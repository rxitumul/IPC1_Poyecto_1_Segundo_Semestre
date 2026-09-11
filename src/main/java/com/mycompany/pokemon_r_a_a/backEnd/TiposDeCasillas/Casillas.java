/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.Batallas.BatallasPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

/**
 *
 * @author ricardocastillo
 */

@SuppressWarnings("rawtypes")
public abstract class Casillas<T> implements Serializable {

    protected T npcT;
    protected String simbolo;
    protected boolean caminable;
    protected int tipo;
    protected boolean tieneSubMenu;
    protected HallDeLaFama hall;
    protected Casillas[][] mapa;

    protected JugadorPokemonPartida jugador;
    protected transient Random random;
    protected transient Scanner scanner;
    protected transient BatallasPokemon batalla;

    public Casillas() {

    }

    public Casillas(HallDeLaFama hall) {
        scanner = new Scanner(System.in);
        batalla = new BatallasPokemon(scanner, hall);
        this.hall = hall;
        random = new Random();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.scanner = new Scanner(System.in);
        random = new Random();
        batalla = new BatallasPokemon(scanner, hall);

    }

    public abstract void imprimir();

    public boolean estadoCasilla(Boolean jugador) {
        return true;
    }

    public abstract boolean caminable();

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

    public void setHall(HallDeLaFama hall) {
        this.hall = hall;
    }

    public Casillas[][] getMapa() {
        return mapa;
    }

    public HallDeLaFama getHall() {
        return hall;
    }

}
