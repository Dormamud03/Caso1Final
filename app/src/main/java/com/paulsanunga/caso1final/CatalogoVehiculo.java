package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paulsanunga.caso1final.Adaptadores.ListaVehiculosAdapter;
import com.paulsanunga.caso1final.Model.CatalogoVehiculos;
import com.paulsanunga.caso1final.Model.Client;
import com.paulsanunga.caso1final.Utils.Apis;
import com.paulsanunga.caso1final.Utils.CatalogoVehiculosService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogoVehiculo extends AppCompatActivity {
    CatalogoVehiculosService service;
    List<CatalogoVehiculos> listArrayCatalogo;
    RecyclerView listVehiculos;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo_vehiculo);
        listVehiculos = findViewById(R.id.listVehiculos);
        mostrarCatalogoVehiculos();
        System.out.println("despues "+listArrayCatalogo);
        Button btnPerfil = findViewById(R.id.btnPerfil);
        btnPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogoVehiculo.this,PerfilActivity.class);
                startActivity(intent);
            }
        });


    }

    public void mostrarCatalogoVehiculos(){

        service = Apis.getCatalogoVehiculosService();
        Call<List<CatalogoVehiculos>> call = service.getCatalogo();
        call.enqueue(new Callback<List<CatalogoVehiculos>>() {
            @Override
            public void onResponse(Call<List<CatalogoVehiculos>> call, Response<List<CatalogoVehiculos>> response) {
                if (response.body()!=null){
                    listVehiculos.setLayoutManager(new LinearLayoutManager(context));
                    ListaVehiculosAdapter adapter = new ListaVehiculosAdapter(response.body());
                    listVehiculos.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<CatalogoVehiculos>> call, Throwable t) {
                Log.e("Error: ",t.getMessage());
            }
        });
    }
}