package com.example.ProyectoFinal.loangrounds.Model;

public class Faqs {
    private int Id;
    private String Pregunta, Respuesta;

    public Faqs(int id, String pregunta, String respuesta) {
        Id = id;
        Pregunta = pregunta;
        Respuesta = respuesta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public int getId() {
        return Id;
    }
}
