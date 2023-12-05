package com.example.proyectoprototipo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button ingresarr, registrarse;
    EditText iniciocorreo, iniciocontrasena;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        ingresarr = findViewById(R.id.ingresar);
        registrarse = findViewById(R.id.bregistrarse);

        iniciocorreo = findViewById(R.id.editcorreoinicio);
        iniciocontrasena = findViewById(R.id.editcontrasenainicio);

        ingresarr.setOnClickListener(new View.OnClickListener() {
            //aqui tambien habria que validar el tema del login
            @Override
            public void onClick(View view) {
                //variables
                String correo, contrasena;
                correo = String.valueOf(iniciocorreo.getText());
                contrasena = String.valueOf(iniciocontrasena.getText());

                if(TextUtils.isEmpty(correo)){
                    Toast.makeText(MainActivity.this, "Ingrese el correo", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(contrasena)){
                    Toast.makeText(MainActivity.this, "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                //now the fire documentationn pal login
                mAuth.signInWithEmailAndPassword(correo, contrasena)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Ingreso Exitoso",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(
                                            getApplicationContext(),
                                            busqueda.class
                                    );
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(MainActivity.this, "Fallidp",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                //aqui iba el intent inicial
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        com.example.proyectoprototipo.registrarse.class
                );
                startActivity(intent);
            }
        });
    }
}