package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class DrenadoraDebuf extends Estados {

    private Pokemons lanzador;
    private Pokemons resividor;

    public DrenadoraDebuf(Pokemons lanzador, Pokemons resividor) {
        this.lanzador = lanzador;
        this.resividor = resividor;
    }

    public void verificador() {
        int vida = lanzador.getVidaPokemon();
        int vidaResividor = resividor.getVidaPokemon();

        if (vida < 0 && vidaResividor < 0) {
            int vidaResividorTotal = resividor.getVidaInicial();
            int sumador = (int) (vidaResividorTotal * 0.07);
            lanzador.setVidaPokemon(vida += sumador);
        }
    }

}
