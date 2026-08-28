package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

public class JugadorPokemonPartida {
    private String nombre;
    private int pokemonedas;
    private int[] medallasObtenidas = { 0, 0, 0 };

    public JugadorPokemonPartida() {
        pokemonedas = 1000;
    }

    public int[] getMedallasObtenidas() {
        return medallasObtenidas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPokemonedas() {
        return pokemonedas;
    }

    public void setMedallasObtenidas(int[] medallasObtenidas) {
        this.medallasObtenidas = medallasObtenidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPokemonedas(int pokemonedas) {
        this.pokemonedas = pokemonedas;
    }

}
