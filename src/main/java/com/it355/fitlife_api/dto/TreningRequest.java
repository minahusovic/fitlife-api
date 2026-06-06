package com.it355.fitlife_api.dto;

import java.time.LocalDate;

public class TreningRequest {

    private String naziv;
    private LocalDate datum;
    private String tipTreninga;
    private Integer trajanjeMinuta;
    private Double potroseneKalorije;
    private String napomena;
    private Long userId;

    public TreningRequest() {
    }

    public String getNaziv() {
        return naziv;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public Integer getTrajanjeMinuta() {
        return trajanjeMinuta;
    }

    public Double getPotroseneKalorije() {
        return potroseneKalorije;
    }

    public String getNapomena() {
        return napomena;
    }

    public Long getUserId() {
        return userId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public void setTrajanjeMinuta(Integer trajanjeMinuta) {
        this.trajanjeMinuta = trajanjeMinuta;
    }

    public void setPotroseneKalorije(Double potroseneKalorije) {
        this.potroseneKalorije = potroseneKalorije;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}