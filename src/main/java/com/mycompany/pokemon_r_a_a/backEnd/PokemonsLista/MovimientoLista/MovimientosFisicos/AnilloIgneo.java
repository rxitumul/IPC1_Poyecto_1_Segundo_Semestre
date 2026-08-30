package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class AnilloIgneo extends Fisico {

    public AnilloIgneo() {
        nombre = "AnilloIgneo";
        potencia = 120;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a calsinado al oponete con una esplocion de fuego el pokemon tiene que descansar "));
        confi.separadorFinalMapa();
    }
}
