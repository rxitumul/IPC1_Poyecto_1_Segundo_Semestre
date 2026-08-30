package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Mordisco extends Fisico {
    public Mordisco() {
        nombre = "Mordisco";
        potencia =60;
    }

    @Override
    protected void estadosAlterados() {

        System.out.println(confi.formatearMapa(
                "El pokemon a dado un bocado con dientes afilados a el pokemon " + pokemonAtacado.getApodo()));
        confi.separadorFinalMapa();
    }
}
