package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class AtaqueFuria extends Fisico {
    public AtaqueFuria() {
        nombre = "AtaqueFuria";
        potencia = 15;
    }

    @Override
    protected void estadosAlterados() {
        int repeticiones = rand.ints(2, 6).findFirst().getAsInt();

        System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " atacó en ráfaga un total de "
                + repeticiones + " veces!"));
        for (int i = 0; i < repeticiones - 1; i++) {
            if (pokemonAtacado.getVidaPokemon() <= 0) {
                break;
            }
            resultadoAcion(true);
        }

    }
}
