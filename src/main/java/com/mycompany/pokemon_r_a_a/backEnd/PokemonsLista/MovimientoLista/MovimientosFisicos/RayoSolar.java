package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class RayoSolar extends Fisico {
    public RayoSolar() {
        nombre = "RayoSolar";
        potencia = 120;
    }

    @Override
    protected int resultadoAcion(Boolean recursivo) {
        if (pokemonUsuario == null || pokemonAtacado == null) {
            return 0;
        }
        if (!pokemonUsuario.isCargandoRayoSolar()) {
            pokemonUsuario.setCargandoRayoSolar(true);
            System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " está absorbiendo luz solar!"));
            return 0;
        } else {
            pokemonUsuario.setCargandoRayoSolar(false);
            System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " liberó toda la energía solar acumulada!"));
            return super.resultadoAcion(recursivo);
        }
    }

    @Override
    protected void estadosAlterados() {
    }
}
