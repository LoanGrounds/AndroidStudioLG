package com.example.ProyectoFinal.loangrounds.Registro;

import android.graphics.ImageDecoder;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.Model.Localidad;
import com.example.ProyectoFinal.loangrounds.Model.Provincia;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.AlertHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.ValidacionesHelpers;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class RegistroFragment extends Fragment {

    Button btnSiguiente;
    MainActivity main;
    View layoutRhoot;
    EditText edtUserName, edtEmail,edtApellido,edtPassword,edtTelefono,edtCiudad,edtNombre,edtProv,edtDireccion,edtDni,edtCBU,edtAlias,edtCuit, edtCheckPassword;
    LinearLayout item1;
    LinearLayout item2;
    LinearLayout item3;
    LinearLayout item4;
    Provincia[] listaProvincias;
    Localidad[] listaLocalidades;
    int contador = 0;


    public RegistroFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contador = 0;
        layoutRhoot = inflater.inflate(R.layout.fragment_registro, container, false);

        ObtenerReferencias();
        SetearListners();
        return layoutRhoot;

    }

    public boolean esFormualarioValido(){
        boolean aux = true;
        String errores = "";
        if(!ValidacionesHelpers.esContraFuerte(edtPassword)){
            aux = false;
            errores += "La contraseña ingresada no es lo suficientemente segura \n"; // se puede ir mostrando con color despues
        }
        if(!edtPassword.getText().toString().trim().equals(edtCheckPassword.getText().toString().trim())){
            aux = false;
            errores += "Las contraseñas no coinciden \n";
        }
        if(!ValidacionesHelpers.esStringValido(edtTelefono)){
            aux = false;
            errores += "El telefono no es valido \n";
        }
        if(!ValidacionesHelpers.esStringValido(edtApellido)){
            aux = false;
            errores += "El apellido no es valido \n";
        }
        if(!ValidacionesHelpers.esStringValido(edtDireccion)){
            aux = false;
            errores += "la  direccion no es valida \n";
        }
        if(!ValidacionesHelpers.esStringValido(edtDni)){
            aux = false;
            errores += "El Dni no es valido \n";
        }
        if(!ValidacionesHelpers.esStringValido(edtNombre)){
            aux = false;
            errores += "El nombre no es valido \n";
        }
        // FALTAN EDIT TEXT PARA NOMBRE DE USUARIO,  OCUPACION, FECHA DE NACIMIENTO Y SEGURO ME OLIVDO DE ALGUNO
        if(!aux) AlertHelper.mostrarAlertaError(getContext(), errores);
        return aux;
    }



    private void ObtenerReferencias() {
        main = (MainActivity) getActivity();
        btnSiguiente = (Button) layoutRhoot.findViewById(R.id.btnSiguiente);
        edtAlias = (EditText) layoutRhoot.findViewById(R.id.edtAlias);
        edtEmail = (EditText) layoutRhoot.findViewById(R.id.edtMail);
        edtCiudad = (EditText) layoutRhoot.findViewById(R.id.edtCiudad);
         edtCuit= (EditText) layoutRhoot.findViewById(R.id.edtCuit);
        edtCBU = (EditText) layoutRhoot.findViewById(R.id.edtCBU);
        edtDni = (EditText) layoutRhoot.findViewById(R.id.edtDni);
        edtDireccion = (EditText) layoutRhoot.findViewById(R.id.edtDireccion);
        edtProv = (EditText) layoutRhoot.findViewById(R.id.edtProv);
        edtTelefono = (EditText) layoutRhoot.findViewById(R.id.edtTelefono);
        edtPassword = (EditText) layoutRhoot.findViewById(R.id.edtPassword);
        edtCheckPassword  = (EditText) layoutRhoot.findViewById(R.id.edtCheckPassword);
        edtNombre = (EditText) layoutRhoot.findViewById(R.id.edtNombre);
        edtApellido = (EditText) layoutRhoot.findViewById(R.id.edtApellido);

        tareaGetLocalidades tarealocalidaes = new tareaGetLocalidades();
        tarealocalidaes.execute();
        tareaGetProvincias tareaProvs = new tareaGetProvincias();
        main.StartAsyncTaskInParallel(tareaProvs);








    }


    public void SetearListners() {
        btnSiguiente.setOnClickListener(btnSiguiente_Click);

    }

    View.OnClickListener btnSiguiente_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            contador++;

            Log.i("Hola", "" + contador);
            if (contador == 1) {
                item1 = layoutRhoot.findViewById(R.id.LinearLayout1);
                item1.setVisibility(View.INVISIBLE);
                item2 = layoutRhoot.findViewById(R.id.LinearLayout2);
                item2.setVisibility(View.VISIBLE);

            }
            if (contador == 2) {
                item2 = layoutRhoot.findViewById(R.id.LinearLayout2);
                item2.setVisibility(View.INVISIBLE);
                item3 = layoutRhoot.findViewById(R.id.LinearLayout3);
                item3.setVisibility(View.VISIBLE);

            }
            if (contador == 3) {
                item3 = layoutRhoot.findViewById(R.id.LinearLayout3);
                item3.setVisibility(View.INVISIBLE);
                item4 = layoutRhoot.findViewById(R.id.LinearLayout4);
                item4.setVisibility(View.VISIBLE);
                btnSiguiente.setText("Crear cuenta");

            }
            if (contador == 4) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                int count = fm.getBackStackEntryCount();
                for (int i = 0; i < count; ++i) {
                    fm.popBackStack();
                }
                contador = 0;
                RegistroUsuarioAsync tarea = new RegistroUsuarioAsync();
                tarea.execute();

            }


        }
    };

    private class RegistroUsuarioAsync extends AsyncPostBase {


        public RegistroUsuarioAsync() {
            super(ApiHelper.devolverUrlParaGet("Usuarios", "signup"));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            toastes.msj(getContext(), "Cargando por favor espero...");
            setParams("Nombre", edtNombre.getText().toString().trim());
            setParams("Apellido",edtApellido.getText().toString().trim());
            setParams("Mail",edtEmail.getText().toString().trim());
            setParams("CBU",edtCBU.getText().toString().trim());
            setParams("Password",edtPassword.getText().toString().trim());
            setParams("InteresXCuota",edtCiudad.getText().toString().trim());
            setParams("CBUAlias", edtAlias.getText().toString().trim());
            setParams("Direccion", edtDireccion.getText().toString().trim());
            setParams("DNI", edtDni.getText().toString().trim());
            setParams("IdLocalidad", 5);
            setParams("Telefono", edtTelefono.getText().toString().trim());
            setParams("UserName", String.format("%s %s",edtNombre.getText().toString().trim(),edtApellido.getText().toString().trim()));
            setParams("CUIT", edtCuit.getText().toString().trim());
            setParams("IdGenero", 2);
            setParams("URLFoto", "");
            setParams("CantidadPrestamosExitosos", 0);
            setParams("Puntos", 0);
            setParams("FechaNacimiento", "1999-08-20");
            setParams("FechaCreacion","2021-10-25");
            setParams("Descripcion", "la mama de chino");
            setParams("Ocupacion", "el papa de chino");


        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (!s.equals("")) {
                CustomLog.log(s);
                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();
                actividadContenedora.setFragmentSesionRegistro();

            }
        }

    }

    private class tareaGetProvincias extends AsyncTaskBase {

        public tareaGetProvincias() {
            super(ApiHelper.devolverUrlParaGet("Varios", "Provincias", "Ver"));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //nada
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!s.equals("")){
                Gson miGson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                        .create();
                listaProvincias = miGson.fromJson(s,Provincia[].class);
                //llenar dropdown

            }
            else{
                CustomLog.log("me llego vacio");
            }
        }
    }

    private class tareaGetLocalidades extends AsyncTaskBase {

        public tareaGetLocalidades() {
            super(ApiHelper.devolverUrlParaGet("Varios", "Localidades", "Ver"));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //nada
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(!s.equals("")){
                Gson miGson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                        .create();
                listaLocalidades = miGson.fromJson(s,Localidad[].class);
                //llenar dropdown

            }
            else{
                CustomLog.log("me llego vacio");
            }
        }
    }
}