package com.example.ProyectoFinal.loangrounds.Model;

import androidx.annotation.NonNull;

import com.example.ProyectoFinal.loangrounds.Utilidades.CustomLog;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Usuario {


    private String UserName, Password, Nombre, Apellido, Telefono, Mail, Direccion, Dni, CBU, CBUAlias, CUIT, Descripcion, Ocupacion, URLFoto, NombreGenero, NombreLocalidad, ApiKey;
    private int Id, Puntos, CantidadPrestamosExitosos, IdGenero, IdLocalidad;
    private Date FechaNacimiento, FechaCreacion;


    public Usuario(String userName, String password, String nombre, String apellido, String telefono, String mail, String direccion, String dni, String cbu, String cbuAlias, String cuit, String descripcion, String ocupacion, String urlFoto, String nombreGenero, String nombreLocalidad, String ApiKey, int id, int puntos, int cantidadPrestamosExitosos, int idGenero, int idLocalidad, Date fechaNacimiento, Date fechaCreacion) {
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
        Descripcion = descripcion;
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
        this.ApiKey = ApiKey;


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

    public String getDescripcion() {
        return Descripcion;
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

    public String getApiKey() {
        return ApiKey;
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

    @NonNull
    @Override
    public String toString() {
        return String.format("Username: %s \n Contra: %s \n Ocupacion: %s \n Desc: %s", this.getUserName(),
                this.getPassword(), this.getOcupacion(), this.getDescripcion());
    }


    public static Usuario fromJson(String s) {
        try {
            Gson miGson;
            GsonBuilder builder = new GsonBuilder();
            builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            miGson = builder.create();
            return miGson.fromJson(s, Usuario.class);
        } catch (Exception e) {
            CustomLog.logException(e);
            return null;
        }
    }


    public static Usuario[] fromJsonToArray(String s) {
        try {
            Gson miGson;
            GsonBuilder builder = new GsonBuilder();
            builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            miGson = builder.create();
            return miGson.fromJson(s, Usuario[].class);
        } catch (Exception e) {
            CustomLog.logException(e);
            return null;
        }
    }
}

