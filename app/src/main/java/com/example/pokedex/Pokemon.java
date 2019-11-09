package com.example.pokedex;

public class Pokemon {

    private String nom;
    private String habilidad;
    private Tipo tipo1;
    private Tipo tipo2;
    private int foto;
    private String anteEvo;
    private String proxEvo;

    public Pokemon (String nom, String habilidad, Tipo tipo1, Tipo tipo2, int foto, String anteEvo, String proxEvo) {

        this.nom = nom;
        this.habilidad = habilidad;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.foto = foto;
        this.anteEvo = anteEvo;
        this.proxEvo = proxEvo;

    }

    public Pokemon (String nom, String habilidad, Tipo tipo1, int foto, String anteEvo, String proxEvo) {

        this.nom = nom;
        this.habilidad = habilidad;
        this.tipo1 = tipo1;
        this.tipo2 = null;
        this.foto = foto;
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

    public Tipo getTipo1() {
        return tipo1;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
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
