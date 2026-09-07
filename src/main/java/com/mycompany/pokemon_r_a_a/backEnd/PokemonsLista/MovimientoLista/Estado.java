package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista;

public abstract class Estado extends Movimiento {

    @Override
    protected int resultadoAcion(Boolean recursivo) {
        if (pokemonAtacado != null && pokemonAtacado != pokemonUsuario) {
            if (pokemonAtacado.isEnElAire()) {
                System.out.println(confi.formatearMapa("¡El movimiento falló porque " + pokemonAtacado.getNombre() + " está en el aire!"));
                return -1;
            }
            if (pokemonAtacado.bolqueador()) {
                System.out.println(confi.formatearMapa("¡" + pokemonAtacado.getNombre() + " se protegió del ataque!"));
                return -1;
            }
        }
        estadosAlterados();
        return -1;
    }

}

