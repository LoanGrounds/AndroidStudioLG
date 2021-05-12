package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.R;


public class CadaPrestamoFragment extends Fragment {

    TextView tv1;
    int intPos;
    View layoutRhoot;
    public CadaPrestamoFragment() {
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
         layoutRhoot=inflater.inflate(R.layout.fragment_cada_prestamo, container, false);
         obtenerReferencias();
         tv1.setText(String.valueOf(intPos));
         return layoutRhoot;

    }

    private void obtenerReferencias() {
        tv1=(TextView) layoutRhoot.findViewById(R.id.tv1);
    }


    public void enviarPosition(int position){


        intPos = position;


    }
}