package com.it355.fitlife_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "treninzi")
public class Trening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;

    private LocalDate datum;

    private String tipTreninga;

    private Integer trajanjeMinuta;

    private Double potroseneKalorije;

    private String napomena;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

   @JsonIgnore
    @OneToMany(mappedBy = "trening", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StavkaTreninga> stavke = new ArrayList<>();

    public Trening() {
    }

    public Trening(String naziv, LocalDate datum, String tipTreninga, Integer trajanjeMinuta,
                   Double potroseneKalorije, String napomena, User user) {
        this.naziv = naziv;
        this.datum = datum;
        this.tipTreninga = tipTreninga;
        this.trajanjeMinuta = trajanjeMinuta;
        this.potroseneKalorije = potroseneKalorije;
        this.napomena = napomena;
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

    public User getUser() {
        return user;
    }

    public List<StavkaTreninga> getStavke() {
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

    public void setUser(User user) {
        this.user = user;
    }

    public void setStavke(List<StavkaTreninga> stavke) {
        this.stavke = stavke;
    }
}