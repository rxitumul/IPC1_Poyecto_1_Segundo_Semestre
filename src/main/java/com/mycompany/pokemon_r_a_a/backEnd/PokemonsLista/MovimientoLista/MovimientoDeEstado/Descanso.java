package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Dormido;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class Descanso extends Estado {

    public Descanso() {
        nombre = "Descanso";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " usó Descanso, recuperó toda su salud y se quedó dormido!"));
        int vida = pokemonUsuario.getVidaInicial();
        pokemonUsuario.setVidaPokemon(vida);
        pokemonUsuario.lipiarEstadosTodos();
        pokemonUsuario.agragarEstado(new Dormido());
    }

}
