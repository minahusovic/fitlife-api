package com.it355.fitlife_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stavke_treninga")
public class StavkaTreninga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer brojSerija;

    private Integer brojPonavljanja;

    private Double tezinaKg;

    private Integer trajanjeMinuta;

    @ManyToOne
    @JoinColumn(name = "trening_id")
    private Trening trening;

    @ManyToOne
    @JoinColumn(name = "vezba_id")
    private Vezba vezba;

    public StavkaTreninga() {
    }

    public StavkaTreninga(Integer brojSerija, Integer brojPonavljanja, Double tezinaKg,
                          Integer trajanjeMinuta, Trening trening, Vezba vezba) {
        this.brojSerija = brojSerija;
        this.brojPonavljanja = brojPonavljanja;
        this.tezinaKg = tezinaKg;
        this.trajanjeMinuta = trajanjeMinuta;
        this.trening = trening;
        this.vezba = vezba;
    }

    public Long getId() {
        return id;
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

    public Trening getTrening() {
        return trening;
    }

    public Vezba getVezba() {
        return vezba;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public void setVezba(Vezba vezba) {
        this.vezba = vezba;
    }
}