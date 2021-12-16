package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalleVehiculo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_vehiculo);

        TextView txtViewMarcaInd = findViewById(R.id.txtViewMarcaInd);
        TextView txtViewModeloInd = findViewById(R.id.txtViewModeloInd);
        TextView txtViewDescInd = findViewById(R.id.txtViewDescInd);
        ImageView imagenView = (ImageView) findViewById(R.id.ImgVehiculoDetalle);
        Button btnBack = findViewById(R.id.regresarbtn);


        Bundle bn = getIntent().getExtras();
        String marca = bn.getString("marca");
        String modelo = bn.getString("modelo");
        String descripcion = bn.getString("descripcion");
        String imagen = bn.getString("imagen");
        System.out.println("imagen que me deberia pasar "+imagen);
        Picasso.with(this)
                .load(imagen)
                .error(R.mipmap.ic_launcher).into(imagenView);

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