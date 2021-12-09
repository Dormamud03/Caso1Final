package com.paulsanunga.caso1final.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paulsanunga.caso1final.Model.CatalogoVehiculos;
import com.paulsanunga.caso1final.R;

import java.util.ArrayList;

public class ListaVehiculosAdapter extends RecyclerView.Adapter<ListaVehiculosAdapter.VehiculoViewHolder> {

    ArrayList<CatalogoVehiculos> listVehiculos;

    public ListaVehiculosAdapter(ArrayList<CatalogoVehiculos> listVehiculos) {

        this.listVehiculos = listVehiculos;
    }
    @NonNull
    @Override
    public VehiculoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_vehiculos,null,false);

        return new VehiculoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculoViewHolder holder, int position) {
        /*holder.viewMarca.setText(listVehiculos.get(position).getMarca);
        holder.viewAnioFabri.setText(listVehiculos.get(position).getAnioFabri);
        holder.viewModelo.setText(listVehiculos.get(position).getModelo);
        holder.viewColor.setText(listVehiculos.get(position).getColor);
        holder.viewMotor.setText(listVehiculos.get(position).getMotor);
        holder.viewNumeroPuertas.setText(listVehiculos.get(position).getNumeroPuertas);*/



    }

    @Override
    public int getItemCount() {
        return listVehiculos.size();
    }

    public class VehiculoViewHolder extends RecyclerView.ViewHolder {
        TextView viewMarca, viewAnioFabri, viewModelo, viewColor, viewMotor, viewNumeroPuertas;
        public VehiculoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewMarca = itemView.findViewById(R.id.txtVehiculoMarca);
            viewAnioFabri = itemView.findViewById(R.id.txtVehiculoAnioFabric);
            viewModelo = itemView.findViewById(R.id.txtVehiculoModelo);
            viewColor = itemView.findViewById(R.id.txtVehiculoColor);
            viewMotor = itemView.findViewById(R.id.txtVehiculoMotor);
            viewNumeroPuertas = itemView.findViewById(R.id.txtVehiculoNumeroPuertas);
        }
    }
}
