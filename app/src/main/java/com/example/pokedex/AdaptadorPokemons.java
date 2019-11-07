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

        int[] imgs = new int[] {
                R.drawable.ic_bulbasaur,
                R.drawable.ic_ivysaur,
                R.drawable.ic_venusaur,
                R.drawable.ic_charmander
        };

        Pokemon pokemon = getItem(position);

        ImageView ivIcon = item.findViewById(R.id.ivIcon);
        ivIcon.setImageResource(imgs[position]);

        TextView tvNom = item.findViewById(R.id.tvNom);
        tvNom.setText(pokemon.getNom());

        TextView tvTipo1 = item.findViewById(R.id.tvTipo1);
        tvTipo1.setText(pokemon.getTipo1());

        TextView tvTipo2 = item.findViewById(R.id.tvTipo2);
        tvTipo2.setText(pokemon.getTipo2());

        TextView tvHabilitat = item.findViewById(R.id.tvHabilitat);
        tvHabilitat.setText(pokemon.getHabilidad());

        return(item);
    }
}
