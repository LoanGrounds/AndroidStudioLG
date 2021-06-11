package com.example.ProyectoFinal.loangrounds.Model;

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
}
