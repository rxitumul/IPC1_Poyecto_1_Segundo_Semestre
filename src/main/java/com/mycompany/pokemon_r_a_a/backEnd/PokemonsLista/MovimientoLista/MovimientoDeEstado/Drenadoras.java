package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.DrenadoraDebuf;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Drenadoras extends Estado {

    public Drenadoras() {
        nombre = "Drenadoras";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " plantó Drenadoras en " + pokemonAtacado.getNombre() + "!"));
        if (!pokemonAtacado.tieneEstado(DrenadoraDebuf.class)) {
            pokemonAtacado.agragarEstadoPermanete(new DrenadoraDebuf(pokemonUsuario, pokemonAtacado));
        }
    }
}
