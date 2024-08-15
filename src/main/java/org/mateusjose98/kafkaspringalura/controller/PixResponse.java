package org.mateusjose98.kafkaspringalura.controller;

import org.mateusjose98.kafkaspringalura.entity.Pix;
import org.mateusjose98.kafkaspringalura.entity.PixStatus;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

public record PixResponse(String identifier, String chaveOrigem, String chaveDestino, BigDecimal valor, PixStatus status) {
    public static Page<PixResponse> fromEntityList(Page<Pix> pixList) {
        return pixList.map(pix -> new PixResponse(pix.getIdentifier(), pix.getChaveOrigem(), pix.getChaveDestino(), pix.getValor(), pix.getStatus()));
    }
}
