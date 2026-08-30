package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorBatallaMenus;

public class BatallasPokemon {

    private ImpresorBatallaMenus impresorMenus = new ImpresorBatallaMenus();
    private Scanner scaner;

    public BatallasPokemon(Scanner scaner) {
        this.scaner = scaner;
    }

    public void pokemonsPelea(JugadorPokemonPartida Jugador, Entrenador enemigo) {

        Pokemons pokemonRival = new Pokemons();
        Pokemons pokemonJugador = new Pokemons();
        Movimiento[] movimiento;

        impresorMenus.impresorDePrincipal(Jugador.getNombre(), enemigo.getNombre(), pokemonRival, pokemonJugador);
        impresorMenus.impresorDeBatallaOpciones();
        int opcion = Integer.parseInt(scaner.nextLine());
        switch (opcion) {
            case 1:
                impresorMenus.impresorDePrincipal(Jugador.getNombre(), enemigo.getNombre(), pokemonRival,
                        pokemonJugador);
                impresorMenus.seleciondeMovimientos(pokemonJugador);
                int selecionado = Integer.parseInt(scaner.nextLine());
                movimiento = pokemonJugador.getMovimientos();
                
                movimiento[selecionado].getNombre();

                break;
            case 2:

                break;

            default:
                break;
        }

    }

}
