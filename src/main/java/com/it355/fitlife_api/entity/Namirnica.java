package com.it355.fitlife_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "namirnice")
public class Namirnica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String naziv;

    @Column(nullable = false)
    private Double kalorijeNa100g;

    @Column(nullable = false)
    private Double proteiniNa100g;

    private Double ugljeniHidratiNa100g;

    private Double mastiNa100g;

    public Namirnica() {
    }

    public Namirnica(String naziv, Double kalorijeNa100g, Double proteiniNa100g,
                     Double ugljeniHidratiNa100g, Double mastiNa100g) {
        this.naziv = naziv;
        this.kalorijeNa100g = kalorijeNa100g;
        this.proteiniNa100g = proteiniNa100g;
        this.ugljeniHidratiNa100g = ugljeniHidratiNa100g;
        this.mastiNa100g = mastiNa100g;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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