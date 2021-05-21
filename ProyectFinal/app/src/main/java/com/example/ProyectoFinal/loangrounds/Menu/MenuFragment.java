package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {
    FloatingActionButton fbtnCrearPrestamo;
    ListView listView;
    View layoutRhoot;
    List<Prestamo> prestamoList;





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

        layoutRhoot= inflater.inflate(R.layout.fragment_menu, container, false);


        prestamoList= new ArrayList<>();
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",1000));
        prestamoList.add(new Prestamo(R.drawable.deck,"Jose pedro",1500));
        prestamoList.add(new Prestamo(R.drawable.yo,"Damian cuk",1200));
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",7000));

        ObtenerReferencia();


        ListaAdaptora adapter= new ListaAdaptora(getActivity(),R.layout.my_list_item,prestamoList);
        listView.setAdapter(adapter);

        SetearListners();

        return layoutRhoot;

    }

    private void ObtenerReferencia() {
        listView = (ListView) layoutRhoot.findViewById(R.id.listView);
        fbtnCrearPrestamo=(FloatingActionButton) layoutRhoot.findViewById(R.id.fbtnCrearPrestamo);
    }


    public void SetearListners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();

                actividadContenedora.setFragmentCadaPrestamo();
                actividadContenedora.EnviarMensaje(position, prestamoList);



            }
        });
        fbtnCrearPrestamo.setOnClickListener(fbtnCrearPrestamo_Click);

    }

    View.OnClickListener fbtnCrearPrestamo_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            MainActivityInicio actividadContenedora;
            actividadContenedora = (MainActivityInicio) getActivity();
            actividadContenedora.setFragmentCrearPrestamo();

        }
    };


}