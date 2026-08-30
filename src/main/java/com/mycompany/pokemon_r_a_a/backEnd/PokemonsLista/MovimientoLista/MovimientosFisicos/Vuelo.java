package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Vuelo extends Fisico {
    public Vuelo() {
        nombre = "Vuelo";
        potencia=90;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("Ataque aereo "));
        confi.separadorFinalMapa();
    }
}
