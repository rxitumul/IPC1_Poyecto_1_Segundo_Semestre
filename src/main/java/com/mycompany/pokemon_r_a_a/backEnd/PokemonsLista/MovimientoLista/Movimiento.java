package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

public abstract class Movimiento implements Serializable {
    protected String nombre = "nombre Base";
    protected int tipoDeAtaque;
    
    protected transient Pokemons pokemonUsuario;
    protected transient Pokemons pokemonAtacado;
    protected transient Random rand;
    protected transient ConfiguracionesDeEstetica confi;

    public Movimiento() {
        confi = new ConfiguracionesDeEstetica();
        rand = new Random();
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Esto carga todo lo normal (vida, medallas, pokemons...)
        confi = new ConfiguracionesDeEstetica();
        rand = new Random();

    }

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

    public void ataque() {
        resultadoAcion(false);
    }

    protected abstract int resultadoAcion(Boolean recursivo);

    protected abstract void estadosAlterados();

}
