package com.example.pokedex;

import java.io.Serializable;

public class Tipo implements Serializable {

    private int id;
    private String nom;
    private int foto;

    public Tipo(int id, String nom, int foto) {
        this.id = id;
        this.nom = nom;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
