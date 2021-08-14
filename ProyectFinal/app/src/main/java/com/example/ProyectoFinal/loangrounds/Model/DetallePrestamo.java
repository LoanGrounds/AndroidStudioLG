package com.example.ProyectoFinal.loangrounds.Model;

import java.sql.Date;

public class DetallePrestamo {
    private int Id, CantidadCuotas, DiasEntreCuotas, DiasTolerancia, IdEstadoPrestamo;
    private double Monto, InteresXCuota;
    private Date FechaDeAcuerdo;

    public DetallePrestamo(int id, int cantidadCuotas, int diasEntreCuotas, int diasTolerancia, int idEstadoPrestamo, double monto, double interesXCuota, Date fechaDeAcuerdo) {
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

    public Date getFechaDeAcuerdo() {
        return FechaDeAcuerdo;
    }




}
