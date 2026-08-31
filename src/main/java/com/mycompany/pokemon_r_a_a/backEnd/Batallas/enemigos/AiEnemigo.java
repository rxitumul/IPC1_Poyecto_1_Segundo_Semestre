package com.mycompany.pokemon_r_a_a.backEnd.Batallas.enemigos;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;

public class AiEnemigo {
    private Random random = new Random();

    /**
     * Elige un ataque al azar de los que tenga disponibles su Pokémon en ese momento.
     */
    public int selecionadorDeAtaque(Movimiento[] enemigo) {
        if (enemigo == null || enemigo.length == 0) {
            return 0;
        }
        return random.nextInt(enemigo.length);
    }

    /**
     * Ejecuta el ataque elegido por la IA contra el Pokémon del jugador.
     */
    public void ataqueEnemigo(Pokemons enemigPokemons, Pokemons jugador, int movimientoEnemigo) {
        if (enemigPokemons == null || jugador == null) {
            return;
        }
        Movimiento[] movimientosEnemigo = enemigPokemons.getMovimientos();
        if (movimientosEnemigo != null && movimientoEnemigo >= 0 && movimientoEnemigo < movimientosEnemigo.length) {
            movimientosEnemigo[movimientoEnemigo].setpokemonAtacado(jugador);
            movimientosEnemigo[movimientoEnemigo].ataque();
        }
    }

    /**
     * Selecciona el siguiente Pokémon con vida del equipo rival (para entrenadores).
     */
    public int seleccionarPokemonCambio(Pokemons[] equipoEnemigo) {
        if (equipoEnemigo == null || equipoEnemigo.length == 0) {
            return -1;
        }
        for (int i = 0; i < equipoEnemigo.length; i++) {
            if (equipoEnemigo[i] != null && equipoEnemigo[i].getVidaPokemon() > 0) {
                return i;
            }
        }
        return -1;
    }
}
