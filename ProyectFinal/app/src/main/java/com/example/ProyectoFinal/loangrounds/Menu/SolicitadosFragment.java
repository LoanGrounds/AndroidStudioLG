package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptadoraPrestados;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.TabLayout.TabAdapter;
import com.example.ProyectoFinal.loangrounds.TabLayout.TabPrestados;
import com.example.ProyectoFinal.loangrounds.TabLayout.TabSolicitados;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SolicitadosFragment extends Fragment {

    private  TableLayout tableLayout;
    ViewPager viewPager;
    MainActivityInicio actividadContenedora;
    ListView listView,listViewSolicitados;
    View layoutRhoot;
    List<VistaPreviaPrestamo> prestamoList;
    VistaPreviaPrestamo[] resultado;
    TabLayout tab;
    TabItem tabPrestados;
    TabItem tabSolicitados;

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

        tab =  layoutRhoot.findViewById(R.id.tabLayout);
        viewPager = layoutRhoot.findViewById(R.id.viewpager);

        tab.setupWithViewPager(viewPager);

        TabAdapter tabAdapter =new TabAdapter(  getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabAdapter.addFragment(new TabPrestados(), "Prestados");
        tabAdapter.addFragment(new TabSolicitados(), "Solicitados");
        viewPager.setAdapter(tabAdapter);


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

}


