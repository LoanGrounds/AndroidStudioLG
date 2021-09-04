package com.example.ProyectoFinal.loangrounds;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.ProyectoFinal.loangrounds.Registro.InicioSesionFragment;
import com.example.ProyectoFinal.loangrounds.Registro.Inicio_RegistrarseFragment;
import com.example.ProyectoFinal.loangrounds.Registro.RegistroFragment;
import com.example.ProyectoFinal.loangrounds.Utilidades.ApiHelper;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;

public class MainActivity extends AppCompatActivity {

    InicioSesionFragment fragmentInicioSesion;
    RegistroFragment fragmentRegistro;
    Inicio_RegistrarseFragment fragmentSesionRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearFragments();
        reemplazarFragmenbts(fragmentSesionRegistro,false);

    }




    public void reemplazarFragmenbts(Fragment fragmento){
        reemplazarFragmenbts(fragmento,true);
    }

    public void reemplazarFragmenbts(Fragment fragmento, Boolean blnAddToBackStack){
        FragmentManager manager= getSupportFragmentManager();
        FragmentTransaction transision = manager.beginTransaction();

        transision.replace(R.id.frameLayout1, fragmento, null );
        if(blnAddToBackStack){

            transision.addToBackStack(null);
        }
        transision.commit();

    }
    private void crearFragments() {
        fragmentInicioSesion = new InicioSesionFragment();
        fragmentRegistro = new RegistroFragment();
        fragmentSesionRegistro = new Inicio_RegistrarseFragment();


    }


    public  void setFragmentInicioSesion(){

        reemplazarFragmenbts(fragmentInicioSesion);
    }

    public  void setFragmentRegistro(){
        reemplazarFragmenbts(fragmentRegistro);
    }

    public  void setFragmentSesionRegistro(){
        reemplazarFragmenbts(fragmentSesionRegistro);

    }
    public void cambioActivity(){
        Intent intent=new Intent(MainActivity.this, MainActivityInicio.class);
        //  FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction(); ft.remove(fragmentRegistro).commit();

        startActivity(intent);
        this.finish();
    }






}