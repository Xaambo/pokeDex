package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private AdaptadorPokemons adaptador;

    private Pokemon[] Pokemons =
            new Pokemon[]{
                    new Pokemon("Bulbasaur", "Espesura", "Planta", "Veneno", "No tiene", "Ivysaur"),
                    new cAmigo("amigo 02", "Apellidos 02", "675998802", "hola02@02.com"),
                    new cAmigo("amigo 03", "Apellidos 03", "675998803", "hola03@03.com"),
                    new cAmigo("amigo 04", "Apellidos 04", "675998804", "hola04@04.com")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
