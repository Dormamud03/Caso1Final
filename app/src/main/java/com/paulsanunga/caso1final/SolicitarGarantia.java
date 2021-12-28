package com.paulsanunga.caso1final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paulsanunga.caso1final.Model.Garantia;
import com.paulsanunga.caso1final.Utils.Apis;
import com.paulsanunga.caso1final.Utils.MisVehiculosService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SolicitarGarantia extends AppCompatActivity {
    MisVehiculosService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_garantia);
        EditText descripcionProblemas = findViewById(R.id.txtDescripProblemas);
        Button btnBack = findViewById(R.id.regresarbtnGarantia);
        Button garantia = findViewById(R.id.btnSolicitarGarantia);
        Bundle bn = getIntent().getExtras();
        String chasis = bn.getString("chasis");
        String desPro = descripcionProblemas.getText().toString();
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        garantia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (descripcionProblemas.getText().toString().isEmpty()){
                    Toast.makeText(SolicitarGarantia.this, "Es obligatorio describir el problema presentado",Toast.LENGTH_LONG).show();
                }else{
                    Garantia g = new Garantia();
                    g.setFk_chasis_vehiculo(chasis);
                    g.setDescripcion(desPro);
                    g.setFecha_solicitud(date);
                    addGarantia(g);
                }
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void addGarantia(Garantia g){
        service = Apis.getMisVehiculosService();
        Call<Garantia> call = service.postGarantia(g);
        call.enqueue(new Callback<Garantia>() {
            @Override
            public void onResponse(Call<Garantia> call, Response<Garantia> response) {
                AlertDialog.Builder  builder = new AlertDialog.Builder(SolicitarGarantia.this);
                builder.setTitle("Aviso");
                builder.setMessage("Solicitud enviada, a su correo le llegará la confirmacion o rechazo de la misma");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SolicitarGarantia.this,MisVehiculos.class);
                        startActivity(intent);
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }

            @Override
            public void onFailure(Call<Garantia> call, Throwable t) {

            }
        });
    }
}