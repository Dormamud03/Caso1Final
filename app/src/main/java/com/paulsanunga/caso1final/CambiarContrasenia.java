package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;

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

public class CambiarContrasenia extends AppCompatActivity {
    ClientService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambiar_contrasenia_layout);
        Client clientEditContrasenia = MainActivity.client;

        EditText contraseniaAntigua = findViewById(R.id.editTextContraseniaAntigua);
        EditText contraseniaNueva = findViewById(R.id.editTextContresniaNueva);
        EditText contraseniaNuevaRepetida = findViewById(R.id.editTextContraseniaRepetidaNueva);

        Button actualizarContrasenia = findViewById(R.id.btnActulizarContrasenia);

        actualizarContrasenia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clientEditContrasenia.getPasswordClient().equals(contraseniaAntigua.getText().toString())){
                    if (contraseniaNueva.getText().toString().equals(contraseniaNuevaRepetida.getText().toString())){
                        clientEditContrasenia.setPasswordClient(contraseniaNueva.getText().toString());
                        editClient(clientEditContrasenia);
                        Toast.makeText(CambiarContrasenia.this, "Se edito Correctamente",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(CambiarContrasenia.this, "No coinciden las contraseñas",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(CambiarContrasenia.this, "Esa contraseña es incorrecta",Toast.LENGTH_LONG).show();
                }

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