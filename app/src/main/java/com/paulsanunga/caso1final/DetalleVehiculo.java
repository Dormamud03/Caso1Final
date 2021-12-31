package com.paulsanunga.caso1final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.paulsanunga.caso1final.Utils.Apis;
import com.paulsanunga.caso1final.Utils.CatalogoVehiculosService;
import com.paulsanunga.caso1final.Utils.CotizacionService;
import com.squareup.picasso.Picasso;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleVehiculo extends AppCompatActivity {
    CotizacionService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_vehiculo);

        TextView txtViewMarcaInd = findViewById(R.id.txtViewMarcaInd);
        TextView txtViewModeloInd = findViewById(R.id.txtViewModeloInd);
        TextView txtViewDescInd = findViewById(R.id.txtViewDescInd);
        ImageView imagenView = (ImageView) findViewById(R.id.ImgVehiculoDetalle);
        Button btnBack = findViewById(R.id.regresarbtn);
        Button btnCotizar = findViewById(R.id.btnCotizarVehiculo);


        Bundle bn = getIntent().getExtras();
        String nombreCli = MainActivity.client.getNombresClient();
        String emailClient = MainActivity.client.getEmailClient();
        long id=bn.getLong("catalogoId");
        String marca = bn.getString("marca");
        String modelo = bn.getString("modelo");
        String descripcion = bn.getString("descripcion");
        String imagen = bn.getString("imagen");
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

        btnCotizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder  builder = new AlertDialog.Builder(DetalleVehiculo.this);
                builder.setTitle("Aviso");
                builder.setMessage("La cotizacion sera enviada a su correo");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*Intent intent = new Intent(DetalleVehiculo.this,CatalogoVehiculo.class);
                        startActivity(intent);*/
                        finish();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
                service = Apis.getCotizarService();
                Call<String> call = service.getCotizacion(id,nombreCli,emailClient);
                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        System.out.println("Todo Listo");
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        System.out.println(t.getMessage());
                    }
                });
            }
        });

    }
}