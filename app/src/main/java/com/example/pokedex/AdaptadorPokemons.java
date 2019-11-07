package com.example.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class AdaptadorPokemons extends ArrayAdapter<Pokemon> {

    public AdaptadorPokemons(Context context, Pokemon[] datos) {
        super(context, R.layout.layout_pokemon, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_pokemon, null);

        Pokemon pokemon = getItem(position);

        ImageView ivIcon = item.findViewById(R.id.ivIcon);
        ivIcon.setImageResource(R.drawable.ic_bulbasaur);

        TextView tvNom = item.findViewById(R.id.tvNom);
        tvNom.setText(pokemon.getNom());

        TextView tvTipo1 = item.findViewById(R.id.tvTipo1);
        tvNom.setText(pokemon.getNom());

        TextView tvTipo2 = item.findViewById(R.id.tvTipo2);
        tvNom.setText(pokemon.getNom());

        TextView tvtvHabilitat = item.findViewById(R.id.tvHabilitat);
        tvNom.setText(pokemon.getNom());

        return(item);
    }
}
