package com.example.proyectoprototipo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button ingresarr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ingresarr = findViewById(R.id.ingresar);
        ingresarr.setOnClickListener(new View.OnClickListener() {
            //aqui tambien habria que validar el tema del login
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        busqueda.class
                );
                startActivity(intent);
            }
        });
    }
}