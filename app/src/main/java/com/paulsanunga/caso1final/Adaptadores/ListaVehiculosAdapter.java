package com.paulsanunga.caso1final.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paulsanunga.caso1final.DetalleVehiculo;
import com.paulsanunga.caso1final.Model.CatalogoVehiculos;
import com.paulsanunga.caso1final.R;

import java.util.ArrayList;
import java.util.List;

public class ListaVehiculosAdapter extends RecyclerView.Adapter<ListaVehiculosAdapter.VehiculoViewHolder> {

    List<CatalogoVehiculos> listVehiculos;

    public ListaVehiculosAdapter(List<CatalogoVehiculos> listVehiculos) {

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
        holder.viewMarca.setText(listVehiculos.get(position).getDiseno().getMarca());
        holder.viewAnioFabri.setText(Integer.toString(listVehiculos.get(position).getYear_vehiculo()));
        holder.viewModelo.setText(listVehiculos.get(position).getDiseno().getModelo());
        //holder.viewColor.setText(listVehiculos.get(position).getCaracteristica().getc);
        holder.viewMotor.setText(listVehiculos.get(position).getCaracteristica().getMotor());
        holder.viewNumeroPuertas.setText(Integer.toString(listVehiculos.get(position).getCaracteristica().getNumero_de_puertas()));


    }

    @Override
    public int getItemCount() {
        if (listVehiculos==null){
            return 0;
        }
        return listVehiculos.size();
    }

    public class VehiculoViewHolder extends RecyclerView.ViewHolder {
        TextView viewMarca, viewAnioFabri, viewModelo, viewColor, viewMotor, viewNumeroPuertas;
        public VehiculoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewMarca = itemView.findViewById(R.id.txtVehiculoMarca);
            viewAnioFabri = itemView.findViewById(R.id.txtVehiculoAnioFabric);
            viewModelo = itemView.findViewById(R.id.txtVehiculoModelo);
            //viewColor = itemView.findViewById(R.id.txtVehiculoColor);
            viewMotor = itemView.findViewById(R.id.txtVehiculoMotor);
            viewNumeroPuertas = itemView.findViewById(R.id.txtVehiculoNumeroPuertas);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, DetalleVehiculo.class);
                    intent.putExtra("marca", listVehiculos.get(getAdapterPosition()).getDiseno().getMarca());
                    intent.putExtra("modelo", listVehiculos.get(getAdapterPosition()).getDiseno().getModelo());
                    intent.putExtra("descripcion", listVehiculos.get(getAdapterPosition()).getCaracteristica().toString());
                    context.startActivity(intent);
                }
            });
        }
    }
}
