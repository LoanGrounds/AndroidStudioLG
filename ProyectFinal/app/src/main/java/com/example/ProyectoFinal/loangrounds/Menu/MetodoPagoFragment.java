package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.R;


public class MetodoPagoFragment extends Fragment {

   LinearLayout linearLayoutTarjetas;
   View layoutRhoot;

    public MetodoPagoFragment() {
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
        layoutRhoot= inflater.inflate(R.layout.fragment_metodo_pago, container, false);
        obtenerReferencias();
        SetearListners();
        return layoutRhoot;
    }



    private void obtenerReferencias() {
        linearLayoutTarjetas=(LinearLayout) layoutRhoot.findViewById(R.id.linearLayoutTarjetas);
    }

    private void SetearListners() {
        linearLayoutTarjetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentRealizar();

            }
        });
    }
}