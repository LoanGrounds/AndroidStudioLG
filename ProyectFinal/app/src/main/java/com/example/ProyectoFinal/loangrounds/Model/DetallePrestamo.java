package com.example.ProyectoFinal.loangrounds.Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class DetallePrestamo {
    private int Id, CantidadCuotas, DiasEntreCuotas, DiasTolerancia, IdEstadoPrestamo;
    private double Monto, InteresXCuota;
    private LocalDate FechaDeAcuerdo;

    public DetallePrestamo(int id, int cantidadCuotas, int diasEntreCuotas, int diasTolerancia, int idEstadoPrestamo, double monto, double interesXCuota, LocalDate fechaDeAcuerdo) {
        Id = id;
        CantidadCuotas = cantidadCuotas;
        DiasEntreCuotas = diasEntreCuotas;
        DiasTolerancia = diasTolerancia;
        IdEstadoPrestamo = idEstadoPrestamo;
        Monto = monto;
        InteresXCuota = interesXCuota;
        FechaDeAcuerdo = fechaDeAcuerdo;
    }

    public int getId() {
        return Id;
    };
    public int getCantidadCuotas() {
        return CantidadCuotas;
    };
    public int getDiasEntreCuotas() {
        return DiasEntreCuotas;
    };
    public int getDiasTolerancia() {
        return DiasTolerancia;
    };
    public int getIdEstadoPrestamo() {
        return IdEstadoPrestamo;
    };

    public double getMonto() {
        return Monto;
    };
    public double getInteresXCuota() {
        return InteresXCuota;
    };

    public LocalDate getFechaDeAcuerdo() {
        return FechaDeAcuerdo;
    }


    public static DetallePrestamo fromjson(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, DetallePrestamo.class);
    }

    public static DetallePrestamo[] fromjsonToArray(String json){
        Gson miGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
        return miGson.fromJson(json, DetallePrestamo[].class);
    }



}
