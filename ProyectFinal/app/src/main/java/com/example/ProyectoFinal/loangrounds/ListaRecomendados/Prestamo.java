package com.example.ProyectoFinal.loangrounds.ListaRecomendados;

public class Prestamo {
    int image;
    String name;
    int precio1;
    int precio2;
    int meses;

    public Prestamo(int image, String name, int precio1, int precio2, int meses) {
        this.image = image;
        this.name = name;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.meses = meses;
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

    public int getPrecio2() {
        return precio2;
    }

    public int getMeses() {
        return meses;
    }
}
