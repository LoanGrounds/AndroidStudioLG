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
    LinearLayout prestamosRecientes;
    LinearLayout configuracion;
    LinearLayout atencionCliente;

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
        SetearListners();
        return layoutRhoot;
    }

    private void ObtenerReferencias() {
        editarPerfil=(LinearLayout) layoutRhoot.findViewById(R.id.editarPerfil);
        prestamosRecientes=(LinearLayout) layoutRhoot.findViewById(R.id.prestamosRecientes);
        configuracion=(LinearLayout) layoutRhoot.findViewById(R.id.configuracion);
        atencionCliente=(LinearLayout) layoutRhoot.findViewById(R.id.atencionCliente);

    }


    public void SetearListners() {


        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentEditarPerfil();

            }
        });
        prestamosRecientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentPrestamosRecientes();

            }
        });
        configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentConfiguracion();

            }
        });
        atencionCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentAtencionCliente();

            }
        });


    }




}