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
import com.paulsanunga.caso1final.Model.Vehiculo;
import com.paulsanunga.caso1final.R;
import com.paulsanunga.caso1final.SolicitarGarantia;

import java.util.List;

public class ListVehiculosCliente extends RecyclerView.Adapter<ListVehiculosCliente.MisVehiculosViewHolder> {

    List<Vehiculo> listMisVehiculos;

    public ListVehiculosCliente(List<Vehiculo> listMisVehiculos) {
        this.listMisVehiculos = listMisVehiculos;
    }

    @NonNull
    @Override
    public ListVehiculosCliente.MisVehiculosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mis_vehiculos,null,false);
        return new MisVehiculosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListVehiculosCliente.MisVehiculosViewHolder holder, int position) {
        holder.viewChasis.setText(listMisVehiculos.get(position).getChasis_vehiculo());
        holder.viewRamv.setText(listMisVehiculos.get(position).getRamv());
        holder.viewPais.setText(listMisVehiculos.get(position).getId_pais().getNombre_pais());
        holder.viewAnio.setText(Integer.toString(listMisVehiculos.get(position).getVehiculoCatalogo().getYear_vehiculo()));

    }

    @Override
    public int getItemCount() {
        if (listMisVehiculos ==null){
            return 0;
        }
        return listMisVehiculos.size();
    }


    public class MisVehiculosViewHolder extends RecyclerView.ViewHolder {
        TextView viewChasis, viewRamv, viewPais, viewAnio;
        public MisVehiculosViewHolder(@NonNull View itemView) {
            super(itemView);
            viewChasis = itemView.findViewById(R.id.txtMiVehiculoChasis);
            viewRamv = itemView.findViewById(R.id.txtRamvMiVehiculo);
            viewPais = itemView.findViewById(R.id.txtPaisMiVehiculo);
            viewAnio = itemView.findViewById(R.id.txtAnioMiVehiculo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, SolicitarGarantia.class);
                    intent.putExtra("chasis", listMisVehiculos.get(getAdapterPosition()).getChasis_vehiculo());
                    context.startActivity(intent);
                }
            });
        }
    }
}
