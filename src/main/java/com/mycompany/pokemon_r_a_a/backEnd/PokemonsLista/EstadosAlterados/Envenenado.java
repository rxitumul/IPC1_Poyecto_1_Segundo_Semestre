package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class Envenenado extends Estados {
    private Pokemons afectado;
    private int resta;

    public Envenenado() {
    }

    public Envenenado(Pokemons afectado) {
        setAfectado(afectado);
    }

    public void setAfectado(Pokemons afectado) {
        this.afectado = afectado;
        if (afectado != null) {
            int vidaTotal = afectado.getVidaInicial();
            this.resta = (int) (vidaTotal * 0.08);
            if (this.resta < 1) {
                this.resta = 1;
            }
        }
    }

    public Pokemons getAfectado() {
        return afectado;
    }

    public int getResta() {
        return resta;
    }

    @Override
    public boolean accion() {
        if (afectado != null) {
            int vidaActual = afectado.getVidaPokemon();
            vidaActual -= resta;
            if (vidaActual < 0) {
                vidaActual = 0;
            }
            afectado.setVidaPokemon(vidaActual);
        }
        return true;
    }
}

