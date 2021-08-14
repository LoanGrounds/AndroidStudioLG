package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.Model.DetallePrestamo;
import com.example.ProyectoFinal.loangrounds.Model.Prestamo;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;


public class CadaPrestamoFragment extends Fragment {

    TextView tvIntereses,tvDinero,tvDiasEntreCuota,tvCantCuotas,tvNombre, tvDiaTol;
    DetallePrestamo detalle;
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
        PrestamoObtenido getDetalle = new PrestamoObtenido(prest.Id);
        getDetalle.execute();

    }


    private void obtenerReferencias() {
        tvDinero= (TextView) layoutRhoot.findViewById(R.id.tvDinero);
        tvDiasEntreCuota=(TextView) layoutRhoot.findViewById(R.id.tvCantMeses);
        tvIntereses=(TextView) layoutRhoot.findViewById(R.id.tvInteres);
        tvDiaTol=(TextView) layoutRhoot.findViewById(R.id.tvDiaTol);
        tvCantCuotas=(TextView) layoutRhoot.findViewById(R.id.tvCantCuotas);
        tvNombre=(TextView) layoutRhoot.findViewById(R.id.tvNombre);
        btnSolicitar=(Button) layoutRhoot.findViewById(R.id.btnSolicitar);
        clCadaPrestamo=(ConstraintLayout) layoutRhoot.findViewById(R.id.clCadaPrestamo);
        pgCargando3=(ProgressBar) layoutRhoot.findViewById(R.id.pgCargando3);
    }

    View.OnClickListener btnSolicitar_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            MainActivityInicio actividadContenedora;
            actividadContenedora = (MainActivityInicio) getActivity();
            actividadContenedora.setFragmentMetodoPago();

        }
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
                //Gson miGson = new Gson();
                //Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
                Gson miGson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                        .create();
                detalle = miGson.fromJson(s,DetallePrestamo.class);
                if(detalle!=null){
                    CustomLog.log(detalle.getFechaDeAcuerdo().toString());
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
}