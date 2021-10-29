package com.example.ProyectoFinal.loangrounds.Registro;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.MainActivity;
import com.example.ProyectoFinal.loangrounds.Model.Usuario;
import com.example.ProyectoFinal.loangrounds.R;
import com.example.ProyectoFinal.loangrounds.Utilidades.AlertHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.example.ProyectoFinal.loangrounds.Utilidades.SharedPreferencesManager;
import com.example.ProyectoFinal.loangrounds.Utilidades.toastes;
import com.example.ProyectoFinal.loangrounds.entidades.Configuracion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class InicioSesionFragment extends Fragment {

    View layoutRhoot;
    Button btnIn;
    EditText edtEmail;
    EditText edtPassword;
  /*  ProgressBar pgCargando2;
    ConstraintLayout clInicionSesion;*/

    public InicioSesionFragment() {
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
        layoutRhoot = inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
        ObtenerReferencias();
        SetearListners();
        return layoutRhoot;
    }

    View.OnClickListener btnIn_Click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String mail = edtEmail.getText().toString().trim();
            String clave = edtPassword.getText().toString().trim();
            if(mail.equals("") || clave.equals("")){
                toastes.msj(getContext(),"Por favor completa con mail y contraseña");
            }
            else{
                /*clInicionSesion.setVisibility(View.GONE);
                pgCargando2.setVisibility(View.VISIBLE);*/
                Login login = new Login(mail,clave);
                login.execute();

            }


        }
    };


    public void SetearListners() {
        btnIn.setOnClickListener(btnIn_Click);

    }

    private void ObtenerReferencias() {
        btnIn = (Button) layoutRhoot.findViewById(R.id.btnIn);
        edtEmail = (EditText) layoutRhoot.findViewById(R.id.edtNombreUsuario);
        edtPassword = (EditText) layoutRhoot.findViewById(R.id.edtApellido);
        /*pgCargando2=(ProgressBar) layoutRhoot.findViewById(R.id.pgCargando2);
        clInicionSesion=(ConstraintLayout) layoutRhoot.findViewById(R.id.clInicioSesion);*/
    }


    public class Login extends AsyncPostBase {

        private final String mail;
        private final String password;
        public Login(String mail, String password){
            super(RequestMethods.POST,ApiHelper.devolverUrlParaGet("Usuarios","login"));
            this.mail = mail;
            this.password = password;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.setParams("Mail",mail);
            this.setParams("Password",password);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("")){/*pgCargando2.setVisibility(View.INVISIBLE) ;clInicionSesion.setVisibility(View.VISIBLE);*/ AlertHelper.mostrarAlertaError(getContext(), "Usuario o contraseña incorrectas ") ;  }
            else {
                Session.currentUser = Usuario.fromJson(s);
                CustomLog.log(s);
                String Mail=edtEmail.getText().toString();
                String Contraseña=edtPassword.getText().toString();
                Configuracion configurar;
                configurar      = SharedPreferencesManager.getConfiguracion(getContext());
                configurar.setMail(Mail);
                configurar.setContraseña(Contraseña);
                SharedPreferencesManager.saveConfiguracion(getContext(), configurar);
                MainActivity actividadContenedora;
                actividadContenedora = (MainActivity) getActivity();
                actividadContenedora.cambioActivity();
            }


        }

    }
}

