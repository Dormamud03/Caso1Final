package com.paulsanunga.caso1final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CotizacionVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cotizacion_layout);

        Button regresarCoti = findViewById(R.id.regresarbtnCotizacion);

        regresarCoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetalleVehiculo.class);
                startActivity(intent);
            }
        });
    }
}
