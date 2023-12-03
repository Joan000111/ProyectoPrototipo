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
import android.widget.TextView;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Locale;

public class busqueda extends AppCompatActivity {

    ImageButton volverlogin;
    Button publicacion, buscar;

    //lo del micro
    ImageButton microfono;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busqueda);

        auth = FirebaseAuth.getInstance();
        nombreusuario = findViewById(R.id.usuarioactual);
        cerrar = findViewById(R.id.bcerrarsesion);
        user = auth.getCurrentUser();
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