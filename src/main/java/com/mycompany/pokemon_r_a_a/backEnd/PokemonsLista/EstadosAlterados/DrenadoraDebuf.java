package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class DrenadoraDebuf extends Estados {

    private Pokemons lanzador;
    private Pokemons resividor;

    public DrenadoraDebuf(Pokemons lanzador, Pokemons resividor) {
        this.lanzador = lanzador;
        this.resividor = resividor;
        this.nombre = "DrenadoraDebuf";
        this.nombreCorto = "DREN";
    }

    public Pokemons getLanzador() {
        return lanzador;
    }

    public Pokemons getResividor() {
        return resividor;
    }

    public int ejecutarDrenado() {
        if (lanzador == null || resividor == null) {
            return 0;
        }
        if (lanzador.getVidaPokemon() <= 0 || resividor.getVidaPokemon() <= 0) {
            return 0;
        }
        int vidaResividorTotal = resividor.getVidaInicial();
        int cantidad = (int) (vidaResividorTotal * 0.07);
        if (cantidad < 1) {
            cantidad = 1;
        }
        int vidaResividor = Math.max(0, resividor.getVidaPokemon() - cantidad);
        resividor.setVidaPokemon(vidaResividor);

        int vidaLanzador = Math.min(lanzador.getVidaInicial(), lanzador.getVidaPokemon() + cantidad);
        lanzador.setVidaPokemon(vidaLanzador);
        return cantidad;
    }

    public void verificador() {
        ejecutarDrenado();
    }

}
