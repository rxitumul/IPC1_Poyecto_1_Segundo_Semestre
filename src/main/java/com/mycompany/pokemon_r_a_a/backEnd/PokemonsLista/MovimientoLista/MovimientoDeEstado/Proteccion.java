package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Proteccion extends Estado {
    public Proteccion() {
        nombre = "Proteccion";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a utlizado Protecion "));
        pokemonUsuario.setActivoBloqueo(true);

        confi.separadorFinalMapa();
    }
}
