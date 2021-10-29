package com.example.ProyectoFinal.loangrounds.entidades;

public class Configuracion {

    private String Mail;
    private String Contraseña;



    public String getMail() {
        return Mail;
    }
    public void setMail(String mail) {
        Mail = mail;
    }

    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }



    @Override
    public String toString() {
        return "Configuracion{" +
                "Mail='" + Mail  +
                "Contraseña='"+ Contraseña +
                '}';
    }


}
