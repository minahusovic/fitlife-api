package com.it355.fitlife_api.dto;

public class StavkaTreningaRequest {

    private Long vezbaId;
    private Integer brojSerija;
    private Integer brojPonavljanja;
    private Double tezinaKg;
    private Integer trajanjeMinuta;

    public StavkaTreningaRequest() {
    }

    public Long getVezbaId() {
        return vezbaId;
    }

    public Integer getBrojSerija() {
        return brojSerija;
    }

    public Integer getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public Double getTezinaKg() {
        return tezinaKg;
    }

    public Integer getTrajanjeMinuta() {
        return trajanjeMinuta;
    }

    public void setVezbaId(Long vezbaId) {
        this.vezbaId = vezbaId;
    }

    public void setBrojSerija(Integer brojSerija) {
        this.brojSerija = brojSerija;
    }

    public void setBrojPonavljanja(Integer brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    public void setTezinaKg(Double tezinaKg) {
        this.tezinaKg = tezinaKg;
    }

    public void setTrajanjeMinuta(Integer trajanjeMinuta) {
        this.trajanjeMinuta = trajanjeMinuta;
    }
}