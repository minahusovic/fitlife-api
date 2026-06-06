package com.it355.fitlife_api.dto;

public class RegisterRequest {

    private String ime;
    private String prezime;
    private String email;
    private String password;
    private Integer godine;
    private Double visina;
    private Double tezina;

    public RegisterRequest() {
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
}