package com.example.pokedex;

import android.graphics.Color;
import android.os.Bundle;
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

        Pokemon pokemon = pokemons.get(random);

        ImageView ivPokemon = findViewById(R.id.ivGPokemon);
        ivPokemon.setImageResource(pokemon.getFoto());
        ivPokemon.setColorFilter(ContextCompat.getColor(this, R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);

    }
}
