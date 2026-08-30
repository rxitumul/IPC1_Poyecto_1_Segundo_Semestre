package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class DobleFilo extends Fisico {
    public DobleFilo() {
        nombre = "DobleFilo";
        potencia = 100;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a usado doble filo y se le regreso el daño en 20% "));
        int dañoResivido= (int)(daño*0.2);
        int vida=pokemonUsuario.getVidaPokemon();
        vida-= dañoResivido;
        pokemonUsuario.setVidaPokemon(vida);
        confi.separadorFinalMapa();
    }

}
