package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.R;


public class ContactoFragment extends Fragment {
    View layoutRhoot;
    LinearLayout editarPerfil;

    public ContactoFragment() {
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
        layoutRhoot = inflater.inflate(R.layout.fragment_contacto, container, false);

        ObtenerReferencias();
        return layoutRhoot;
    }

    private void ObtenerReferencias() {
        editarPerfil=(LinearLayout) layoutRhoot.findViewById(R.id.editarPerfil);


    }


    public void SetearListners() {

        editarPerfil.setOnClickListener(editarPerfil_Click);


    }



    View.OnClickListener editarPerfil_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            MainActivityInicio actividadContenedora;
            actividadContenedora = (MainActivityInicio) getActivity();
            actividadContenedora.setFragmentEditarPerfil();

        }
    };
}