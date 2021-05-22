package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.LupaAdapter;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class LupaFragment extends Fragment implements SearchView.OnQueryTextListener {

    View layoutRhoot;

    RecyclerView recyclerView;
    LupaAdapter lupaAdapter;
    SearchView buscarPrestamo;
    LottieAnimationView filtros;

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
        layoutRhoot = inflater.inflate(R.layout.fragment_lupa, container, false);
        prestamoList = new ArrayList<>();
        prestamoList.add(new Prestamo(R.drawable.deck, "Luka Portnoi", 1000));
        prestamoList.add(new Prestamo(R.drawable.deck, "Jose pedro", 1000));
        prestamoList.add(new Prestamo(R.drawable.yo, "Damian cuk", 1000));
        prestamoList.add(new Prestamo(R.drawable.deck, "Luka Portnoi", 1000));
        prestamoList.add(new Prestamo(R.drawable.deck, "FDiego Poasdrtnoi", 1000));
        prestamoList.add(new Prestamo(R.drawable.deck, "Maradona lupe", 1000));
        prestamoList.add(new Prestamo(R.drawable.deck, "Tomy sinRottman", 1000));


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
        buscarPrestamo=(SearchView) layoutRhoot.findViewById(R.id.buscarPrestamo);
        filtros=(LottieAnimationView) layoutRhoot.findViewById(R.id.animation_view2);
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