package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

public abstract class Movimiento {
    protected String nombre = "nombre Base";
    protected Pokemons pokemonUsuario;
    protected Pokemons pokemonAtacado;
    protected Random rand = new Random();
    protected int tipoDeAtaque;
    protected ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPokemonUsuario(Pokemons pokemonUsuario) {
        this.pokemonUsuario = pokemonUsuario;
    }

    public Pokemons getPokemonUsuario() {
        return pokemonUsuario;
    }

    public void setpokemonAtacado(Pokemons pokemonAtacado) {
        this.pokemonAtacado = pokemonAtacado;
    }

    public void ataque(){
       resultadoAcion(false);
    }
    protected abstract int resultadoAcion(Boolean recursivo);

    protected abstract void estadosAlterados();

}
