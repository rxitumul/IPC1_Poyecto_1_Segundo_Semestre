package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class MapaCiudad {
    private String nombre;
    private Casillas[][] mapa;
    private int[] jugador;

    public MapaCiudad(String nombre, Casillas[][] mapa, int[] jugador) {
        this.mapa = mapa;
        this.nombre = nombre;
        this.jugador = jugador;
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
}
