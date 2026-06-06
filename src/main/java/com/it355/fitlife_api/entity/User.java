package com.it355.fitlife_api.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private Integer godine;

    private Double visina;

    private Double tezina;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String ime, String prezime, String email, String password, Integer godine, Double visina, Double tezina) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
        this.godine = godine;
        this.visina = visina;
        this.tezina = tezina;
    }

    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getGodine() {
        return godine;
    }

    public Double getVisina() {
        return visina;
    }

    public Double getTezina() {
        return tezina;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGodine(Integer godine) {
        this.godine = godine;
    }

    public void setVisina(Double visina) {
        this.visina = visina;
    }

    public void setTezina(Double tezina) {
        this.tezina = tezina;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}