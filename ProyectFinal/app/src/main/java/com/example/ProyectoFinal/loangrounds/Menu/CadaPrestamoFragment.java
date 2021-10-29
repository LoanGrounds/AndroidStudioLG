package com.example.ProyectoFinal.loangrounds.Menu;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.Model.DetallePrestamo;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class CadaPrestamoFragment extends Fragment {

    TextView tvIntereses,tvDinero,tvDiasEntreCuota,tvCantCuotas,tvNombre, tvDiaTol;
    DetallePrestamo detalle;
    MainActivityInicio actividadContenedora;
    PrestamoRecomendadoDTO prest;
    Button btnSolicitar;
    View layoutRhoot;
    ProgressBar pgCargando3;
    ConstraintLayout clCadaPrestamo;
    public CadaPrestamoFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        layoutRhoot=inflater.inflate(R.layout.fragment_cada_prestamo, container, false);
        obtenerReferencias();
        inicializarDatos();
        SetearListners();
        return layoutRhoot;

    }

    private void SetearListners() {
        btnSolicitar.setOnClickListener(btnSolicitar_Click);
    }
    private void inicializarDatos(){
        String nombre=prest.UserName;
        int diner=prest.Monto;
        tvDinero.setText("$"+String.valueOf(diner));
        tvNombre.setText(nombre);
        PrestamoObtenido getDetalle = new PrestamoObtenido(prest.IdDetalle);
        getDetalle.execute();

    }


    private void obtenerReferencias() {
        actividadContenedora = (MainActivityInicio) getActivity();
        tvDinero= (TextView) layoutRhoot.findViewById(R.id.tvDinero);
        tvDiasEntreCuota=(TextView) layoutRhoot.findViewById(R.id.tvCantMeses);
        tvIntereses=(TextView) layoutRhoot.findViewById(R.id.tvInteres);
        tvDiaTol=(TextView) layoutRhoot.findViewById(R.id.tvDiaTol);
        tvCantCuotas=(TextView) layoutRhoot.findViewById(R.id.tvCantCuotas);
        tvNombre=(TextView) layoutRhoot.findViewById(R.id.tvNombre);
        btnSolicitar=(Button) layoutRhoot.findViewById(R.id.btnSolicitarPrestamo);
        clCadaPrestamo=(ConstraintLayout) layoutRhoot.findViewById(R.id.clCadaPrestamo);
        pgCargando3=(ProgressBar) layoutRhoot.findViewById(R.id.pgCargando3);
    }

    View.OnClickListener btnSolicitar_Click = v ->{
            solicitarPrestamoTarea solicitar = new solicitarPrestamoTarea();
            cambiarPrestamo cambiar = new cambiarPrestamo(Session.currentUser.getId());
            solicitar.execute();
            solicitar.StartAsyncTaskInParallel(cambiar);
            // NO SE QUE MAS HACER ACA DESPUES DE QUE SE SOLICITA
    };

    public void enviarPosition(PrestamoRecomendadoDTO prestamoList ){
        prest = prestamoList;

    }

    private class PrestamoObtenido extends AsyncTaskBase {


        public PrestamoObtenido(int id) {
            super(ApiHelper.devolverUrlParaGet("Detalles","obtenerPorId",String.valueOf(id)));
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
                detalle = DetallePrestamo.fromjson(s);
                if(detalle!=null){
                    double interes=detalle.getInteresXCuota();
                    tvIntereses.setText(String.valueOf(interes));
                    tvCantCuotas.setText(String.valueOf(detalle.getCantidadCuotas()));
                    tvDiasEntreCuota.setText(String.valueOf(detalle.getDiasEntreCuotas()));
                    tvDiaTol.setText(String.valueOf(detalle.getDiasTolerancia()));
                }
            }
            pgCargando3.setVisibility(View.GONE);
            clCadaPrestamo.setVisibility(View.VISIBLE);
        }
    }

    private class solicitarPrestamoTarea extends AsyncPostBase{

        public solicitarPrestamoTarea() {
            super(RequestMethods.PUT,ApiHelper.devolverUrlParaGet("Detalles", "update"));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setParams("Id", detalle.getId());
            setParams("IdEstadoDePrestamo", 1); // cambia el estado a solicitado}
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //ENVIAR NOTIFICACION AL PRESTAMISTA QUE FUE SOLICITADO. lUEGO SI ACEPTA ENTONCES SE DEFINE
            // LA FECAH DE ACUERDO
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class cambiarPrestamo extends AsyncPostBase{
        private final int idPrestatario;

        public cambiarPrestamo(int idPrestatario) {
            super(RequestMethods.PUT,ApiHelper.devolverUrlParaGet("Prestamos", "update"));
            this.idPrestatario = idPrestatario;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setParams("Id", prest.Id);
            setParams("IdUsuarioPrestador", idPrestatario); // cambia el estado a solicitado
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // AVISAR AL PRESTATARIO QUE SE SOLICITO CON EXITO
        }
    }
}