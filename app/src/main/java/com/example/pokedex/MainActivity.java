package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private AdaptadorPokemons adaptador;

    private Pokemon[] Pokemons = new Pokemon[]{
                                 new Pokemon("Bulbasaur", "Espesura", "Planta", "Veneno", "No tiene", "Ivysaur"),
                                 new Pokemon("Inysaur", "Espesura", "Planta", "Veneno", "Bulbasaur", "Venusaur"),
                                 new Pokemon("Venusaur", "Espesura", "Planta", "Veneno", "Inysaur", "No tiene"),
                                 new Pokemon("Charmander", "Mar llamas", "Fuego", "No tiene", "No tiene", "Charmeleon")
                                 };

    private int[] imgs = new int[] {
                         R.drawable.ic_bulbasaur,
                         R.drawable.ic_ivysaur,
                         R.drawable.ic_venusaur,
                         R.drawable.ic_charmander
                         };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorPokemons adaptador = new AdaptadorPokemons(this, Pokemons);

        // Assignem al listview l'adaptador creat
        ListView lst = (ListView)findViewById(R.id.lvPokemon);
        lst.setAdapter(adaptador);
    }
}
