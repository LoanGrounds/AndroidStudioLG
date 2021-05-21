package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
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
import java.util.stream.Collectors;

public class LupaAdapter extends RecyclerView.Adapter<LupaAdapter.ViewHolder> implements View.OnClickListener{
    ArrayList<Prestamo> prestamos;
    ArrayList<Prestamo> listaOriginal;
    Context context;
    private View.OnClickListener listener;

    int resource;

    public LupaAdapter(Context context, ArrayList<Prestamo> prestamos){

        this.context=context;
        this.prestamos=prestamos;
        listaOriginal=new ArrayList<>();
        listaOriginal.addAll(prestamos);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mi_list_item2,parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNombreApellido.setText(prestamos.get(position).getName());
        holder.precio1.setText(String.valueOf("$"+prestamos.get(position).getPrecio1()));
        holder.imgPrestamista.setImageDrawable(context.getResources().getDrawable(prestamos.get(position).getImage()));
    }

    public   void filtrar(String buscarPrestamo){
        int longitud= buscarPrestamo.length();
        if(longitud == 0){
            prestamos.clear();
            prestamos.addAll(listaOriginal);
        }
        else {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                List <Prestamo> collects =  prestamos.stream()
                        .filter(i -> i.getName().toLowerCase().contains(buscarPrestamo.toLowerCase()))
                        .collect(Collectors.toList());
                prestamos.clear();
                prestamos.addAll(collects);
            }
            else{
                for (Prestamo c: listaOriginal) {

                    if (c.getName().toLowerCase().contains(buscarPrestamo.toLowerCase())){
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

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }

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
