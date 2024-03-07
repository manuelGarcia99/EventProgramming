package com.example.proj;

import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Hashtable;

public class Barco {
    public Integer numDeCasasDestruidas;
    public Integer numDeCasasVivas;
    public Integer numTotalDeCasas;
    public Hashtable<Point, Boolean> listaDeDanos;
    public  Character ID ;

    Barco(Integer numTotalDeCasas, Character ID){
        this.numTotalDeCasas = numTotalDeCasas;
        numDeCasasVivas = numTotalDeCasas;
        numDeCasasDestruidas = 0;
        this.ID = ID;
        listaDeDanos = new Hashtable<>();

    }
}
