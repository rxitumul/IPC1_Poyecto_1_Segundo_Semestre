package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Mordisco extends Fisico {
    public Mordisco() {
        nombre = "Mordisco";
        potencia = 60;
    }

    @Override
    protected void estadosAlterados() {
        String nombreObjetivo = (pokemonAtacado != null && pokemonAtacado.getApodo() != null) ? pokemonAtacado.getApodo() : (pokemonAtacado != null ? pokemonAtacado.getNombre() : "oponente");
        System.out.println(confi.formatearMapa("El pokemon ha dado un bocado con dientes afilados al pokemon " + nombreObjetivo));
    }
}
