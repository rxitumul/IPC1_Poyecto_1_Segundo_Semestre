package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Estado;

public class DisparoDemora extends Estado {

    public DisparoDemora() {
        nombre = "DisparoDemora";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " usó Disparo Demora!"));
        int velocidad = pokemonAtacado.getVelocidadPokemon();
        int reduccion = (int) (velocidad * 0.25);
        if (reduccion < 1) {
            reduccion = 1;
        }
        int nuevaVelocidad = Math.max(1, velocidad - reduccion);
        pokemonAtacado.setVelocidadPokemon(nuevaVelocidad);
        System.out.println(confi.formatearMapa("¡La velocidad de " + pokemonAtacado.getNombre() + " se redujo en 25%! (" + velocidad + " -> " + nuevaVelocidad + ")"));
    }
}
