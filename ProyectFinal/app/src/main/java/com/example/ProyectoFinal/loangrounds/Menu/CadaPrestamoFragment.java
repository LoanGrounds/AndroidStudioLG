package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;


public class CadaPrestamoFragment extends Fragment {

    TextView tv1;
    TextView tvDinero;
    TextView tvCantMeses;
    SeekBar skbDinero;
    TextView tvIntereses;
    int intPos;
    List<Prestamo> prest;
    View layoutRhoot;
    public CadaPrestamoFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         layoutRhoot=inflater.inflate(R.layout.fragment_cada_prestamo, container, false);
         obtenerReferencias();
        inicializarDatos();
         SetearListners();
         return layoutRhoot;

    }

    private void SetearListners() {
        skbDinero.setOnSeekBarChangeListener(skbDinero_Change);
    }
    private void inicializarDatos(){
        String nombre=prest.get(intPos).getName();
        int meses=prest.get(intPos).getMeses();
        int dineroMin=prest.get(intPos).getPrecio1();
        int dineroMax=prest.get(intPos).getPrecio2();

        tv1.setText(String.valueOf(nombre));
        tvCantMeses.setText(String.valueOf(meses)+"  meses");
        tvDinero.setText(String.valueOf(dineroMin));
        skbDinero.setMin(dineroMin);
        skbDinero.setMax(dineroMax-dineroMin);
        double interes=(dineroMin*0.2);
        tvIntereses.setText(String.valueOf(interes));



    }

    SeekBar.OnSeekBarChangeListener skbDinero_Change=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean fromUser) {


            int min=i+prest.get(intPos).getPrecio1();
            double interes=(min*0.2);
            tvDinero.setText(String.valueOf(min));
            tvIntereses.setText(String.valueOf(interes));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private void obtenerReferencias() {
        tv1=(TextView) layoutRhoot.findViewById(R.id.tv1);
        tvDinero= (TextView) layoutRhoot.findViewById(R.id.tvDinero);
        tvCantMeses=(TextView) layoutRhoot.findViewById(R.id.tvCantMeses);
        skbDinero=(SeekBar)layoutRhoot.findViewById(R.id.skbDinero);
        tvIntereses=(TextView) layoutRhoot.findViewById(R.id.tvInteres);
    }


    public void enviarPosition(int position, List<Prestamo> prestamoList ){

       prest = prestamoList;
        intPos = position;


    }
}