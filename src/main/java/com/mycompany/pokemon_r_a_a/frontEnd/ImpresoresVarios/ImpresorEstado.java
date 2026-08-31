package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class ImpresorEstado extends ImpresoresGlobal {

    public void impresorEquipo(Pokemons[] pokemos) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("Equipo pokemon"));
        separadorMediosMapa();
        System.out.println(formatearMapa(""));
        System.out.println(formatearMapa("Tu equipo"));
        int contador = 1;
        for (Pokemons pokemons : pokemos) {
            if (pokemons != null) {
                if (pokemons.getVidaInicial() == pokemons.getVidaPokemon()) {
                    System.out.println(formatearMapa(contador + ") " + pokemons.getApodo()
                            + "   Lvl"
                            + pokemons.getNivel() + " HP " + BARRAS_DE_VIDA_100 + "  "
                            + pokemons.getVidaInicial() + "/"
                            + pokemons.getVidaPokemon()));

                } else if (pokemons.getVidaInicial() < (pokemons.getVidaPokemon() / 2)) {
                    System.out.println(formatearMapa(
                            contador + ") " + pokemons.getApodo() + "Lvl"
                                    + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_75 + "  " + pokemons.getVidaInicial()
                                    + "/" + pokemons.getVidaPokemon()));

                } else if (pokemons.getVidaInicial() < (pokemons.getVidaPokemon() / 2) / 2) {
                    System.out.println(formatearMapa(
                            contador + ") " + pokemons.getApodo() + "Lvl"
                                    + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_50 + "  " + pokemons.getVidaInicial()
                                    + "/" + pokemons.getVidaPokemon()));

                } else {
                    System.out.println(formatearMapa(
                            contador + ") " + pokemons.getApodo() + "Lvl"
                                    + pokemons.getNivel() + " HP "
                                    + BARRAS_DE_VIDA_25 + "  " + pokemons.getVidaInicial()
                                    + "/" + pokemons.getVidaPokemon()));
                }
            } else {
                System.out.println(formatearMapa(contador + ") Sin pokemon "));
            }
            contador++;
            System.out.println(formatearMapa(""));
        }
        System.out.println(formatearMapa(""));
        separadorMediosMapa();
        System.out.println(formatearMapa(""));
        System.out.println(formatearMapa("[1] Cambiar orden          [2] Liberar Pokémon      [3] Ver información"));
        System.out.println(formatearMapa(""));
        System.out.println(formatearMapa("[0] Salir"));
        System.out.println(formatearMapa(""));
        separadorFinalMapa();
    }

    public void cambioDeOrden(Pokemons[] pokemons, boolean opcion) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("Cambiar orden"));
        separadorMediosMapa();
        System.out.println(formatearMapa(""));
        if (opcion) {
            System.out.println(formatearMapa("Selecione al pokemon que seas mover"));
        } else {
            System.out.println(formatearMapa("Selecione la pocicion a donde se movera"));
        }
        System.out.println(formatearMapa(""));
        int contador = 1;
        for (Pokemons pokemons2 : pokemons) {
            if (pokemons2 != null) {
                System.out.println(formatearMapa(contador + ") " + pokemons2.getApodo()));
            } else {
                System.out.println(formatearMapaCentrado(contador + ") Sin pokemon "));
            }
            contador++;
        }
        System.out.println(formatearMapa("[0] Volver"));
        separadorFinalMapa();
    }

    public void impresorDeLiberacion(Pokemons[] pokemons) {
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("Liberar pokemon"));
        separadorMediosMapa();
        System.out.println(formatearMapa(""));
        System.out.println(formatearMapa("Selecione el pokemon a liberar"));
        System.out.println(formatearMapa(""));
        int contador = 1;
        for (Pokemons pokemons2 : pokemons) {
            if (pokemons2 != null) {
                System.out.println(formatearMapa(contador + ") " + pokemons2.getApodo()));
            } else {
                System.out.println(formatearMapa(contador + ") Sin pokemon"));
            }
            contador++;
        }
        System.out.println(formatearMapa(""));
        System.out.println(formatearMapaCentrado(ROJO + "⚠ ADVERTENCIA: Esta acción no puede revertirse." + RESET));
        System.out.println(formatearMapa(""));
        System.out.println(formatearMapa("[0] Volver"));
        separadorFinalMapa();
    }

    public void confirmacionLiberacion() {
        System.out.print(NARANJA);
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("Confirmacion liberacion"));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado("¿Estás seguro de que deseas liberar a Bulbasaur?"));
        System.out.println(formatearMapaCentrado(""));
        System.out.println(formatearMapaCentrado("⚠ Esta acción es permanente."));
        System.out.println(formatearMapaCentrado("⚠ No podrás recuperar a este Pokémon."));
        System.out.println(formatearMapaCentrado(""));
        System.out.println(formatearMapaCentrado("[1] SÍ [2] NO"));
        System.out.println(formatearMapaCentrado(""));
        separadorFinalMapa();
        System.out.print(RESET);
    }

    public void exito(String accion) {
        System.out.print(VERDE);
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("Accion " + accion + " realizada con exito"));
        separadorFinalMapa();
        System.out.print(RESET);
    }

    public void fallo(String accion) {
        System.out.print(NARANJA);
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("Accion fallida: " + accion));
        System.out.println(formatearMapaCentrado("Porfavor vuelva a intentar"));
        separadorFinalMapa();
        System.out.print(RESET);
    }

}
