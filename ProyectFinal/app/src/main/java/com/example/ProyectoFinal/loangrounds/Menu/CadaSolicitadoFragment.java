package com.example.ProyectoFinal.loangrounds.Menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.DetallePrestamo;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.AlertHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;


public class CadaSolicitadoFragment extends Fragment {

    TextView tvIntereses,tvDinero,tvDiasEntreCuota,tvCantCuotas,tvNombre, tvDiaTol;
    VistaPreviaPrestamo prestamo;
    MainActivityInicio main;
    Button btn_acpetar, btn_cancelar, btn_notificar, btn_borrarPrestamo;
    public void setDetalle(VistaPreviaPrestamo v){
        prestamo = v;
    }

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
        main = (MainActivityInicio) getActivity();
        if(layoutRhoot!= null) {
            tvDinero = (TextView) layoutRhoot.findViewById(R.id.tvDinero);
            tvDiasEntreCuota = (TextView) layoutRhoot.findViewById(R.id.tvCantMeses);
            tvIntereses = (TextView) layoutRhoot.findViewById(R.id.tvInteres);
            tvDiaTol = (TextView) layoutRhoot.findViewById(R.id.tvDiaTol);
            tvCantCuotas = (TextView) layoutRhoot.findViewById(R.id.tvCantCuotas);
            btn_acpetar = (Button) layoutRhoot.findViewById(R.id.btnAceptar);
            btn_cancelar = (Button) layoutRhoot.findViewById(R.id.btnRechazar);
            btn_borrarPrestamo = (Button) layoutRhoot.findViewById(R.id.btnCancelarPrestamo);
            tvNombre = (TextView) layoutRhoot.findViewById(R.id.tvNombre);
            if (prestamo != null) {
                tvNombre.setText(prestamo.getPrestamista());
            }
        }

        switch (prestamo.getEstado()){
            case "Solicitado":
                btn_acpetar.setVisibility(View.VISIBLE);
                btn_cancelar.setVisibility(View.VISIBLE);
                btn_borrarPrestamo.setVisibility(View.INVISIBLE);
                break;
            case "Activo":
                btn_acpetar.setVisibility(View.INVISIBLE);
                btn_cancelar.setVisibility(View.INVISIBLE);
                btn_borrarPrestamo.setVisibility(View.INVISIBLE);
                break;
            case "Demorado":
                btn_acpetar.setVisibility(View.INVISIBLE);
                btn_cancelar.setVisibility(View.INVISIBLE);
                btn_borrarPrestamo.setVisibility(View.INVISIBLE);
                break;
            case "Caducado":
                btn_acpetar.setVisibility(View.INVISIBLE);
                btn_cancelar.setVisibility(View.INVISIBLE);
                btn_borrarPrestamo.setVisibility(View.INVISIBLE);
                break;
            default:
                btn_acpetar.setVisibility(View.INVISIBLE);
                btn_cancelar.setVisibility(View.INVISIBLE);
                btn_borrarPrestamo.setVisibility(View.VISIBLE);

        }
    }

    private void inicializarDatos() {
    }

    private void SetearListners() {
        btn_borrarPrestamo.setOnClickListener(btn_borrar_click);
        btn_cancelar.setOnClickListener(btn_cancelar_click);
        btn_acpetar.setOnClickListener(btn_aceptar_click);

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

    private class EliminarPrestamo extends AsyncPostBase{

        public EliminarPrestamo(int id) {
            super(RequestMethods.DELETE, ApiHelper.devolverUrlParaGet("Prestamos","borrar",String.valueOf(id)));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            AlertHelper.mostrarMensaje(main, "Se borro tu prestamo con exito");
        }
    }

    View.OnClickListener btn_borrar_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EliminarPrestamo eliminar = new EliminarPrestamo(prestamo.getIdDetallePrestamo());
            eliminar.execute();
        }
    };

    View.OnClickListener btn_cancelar_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AceptarPrestamoTarea rechazar = new AceptarPrestamoTarea(prestamo.getIdDetallePrestamo(),false);
            rechazar.execute();
            //NOTIFICAR AL OTRO USUARIO QUE LO RECHAZARON
        }
    };

    View.OnClickListener btn_aceptar_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AceptarPrestamoTarea aceptar = new AceptarPrestamoTarea(prestamo.getIdDetallePrestamo(),true);
            aceptar.execute();
            //NOTIFICAR AL OTRO USUARIO QUE LO ACEPTARON
        }
    };

    private class AsyncTaskGetDetalle  extends AsyncTaskBase {
        private DetallePrestamo detalle;
        public AsyncTaskGetDetalle() {
            super(ApiHelper.devolverUrlParaGet("Detalles", "obtenerPorId", String.valueOf(prestamo.getIdDetallePrestamo())));
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!s.equals("")){
                Gson miGson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                        .create();
                detalle  = miGson.fromJson(s,DetallePrestamo.class);
                if(detalle!= null){
                    double interes=detalle.getInteresXCuota();
                    tvIntereses.setText(String.valueOf(interes));
                    tvCantCuotas.setText(String.valueOf(detalle.getCantidadCuotas()));
                    tvDiasEntreCuota.setText(String.valueOf(detalle.getDiasEntreCuotas()));
                }


            }
        }


    }

}