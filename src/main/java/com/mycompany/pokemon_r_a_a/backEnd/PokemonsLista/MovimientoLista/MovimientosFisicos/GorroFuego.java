package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Confuso;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class GorroFuego extends Fisico {
    public GorroFuego() {
        nombre = "GorroFuego";
        potencia=75;
    }

    @Override
    protected void estadosAlterados() {
          System.out.println(confi.formatearMapa("El pokemon a realizado garra fuego"));
        if (rand.nextDouble() > 0.1) {
            System.out.println(confi.formatearMapa("El pokemon a confundido al oponete"));
            pokemonAtacado.agragarEstado(new Confuso());
        }
        confi.separadorFinalMapa();
    }
}
