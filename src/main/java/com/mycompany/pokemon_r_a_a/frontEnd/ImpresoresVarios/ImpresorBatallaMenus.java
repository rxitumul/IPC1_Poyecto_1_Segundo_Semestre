package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class ImpresorBatallaMenus extends ImpresoresGlobal {

    public void impresorDePrincipal(String nombreJugador, String nombreEnemigo, Pokemons pokemonEnemigo,
            Pokemons pokemonJugador) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("BATALLA POKÉMON"));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado(""));
        System.out.println(formatearMapaCentrado(
                "ENTRENADOR: " + nombreJugador + "                      RIVAL: " + nombreEnemigo));
        System.out.println(formatearMapaCentrado(""));
        System.out.println(
                formatearMapaCentrado("Especie: " + pokemonJugador.getNombre()
                        + "                      Especie: "
                        + pokemonEnemigo.getNombre()));
        System.out.println(formatearMapaCentrado(
                "Apodo: " + pokemonJugador.getNombre() + "                      Apodo: "
                        + pokemonEnemigo.getNombre()));
        System.out.println(formatearMapaCentrado(
                "NIVEL  " + pokemonJugador.getNivel() + "                       NIVEL  "
                        + pokemonEnemigo.getNivel()));
        System.out.println(
                formatearMapaCentrado("HP: " + pokemonJugador.getVidaInicial() + "/"
                        + pokemonJugador.getVidaPokemon()
                        + "                      HP: " + pokemonEnemigo.getVidaInicial() + "/"
                        + pokemonEnemigo.getVidaPokemon()));
        System.out.println(formatearMapaCentrado(""));
        separadorMediosMapa();

    }

    public void impresorDeBatallaOpcionesPokemonSalvaje() {
        System.out.println(formatearMapaCentrado("¿QUÉ HARÁS?"));
        System.out.println(formatearMapaCentrado("[1] LUCHAR          [2] MOCHILA"));
        System.out.println(formatearMapaCentrado("[3] POKÉMON         [4] HUIR"));
        separadorFinalMapa();
    }

    public void impresorDeBatallaOpciones() {
        System.out.println(formatearMapaCentrado("¿QUÉ HARÁS?"));
        System.out.println(formatearMapaCentrado("[1] LUCHAR     [2] MOCHILA     [3] POKÉMON"));
        separadorFinalMapa();
    }

    public void seleciondeMovimientos(Pokemons pokemon) {
        Movimiento[] movimientos = pokemon.getMovimientos();
        int tamaño = movimientos.length;
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("MOVIMIENTOS"));
        separadorMediosMapa();
        if (tamaño == 3) {
            System.out.println(formatearMapaCentrado(
                    "1) " + movimientos[0].getNombre() + "          2)"
                            + movimientos[1].getNombre()));
            System.out.println(formatearMapaCentrado("3) " + movimientos[2].getNombre()));

        } else if (tamaño == 2) {
            System.out.println(formatearMapaCentrado(
                    "1) " + movimientos[0].getNombre() + "          2)"
                            + movimientos[1].getNombre()));

        } else if (tamaño == 1) {
            System.out.println(formatearMapaCentrado("1) " + movimientos[0].getNombre()));
        } else {
            System.out.println(formatearMapaCentrado(
                    "1) " + movimientos[0].getNombre() + "          2)"
                            + movimientos[1].getNombre()));
            System.out.println(formatearMapaCentrado(
                    "3) " + movimientos[2].getNombre() + "          4)"
                            + movimientos[3].getNombre()));
        }
        separadorMediosMapa();
        System.out.println(formatearCentrado("0) Volver"));
        separadorFinalMapa();
    }

    public void selecionMochila(Mochila mochila) {

        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("MOCHILA"));
        separadorMediosMapa();

        System.out.println(formatearMapaCentrado(
                "1) Paralisis x" + mochila.getAntiParalisis() + "          2) Antidoto x"
                        + mochila.getAntidoto()));
        System.out.println(formatearMapaCentrado(
                "3) Pocion x" + mochila.getPocion() + "          4) Pokebola x"
                        + mochila.getPokebola()));
        System.out.println(formatearMapaCentrado("5) RestauraTodo x" + mochila.getRestauraTodo()
                + "          6) SuperPocion x" + mochila.getSuperPocion()));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado("0) Volver"));
        separadorFinalMapa();
    }

    public void cambioPokemon(Pokemons[] pokemos) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("CAMBIAR POKÉMON"));
        separadorMediosMapa();
        int contador = 0;
        for (Pokemons pokemons : pokemos) {
            if (pokemons != null) {
                if (pokemons.getVidaInicial() == pokemons.getVidaPokemon()) {
                    System.out.println(formatearMapa(contador + ") " + pokemons.getApodo()
                            + " Lvl "
                            + pokemons.getNivel() + " HP " + BARRAS_DE_VIDA_100
                            + pokemons.getVidaInicial() + "/"
                            + pokemons.getVidaPokemon()));

                } else if (pokemons.getVidaInicial() < (pokemons.getVidaPokemon() / 2)) {
                    System.out.println(formatearMapa(
                            contador + ") " + pokemons.getApodo() + " Lvl "
                                    + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_75 + pokemons.getVidaInicial()
                                    + "/" + pokemons.getVidaPokemon()));

                } else if (pokemons.getVidaInicial() < (pokemons.getVidaPokemon() / 2) / 2) {
                    System.out.println(formatearMapa(
                            contador + ") " + pokemons.getApodo() + " Lvl "
                                    + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_50 + pokemons.getVidaInicial()
                                    + "/" + pokemons.getVidaPokemon()));

                } else {
                    System.out.println(formatearMapa(
                            contador + ") " + pokemons.getApodo() + " Lvl "
                                    + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_25 + pokemons.getVidaInicial()
                                    + "/" + pokemons.getVidaPokemon()));
                }
            } else {
                System.out.println(formatearMapa(contador + ") Sin pokemon "));
            }
            contador++;
            System.out.println(formatearMapa(""));
        }
        separadorMediosMapa();
        System.out.println(formatearCentrado("0) Volver"));
        separadorFinalMapa();
    }

    public void mensajePokemonDebilitado(String nombrePokemon) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡" + nombrePokemon + " se ha debilitado!"));
        separadorFinalMapa();
    }

    public void pantallaDerrota() {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡TODOS TUS POKÉMON SE HAN DEBILITADO!"));
        System.out.println(formatearMapaCentrado("HAS PERDIDO EL COMBATE..."));
        separadorFinalMapa();
    }

    public void pantallaVictoriaSalvaje(String nombrePokemonSalvaje, String nombrePokemonJugador, int xp) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡EL POKÉMON SALVAJE " + nombrePokemonSalvaje.toUpperCase() + " FUE DERROTADO!"));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado(nombrePokemonJugador + " ganó " + xp + " puntos de EXP."));
        separadorFinalMapa();
    }

    public void pantallaVictoriaEntrenador(String nombreEntrenador, int dinero) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡HAS VENCIDO AL ENTRENADOR " + nombreEntrenador.toUpperCase() + "!"));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado("¡Has recibido $" + dinero + " PokéMonedas por la victoria!"));
        separadorFinalMapa();
    }

    public void pantallaCapturaExitosa(String nombrePokemon) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡HAS ATRAPADO A " + nombrePokemon.toUpperCase() + "!"));
        System.out.println(formatearMapaCentrado("Se ha registrado y añadido a tu equipo."));
        separadorFinalMapa();
    }

    public void pantallaCapturaFallida() {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡El Pokémon salvaje se ha liberado de la Pokébola!"));
        separadorFinalMapa();
    }

    public void mensajeEntrenadorCambiaPokemon(String nombreEntrenador, String nombrePokemon) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡" + nombreEntrenador + " envía a " + nombrePokemon + "!"));
        separadorFinalMapa();
    }

    public void mensajePokemonEntra(String nombrePokemon) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡Adelante, " + nombrePokemon + "!"));
        separadorFinalMapa();
    }

    public void mensajeHuidaExitosa() {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡Has escapado con éxito del combate!"));
        separadorFinalMapa();
    }

    public void mensajeNoPuedeHuir() {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡No puedes huir de un combate contra un entrenador!"));
        separadorFinalMapa();
    }

    public void mensajeNoPuedeCapturarEntrenador() {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡No puedes atrapar el Pokémon de otro entrenador!"));
        separadorFinalMapa();
    }

    public void mensajePokemonSinEnergia() {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("Ese Pokémon no tiene energía para combatir."));
        separadorFinalMapa();
    }

    public void mensajeSinPokemonsVivos() {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("No tienes Pokémon con vida para luchar."));
        separadorFinalMapa();
    }

    public void mensajeAtaqueRealizado(String atacante, String movimiento, int daño, String defensor, int hpRestante, int hpTotal) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡" + atacante + " usó " + movimiento + "!"));
        System.out.println(formatearMapaCentrado("Causó " + daño + " de daño a " + defensor + " (HP: " + hpRestante + "/" + hpTotal + ")"));
        separadorFinalMapa();
    }

    public void mensajeProtegido(String nombrePokemon) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("¡" + nombrePokemon + " se protegió del ataque!"));
        separadorFinalMapa();
    }
}
