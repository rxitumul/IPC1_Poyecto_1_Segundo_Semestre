package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;

public abstract class TurnosDeJuego extends Finalizacion {

    /**
     * Ejecuta la resolución de ataques comparando prioridad ("Ataque rápido") y
     * velocidad.
     */
    @Override
    protected boolean ejecutarTurnoCombate(JugadorPokemonPartida jugador, int movJugadorIndex,
            Pokemons[] pokemonsJugador,
            Entrenador enemigo, Pokemons[] pokemonsEnemigo, boolean esSalvaje, String nombreEnemigo) {
        int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
        Movimiento movJ = pokemonJugador.getMovimientos()[movJugadorIndex];
        Movimiento movE = pokemonRival.getMovimientos()[movEnemigo];

        boolean jugadorAtacaPrimero = determinaPrioridad(movJ, movE, pokemonJugador, pokemonRival);

        if (jugadorAtacaPrimero) {
            // Turno del Jugador
            ejecutarAccionAtaque(pokemonJugador, pokemonRival, movJ);
            if (pokemonRival.getVidaPokemon() <= 0) {
                return manejarMuerteRival(jugador, enemigo, pokemonsEnemigo, esSalvaje);
            }

            // Turno del Rival
            ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
            if (pokemonJugador.getVidaPokemon() <= 0) {
                return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
            }
        } else {
            // Turno del Rival
            ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
            if (pokemonJugador.getVidaPokemon() <= 0) {
                return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
            }

            // Turno del Jugador
            ejecutarAccionAtaque(pokemonJugador, pokemonRival, movJ);
            if (pokemonRival.getVidaPokemon() <= 0) {
                return manejarMuerteRival(jugador, enemigo, pokemonsEnemigo, esSalvaje);
            }
        }

        // Fin de turno (veneno, drenadoras, etc.)
        procesarFinDeTurno(pokemonJugador, pokemonRival);

        if (pokemonRival.getVidaPokemon() <= 0) {
            return manejarMuerteRival(jugador, enemigo, pokemonsEnemigo, esSalvaje);
        }
        if (pokemonJugador.getVidaPokemon() <= 0) {
            return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
        }

        return false;
    }

    /**
     * Permite retirar el Pokémon actual y enviar a otro con HP > 0. Consume el
     * turno.
     */
    protected boolean ejecutarTurnoCambio(JugadorPokemonPartida jugador, Pokemons[] pokemonsJugador,
            Entrenador enemigo, Pokemons[] pokemonsEnemigo, boolean esSalvaje, String nombreEnemigo) {
        impresorMenus.impresorDePrincipal(jugador.getNombre(), nombreEnemigo, pokemonRival, pokemonJugador);
        impresorMenus.cambioPokemon(pokemonsJugador, true);

        int seleccion;
        try {
            seleccion = Integer.parseInt(scaner.nextLine());
        } catch (NumberFormatException e) {
            return false;
        }

        if (seleccion == 0) {
            return false; // Cancela el cambio, no gasta turno
        }

        int index = seleccion - 1;
        if (index < 0 || index >= pokemonsJugador.length || pokemonsJugador[index] == null) {
            System.out.println(impresorMenus.formatearMapa("Selección no válida."));
            return false;
        }
        if (index == jugadorPokemonIndice) {
            System.out.println(impresorMenus.formatearMapa("¡" + pokemonJugador.getNombre() + " ya está en combate!"));
            return false;
        }
        if (pokemonsJugador[index].getVidaPokemon() <= 0) {
            impresorMenus.mensajePokemonSinEnergia();
            return false;
        }

        // Cambio exitoso: consume el turno
        jugadorPokemonIndice = index;
        pokemonJugador = pokemonsJugador[jugadorPokemonIndice];
        impresorMenus.mensajePokemonEntra(pokemonJugador.getNombre());

        // El rival ataca al Pokémon recién ingresado
        int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
        ejecutarAccionAtaque(pokemonRival, pokemonJugador, pokemonRival.getMovimientos()[movEnemigo]);
        if (pokemonJugador.getVidaPokemon() <= 0) {
            return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
        }

        procesarFinDeTurno(pokemonJugador, pokemonRival);
        if (pokemonJugador.getVidaPokemon() <= 0) {
            return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
        }
        if (pokemonRival.getVidaPokemon() <= 0) {
            return manejarMuerteRival(jugador, enemigo, pokemonsEnemigo, esSalvaje);
        }

        return false;
    }

    /**
     * Permite usar un objeto de la mochila. Consume el turno.
     * Si usa Pokébola: solo en salvajes y con menos de 6 Pokémon en equipo.
     */
    protected boolean ejecutarTurnoObjeto(JugadorPokemonPartida jugador, Pokemons[] pokemonsJugador,
            Entrenador enemigo, Pokemons[] pokemonsEnemigo, boolean esSalvaje, String nombreEnemigo) {
        impresorMenus.impresorDePrincipal(jugador.getNombre(), nombreEnemigo, pokemonRival, pokemonJugador);
        impresorMenus.selecionMochila(jugador.getMochilaJugador());

        int itemSeleccionado;
        try {
            itemSeleccionado = Integer.parseInt(scaner.nextLine());
        } catch (NumberFormatException e) {
            return false;
        }

        if (itemSeleccionado == 0) {
            return false; // Cancela sin gastar turno
        }

        // Caso Pokébola
        if (itemSeleccionado == 4) {
            if (!esSalvaje) {
                impresorMenus.mensajeNoPuedeCapturarEntrenador();
                return false;
            }
            if (jugador.getMochilaJugador().getPokebola() <= 0) {
                System.out.println(impresorMenus.formatearMapa("¡No tienes Pokébolas en tu mochila!"));
                return false;
            }
            if (jugador.getCantidadPokemonEquipo() >= 6) {
                System.out
                        .println(impresorMenus.formatearMapa("¡Tu equipo ya tiene 6 Pokémon! No puedes capturar más."));
                return false;
            }

            int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
            Movimiento movE = pokemonRival.getMovimientos()[movEnemigo];
            boolean jugadorPrimero = determinaPrioridad(null, movE, pokemonJugador, pokemonRival);

            if (jugadorPrimero) {
                boolean capturado = intentarCaptura(jugador, pokemonRival);
                if (capturado) {
                    return true;
                }
                // Si la captura falla, el rival ataca
                ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
                if (pokemonJugador.getVidaPokemon() <= 0) {
                    return manejarMuerteJugador(jugador, pokemonsJugador, false);
                }
            } else {
                System.out.println(impresorMenus.formatearMapa(
                        "¡" + pokemonRival.getNombre() + " es más veloz y ataca antes del lanzamiento!"));
                ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
                if (pokemonJugador.getVidaPokemon() <= 0) {
                    return manejarMuerteJugador(jugador, pokemonsJugador, false);
                }
                boolean capturado = intentarCaptura(jugador, pokemonRival);
                if (capturado) {
                    return true;
                }
            }

            procesarFinDeTurno(pokemonJugador, pokemonRival);
            if (pokemonJugador.getVidaPokemon() <= 0) {
                return manejarMuerteJugador(jugador, pokemonsJugador, false);
            }
            return false;
        }

        // Otros objetos curativos
        if (!jugador.getMochilaJugador().tieneObjeto(itemSeleccionado)) {
            System.out.println(impresorMenus.formatearMapa("¡No tienes ese objeto en tu mochila!"));
            return false;
        }

        int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
        Movimiento movE = pokemonRival.getMovimientos()[movEnemigo];
        boolean jugadorPrimero = determinaPrioridad(null, movE, pokemonJugador, pokemonRival);

        if (jugadorPrimero) {
            jugador.acionJugador(2, jugadorPokemonIndice, itemSeleccionado, pokemonJugador);
            ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
            if (pokemonJugador.getVidaPokemon() <= 0) {
                return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
            }
        } else {
            ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
            if (pokemonJugador.getVidaPokemon() <= 0) {
                return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
            }
            jugador.acionJugador(2, jugadorPokemonIndice, itemSeleccionado, pokemonJugador);
        }

        procesarFinDeTurno(pokemonJugador, pokemonRival);
        if (pokemonJugador.getVidaPokemon() <= 0) {
            return manejarMuerteJugador(jugador, pokemonsJugador, !esSalvaje);
        }
        if (pokemonRival.getVidaPokemon() <= 0) {
            return manejarMuerteRival(jugador, enemigo, pokemonsEnemigo, esSalvaje);
        }

        return false;
    }

    /**
     * Intenta escapar del combate.
     * En batallas contra entrenadores esta opción está bloqueada sin gastar el
     * turno.
     * En batallas salvajes se comparan velocidades: si el Pokémon es más lento
     * recibe el ataque antes de huir.
     */
    protected boolean ejecutarTurnoHuir(JugadorPokemonPartida jugador, Pokemons[] pokemonsJugador,
            Entrenador enemigo, Pokemons[] pokemonsEnemigo, boolean esSalvaje) {
        if (!esSalvaje) {
            impresorMenus.mensajeNoPuedeHuir();
            return false; // Bloqueado, no gasta turno
        }

        int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
        Movimiento movE = pokemonRival.getMovimientos()[movEnemigo];
        boolean jugadorPrimero = determinaPrioridad(null, movE, pokemonJugador, pokemonRival);

        if (jugadorPrimero) {
            impresorMenus.mensajeHuidaExitosa();
            return true; // Huida exitosa inmediata
        } else {
            System.out.println(impresorMenus.formatearMapa(
                    "¡" + pokemonRival.getNombre() + " es más veloz y te ataca antes de que puedas huir!"));
            ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
            procesarFinDeTurno(pokemonJugador, pokemonRival);
            if (pokemonJugador.getVidaPokemon() <= 0) {
                return manejarMuerteJugador(jugador, pokemonsJugador, false);
            }
            impresorMenus.mensajeHuidaExitosa();
            return true;
        }
    }

    /**
     * Calcula la captura de un Pokémon salvaje.
     * R aleatorio entre 0 y vidaInicial. Si R > vidaPokemon actual -> capturado.
     */
    protected boolean intentarCaptura(JugadorPokemonPartida jugador, Pokemons pokemonSalvaje) {
        int pokebola = jugador.getMochilaJugador().getPokebola();
        jugador.getMochilaJugador().setPokebola(pokebola - 1);
        jugador.incrementarPokebolasLanzadas();

        int maxHp = pokemonSalvaje.getVidaInicial();
        int currentHp = pokemonSalvaje.getVidaPokemon();
        int r = rand.nextInt(maxHp + 1);

        if (r > currentHp) {
            jugador.incrementarPokemonCapturados();
            impresorMenus.pantallaCapturaExitosa(pokemonSalvaje.getNombre());
            System.out.println(impresorMenus
                    .formatearMapa("¿Deseas ponerle un apodo a tu nuevo Pokémon? (Presiona ENTER para omitir):"));
            String apodo = scaner.nextLine().trim();
            if (!apodo.isEmpty()) {
                pokemonSalvaje.setApodo(apodo);
            }
            Pokemons[] equipo = jugador.getPokemosEquipo();
            for (int i = 0; i < equipo.length; i++) {
                if (equipo[i] == null) {
                    equipo[i] = pokemonSalvaje;
                    break;
                }
            }
            return true;
        } else {
            impresorMenus.pantallaCapturaFallida();
            return false;
        }
    }

    

}
