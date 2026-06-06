package com.it355.fitlife_api.dto;

public class VezbaRequest {

    private String naziv;
    private String misicnaGrupa;
    private String opis;
    private Double kalorijePoMinutu;

    public VezbaRequest() {
    }

    public String getNaziv() {
        return naziv;
    }

    public String getMisicnaGrupa() {
        return misicnaGrupa;
    }

    public String getOpis() {
        return opis;
    }

    public Double getKalorijePoMinutu() {
        return kalorijePoMinutu;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setMisicnaGrupa(String misicnaGrupa) {
        this.misicnaGrupa = misicnaGrupa;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setKalorijePoMinutu(Double kalorijePoMinutu) {
        this.kalorijePoMinutu = kalorijePoMinutu;
    }
}