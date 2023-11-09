package com.example.proyectoprototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class publicar extends AppCompatActivity {

    ImageButton volverabusqueda;
    Button finalizado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar);

        volverabusqueda = findViewById(R.id.volver3);
        volverabusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), busqueda.class);
                startActivity(intent);
            }
        });

        //desde este boton se deben mandar las wias pa la BD y que al volver a la busqueda, aparezca al buscar
        finalizado = findViewById(R.id.bpublicarlisto);
        finalizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), busqueda.class);
                startActivity(intent);
            }
        });
    }
}