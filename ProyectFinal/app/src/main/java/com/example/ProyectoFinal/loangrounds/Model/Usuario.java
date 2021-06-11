package com.example.ProyectoFinal.loangrounds.Model;

import java.sql.Date;

public class Usuario {


    private String UserName, Password, Nombre, Apellido,Telefono, Mail, Direccion, Dni, CBU, CBUAlias, CUIT, Descipcion, Ocupacion, URLFoto, NombreGenero, NombreLocalidad  ;
    private int Id, Puntos, CantidadPrestamosExitosos, IdGenero, IdLocalidad ;
    private Date FechaNacimiento, FechaCreacion;



    public Usuario(String userName, String password, String nombre, String apellido, String telefono, String mail, String direccion, String dni, String cbu, String cbuAlias, String cuit, String descipcion, String ocupacion, String urlFoto, String nombreGenero, String nombreLocalidad, int id, int puntos, int cantidadPrestamosExitosos, int idGenero, int idLocalidad, Date fechaNacimiento, Date fechaCreacion) {
        UserName = userName;
        Password = password;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Mail = mail;
        Direccion = direccion;
        Dni = dni;
        CBU = cbu;
        CBUAlias = cbuAlias;
        CUIT = cuit;
        Descipcion = descipcion;
        Ocupacion = ocupacion;
        URLFoto = urlFoto;
        NombreGenero = nombreGenero;
        NombreLocalidad = nombreLocalidad;
        Id = id;
        Puntos = puntos;
        CantidadPrestamosExitosos = cantidadPrestamosExitosos;
        IdGenero = idGenero;
        IdLocalidad = idLocalidad;
        FechaNacimiento = fechaNacimiento;
        FechaCreacion = fechaCreacion;



    }


    public String getUserName() {
        return UserName;
    }
    public String getPassword() {
        return Password;
    }
    public String getNombre() {
        return Nombre;
    }
    public String getApellido() {
        return Apellido;
    }
    public String getTelefono() {
        return Telefono;
    }
    public String getMail() {
        return Mail;
    }
    public String getDireccion() {
        return Direccion;
    }
    public String getDni() {
        return Dni;
    }
    public String getCBU() {
        return CBU;
    }
    public String getCBUAlias() {
        return CBUAlias;
    }
    public String getCUIT() {
        return CUIT;
    }
    public String getDescipcion() {
        return Descipcion;
    }
    public String getOcupacion() {
        return Ocupacion;
    }
    public String getURLFoto() {
        return URLFoto;
    }
    public String getNombreGenero() {
        return NombreGenero;
    }
    public String getNombreLocalidad() {
        return NombreLocalidad;
    }



    public int getId() {
        return Id;
    }
    public int getPuntos() {
        return Puntos;
    }
    public int getCantidadPrestamosExitosos() {
        return CantidadPrestamosExitosos;
    }
    public int getIdGenero() {
        return IdGenero;
    }
    public int getIdLocalidad() {
        return IdLocalidad;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }
    public Date getFechaCreacion() {
        return FechaCreacion;
    }


}
