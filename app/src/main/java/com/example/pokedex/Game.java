package com.example.pokedex;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_game);

        final ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) getIntent().getSerializableExtra("pokemons");

        int random = (int) (Math.random() * (pokemons.size()));
        int foto;
        String nom;

        ArrayList<Button> opcions = new ArrayList<>();

        Button btnOpcio1 = findViewById(R.id.btnOpcio1);
        Button btnOpcio2 = findViewById(R.id.btnOpcio2);
        Button btnOpcio3 = findViewById(R.id.btnOpcio3);
        Button btnOpcio4 = findViewById(R.id.btnOpcio4);

        opcions.add(btnOpcio1);
        opcions.add(btnOpcio2);
        opcions.add(btnOpcio3);
        opcions.add(btnOpcio4);

        Pokemon pokemon = pokemons.get(random);
        Pokemon pokemonFalso;

        nom = pokemon.getNom();
        foto = pokemon.getFoto();

        ImageView ivPokemon = findViewById(R.id.ivGPokemon);
        ivPokemon.setImageResource(foto);
        ivPokemon.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

        random = (int) (Math.random() * opcions.size());

        opcions.get(random).setText(nom);

        opcions.remove(random);

        for (int i = 0; i < opcions.size(); i++) {
            random = (int) (Math.random() * (pokemons.size()));
            pokemonFalso = pokemons.get(random);

            if (foto != pokemonFalso.getFoto()) {
                opcions.get(i).setText(pokemons.get(random).getNom());
            }
        }

        btnOpcio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnOpcio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnOpcio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnOpcio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
