package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Vuelo extends Fisico {
    public Vuelo() {
        nombre = "Vuelo";
        potencia = 90;
    }

    @Override
    protected int resultadoAcion(Boolean recursivo) {
        if (pokemonUsuario == null || pokemonAtacado == null) {
            return 0;
        }
        if (!pokemonUsuario.isEnElAire()) {
            pokemonUsuario.setEnElAire(true);
            System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " voló muy alto y se quedó en el aire!"));
            return 0;
        } else {
            pokemonUsuario.setEnElAire(false);
            System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " bajó del aire para atacar!"));
            return super.resultadoAcion(recursivo);
        }
    }

    @Override
    protected void estadosAlterados() {
    }
}
