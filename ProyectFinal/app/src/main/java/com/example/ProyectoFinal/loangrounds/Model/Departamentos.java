package com.example.ProyectoFinal.loangrounds.Model;

public class Departamentos {

    private int Id, IdProvincia;
    private String Nombre;

    public Departamentos(int id, int idProvincia, String nombre) {
        Id = id;
        IdProvincia = idProvincia;
        Nombre = nombre;
    }


    public String getNombre() {
        return Nombre;
    }
    public int getId() {
        return Id;
    }
    public int getIdProvincia() {
        return IdProvincia;
    }
}
