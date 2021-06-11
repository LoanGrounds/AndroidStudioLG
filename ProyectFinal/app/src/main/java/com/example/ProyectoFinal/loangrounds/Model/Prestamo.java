package com.example.ProyectoFinal.loangrounds.Model;

public class Prestamo {
    private int IdDetallePrestamo, IdUsuarioPrestamista, IdUsuarioPrestador;

    public Prestamo(int idDetallePrestamo, int idUsuarioPrestamista, int idUsuarioPrestador) {
        IdDetallePrestamo = idDetallePrestamo;
        IdUsuarioPrestamista = idUsuarioPrestamista;
        IdUsuarioPrestador = idUsuarioPrestador;
    }


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
