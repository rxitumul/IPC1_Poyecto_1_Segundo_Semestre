package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class Entrenador extends Npc<Pokemons>{

    private Pokemons[] pokemosEquipo;


    public Pokemons[] getLista() {
        return pokemosEquipo;
    }

    public void setLista(Pokemons[] pokemosEquipo) {
        this.pokemosEquipo = pokemosEquipo;
    }

    public void setBoleanoActivo(boolean esLider) {
        this.boleanoActivo = esLider;
    }

    public boolean getbBleanoActivo() {
        return boleanoActivo;
    }
}
