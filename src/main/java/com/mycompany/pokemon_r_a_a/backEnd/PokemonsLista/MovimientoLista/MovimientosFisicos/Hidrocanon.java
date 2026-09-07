package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Cansado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Hidrocanon extends Fisico {

    public Hidrocanon() {
        nombre = "Hidrocanon";
        potencia = 120;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("¡El pokemon ha utilizado un cañonazo de agua! Debe descansar el siguiente turno."));
        if (pokemonUsuario != null) {
            pokemonUsuario.agragarEstado(new Cansado());
        }
    }
}
