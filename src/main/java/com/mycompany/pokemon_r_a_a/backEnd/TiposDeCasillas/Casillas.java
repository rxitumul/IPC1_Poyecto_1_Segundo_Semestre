/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;

import java.util.Random;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.Batallas.BatallasPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

/**
 *
 * @author ricardocastillo
 */
public abstract class Casillas<T> {

    protected Random random = new Random();
    protected T dialogo;
    protected JugadorPokemonPartida jugador;
    protected Scanner scanner = new Scanner(System.in);
    protected BatallasPokemon batalla;
    protected final static String ROJO = "\u001B[31m";
    protected final static String VERDE = "\u001B[32m";
    protected final static String AMARILLO = "\u001B[33m";

    protected final static String VERDE_CLARO = "\u001B[38;5;118m";
    protected final static String AZUL = "\u001B[34m";
    protected final static String MAGENTA = "\u001B[35m";
    protected final static String RESET = "\u001B[0m";

    public Casillas() {

    }

    public Casillas(HallDeLaFama hall) {
        batalla = new BatallasPokemon(scanner, hall);
    }

    public abstract void imprimir();

    public abstract boolean estadoCasilla(Boolean jugador);

    public abstract int tipoCasilla();

    public abstract Boolean subMenu();

    public abstract void setMapa();

    public abstract boolean getEstadoDeGruppo();

    public void setNpc(T dialogo) {

    }

    public void setjugador(JugadorPokemonPartida jugador) {
        this.jugador = jugador;
    }

    public T accionCasilla(JugadorPokemonPartida jugador) {
        return null;
    }

}
