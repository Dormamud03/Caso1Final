package com.paulsanunga.caso1final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class CatalogoVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        Button btnVerDetalle = findViewById(R.id.btnVerDetalle);
        btnVerDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DetalleVehiculo.class);
                startActivity(intent);
            }
        });

        ImageButton imgVerPerfil = findViewById(R.id.imgBtnUser);
        imgVerPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PerfilUsuario.class);
                startActivity(intent);
            }
        });
    }
}
