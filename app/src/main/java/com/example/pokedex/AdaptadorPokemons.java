package com.example.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

class AdaptadorPokemons extends ArrayAdapter<Pokemon> {

    public AdaptadorPokemons(Context context, Pokemon[] datos) {
        super(context, R.layout.layout_pokemon, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_pokemon, null);

        Pokemon pokemon = (Pokemon) getItem(position);



        return(item);
    }
}
