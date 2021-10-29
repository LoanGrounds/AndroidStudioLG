package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.ProyectoFinal.loangrounds.AsyncTask.AsyncPostBase;
import com.example.ProyectoFinal.loangrounds.Model.Usuario;
import com.example.ProyectoFinal.loangrounds.Registro.InicioSesionFragment;
import com.example.ProyectoFinal.loangrounds.Utilidades.AlertHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.example.ProyectoFinal.loangrounds.Utilidades.Session;
import com.example.ProyectoFinal.loangrounds.Utilidades.SharedPreferencesManager;
import com.example.ProyectoFinal.loangrounds.entidades.Configuracion;

public class MainActivityStart extends AppCompatActivity {


    boolean resultado;
    String mail;
    String contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_start);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    resultado = LeerConfiguracion();

                    if ( resultado == false){
                        final Intent mainIntent = new Intent(MainActivityStart.this, MainActivity.class);
                        MainActivityStart.this.startActivity(mainIntent);
                        MainActivityStart.this.finish();
                    }
                    else {
                        Login login = new Login(mail,contraseña);
                        login.execute();
                    }


                }
            }, 1850);
    }



    private boolean LeerConfiguracion(){
        Configuracion config;
        boolean resultado = true;
        config = SharedPreferencesManager.getConfiguracion(this);
         mail = config.getMail().toString();
        contraseña = config.getContraseña().toString();

       if (mail == "" || contraseña == ""){
           resultado = false ;
       }
       return resultado;
    }



    public class Login extends AsyncPostBase {

        private final String mail;
        private final String password;
        public Login(String mail, String password){
            super(RequestMethods.POST, ApiHelper.devolverUrlParaGet("Usuarios","login"));
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


                Session.currentUser = Usuario.fromJson(s);
                CustomLog.log(s);
                cambioActivity();



        }

    }

    public void cambioActivity(){
        Intent intent=new Intent(MainActivityStart.this, MainActivityInicio.class);
        //  FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction(); ft.remove(fragmentRegistro).commit();

        startActivity(intent);
        this.finish();
    }
}