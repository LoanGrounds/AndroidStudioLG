package com.example.ProyectoFinal.loangrounds.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VistaPreviaPrestamo {
    private int IdDetallePrestamo;
    private double Monto;
    private String prestamista, estado;

    public int getIdDetallePrestamo() { return IdDetallePrestamo; }

    public double getMonto() { return Monto; }

    public String getEstado() { return estado; }

    public String getPrestamista() { return prestamista; }

    public static VistaPreviaPrestamo[] fromJsonToArray(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, VistaPreviaPrestamo[].class);
    }
}
