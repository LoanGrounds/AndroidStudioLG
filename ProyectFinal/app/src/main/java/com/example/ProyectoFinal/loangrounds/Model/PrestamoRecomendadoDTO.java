package com.example.ProyectoFinal.loangrounds.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PrestamoRecomendadoDTO {
    public int Id,IdDetalle, Monto, URLFoto;
    public String UserName ;


    public PrestamoRecomendadoDTO(int id, int idDetalle, int monto, String userName, int urlFoto) {
        Id = id;
        IdDetalle  = idDetalle;
        Monto = monto;
        UserName = userName;
        URLFoto = urlFoto;
    }


    public static PrestamoRecomendadoDTO[] fromJsonToAray(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, PrestamoRecomendadoDTO[].class);
    }


}
