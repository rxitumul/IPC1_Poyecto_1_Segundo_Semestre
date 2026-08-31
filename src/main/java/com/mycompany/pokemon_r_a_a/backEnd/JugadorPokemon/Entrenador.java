package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class Entrenador {
    private String nombre;
    private boolean esLider;
    private int ciudad;
    private Pokemons[] pokemosEquipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pokemons[] getPokemosEquipo() {
        return pokemosEquipo;
    }

    public void setPokemosEquipo(Pokemons[] pokemosEquipo) {
        this.pokemosEquipo = pokemosEquipo;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public void setEsLider(boolean esLider) {
        this.esLider = esLider;
    }

    public int getCiudad() {
        return ciudad;
    }

    public boolean getEsLider() {
        return esLider;
    }
}
