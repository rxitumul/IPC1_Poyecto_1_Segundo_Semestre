package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class Envenenado extends Estados{
    private Pokemons afectado;
    private int resta;

    public Envenenado(Pokemons afectado) {
        this.afectado = afectado;
        int vidaTotal = afectado.getVidaInicial();
        resta = (int) (vidaTotal * 0.08);
    }

    public boolean accion() {
        int vidaActual = afectado.getVidaPokemon();
        vidaActual -= resta;
        afectado.setVidaPokemon(vidaActual);
        return true;
    }

}
