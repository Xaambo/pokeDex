package com.example.pokedex;

public class Pokemon {

    private String nom;
    private String habilidad;
    private String tipo1;
    private String tipo2;
    private String anteEvo;
    private String proxEvo;

    public Pokemon (String nom, String habilidad, String tipo1, String tipo2, String anteEvo, String proxEvo) {

        this.nom = nom;
        this.habilidad = habilidad;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.anteEvo = anteEvo;
        this.proxEvo = proxEvo;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getAnteEvo() {
        return anteEvo;
    }

    public void setAnteEvo(String anteEvo) {
        this.anteEvo = anteEvo;
    }

    public String getProxEvo() {
        return proxEvo;
    }

    public void setProxEvo(String proxEvo) {
        this.proxEvo = proxEvo;
    }
}
