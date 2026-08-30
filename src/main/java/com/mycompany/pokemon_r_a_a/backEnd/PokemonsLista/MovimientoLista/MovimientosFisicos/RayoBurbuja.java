package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class RayoBurbuja extends Fisico {
    public RayoBurbuja() {
        nombre = "RayoBurbuja";
        potencia = 70;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon a utilizado una rafaga de burbugas"));
        int velocidad = pokemonAtacado.getVelocidadPokemon();
        int reducion = (int) (velocidad * 0.05);
        velocidad -= reducion;
        pokemonAtacado.setVelocidadPokemon(velocidad);
        confi.separadorFinalMapa();
    }
}
