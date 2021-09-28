package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ProyectoFinal.loangrounds.R;


public class PrestamosRecientesFragment extends Fragment {
    View rootLayout;

    public PrestamosRecientesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootLayout == null) rootLayout = inflater.inflate(R.layout.fragment_prestamos_recientes, container, false);
        return  rootLayout;
    }
}