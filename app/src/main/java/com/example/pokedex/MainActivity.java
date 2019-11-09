package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdaptadorPokemons adaptador;



    private Pokemon[] Pokemons = new Pokemon[]{
                                 new Pokemon("Bulbasaur", "Espesura", "Planta", "Veneno", R.drawable.ic_bulbasaur, "No tiene", "Ivysaur"),
                                 new Pokemon("Inysaur", "Espesura", "Planta", "Veneno", R.drawable.ic_ivysaur, "Bulbasaur", "Venusaur"),
                                 new Pokemon("Venusaur", "Espesura", "Planta", "Veneno", R.drawable.ic_venusaur, "Inysaur", "No tiene"),
                                 new Pokemon("Charmander", "Mar llamas", "Fuego", R.drawable.ic_charmander, "No tiene", "Charmeleon")
                                 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorPokemons adaptador = new AdaptadorPokemons(this, Pokemons);

        setTitle("PokéDex");

        // Assignem al listview l'adaptador creat
        ListView lst = findViewById(R.id.lvPokemon);
        lst.setAdapter(adaptador);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                // Agafem l'objecte associat, en aquest cas l'objecte es un STRING
                Pokemon opcionSeleccionada = (Pokemon) a.getItemAtPosition(position);

                // Fel que toqui en aquest cast fer un Toast cutre.
                detailPokemon(opcionSeleccionada);

            }
        });
    }

    private void detailPokemon(Pokemon opcioSeleccionada) {
        Intent i = new Intent(this, DetailPokemon.class);

        String tipo2;

        i.putExtra("nom", opcioSeleccionada.getNom());
        i.putExtra("habilitat", opcioSeleccionada.getHabilidad());
        i.putExtra("tipo1", opcioSeleccionada.getTipo1());

        tipo2 = opcioSeleccionada.getTipo2();

        if (tipo2 != null) {

            i.putExtra("tipo2", tipo2);

        } else {

            i.putExtra("tipo2", "");

        }

        i.putExtra("foto", opcioSeleccionada.getFoto());
        i.putExtra("anteEvo", opcioSeleccionada.getAnteEvo());
        i.putExtra("proxEvo", opcioSeleccionada.getProxEvo());

        startActivity(i);
    }
}
