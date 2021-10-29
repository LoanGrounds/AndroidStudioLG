package com.example.ProyectoFinal.loangrounds.TabLayout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptadoraPrestados;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;


public class TabPrestados extends Fragment {


    View layoutRhoot;
    private TableLayout tableLayout;
    ViewPager viewPager;
    MainActivityInicio actividadContenedora;
    ListView listView,listViewSolicitados;

    List<VistaPreviaPrestamo> prestamoList;
    VistaPreviaPrestamo[] resultado;
    TabLayout tab;
    TabItem tabPrestados;
    TabItem tabSolicitados;


    public TabPrestados() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        layoutRhoot= inflater.inflate(R.layout.fragment_tab_prestados, container, false);
        ObtenerReferencia();
        TabPrestados.tareaMisPrestamosPrestados tareaPedidos = new TabPrestados.tareaMisPrestamosPrestados();
        tareaPedidos.execute();
        SetearListners();
        return layoutRhoot;
    }


    private void ObtenerReferencia() {

        actividadContenedora = (MainActivityInicio) getActivity();
        if(layoutRhoot != null){
            listView = (ListView) layoutRhoot.findViewById(R.id.listViewSolicitados);
            //tabSolicitados = (TabItem) layoutRhoot.findViewById(R.id.tabSolicitados);
            //tabPrestados= (TabItem) layoutRhoot.findViewById(R.id.tabPrestados);

        }


    }

    public void SetearListners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                VistaPreviaPrestamo pestamoSolici = resultado[position] ;
                CustomLog.logObject(resultado);
                actividadContenedora.setFragmentCadaSolicitado(pestamoSolici);
                actividadContenedora.setFragmentCadaSolicitado();

            }
        });}



    private  class tareaMisPrestamosPrestados extends AsyncTaskBase {

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
            resultado = miGson.fromJson(s,VistaPreviaPrestamo[].class);
            CustomLog.logObject("holaaa"+ resultado[0].getIdDetallePrestamo());
            ListaAdaptadoraPrestados nuevoAdapter = new ListaAdaptadoraPrestados(getActivity(),R.layout.my_list_item_listview, Arrays.asList(resultado.clone()));
            listView.setAdapter(nuevoAdapter);
            //llenar un list view ponele
        }
    }
}