package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;

public class LupaAdapter extends RecyclerView.Adapter<LupaAdapter.ViewHolder>{
    ArrayList<Prestamo> prestamos;
    Context context;
    int resource;

    public LupaAdapter(Context context, ArrayList<Prestamo> prestamos){

        this.context=context;

        this.prestamos=prestamos;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_list_item2,parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNombreApellido.setText(prestamos.get(position).getName());
        holder.precio1.setText(String.valueOf("$"+prestamos.get(position).getPrecio1()));
        holder.imgPrestamista.setImageDrawable(context.getResources().getDrawable(prestamos.get(position).getImage()));
    }

    @Override
    public int getItemCount() {
        return prestamos.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreApellido;
        TextView precio1;
        ImageView imgPrestamista;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreApellido=itemView.findViewById(R.id.tvNombreApellido);
            precio1=itemView.findViewById(R.id.precio1);
            imgPrestamista=itemView.findViewById(R.id.imgPrestamista);


        }
    }
}
