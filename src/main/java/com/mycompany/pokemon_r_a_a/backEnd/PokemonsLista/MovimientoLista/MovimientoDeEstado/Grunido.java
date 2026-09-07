package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Grunido extends Estado {
    public Grunido() {
        nombre = "Grunido";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a utlizado Gruñido"));
        int ataque = pokemonAtacado.getAtaquePokemon();
        int reducion = (int) (ataque * 0.2);
        pokemonAtacado.setAtaquePokemon(ataque -= reducion);

    }
}
