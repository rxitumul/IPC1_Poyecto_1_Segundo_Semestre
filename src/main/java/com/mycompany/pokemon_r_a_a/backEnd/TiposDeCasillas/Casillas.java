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

    protected String simbolo;
    protected boolean caminable;
    protected int tipo;
    protected boolean tieneSubMenu;

    public Casillas() {

    }

    public Casillas(HallDeLaFama hall) {
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

}
