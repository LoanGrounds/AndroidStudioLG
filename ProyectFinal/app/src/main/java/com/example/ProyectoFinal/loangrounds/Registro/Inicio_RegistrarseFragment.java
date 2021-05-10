package com.example.ProyectoFinal.loangrounds.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.R;


public class Inicio_RegistrarseFragment extends Fragment {

    Button btnIniciarSesion;
    Button btnRegistrarse;
    View layoutRhoot;

    public Inicio_RegistrarseFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRhoot = inflater.inflate(R.layout.fragment_inicio__registrarse, container, false);

        ObtenerReferencias();
        SetearListners();

        return layoutRhoot;
        
    }

    private void ObtenerReferencias(){
        btnIniciarSesion = (Button) layoutRhoot.findViewById(R.id.btnIniciarSesion);
        btnRegistrarse = (Button) layoutRhoot.findViewById(R.id.btnRegistrarse);



    }





    public void SetearListners() {
        btnIniciarSesion.setOnClickListener(btnIniciarSesion_Click);
        btnRegistrarse.setOnClickListener(btnRegistrarse_Click);
        // btnFoto.setOnClickListener(btnFoto_Click);
    }
    View.OnClickListener btnIniciarSesion_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();


            actividadContenedora.setFragmentInicioSesion();

        }
    };

    View.OnClickListener btnRegistrarse_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();


            actividadContenedora.setFragmentRegistro();

        }
    };




}