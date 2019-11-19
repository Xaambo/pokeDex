package com.example.pokedex;

import java.io.Serializable;

public class Pokemon implements Serializable {

    private String id;
    private String nom;
    private Tipo tipo1;
    private Tipo tipo2;
    private int foto;
    private String anteEvo;
    private String proxEvo;

    public Pokemon (String id, String nom, Tipo tipo1, Tipo tipo2, int foto, String anteEvo, String proxEvo) {

        this.id = id;
        this.nom = nom;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.foto = foto;
        this.anteEvo = anteEvo;
        this.proxEvo = proxEvo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
