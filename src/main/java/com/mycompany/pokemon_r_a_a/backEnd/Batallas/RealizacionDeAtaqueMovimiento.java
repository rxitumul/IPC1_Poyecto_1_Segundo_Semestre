package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.Batallas.enemigos.AiEnemigo;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorBatallaMenus;

public class RealizacionDeAtaqueMovimiento {

    protected static final int DINERO_GANADO_RANGO_A = 150;
    protected static final int DINERO_GANADO_RANGO_B = 500;

    protected ImpresorBatallaMenus impresorMenus = new ImpresorBatallaMenus();
    protected AiEnemigo aiEnemigo = new AiEnemigo();
    protected int jugadorPokemonIndice;
    protected int enemigoPokemonIndice;
    protected Scanner scaner;

    private void ejecutarTurnoCombate(JugadorPokemonPartida jugador, int movJugador, Pokemons pokemonJugador,
            Pokemons pokemonRival) {
        int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());

        Movimiento movJ = pokemonJugador.getMovimientos()[movJugador];
        Movimiento movE = pokemonRival.getMovimientos()[movEnemigo];

        boolean jugadorPrioridad = movJ.getNombre().equalsIgnoreCase("AtaqueRápido") || pokemonJugador.getPrioritario();
        boolean rivalPrioridad = movE.getNombre().equalsIgnoreCase("AtaqueRápido") || pokemonRival.getPrioritario();

        pokemonJugador.setPrioritario(false);
        pokemonRival.setPrioritario(false);

        boolean jugadorAtacaPrimero;

        if (jugadorPrioridad && !rivalPrioridad) {
            jugadorAtacaPrimero = true;
        } else if (!jugadorPrioridad && rivalPrioridad) {
            jugadorAtacaPrimero = false;
        } else {
            jugadorAtacaPrimero = pokemonJugador.getVelocidadPokemon() >= pokemonRival.getVelocidadPokemon();
        }

        if (jugadorAtacaPrimero) {
            // Turno del Jugador
            jugador.acionJugador(1, jugadorPokemonIndice, movJugador, pokemonRival);

            // Si el rival sobrevive, contraataca
            if (pokemonRival.getVidaPokemon() > 0) {
                aiEnemigo.ataqueEnemigo(pokemonRival, pokemonJugador, movEnemigo);
            }
        } else {
            // Turno del Rival
            aiEnemigo.ataqueEnemigo(pokemonRival, pokemonJugador, movEnemigo);

            // Si el jugador sobrevive, contraataca
            if (pokemonJugador.getVidaPokemon() > 0) {
                jugador.acionJugador(1, jugadorPokemonIndice, movJugador, pokemonRival);
            }
        }
    }

    protected boolean selecionador(int opcion, JugadorPokemonPartida jugador, String nombreEnemigo, Pokemons pokemonRival,
            Pokemons pokemonJugador, Pokemons[] pokemonsJugador, boolean capturaPokemonhierva) {
        switch (opcion) {
            case 1:
                // LUCHAR
                impresorMenus.impresorDePrincipal(jugador.getNombre(), nombreEnemigo, pokemonRival,
                        pokemonJugador);
                impresorMenus.seleciondeMovimientos(pokemonJugador);
                int movSeleccionado;
                try {
                    movSeleccionado = Integer.parseInt(scaner.nextLine());
                } catch (NumberFormatException e) {
                    return false;
                }
                if (movSeleccionado == 0) {
                    break;
                }
                int movIndex = movSeleccionado - 1;
                if (movIndex >= 0 && movIndex < pokemonJugador.getMovimientos().length) {
                    ejecutarTurnoCombate(jugador, movIndex, pokemonJugador, pokemonRival);
                }
                break;

            case 2:
                // MOCHILA
                impresorMenus.impresorDePrincipal(jugador.getNombre(), nombreEnemigo, pokemonRival,
                        pokemonJugador);
                impresorMenus.selecionMochila(jugador.getMochilaJugador());
                int itemSeleccionado;
                try {
                    itemSeleccionado = Integer.parseInt(scaner.nextLine());
                } catch (NumberFormatException e) {
                    return false;

                }
                if (itemSeleccionado == 0) {
                    break;
                }
                if (itemSeleccionado == 4) {
                    if (capturaPokemonhierva) {
                        jugador.acionJugador(2, jugadorPokemonIndice, 4, pokemonRival);
                        if (jugador.getCaptura()) {
                            impresorMenus.pantallaCapturaExitosa(pokemonRival.getNombre());
                            return true;
                        } else {
                            impresorMenus.pantallaCapturaFallida();
                            int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
                            aiEnemigo.ataqueEnemigo(pokemonRival, pokemonJugador, movEnemigo);
                        }
                    } else {
                        impresorMenus.mensajeNoPuedeCapturarEntrenador();
                    }

                } else {
                    jugador.acionJugador(2, jugadorPokemonIndice, itemSeleccionado, pokemonJugador);
                    int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
                    aiEnemigo.ataqueEnemigo(pokemonRival, pokemonJugador, movEnemigo);
                }
                break;

            case 3:
                // CAMBIAR POKÉMON
                impresorMenus.impresorDePrincipal(jugador.getNombre(), nombreEnemigo, pokemonRival,
                        pokemonJugador);
                impresorMenus.cambioPokemon(pokemonsJugador);
                int cambioIndex = 0;
                try {
                    cambioIndex = Integer.parseInt(scaner.nextLine());
                } catch (NumberFormatException e) {
                    return false;
                }
                if (cambioIndex >= 0 && cambioIndex < pokemonsJugador.length
                        && pokemonsJugador[cambioIndex] != null) {
                    if (pokemonsJugador[cambioIndex].getVidaPokemon() > 0 && cambioIndex != jugadorPokemonIndice) {
                        jugadorPokemonIndice = cambioIndex;
                        pokemonJugador = pokemonsJugador[jugadorPokemonIndice];
                        impresorMenus.mensajePokemonEntra(pokemonJugador.getNombre());
                        int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
                        aiEnemigo.ataqueEnemigo(pokemonRival, pokemonJugador, movEnemigo);
                    } else if (pokemonsJugador[cambioIndex].getVidaPokemon() <= 0) {
                        impresorMenus.mensajePokemonSinEnergia();
                    }
                }
                break;
            case 4:
               
                return capturaPokemonhierva;

            default:
                return false;
        }
        return false;
    }

}
