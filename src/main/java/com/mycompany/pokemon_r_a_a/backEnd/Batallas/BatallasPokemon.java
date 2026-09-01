package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import java.util.Random;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class BatallasPokemon extends RealizacionDeAtaqueMovimiento {

    private HallDeLaFama hallDeLaFama;

    public BatallasPokemon(Scanner scaner, HallDeLaFama hallDeLaFama) {
        this.scaner = scaner;
        this.hallDeLaFama = hallDeLaFama;
    }

    Pokemons pokemonJugador;
    Pokemons pokemonRival;

    public void pokemonPeleaHierva(JugadorPokemonPartida jugador, Pokemons pokemonSalvaje) {
        jugador.incrementarBatallasSalvajes();
        Pokemons[] pokemonsJugador = jugador.getPokemosEquipo();
        pokemonRival = pokemonSalvaje;

        jugadorPokemonIndice = jugador.getPrimerPokemonVivoIndice();
        if (jugadorPokemonIndice == -1) {
            impresorMenus.mensajeSinPokemonsVivos();
            return;
        }

        boolean batallaEnCurso = true;

        while (batallaEnCurso) {
            pokemonJugador = pokemonsJugador[jugadorPokemonIndice];

            if (condicionDeVictoria(jugador, null, pokemonsJugador, false)) {
                return;
            }

            impresorMenus.impresorDePrincipal(jugador.getNombre(), "Pokémon Salvaje", pokemonRival, pokemonJugador);
            impresorMenus.impresorDeBatallaOpcionesPokemonSalvaje();

            int opcion;
            try {
                opcion = Integer.parseInt(scaner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            selecionador(opcion, jugador, "Pokémon Salvaje", pokemonRival, pokemonJugador, pokemonsJugador, true);
        }
    }

    public void pokemonsPelea(JugadorPokemonPartida jugador, Entrenador enemigo) {
        jugador.incrementarBatallasEntrenador();
        Pokemons[] pokemonsJugador = jugador.getPokemosEquipo();
        Pokemons[] pokemonsEnemigo = enemigo.getLista();

        jugadorPokemonIndice = jugador.getPrimerPokemonVivoIndice();
        if (jugadorPokemonIndice == -1) {
            impresorMenus.mensajeSinPokemonsVivos();
            return;
        }

        enemigoPokemonIndice = 0;
        if (pokemonsEnemigo != null) {
            for (int i = 0; i < pokemonsEnemigo.length; i++) {
                if (pokemonsEnemigo[i] != null && pokemonsEnemigo[i].getVidaPokemon() > 0) {
                    enemigoPokemonIndice = i;
                    break;
                }
            }
        }

        boolean batallaEnCurso = true;

        while (batallaEnCurso) {
            pokemonJugador = pokemonsJugador[jugadorPokemonIndice];
            if (pokemonsEnemigo != null && enemigoPokemonIndice < pokemonsEnemigo.length) {
                pokemonRival = pokemonsEnemigo[enemigoPokemonIndice];
            } else {
                pokemonRival = null;
            }

            if (pokemonRival == null) {
                int recompensa = 200;
                jugador.setPokemonedas(jugador.getPokemonedas() + recompensa);
                impresorMenus.pantallaVictoriaEntrenador(enemigo.getNombre(), recompensa);
                return;
            }
            if (condicionDeVictoria(jugador, enemigo, pokemonsEnemigo, true)) {
                return;
            }

            impresorMenus.impresorDePrincipal(jugador.getNombre(), enemigo.getNombre(), pokemonRival, pokemonJugador);
            impresorMenus.impresorDeBatallaOpciones();

            int opcion;
            try {
                opcion = Integer.parseInt(scaner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            selecionador(opcion, jugador, enemigo.getNombre(), pokemonRival, pokemonJugador, pokemonsJugador, false);
        }
    }

    private boolean condicionDeVictoria(JugadorPokemonPartida jugador, Entrenador enemigo, Pokemons[] pokemonsEnemigo,
            boolean combateGimnacio) {
        if (pokemonJugador.getVidaPokemon() <= 0) {
            impresorMenus.mensajePokemonDebilitado(pokemonJugador.getNombre());
            jugadorPokemonIndice = jugador.getPrimerPokemonVivoIndice();
            if (jugadorPokemonIndice == -1) {
                derrota(true, jugador);
                impresorMenus.pantallaDerrota();
                return true;
            }

            impresorMenus.mensajePokemonEntra(pokemonJugador.getNombre());
        }

        if (pokemonRival.getVidaPokemon() <= 0 && combateGimnacio) {
            int xpPokemon = ((pokemonRival.getNivel()) ^ 2) / 2;
            pokemonJugador.setXp(pokemonJugador.getXp() + xpPokemon);
            pokemonJugador.incrementarEnemigosDebilitados(); // MVP Tracker
            impresorMenus.mensajePokemonDebilitado(pokemonRival.getNombre());
            enemigoPokemonIndice = aiEnemigo.seleccionarPokemonCambio(pokemonsEnemigo);
            if (enemigoPokemonIndice == -1) {
                victoria(jugador, enemigo);
                return true;

            }
            impresorMenus.mensajeEntrenadorCambiaPokemon(enemigo.getNombre(), pokemonRival.getNombre());
        } else if (pokemonRival.getVidaPokemon() <= 0) {
            int xpPokemon = ((pokemonRival.getNivel()) ^ 2) / 2;
            pokemonJugador.setXp(pokemonJugador.getXp() + xpPokemon);
            pokemonJugador.incrementarEnemigosDebilitados(); // MVP Tracker
            impresorMenus.pantallaVictoriaSalvaje(pokemonRival.getNombre(), pokemonJugador.getNombre(), xpPokemon);
            return true;

        }
        return false;

    }

    private void derrota(boolean entrenador, JugadorPokemonPartida jugador) {
        int pagoDerrota;
        int pokemonedasActuales = jugador.getPokemonedas();
        pagoDerrota = pokemonedasActuales / 2;
        if (entrenador) {
            jugador.setPokemonedas(pagoDerrota);
        }
    }

    private void victoria(JugadorPokemonPartida jugador, Entrenador entrenador) {
        Random rand = new Random();
        int pokemonedasGanadas = rand.ints(DINERO_GANADO_RANGO_A, DINERO_GANADO_RANGO_B + 1).findFirst().getAsInt();
        int pokemonedasActual = jugador.getPokemonedas();
        pokemonedasGanadas = pokemonedasGanadas + pokemonedasActual;
        jugador.setPokemonedas(pokemonedasGanadas);
        impresorMenus.pantallaVictoriaEntrenador(entrenador.getNombre(), pokemonedasGanadas);
        if (entrenador.getbBleanoActivo()) {
            int ciudadIndice = entrenador.getCiudad();
            int[] medallas = jugador.getMedallasObtenidas();
            if (medallas[ciudadIndice] == 0) {
                medallas[ciudadIndice] = 1;
                int contador = 0;
                for (int m : medallas) {
                    if (m > 0)
                        contador++;
                }
                if (contador >= 3) {
                    hallDeLaFama.registrarVictoria(jugador);
                }
            }
        }

    }
}
