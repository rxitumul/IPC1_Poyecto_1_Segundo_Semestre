package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;

public class CapturaPokemon {
    private Random rand = new Random();

    public boolean captura(Pokemons captura, JugadorPokemonPartida jugador) {
        int atraparProb = rand.ints(0, captura.getVidaInicial() + 1).findFirst().getAsInt();
        if (atraparProb > captura.getVidaPokemon()) {
            Pokemons[] pokemosEquipo = jugador.getPokemosEquipo();
            for (int i = 0; i < pokemosEquipo.length; i++) {
                if (pokemosEquipo[i] == null) {
                    pokemosEquipo[i] = captura;
                    return true;
                }
            }
        }
        return false;
    }
}
