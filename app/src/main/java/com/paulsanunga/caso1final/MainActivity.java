package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.paulsanunga.caso1final.Model.Client;
import com.paulsanunga.caso1final.Utils.Apis;
import com.paulsanunga.caso1final.Utils.ClientService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ClientService service;
    public static Client client = new Client();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText username = findViewById(R.id.editTextLoginUsername);
        EditText password = findViewById(R.id.editTextLoginPassword);
        Button btnLogin = findViewById(R.id.btnIngresar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service = Apis.getClientService();
                Call<Client> call = service.loginClient(username.getText().toString(),password.getText().toString());
                call.enqueue(new Callback<Client>() {
                    @Override
                    public void onResponse(Call<Client> call, Response<Client> response) {
                        if (response.body()!=null){
                            client = response.body();
                            Toast.makeText(MainActivity.this, "Se Loggeo Correctamente",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this,PerfilActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<Client> call, Throwable t) {
                        Log.e("Error: ",t.getMessage());
                        Toast.makeText(MainActivity.this, "Este Usuario No se encuentra registrado",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        Button btnRegistrarse = findViewById(R.id.btnRegistrarse);
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}