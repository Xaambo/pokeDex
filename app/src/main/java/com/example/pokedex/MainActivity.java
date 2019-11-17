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

public class MainActivity extends AppCompatActivity {

    private AdaptadorPokemons adaptador;
    private Filtre filtre = new Filtre();

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
                                 new Pokemon("3", "Venusaur", "Espesura", Tipos[3], Tipos[4], R.drawable.ic_venusaur, "Inysaur", "No tiene"),
                                 new Pokemon("4", "Charmander", "Mar llamas", Tipos[2], Tipos[0], R.drawable.ic_charmander, "No tiene", "Charmeleon")
                                 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorPokemons adaptador = new AdaptadorPokemons(this, Pokemons, filtre);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.layout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case R.id.ninguno:
                Toast.makeText(this,"SIN FILTROOOOOOOOO", Toast.LENGTH_LONG).show();
                filtre.setFiltro(item.getTitle().toString());
                return true;
            case R.id.agua:
                Toast.makeText(this,"AGUAAAAAAAAAAAAAAA", Toast.LENGTH_LONG).show();
                filtre.setFiltro(item.getTitle().toString());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void detailPokemon(Pokemon opcioSeleccionada) {
        Intent i = new Intent(this, DetailPokemon.class);

        i.putExtra("pokemon", opcioSeleccionada);

        startActivity(i);
    }
}
