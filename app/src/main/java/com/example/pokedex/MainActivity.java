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
                           new Tipo(R.id.ninguno, "", 0),
                           new Tipo(R.id.agua, "Agua", R.drawable.tipo_agua),
                           new Tipo(R.id.bicho, "Bicho", R.drawable.tipo_bicho),
                           new Tipo(R.id.dragon, "Dragón", R.drawable.tipo_dragon),
                           new Tipo(R.id.electrico, "Eléctrico", R.drawable.tipo_electrico),
                           new Tipo(R.id.fanstasma, "Fantasma", R.drawable.tipo_fantasma),
                           new Tipo(R.id.fuego, "Fuego", R.drawable.tipo_fuego),
                           new Tipo(R.id.hielo, "Hielo", R.drawable.tipo_hielo),
                           new Tipo(R.id.lucha, "Lucha", R.drawable.tipo_lucha),
                           new Tipo(R.id.normal, "Normal", R.drawable.tipo_normal),
                           new Tipo(R.id.planta, "Planta", R.drawable.tipo_planta),
                           new Tipo(R.id.psiquico, "Psíquico", R.drawable.tipo_psiquico),
                           new Tipo(R.id.roca, "Roca", R.drawable.tipo_roca),
                           new Tipo(R.id.tierra, "Tierra", R.drawable.tipo_tierra),
                           new Tipo(R.id.veneno, "Veneno", R.drawable.tipo_veneno),
                           new Tipo(R.id.volador, "Volador", R.drawable.tipo_volador)
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
        ListPokemon.add(new Pokemon("5", "Charmeleon", Tipos[6], Tipos[0], R.drawable.charmeleon_seeklogo_com, "Charmander", "Charizard"));
        ListPokemon.add(new Pokemon("6", "Charizard",  Tipos[6], Tipos[15], R.drawable.charizard_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("7", "Squirtle",  Tipos[1], Tipos[0], R.drawable.squirtle_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("8", "Wartortle",  Tipos[1], Tipos[0], R.drawable.wartortle_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("9", "Blastoise",  Tipos[1], Tipos[0], R.drawable.blastoise_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("10", "Caterpie",  Tipos[2], Tipos[0], R.drawable.caterpie_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("11", "Metapod",  Tipos[2], Tipos[0], R.drawable.metapod_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("12", "Butterfree",  Tipos[2], Tipos[15], R.drawable.butterfree_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("13", "Weedle",  Tipos[2], Tipos[14], R.drawable.weedle_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("14", "Kakuna",  Tipos[2], Tipos[14], R.drawable.kakuna_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("15", "Beedrill",  Tipos[2], Tipos[14], R.drawable.beedrill_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("16", "Pidgey",  Tipos[9], Tipos[15], R.drawable.pidgey_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("17", "Pidgeotto",  Tipos[9], Tipos[15], R.drawable.pidgeotto_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("18", "Pidgeot",  Tipos[9], Tipos[15], R.drawable.pidgeot_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("19", "Rattata",  Tipos[9], Tipos[0], R.drawable.charizard_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("20", "Raticate",  Tipos[9], Tipos[0], R.drawable.raticate_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("21", "Spearow",  Tipos[9], Tipos[15], R.drawable.spearow_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("22", "Fearow",  Tipos[9], Tipos[15], R.drawable.fearow_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("23", "Ekans",  Tipos[14], Tipos[0], R.drawable.ekans_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("24", "Arbok",  Tipos[14], Tipos[0], R.drawable.arbok_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("25", "Pikachu",  Tipos[4], Tipos[0], R.drawable.pikachu_pokemon_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("26", "Raichu",  Tipos[4], Tipos[0], R.drawable.raichu_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("27", "Sandshrew",  Tipos[13], Tipos[0], R.drawable.sandshrew_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("28", "Sandslash",  Tipos[13], Tipos[0], R.drawable.sandslash_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("29", "Nidoran ♀",  Tipos[14], Tipos[0], R.drawable.nidoran_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("30", "Nidorina",  Tipos[14], Tipos[0], R.drawable.nidorina_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("31", "Nidoqueen",  Tipos[14], Tipos[13], R.drawable.nidoqueen_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("32", "Nidoran ♂",  Tipos[14], Tipos[0], R.drawable.nidoran_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("33", "Nidorino",  Tipos[14], Tipos[0], R.drawable.nidorino_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("34", "Nidoking",  Tipos[14], Tipos[13], R.drawable.nidoking_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("35", "Clefairy",  Tipos[9], Tipos[0], R.drawable.clefairy_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("36", "Clefable",  Tipos[9], Tipos[0], R.drawable.clefable_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("37", "Vulpix",  Tipos[6], Tipos[0], R.drawable.vulpix_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("38", "Ninetales", Tipos[6], Tipos[0], R.drawable.ninetales_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("39", "Jigglypuff",  Tipos[9], Tipos[0], R.drawable.jigglypuff_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("40", "Wigglytuff",  Tipos[9], Tipos[0], R.drawable.wigglytuff_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("41", "Zubat",  Tipos[14], Tipos[15], R.drawable.zubat_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("42", "Golbat",  Tipos[14], Tipos[15], R.drawable.golbat_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("43", "Oddish",  Tipos[10], Tipos[14], R.drawable.oddish_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("44", "Gloom",  Tipos[10], Tipos[14], R.drawable.gloom_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("45", "Vileplume",  Tipos[10], Tipos[14], R.drawable.vileplume_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("46", "Paras",  Tipos[2], Tipos[10], R.drawable.paras_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("47", "Parasect",  Tipos[2], Tipos[10], R.drawable.parasect_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("48", "Venonat",  Tipos[2], Tipos[14], R.drawable.venonat_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("49", "Venomoth",  Tipos[2], Tipos[14], R.drawable.venomoth_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("50", "Diglett",  Tipos[13], Tipos[0], R.drawable.diglett_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("51", "Dugtrio",  Tipos[13], Tipos[0], R.drawable.dugtrio_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("52", "Meowth",  Tipos[9], Tipos[0], R.drawable.meowth_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("53", "Persian",  Tipos[9], Tipos[0], R.drawable.persian_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("54", "Psyduck",  Tipos[1], Tipos[0], R.drawable.psyduck_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("55", "Golduck",  Tipos[1], Tipos[0], R.drawable.golduck_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("56", "Mankey",  Tipos[8], Tipos[0], R.drawable.mankey_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("57", "Primeape",  Tipos[8], Tipos[0], R.drawable.primeape_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("58", "Growlithe",  Tipos[6], Tipos[0], R.drawable.growlithe_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("59", "Arcanine",  Tipos[6], Tipos[0], R.drawable.arcanine_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("60", "Poliwag",  Tipos[1], Tipos[0], R.drawable.poliwag_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("61", "Poliwhirl",  Tipos[1], Tipos[0], R.drawable.poliwhirl_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("62", "Poliwrath",  Tipos[1], Tipos[8], R.drawable.poliwrath_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("63", "Abra",  Tipos[11], Tipos[0], R.drawable.abra_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("64", "Kadabra",  Tipos[11], Tipos[0], R.drawable.kadabra_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("65", "Alakazam",  Tipos[11], Tipos[0], R.drawable.alakazam_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("66", "Machop",  Tipos[8], Tipos[0], R.drawable.machop_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("67", "Machoke",  Tipos[8], Tipos[0], R.drawable.machoke_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("68", "Machamp",  Tipos[8], Tipos[0], R.drawable.charizard_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("69", "Bellsprout",  Tipos[10], Tipos[14], R.drawable.bellsprout_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("70", "Weepinbell",  Tipos[10], Tipos[14], R.drawable.weepinbell_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("71", "Victreebel",  Tipos[10], Tipos[14], R.drawable.victreebel_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("72", "Tentacool",  Tipos[1], Tipos[14], R.drawable.tentacool_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("73", "Tentacruel",  Tipos[1], Tipos[14], R.drawable.tentacruel_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("74", "Geodude",  Tipos[12], Tipos[13], R.drawable.geodude_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("75", "Graveler",  Tipos[12], Tipos[13], R.drawable.graveler_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("76", "Golem",  Tipos[12], Tipos[13], R.drawable.golem_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("77", "Ponyta",  Tipos[6], Tipos[0], R.drawable.ponyta_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("78", "Rapidash",  Tipos[6], Tipos[0], R.drawable.rapidash_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("79", "Slowpoke",  Tipos[1], Tipos[11], R.drawable.slowpoke_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("80", "Slowbro",  Tipos[1], Tipos[11], R.drawable.slowbro_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("81", "Magnemite",  Tipos[4], Tipos[0], R.drawable.magnemite_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("82", "Magneton",  Tipos[4], Tipos[0], R.drawable.magneton_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("83", "Farfetch'd",  Tipos[9], Tipos[15], R.drawable.farfetchd_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("84", "Doduo",  Tipos[9], Tipos[15], R.drawable.doduo_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("85", "Dodrio",  Tipos[9], Tipos[15], R.drawable.dodrio_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("86", "Seel",  Tipos[1], Tipos[0], R.drawable.seel_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("87", "Dewgong",  Tipos[1], Tipos[7], R.drawable.dewgong_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("88", "Grimer",  Tipos[14], Tipos[0], R.drawable.grimer_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("89", "Muk",  Tipos[14], Tipos[0], R.drawable.muk_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("90", "Shellder",  Tipos[1], Tipos[0], R.drawable.shellder_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("91", "Cloyster",  Tipos[1], Tipos[7], R.drawable.cloyster_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("92", "Gastly",  Tipos[5], Tipos[14], R.drawable.gastly_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("93", "Haunter",  Tipos[5], Tipos[14], R.drawable.haunter_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("94", "Gengar",  Tipos[5], Tipos[14], R.drawable.gengar_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("95", "Onix",  Tipos[12], Tipos[13], R.drawable.onix_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("96", "Drowzee",  Tipos[11], Tipos[0], R.drawable.drowzee_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("97", "Hypno",  Tipos[11], Tipos[0], R.drawable.hypno_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("98", "Krabby",  Tipos[1], Tipos[0], R.drawable.krabby_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("99", "Kingler",  Tipos[1], Tipos[0], R.drawable.kingler_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("100", "Voltorb",  Tipos[4], Tipos[0], R.drawable.voltorb_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("101", "Electrode",  Tipos[4], Tipos[0], R.drawable.electrode_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("102", "Exeggcute",  Tipos[10], Tipos[11], R.drawable.exeggcute_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("103", "Exeggutor",  Tipos[10], Tipos[11], R.drawable.exeggutor_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("104", "Cubone",  Tipos[13], Tipos[0], R.drawable.cubone_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("105", "Marowak",  Tipos[13], Tipos[0], R.drawable.marowak_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("106", "Hitmonlee",  Tipos[8], Tipos[0], R.drawable.hitmonlee_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("107", "Hitmonchan",  Tipos[8], Tipos[0], R.drawable.hitmonchan_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("108", "Lickitung",  Tipos[9], Tipos[0], R.drawable.lickitung_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("109", "Koffing",  Tipos[14], Tipos[0], R.drawable.koffing_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("110", "Weezing",  Tipos[14], Tipos[0], R.drawable.weezing_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("111", "Rhyhorn",  Tipos[13], Tipos[12], R.drawable.rhyhorn_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("112", "Rhydon",  Tipos[13], Tipos[12], R.drawable.rhydon_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("113", "Chansey",  Tipos[9], Tipos[0], R.drawable.chansey_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("114", "Tangela",  Tipos[10], Tipos[0], R.drawable.tangela_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("115", "Kangaskhan",  Tipos[9], Tipos[0], R.drawable.kangaskhan_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("116", "Horsea",  Tipos[1], Tipos[0], R.drawable.horsea_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("117", "Seadra",  Tipos[1], Tipos[0], R.drawable.seadra_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("118", "Goldeen",  Tipos[1], Tipos[0], R.drawable.goldeen_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("119", "Seaking",  Tipos[1], Tipos[0], R.drawable.seaking_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("120", "Staryu",  Tipos[1], Tipos[0], R.drawable.staryu_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("121", "Starmie",  Tipos[1], Tipos[11], R.drawable.starmie_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("122", "Mr. Mime",  Tipos[11], Tipos[0], R.drawable.mr_mime_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("123", "Scyther",  Tipos[2], Tipos[15], R.drawable.scyther_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("124", "Jynx",  Tipos[7], Tipos[11], R.drawable.jynx_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("125", "Electabuzz",  Tipos[4], Tipos[0], R.drawable.electabuzz_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("126", "Magmar",  Tipos[6], Tipos[0], R.drawable.magmar_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("127", "Pinsir",  Tipos[2], Tipos[0], R.drawable.pinsir_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("128", "Tauros",  Tipos[9], Tipos[0], R.drawable.charizard_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("129", "Magikarp",  Tipos[1], Tipos[0], R.drawable.magikarp_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("130", "Gyarados",  Tipos[1], Tipos[15], R.drawable.gyarados_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("131", "Lapras",  Tipos[1], Tipos[7], R.drawable.lapras_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("132", "Ditto",  Tipos[9], Tipos[0], R.drawable.ditto_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("133", "Eevee",  Tipos[9], Tipos[0], R.drawable.eevee_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("134", "Vaporeon",  Tipos[1], Tipos[0], R.drawable.vaporeon_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("135", "Jolteon",  Tipos[4], Tipos[0], R.drawable.jolteon_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("136", "Flareon",  Tipos[6], Tipos[0], R.drawable.flareon_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("137", "Porygon",  Tipos[9], Tipos[0], R.drawable.porygon_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("138", "Omanyte",  Tipos[12], Tipos[1], R.drawable.omanyte_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("139", "Omastar",  Tipos[12], Tipos[1], R.drawable.omastar_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("140", "Kabuto",  Tipos[12], Tipos[1], R.drawable.kabuto_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("141", "Kabutops",  Tipos[12], Tipos[1], R.drawable.kabutops_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("142", "Aerodactyl",  Tipos[12], Tipos[15], R.drawable.aerodactyl_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("143", "Snorlax",  Tipos[9], Tipos[0], R.drawable.snorlax_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("144", "Articuno",  Tipos[7], Tipos[15], R.drawable.articuno_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("145", "Zapdos",  Tipos[4], Tipos[15], R.drawable.zapdos_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("146", "Moltres",  Tipos[6], Tipos[15], R.drawable.moltres_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("147", "Dratini",  Tipos[3], Tipos[15], R.drawable.dratini_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("148", "Dragonair",  Tipos[3], Tipos[15], R.drawable.dragonair_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("149", "Dragonite",  Tipos[3], Tipos[15], R.drawable.dragonite_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("150", "Mewtwo",  Tipos[11], Tipos[0], R.drawable.mewtwo_seeklogo_com, "", ""));
        ListPokemon.add(new Pokemon("151", "Mew",  Tipos[11], Tipos[0], R.drawable.mew_seeklogo_com, "", ""));

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

        int filtre = item.getItemId();

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

    private void filtreLlista(int filtre) {

        // Respond to the action bar's Up/Home button
        if (filtre == R.id.ninguno) {
            ListPokemonFiltrat.clear();
            ListPokemonFiltrat.addAll(ListPokemon);

            adaptador.notifyDataSetChanged();
        } else {
            ListPokemonFiltrat.clear();

            for (int i = 0; i < ListPokemon.size(); i++) {
                if (ListPokemon.get(i).getTipo1().getId() == filtre || ListPokemon.get(i).getTipo2().getId() == filtre) {

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
        Intent i = new Intent(this, Game.class);

        i.putExtra("pokemons", ListPokemon);

        startActivity(i);
    }
}