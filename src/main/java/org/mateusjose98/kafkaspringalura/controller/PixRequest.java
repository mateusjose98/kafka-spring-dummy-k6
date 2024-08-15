package org.mateusjose98.kafkaspringalura.controller;

import org.mateusjose98.kafkaspringalura.entity.PixStatus;
import org.mateusjose98.kafkaspringalura.entity.Pix;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PixRequest {
    String identifier;
    String chaveOrigem;
    String chaveDestino;
    String valor;
    LocalDateTime dataTransferencia;
    PixStatus status;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getChaveOrigem() {
        return chaveOrigem;
    }

    public void setChaveOrigem(String chaveOrigem) {
        this.chaveOrigem = chaveOrigem;
    }

    public String getChaveDestino() {
        return chaveDestino;
    }

    public void setChaveDestino(String chaveDestino) {
        this.chaveDestino = chaveDestino;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDateTime dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public PixStatus getStatus() {
        return status;
    }

    public void setStatus(PixStatus status) {
        this.status = status;
    }

    public Pix toEntity() {
        var result = new Pix();
        result.setIdentifier(this.identifier);
        result.setChaveOrigem(this.chaveOrigem);
        result.setChaveDestino(this.chaveDestino);
        result.setValor(new BigDecimal(this.valor));
        result.setDataTransferencia(this.dataTransferencia);
        result.setStatus(this.status);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PixRequest{");
        sb.append("identifier='").append(identifier).append('\'');
        sb.append(", chaveOrigem='").append(chaveOrigem).append('\'');
        sb.append(", chaveDestino='").append(chaveDestino).append('\'');
        sb.append(", valor='").append(valor).append('\'');
        sb.append(", dataTransferencia=").append(dataTransferencia);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
