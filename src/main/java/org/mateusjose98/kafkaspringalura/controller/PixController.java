package org.mateusjose98.kafkaspringalura.controller;


import org.mateusjose98.kafkaspringalura.entity.PixStatus;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/pix")
@Profile("producer")
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


}
