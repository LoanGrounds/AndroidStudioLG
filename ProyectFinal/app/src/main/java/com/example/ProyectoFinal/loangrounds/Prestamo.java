package com.example.ProyectoFinal.loangrounds;

public class Prestamo {
    int image;
    String name;
    int precio1;
    int precio2;
    int plazo;

    public Prestamo(int image, String name, int precio1, int precio2, int plazo) {
        this.image = image;
        this.name = name;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.plazo = plazo;
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

    public int getPlazo() {
        return plazo;
    }
}
