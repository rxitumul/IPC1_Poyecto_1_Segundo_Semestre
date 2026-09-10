package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeSelecion;

public class Pokedex implements Serializable {
    private Pokemons[] pokemon;
    private transient ImpresorDeSelecion impresor;
    private transient Scanner scanner;

    public Pokedex(Pokemons[] pokemon, Scanner scanner) {
        this.pokemon = pokemon;
        this.scanner = scanner;
        impresor = new ImpresorDeSelecion();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        impresor = new ImpresorDeSelecion();
        this.scanner = new Scanner(System.in);

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
