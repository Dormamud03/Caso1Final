package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_vehiculo);

        TextView txtViewMarcaInd = findViewById(R.id.txtViewMarcaInd);
        TextView txtViewModeloInd = findViewById(R.id.txtViewModeloInd);
        TextView txtViewDescInd = findViewById(R.id.txtViewDescInd);
        Button btnBack = findViewById(R.id.regresarbtn);


        Bundle bn = getIntent().getExtras();
        String marca = bn.getString("marca");
        String modelo = bn.getString("modelo");
        String descripcion = bn.getString("descripcion");

        txtViewMarcaInd.setText(marca);
        txtViewModeloInd.setText(modelo);
        txtViewDescInd.setText(descripcion);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}