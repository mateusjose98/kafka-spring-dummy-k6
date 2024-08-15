package org.mateusjose98.kafkaspringalura.service;

import org.mateusjose98.kafkaspringalura.entity.PixStatus;
import org.mateusjose98.kafkaspringalura.controller.PixRequest;
import org.mateusjose98.kafkaspringalura.entity.Key;
import org.mateusjose98.kafkaspringalura.entity.Pix;
import org.mateusjose98.kafkaspringalura.repository.KeyRepository;
import org.mateusjose98.kafkaspringalura.repository.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Profile("consumer")
public class PixValidator {

    @Autowired
    private KeyRepository keyRepository;

    @Autowired
    private PixRepository pixRepository;

    @KafkaListener(topics = "pix-topic", groupId = "grupo")
    public void processaPix(PixRequest request) {
        System.out.println("Recebido! : " + request.getIdentifier());

        Pix pix = pixRepository.findByIdentifier(request.getIdentifier());
        Key origem = keyRepository.findByChave(request.getChaveOrigem());
        Key destino = keyRepository.findByChave(request.getChaveDestino());

        if (origem != null && destino != null) {
            pix.setStatus(PixStatus.PROCESSADO);
        } else {
            pix.setStatus(PixStatus.ERRO);
        }
        pixRepository.save(pix);
    }

}
