package com.example.ProyectoFinal.loangrounds.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BusquedaFiltradaDTO {
    private int Id, CantidadCuotas, DiasEntreCuotas, DiasTolerancia;
    private String UserName;
    private Float Monto, InteresXCuota;

    public BusquedaFiltradaDTO(int id, int cantidadCuotas, int diasEntreCuotas, int diasTolerancia, String userName, Float monto, Float interesXCuota) {
        Id = id;
        CantidadCuotas = cantidadCuotas;
        DiasEntreCuotas = diasEntreCuotas;
        DiasTolerancia = diasTolerancia;
        UserName = userName;
        Monto = monto;
        InteresXCuota = interesXCuota;
    }

    public String getUserName() {
        return UserName;
    }

    public int getDiasEntreCuotas() {
        return DiasEntreCuotas;
    }

    public int getCantidadCuotas() {
        return CantidadCuotas;
    }

    public int getDiasTolerancia() {
        return DiasTolerancia;
    }

    public int getId() {
        return Id;
    }

    public Float getInteresXCuota() {
        return InteresXCuota;
    }

    public Float getMonto() {
        return Monto;
    }

    public static BusquedaFiltradaDTO[] fromJsonToAray(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, BusquedaFiltradaDTO[].class);
    }
}
