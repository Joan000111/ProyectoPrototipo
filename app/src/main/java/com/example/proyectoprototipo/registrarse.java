package com.example.proyectoprototipo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

public class registrarse extends AppCompatActivity {

    Button finalizarreg;
    ImageButton volveramain;
    EditText recorreo, reusuario, recontrasena;
    FirebaseAuth mAuth;

    //pa saber si ya se esta loggeado
    @Override
    public void onStart() {
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        mAuth = FirebaseAuth.getInstance(); //inicializada la bd

        finalizarreg = findViewById(R.id.bregistrocompleto);
        volveramain = findViewById(R.id.volver6);

        recorreo = findViewById(R.id.editcorreonuevo);
        recontrasena = findViewById(R.id.editcontrasenanueva);
        reusuario = findViewById(R.id.editusuarionuevo);
        finalizarreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //variables
                String nombre, correo, contrasena;
                nombre = String.valueOf(reusuario.getText());
                correo = String.valueOf(recorreo.getText());
                contrasena = String.valueOf(recontrasena.getText());

                if(TextUtils.isEmpty(nombre)){
                    Toast.makeText(registrarse.this, "Ingrese un nombre de usuario", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(correo)){
                    Toast.makeText(registrarse.this, "Ingrese el correo", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(contrasena)){
                    Toast.makeText(registrarse.this, "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                //basededatooOos
                mAuth.createUserWithEmailAndPassword(correo, contrasena)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(registrarse.this, "Cuenta Creada.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(registrarse.this, "Autentificacion Fallida.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


                //pa que inscriba y se mande alv altoque
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
            }
        });
        volveramain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
            }
        });
        // los dos botones hacen lo mismo pero el volver obvio no guarda informacion
    }
}