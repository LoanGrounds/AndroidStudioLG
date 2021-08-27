package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptadoraPrestados;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolicitadosFragment extends Fragment {

    ListView listView;
    View layoutRhoot;
    List<VistaPreviaPrestamo> prestamoList;
    VistaPreviaPrestamo[] resultado;

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

        layoutRhoot= inflater.inflate(R.layout.fragment_solicitados, container, false);
        ObtenerReferencia();
        tareaMisPrestamosPrestados tareaPedidos = new tareaMisPrestamosPrestados();
        tareaPedidos.execute();
        SetearListners();
        return layoutRhoot;
    }

    /*private class PrestamosPedidosAsinc extends AsyncTaskBase {


        public PrestamosPedidosAsinc() {
            super(ApiHelper.devolverUrlParaGet("Prestamos","misPrestamosPedidos"));
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
                resultado = miGson.fromJson(s,VistaPreviaPrestamo[].class);
                ListaAdaptadoraPrestados nuevoAdapter = new ListaAdaptadoraPrestados(getActivity(),R.layout.my_list_item_listview, Arrays.asList(resultado.clone()));
                listView.setAdapter(nuevoAdapter);


            }


        }
    }*/
    private void ObtenerReferencia() {
        listView = (ListView) layoutRhoot.findViewById(R.id.listViewPrestados);


    }

    public void SetearListners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                VistaPreviaPrestamo pestamoSolici = resultado[position] ;


                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();

                actividadContenedora.setFragmentCadaPrestamo();




            }
        });}



    private  class tareaMisPrestamosPrestados extends AsyncTaskBase{

        public tareaMisPrestamosPrestados() {
            super(ApiHelper.devolverUrlParaGet("Prestamos","misPrestamosPrestados"));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson miGson = new Gson();
            VistaPreviaPrestamo[] misPrestamos = miGson.fromJson(s,VistaPreviaPrestamo[].class);
            ListaAdaptadoraPrestados nuevoAdapter = new ListaAdaptadoraPrestados(getActivity(),R.layout.my_list_item_listview, Arrays.asList(misPrestamos.clone()));
            listView.setAdapter(nuevoAdapter);
            //llenar un list view ponele
        }
    }

}


