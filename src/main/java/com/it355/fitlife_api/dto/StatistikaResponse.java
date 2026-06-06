package com.it355.fitlife_api.dto;

import java.time.LocalDate;

public class StatistikaResponse {

    private Long userId;
    private LocalDate datum;
    private Double ukupneKalorije;
    private Double ukupniProteini;
    private Double potroseneKalorije;
    private Double netoKalorije;

    public StatistikaResponse() {
    }

    public StatistikaResponse(Long userId, LocalDate datum, Double ukupneKalorije,
                              Double ukupniProteini, Double potroseneKalorije, Double netoKalorije) {
        this.userId = userId;
        this.datum = datum;
        this.ukupneKalorije = ukupneKalorije;
        this.ukupniProteini = ukupniProteini;
        this.potroseneKalorije = potroseneKalorije;
        this.netoKalorije = netoKalorije;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public Double getUkupneKalorije() {
        return ukupneKalorije;
    }

    public Double getUkupniProteini() {
        return ukupniProteini;
    }

    public Double getPotroseneKalorije() {
        return potroseneKalorije;
    }

    public Double getNetoKalorije() {
        return netoKalorije;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public void setUkupneKalorije(Double ukupneKalorije) {
        this.ukupneKalorije = ukupneKalorije;
    }

    public void setUkupniProteini(Double ukupniProteini) {
        this.ukupniProteini = ukupniProteini;
    }

    public void setPotroseneKalorije(Double potroseneKalorije) {
        this.potroseneKalorije = potroseneKalorije;
    }

    public void setNetoKalorije(Double netoKalorije) {
        this.netoKalorije = netoKalorije;
    }
}