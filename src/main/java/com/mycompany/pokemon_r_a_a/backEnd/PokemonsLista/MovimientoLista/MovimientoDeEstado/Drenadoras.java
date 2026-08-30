package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.DrenadoraDebuf;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Drenadoras extends Estado{

    public Drenadoras(){
        nombre="Drenadoras";
    }

    @Override
    protected void estadosAlterados() {
      System.out.println(confi.formatearMapa("El pokemon a utlizado Drenadora"));
        int defensa = pokemonAtacado.getDefensaPokemon();
        int reducion = (int) (defensa * 0.2);
        pokemonAtacado.setDefensaPokemon(defensa -= reducion);
        pokemonAtacado.agragarEstadoPermanete(new DrenadoraDebuf(pokemonUsuario,pokemonAtacado));
        confi.separadorFinalMapa();
    }
}
