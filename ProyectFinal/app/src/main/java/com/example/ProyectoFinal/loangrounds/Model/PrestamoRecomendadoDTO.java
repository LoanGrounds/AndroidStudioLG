package com.example.ProyectoFinal.loangrounds.Model;

public class PrestamoRecomendadoDTO {
    public int Id,IdDetalle, Monto, URLFoto;
    public String UserName ;


    public PrestamoRecomendadoDTO(int id, int idDetalle, int monto, String userName, int urlFoto) {
        Id = id;
        IdDetalle  = idDetalle;
        Monto = monto;
        UserName = userName;
        URLFoto = urlFoto;
    }



}
