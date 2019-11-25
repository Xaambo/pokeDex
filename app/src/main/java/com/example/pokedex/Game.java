package com.example.pokedex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class Game extends AppCompatActivity {

    int contador = 0;
    int max = 0;
    String nom;
    ImageView ivPokemon;
    TextView tvGPuntuacio;
    TextView tvGMaxPuntuacio;
    Button btnOpcio1;
    Button btnOpcio2;
    Button btnOpcio3;
    Button btnOpcio4;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_game);

        setTitle("PokéGame");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<Pokemon> pokemons = (ArrayList<Pokemon>) getIntent().getSerializableExtra("pokemons");

        final ArrayList<Button> opcions = new ArrayList<>();

        preferences = getSharedPreferences("PuntuacionMax", Context.MODE_PRIVATE);
        editor = preferences.edit();

        btnOpcio1 = findViewById(R.id.btnOpcio1);
        btnOpcio2 = findViewById(R.id.btnOpcio2);
        btnOpcio3 = findViewById(R.id.btnOpcio3);
        btnOpcio4 = findViewById(R.id.btnOpcio4);

        setJoc(pokemons, opcions);

        tvGMaxPuntuacio.setText("Max: " + preferences.getInt("Max", 0));

        btnOpcio1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String opcio = btnOpcio1.getText().toString();
                boolean victoria = false;

                victoria = comparar(nom, opcio, victoria);

                if (victoria) {
                    esVictoria();
                    setJoc(pokemons, opcions);
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    setMax();
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
                    esVictoria();
                    setJoc(pokemons, opcions);
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    setMax();
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
                    esVictoria();
                    setJoc(pokemons, opcions);
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    setMax();
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
                    esVictoria();
                    setJoc(pokemons, opcions);
                } else {
                    tvGPuntuacio.setText("GAME OVER");
                    setMax();
                    finish();
                }
            }
        });
    }

    private void setJoc(ArrayList<Pokemon> pokemons, ArrayList<Button> opcions) {

        int random = (int) (Math.random() * (pokemons.size()));
        int foto;

        opcions.clear();

        opcions.add(btnOpcio1);
        opcions.add(btnOpcio2);
        opcions.add(btnOpcio3);
        opcions.add(btnOpcio4);

        Pokemon pokemon = pokemons.get(random);
        Pokemon pokemonFalso;

        nom = pokemon.getNom();
        foto = pokemon.getFoto();

        ivPokemon = findViewById(R.id.ivGPokemon);
        ivPokemon.setImageResource(foto);
        ivPokemon.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

        tvGPuntuacio = findViewById(R.id.tvGPuntuacio);
        tvGMaxPuntuacio = findViewById(R.id.tvGMax);

        random = (int) (Math.random() * opcions.size());

        opcions.get(random).setText(nom);

        opcions.remove(random);

        for (int i = 0; i < opcions.size(); i++) {
            random = (int) (Math.random() * (pokemons.size()));
            pokemonFalso = pokemons.get(random);

            if (!nom.equals(pokemonFalso.getNom())) {
                opcions.get(i).setText(pokemons.get(random).getNom());
            }
        }
    }

    private void esVictoria() {
        ivPokemon.setColorFilter(null);
        contador++;
        tvGPuntuacio.setText("Puntuación: " + String.valueOf(contador));
    }

    private void setMax() {
        if (contador > max) {
            max = contador;
            editor.putInt("Max", max);
            editor.apply();
        }
    }

    private boolean comparar(String nom, String opcio, boolean victoria) {

        if (nom.equals(opcio)) {
            victoria = true;
        }

        return victoria;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
