package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {

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
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",1000,1500,3));
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",1000,1500,3));
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",1000,1500,3));
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",1000,1500,3));


        listView = (ListView) layoutRhoot.findViewById(R.id.listView);

        ListaAdaptora adapter= new ListaAdaptora(getActivity(),R.layout.my_list_item,prestamoList);



        listView.setAdapter(adapter);
        Log.i("Hola",""+ adapter);
        Log.i("Hola",""+ prestamoList);
        Log.i("Hola",""+ listView);
        return layoutRhoot;

    }



}