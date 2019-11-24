package com.example.pokedex;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_game);

        final ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) getIntent().getSerializableExtra("pokemons");

        ArrayList<Button> opcions = new ArrayList<>();

        final Button btnOpcio1 = findViewById(R.id.btnOpcio1);
        final Button btnOpcio2 = findViewById(R.id.btnOpcio2);
        final Button btnOpcio3 = findViewById(R.id.btnOpcio3);
        final Button btnOpcio4 = findViewById(R.id.btnOpcio4);

        opcions.add(btnOpcio1);
        opcions.add(btnOpcio2);
        opcions.add(btnOpcio3);
        opcions.add(btnOpcio4);

        int random = (int) (Math.random() * (pokemons.size()));
        int foto;
        final String nom;

        Pokemon pokemon = pokemons.get(random);
        Pokemon pokemonFalso;

        nom = pokemon.getNom();
        foto = pokemon.getFoto();

        final ImageView ivPokemon = findViewById(R.id.ivGPokemon);
        ivPokemon.setImageResource(foto);
        ivPokemon.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

        final TextView tvGPuntuacio = findViewById(R.id.tvGPuntuacio);

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
                String opcio = btnOpcio1.getText().toString();
                boolean victoria = false;

                victoria = comparar(nom, opcio, victoria);

                if (victoria) {
                    ivPokemon.setColorFilter(null);
                    contador++;
                    tvGPuntuacio.setText("Puntuación: " + String.valueOf(contador));
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    finish();
                }
            }
        });

        btnOpcio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opcio = btnOpcio2.getText().toString();
                boolean victoria = false;

                victoria = comparar(nom, opcio, victoria);

                if (victoria) {
                    ivPokemon.setColorFilter(null);
                    contador++;
                    tvGPuntuacio.setText("Puntuación: " + String.valueOf(contador));
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    finish();
                }
            }
        });

        btnOpcio3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opcio = btnOpcio3.getText().toString();
                boolean victoria = false;

                victoria = comparar(nom, opcio, victoria);

                if (victoria) {
                    ivPokemon.setColorFilter(null);
                    contador++;
                    tvGPuntuacio.setText("Puntuación: " + String.valueOf(contador));
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    finish();
                }
            }
        });

        btnOpcio4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opcio = btnOpcio4.getText().toString();
                boolean victoria = false;

                victoria = comparar(nom, opcio, victoria);

                if (victoria) {
                    ivPokemon.setColorFilter(null);
                    contador++;
                    tvGPuntuacio.setText("Puntuación: " + String.valueOf(contador));
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    finish();
                }
            }
        });
    }

    private void setJoc() {

    }

    private boolean comparar(String nom, String opcio, boolean victoria) {

        if (nom.equals(opcio)) {
            victoria = true;
        }

        return victoria;
    }
}
