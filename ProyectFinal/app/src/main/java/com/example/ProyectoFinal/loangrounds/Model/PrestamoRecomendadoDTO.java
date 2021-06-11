package com.example.ProyectoFinal.loangrounds.Model;

public class PrestamoRecomendadoDTO {
    public int Id, Monto, URLFoto;
    public String UserName ;


    public PrestamoRecomendadoDTO(int id, int monto, String userName, int urlFoto) {
        Id = id;
        Monto = monto;
        UserName = userName;
        URLFoto = urlFoto;
    }



}
