package com.example.ProyectoFinal.loangrounds.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.R;


public class InicioSesionFragment extends Fragment {

    View layoutRhoot;
    Button btnIn;
    public InicioSesionFragment() {
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
        layoutRhoot= inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        ObtenerReferencias();
        SetearListners();
        return layoutRhoot;
    }

    View.OnClickListener btnIn_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivity actividadContenedora;
            actividadContenedora = (MainActivity) getActivity();
            actividadContenedora.cambioActivity();

        }
    };







    public void SetearListners() {
        btnIn.setOnClickListener(btnIn_Click);

    }
    private void ObtenerReferencias(){
        btnIn = (Button) layoutRhoot.findViewById(R.id.btnIn);




    }
}