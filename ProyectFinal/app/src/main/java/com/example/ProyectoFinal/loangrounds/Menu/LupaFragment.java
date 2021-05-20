package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.LupaAdapter;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;


public class LupaFragment extends Fragment {

    View layoutRhoot;
    ListView listView;
    RecyclerView recyclerView;
    LupaAdapter lupaAdapter;

    ArrayList<Prestamo> prestamoList;
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


        recyclerView=(RecyclerView) layoutRhoot.findViewById(R.id.recyclerView);


        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        lupaAdapter= new LupaAdapter(getActivity(), prestamoList);
        recyclerView.setAdapter(lupaAdapter);

        return layoutRhoot;
    }




}