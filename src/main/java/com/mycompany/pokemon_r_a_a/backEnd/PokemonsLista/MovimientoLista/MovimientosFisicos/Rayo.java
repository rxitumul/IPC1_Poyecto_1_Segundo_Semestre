package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Paralizado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Rayo extends Fisico {
    public Rayo() {
        nombre = "Rayo";
        potencia = 100;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a realizado un ataque electrico"));
        if (rand.nextDouble() > 0.2) {
            System.out.println(confi.formatearMapa("El pokemon a paralizado al oponete"));
            pokemonAtacado.agragarEstado(new Paralizado());
        }
        confi.separadorFinalMapa();
    }
}
