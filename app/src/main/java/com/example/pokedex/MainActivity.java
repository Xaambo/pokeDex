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
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private AdaptadorPokemons adaptador;

    private Tipo[] Tipos = new Tipo[] {
                           new Tipo("", 0),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Bicho", R.drawable.tipo_agua),
                           new Tipo("Dragón", R.drawable.tipo_agua),
                           new Tipo("Eléctrico", R.drawable.tipo_agua),
                           new Tipo("Fantasma", R.drawable.tipo_agua),
                           new Tipo("Fuego", R.drawable.fuego_tipo),
                           new Tipo("Hielo", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Fuego", R.drawable.fuego_tipo),
                           new Tipo("Planta", R.drawable.tipo_planta),
                           new Tipo("Veneno", R.drawable.tipo_veneno)
                           };

    private Pokemon[] Pokemons = new Pokemon[]{
                                 new Pokemon("1", "Bulbasaur", Tipos[3], Tipos[4], R.drawable.ic_bulbasaur, "No tiene", "Ivysaur"),
                                 new Pokemon("2", "Ivysaur", Tipos[3], Tipos[4], R.drawable.ic_ivysaur, "Bulbasaur", "Venusaur"),
                                 new Pokemon("3", "Venusaur", Tipos[3], Tipos[4], R.drawable.ic_venusaur, "Ivysaur", "No tiene"),
                                 new Pokemon("4", "Charmander", Tipos[2], Tipos[0], R.drawable.ic_charmander, "No tiene", "Charmeleon"),
                                 new Pokemon("5", "Charmeleon", Tipos[2], Tipos[0], R.drawable.ic_charmander, "Charmander", "Charizard"),
                                 new Pokemon("6", "Charizard", "@drawable/charizard", "@drawable/fuego", "@drawable/volador"),
                                 new Pokemon("7", "Squirtle", "@drawable/squirtle", "@drawable/agua", ""),
                                 new Pokemon("8", "Wartortle", "@drawable/wartortle", "@drawable/agua", ""),
                                 new Pokemon("9", "Blastoise", "@drawable/blastoise", "@drawable/agua", ""),
                                 new Pokemon("#10", "Caterpie", "@drawable/caterpie", "@drawable/bicho", ""),
                                 new Pokemon("#11", "Metapod", "@drawable/metapod", "@drawable/bicho", ""),
                                 new Pokemon("#12", "Butterfree", "@drawable/butterfree", "@drawable/bicho", "@drawable/volador"),
                                 new Pokemon("#13", "Weedle", "@drawable/weedle", "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#14", "Kakuna", "@drawable/kakuna", "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#15", "Beedrill", "@drawable/beedrill", "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#16", "Pidgey", "@drawable/pidgey", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#17", "Pidgeotto", "@drawable/pidgeotto", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#18", "Pidgeot", "@drawable/pidgeot", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#19", "Rattata", "@drawable/rattata", "@drawable/normal", ""),
                                 new Pokemon("#20", "Raticate", "@drawable/raticate", "@drawable/normal", ""),
                                 new Pokemon("#21", "Spearow", "@drawable/spearow", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#22", "Fearow", "@drawable/fearow", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#23", "Ekans", "@drawable/ekans", "@drawable/veneno", ""),
                                 new Pokemon("#24", "Arbok", "@drawable/arbok", "@drawable/veneno", ""),
                                 new Pokemon("#25", "Pikachu", "@drawable/pikachu", "@drawable/electrico", ""),
                                 new Pokemon("#26", "Raichu", "@drawable/raichu", "@drawable/electrico", ""),
                                 new Pokemon("#27", "Sandshrew", "@drawable/sandshrew", "@drawable/tierra", ""),
                                 new Pokemon("#28", "Sandslash", "@drawable/sandslash", "@drawable/tierra", ""),
                                 new Pokemon("#29", "Nidoran ♀", "@drawable/nidoranh", "@drawable/veneno", ""),
                                 new Pokemon("#30", "Nidorina", "@drawable/nidorina", "@drawable/veneno", ""),
                                 new Pokemon("#31", "Nidoqueen", "@drawable/nidoqueen", "@drawable/veneno", "@drawable/tierra"),
                                 new Pokemon("#32", "Nidoran ♂", "@drawable/nidoranm", "@drawable/veneno", ""),
                                 new Pokemon("#33", "Nidorino", "@drawable/nidorino", "@drawable/veneno", ""),
                                 new Pokemon("#34", "Nidoking", "@drawable/nidoking", "@drawable/veneno", "@drawable/tierra"),
                                 new Pokemon("#35", "Clefairy", "@drawable/clefairy", "@drawable/normal", ""),
                                 new Pokemon("#36", "Clefable", "@drawable/clefable", "@drawable/normal", ""),
                                 new Pokemon("#37", "Vulpix", "@drawable/vulpix", "@drawable/fuego", ""),
                                 new Pokemon("#38", "@drawable/ninetales", "Ninetales", "@drawable/fuego", ""),
                                 new Pokemon("#39", "Jigglypuff", "@drawable/jigglypuff", "@drawable/normal", "@drawable/hada"),
                                 new Pokemon("#40", "Wigglytuff", "@drawable/wigglytuff", "@drawable/normal", "@drawable/hada"),
                                 new Pokemon("#41", "Zubat", "@drawable/zubat", "@drawable/veneno", "@drawable/volador"),
                                 new Pokemon("#42", "Golbat", "@drawable/golbat", "@drawable/veneno", "@drawable/volador"),
                                 new Pokemon("#43", "Oddish", "@drawable/oddish", "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#44", "Gloom", "@drawable/gloom", "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#45", "Vileplume", "@drawable/vileplume", "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#46", "Paras", "@drawable/paras", "@drawable/bicho", "@drawable/planta"),
                                 new Pokemon("#47", "Parasect", "@drawable/parasect", "@drawable/bicho", "@drawable/planta"),
                                 new Pokemon("#48", "Venonat", "@drawable/venonat", "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#49", "Venomoth", "@drawable/venomoth", "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#50", "Diglett", "@drawable/diglett", "@drawable/tierra", ""),
                                 new Pokemon("#51", "Dugtrio", "@drawable/dugtrio", "@drawable/tierra", ""),
                                 new Pokemon("#52", "Meowth", "@drawable/meowth", "@drawable/normal", ""),
                                 new Pokemon("#53", "Persian", "@drawable/persian", "@drawable/normal", ""),
                                 new Pokemon("#54", "Psyduck", "@drawable/psyduck", "@drawable/agua", ""),
                                 new Pokemon("#55", "Golduck", "@drawable/golduck", "@drawable/agua", ""),
                                 new Pokemon("#56", "Mankey", "@drawable/mankey", "@drawable/lucha", ""),
                                 new Pokemon("#57", "Primeape", "@drawable/primeape", "@drawable/lucha", ""),
                                 new Pokemon("#58", "Growlithe", "@drawable/growlithe", "@drawable/fuego", ""),
                                 new Pokemon("#59", "Arcanine", "@drawable/arcanine", "@drawable/fuego", ""),
                                 new Pokemon("#60", "Poliwag", "@drawable/poliwag", "@drawable/agua", ""),
                                 new Pokemon("#61", "Poliwhirl", "@drawable/poliwhirl", "@drawable/agua", ""),
                                 new Pokemon("#62", "Poliwrath", "@drawable/poliwrath", "@drawable/agua", "@drawable/lucha"),
                                 new Pokemon("#63", "Abra", "@drawable/abra", "@drawable/psiquico", ""),
                                 new Pokemon("#64", "Kadabra", "@drawable/kadabra", "@drawable/psiquico", ""),
                                 new Pokemon("#65", "Alakazam", "@drawable/alakazam", "@drawable/psiquico", ""),
                                 new Pokemon("#66", "Machop", "@drawable/machop", "@drawable/lucha", ""),
                                 new Pokemon("#67", "Machoke", "@drawable/machoke", "@drawable/lucha", ""),
                                 new Pokemon("#68", "Machamp", "@drawable/machamp", "@drawable/lucha", ""),
                                 new Pokemon("#69", "Bellsprout", "@drawable/bellsprout", "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#70", "Weepinbell", "@drawable/weepinbell", "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#71", "Victreebel", "@drawable/victreebel", "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#72", "Tentacool", "@drawable/tentacool", "@drawable/agua", "@drawable/veneno"),
                                 new Pokemon("#73", "Tentacruel", "@drawable/tentacruel", "@drawable/agua", "@drawable/veneno"),
                                 new Pokemon("#74", "Geodude", "@drawable/geodude", "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#75", "Graveler", "@drawable/graveler", "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#76", "Golem", "@drawable/golem", "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#77", "Ponyta", "@drawable/ponyta", "@drawable/fuego", ""),
                                 new Pokemon("#78", "Rapidash", "@drawable/rapidash", "@drawable/fuego", ""),
                                 new Pokemon("#79", "Slowpoke", "@drawable/slowpoke", "@drawable/agua", "@drawable/psiquico"),
                                 new Pokemon("#80", "Slowbro", "@drawable/slowbro", "@drawable/agua", "@drawable/psiquico"),
                                 new Pokemon("#81", "Magnemite", "@drawable/magnemite", "@drawable/electrico", "@drawable/acero"),
                                 new Pokemon("#82", "Magneton", "@drawable/magneton", "@drawable/electrico", "@drawable/acero"),
                                 new Pokemon("#83", "Farfetch'd", "@drawable/farfetch", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#84", "Doduo", "@drawable/doduo", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#85", "Dodrio", "@drawable/dodrio", "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#86", "Seel", "@drawable/seel", "@drawable/agua", ""),
                                 new Pokemon("#87", "Dewgong", "@drawable/dewgong", "@drawable/agua", "@drawable/hielo"),
                                 new Pokemon("#88", "Grimer", "@drawable/grimer", "@drawable/veneno", ""),
                                 new Pokemon("#89", "Muk", "@drawable/muk", "@drawable/veneno", ""),
                                 new Pokemon("#90", "Shellder", "@drawable/shellder", "@drawable/agua", ""),
                                 new Pokemon("#91", "Cloyster", "@drawable/cloyster", "@drawable/agua", "@drawable/hielo"),
                                 new Pokemon("#92", "Gastly", "@drawable/gastly", "@drawable/fantasma", "@drawable/veneno"),
                                 new Pokemon("#93", "Haunter", "@drawable/haunter", "@drawable/fantasma", "@drawable/veneno"),
                                 new Pokemon("#94", "Gengar", "@drawable/gengar", "@drawable/fantasma", "@drawable/veneno"),
                                 new Pokemon("#95", "Onix", "@drawable/onix", "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#96", "Drowzee", "@drawable/drowzee", "@drawable/psiquico", ""),
                                 new Pokemon("#97", "Hypno", "@drawable/hypno", "@drawable/psiquico", ""),
                                 new Pokemon("#98", "Krabby", "@drawable/krabby", "@drawable/agua", ""),
                                 new Pokemon("#99", "Kingler", "@drawable/kingler", "@drawable/agua", ""),
                                 new Pokemon("#100", "Voltorb", "@drawable/voltorb", "@drawable/electrico", ""),
                                 new Pokemon("#101", "Electrode", "@drawable/electrode", "@drawable/electrico", ""),
                                 new Pokemon("#102", "Exeggcute", "@drawable/exeggcute", "@drawable/planta", "@drawable/psiquico"),
                                 new Pokemon("#103", "Exeggutor", "@drawable/exeggutor", "@drawable/planta", "@drawable/psiquico"),
                                 new Pokemon("#104", "Cubone", "@drawable/cubone", "@drawable/tierra", ""),
                                 new Pokemon("#105", "Marowak", "@drawable/marowak", "@drawable/tierra", ""),
                                 new Pokemon("#106", "Hitmonlee", "@drawable/hitmonlee", "@drawable/lucha", ""),
                                 new Pokemon("#107", "Hitmonchan", "@drawable/hitmonchan", "@drawable/lucha", ""),
                                 new Pokemon("#108", "Lickitung", "@drawable/lickitung", "@drawable/normal", ""),
                                 new Pokemon("#109", "Koffing", "@drawable/koffing", "@drawable/veneno", ""),
                                 new Pokemon("#110", "Weezing", "@drawable/weezing", "@drawable/veneno", ""),
                                 new Pokemon("#111", "Rhyhorn", "@drawable/rhyhorn", "@drawable/tierra", "@drawable/roca"),
                                 new Pokemon("#112", "Rhydon", "@drawable/rhydon", "@drawable/tierra", "@drawable/roca"),
                                 new Pokemon("#113", "Chansey", "@drawable/chansey", "@drawable/normal", ""),
                                 new Pokemon("#114", "Tangela", "@drawable/tangela", "@drawable/planta", ""),
                                 new Pokemon("#115", "Kangaskhan", "@drawable/kangaskhan", "@drawable/normal", ""),
                                 new Pokemon("#116", "Horsea", "@drawable/horsea", "@drawable/agua", ""),
                                 new Pokemon("#117", "Seadra", "@drawable/seadra", "@drawable/agua", ""),
                                 new Pokemon("#118", "Goldeen", "@drawable/goldeen", "@drawable/agua", ""),
                                 new Pokemon("#119", "Seaking", "@drawable/seaking", "@drawable/agua", ""),
                                 new Pokemon("#120", "Staryu", "@drawable/staryu", "@drawable/agua", ""),
                                 new Pokemon("#121", "Starmie", "@drawable/starmie", "@drawable/agua", "@drawable/psiquico"),
                                 new Pokemon("#122", "Mr. Mime", "@drawable/mrmime", "@drawable/psiquico", "@drawable/hada"),
                                 new Pokemon("#123", "Scyther", "@drawable/scyther", "@drawable/bicho", "@drawable/volador"),
                                 new Pokemon("#124", "Jynx", "@drawable/jynx", "@drawable/hielo", "@drawable/psiquico"),
                                 new Pokemon("#125", "Electabuzz", "@drawable/electabuzz", "@drawable/electrico", ""),
                                 new Pokemon("#126", "Magmar", "@drawable/magmar", "@drawable/fuego", ""),
                                 new Pokemon("#127", "Pinsir", "@drawable/pinsir", "@drawable/bicho", ""),
                                 new Pokemon("#128", "Tauros", "@drawable/tauros", "@drawable/normal", ""),
                                 new Pokemon("#129", "Magikarp", "@drawable/magikarp", "@drawable/agua", ""),
                                 new Pokemon("#130", "Gyarados", "@drawable/gyarados", "@drawable/agua", "@drawable/volador"),
                                 new Pokemon("#131", "Lapras", "@drawable/lapras", "@drawable/agua", "@drawable/hielo"),
                                 new Pokemon("#132", "Ditto", "@drawable/ditto", "@drawable/normal", ""),
                                 new Pokemon("#133", "Eevee", "@drawable/eevee", "@drawable/normal", ""),
                                 new Pokemon("#134", "Vaporeon", "@drawable/vaporeon", "@drawable/agua", ""),
                                 new Pokemon("#135", "Jolteon", "@drawable/jolteon", "@drawable/electrico", ""),
                                 new Pokemon("#136", "Flareon", "@drawable/flareon", "@drawable/fuego", ""),
                                 new Pokemon("#137", "Porygon", "@drawable/porygon", "@drawable/normal", ""),
                                 new Pokemon("#138", "Omanyte", "@drawable/omanyte", "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#139", "Omastar", "@drawable/omastar", "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#140", "Kabuto", "@drawable/kabuto", "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#141", "Kabutops", "@drawable/kabutops", "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#142", "Aerodactyl", "@drawable/aerodactyl", "@drawable/roca", "@drawable/volador"),
                                 new Pokemon("#143", "Snorlax", "@drawable/snorlax", "@drawable/normal", ""),
                                 new Pokemon("#144", "Articuno", "@drawable/articuno", "@drawable/hielo", "@drawable/volador"),
                                 new Pokemon("#145", "Zapdos", "@drawable/zapdos", "@drawable/electrico", "@drawable/volador"),
                                 new Pokemon("#146", "Moltres", "@drawable/moltres", "@drawable/fuego", "@drawable/volador"),
                                 new Pokemon("#147", "Dratini", "@drawable/dratini", "@drawable/dragon", "@drawable/volador"),
                                 new Pokemon("#148", "Dragonair", "@drawable/dragonair", "@drawable/dragon", "@drawable/volador"),
                                 new Pokemon("#149", "Dragonite", "@drawable/dragonite", "@drawable/dragon", "@drawable/volador"),
                                 new Pokemon("#150", "Mewtwo", "@drawable/mewtwo", "@drawable/psiquico", ""),
                                 new Pokemon("#151", "Mew", "@drawable/mew", "@drawable/psiquico", "")

                                 };

    private ArrayList<Pokemon> ListPokemon = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> ListPokemonFiltrat = new ArrayList<Pokemon>();

    private Pokemon[] PokemonsFiltrats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("PokéDex");

        ListPokemon.add(new Pokemon("1", "Bulbasaur", Tipos[3], Tipos[4], R.drawable.ic_bulbasaur, "No tiene", "Ivysaur"));
        ListPokemon.add(new Pokemon("2","Ivysaur", Tipos[3], Tipos[4], R.drawable.ic_ivysaur, "Bulbasaur", "Venusaur"));
        ListPokemon.add(new Pokemon("3", "Venusaur", Tipos[3], Tipos[4], R.drawable.ic_venusaur, "Ivysaur", "No tiene"));
        ListPokemon.add(new Pokemon("4", "Charmander", Tipos[2], Tipos[0], R.drawable.ic_charmander, "No tiene", "Charmeleon"));
        

        /*filtre("Sin filtro");*/
        ListPokemonFiltrat.addAll(ListPokemon);

        /*adaptador = new AdaptadorPokemons(this, PokemonsFiltrats);*/
        adaptador = new AdaptadorPokemons(this, ListPokemonFiltrat);

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
            /*filtre(filtre);*/
            filtreLlista(filtre);
        }

        return super.onOptionsItemSelected(item);
    }

    private void filtre(String filtre) {

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
            PokemonsFiltrats = new Pokemon[Pokemons.length];

            for (int i = 0; i < Pokemons.length; i++) {
                PokemonsFiltrats[i] = Pokemons[i];
            }

        }
    }

    private void filtreLlista(String filtre) {

        // Respond to the action bar's Up/Home button
        if (filtre.equals("Sin filtro")) {
            ListPokemonFiltrat.clear();
            ListPokemonFiltrat.addAll(ListPokemon);

            adaptador.notifyDataSetChanged();
        } else {
            ListPokemonFiltrat.clear();

            for (int i = 0; i < ListPokemon.size(); i++) {
                if (ListPokemon.get(i).getTipo1().getNom().equals(filtre) || ListPokemon.get(i).getTipo2().getNom().equals(filtre)) {

                    ListPokemonFiltrat.add(ListPokemon.get(i));
                }
            }

            adaptador.notifyDataSetChanged();
        }
    }

    private void detailPokemon(Pokemon opcioSeleccionada) {
        Intent i = new Intent(this, DetailPokemon.class);

        i.putExtra("pokemon", opcioSeleccionada);

        startActivity(i);
    }

    private void joc() {

    }
}
