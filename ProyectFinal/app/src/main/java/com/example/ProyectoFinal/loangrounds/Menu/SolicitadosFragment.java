package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;

import java.util.ArrayList;
import java.util.List;


public class SolicitadosFragment extends Fragment {

    ListView listView;
    View layoutRhoot;
    List<PrestamoRecomendadoDTO> prestamoList;
    public SolicitadosFragment() {
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
        layoutRhoot= inflater.inflate(R.layout.fragment_solicitados, container, false);
        prestamoList= new ArrayList<>();
        prestamoList.add(new PrestamoRecomendadoDTO(4,1000,"Luka Portnoi",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(5,1500,"Fernando pedro",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(6,20000,"Gonzalo Turrezco",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(7,1000,"Matas Besmedrisnik",R.drawable.yo));


        listView = (ListView) layoutRhoot.findViewById(R.id.listView);
        ListaAdaptora adapter= new ListaAdaptora(getActivity(),R.layout.my_list_item,prestamoList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();

                actividadContenedora.setFragmentCadaSolicitado();
                actividadContenedora.EnviarMensajeSolicitado(position, prestamoList);



            }
        });

        return layoutRhoot;
    }
}