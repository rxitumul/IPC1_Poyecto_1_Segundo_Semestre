package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class AtaqueAla extends Fisico {
    public AtaqueAla() {
        nombre = "AtaqueAla";
        potencia=100;
    }

    @Override
    protected void estadosAlterados() {
         System.out.println(confi.formatearMapa("El pokemon a extendido sus alas para golpear al oponete"));

    }
}
