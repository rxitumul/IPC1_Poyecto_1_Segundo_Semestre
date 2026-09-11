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

    protected final static int DINERO_GANADO_RANGO_A = 150;
    protected final static int DINERO_GANADO_RANGO_B = 500;

    protected ImpresorBatallaMenus impresorMenus;
    protected AiEnemigo aiEnemigo;
    protected int jugadorPokemonIndice;
    protected int enemigoPokemonIndice;
    protected Scanner scaner;
    protected Random rand;

    protected Pokemons pokemonJugador;
    protected Pokemons pokemonRival;
    protected HallDeLaFama hallDeLaFama;

    public RealizacionDeAtaqueMovimiento() {
        impresorMenus = new ImpresorBatallaMenus();
        aiEnemigo = new AiEnemigo();
        rand = new Random();
    }

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
            impresorMenus.mensajePokemonenemigo("¡" + atacante.getNombre() + " está exhausto y descansa este turno!");
            atacante.eliminarEstado("Cansado");
            return false;
        }

        // 2. Dormido
        Estados dormido = atacante.obtenerEstado("Dormido");
        if (dormido != null) {
            dormido.decrementarContador();
            impresorMenus.mensajePokemonenemigo(
                    "¡" + atacante.getNombre() + " está profundamente dormido y no puede moverse!");
            if (dormido.esExpirado()) {
                impresorMenus.mensajePokemonenemigo("¡" + atacante.getNombre() + " se ha despertado!");
                atacante.eliminarEstado("Dormido");
            }
            return false;
        }

        // 3. Paralizado
        Estados paralizado = atacante.obtenerEstado("Paralizado");
        if (paralizado != null) {
            paralizado.decrementarContador();
            impresorMenus.mensajePokemonenemigo("¡" + atacante.getNombre() + " está paralizado y no puede moverse!");
            if (paralizado.esExpirado()) {
                impresorMenus.mensajePokemonenemigo("¡" + atacante.getNombre() + " ya no está paralizado!");
                atacante.eliminarEstado("Paralizado");
            }
            return false;
        }

        // 4. Confuso
        Estados confuso = atacante.obtenerEstado("Confuso");
        if (confuso != null) {
            confuso.decrementarContador();
            impresorMenus.mensajePokemonenemigo("¡" + atacante.getNombre() + " está confuso!");
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
                impresorMenus.mensajePokemonenemigo("¡" + atacante.getNombre() + " ya no está confuso!");
                atacante.eliminarEstado("Confuso");
            }
        }

        // 5. Ataque exitoso hacia el objetivo
        mov.setPokemonUsuario(atacante);
        mov.setpokemonAtacado(objetivo);
        mov.ataque();
        return true;
    }

    public void procesarFinDeTurno(Pokemons pokemon1, Pokemons pokemon2) {
        aplicarEfectosFinDeTurno(pokemon1);
        aplicarEfectosFinDeTurno(pokemon2);
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
            impresorMenus.mensajePokemonenemigo("¡" + p.getNombre() + " sufre " + danoVeneno
                    + " de daño por el veneno! (HP restante: " + nuevaVida + "/" + vidaTotal + ")");
        }

        // Drenadoras: absorbe 7% de la salud total del oponente y las usa para curar al
        // lanzador
        Estados dren = p.obtenerEstado("DrenadoraDebuf");
        if (dren instanceof DrenadoraDebuf) {
            DrenadoraDebuf debuf = (DrenadoraDebuf) dren;
            if (debuf.getLanzador() != null && debuf.getLanzador().getVidaPokemon() > 0 && p.getVidaPokemon() > 0) {
                int drenado = debuf.ejecutarDrenado();
                impresorMenus.mensajePokemonenemigo("¡Las drenadoras absorben " + drenado + " HP de "
                        + p.getNombre() + " para curar a " + debuf.getLanzador().getNombre() + "!");
            } else {
                p.eliminarEstado("DrenadoraDebuf");
            }
        }
    }

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