package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.Menu.CadaPrestamoFragment;
import com.example.ProyectoFinal.loangrounds.Model.DetallePrestamo;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class ListaAdaptadoraPrestados extends ArrayAdapter<VistaPreviaPrestamo> {
    Context mCtx;
    int resource;
    List<VistaPreviaPrestamo> ListaPrestamos;
    LupaAdapter lupaAdapter;
    DetallePrestamo detalle;
    int idDetallePrestamos;
    ConstraintLayout clCard;



    public ListaAdaptadoraPrestados(Context mCtx, int resource, List<VistaPreviaPrestamo> ListaPrestamos){
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
        clCard= (ConstraintLayout) view.findViewById(R.id.clCard);
        TextView precio1=view.findViewById(R.id.precio1);
        ImageView imgPrestamista=view.findViewById(R.id.imgPrestamista);



        VistaPreviaPrestamo prestamo=ListaPrestamos.get(position);



        tvNombreApellido.setText(prestamo.getPrestamista());

        if(prestamo.getEstado().equals("Negociando")  ){
            tvNombreApellido.setText("Solictado");
        }else if (prestamo.getEstado().equals("Activo") ){
        }else if (prestamo.getEstado().equals("Demorado") ){
        } else if (prestamo.getEstado().equals("Caducado") ){
        }else{
            tvNombreApellido.setText("Disponible");
        }


        precio1.setText(String.valueOf("$"+prestamo.getMonto()));


        //imgPrestamista.setImageDrawable(mCtx.getResources().getDrawable(prestamo.URLFoto));


        return view;
    }





}
