package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class BatallasPokemon extends TurnosDeJuego {

    public BatallasPokemon(Scanner scaner, HallDeLaFama hallDeLaFama) {
        this.scaner = scaner;
        this.hallDeLaFama = hallDeLaFama;
    }

    /**
     * Inicia el combate contra un Pokémon salvaje en la hierba alta.
     */
    public void pokemonPeleaHierva(JugadorPokemonPartida jugador, Pokemons pokemonSalvaje) {
        jugador.incrementarBatallasSalvajes();
        Pokemons[] pokemonsJugador = jugador.getPokemosEquipo();
        pokemonRival = pokemonSalvaje;

        // Ambos lados envían a su primer Pokémon disponible (HP > 0)
        jugadorPokemonIndice = jugador.getPrimerPokemonVivoIndice();
        if (jugadorPokemonIndice == -1) {
            impresorMenus.mensajeSinPokemonsVivos();
            return;
        }

        pokemonJugador = pokemonsJugador[jugadorPokemonIndice];
        System.out.println(impresorMenus.formatearMapa("¡Un " + pokemonRival.getNombre() + " salvaje ha aparecido!"));
        impresorMenus.mensajePokemonEntra(pokemonJugador.getNombre());

        boolean batallaTerminada = false;

        while (!batallaTerminada) {
            pokemonJugador = pokemonsJugador[jugadorPokemonIndice];

            // ─── Cansado: bloquear menú completo ───
            if (pokemonJugador.tieneEstado("Cansado")) {
                System.out.println(impresorMenus.formatearMapa(
                        "¡" + pokemonJugador.getNombre()
                                + " está exhausto y necesita descansar este turno! No puede realizar ninguna acción."));
                pokemonJugador.eliminarEstado("Cansado");

                int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
                ejecutarAccionAtaque(pokemonRival, pokemonJugador, pokemonRival.getMovimientos()[movEnemigo]);
                procesarFinDeTurno(pokemonJugador, pokemonRival);

                if (pokemonJugador.getVidaPokemon() <= 0) {
                    if (manejarMuerteJugador(jugador, pokemonsJugador, false)) {
                        return;
                    }
                }
                if (pokemonRival.getVidaPokemon() <= 0) {
                    if (manejarMuerteRival(jugador, null, null, true)) {
                        return;
                    }
                }
                continue;
            }

            impresorMenus.impresorDePrincipal(jugador.getNombre(), "Pokémon Salvaje", pokemonRival, pokemonJugador);
            impresorMenus.impresorDeBatallaOpcionesPokemonSalvaje();

            int opcion;
            try {
                opcion = Integer.parseInt(scaner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            batallaTerminada = selecionador(opcion, jugador, null, null, pokemonsJugador, true, "Pokémon Salvaje");
        }
    }

    /**
     * Inicia el combate contra un Entrenador o Líder de Gimnasio.
     */
    public void pokemonsPelea(JugadorPokemonPartida jugador, Entrenador enemigo) {
        jugador.incrementarBatallasEntrenador();
        Pokemons[] pokemonsJugador = jugador.getPokemosEquipo();
        Pokemons[] pokemonsEnemigo = enemigo.getLista();

        // Ambos lados envían a su primer Pokémon disponible (HP > 0)
        jugadorPokemonIndice = jugador.getPrimerPokemonVivoIndice();
        if (jugadorPokemonIndice == -1) {
            impresorMenus.mensajeSinPokemonsVivos();
            return;
        }

        enemigoPokemonIndice = -1;
        if (pokemonsEnemigo != null) {
            for (int i = 0; i < pokemonsEnemigo.length; i++) {
                if (pokemonsEnemigo[i] != null && pokemonsEnemigo[i].getVidaPokemon() > 0) {
                    enemigoPokemonIndice = i;
                    break;
                }
            }
        }

        if (enemigoPokemonIndice == -1) {
            victoria(jugador, enemigo);
            return;
        }

        pokemonRival = pokemonsEnemigo[enemigoPokemonIndice];
        pokemonJugador = pokemonsJugador[jugadorPokemonIndice];

        System.out.println(
                impresorMenus.formatearMapa("¡El entrenador " + enemigo.getNombre() + " te desafía a un combate!"));
        impresorMenus.mensajeEntrenadorCambiaPokemon(enemigo.getNombre(), pokemonRival.getNombre());
        impresorMenus.mensajePokemonEntra(pokemonJugador.getNombre());

        boolean batallaTerminada = false;

        while (!batallaTerminada) {
            pokemonJugador = pokemonsJugador[jugadorPokemonIndice];

            // ─── Cansado: bloquear menú completo ───
            if (pokemonJugador.tieneEstado("Cansado")) {
                System.out.println(impresorMenus.formatearMapa(
                        "¡" + pokemonJugador.getNombre()
                                + " está exhausto y necesita descansar este turno! No puede realizar ninguna acción."));
                pokemonJugador.eliminarEstado("Cansado");

                int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
                ejecutarAccionAtaque(pokemonRival, pokemonJugador, pokemonRival.getMovimientos()[movEnemigo]);
                procesarFinDeTurno(pokemonJugador, pokemonRival);

                if (pokemonJugador.getVidaPokemon() <= 0) {
                    if (manejarMuerteJugador(jugador, pokemonsJugador, true)) {
                        return;
                    }
                }
                if (pokemonRival.getVidaPokemon() <= 0) {
                    if (manejarMuerteRival(jugador, enemigo, pokemonsEnemigo, false)) {
                        return;
                    }
                }
                continue;
            }

            impresorMenus.impresorDePrincipal(jugador.getNombre(), enemigo.getNombre(), pokemonRival, pokemonJugador);
            impresorMenus.impresorDeBatallaOpciones();

            int opcion;
            try {
                opcion = Integer.parseInt(scaner.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }

            batallaTerminada = selecionador(opcion, jugador, enemigo, pokemonsEnemigo, pokemonsJugador, false,
                    enemigo.getNombre());
        }
    }

    /**
     * Procesa la opción elegida por el jugador en el menú principal.
     */
    protected boolean selecionador(int opcion, JugadorPokemonPartida jugador, Entrenador enemigo,
            Pokemons[] pokemonsEnemigo, Pokemons[] pokemonsJugador, boolean esSalvaje, String nombreEnemigo) {
        switch (opcion) {
            case 1:
                // 1. ATACAR
                impresorMenus.impresorDePrincipal(jugador.getNombre(), nombreEnemigo, pokemonRival, pokemonJugador);
                impresorMenus.seleciondeMovimientos(pokemonJugador);
                int movSeleccionado;
                try {
                    movSeleccionado = Integer.parseInt(scaner.nextLine());
                } catch (NumberFormatException e) {
                    return false;
                }
                if (movSeleccionado == 0) {
                    return false; // Volver al menú sin consumir turno
                }
                int movIndex = movSeleccionado - 1;
                if (movIndex >= 0 && movIndex < pokemonJugador.getMovimientos().length
                        && pokemonJugador.getMovimientos()[movIndex] != null) {
                    return ejecutarTurnoCombate(jugador, movIndex, pokemonsJugador, enemigo, pokemonsEnemigo, esSalvaje,
                            nombreEnemigo);
                }
                return false;

            case 2:
                // 2. CAMBIAR POKÉMON
                return ejecutarTurnoCambio(jugador, pokemonsJugador, enemigo, pokemonsEnemigo, esSalvaje,
                        nombreEnemigo);

            case 3:
                // 3. USAR UN OBJETO
                return ejecutarTurnoObjeto(jugador, pokemonsJugador, enemigo, pokemonsEnemigo, esSalvaje,
                        nombreEnemigo);

            case 4:
                // 4. HUIR
                return ejecutarTurnoHuir(jugador, pokemonsJugador, enemigo, pokemonsEnemigo, esSalvaje);

            default:
                return false;
        }
    }
}
