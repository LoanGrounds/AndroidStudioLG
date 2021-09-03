package com.example.ProyectoFinal.loangrounds.Menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;

import java.util.List;


public class CadaSolicitadoFragment extends Fragment {


    List<PrestamoRecomendadoDTO> prest;
    View layoutRhoot;

    public CadaSolicitadoFragment() {
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
        layoutRhoot= inflater.inflate(R.layout.fragment_cada_solicitado, container, false);
        obtenerReferencias();
        inicializarDatos();
        SetearListners();


        return layoutRhoot;
    }

    private void obtenerReferencias() {
    }

    private void inicializarDatos() {
    }

    private void SetearListners() {
    }

    public void enviarPosition(List<PrestamoRecomendadoDTO> prestamoList ){

        prest = prestamoList;



    }

    //No se donde estan todos los solicitados pero aca esta la task
    private class AceptarPrestamoTarea extends AsyncPostBase {
        private int IdDetalle;
        private boolean acepto;

        public AceptarPrestamoTarea(int id, boolean acepto) {
            super(RequestMethods.PUT, ApiHelper.devolverUrlParaGet("Detalles", "update"));
            IdDetalle = id;
            this.acepto = acepto;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setParams("Id", IdDetalle);
            if(acepto){
                setParams("IdEstadoDePrestamo", 2); // cambia el estado a Activo
                setParams("FechaDeAcuerdo", "2021-05-24"); // fecha random
            }
            else{
                setParams("IdEstadoDePrestamo", 5);//Lo vuelve a poner disponible
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!acepto){
                cambiarPrestamo reset = new cambiarPrestamo(27);
                reset.execute();
                        //Necesito conseguir de donde viene el prestamo
            }
            //ENVIAR NOTIFICACION AL PRESTATARIO QUE FUE ACEPTADO
        }
    }


    @SuppressLint("StaticFieldLeak")
    private class cambiarPrestamo extends AsyncPostBase{
        private final int idPrestamo;

        public cambiarPrestamo(int idPrestamo) {
            super(RequestMethods.PUT,ApiHelper.devolverUrlParaGet("Prestamos", "update"));
            this.idPrestamo = idPrestamo;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setParams("Id", idPrestamo);
            setParams("IdUsuarioPrestador"); // cambia el Prestatario a null
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // AVISAR AL PRESTATARIO QUE SE SOLICITO CON EXITO
        }
    }
}