package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados;

public abstract class Estados {
    protected int contador;

    public boolean accion() {
        return contador == 0;
    }
}
