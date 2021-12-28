package com.paulsanunga.caso1final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.paulsanunga.caso1final.Adaptadores.ListVehiculosCliente;
import com.paulsanunga.caso1final.Adaptadores.ListaVehiculosAdapter;
import com.paulsanunga.caso1final.Model.CatalogoVehiculos;
import com.paulsanunga.caso1final.Model.VehiculoCliente;
import com.paulsanunga.caso1final.Utils.Apis;
import com.paulsanunga.caso1final.Utils.MisVehiculosService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisVehiculos extends AppCompatActivity {
    MisVehiculosService service;
    RecyclerView listMisVehiculos;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_vehiculos);
        listMisVehiculos = findViewById(R.id.ListMisVehiculos);
        mostrarMisVehiculos();
    }
    public void mostrarMisVehiculos(){
        service = Apis.getMisVehiculosService();
        Call<List<String>> call = service.getVehiculosClient(MainActivity.client.getCedulaClient());
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                if (response.body()!=null){
                    List<VehiculoCliente> list = new ArrayList<VehiculoCliente>();
                    String[] responseDirec;
                    for (int i = 0; i < response.body().size(); i++) {
                        VehiculoCliente vehiculoCliente = new VehiculoCliente();
                        responseDirec = response.body().get(i).split(",");
                        vehiculoCliente.setChasis_vehiculo(responseDirec[0]);
                        vehiculoCliente.setLinks_imagen(responseDirec[1]);
                        vehiculoCliente.setMarca(responseDirec[2]);
                        vehiculoCliente.setModelo(responseDirec[3]);
                        list.add(vehiculoCliente);
                    }
                    listMisVehiculos.setLayoutManager(new LinearLayoutManager(context));
                    ListVehiculosCliente adapter = new ListVehiculosCliente(list);
                    listMisVehiculos.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {
                System.out.println("Error "+ t.getMessage());
            }
        });
    }
}