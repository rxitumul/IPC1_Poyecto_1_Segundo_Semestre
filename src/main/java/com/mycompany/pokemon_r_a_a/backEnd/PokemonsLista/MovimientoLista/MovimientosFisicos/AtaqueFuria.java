package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class AtaqueFuria extends Fisico {
    public AtaqueFuria() {
        nombre = "AtaqueFuria";
        potencia = 15;
    }

    @Override
    protected void estadosAlterados() {
        int repeticiones = rand.ints(2, 5).findFirst().getAsInt();

        System.out.println(confi.formatearMapa("El pokemon pocoteado a el pokemon" + pokemonAtacado.getApodo()
                + " un total de " + repeticiones + " veces"));
        int vidaPokemon = pokemonAtacado.getVidaPokemon();
        for (int i = 0; i < repeticiones - 1; i++) {
            int daño = resultadoAcion();
            vidaPokemon -= daño;
        }
        pokemonAtacado.setVidaPokemon(vidaPokemon);
        confi.separadorFinalMapa();
    }
}
