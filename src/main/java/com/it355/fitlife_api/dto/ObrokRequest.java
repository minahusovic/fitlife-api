package com.it355.fitlife_api.dto;

import java.time.LocalDate;

public class ObrokRequest {

    private String naziv;
    private LocalDate datum;
    private String tipObroka;
    private Long userId;

    public ObrokRequest() {
    }

    public String getNaziv() {
        return naziv;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getTipObroka() {
        return tipObroka;
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

    public void setTipObroka(String tipObroka) {
        this.tipObroka = tipObroka;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}