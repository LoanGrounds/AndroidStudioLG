package com.example.ProyectoFinal.loangrounds.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Localidad {
    private int Id, IdDepartamento;
    private String Nombre;


    public Localidad(int id, int idDepartamento, String nombre) {
        Id = id;
        IdDepartamento = idDepartamento;
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public int getId() {
        return Id;
    }

    public static Localidad[] fromJsonToArray(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, Localidad[].class);
    }
}
