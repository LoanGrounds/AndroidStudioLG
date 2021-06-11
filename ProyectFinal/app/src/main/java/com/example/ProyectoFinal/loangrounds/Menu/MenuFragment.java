package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.gson.Gson;


public class MenuFragment extends Fragment {
    FloatingActionButton fbtnCrearPrestamo;
    ListView listView;
    View layoutRhoot;
    List<PrestamoRecomendadoDTO> prestamoList;
    LottieAnimationView animation_view;
    ArrayList<PrestamoRecomendadoDTO> prestamoListApi=new ArrayList<>();



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
        prestamoList.add(new PrestamoRecomendadoDTO(4,1000,"Luka Portnoi",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(5,1500,"Fernando pedro",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(6,20000,"Gonzalo Turrezco",R.drawable.deck));
        prestamoList.add(new PrestamoRecomendadoDTO(7,1000,"Matas Besmedrisnik",R.drawable.yo));

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

    private class PrestamoRecomendadoAsinc extends AsyncTaskBase {


        public PrestamoRecomendadoAsinc(String b) {
            super(b);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            toastes.msj(getContext(),"Cargando por favor espero...");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s!=null){

                prestamoListApi=new Gson().fromJson(s, prestamoListApi.getClass());


            }}
    }

}