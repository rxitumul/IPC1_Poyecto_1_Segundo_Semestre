package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class AtaqueRápido extends Fisico {
    public AtaqueRápido() {
        potencia = 40;
        nombre = "AtaqueRápido";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("Ataque a alta velocidad "));
        pokemonUsuario.setPrioritario(true);
        confi.separadorFinalMapa();
    }
}
