package com.it355.fitlife_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "obroci")
public class Obrok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private LocalDate datum;

    private String tipObroka;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "obrok", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StavkaObroka> stavke = new ArrayList<>();

    public Obrok() {
    }

    public Obrok(String naziv, LocalDate datum, String tipObroka, User user) {
        this.naziv = naziv;
        this.datum = datum;
        this.tipObroka = tipObroka;
        this.user = user;
    }

    public Long getId() {
        return id;
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

    public User getUser() {
        return user;
    }

    public List<StavkaObroka> getStavke() {
        return stavke;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setStavke(List<StavkaObroka> stavke) {
        this.stavke = stavke;
    }
}