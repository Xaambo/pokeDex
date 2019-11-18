package com.example.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

class AdaptadorPokemons extends ArrayAdapter<Pokemon> {

    public AdaptadorPokemons(Context context, Pokemon[] datos) {
        super(context, R.layout.layout_pokemon, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_pokemon, null);

        Tipo tipo1;
        Tipo tipo2;
        Pokemon pokemon = getItem(position);

        tipo2 = pokemon.getTipo2();

        TextView tvId = item.findViewById(R.id.tvId);
        tvId.setText("#" + pokemon.getId());

        ImageView ivIcon = item.findViewById(R.id.ivIcon);
        ivIcon.setImageResource(pokemon.getFoto());

        TextView tvNom = item.findViewById(R.id.tvNom);
        tvNom.setText(pokemon.getNom());

        ImageView ivTipo1 = item.findViewById(R.id.ivTipo1);
        ivTipo1.setImageResource(pokemon.getTipo1().getFoto());

        if (!tipo2.getNom().equals("")) {

            ImageView ivTipo2 = item.findViewById(R.id.ivTipo2);
            ivTipo2.setImageResource(pokemon.getTipo2().getFoto());
        } else {

            ImageView ivTipo2 = item.findViewById(R.id.ivTipo2);
            ivTipo2.setVisibility(View.GONE);
        }

        return(item);
    }
}