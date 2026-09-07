package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Cansado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class AnilloIgneo extends Fisico {

    public AnilloIgneo() {
        nombre = "AnilloIgneo";
        potencia = 120;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("¡El pokemon ha calcinado al oponente con una explosión de fuego! Debe descansar el siguiente turno."));
        if (pokemonUsuario != null) {
            pokemonUsuario.agragarEstado(new Cansado());
        }
    }
}
