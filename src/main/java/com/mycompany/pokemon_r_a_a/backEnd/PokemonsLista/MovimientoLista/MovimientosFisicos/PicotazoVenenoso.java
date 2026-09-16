package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Envenenado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class PicotazoVenenoso extends Fisico {
    public PicotazoVenenoso() {
        nombre = "Picotazo Venenoso";
        potencia = 20;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("¡Ataque con aguijón tóxico!"));
        if (rand.nextDouble() <= 0.15) {
            String nombreObjetivo;
            if (pokemonAtacado.getApodo() != null) {
                nombreObjetivo = pokemonAtacado.getApodo();
            } else {
                nombreObjetivo = pokemonAtacado.getNombre();
            }
            System.out.println(confi.formatearMapa("¡" + nombreObjetivo + " ha sido envenenado!"));
            if (!pokemonAtacado.tieneEstado("Envenenado")) {
                pokemonAtacado.agragarEstadoPermanete(new Envenenado(pokemonAtacado));
            }
        }
    }
}

