package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdaptadorPokemons adaptador;

    private Tipo[] Tipos = new Tipo[] {
                           new Tipo("", 0),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Fuego", R.drawable.fuego_tipo),
                           new Tipo("Planta", R.drawable.tipo_planta),
                           new Tipo("Veneno", R.drawable.tipo_veneno)
                           };

    private Pokemon[] Pokemons = new Pokemon[]{
                                 new Pokemon("1", "Bulbasaur", "Espesura", Tipos[3], Tipos[4], R.drawable.ic_bulbasaur, "No tiene", "Ivysaur"),
                                 new Pokemon("2","Ivysaur", "Espesura", Tipos[3], Tipos[4], R.drawable.ic_ivysaur, "Bulbasaur", "Venusaur"),
                                 new Pokemon("3", "Venusaur", "Espesura", Tipos[3], Tipos[4], R.drawable.ic_venusaur, "Ivysaur", "No tiene"),
                                 new Pokemon("4", "Charmander", "Mar llamas", Tipos[2], Tipos[0], R.drawable.ic_charmander, "No tiene", "Charmeleon")
                                 };

    private Pokemon[] PokemonsFiltrats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("PokéDex");

        filtre("Sin filtro");

        adaptador = new AdaptadorPokemons(this, PokemonsFiltrats);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.layout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String filtre = item.getTitle().toString();

        // Respond to the action bar's Up/Home button
        if (item.getItemId() == R.id.ic_Joc) {
            joc();
        } else {
            filtre(filtre);
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean filtre(String filtre) {

        int comptador = 0;

        // Respond to the action bar's Up/Home button
        if (!filtre.equals("Sin filtro")) {

            for (int i = 0; i < Pokemons.length; i++) {
                if (Pokemons[i].getTipo1().getNom().equals(filtre) || Pokemons[i].getTipo2().getNom().equals(filtre)) {
                    comptador++;
                }
            }

            PokemonsFiltrats = new Pokemon[comptador];
            comptador = 0;

            for (int i = 0; i < Pokemons.length; i++) {
                if (Pokemons[i].getTipo1().getNom().equals(filtre) || Pokemons[i].getTipo2().getNom().equals(filtre)) {
                    PokemonsFiltrats[comptador] = Pokemons[i];
                    comptador++;
                }
            }

            adaptador.notifyDataSetChanged();
        } else {
            PokemonsFiltrats = Pokemons;
        }
        return true;
    }

    private void detailPokemon(Pokemon opcioSeleccionada) {
        Intent i = new Intent(this, DetailPokemon.class);

        i.putExtra("pokemon", opcioSeleccionada);

        startActivity(i);
    }

    private void joc() {

    }
}
