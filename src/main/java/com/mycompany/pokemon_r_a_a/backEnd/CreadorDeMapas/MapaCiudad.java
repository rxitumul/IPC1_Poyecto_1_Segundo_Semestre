package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import java.io.Serializable;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class MapaCiudad implements Serializable {
    private String nombre;
    private int[] jugador;
    private int[] enfermeria;

    private Casillas[][] mapa;

    public MapaCiudad(String nombre, Casillas[][] mapa, int[] jugador, int[] enfermeria) {
        this.mapa = mapa;
        this.nombre = nombre;
        this.jugador = jugador;
        this.enfermeria = enfermeria;
    }

    public Casillas[][] getMapa() {
        return mapa;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getJugador() {
        return jugador;
    }

    public void setJugador(int[] jugador) {
        this.jugador = jugador;
    }

    public int[] getEnfermeria() {
        return enfermeria;
    }

}
