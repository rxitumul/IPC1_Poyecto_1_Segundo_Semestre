/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;

import java.util.Random;

/**
 *
 * @author ricardocastillo
 */
public abstract class Casillas {

    protected Random random= new Random();
    protected final static String ROJO = "\u001B[31m";
    protected final static String VERDE = "\u001B[32m";
    protected final static String AMARILLO = "\u001B[33m";
    protected final static String CAFE = "\u001B[33m";
    protected final static String AZUL = "\u001B[34m";
    protected final static String MAGENTA = "\u001B[35m";
    protected final static String RESET = "\u001B[0m";

    public abstract void imprimir();

    public abstract boolean estadoCasilla(Boolean jugador);

    public abstract int tipoCasilla();

    public abstract Boolean subMenu();

    public abstract void setMapa();

    public abstract boolean getEstadoDeGruppo();

    public <T> T accionCasilla() {
        return null;
    }

}
