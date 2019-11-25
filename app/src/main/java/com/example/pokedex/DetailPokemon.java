package com.example.pokedex;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class DetailPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detailpokemon);

        Bundle extras = getIntent().getExtras();
        final Pokemon pokemon = (Pokemon) extras.getSerializable("pokemon");

        Tipo tipo2 = pokemon.getTipo2();

        ImageView ivDIcon = findViewById(R.id.iconDetail);
        ivDIcon.setImageResource(pokemon.getFoto());

        ImageView ivDTipo = findViewById(R.id.ivDTipo);
        ivDTipo.setImageResource(pokemon.getTipo1().getFoto());

        if (!tipo2.getNom().equals("")) {

            ImageView ivDTipo2 = findViewById(R.id.ivDTipo2);
            ivDTipo2.setImageResource(pokemon.getTipo2().getFoto());
        } else {

            ImageView ivDTipo2 = findViewById(R.id.ivDTipo2);
            ivDTipo2.setVisibility(View.GONE);
        }

        TextView tvDNom = findViewById(R.id.tvDNom);
        tvDNom.setText(pokemon.getNom());

        Button btnWeb = findViewById(R.id.btnWeb);
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*verifiarPermisosInternet();*/

                String url = "https://www.wikidex.net/wiki/" + pokemon.getNom();

                Uri webpage = Uri.parse(url);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                startActivity(webIntent);
            }
        });

        Button btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent i = new Intent();

            i.setAction(Intent.ACTION_SEND);

            String dadesPokemon = "PokéDex ID: #" + pokemon.getId() + "\nNom: " + pokemon.getNom() + "\nTipos: " + pokemon.getTipo1().getNom() + " i " + pokemon.getTipo2().getNom();

            i.putExtra(Intent.EXTRA_TEXT, dadesPokemon);
            i.setType("text/plain");
            startActivity(i);
            }
        });

        Button btnAtras = findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /*private void verifiarPermisosInternet() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        0);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }
    }*/
}
