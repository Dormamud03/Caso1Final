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
import com.paulsanunga.caso1final.Utils.Encrypt;

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
                                        if (isEcuadorianDocumentValid(txtCedula.getText().toString())){
                                            Client p = new Client();
                                            p.setCedulaClient(txtCedula.getText().toString());
                                            p.setNombresClient(txtNombre.getText().toString());
                                            p.setEmailClient(txtEmail.getText().toString());
                                            p.setCelularClient(txtCelular.getText().toString());
                                            p.setDireccionClient(txtDireccion.getText().toString());
                                            p.setPasswordClient(new Encrypt().getAES(txtContrasenia.getText().toString()));

                                            addCliente(p);
                                        }else{
                                            Toast.makeText(RegisterActivity.this, "La cedula no es correcta",Toast.LENGTH_LONG).show();
                                        }

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
    private boolean isEcuadorianDocumentValid(String document) {
        byte sum = 0;
        try {
            if (document.trim().length() != 10)
                return false;
            String[] data = document.split("");
            byte verifier = Byte.parseByte(data[0] + data[1]);
            if (verifier < 1 || verifier > 24)
                return false;
            byte[] digits = new byte[data.length];
            for (byte i = 0; i < digits.length; i++)
                digits[i] = Byte.parseByte(data[i]);
            if (digits[2] > 6)
                return false;
            for (byte i = 0; i < digits.length - 1; i++) {
                if (i % 2 == 0) {
                    verifier = (byte) (digits[i] * 2);
                    if (verifier > 9)
                        verifier = (byte) (verifier - 9);
                } else
                    verifier = (byte) (digits[i] * 1);
                sum = (byte) (sum + verifier);
            }
            if ((sum - (sum % 10) + 10 - sum) == digits[9])
                return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
