package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Picotazo extends Fisico {
    public Picotazo() {
        nombre = "Picotazo";
        potencia = 40;
    }

    @Override
    protected void estadosAlterados() {
        String nombreObjetivo = (pokemonAtacado != null && pokemonAtacado.getApodo() != null) ? pokemonAtacado.getApodo() : (pokemonAtacado != null ? pokemonAtacado.getNombre() : "oponente");
        System.out.println(confi.formatearMapa("El pokemon ha ensartado al pokemon " + nombreObjetivo + " con su pico punzante"));
    }
}
