package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class DobleFilo extends Fisico {
    public DobleFilo() {
        nombre = "DobleFilo";
        potencia = 100;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon ha usado Doble Filo y recibió daño de retroceso del 20%"));
        int dañoRecibido = (int) (daño * 0.2);
        if (dañoRecibido < 1 && daño > 0) {
            dañoRecibido = 1;
        }
        int vida = pokemonUsuario.getVidaPokemon();
        vida -= dañoRecibido;
        if (vida < 0) {
            vida = 0;
        }
        pokemonUsuario.setVidaPokemon(vida);
    }
}
