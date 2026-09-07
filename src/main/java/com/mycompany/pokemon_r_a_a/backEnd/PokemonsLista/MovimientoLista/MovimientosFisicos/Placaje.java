package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Placaje extends Fisico {
    public Placaje() {
        potencia = 35;
        nombre = "Placaje";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a Embestido al oponenten con todo el cuerpo"));

    }
}
