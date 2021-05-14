package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.List;

public class ListaAdaptora extends ArrayAdapter<Prestamo> {
    Context mCtx;
    int resource;
    List<Prestamo> ListaPrestamos;



    public ListaAdaptora(Context mCtx, int resource, List<Prestamo> ListaPrestamos){
        super(mCtx,resource,ListaPrestamos);
        this.mCtx=mCtx;
        this.resource=resource;
        this.ListaPrestamos=ListaPrestamos;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(mCtx) ;
        View view=inflater.inflate(resource,null);
        TextView tvNombreApellido=view.findViewById(R.id.tvNombreApellido);
        TextView precio1=view.findViewById(R.id.precio1);
        ImageView imgPrestamista=view.findViewById(R.id.imgPrestamista);


        Prestamo prestamo=ListaPrestamos.get(position);
        tvNombreApellido.setText(prestamo.getName());
        precio1.setText(String.valueOf(prestamo.getPrecio1()));
        imgPrestamista.setImageDrawable(mCtx.getResources().getDrawable(prestamo.getImage()));

        return view;
    }
}
