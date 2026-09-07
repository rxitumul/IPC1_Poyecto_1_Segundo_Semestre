package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Latigo extends Estado {
    public Latigo() {
        nombre = "Latigo";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a utlizado Latigo"));
        int defensa = pokemonAtacado.getDefensaPokemon();
        int reducion = (int) (defensa * 0.2);
        pokemonAtacado.setDefensaPokemon(defensa -= reducion);
    }
}
