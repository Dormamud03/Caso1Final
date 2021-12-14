package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paulsanunga.caso1final.Model.Client;
import com.paulsanunga.caso1final.Utils.Apis;
import com.paulsanunga.caso1final.Utils.ClientService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilActivity extends AppCompatActivity {
    ClientService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Client clientEdit = MainActivity.client;
        EditText cedulaPerfil = findViewById(R.id.editTextCedulaper);
        EditText nombrePerfil = findViewById(R.id.editTextNombreper);
        EditText emailPerfil = findViewById(R.id.editTextEmailEdit);
        EditText celularPerfil = findViewById(R.id.editTextcelularper);
        EditText direccionPerfil = findViewById(R.id.editTextdireccionper);
        Button actualizarDatos = findViewById(R.id.btnActualizarDatos);
        Button cambiarContrania = findViewById(R.id.btnCambiarContraseniaDesdePerfil);
        Button back = findViewById(R.id.butRegresarPerfilUsuario);


        cedulaPerfil.setText(clientEdit.getCedulaClient());
        nombrePerfil.setText(clientEdit.getNombresClient());
        emailPerfil.setText(clientEdit.getEmailClient());
        celularPerfil.setText(clientEdit.getCelularClient());
        direccionPerfil.setText(clientEdit.getDireccionClient());


        actualizarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //revisar validacion eficaz no llega al else
                if (clientEdit.getNombresClient()!=nombrePerfil.getText().toString()||clientEdit.getEmailClient()!=emailPerfil.getText().toString()
                ||clientEdit.getCelularClient()!=celularPerfil.getText().toString()||clientEdit.getDireccionClient()!=direccionPerfil.getText().toString()){
                    clientEdit.setNombresClient(nombrePerfil.getText().toString());
                    clientEdit.setEmailClient(emailPerfil.getText().toString());
                    clientEdit.setCelularClient(celularPerfil.getText().toString());
                    clientEdit.setDireccionClient(direccionPerfil.getText().toString());

                    editClient(clientEdit);
                    Toast.makeText(PerfilActivity.this, "Se edito Correctamente",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(PerfilActivity.this, "No ha editado ningun campo",Toast.LENGTH_LONG).show();
                }


            }
        });

        cambiarContrania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PerfilActivity.this,CambiarContrasenia.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
    public void editClient(Client c){
        service = Apis.getClientService();
        Call<Client> call = service.addClient(c);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if (response!=null){
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("Error: ",t.getMessage());

            }
        });
    }
}