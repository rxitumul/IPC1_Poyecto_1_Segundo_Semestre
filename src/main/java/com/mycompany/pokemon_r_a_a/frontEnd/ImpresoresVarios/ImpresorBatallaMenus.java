package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;


import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class ImpresorBatallaMenus extends ImpresoresGlobal {

    private final static String BARRAS_DE_VIDA_25 = "█████░░░░░░░░░░░░░░░";
    private final static String BARRAS_DE_VIDA_50 = "██████████░░░░░░░░░░";
    private final static String BARRAS_DE_VIDA_75 = "███████████████░░░░░";
    private final static String BARRAS_DE_VIDA_100 = "████████████████████";

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
                formatearMapaCentrado("Especie: " + pokemonJugador.getNombre() + "                      Especie: "
                        + pokemonEnemigo.getNombre()));
        System.out.println(formatearMapaCentrado(
                "Apodo: " + pokemonJugador.getNombre() + "                      Apodo: " + pokemonEnemigo.getNombre()));
        System.out.println(formatearMapaCentrado(
                "NIVEL  " + pokemonJugador.getNivel() + "                       NIVEL  " + pokemonEnemigo.getNivel()));
        System.out.println(
                formatearMapaCentrado("HP: " + pokemonJugador.getVidaInicial() + "/" + pokemonJugador.getVidaPokemon()
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
                    "1) " + movimientos[0].getNombre() + "          2)" + movimientos[1].getNombre()));
            System.out.println(formatearMapaCentrado("3) " + movimientos[1].getNombre()));

        } else if (tamaño == 2) {
            System.out.println(formatearMapaCentrado(
                    "1) " + movimientos[0].getNombre() + "          2)" + movimientos[1].getNombre()));

        } else {
            System.out.println(formatearMapaCentrado(
                    "1) " + movimientos[0].getNombre() + "          2)" + movimientos[1].getNombre()));
            System.out.println(formatearMapaCentrado(
                    "3) " + movimientos[2].getNombre() + "          4)" + movimientos[3].getNombre()));
        }
        separadorMediosMapa();
        System.out.println(formatearCentrado("0) Volver"));
        separadorFinalMapa();
    }

    public void selecionMochila(Mochila mochila) {

        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("MOVIMIENTOS"));
        separadorMediosMapa();

        System.out.println(formatearMapaCentrado(
                "1) Paralisis x" + mochila.getAntiParalisis() + "          2) Antidoto x" + mochila.getAntidoto()));
        System.out.println(formatearMapaCentrado(
                "3) Pocion x" + mochila.getPocion() + "          4) Pokebola x" + mochila.getPokebola()));
        System.out.println(formatearMapaCentrado("3) RestauraTodo x" + mochila.getRestauraTodo()
                + "          4) SuperPocion x" + mochila.getSuperPocion()));
        separadorMediosMapa();
        System.out.println(formatearCentrado("0) Volver"));
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
                    System.out.println(formatearMapaCentrado(contador + ") " + pokemons.getApodo() + "Lvl"
                            + pokemons.getNivel() + " HP " + BARRAS_DE_VIDA_100 + pokemons.getVidaInicial() + "/"
                            + pokemons.getVidaPokemon()));

                } else if (pokemons.getVidaInicial() < (pokemons.getVidaPokemon() / 2)) {
                    System.out.println(formatearMapaCentrado(
                            contador + ") " + pokemons.getApodo() + "Lvl" + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_75 + pokemons.getVidaInicial() + "/" + pokemons.getVidaPokemon()));

                } else if (pokemons.getVidaInicial() < (pokemons.getVidaPokemon() / 2) / 2) {
                    System.out.println(formatearMapaCentrado(
                            contador + ") " + pokemons.getApodo() + "Lvl" + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_50 + pokemons.getVidaInicial() + "/" + pokemons.getVidaPokemon()));

                } else {
                    System.out.println(formatearMapaCentrado(
                            contador + ") " + pokemons.getApodo() + "Lvl" + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_25 + pokemons.getVidaInicial() + "/" + pokemons.getVidaPokemon()));
                }
            } else {
                System.out.println(formatearMapaCentrado(contador + ") Sin pokemon "));
            }
            contador++;
        }

    }
}
