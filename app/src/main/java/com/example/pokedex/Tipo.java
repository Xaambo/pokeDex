package com.example.pokedex;

import java.io.Serializable;

public class Tipo implements Serializable {

    private String nom;
    private int foto;

    public Tipo(String nom, int foto) {
        this.nom = nom;
        this.foto = foto;
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
