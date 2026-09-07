package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import java.util.Random;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.Batallas.enemigos.AiEnemigo;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Cansado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Confuso;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Dormido;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.DrenadoraDebuf;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Envenenado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Estados;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Paralizado;
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
    protected Random rand = new Random();

    public boolean ejecutarAccionAtaque(Pokemons atacante, Pokemons objetivo, Movimiento mov) {
        if (atacante == null || objetivo == null || mov == null) {
            return false;
        }
        if (atacante.getVidaPokemon() <= 0) {
            return false;
        }

        // 1. Cansado
        Estados cansado = atacante.obtenerEstado(Cansado.class);
        if (cansado != null) {
            System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " está exhausto y descansa este turno!"));
            atacante.eliminarEstadoPorClase(Cansado.class);
            return false;
        }

        // 2. Dormido
        Estados dormido = atacante.obtenerEstado(Dormido.class);
        if (dormido != null) {
            dormido.decrementarContador();
            System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " está profundamente dormido y no puede moverse!"));
            if (dormido.esExpirado()) {
                System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " se ha despertado!"));
                atacante.eliminarEstadoPorClase(Dormido.class);
            }
            return false;
        }

        // 3. Paralizado
        Estados paralizado = atacante.obtenerEstado(Paralizado.class);
        if (paralizado != null) {
            paralizado.decrementarContador();
            System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " está paralizado y no puede moverse!"));
            if (paralizado.esExpirado()) {
                System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " ya no está paralizado!"));
                atacante.eliminarEstadoPorClase(Paralizado.class);
            }
            return false;
        }

        // 4. Confuso
        Estados confuso = atacante.obtenerEstado(Confuso.class);
        if (confuso != null) {
            confuso.decrementarContador();
            System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " está confuso!"));
            boolean seDanioASiMismo = (rand.nextDouble() <= 0.30);
            if (seDanioASiMismo) {
                System.out.println(impresorMenus.formatearMapa("¡Tan confuso está que su ataque se dirigió a sí mismo!"));
                mov.setPokemonUsuario(atacante);
                mov.setpokemonAtacado(atacante);
                mov.ataque();
                if (confuso.esExpirado()) {
                    System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " ya no está confuso!"));
                    atacante.eliminarEstadoPorClase(Confuso.class);
                }
                return false;
            }
            if (confuso.esExpirado()) {
                System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " ya no está confuso!"));
                atacante.eliminarEstadoPorClase(Confuso.class);
            }
        }

        // 5. Ataque exitoso hacia el objetivo
        mov.setPokemonUsuario(atacante);
        mov.setpokemonAtacado(objetivo);
        mov.ataque();
        return true;
    }

    public void procesarFinDeTurno(Pokemons p1, Pokemons p2) {
        aplicarEfectosFinDeTurno(p1);
        aplicarEfectosFinDeTurno(p2);
    }

    private void aplicarEfectosFinDeTurno(Pokemons p) {
        if (p == null || p.getVidaPokemon() <= 0) {
            return;
        }

        // Envenenado: resta el 8% de la salud total en cada turno
        if (p.tieneEstado(Envenenado.class)) {
            int vidaTotal = p.getVidaInicial();
            int danoVeneno = (int) (vidaTotal * 0.08);
            if (danoVeneno < 1) {
                danoVeneno = 1;
            }
            int nuevaVida = Math.max(0, p.getVidaPokemon() - danoVeneno);
            p.setVidaPokemon(nuevaVida);
            System.out.println(impresorMenus.formatearMapa("¡" + p.getNombre() + " sufre " + danoVeneno
                    + " de daño por el veneno! (HP restante: " + nuevaVida + "/" + vidaTotal + ")"));
        }

        // Drenadoras: absorbe 7% de la salud total del oponente y las usa para curar al lanzador
        Estados dren = p.obtenerEstado(DrenadoraDebuf.class);
        if (dren instanceof DrenadoraDebuf) {
            DrenadoraDebuf debuf = (DrenadoraDebuf) dren;
            if (debuf.getLanzador() != null && debuf.getLanzador().getVidaPokemon() > 0 && p.getVidaPokemon() > 0) {
                int drenado = debuf.ejecutarDrenado();
                System.out.println(impresorMenus.formatearMapa("¡Las drenadoras absorben " + drenado + " HP de "
                        + p.getNombre() + " para curar a " + debuf.getLanzador().getNombre() + "!"));
            } else {
                p.eliminarEstadoPorClase(DrenadoraDebuf.class);
            }
        }
    }

    protected void ejecutarTurnoCombate(JugadorPokemonPartida jugador, int movJugador, Pokemons pokemonJugador,
            Pokemons pokemonRival) {
        int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());

        Movimiento movJ = pokemonJugador.getMovimientos()[movJugador];
        Movimiento movE = pokemonRival.getMovimientos()[movEnemigo];

        boolean jugadorPrioridad = movJ.getNombre().equalsIgnoreCase("AtaqueRápido")
                || movJ.getNombre().equalsIgnoreCase("AtaqueRapido") || pokemonJugador.getPrioritario();
        boolean rivalPrioridad = movE.getNombre().equalsIgnoreCase("AtaqueRápido")
                || movE.getNombre().equalsIgnoreCase("AtaqueRapido") || pokemonRival.getPrioritario();

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
            ejecutarAccionAtaque(pokemonJugador, pokemonRival, movJ);

            // Si el rival sobrevive, contraataca
            if (pokemonRival.getVidaPokemon() > 0) {
                ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);
            }
        } else {
            // Turno del Rival
            ejecutarAccionAtaque(pokemonRival, pokemonJugador, movE);

            // Si el jugador sobrevive, contraataca
            if (pokemonJugador.getVidaPokemon() > 0) {
                ejecutarAccionAtaque(pokemonJugador, pokemonRival, movJ);
            }
        }

        // Fin de turno
        procesarFinDeTurno(pokemonJugador, pokemonRival);
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
                            ejecutarAccionAtaque(pokemonRival, pokemonJugador, pokemonRival.getMovimientos()[movEnemigo]);
                            procesarFinDeTurno(pokemonJugador, pokemonRival);
                        }
                    } else {
                        impresorMenus.mensajeNoPuedeCapturarEntrenador();
                    }

                } else {
                    jugador.acionJugador(2, jugadorPokemonIndice, itemSeleccionado, pokemonJugador);
                    int movEnemigo = aiEnemigo.selecionadorDeAtaque(pokemonRival.getMovimientos());
                    ejecutarAccionAtaque(pokemonRival, pokemonJugador, pokemonRival.getMovimientos()[movEnemigo]);
                    procesarFinDeTurno(pokemonJugador, pokemonRival);
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
                        ejecutarAccionAtaque(pokemonRival, pokemonJugador, pokemonRival.getMovimientos()[movEnemigo]);
                        procesarFinDeTurno(pokemonJugador, pokemonRival);
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
