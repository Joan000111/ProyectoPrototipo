package com.example.proyectoprototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class publicar extends AppCompatActivity {

    ImageButton volverabusqueda;
    Button finalizado;
    //tengo que leer los valores para mandarlo a la otra act con la lista y firebase
    EditText eTNombre,eTAutor;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar);

        //los valores aca
        eTNombre=findViewById(R.id.ettitulo);
        eTAutor=findViewById(R.id.etautor);

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
                Libro libro = new Libro();
                libro.setID(UUID.randomUUID().toString());
                libro.setNombre(eTNombre.getText().toString());
                libro.setAutor(eTAutor.getText().toString());
                databaseReference.child("Libro").child(libro.getID()).setValue(libro);

                Intent intent = new Intent(getApplicationContext(), busqueda.class);
                startActivity(intent);
            }
        });

    }
}