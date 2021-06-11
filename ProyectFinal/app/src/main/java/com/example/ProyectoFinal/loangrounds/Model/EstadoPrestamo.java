package com.example.ProyectoFinal.loangrounds.Model;

import java.sql.Date;

public class EstadoPrestamo {

    private int Id;
    private String Comentarios;
    private String Nombre;

    public EstadoPrestamo(int id, String comentarios, String nombre) {
        Id = id;
        Comentarios=comentarios;
        Nombre=nombre;

    }
    public int getId() {
        return Id;
    };
    public String getNombre() {
        return Nombre;
    }
    public String getComentarios() {
        return Comentarios;
    }





}
