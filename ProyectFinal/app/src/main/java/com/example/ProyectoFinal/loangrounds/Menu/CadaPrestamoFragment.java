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

import java.util.List;


public class CadaPrestamoFragment extends Fragment {

    TextView tv1;
    TextView tvDinero;
    TextView tvDiasEntreCuota;
    SeekBar skbDinero;
    TextView tvIntereses;
    TextView tvDiaTol;
    TextView tvCantCuotas;
    TextView tvNombre;
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

    }
    private void inicializarDatos(){
        String nombre=prest.get(intPos).getName();

        int diner=prest.get(intPos).getPrecio1();

        tvDinero.setText("$"+String.valueOf(diner));
        double interes=(diner*0.12);
        tvIntereses.setText(String.valueOf(interes));
        tvNombre.setText(nombre);


    }


    private void obtenerReferencias() {
        tvDinero= (TextView) layoutRhoot.findViewById(R.id.tvDinero);
        tvDiasEntreCuota=(TextView) layoutRhoot.findViewById(R.id.tvCantMeses);
        tvIntereses=(TextView) layoutRhoot.findViewById(R.id.tvInteres);
        tvDiaTol=(TextView) layoutRhoot.findViewById(R.id.tvDiaTol);
        tvCantCuotas=(TextView) layoutRhoot.findViewById(R.id.tvCantCuotas);
        tvNombre=(TextView) layoutRhoot.findViewById(R.id.tvNombre);
    }


    public void enviarPosition(int position, List<Prestamo> prestamoList ){

        prest = prestamoList;
        intPos = position;


    }
}