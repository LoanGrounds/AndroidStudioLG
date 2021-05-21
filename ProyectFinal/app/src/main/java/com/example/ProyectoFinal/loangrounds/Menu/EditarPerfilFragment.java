package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ProyectoFinal.loangrounds.R;


public class EditarPerfilFragment extends Fragment {

    View layoutRhoot;

    public EditarPerfilFragment() {
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
        layoutRhoot=inflater.inflate(R.layout.fragment_editar_perfil, container, false);
        return layoutRhoot;
    }
}