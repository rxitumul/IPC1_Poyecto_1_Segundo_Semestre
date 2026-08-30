package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class DisparoDemora extends Estado {

    public DisparoDemora() {
        nombre = "DisparoDemora";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a utlizado Demorrado"));
        int velocidad = pokemonAtacado.getVelocidadPokemon();
        int reducion = (int) (velocidad * 0.2);
        pokemonAtacado.setVelocidadPokemon(velocidad -= reducion);
        confi.separadorFinalMapa();
    }
}
