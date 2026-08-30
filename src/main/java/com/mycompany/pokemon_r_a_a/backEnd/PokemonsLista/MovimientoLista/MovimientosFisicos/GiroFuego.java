package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class GiroFuego extends Fisico {
    public GiroFuego() {
        nombre = "GiroFuego";
        potencia = 15;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon un giroFuego "));
        confi.separadorFinalMapa();
    }
}
