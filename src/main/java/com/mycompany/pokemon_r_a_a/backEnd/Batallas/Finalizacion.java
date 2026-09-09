package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;

public abstract class Finalizacion extends RealizacionDeAtaqueMovimiento {



    protected boolean manejarMuerteJugador(JugadorPokemonPartida jugador, Pokemons[] pokemonsJugador,
            boolean esEntrenador) {
        impresorMenus.mensajePokemonDebilitado(pokemonJugador.getNombre());

        if (!jugador.tienePokemonVivos()) {
            derrota(esEntrenador, jugador);
            return true;
        }

        System.out.println(impresorMenus.formatearMapa("¡" + pokemonJugador.getNombre()
                + " no puede continuar! Debes enviar a otro integrante de tu equipo."));
        while (true) {
            impresorMenus.cambioPokemon(pokemonsJugador, false);
            int opcion;
            try {
                opcion = Integer.parseInt(scaner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(impresorMenus.formatearMapa("Selección inválida. Elige un Pokémon con vida."));
                continue;
            }
            int index = opcion - 1;
            if (index >= 0 && index < pokemonsJugador.length && pokemonsJugador[index] != null) {
                if (pokemonsJugador[index].getVidaPokemon() > 0) {
                    jugadorPokemonIndice = index;
                    pokemonJugador = pokemonsJugador[jugadorPokemonIndice];
                    impresorMenus.mensajePokemonEntra(pokemonJugador.getNombre());
                    return false;
                } else {
                    impresorMenus.mensajePokemonSinEnergia();
                }
            } else {
                System.out.println(impresorMenus.formatearMapa("Selección inválida. Elige un Pokémon con vida."));
            }
        }
    }

    protected void victoria(JugadorPokemonPartida jugador, Entrenador entrenador) {
        int recompensa = rand.nextInt(DINERO_GANADO_RANGO_B - DINERO_GANADO_RANGO_A + 1) + DINERO_GANADO_RANGO_A;
        jugador.setPokemonedas(jugador.getPokemonedas() + recompensa);
        impresorMenus.pantallaVictoriaEntrenador(entrenador.getNombre(), recompensa);

        if (entrenador.getbBleanoActivo()) {
            int ciudadIndice = entrenador.getCiudad();
            int[] medallas = jugador.getMedallasObtenidas();
            if (medallas != null && ciudadIndice >= 0 && ciudadIndice < medallas.length) {
                if (medallas[ciudadIndice] == 0) {
                    medallas[ciudadIndice] = 1;
                    System.out.println(impresorMenus.formatearMapa("¡Has ganado la Medalla de la Ciudad!"));
                    int contador = 0;
                    for (int m : medallas) {
                        if (m > 0) {
                            contador++;
                        }
                    }
                    if (contador >= 3 && hallDeLaFama != null) {
                        hallDeLaFama.registrarVictoria(jugador);
                    }
                }
            }
        }
    }

    protected void derrota(boolean entrenador, JugadorPokemonPartida jugador) {
        if (entrenador) {
            int pago = jugador.getPokemonedas() / 2;
            jugador.setPokemonedas(jugador.getPokemonedas() - pago);
            System.out
                    .println(impresorMenus.formatearMapa("¡Has pagado $" + pago + " PokéMonedas al entrenador rival!"));
        }

        impresorMenus.pantallaDerrota();
        jugador.setVencido(true);
        // Use EnfermeriaNpc instance to heal the team
        EnfermeriaNpc enfermera = new EnfermeriaNpc();
        enfermera.setLista(jugador.getPokemosEquipo());
        enfermera.setBoleanoActivo(true);
        enfermera.accion();
        System.out.println(impresorMenus.formatearMapa("¡Has sido derrotado! Apareces en el Centro Pokémon más cercano."));
    }

}
