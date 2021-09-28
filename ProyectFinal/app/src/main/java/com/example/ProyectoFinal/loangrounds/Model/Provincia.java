package com.example.ProyectoFinal.loangrounds.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Provincia {
    private int Id;
    private String Nombre;

    public Provincia(int id, String nombre) {
        Id = id;
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }


    public int getId() {
        return Id;
    }

    public static Provincia[] fromJsonToArray(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, Provincia[].class);
    }
}
