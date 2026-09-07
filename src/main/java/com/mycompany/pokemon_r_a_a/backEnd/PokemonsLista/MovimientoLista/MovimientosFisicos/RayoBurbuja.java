package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class RayoBurbuja extends Fisico {
    public RayoBurbuja() {
        nombre = "RayoBurbuja";
        potencia = 70;
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("El pokemon ha utilizado una ráfaga de burbujas"));
        int velocidad = pokemonAtacado.getVelocidadPokemon();
        int reduccion = (int) (velocidad * 0.05);
        if (reduccion < 1 && velocidad > 1) {
            reduccion = 1;
        }
        velocidad = Math.max(1, velocidad - reduccion);
        pokemonAtacado.setVelocidadPokemon(velocidad);
    }
}
