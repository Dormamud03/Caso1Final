package com.paulsanunga.caso1final.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.paulsanunga.caso1final.Model.VehiculoCliente;
import com.paulsanunga.caso1final.R;
import com.paulsanunga.caso1final.SolicitarGarantia;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListVehiculosCliente extends RecyclerView.Adapter<ListVehiculosCliente.MisVehiculosViewHolder> {

    List<VehiculoCliente> listMisVehiculos;

    public ListVehiculosCliente(List<VehiculoCliente> listMisVehiculos) {
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
        holder.viewMarca.setText(listMisVehiculos.get(position).getMarca());
        holder.viewModelo.setText(listMisVehiculos.get(position).getModelo());
        Picasso.with(holder.imagenMiAuto.getContext())
                .load(listMisVehiculos.get(position).getLinks_imagen())
                .error(R.mipmap.ic_launcher)
                .into(holder.imagenMiAuto);

    }

    @Override
    public int getItemCount() {
        if (listMisVehiculos ==null){
            return 0;
        }
        return listMisVehiculos.size();
    }


    public class MisVehiculosViewHolder extends RecyclerView.ViewHolder {
        ImageView imagenMiAuto;
        TextView viewChasis, viewMarca, viewModelo;
        public MisVehiculosViewHolder(@NonNull View itemView) {
            super(itemView);
            viewChasis = itemView.findViewById(R.id.txtMiVehiculoChasis);
            viewMarca = itemView.findViewById(R.id.txtMarcaMiVehiculo);
            viewModelo = itemView.findViewById(R.id.txtModeloMiVehiculo);
            imagenMiAuto = itemView.findViewById(R.id.imgMiVehiculo);

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
