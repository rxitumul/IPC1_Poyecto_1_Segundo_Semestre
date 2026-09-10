package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Confuso;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Supersonico extends Estado {
    public Supersonico() {
        nombre = "Supersonico";
    }

    @Override
    protected void estadosAlterados() {
    confi.mensajeInformativo("El pokemon a utlizado supersonico");
       pokemonAtacado.agragarEstado(new Confuso());
    }
}
