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
        /*String habilitat = extras.getString("habilitat");
        String tipo1 = extras.getString("tipo1");
        String tipo2 = extras.getString("tipo2");
        int foto = extras.getInt("foto");
        String anteEvo = extras.getString("anteEvo");
        String proxEvo = extras.getString("proxEvo");*/

        setTitle(pokemon.getNom());

    }
}
