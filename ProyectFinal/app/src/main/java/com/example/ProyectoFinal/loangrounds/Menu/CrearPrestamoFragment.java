package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class CrearPrestamoFragment extends Fragment {

    View layoutRhoot;


    public CrearPrestamoFragment() {
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
        layoutRhoot = inflater.inflate(R.layout.fragment_crear_prestamo, container, false);
        ObtenerReferencia();
        SetearListners();
        return  layoutRhoot;
    }

    public void SetearListners() {

    }

    private void ObtenerReferencia() {


    }
}