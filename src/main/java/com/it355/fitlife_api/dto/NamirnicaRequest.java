package com.it355.fitlife_api.dto;

public class NamirnicaRequest {

    private String naziv;
    private Double kalorijeNa100g;
    private Double proteiniNa100g;
    private Double ugljeniHidratiNa100g;
    private Double mastiNa100g;

    public NamirnicaRequest() {
    }

    public String getNaziv() {
        return naziv;
    }

    public Double getKalorijeNa100g() {
        return kalorijeNa100g;
    }

    public Double getProteiniNa100g() {
        return proteiniNa100g;
    }

    public Double getUgljeniHidratiNa100g() {
        return ugljeniHidratiNa100g;
    }

    public Double getMastiNa100g() {
        return mastiNa100g;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKalorijeNa100g(Double kalorijeNa100g) {
        this.kalorijeNa100g = kalorijeNa100g;
    }

    public void setProteiniNa100g(Double proteiniNa100g) {
        this.proteiniNa100g = proteiniNa100g;
    }

    public void setUgljeniHidratiNa100g(Double ugljeniHidratiNa100g) {
        this.ugljeniHidratiNa100g = ugljeniHidratiNa100g;
    }

    public void setMastiNa100g(Double mastiNa100g) {
        this.mastiNa100g = mastiNa100g;
    }
}