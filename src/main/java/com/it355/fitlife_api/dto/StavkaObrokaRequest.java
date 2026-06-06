package com.it355.fitlife_api.dto;

public class StavkaObrokaRequest {

    private Long namirnicaId;
    private Double kolicinaGrama;

    public StavkaObrokaRequest() {
    }

    public Long getNamirnicaId() {
        return namirnicaId;
    }

    public Double getKolicinaGrama() {
        return kolicinaGrama;
    }

    public void setNamirnicaId(Long namirnicaId) {
        this.namirnicaId = namirnicaId;
    }

    public void setKolicinaGrama(Double kolicinaGrama) {
        this.kolicinaGrama = kolicinaGrama;
    }
}