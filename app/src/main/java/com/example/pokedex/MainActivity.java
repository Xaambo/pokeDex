package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdaptadorPokemons adaptador;

    private Tipo[] Tipos = new Tipo[] {
                           new Tipo("", 0),
                           new Tipo("Agua", R.drawable.tipo_agua),
                           new Tipo("Bicho", R.drawable.tipo_bicho),
                           new Tipo("Dragón", R.drawable.tipo_dragon),
                           new Tipo("Eléctrico", R.drawable.tipo_electrico),
                           new Tipo("Fantasma", R.drawable.tipo_fantasma),
                           new Tipo("Fuego", R.drawable.tipo_fuego),
                           new Tipo("Hielo", R.drawable.tipo_hielo),
                           new Tipo("Lucha", R.drawable.tipo_lucha),
                           new Tipo("Normal", R.drawable.tipo_normal),
                           new Tipo("Planta", R.drawable.tipo_planta),
                           new Tipo("Psíquico", R.drawable.tipo_psiquico),
                           new Tipo("Roca", R.drawable.tipo_roca),
                           new Tipo("Tierra", R.drawable.tipo_tierra),
                           new Tipo("Veneno", R.drawable.tipo_veneno),
                           new Tipo("Volador", R.drawable.tipo_volador)
                           };

    private Pokemon[] Pokemons = new Pokemon[]{
                                 new Pokemon("1", "Bulbasaur", Tipos[10], Tipos[14], R.drawable.ic_bulbasaur, "No tiene", "Ivysaur"),
                                 new Pokemon("2", "Ivysaur", Tipos[10], Tipos[14], R.drawable.ic_ivysaur, "Bulbasaur", "Venusaur"),
                                 new Pokemon("3", "Venusaur", Tipos[3], Tipos[14], R.drawable.ic_venusaur, "Ivysaur", "No tiene"),
                                 new Pokemon("4", "Charmander", Tipos[6], Tipos[0], R.drawable.ic_charmander, "No tiene", "Charmeleon"),
                                 new Pokemon("5", "Charmeleon", Tipos[6], Tipos[0], R.drawable.ic_charmander, "Charmander", "Charizard"),
                                 };

    private ArrayList<Pokemon> ListPokemon = new ArrayList<>();
    private ArrayList<Pokemon> ListPokemonFiltrat = new ArrayList<>();

    private Pokemon[] PokemonsFiltrats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("PokéDex");

        ListPokemon.add(new Pokemon("1", "Bulbasaur", Tipos[10], Tipos[14], R.drawable.ic_bulbasaur, "No tiene", "Ivysaur"));
        ListPokemon.add(new Pokemon("2","Ivysaur", Tipos[10], Tipos[14], R.drawable.ic_ivysaur, "Bulbasaur", "Venusaur"));
        ListPokemon.add(new Pokemon("3", "Venusaur", Tipos[10], Tipos[14], R.drawable.ic_venusaur, "Ivysaur", "No tiene"));
        ListPokemon.add(new Pokemon("4", "Charmander", Tipos[6], Tipos[0], R.drawable.ic_charmander, "No tiene", "Charmeleon"));
        ListPokemon.add(new Pokemon("5", "Charmeleon", Tipos[6], Tipos[0], R.drawable.ic_charmander, "Charmander", "Charizard"));
        ListPokemon.add(new Pokemon("6", "Charizard",  Tipos[6], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("7", "Squirtle",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("8", "Wartortle",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("9", "Blastoise",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#10", "Caterpie",  Tipos[2], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#11", "Metapod",  Tipos[2], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#12", "Butterfree",  Tipos[2], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#13", "Weedle",  Tipos[2], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#14", "Kakuna",  Tipos[2], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#15", "Beedrill",  Tipos[2], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#16", "Pidgey",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#17", "Pidgeotto",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#18", "Pidgeot",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#19", "Rattata",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#20", "Raticate",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#21", "Spearow",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#22", "Fearow",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#23", "Ekans",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#24", "Arbok",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#25", "Pikachu",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#26", "Raichu",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#27", "Sandshrew",  Tipos[13], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#28", "Sandslash",  Tipos[13], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#29", "Nidoran ♀",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#30", "Nidorina",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#31", "Nidoqueen",  Tipos[14], Tipos[13], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#32", "Nidoran ♂",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#33", "Nidorino",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#34", "Nidoking",  Tipos[14], Tipos[13], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#35", "Clefairy",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#36", "Clefable",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#37", "Vulpix",  Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#38",  "Ninetales", Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#39", "Jigglypuff",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#40", "Wigglytuff",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#41", "Zubat",  Tipos[14], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#42", "Golbat",  Tipos[14], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#43", "Oddish",  Tipos[10], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#44", "Gloom",  Tipos[10], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#45", "Vileplume",  Tipos[10], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#46", "Paras",  Tipos[2], Tipos[10], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#47", "Parasect",  Tipos[2], Tipos[10], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#48", "Venonat",  Tipos[2], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#49", "Venomoth",  Tipos[2], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#50", "Diglett",  Tipos[13], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#51", "Dugtrio",  Tipos[13], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#52", "Meowth",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#53", "Persian",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#54", "Psyduck",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#55", "Golduck",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#56", "Mankey",  Tipos[8], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#57", "Primeape",  Tipos[8], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#58", "Growlithe",  Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#59", "Arcanine",  Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#60", "Poliwag",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#61", "Poliwhirl",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#62", "Poliwrath",  Tipos[1], Tipos[8], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#63", "Abra",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#64", "Kadabra",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#65", "Alakazam",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#66", "Machop",  Tipos[8], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#67", "Machoke",  Tipos[8], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#68", "Machamp",  Tipos[8], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#69", "Bellsprout",  Tipos[10], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#70", "Weepinbell",  Tipos[10], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#71", "Victreebel",  Tipos[10], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#72", "Tentacool",  Tipos[1], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#73", "Tentacruel",  Tipos[1], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#74", "Geodude",  Tipos[12], Tipos[13], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#75", "Graveler",  Tipos[12], Tipos[13], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#76", "Golem",  Tipos[12], Tipos[13], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#77", "Ponyta",  Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#78", "Rapidash",  Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#79", "Slowpoke",  Tipos[1], Tipos[11], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#80", "Slowbro",  Tipos[1], Tipos[11], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#81", "Magnemite",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#82", "Magneton",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#83", "Farfetch'd",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#84", "Doduo",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#85", "Dodrio",  Tipos[9], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#86", "Seel",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#87", "Dewgong",  Tipos[1], Tipos[7], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#88", "Grimer",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#89", "Muk",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#90", "Shellder",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#91", "Cloyster",  Tipos[1], Tipos[7], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#92", "Gastly",  Tipos[5], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#93", "Haunter",  Tipos[5], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#94", "Gengar",  Tipos[5], Tipos[14], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#95", "Onix",  Tipos[12], Tipos[13], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#96", "Drowzee",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#97", "Hypno",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#98", "Krabby",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#99", "Kingler",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#100", "Voltorb",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#101", "Electrode",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#102", "Exeggcute",  Tipos[10], Tipos[11], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#103", "Exeggutor",  Tipos[10], Tipos[11], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#104", "Cubone",  Tipos[13], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#105", "Marowak",  Tipos[13], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#106", "Hitmonlee",  Tipos[8], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#107", "Hitmonchan",  Tipos[8], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#108", "Lickitung",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#109", "Koffing",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#110", "Weezing",  Tipos[14], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#111", "Rhyhorn",  Tipos[13], Tipos[12], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#112", "Rhydon",  Tipos[13], Tipos[12], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#113", "Chansey",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#114", "Tangela",  Tipos[10], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#115", "Kangaskhan",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#116", "Horsea",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#117", "Seadra",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#118", "Goldeen",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#119", "Seaking",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#120", "Staryu",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#121", "Starmie",  Tipos[1], Tipos[11], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#122", "Mr. Mime",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#123", "Scyther",  Tipos[2], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#124", "Jynx",  Tipos[7], Tipos[11], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#125", "Electabuzz",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#126", "Magmar",  Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#127", "Pinsir",  Tipos[2], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#128", "Tauros",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#129", "Magikarp",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#130", "Gyarados",  Tipos[1], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#131", "Lapras",  Tipos[1], Tipos[7], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#132", "Ditto",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#133", "Eevee",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#134", "Vaporeon",  Tipos[1], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#135", "Jolteon",  Tipos[4], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#136", "Flareon",  Tipos[6], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#137", "Porygon",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#138", "Omanyte",  Tipos[12], Tipos[1], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#139", "Omastar",  Tipos[12], Tipos[1], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#140", "Kabuto",  Tipos[12], Tipos[1], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#141", "Kabutops",  Tipos[12], Tipos[1], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#142", "Aerodactyl",  Tipos[12], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#143", "Snorlax",  Tipos[9], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#144", "Articuno",  Tipos[7], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#145", "Zapdos",  Tipos[4], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#146", "Moltres",  Tipos[6], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#147", "Dratini",  Tipos[3], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#148", "Dragonair",  Tipos[3], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#149", "Dragonite",  Tipos[3], Tipos[15], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#150", "Mewtwo",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        ListPokemon.add(new Pokemon("#151", "Mew",  Tipos[11], Tipos[0], R.drawable.ic_charmander, "", ""));
        
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
            return true;
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
