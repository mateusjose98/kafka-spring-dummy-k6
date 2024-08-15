package org.mateusjose98.kafkaspringalura.controller;

import org.mateusjose98.kafkaspringalura.service.PixService;
import org.mateusjose98.kafkaspringalura.entity.PixStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pix")
public class PixController {

    private final PixService pixService;

    public PixController(PixService pixService) {
        this.pixService = pixService;
    }

    @PostMapping
    public ResponseEntity<PixResponse> createPix(@RequestBody PixRequest pixRequest) {
        pixRequest.setDataTransferencia(LocalDateTime.now());
        pixRequest.setStatus(PixStatus.EM_PROCESSAMENTO);
        pixRequest.setIdentifier(UUID.randomUUID().toString());
        PixResponse response = pixService.salvar(pixRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<PixResponse>> listAll(Pageable pg) {
        Page<PixResponse> pixResponses = pixService.listAll(pg);
        return new ResponseEntity<>(pixResponses, HttpStatus.OK);
    }
}
