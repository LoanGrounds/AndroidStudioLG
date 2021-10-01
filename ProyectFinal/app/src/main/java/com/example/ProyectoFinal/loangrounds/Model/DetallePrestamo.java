package com.example.ProyectoFinal.loangrounds.Model;
import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

public class DetallePrestamo {
    private int Id, CantidadCuotas, DiasEntreCuotas, DiasTolerancia, IdEstadoPrestamo;
    private double Monto, InteresXCuota;
    private LocalDateTime FechaDeAcuerdo;

    public DetallePrestamo(int id, int cantidadCuotas, int diasEntreCuotas, int diasTolerancia, int idEstadoPrestamo, double monto, double interesXCuota, LocalDateTime fechaDeAcuerdo) {
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

    public LocalDateTime getFechaDeAcuerdo() {
        return FechaDeAcuerdo;
    }


    public static DetallePrestamo fromjson(String s){

        try{
            Gson miGson;
            GsonBuilder builder = new GsonBuilder();
            builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            miGson = builder.create();
            return miGson.fromJson(s, DetallePrestamo.class);
        }
        catch (Exception e) {
            CustomLog.logException(e);
            return null;}
    }

    public static DetallePrestamo[] fromjsonToArray(String s){
        try{
            Gson miGson;
            GsonBuilder builder = new GsonBuilder();
            builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            miGson = builder.create();
            return miGson.fromJson(s, DetallePrestamo[].class);
        }
        catch (Exception e) {
            CustomLog.logException(e);
            return null;}
    }





}
