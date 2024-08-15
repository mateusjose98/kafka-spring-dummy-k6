package org.mateusjose98.kafkaspringalura.service;

import org.mateusjose98.kafkaspringalura.controller.PixRequest;
import org.mateusjose98.kafkaspringalura.controller.PixResponse;
import org.mateusjose98.kafkaspringalura.entity.Pix;
import org.mateusjose98.kafkaspringalura.repository.PixRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PixService {

    private final PixRepository pixRepository;
    private final KafkaTemplate<String, PixRequest> kafkaTemplate;
    public PixService(PixRepository pixRepository, KafkaTemplate<String, PixRequest> kafkaTemplate) {
        this.pixRepository = pixRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public PixResponse salvar(PixRequest pixRequest) {
        System.out.println("Salvando pix: " + pixRequest);
        Pix saved = pixRepository.save(pixRequest.toEntity());
        kafkaTemplate.send("pix-topic", saved.getIdentifier(), pixRequest);
        return new PixResponse(saved.getIdentifier(), saved.getChaveOrigem(), saved.getChaveDestino(), saved.getValor(), saved.getStatus());

    }

    public Page<PixResponse> listAll(Pageable pageable) {
        Page<Pix> pixList = pixRepository.findAll(pageable);
        return PixResponse.fromEntityList(pixList);
    }
}
