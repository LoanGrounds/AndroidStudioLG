package com.example.ProyectoFinal.loangrounds.Model;

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
}
