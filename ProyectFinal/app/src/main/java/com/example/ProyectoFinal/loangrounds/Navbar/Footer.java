package com.example.ProyectoFinal.loangrounds.Navbar;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.R;


public class Footer extends Fragment {
    ImageButton imBtnHouse, imBtnLupa, imBtnSol, imBtnCont;
    View layoutRhoot;




    public Footer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        layoutRhoot=inflater.inflate(R.layout.fragment_footer, container, false);
        ObtenerReferencias();
        SetearListners();
        return layoutRhoot;
    }
    private void SetearListners() {
        imBtnHouse.setOnClickListener(imBtnHouse_Click);
        imBtnLupa.setOnClickListener(imBtnLupa_Click);
        imBtnSol.setOnClickListener(imBtnSol_Click);
        imBtnCont.setOnClickListener(imBtnCont_Click);
    }
    View.OnClickListener imBtnHouse_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivityInicio actividadContenedora;
            actividadContenedora=(MainActivityInicio) getActivity();
            actividadContenedora.setFragmentMenu();
        }
    };


    View.OnClickListener imBtnLupa_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivityInicio actividadContenedora;
            actividadContenedora=(MainActivityInicio) getActivity();
            actividadContenedora.setFragmentLupa();
        }
    };


    View.OnClickListener imBtnSol_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivityInicio actividadContenedora;
            actividadContenedora=(MainActivityInicio) getActivity();
            actividadContenedora.setFragmentSolicitados();
        }
    };
    View.OnClickListener imBtnCont_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MainActivityInicio actividadContenedora;
            actividadContenedora=(MainActivityInicio) getActivity();
            actividadContenedora.setFragmentContacto();
        }
    };

    private void ObtenerReferencias(){
        imBtnHouse = (ImageButton)layoutRhoot.findViewById(R.id.imBtnHouse);
        imBtnLupa = (ImageButton)layoutRhoot.findViewById(R.id.imBtnLupa);
        imBtnSol= (ImageButton) layoutRhoot.findViewById(R.id.imBtnSol);
        imBtnCont= (ImageButton) layoutRhoot.findViewById(R.id.imBtnCont);
    }
}