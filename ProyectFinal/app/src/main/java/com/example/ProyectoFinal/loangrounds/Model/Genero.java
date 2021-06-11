package com.example.ProyectoFinal.loangrounds.Model;

public class Genero {
    private int Id, Orden;
    private String Nombre;

    public Genero(int id, int orden, String nombre) {
        Id = id;
        Orden = orden;
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getOrden() {
        return Orden;
    }

    public int getId() {
        return Id;
    }
}
