package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.paulsanunga.caso1final.Model.Client;

public class PerfilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Client clientEdit = MainActivity.client;
        System.out.println(clientEdit.getEmailClient());
        EditText cedulaPerfil = findViewById(R.id.editTextCedulaper);
        EditText nombrePerfil = findViewById(R.id.editTextNombreper);
        EditText emailPerfil = findViewById(R.id.editTextEmailEdit);
        EditText celularPerfil = findViewById(R.id.editTextcelularper);
        EditText direccionPerfil = findViewById(R.id.editTextdireccionper);

        cedulaPerfil.setText(clientEdit.getCedulaClient());
        nombrePerfil.setText(clientEdit.getNombresClient());
        emailPerfil.setText(clientEdit.getEmailClient());
        celularPerfil.setText(clientEdit.getCelularClient());
        direccionPerfil.setText(clientEdit.getDireccionClient());

    }
}