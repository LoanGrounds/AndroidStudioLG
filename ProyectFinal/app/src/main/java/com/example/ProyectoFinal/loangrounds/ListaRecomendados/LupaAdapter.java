package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LupaAdapter extends RecyclerView.Adapter<LupaAdapter.ViewHolder>{
    ArrayList<PrestamoRecomendadoDTO> prestamos;
    ArrayList<PrestamoRecomendadoDTO> listaOriginal;
    Context context;
    private View.OnClickListener listener;

    int resource;

    public LupaAdapter(Context context, ArrayList<PrestamoRecomendadoDTO> prestamos){

        this.context=context;
        this.prestamos=prestamos;
        listaOriginal=new ArrayList<>();
        listaOriginal.addAll(prestamos);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item_listview,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNombreApellido.setText(prestamos.get(position).UserName);
        holder.precio1.setText(String.valueOf("$"+prestamos.get(position).Monto));
        holder.imgPrestamista.setImageDrawable(context.getResources().getDrawable(prestamos.get(position).URLFoto));

    }

    public   void filtrar(String buscarPrestamo){
        int longitud= buscarPrestamo.length();
        if(longitud == 0){
            prestamos.clear();
            prestamos.addAll(listaOriginal);
        }
        else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                List <PrestamoRecomendadoDTO> collects =  prestamos.stream()
                        .filter(i -> i.UserName.toLowerCase().contains(buscarPrestamo.toLowerCase()))
                        .collect(Collectors.toList());
                prestamos.clear();
                prestamos.addAll(collects);
            }
            else{
                for (PrestamoRecomendadoDTO c: listaOriginal) {

                    if (c.UserName.toLowerCase().contains(buscarPrestamo.toLowerCase())){
                        prestamos.add(c);

                    }
                }

            }

        }
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return prestamos.size();

    }

    public void setOnClickListener(View.OnClickListener listener){

        this.listener=listener;

    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreApellido;
        TextView precio1;
        ImageView imgPrestamista;
        LottieAnimationView animation_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreApellido=itemView.findViewById(R.id.tvNombreApellido);
            precio1=itemView.findViewById(R.id.precio1);
            imgPrestamista=itemView.findViewById(R.id.imgPrestamista);



        }
    }
}
