package com.example.ProyectoFinal.loangrounds.Model;

public class Localidad {
    private int Id, IdDepartamento;
    private String Nombre;


    public Localidad(int id, int idDepartamento, String nombre) {
        Id = id;
        IdDepartamento = idDepartamento;
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getIdDepartamento() {
        return IdDepartamento;
    }

    public int getId() {
        return Id;
    }
}
