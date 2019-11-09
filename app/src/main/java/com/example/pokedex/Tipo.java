package com.example.pokedex;

public class Tipo {

    private String nom;
    private int foto;

    public void Tipo(int foto) {

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
