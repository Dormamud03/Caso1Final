package com.paulsanunga.caso1final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_vehiculo);

        Button regresarbtn = findViewById(R.id.regresarbtn);
        Button cotizar = findViewById(R.id.btnCotizarVehiculo);

        cotizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CotizacionVehiculo.class);
                startActivity(intent);
            }
        });

        regresarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),CatalogoVehiculo.class);
                startActivity(intent);
            }
        });
    }
}
