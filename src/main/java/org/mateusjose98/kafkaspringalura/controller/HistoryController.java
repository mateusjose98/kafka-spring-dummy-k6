package org.mateusjose98.kafkaspringalura.controller;

import org.mateusjose98.kafkaspringalura.service.HistoryService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Profile("consumer")
@RequestMapping("/history")
public class HistoryController {

    final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }
    @GetMapping
    public ResponseEntity<Map<String, Object>> listAll() {
        var pixResponses = historyService.listAll();
        return new ResponseEntity<>(pixResponses, HttpStatus.OK);
    }
}
