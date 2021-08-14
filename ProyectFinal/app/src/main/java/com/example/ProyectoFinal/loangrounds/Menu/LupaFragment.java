package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.LupaAdapter;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;


public class LupaFragment extends Fragment implements SearchView.OnQueryTextListener {

    View layoutRhoot;

    RecyclerView recyclerView;
    LupaAdapter lupaAdapter;
    SearchView buscarPrestamo;
    ImageView filtros;

    ArrayList<PrestamoRecomendadoDTO> prestamoList;

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
        layoutRhoot = inflater.inflate(R.layout.fragment_lupa, container, false);
        prestamoList = new ArrayList<>();
        prestamoList.add(new PrestamoRecomendadoDTO(4,1000,"Luka Portnoi",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(5,1500,"Fernando pedro",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(6,20000,"Gonzalo Turrezco",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(7,1000,"Matas Besmedrisnik",R.drawable.yo));


        ObtenerReferencias();
        initListeners();



        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        lupaAdapter= new LupaAdapter(getActivity(), prestamoList);

        recyclerView.setAdapter(lupaAdapter);
      /*  lupaAdapter.setOnClickListener(v -> {
            MainActivityInicio actividadContenedora;
            actividadContenedora = (MainActivityInicio) getActivity();

            actividadContenedora.setFragmentCadaPrestamo();

        });*/

        return layoutRhoot;
    }

    private void ObtenerReferencias() {
        recyclerView=(RecyclerView) layoutRhoot.findViewById(R.id.recyclerView);
        buscarPrestamo=(SearchView) layoutRhoot.findViewById(R.id.searchBuscarPrestamo);
        filtros=(ImageView) layoutRhoot.findViewById(R.id.imageView4);
    }

    private void initListeners(){

        buscarPrestamo.setOnQueryTextListener(this);
        filtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentFiltros();

            }
        });

    }




    @Override
    public boolean onQueryTextSubmit(String query) {


        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        lupaAdapter.filtrar(newText);
        return false;
    }
}