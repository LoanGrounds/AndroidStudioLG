package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.List;


public class CadaSolicitadoFragment extends Fragment {

    int intPos;
    List<Prestamo> prest;
    View layoutRhoot;

    public CadaSolicitadoFragment() {
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
        layoutRhoot= inflater.inflate(R.layout.fragment_cada_solicitado, container, false);
        obtenerReferencias();
        inicializarDatos();
        SetearListners();


        return layoutRhoot;
    }

    private void obtenerReferencias() {
    }

    private void inicializarDatos() {
    }

    private void SetearListners() {
    }

    public void enviarPosition(int position, List<Prestamo> prestamoList ){

        prest = prestamoList;
        intPos = position;


    }
}