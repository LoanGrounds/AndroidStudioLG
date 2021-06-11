package com.example.ProyectoFinal.loangrounds.Model;

public class Provincia {
    private int Id;
    private String Nombre;

    public Provincia(int id, String nombre) {
        Id = id;
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }


    public int getId() {
        return Id;
    }
}
