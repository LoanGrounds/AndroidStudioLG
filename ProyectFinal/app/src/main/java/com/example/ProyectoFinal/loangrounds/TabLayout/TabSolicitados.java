package com.example.ProyectoFinal.loangrounds.TabLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptadoraPrestados;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptadoraSolicitados;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;


public class TabSolicitados extends Fragment {

    List<VistaPreviaPrestamo> prestamoList;
    VistaPreviaPrestamo[] resultado;
    ListView listViewSolicitados;
    View layoutRhoot;
    MainActivityInicio actividadContenedora;

    public TabSolicitados() {
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
        layoutRhoot= inflater.inflate(R.layout.fragment_tab_solicitados, container, false);
        ObtenerReferencia();
        tareaMisPrestamosSolicitados tareaSolicitado = new tareaMisPrestamosSolicitados();
        tareaSolicitado.execute();
        SetearListners();
        return layoutRhoot;
    }


    private void ObtenerReferencia() {

        actividadContenedora = (MainActivityInicio) getActivity();
        if(layoutRhoot != null){
            listViewSolicitados = (ListView) layoutRhoot.findViewById(R.id.listViewSolicitados);
            //tabSolicitados = (TabItem) layoutRhoot.findViewById(R.id.tabSolicitados);
            //tabPrestados= (TabItem) layoutRhoot.findViewById(R.id.tabPrestados);

        }


    }

    public void SetearListners() {
        listViewSolicitados.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VistaPreviaPrestamo pestamoSolici = resultado[position] ;
                CustomLog.logObject(resultado);
                actividadContenedora.setFragmentCadaSolicitado(pestamoSolici);
                actividadContenedora.setFragmentCadaSolicitado();

            }
        });}



    private  class tareaMisPrestamosSolicitados extends AsyncTaskBase {

        public tareaMisPrestamosSolicitados() {
            super(ApiHelper.devolverUrlParaGet("Prestamos","misPrestamosPedidos"));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Gson miGson = new Gson();
            resultado = miGson.fromJson(s, VistaPreviaPrestamo[].class);
            ListaAdaptadoraSolicitados nuevoAdapter = new ListaAdaptadoraSolicitados(getActivity(),R.layout.my_list_item_listview, Arrays.asList(resultado.clone()));
            listViewSolicitados.setAdapter(nuevoAdapter);
            //llenar un list view ponele
        }
    }



}