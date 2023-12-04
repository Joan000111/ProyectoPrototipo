package com.example.proyectoprototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Locale;

public class busqueda extends AppCompatActivity {

    ImageButton volverlogin;
    Button publicacion, buscar;

    //lo del micro Y MAPA
    ImageButton microfono, estrella;
    SearchView bbusqueda;

    //info de la sesion
    FirebaseAuth auth;
    TextView nombreusuario;
    Button cerrar;
    FirebaseUser user;
    FirebaseAuth mAuth;

    //pa saber si el pana ya estaba iniciado
    /*
    @Override
    public void onStart() {
        mAuth = FirebaseAuth.getInstance();
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(
                    getApplicationContext(),
                    busqueda.class
            );
            startActivity(intent);
            finish();
        }
    }*/

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        auth = FirebaseAuth.getInstance();
        nombreusuario = findViewById(R.id.usuarioactual);
        cerrar = findViewById(R.id.bcerrarsesion);
        user = auth.getCurrentUser();

        estrella = findViewById(R.id.imestrella);
        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        mapa.class
                );

            String direccion = "-34.78127778,-71.03747222";

            String[] direc = direccion.split(",");
            String longitude = direc[0];
            String latitude = direc[1];

            double primeralong = Double.parseDouble(longitude.toString());
            double primeralati = Double.parseDouble(latitude.toString());

            intent.putExtra("lo1", primeralong);
            intent.putExtra("la1", primeralati);
            startActivity(intent);

            }

        });

        if(user == null){
            Intent intent = new Intent(
                    getApplicationContext(),
                    MainActivity.class
            );
            startActivity(intent);
            finish();
        }
        else{
            nombreusuario.setText(user.getEmail()); //me gustaría cambiarlo al nombre
        }

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
                finish();
            }
        });



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

        buscar = findViewById(R.id.bbuscar);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), resultado.class);
                startActivity(intent);
            }
        });

        //lo de micro
    }
}