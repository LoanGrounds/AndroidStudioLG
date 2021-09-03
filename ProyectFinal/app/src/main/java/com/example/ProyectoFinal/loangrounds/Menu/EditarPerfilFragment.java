package com.example.ProyectoFinal.loangrounds.Menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncTaskGetUsuario;
import com.example.ProyectoFinal.loangrounds.Model.Usuario;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class EditarPerfilFragment extends Fragment {

    View layoutRhoot;

    public EditarPerfilFragment() {
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
        layoutRhoot=inflater.inflate(R.layout.fragment_editar_perfil, container, false);
        return layoutRhoot;
    }


    private class tareaEditarPerfil extends AsyncPostBase{

        public tareaEditarPerfil() {
            super(RequestMethods.PUT,ApiHelper.devolverUrlParaGet("Usuarios", "upadte"));
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            setParams("fechaNacimiento", "24-04-2003");
            // Dependiendo de que cambio vas llenando params
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s!= null){
                Gson miGson = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                        .create();
                Session.currentUser = AsyncTaskGetUsuario.devolerUsuario(Session.currentUser.getId());
            }
        }
    }
}