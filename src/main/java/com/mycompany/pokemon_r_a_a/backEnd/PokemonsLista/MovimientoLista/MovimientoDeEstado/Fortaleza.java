package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Fortaleza extends Estado {

    public Fortaleza() {
        nombre = "Fortaleza";
    }

    @Override
    protected void estadosAlterados() {
      System.out.println(confi.formatearMapa("El pokemon a utlizado Fortaleza"));
        int defensa = pokemonUsuario.getDefensaPokemon();
        int aumento = (int) (defensa * 0.5);
        pokemonUsuario.setDefensaPokemon(defensa += aumento);
        confi.separadorFinalMapa();
    }
}
