package com.paulsanunga.caso1final;

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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ClientService service;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        EditText txtCedula = (EditText) findViewById(R.id.editTextCedula);
        EditText txtNombre = (EditText) findViewById(R.id.editTextNombre);
        EditText txtContrasenia = (EditText) findViewById(R.id.editTextContrasenia);
        EditText txtEmail = (EditText) findViewById(R.id.editTextEmailEdit);
        EditText txtCelular = (EditText) findViewById(R.id.editTextCelular);
        EditText txtDireccion = (EditText) findViewById(R.id.editTextDireccion);

        Button btnSave = (Button) findViewById(R.id.btnGuardar);
        Button btnCancel = (Button) findViewById(R.id.btnCancelar);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Client p = new Client();
                p.setCedulaClient(txtCedula.getText().toString());
                p.setNombresClient(txtNombre.getText().toString());
                p.setEmailClient(txtEmail.getText().toString());
                p.setCelularClient(txtCelular.getText().toString());
                p.setDireccionClient(txtDireccion.getText().toString());
                p.setPasswordClient(txtContrasenia.getText().toString());

                addCliente(p);

            }
        });
    }

    public void addCliente(Client c){
        service = Apis.getClientService();
        Call<Client> call = service.addClient(c);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if (response!=null){
                    Toast.makeText(RegisterActivity.this, "Se Agrego con exito",Toast.LENGTH_LONG).show();
                    System.out.println(response.body());
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("Error: ",t.getMessage());

            }
        });
    }
}
