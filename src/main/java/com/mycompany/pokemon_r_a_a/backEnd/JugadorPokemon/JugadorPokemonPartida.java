package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeSelecion;

public class JugadorPokemonPartida {
    private String nombre;
    private int pokemonedas;
    private int[] medallasObtenidas = { 0, 0, 0 };
    private Scanner scanner;
    private Pokemons[] pokemosEquipo;
    private ImpresorDeSelecion impresorDeSelecion = new ImpresorDeSelecion();

    public JugadorPokemonPartida(Scanner scanner) {
        pokemonedas = 1000;
        this.scanner = scanner;
    }

    public int[] getMedallasObtenidas() {
        return medallasObtenidas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPokemonedas() {
        return pokemonedas;
    }
    public Pokemons[] getPokemosEquipo() {
        return pokemosEquipo;
    }
    public void setPokemosEquipo(Pokemons[] pokemosEquipo) {
        this.pokemosEquipo = pokemosEquipo;
    }

    public void setMedallasObtenidas(int[] medallasObtenidas) {
        this.medallasObtenidas = medallasObtenidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPokemonedas(int pokemonedas) {
        this.pokemonedas = pokemonedas;
    }

    public void perfil(MapaCiudad[] mapaCiudadesLocal) {
        impresorDeSelecion.impresorDeEstadoJugador(this, mapaCiudadesLocal);
        scanner.nextLine();
    }

}
