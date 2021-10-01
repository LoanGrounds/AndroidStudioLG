package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.DetallePrestamo;
import com.example.ProyectoFinal.loangrounds.Model.VistaPreviaPrestamo;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Registro.InicioSesionFragment;
import com.example.ProyectoFinal.loangrounds.Utilidades.AlertHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.example.ProyectoFinal.loangrounds.Utilidades.ValidacionesHelpers;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;


public class CrearPrestamoFragment extends Fragment {

    View layoutRhoot;
    Button btnCrear;
    TextView tv_interes;
    SeekBar skbInteres;
    EditText edtCantidadAPrestar,edtDiasEntreCuotas;
    Spinner spinnerDropDown;
    MainActivityInicio main;
    int cantCoutas, diasEntreCuotas, diasTolerancia;
    double monto, interes;
    public CrearPrestamoFragment() {
        // Required empty public constructor
    }

    public boolean esValidoElPrestamo(){
        boolean aux = true;
        String errores = "";
        if(!ValidacionesHelpers.esNumeroValido(edtCantidadAPrestar)){
            aux = false;
            errores+= "el monto elegido no es valido";
        }
        if(!ValidacionesHelpers.esNumeroValido(edtDiasEntreCuotas)){
            aux = false;
            errores+= "el monto elegido no es valido";
        }if(!ValidacionesHelpers.esNumeroValido(skbInteres)){
            aux = false;
            errores+= "el monto elegido no es valido";
        }

        if(!aux) AlertHelper.mostrarAlertaError(main,errores);
        return aux;
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
        dropDown();
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
                if(esValidoElPrestamo()){
                    diasEntreCuotas = Integer.parseInt(edtDiasEntreCuotas.getText().toString().trim());
                    monto = Double.parseDouble(edtCantidadAPrestar.getText().toString().trim());
                    interes = Double.parseDouble(tv_interes.getText().toString().split(" %")[0].trim());
                    diasTolerancia = 10;
                    DetallePrestamo detallePrestamo= new DetallePrestamo(0,cantCoutas,diasEntreCuotas,diasTolerancia,5,monto,interes,  null );
                    tareaCrearDetalle nuevoDetalle = new tareaCrearDetalle(detallePrestamo);
                    nuevoDetalle.execute();
                    main.setFragmentVerificacionPrestamo();
                }




            }
        });
        skbInteres.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_interes.setText((String.valueOf(progress)+ " %"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                    skbInteres.setMax(15);
                    skbInteres.setMin(5);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void ObtenerReferencia() {
        main = (MainActivityInicio) getActivity();
        if(layoutRhoot != null){
            tv_interes =(TextView) layoutRhoot.findViewById(R.id.tv_Interes);
            edtCantidadAPrestar = (EditText) layoutRhoot.findViewById(R.id.edtCantidadAPrestar);
            edtDiasEntreCuotas = (EditText) layoutRhoot.findViewById(R.id.edtDiasEntreCuotas);
            btnCrear=(Button) layoutRhoot.findViewById(R.id.btnCrearPrestamo);
            edtCantidadAPrestar=(EditText) layoutRhoot.findViewById(R.id.edtCantidadAPrestar);
            spinnerDropDown=(Spinner) layoutRhoot.findViewById(R.id.spinnerDropDown);
            skbInteres = (SeekBar) layoutRhoot.findViewById(R.id.skbInteres);
        }


    }

    //pongo acá para crear prestamo no se donde va
    private class tareaCrearPrestamo extends AsyncPostBase{

        private int idDetalle, idUsuario;
        public tareaCrearPrestamo(int idUsuario, int idDetalle) {
            super(RequestMethods.POST,ApiHelper.devolverUrlParaGet("Prestamos", "nuevo"));
            this.idDetalle = idDetalle;
            this.idUsuario = idUsuario;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
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
            super(RequestMethods.POST,ApiHelper.devolverUrlParaGet("Prestamos", "nuevoDetalle"));
            nuevoDetalle = detalle;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //CARGANDO POR FAVOR ESPERE BLA VLA
            setParams("CantidadCuotas",nuevoDetalle.getCantidadCuotas());
            setParams("DiasEntreCuotas",nuevoDetalle.getDiasEntreCuotas());
            setParams("DiasTolerancia",nuevoDetalle.getDiasTolerancia());
            setParams("IdEstadoDePrestamo",5);
            setParams("Monto",nuevoDetalle.getMonto());
            setParams("InteresXCuota",nuevoDetalle.getInteresXCuota());
            setParams("FechaDeAcuerdo");
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
    AdapterView.OnItemSelectedListener select_coutas = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    cantCoutas = 1;
                    break;
                case 1:
                    cantCoutas = 3;
                    break;
                case 2:
                    cantCoutas = 6;
                    break;
                case 3:
                    cantCoutas = 12;
                    break;

                default:
                    cantCoutas = 1;
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    public void dropDown(){
        ArrayAdapter<String> miDrpdown= new ArrayAdapter<String>(main, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.cantidad_cuotas));
        miDrpdown.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDropDown.setAdapter(miDrpdown);
        spinnerDropDown.setOnItemSelectedListener(select_coutas);
    }




}