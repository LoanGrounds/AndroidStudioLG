package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.DetallePrestamo;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Registro.InicioSesionFragment;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.time.DateTimeException;
import java.util.Date;


public class CrearPrestamoFragment extends Fragment {

    View layoutRhoot;
    Button btnCrear;
    EditText edtCantidadAPrestar;


    public CrearPrestamoFragment() {
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
        layoutRhoot = inflater.inflate(R.layout.fragment_crear_prestamo, container, false);
        ObtenerReferencia();
        SetearListners();


        return  layoutRhoot;
    }

   /* private DetallePrestamo inicializarDetalle() {
        DetallePrestamo detalle;

       detalle=new DetallePrestamo(1,6,3,5,,edtCantidadAPrestar.getText(),12);
        return detalle;
    }*/

    public void SetearListners() {
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetallePrestamo detallePrestamo= new DetallePrestamo(0,7,60,5,6,8000,1000,  null );
                tareaCrearDetalle nuevoDetalle = new tareaCrearDetalle(detallePrestamo);
                nuevoDetalle.execute();
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentVerificacionPrestamo();

            }
        });
    }

    private void ObtenerReferencia() {

        btnCrear=(Button) layoutRhoot.findViewById(R.id.btnCrearPrestamo);
        edtCantidadAPrestar=(EditText) layoutRhoot.findViewById(R.id.edtCantidadAPrestar);
    }

    //pongo acá para crear prestamo no se donde va
    private class tareaCrearPrestamo extends AsyncPostBase{

        private int idDetalle, idUsuario;
        public tareaCrearPrestamo(int idUsuario, int idDetalle) {
            super(ApiHelper.devolverUrlParaGet("Prestamos", "nuevo"));
            this.idDetalle = idDetalle;
            this.idUsuario = idUsuario;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setRequesMethod(RequestMethods.POST);
            setParams("IdDetallePrestamo", idDetalle);
            setParams("IdUsuarioPrestamista", idUsuario);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            CustomLog.log(s);
            //Felicidades create tu prestamo que se yo
        }
    }

    private class tareaCrearDetalle extends AsyncPostBase{
        private DetallePrestamo nuevoDetalle;
        public tareaCrearDetalle(DetallePrestamo detalle) {
            super(ApiHelper.devolverUrlParaGet("Prestamos", "nuevoDetalle"));
            nuevoDetalle = detalle;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //CARGANDO POR FAVOR ESPERE BLA VLA
            setRequesMethod(RequestMethods.POST);
            setParams("CantidadCuotas",nuevoDetalle.getCantidadCuotas());
            setParams("DiasEntreCuotas",nuevoDetalle.getDiasEntreCuotas());
            setParams("DiasTolerancia",nuevoDetalle.getDiasTolerancia());
            setParams("IdEstadoDePrestamo",5);
            setParams("Monto",nuevoDetalle.getMonto());
            setParams("InteresXCuota",nuevoDetalle.getInteresXCuota());
            setParams("FechaDeAcuerdo", (Date) null);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            CustomLog.log(s);
            Gson migson = new Gson();
            DetallePrestamo aux = migson.fromJson(s,DetallePrestamo.class);
            tareaCrearPrestamo crearPrestamo = new tareaCrearPrestamo(Session.currentUser.getId(),aux.getId());
            crearPrestamo.execute();

        }
    }

//ASYNC TASK PARA VER LOS PRESTAMOS NO VA ACA
    private  class tareaMisPrestamosPedidos extends AsyncTaskBase{

    public tareaMisPrestamosPedidos() {
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
        VistaPreviaPrestamo[] misPrestamos = miGson.fromJson(s,VistaPreviaPrestamo[].class);
        //llenar un list view ponele
    }
}

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
            //llenar un list view ponele
        }
    }


}