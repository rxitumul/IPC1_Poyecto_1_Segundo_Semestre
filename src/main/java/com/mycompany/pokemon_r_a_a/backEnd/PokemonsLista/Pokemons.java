package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;

public class Pokemons {
    private String nombreLocal;
    private Movimiento[] movimientosPokemonLocal;
    private int[] statusLocal;

    public void setNombre(String nombre) {
        nombreLocal = nombre;
    }

    public void setMovimientos(Movimiento[] movimientosPokemon) {
        movimientosPokemonLocal = movimientosPokemon;
    }

    public void setStatus(int[] status) {
        statusLocal = status;
    }

    public String getNombre() {
        return nombreLocal;
    }

    public Movimiento[] getMovimientos() {
        return movimientosPokemonLocal;
    }

    public int[] getStatus() {
        return statusLocal;
    }

}
