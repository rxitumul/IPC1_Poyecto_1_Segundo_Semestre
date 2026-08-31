package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista;

public abstract class Estado extends Movimiento {

    @Override
    protected int resultadoAcion(Boolean recursivo) {
        estadosAlterados();
        return -1;
    }

}
