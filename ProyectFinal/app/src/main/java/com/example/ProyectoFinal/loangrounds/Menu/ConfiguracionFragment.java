package com.example.ProyectoFinal.loangrounds.Menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.MainActivityStart;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.SharedPreferencesManager;
import com.example.ProyectoFinal.loangrounds.entidades.Configuracion;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ConfiguracionFragment extends Fragment {
    View layoutRhoot;
    Button btnCerrar;

    public ConfiguracionFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutRhoot= inflater.inflate(R.layout.fragment_configuracion, container, false);
        ObtenerReferencia();

        return layoutRhoot;
    }

    private void ObtenerReferencia() {
        btnCerrar = (Button) layoutRhoot.findViewById(R.id.btnCerrar);
    }

    public void SetearListners() {

  btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
                SharedPreferencesManager.clearConfiguracion(getContext());

                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();
                actividadContenedora.cambioActivity();
            }
        });
    }





}