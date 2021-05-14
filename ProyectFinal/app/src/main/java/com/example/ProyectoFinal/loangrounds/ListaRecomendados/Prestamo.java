package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

public class Prestamo {
    int image;
    String name;
    int precio1;



    public Prestamo(int image, String name, int precio1) {
        this.image = image;
        this.name = name;
        this.precio1 = precio1;


    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getPrecio1() {
        return precio1;
    }




}
