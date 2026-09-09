package com.mycompany.pokemon_r_a_a.backEnd.Batallas;

import java.util.Random;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.Batallas.enemigos.AiEnemigo;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.DrenadoraDebuf;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Estados;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorBatallaMenus;

public abstract class RealizacionDeAtaqueMovimiento {

    protected static final int DINERO_GANADO_RANGO_A = 150;
    protected static final int DINERO_GANADO_RANGO_B = 500;

    protected ImpresorBatallaMenus impresorMenus = new ImpresorBatallaMenus();
    protected AiEnemigo aiEnemigo = new AiEnemigo();
    protected int jugadorPokemonIndice;
    protected int enemigoPokemonIndice;
    protected Scanner scaner;
    protected Random rand = new Random();

    protected Pokemons pokemonJugador;
    protected Pokemons pokemonRival;
    protected HallDeLaFama hallDeLaFama;

    public boolean ejecutarAccionAtaque(Pokemons atacante, Pokemons objetivo, Movimiento mov) {
        if (atacante == null || objetivo == null || mov == null) {
            return false;
        }
        if (atacante.getVidaPokemon() <= 0) {
            return false;
        }

        // 1. Cansado
        Estados cansado = atacante.obtenerEstado("Cansado");
        if (cansado != null) {
            System.out.println(
                    impresorMenus.formatearMapa("¡" + atacante.getNombre() + " está exhausto y descansa este turno!"));
            atacante.eliminarEstado("Cansado");
            return false;
        }

        // 2. Dormido
        Estados dormido = atacante.obtenerEstado("Dormido");
        if (dormido != null) {
            dormido.decrementarContador();
            System.out.println(impresorMenus
                    .formatearMapa("¡" + atacante.getNombre() + " está profundamente dormido y no puede moverse!"));
            if (dormido.esExpirado()) {
                System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " se ha despertado!"));
                atacante.eliminarEstado("Dormido");
            }
            return false;
        }

        // 3. Paralizado
        Estados paralizado = atacante.obtenerEstado("Paralizado");
        if (paralizado != null) {
            paralizado.decrementarContador();
            System.out.println(
                    impresorMenus.formatearMapa("¡" + atacante.getNombre() + " está paralizado y no puede moverse!"));
            if (paralizado.esExpirado()) {
                System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " ya no está paralizado!"));
                atacante.eliminarEstado("Paralizado");
            }
            return false;
        }

        // 4. Confuso
        Estados confuso = atacante.obtenerEstado("Confuso");
        if (confuso != null) {
            confuso.decrementarContador();
            System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " está confuso!"));
            boolean seDanioASiMismo = (rand.nextDouble() <= 0.30);
            if (seDanioASiMismo) {
                System.out
                        .println(impresorMenus.formatearMapa("¡Tan confuso está que su ataque se dirigió a sí mismo!"));
                mov.setPokemonUsuario(atacante);
                mov.setpokemonAtacado(atacante);
                mov.ataque();
                if (confuso.esExpirado()) {
                    System.out
                            .println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " ya no está confuso!"));
                    atacante.eliminarEstado("Confuso");
                }
                return false;
            }
            if (confuso.esExpirado()) {
                System.out.println(impresorMenus.formatearMapa("¡" + atacante.getNombre() + " ya no está confuso!"));
                atacante.eliminarEstado("Confuso");
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
        if (p.tieneEstado("Envenenado")) {
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

        // Drenadoras: absorbe 7% de la salud total del oponente y las usa para curar al
        // lanzador
        Estados dren = p.obtenerEstado("DrenadoraDebuf");
        if (dren instanceof DrenadoraDebuf) {
            DrenadoraDebuf debuf = (DrenadoraDebuf) dren;
            if (debuf.getLanzador() != null && debuf.getLanzador().getVidaPokemon() > 0 && p.getVidaPokemon() > 0) {
                int drenado = debuf.ejecutarDrenado();
                System.out.println(impresorMenus.formatearMapa("¡Las drenadoras absorben " + drenado + " HP de "
                        + p.getNombre() + " para curar a " + debuf.getLanzador().getNombre() + "!"));
            } else {
                p.eliminarEstado("DrenadoraDebuf");
            }
        }
    }

    /**
     * Compara las prioridades y velocidades de los dos Pokémon según las reglas:
     * 1. "Ataque rápido" siempre tiene prioridad.
     * 2. Si ambos usan "Ataque rápido" (o ninguno), depende de las velocidades.
     * 3. Si las velocidades son iguales, se decide de forma aleatoria (50/50).
     * Retorna true si el Pokémon del jugador actúa primero, false si el rival actúa
     * primero.
     */
    protected boolean determinaPrioridad(Movimiento movJugador, Movimiento movRival, Pokemons pJugador,
            Pokemons pRival) {
        boolean jugadorPrioridad = (movJugador != null && (movJugador.getNombre().equalsIgnoreCase("AtaqueRápido")
                || movJugador.getNombre().equalsIgnoreCase("AtaqueRapido"))) || pJugador.getPrioritario();
        boolean rivalPrioridad = (movRival != null && (movRival.getNombre().equalsIgnoreCase("AtaqueRápido")
                || movRival.getNombre().equalsIgnoreCase("AtaqueRapido"))) || pRival.getPrioritario();

        pJugador.setPrioritario(false);
        pRival.setPrioritario(false);

        if (jugadorPrioridad && !rivalPrioridad) {
            return true;
        }
        if (!jugadorPrioridad && rivalPrioridad) {
            return false;
        }

        if (pJugador.getVelocidadPokemon() > pRival.getVelocidadPokemon()) {
            return true;
        } else if (pJugador.getVelocidadPokemon() < pRival.getVelocidadPokemon()) {
            return false;
        } else {
            return rand.nextBoolean();
        }
    }

    protected boolean manejarMuerteRival(JugadorPokemonPartida jugador, Entrenador enemigo, Pokemons[] pokemonsEnemigo,
            boolean esSalvaje) {
        int nivelRival = pokemonRival.getNivel();
        int xpPokemon = (nivelRival * nivelRival) / 2;
        if (xpPokemon < 1) {
            xpPokemon = 1;
        }
        pokemonJugador.setXp(pokemonJugador.getXp() + xpPokemon);
        pokemonJugador.incrementarEnemigosDebilitados();
        impresorMenus.mensajePokemonDebilitado(pokemonRival.getNombre());

        if (esSalvaje) {
            impresorMenus.pantallaVictoriaSalvaje(pokemonRival.getNombre(), pokemonJugador.getNombre(), xpPokemon);
            return true;
        } else {
            enemigoPokemonIndice = aiEnemigo.seleccionarPokemonCambio(pokemonsEnemigo);
            if (enemigoPokemonIndice == -1) {
                victoria(jugador, enemigo);
                return true;
            } else {
                pokemonRival = pokemonsEnemigo[enemigoPokemonIndice];
                impresorMenus.mensajeEntrenadorCambiaPokemon(enemigo.getNombre(), pokemonRival.getNombre());
                return false;
            }
        }
    }

    protected abstract void victoria(JugadorPokemonPartida jugador, Entrenador entrenador);

    protected abstract boolean ejecutarTurnoCombate(JugadorPokemonPartida jugador, int movJugadorIndex,
            Pokemons[] pokemonsJugador,
            Entrenador enemigo, Pokemons[] pokemonsEnemigo, boolean esSalvaje, String nombreEnemigo);
}