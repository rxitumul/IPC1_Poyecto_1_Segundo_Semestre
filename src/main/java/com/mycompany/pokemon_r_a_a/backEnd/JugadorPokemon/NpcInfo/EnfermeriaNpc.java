package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class EnfermeriaNpc extends Npc<Pokemons> {

    private Pokemons[] pokemosEquipo;

    public void accion() {
        if (boleanoActivo){
            for (Pokemons pokemons : pokemosEquipo) {
                pokemons.restauradorArtibutos();
                pokemons.lipiarEstadosTodos();
            }
        }
    }

    @Override
    public void setBoleanoActivo(boolean boleanoActivo) {
        this.boleanoActivo = boleanoActivo;
    }

    @Override
    public boolean getbBleanoActivo() {
        return boleanoActivo;
    }

    @Override
    public Pokemons[] getLista() {
        return pokemosEquipo;
    }

    @Override
    public void setLista(Pokemons[] pokemosEquipo) {
        this.pokemosEquipo = pokemosEquipo;
    }

}
