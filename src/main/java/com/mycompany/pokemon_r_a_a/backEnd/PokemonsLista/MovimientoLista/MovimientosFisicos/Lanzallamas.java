package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Lanzallamas extends Fisico {
    public Lanzallamas() {
        nombre = "Lanzallamas";
        potencia = 90;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a lanzado una rafaga de fuego"));
        confi.separadorFinalMapa();
    }
}
