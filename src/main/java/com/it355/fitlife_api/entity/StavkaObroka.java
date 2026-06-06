package com.it355.fitlife_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stavke_obroka")
public class StavkaObroka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double kolicinaGrama;

    @ManyToOne
    @JoinColumn(name = "obrok_id")
    private Obrok obrok;

    @ManyToOne
    @JoinColumn(name = "namirnica_id")
    private Namirnica namirnica;

    public StavkaObroka() {
    }

    public StavkaObroka(Double kolicinaGrama, Obrok obrok, Namirnica namirnica) {
        this.kolicinaGrama = kolicinaGrama;
        this.obrok = obrok;
        this.namirnica = namirnica;
    }

    public Long getId() {
        return id;
    }

    public Double getKolicinaGrama() {
        return kolicinaGrama;
    }

    public Obrok getObrok() {
        return obrok;
    }

    public Namirnica getNamirnica() {
        return namirnica;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKolicinaGrama(Double kolicinaGrama) {
        this.kolicinaGrama = kolicinaGrama;
    }

    public void setObrok(Obrok obrok) {
        this.obrok = obrok;
    }

    public void setNamirnica(Namirnica namirnica) {
        this.namirnica = namirnica;
    }
}