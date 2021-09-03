package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.LupaAdapter;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.BusquedaFiltradaDTO;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.gson.Gson;


public class MenuFragment extends Fragment {
    FloatingActionButton fbtnCrearPrestamo;
    ListView listView;
    View layoutRhoot;
    LupaAdapter lupaAdapter;
    ProgressBar pgCargando;
    ConstraintLayout clMenu;

    SearchView buscarPrestamo;
    ImageView filtros;
    ArrayList<PrestamoRecomendadoDTO> prestamoList;

    LottieAnimationView animation_view;
    ArrayList<PrestamoRecomendadoDTO> prestamoListApi=new ArrayList<>();
    PrestamoRecomendadoDTO[] resultado;



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

        ObtenerReferencia();



        PrestamoRecomendadoAsinc tareaRecomendados = new PrestamoRecomendadoAsinc(50000/* monto arbitrario cambiar despues*/);
        tareaRecomendados.execute();
        //probar como funciona este metodo con la api conectada

        SetearListners();


        return layoutRhoot;

    }

    private void ObtenerReferencia() {
        listView = (ListView) layoutRhoot.findViewById(R.id.listView);
        fbtnCrearPrestamo=(FloatingActionButton) layoutRhoot.findViewById(R.id.fbtnCrearPrestamo);
        buscarPrestamo=(SearchView) layoutRhoot.findViewById(R.id.searchBuscarPrestamo);
        filtros=(ImageView) layoutRhoot.findViewById(R.id.btnFiltros);
        pgCargando=(ProgressBar) layoutRhoot.findViewById(R.id.pgCargando);
        clMenu=(ConstraintLayout) layoutRhoot.findViewById(R.id.clMenu);

    }


    public void SetearListners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                PrestamoRecomendadoDTO pestamoSolici = resultado[position] ;


                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();

                actividadContenedora.setFragmentCadaPrestamo();
                actividadContenedora.EnviarMensaje(pestamoSolici);



            }
        });
        fbtnCrearPrestamo.setOnClickListener(fbtnCrearPrestamo_Click);



        filtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentFiltros();

            }
        });
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


        public PrestamoRecomendadoAsinc(int montoMax) {
            super(ApiHelper.devolverUrlParaGet("Prestamos","recomendados",String.valueOf(montoMax)));
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
                Gson miGson = new Gson();
                resultado = miGson.fromJson(s,PrestamoRecomendadoDTO[].class);
                ListaAdaptora nuevoAdapter = new ListaAdaptora(getActivity(),R.layout.my_list_item_listview, Arrays.asList(resultado.clone()));
                listView.setAdapter(nuevoAdapter);

            }

            pgCargando.setVisibility(View.GONE);
            clMenu.setVisibility(View.VISIBLE);


        }
    }


    // HAGO LA BUSQUEDA FILTRADA ACA NO SE DONDE VA
     private class FiltrarPrestamosAsync extends AsyncTaskBase {

        public FiltrarPrestamosAsync(double montoMax, double maxInteres, int minDiasT, int minDiasCoutas,
                                     int minCantCuotas) {
            super(ApiHelper.devolverUrlParaGet("Prestamos","BusquedaFiltrada"));
            if(montoMax == 0) setParams("montoMax", (String) null); else setParams("montoMax",montoMax);
            if(maxInteres == 0) setParams("maxInteres", (String) null); else setParams("maxInteres",maxInteres);
            if(minDiasT == 0) setParams("minDiasT",(String) null); else setParams("minDiasT",minDiasT);
            if(minDiasCoutas == 0) setParams("minDiasCoutas",(String) null); else setParams("minDiasCoutas",minDiasCoutas);
            if(minCantCuotas == 0) setParams("minCantCuotas",(String) null); else setParams("minCantCuotas",minCantCuotas);
            if (Session.currentUser.getId() == 0) setParams("idUsuario", 5);// numero precargado
            else setParams("idUsuario", Session.currentUser.getId());
        }
        public FiltrarPrestamosAsync(double montoMax, double maxInteres, int minDiasT, int minDiasCoutas){
            this(montoMax,maxInteres,minDiasT,minDiasCoutas,0);
        }
        public FiltrarPrestamosAsync(double montoMax, double maxInteres, int minDiasT){
            this(montoMax,maxInteres,minDiasT,0);
        }
        public FiltrarPrestamosAsync(double montoMax, double maxInteres){
            this(montoMax,maxInteres,0);
        }
        public FiltrarPrestamosAsync(double montoMax){
            this(montoMax,0);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson migson = new Gson();
            BusquedaFiltradaDTO[] resultado =  migson.fromJson(s,BusquedaFiltradaDTO[].class);
            // hacer lo que haya que hacer
        }
    }




}