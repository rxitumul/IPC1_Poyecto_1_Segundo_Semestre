package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.DrenadoraDebuf;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Drenadoras extends Estado {

    public Drenadoras() {
        nombre = "Drenadoras";
    }

    @Override
    protected void estadosAlterados() {
        confi.mensajeInformativo(
                "¡" + pokemonUsuario.getNombre() + " plantó Drenadoras en " + pokemonAtacado.getNombre() + "!");
        if (!pokemonAtacado.tieneEstado("DrenadoraDebuf")) {
            pokemonAtacado.agragarEstadoPermanete(new DrenadoraDebuf(pokemonUsuario, pokemonAtacado));
        }
    }
}
