package com.paulsanunga.caso1final;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.paulsanunga.caso1final.Model.Client;
import com.paulsanunga.caso1final.Utils.Apis;
import com.paulsanunga.caso1final.Utils.ClientService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ClientService service;
    EditText txtCedula;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        txtCedula =findViewById(R.id.editTextCedula);
        EditText txtNombre = (EditText) findViewById(R.id.editTextNombre);
        EditText txtContrasenia = (EditText) findViewById(R.id.editTextContrasenia);
        EditText txtEmail = (EditText) findViewById(R.id.editTextEmailEdit);
        EditText txtCelular = (EditText) findViewById(R.id.editTextCelular);
        EditText txtDireccion = (EditText) findViewById(R.id.editTextDireccion);

        Button btnSave = (Button) findViewById(R.id.btnGuardar);
        Button btnCancel = (Button) findViewById(R.id.btnCancelar);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCedula.getText().toString().isEmpty()){
                    Toast.makeText(RegisterActivity.this, "El campo cedula es obligatorio",Toast.LENGTH_LONG).show();
                }else{
                    if (txtNombre.getText().toString().isEmpty()){
                        Toast.makeText(RegisterActivity.this, "El campo nombre es obligatorio",Toast.LENGTH_LONG).show();
                    }else {
                        if (txtContrasenia.getText().toString().isEmpty()){
                            Toast.makeText(RegisterActivity.this, "El campo contraseña es obligatorio",Toast.LENGTH_LONG).show();
                        }else{
                            if (txtEmail.getText().toString().isEmpty()){
                                Toast.makeText(RegisterActivity.this, "El campo email es obligatorio",Toast.LENGTH_LONG).show();
                            }else {
                                if (txtCelular.getText().toString().isEmpty()){
                                    Toast.makeText(RegisterActivity.this, "El campo celular es obligatorio",Toast.LENGTH_LONG).show();
                                }else{
                                    if (txtDireccion.getText().toString().isEmpty()){
                                        Toast.makeText(RegisterActivity.this, "El campo direccion es obligatorio",Toast.LENGTH_LONG).show();
                                    }else{

                                        Client p = new Client();
                                        p.setCedulaClient(txtCedula.getText().toString());
                                        p.setNombresClient(txtNombre.getText().toString());
                                        p.setEmailClient(txtEmail.getText().toString());
                                        p.setCelularClient(txtCelular.getText().toString());
                                        p.setDireccionClient(txtDireccion.getText().toString());
                                        p.setPasswordClient(txtContrasenia.getText().toString());

                                        addCliente(p);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    public void addCliente(Client c){
        service = Apis.getClientService();
        Call<List<Client>> call = service.getClient();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                boolean validacion= false;
                for (int i = 0; i < response.body().size(); i++) {
                    System.out.println(response.body().get(i).getCedulaClient());
                    if (txtCedula.getText().toString().equals(response.body().get(i).getCedulaClient())){
                        validacion = true;
                    }
                }
                if (!validacion){
                    service.addClient(c);
                    Call <Client> callIngresar = service.addClient(c);
                    callIngresar.enqueue(new Callback<Client>() {
                        @Override
                        public void onResponse(Call<Client> call, Response<Client> response) {
                            Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                            startActivity(intent);
                            Toast.makeText(RegisterActivity.this, "El cliente se ingreso Correctamente",Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onFailure(Call<Client> call, Throwable t) {

                        }
                    });
                }else{
                    Toast.makeText(RegisterActivity.this, "El cliente Ingresado ya esta en la base de datos",Toast.LENGTH_LONG).show();
                }

            }
            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {

            }
        });

    }
}
