package com.example.ProyectoFinal.loangrounds.Menu;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Prestamo;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {

    ListView listView;
    View layoutRhoot;


    public MenuFragment() {
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
        layoutRhoot= inflater.inflate(R.layout.fragment_menu, container, false);
     /*  listView=(ListView) layoutRhoot.findViewById(R.id.listView);
        MainActivityInicio actividadContenedora;
        actividadContenedora=(MainActivityInicio) getActivity();
        ListaAdaptora lista=actividadContenedora.listas();
        listView.setAdapter();*/
        return layoutRhoot;

    }
}