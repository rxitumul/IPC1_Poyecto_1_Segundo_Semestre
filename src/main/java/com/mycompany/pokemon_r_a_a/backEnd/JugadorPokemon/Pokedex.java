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
            impresor.impresorDePokedex(pokemon);
            String entrada = scanner.nextLine().trim();
            if (entrada.isEmpty() || entrada.equalsIgnoreCase("X") || entrada.equalsIgnoreCase("0") || entrada.equalsIgnoreCase("salir")) {
                break;
            }

            int indexEncontrado = -1;
            try {
                int num = Integer.parseInt(entrada);
                if (num >= 1 && num <= pokemon.length) {
                    indexEncontrado = num - 1;
                }
            } catch (NumberFormatException e) {
                for (int i = 0; i < pokemon.length; i++) {
                    if (pokemon[i] != null && pokemon[i].getNombre() != null
                            && pokemon[i].getNombre().equalsIgnoreCase(entrada)) {
                        indexEncontrado = i;
                        break;
                    }
                }
            }

            if (indexEncontrado != -1 && pokemon[indexEncontrado] != null) {
                impresor.impresorDePokemon(pokemon, indexEncontrado);
                scanner.nextLine();
            } else {
                impresor.mensajeInformativo("No se encontró ningún Pokémon con ese número o nombre.");
            }
        } while (true);
    }

}
