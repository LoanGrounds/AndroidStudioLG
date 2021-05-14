package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;


public class LupaFragment extends Fragment {

    View layoutRhoot;
    ListView listView;

    List<Prestamo> prestamoList;
    public LupaFragment() {
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
        layoutRhoot=inflater.inflate(R.layout.fragment_lupa, container, false);
        prestamoList= new ArrayList<>();
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",1000));
        prestamoList.add(new Prestamo(R.drawable.deck,"Jose pedro",1000));
        prestamoList.add(new Prestamo(R.drawable.yo,"Damian cuk",1000));
        prestamoList.add(new Prestamo(R.drawable.deck,"Luka Portnoi",1000));


        listView = (ListView) layoutRhoot.findViewById(R.id.listView);
        ListaAdaptora adapter= new ListaAdaptora(getActivity(),R.layout.my_list_item,prestamoList);
        listView.setAdapter(adapter);
        return layoutRhoot;
    }




}