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
                           new Tipo("Fuego", R.drawable.fuego_tipo),
                           new Tipo("Planta", R.drawable.tipo_planta),
                           new Tipo("Veneno", R.drawable.tipo_veneno)
                           };

    private Pokemon[] Pokemons = new Pokemon[]{
                                 new Pokemon("1", "Bulbasaur", Tipos[3], Tipos[4], R.drawable.ic_bulbasaur, "No tiene", "Ivysaur"),
                                 new Pokemon("2","Ivysaur", Tipos[3], Tipos[4], R.drawable.ic_ivysaur, "Bulbasaur", "Venusaur"),
                                 new Pokemon("3", "Venusaur", Tipos[3], Tipos[4], R.drawable.ic_venusaur, "Ivysaur", "No tiene"),
                                 new Pokemon("4", "Charmander", Tipos[2], Tipos[0], R.drawable.ic_charmander, "No tiene", "Charmeleon"),
                                 new Pokemon("5", "Charmeleon", Tipos[2], Tipos[0], R.drawable.ic_charmander, "Charmander", "Charizard"),
                                 new Pokemon("6", "@drawable/charizard", "Charizard",  "@drawable/fuego", "@drawable/volador"),
                                 new Pokemon("7", "@drawable/squirtle", "Squirtle",  "@drawable/agua", ""),
                                 new Pokemon("8", "@drawable/wartortle", "Wartortle",  "@drawable/agua", ""),
                                 new Pokemon("9", "@drawable/blastoise", "Blastoise",  "@drawable/agua", ""),
                                 new Pokemon("#10", "@drawable/caterpie", "Caterpie",  "@drawable/bicho", ""),
                                 new Pokemon("#11", "@drawable/metapod", "Metapod",  "@drawable/bicho", ""),
                                 new Pokemon("#12", "@drawable/butterfree", "Butterfree",  "@drawable/bicho", "@drawable/volador"),
                                 new Pokemon("#13", "@drawable/weedle", "Weedle",  "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#14", "@drawable/kakuna", "Kakuna",  "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#15", "@drawable/beedrill", "Beedrill",  "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#16", "@drawable/pidgey", "Pidgey",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#17", "@drawable/pidgeotto", "Pidgeotto",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#18", "@drawable/pidgeot", "Pidgeot",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#19", "@drawable/rattata", "Rattata",  "@drawable/normal", ""),
                                 new Pokemon("#20", "@drawable/raticate", "Raticate",  "@drawable/normal", ""),
                                 new Pokemon("#21", "@drawable/spearow", "Spearow",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#22", "@drawable/fearow", "Fearow",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#23", "@drawable/ekans", "Ekans",  "@drawable/veneno", ""),
                                 new Pokemon("#24", "@drawable/arbok", "Arbok",  "@drawable/veneno", ""),
                                 new Pokemon("#25", "@drawable/pikachu", "Pikachu",  "@drawable/electrico", ""),
                                 new Pokemon("#26", "@drawable/raichu", "Raichu",  "@drawable/electrico", ""),
                                 new Pokemon("#27", "@drawable/sandshrew", "Sandshrew",  "@drawable/tierra", ""),
                                 new Pokemon("#28", "@drawable/sandslash", "Sandslash",  "@drawable/tierra", ""),
                                 new Pokemon("#29", "@drawable/nidoranh", "Nidoran♀",  "@drawable/veneno", ""),
                                 new Pokemon("#30", "@drawable/nidorina", "Nidorina",  "@drawable/veneno", ""),
                                 new Pokemon("#31", "@drawable/nidoqueen", "Nidoqueen",  "@drawable/veneno", "@drawable/tierra"),
                                 new Pokemon("#32", "@drawable/nidoranm", "Nidoran♂",  "@drawable/veneno", ""),
                                 new Pokemon("#33", "@drawable/nidorino", "Nidorino",  "@drawable/veneno", ""),
                                 new Pokemon("#34", "@drawable/nidoking", "Nidoking",  "@drawable/veneno", "@drawable/tierra"),
                                 new Pokemon("#35", "@drawable/clefairy", "Clefairy",  "@drawable/normal", ""),
                                 new Pokemon("#36", "@drawable/clefable", "Clefable",  "@drawable/normal", ""),
                                 new Pokemon("#37", "@drawable/vulpix", "Vulpix",  "@drawable/fuego", ""),
                                 new Pokemon("#38", "@drawable/ninetales", "Ninetales",  "@drawable/fuego", ""),
                                 new Pokemon("#39", "@drawable/jigglypuff", "Jigglypuff",  "@drawable/normal", "@drawable/hada"),
                                 new Pokemon("#40", "@drawable/wigglytuff", "Wigglytuff",  "@drawable/normal", "@drawable/hada"),
                                 new Pokemon("#41", "@drawable/zubat", "Zubat",  "@drawable/veneno", "@drawable/volador"),
                                 new Pokemon("#42", "@drawable/golbat", "Golbat",  "@drawable/veneno", "@drawable/volador"),
                                 new Pokemon("#43", "@drawable/oddish", "Oddish",  "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#44", "@drawable/gloom", "Gloom",  "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#45", "@drawable/vileplume", "Vileplume",  "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#46", "@drawable/paras", "Paras",  "@drawable/bicho", "@drawable/planta"),
                                 new Pokemon("#47", "@drawable/parasect", "Parasect",  "@drawable/bicho", "@drawable/planta"),
                                 new Pokemon("#48", "@drawable/venonat", "Venonat",  "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#49", "@drawable/venomoth", "Venomoth",  "@drawable/bicho", "@drawable/veneno"),
                                 new Pokemon("#50", "@drawable/diglett", "Diglett",  "@drawable/tierra", ""),
                                 new Pokemon("#51", "@drawable/dugtrio", "Dugtrio",  "@drawable/tierra", ""),
                                 new Pokemon("#52", "@drawable/meowth", "Meowth",  "@drawable/normal", ""),
                                 new Pokemon("#53", "@drawable/persian", "Persian",  "@drawable/normal", ""),
                                 new Pokemon("#54", "@drawable/psyduck", "Psyduck",  "@drawable/agua", ""),
                                 new Pokemon("#55", "@drawable/golduck", "Golduck",  "@drawable/agua", ""),
                                 new Pokemon("#56", "@drawable/mankey", "Mankey",  "@drawable/lucha", ""),
                                 new Pokemon("#57", "@drawable/primeape", "Primeape",  "@drawable/lucha", ""),
                                 new Pokemon("#58", "@drawable/growlithe", "Growlithe",  "@drawable/fuego", ""),
                                 new Pokemon("#59", "@drawable/arcanine", "Arcanine",  "@drawable/fuego", ""),
                                 new Pokemon("#60", "@drawable/poliwag", "Poliwag",  "@drawable/agua", ""),
                                 new Pokemon("#61", "@drawable/poliwhirl", "Poliwhirl",  "@drawable/agua", ""),
                                 new Pokemon("#62", "@drawable/poliwrath", "Poliwrath",  "@drawable/agua", "@drawable/lucha"),
                                 new Pokemon("#63", "@drawable/abra", "Abra",  "@drawable/psiquico", ""),
                                 new Pokemon("#64", "@drawable/kadabra", "Kadabra",  "@drawable/psiquico", ""),
                                 new Pokemon("#65", "@drawable/alakazam", "Alakazam",  "@drawable/psiquico", ""),
                                 new Pokemon("#66", "@drawable/machop", "Machop",  "@drawable/lucha", ""),
                                 new Pokemon("#67", "@drawable/machoke", "Machoke",  "@drawable/lucha", ""),
                                 new Pokemon("#68", "@drawable/machamp", "Machamp",  "@drawable/lucha", ""),
                                 new Pokemon("#69", "@drawable/bellsprout", "Bellsprout",  "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#70", "@drawable/weepinbell", "Weepinbell",  "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#71", "@drawable/victreebel", "Victreebel",  "@drawable/planta", "@drawable/veneno"),
                                 new Pokemon("#72", "@drawable/tentacool", "Tentacool",  "@drawable/agua", "@drawable/veneno"),
                                 new Pokemon("#73", "@drawable/tentacruel", "Tentacruel",  "@drawable/agua", "@drawable/veneno"),
                                 new Pokemon("#74", "@drawable/geodude", "Geodude",  "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#75", "@drawable/graveler", "Graveler",  "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#76", "@drawable/golem", "Golem",  "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#77", "@drawable/ponyta", "Ponyta",  "@drawable/fuego", ""),
                                 new Pokemon("#78", "@drawable/rapidash", "Rapidash",  "@drawable/fuego", ""),
                                 new Pokemon("#79", "@drawable/slowpoke", "Slowpoke",  "@drawable/agua", "@drawable/psiquico"),
                                 new Pokemon("#80", "@drawable/slowbro", "Slowbro",  "@drawable/agua", "@drawable/psiquico"),
                                 new Pokemon("#81", "@drawable/magnemite", "Magnemite",  "@drawable/electrico", "@drawable/acero"),
                                 new Pokemon("#82", "@drawable/magneton", "Magneton",  "@drawable/electrico", "@drawable/acero"),
                                 new Pokemon("#83", "@drawable/farfetch", "Farfetch'd",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#84", "@drawable/doduo", "Doduo",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#85", "@drawable/dodrio", "Dodrio",  "@drawable/normal", "@drawable/volador"),
                                 new Pokemon("#86", "@drawable/seel", "Seel",  "@drawable/agua", ""),
                                 new Pokemon("#87", "@drawable/dewgong", "Dewgong",  "@drawable/agua", "@drawable/hielo"),
                                 new Pokemon("#88", "@drawable/grimer", "Grimer",  "@drawable/veneno", ""),
                                 new Pokemon("#89", "@drawable/muk", "Muk",  "@drawable/veneno", ""),
                                 new Pokemon("#90", "@drawable/shellder", "Shellder",  "@drawable/agua", ""),
                                 new Pokemon("#91", "@drawable/cloyster", "Cloyster",  "@drawable/agua", "@drawable/hielo"),
                                 new Pokemon("#92", "@drawable/gastly", "Gastly",  "@drawable/fantasma", "@drawable/veneno"),
                                 new Pokemon("#93", "@drawable/haunter", "Haunter",  "@drawable/fantasma", "@drawable/veneno"),
                                 new Pokemon("#94", "@drawable/gengar", "Gengar",  "@drawable/fantasma", "@drawable/veneno"),
                                 new Pokemon("#95", "@drawable/onix", "Onix",  "@drawable/roca", "@drawable/tierra"),
                                 new Pokemon("#96", "@drawable/drowzee", "Drowzee",  "@drawable/psiquico", ""),
                                 new Pokemon("#97", "@drawable/hypno", "Hypno",  "@drawable/psiquico", ""),
                                 new Pokemon("#98", "@drawable/krabby", "Krabby",  "@drawable/agua", ""),
                                 new Pokemon("#99", "@drawable/kingler", "Kingler",  "@drawable/agua", ""),
                                 new Pokemon("#100", "@drawable/voltorb", "Voltorb",  "@drawable/electrico", ""),
                                 new Pokemon("#101", "@drawable/electrode", "Electrode",  "@drawable/electrico", ""),
                                 new Pokemon("#102", "@drawable/exeggcute", "Exeggcute",  "@drawable/planta", "@drawable/psiquico"),
                                 new Pokemon("#103", "@drawable/exeggutor", "Exeggutor",  "@drawable/planta", "@drawable/psiquico"),
                                 new Pokemon("#104", "@drawable/cubone", "Cubone",  "@drawable/tierra", ""),
                                 new Pokemon("#105", "@drawable/marowak", "Marowak",  "@drawable/tierra", ""),
                                 new Pokemon("#106", "@drawable/hitmonlee", "Hitmonlee",  "@drawable/lucha", ""),
                                 new Pokemon("#107", "@drawable/hitmonchan", "Hitmonchan",  "@drawable/lucha", ""),
                                 new Pokemon("#108", "@drawable/lickitung", "Lickitung",  "@drawable/normal", ""),
                                 new Pokemon("#109", "@drawable/koffing", "Koffing",  "@drawable/veneno", ""),
                                 new Pokemon("#110", "@drawable/weezing", "Weezing",  "@drawable/veneno", ""),
                                 new Pokemon("#111", "@drawable/rhyhorn", "Rhyhorn",  "@drawable/tierra", "@drawable/roca"),
                                 new Pokemon("#112", "@drawable/rhydon", "Rhydon",  "@drawable/tierra", "@drawable/roca"),
                                 new Pokemon("#113", "@drawable/chansey", "Chansey",  "@drawable/normal", ""),
                                 new Pokemon("#114", "@drawable/tangela", "Tangela",  "@drawable/planta", ""),
                                 new Pokemon("#115", "@drawable/kangaskhan", "Kangaskhan",  "@drawable/normal", ""),
                                 new Pokemon("#116", "@drawable/horsea", "Horsea",  "@drawable/agua", ""),
                                 new Pokemon("#117", "@drawable/seadra", "Seadra",  "@drawable/agua", ""),
                                 new Pokemon("#118", "@drawable/goldeen", "Goldeen",  "@drawable/agua", ""),
                                 new Pokemon("#119", "@drawable/seaking", "Seaking",  "@drawable/agua", ""),
                                 new Pokemon("#120", "@drawable/staryu", "Staryu",  "@drawable/agua", ""),
                                 new Pokemon("#121", "@drawable/starmie", "Starmie",  "@drawable/agua", "@drawable/psiquico"),
                                 new Pokemon("#122", "@drawable/mrmime", "Mr. Mime",  "@drawable/psiquico", "@drawable/hada"),
                                 new Pokemon("#123", "@drawable/scyther", "Scyther",  "@drawable/bicho", "@drawable/volador"),
                                 new Pokemon("#124", "@drawable/jynx", "Jynx",  "@drawable/hielo", "@drawable/psiquico"),
                                 new Pokemon("#125", "@drawable/electabuzz", "Electabuzz",  "@drawable/electrico", ""),
                                 new Pokemon("#126", "@drawable/magmar", "Magmar",  "@drawable/fuego", ""),
                                 new Pokemon("#127", "@drawable/pinsir", "Pinsir",  "@drawable/bicho", ""),
                                 new Pokemon("#128", "@drawable/tauros", "Tauros",  "@drawable/normal", ""),
                                 new Pokemon("#129", "@drawable/magikarp", "Magikarp",  "@drawable/agua", ""),
                                 new Pokemon("#130", "@drawable/gyarados", "Gyarados",  "@drawable/agua", "@drawable/volador"),
                                 new Pokemon("#131", "@drawable/lapras", "Lapras",  "@drawable/agua", "@drawable/hielo"),
                                 new Pokemon("#132", "@drawable/ditto", "Ditto",  "@drawable/normal", ""),
                                 new Pokemon("#133", "@drawable/eevee", "Eevee",  "@drawable/normal", ""),
                                 new Pokemon("#134", "@drawable/vaporeon", "Vaporeon",  "@drawable/agua", ""),
                                 new Pokemon("#135", "@drawable/jolteon", "Jolteon",  "@drawable/electrico", ""),
                                 new Pokemon("#136", "@drawable/flareon", "Flareon",  "@drawable/fuego", ""),
                                 new Pokemon("#137", "@drawable/porygon", "Porygon",  "@drawable/normal", ""),
                                 new Pokemon("#138", "@drawable/omanyte", "Omanyte",  "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#139", "@drawable/omastar", "Omastar",  "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#140", "@drawable/kabuto", "Kabuto",  "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#141", "@drawable/kabutops", "Kabutops",  "@drawable/roca", "@drawable/agua"),
                                 new Pokemon("#142", "@drawable/aerodactyl", "Aerodactyl",  "@drawable/roca", "@drawable/volador"),
                                 new Pokemon("#143", "@drawable/snorlax", "Snorlax",  "@drawable/normal", ""),
                                 new Pokemon("#144", "@drawable/articuno", "Articuno",  "@drawable/hielo", "@drawable/volador"),
                                 new Pokemon("#145", "@drawable/zapdos", "Zapdos",  "@drawable/electrico", "@drawable/volador"),
                                 new Pokemon("#146", "@drawable/moltres", "Moltres",  "@drawable/fuego", "@drawable/volador"),
                                 new Pokemon("#147", "@drawable/dratini", "Dratini",  "@drawable/dragon", "@drawable/volador"),
                                 new Pokemon("#148", "@drawable/dragonair", "Dragonair",  "@drawable/dragon", "@drawable/volador"),
                                 new Pokemon("#149", "@drawable/dragonite", "Dragonite",  "@drawable/dragon", "@drawable/volador"),
                                 new Pokemon("#150", "@drawable/mewtwo", "Mewtwo",  "@drawable/psiquico", ""),
                                 new Pokemon("#151", "@drawable/mew", "Mew",  "@drawable/psiquico", "")*/

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
