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
        System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " disparó un poderoso Rayo!"));
        if (rand.nextDouble() <= 0.20) {
            String nombreObjetivo = pokemonAtacado.getApodo() != null ? pokemonAtacado.getApodo() : pokemonAtacado.getNombre();
            System.out.println(confi.formatearMapa("¡" + nombreObjetivo + " ha sido paralizado!"));
            if (!pokemonAtacado.tieneEstado("Paralizado")) {
                pokemonAtacado.agragarEstado(new Paralizado());
            }
        }
    }

}
