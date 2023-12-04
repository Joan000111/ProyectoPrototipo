package com.example.proyectoprototipo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class resultado extends AppCompatActivity {

    private List<Libro> ListLibro = new ArrayList<Libro>();
    ArrayAdapter<Libro> arrayAdapterLibro;
    ListView lvListadoLibros;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    ImageButton volverabusqueda;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        inicializarFireBase();

        lvListadoLibros=findViewById(R.id.lista_libros);

        volverabusqueda = findViewById(R.id.bsalirderesultado);
        volverabusqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), busqueda.class);
                startActivity(intent);
            }
        });

        String nl = getIntent().getStringExtra("nombrelibro");
        String na = getIntent().getStringExtra("nombreautor");

        Libro libro = new Libro();


        if (nl == "" || na == ""){
            listarDatos();
        }
        else{
            libro.setID(UUID.randomUUID().toString());
            libro.setNombre(nl);
            libro.setAutor(na);

            databaseReference.child("Libro").child(libro.getID()).setValue(libro);
            listarDatos();
        }


    }

    private void listarDatos() {
        databaseReference.child("Libro").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ListLibro.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    Libro li =objs.getValue(Libro.class);
                    ListLibro.add(li);
                    arrayAdapterLibro =new ArrayAdapter<Libro>(resultado.this, android.R.layout.simple_expandable_list_item_1,ListLibro);
                    lvListadoLibros.setAdapter(arrayAdapterLibro);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }
}