package org.mateusjose98.kafkaspringalura.controller;

import org.mateusjose98.kafkaspringalura.controller.PixRequest;
import org.mateusjose98.kafkaspringalura.controller.PixResponse;
import org.mateusjose98.kafkaspringalura.entity.Pix;
import org.mateusjose98.kafkaspringalura.repository.PixRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("producer")
public class PixService {

    private final PixRepository pixRepository;
    private final KafkaTemplate<String, PixRequest> kafkaTemplate;
    public PixService(PixRepository pixRepository, KafkaTemplate<String, PixRequest> kafkaTemplate) {
        this.pixRepository = pixRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public PixResponse salvar(PixRequest pixRequest) {
        Pix saved = pixRepository.save(pixRequest.toEntity());
        System.out.println(saved.getIdentifier() + " Sending message to kafka");
        kafkaTemplate.send("pix-topic", saved.getIdentifier(), pixRequest);
        return new PixResponse(saved.getIdentifier(), saved.getChaveOrigem(), saved.getChaveDestino(), saved.getValor(), saved.getStatus());

    }

}
