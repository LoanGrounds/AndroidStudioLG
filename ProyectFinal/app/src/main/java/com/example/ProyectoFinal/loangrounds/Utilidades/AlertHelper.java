package com.example.ProyectoFinal.loangrounds.Utilidades;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertHelper {


    public static void mostrarAlertaError(Context c, String error, DialogInterface.OnClickListener click){
        AlertDialog.Builder builder = new AlertDialog.Builder(c,AlertDialog.THEME_DEVICE_DEFAULT_DARK);
        String titulo = "Ups, parece que hubo un error"; // generic text
        builder.setTitle(titulo);
        builder.setMessage(error);
        builder.setPositiveButton("Continuar",click); // you can add listener if you want
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    public static void mostrarAlertaError(Context c, String error){
        mostrarAlertaError(c,error,null);
    }

    public static void mostrarMensaje(Context c, String mensaje, DialogInterface.OnClickListener click){
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setMessage(mensaje);
        builder.setPositiveButton("Continuar",click); // you can add listener if you want
        builder.setNegativeButton("Cancelar",null);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    public static void mostrarMensaje(Context c, String mensaje){
        mostrarMensaje(c,mensaje,null);
    }





}
