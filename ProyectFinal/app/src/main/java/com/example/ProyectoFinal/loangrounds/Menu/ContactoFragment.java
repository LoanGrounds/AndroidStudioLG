package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskBase;
import com.example.ProyectoFinal.loangrounds.ListaRecomendados.ListaAdaptora;
import com.example.ProyectoFinal.loangrounds.MainActivityInicio;
import com.example.ProyectoFinal.loangrounds.Model.PrestamoRecomendadoDTO;
import com.example.ProyectoFinal.loangrounds.Model.Usuario;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Arrays;
import java.util.List;


public class ContactoFragment extends Fragment {
    View layoutRhoot;
    LinearLayout editarPerfil;
    LinearLayout prestamosRecientes;
    Usuario resultado;
    LinearLayout configuracion;
    LinearLayout atencionCliente;
    TextView tvNombreUsuario,tvOcupacion, tvDescripcion;
    ImageView imFotoUsuario;
    ConstraintLayout csContacto;
    public ContactoFragment() {
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
        layoutRhoot = inflater.inflate(R.layout.fragment_contacto, container, false);

        ObtenerReferencias();
        InicializarDatos();
        //VerUsuario verUsuario = new VerUsuario(Session.currentUser.getUserName());
        //verUsuario.execute();
        CustomLog.logObject(Session.currentUser);
        SetearListners();
        return layoutRhoot;
    }

    private void ObtenerReferencias() {
        editarPerfil=(LinearLayout) layoutRhoot.findViewById(R.id.editarPerfil);
        prestamosRecientes=(LinearLayout) layoutRhoot.findViewById(R.id.prestamosRecientes);
        configuracion=(LinearLayout) layoutRhoot.findViewById(R.id.configuracion);
        atencionCliente=(LinearLayout) layoutRhoot.findViewById(R.id.atencionCliente);
        tvNombreUsuario=(TextView) layoutRhoot.findViewById(R.id.tvNombreUsuario);
        tvOcupacion=(TextView) layoutRhoot.findViewById(R.id.tvOcupacion);
        tvDescripcion=(TextView) layoutRhoot.findViewById(R.id.tvDescripcion);
        imFotoUsuario=(ImageView) layoutRhoot.findViewById(R.id.imFotoUsuario);
        csContacto=(ConstraintLayout) layoutRhoot.findViewById(R.id.csContacto);
    }


    public void SetearListners() {


        editarPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentEditarPerfil();

            }
        });
        prestamosRecientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentPrestamosRecientes();

            }
        });
        configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentConfiguracion();

            }
        });
        atencionCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityInicio actividadContenedora;
                actividadContenedora = (MainActivityInicio) getActivity();
                actividadContenedora.setFragmentAtencionCliente();

            }
        });


    }



    private class VerUsuario extends AsyncTaskBase {


        public VerUsuario(String userName) {
            super(ApiHelper.devolverUrlParaGet("Usuarios","traerporUserName", userName));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            toastes.msj(getContext(),"Cargando por favor espero...");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            CustomLog.log("Usuario"+s);
            if (s!=null){
                Gson miGson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                        .create();
                resultado = miGson.fromJson(s, Usuario.class);

                tvNombreUsuario.setText(resultado.getUserName());
                tvOcupacion.setText(resultado.getOcupacion());
                tvDescripcion.setText(resultado.getDescripcion());
                csContacto.setVisibility(View.VISIBLE);
            }


        }

    }
    public void InicializarDatos(){
        tvNombreUsuario.setText(Session.currentUser.getUserName());
        tvOcupacion.setText(Session.currentUser.getOcupacion());
        tvDescripcion.setText(Session.currentUser.getDescripcion());
        csContacto.setVisibility(View.VISIBLE);
    }


}