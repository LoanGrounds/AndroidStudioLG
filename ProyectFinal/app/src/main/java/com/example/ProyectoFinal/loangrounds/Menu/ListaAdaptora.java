package com.example.ProyectoFinal.loangrounds.Menu;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ProyectoFinal.loangrounds.Prestamo;
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
        TextView tvNombre=view.findViewById(R.id.tvNombreApellido);
        TextView tvMeses=view.findViewById(R.id.tvMeses);
        TextView tvPrecioMin=view.findViewById(R.id.precio1);
        TextView tvPrecioMax=view.findViewById(R.id.precio2);
        ImageView imgPrestamista=view.findViewById(R.id.imgPrestamista);


        Prestamo prestamo=ListaPrestamos.get(position);
        tvNombre.setText(prestamo.getName());
        tvMeses.setText(prestamo.getPlazo());
        tvPrecioMin.setText(prestamo.getPrecio1());
        tvPrecioMax.setText(prestamo.getPrecio2());
        imgPrestamista.setImageDrawable(mCtx.getResources().getDrawable(prestamo.getImage()));

        return view;
    }
}
