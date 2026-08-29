package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeSelecion;

public class Pokedex {
    private Pokemons[] pokemon;
    private ImpresorDeSelecion impresor = new ImpresorDeSelecion();
    private Scanner scanner = new Scanner(System.in);

    public Pokedex(Pokemons[] pokemon, Scanner scanner) {
        this.pokemon = pokemon;
        this.scanner = scanner;
    }

    public void pokedexMenu() {
        do {
            try {
                impresor.impresorDePokedex(pokemon);
                int selecionDeJugador = Integer.parseInt(scanner.nextLine());
                impresor.impresorDePokemon(pokemon, selecionDeJugador);
                scanner.nextLine();
            } catch (NumberFormatException e) {
                break;
            }
        } while (true);
    }

}
