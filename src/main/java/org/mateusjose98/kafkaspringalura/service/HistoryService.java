package org.mateusjose98.kafkaspringalura.service;

import org.mateusjose98.kafkaspringalura.controller.PixResponse;
import org.mateusjose98.kafkaspringalura.entity.Pix;
import org.mateusjose98.kafkaspringalura.repository.PixRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Profile("consumer")
public class HistoryService {
    final PixRepository pixRepository;
    public HistoryService(PixRepository pixRepository) {
        this.pixRepository = pixRepository;
    }


    public Map<String, Object> listAll() {
        List<Pix> pixList = pixRepository.findAll();
        return Map.of(
                "size", pixList.size(),
                "data", pixList
        );
    }

}
