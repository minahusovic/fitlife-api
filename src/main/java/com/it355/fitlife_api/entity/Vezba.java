package com.it355.fitlife_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vezbe")
public class Vezba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    private String misicnaGrupa;

    private String opis;

    private Double kalorijePoMinutu;

    public Vezba() {
    }

    public Vezba(String naziv, String misicnaGrupa, String opis, Double kalorijePoMinutu) {
        this.naziv = naziv;
        this.misicnaGrupa = misicnaGrupa;
        this.opis = opis;
        this.kalorijePoMinutu = kalorijePoMinutu;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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