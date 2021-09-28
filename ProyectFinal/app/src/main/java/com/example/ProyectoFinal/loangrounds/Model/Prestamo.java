package com.example.ProyectoFinal.loangrounds.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Prestamo {
    private int Id,  IdDetallePrestamo, IdUsuarioPrestamista, IdUsuarioPrestador;

    public Prestamo(int id, int idDetallePrestamo, int idUsuarioPrestamista, int idUsuarioPrestador) {
        Id = id;
        IdDetallePrestamo = idDetallePrestamo;
        IdUsuarioPrestamista = idUsuarioPrestamista;
        IdUsuarioPrestador = idUsuarioPrestador;
    }

    public int getId(){return Id;}
    public int getIdDetallePrestamo() {
        return IdDetallePrestamo;
    }

    public int getIdUsuarioPrestamista() {
        return IdUsuarioPrestamista;
    }

    public int getIdUsuarioPrestador() {
        return IdUsuarioPrestador;
    }

    public static Prestamo fromJson(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, Prestamo.class);
    }

    public static Prestamo[] fromJsonToAray(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, Prestamo[].class);
    }
}
