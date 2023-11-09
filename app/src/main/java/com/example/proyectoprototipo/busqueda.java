package com.example.proyectoprototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Locale;

public class busqueda extends AppCompatActivity {

    ImageButton volverlogin;
    Button publicacion;

    //lo del micro
    ImageButton microfono;
    SearchView bbusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        //lo de volver / botones
        volverlogin = findViewById(R.id.volver2);
        volverlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        publicacion = findViewById(R.id.bpublicar);
        publicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), publicar.class);
                startActivity(intent);
            }
        });

        //lo de micro
    }
}