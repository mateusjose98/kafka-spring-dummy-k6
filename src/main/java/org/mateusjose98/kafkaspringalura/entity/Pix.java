package org.mateusjose98.kafkaspringalura.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pix {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identifier;
    private String chaveOrigem;
    private String chaveDestino;
    private BigDecimal valor;
    private LocalDateTime dataTransferencia;
    @Enumerated(EnumType.STRING)
    private PixStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
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
}
