package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.List;

public class ListaAdaptora extends ArrayAdapter<Prestamo> {
    Context mCtx;
    int resource;
    List<Prestamo> ListaPrestamos;
    LupaAdapter lupaAdapter;


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
        LottieAnimationView coraDislike=view.findViewById(R.id.coraDislike);
        final int[] cont = {0};


        Prestamo prestamo=ListaPrestamos.get(position);
        tvNombreApellido.setText(prestamo.getName());
        precio1.setText(String.valueOf("$"+prestamo.getPrecio1()));
        imgPrestamista.setImageDrawable(mCtx.getResources().getDrawable(prestamo.getImage()));
        final boolean[] like = {false};
        coraDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                like[0] =likeAnimation(coraDislike,R.raw.like, like[0]);


                /*if (cont[0] ==0){
                coraDislike.setBackgroundResource(R.drawable.favorite_like);
                cont[0]++;
                }else{
                    coraDislike.setBackgroundResource(R.drawable.favorite_unlike);
                    cont[0]--;
                }*/
            }
        });

        return view;
    }


    private boolean likeAnimation(LottieAnimationView imageView, int animation,Boolean like){
        if (!like){
            imageView.setAnimation(animation);
            imageView.playAnimation();
        }
        else {
            imageView.setImageResource(R.drawable.favorite_unlike);
        }

        return !like;
    }
}
