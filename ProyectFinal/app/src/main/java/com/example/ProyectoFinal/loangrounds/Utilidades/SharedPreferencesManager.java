package com.example.ProyectoFinal.loangrounds.Utilidades;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ProyectoFinal.loangrounds.entidades.Configuracion;


public class SharedPreferencesManager {
    private static String CONFIG_FILE = "configuracion";

    private static String FIELD_KEY_MAIL        = "mail";
    private static String FIELD_KEY_CONTRASEÑA        = "contraseña";



    public static Configuracion getConfiguracion(Context context){
        Configuracion returnEntity = new Configuracion();

        SharedPreferences sharedPref = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE);
        returnEntity = new Configuracion();
        returnEntity.setMail(sharedPref.getString(FIELD_KEY_MAIL, ""));
        returnEntity.setContraseña(sharedPref.getString(FIELD_KEY_CONTRASEÑA, ""));

        return  returnEntity;
    }

    public static boolean saveConfiguracion(Context context, Configuracion config){
        SharedPreferences sharedPref = context.getSharedPreferences(CONFIG_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(FIELD_KEY_MAIL, config.getMail());
        editor.putString(FIELD_KEY_CONTRASEÑA, config.getContraseña());


        editor.commit();
        return true;
    }

    public static boolean clearConfiguracion(Context context){
        Configuracion config = new Configuracion();
        return saveConfiguracion(context, config);
    }

}
