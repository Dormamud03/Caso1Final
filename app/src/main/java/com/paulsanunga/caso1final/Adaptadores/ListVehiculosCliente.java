package com.paulsanunga.caso1final.Adaptadores;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paulsanunga.caso1final.Model.CatalogoVehiculos;
import com.paulsanunga.caso1final.Model.Factura;

import java.util.List;

public class ListVehiculosCliente extends RecyclerView.Adapter<ListaVehiculosAdapter.VehiculoViewHolder> {
    List<Factura> listVehiculos;

    public ListVehiculosCliente(List<Factura> listVehiculos) {
        this.listVehiculos = listVehiculos;
    }

    @NonNull
    @Override
    public ListaVehiculosAdapter.VehiculoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaVehiculosAdapter.VehiculoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
