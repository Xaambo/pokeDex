package com.example.pokedex;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detailpokemon);

        Bundle extras = getIntent().getExtras();
        Pokemon pokemon = (Pokemon) extras.getSerializable("pokemon");

        setTitle(pokemon.getNom());

    }
}
