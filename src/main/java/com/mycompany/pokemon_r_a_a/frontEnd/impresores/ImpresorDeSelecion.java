package com.mycompany.pokemon_r_a_a.frontEnd.impresores;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

public class ImpresorDeSelecion {
    private ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();
    protected final static String VERDE = "\u001B[32m";
    protected final static String ROJO = "\u001B[31m";
    protected final static String RESET = "\u001B[0m";

    public <T> void impresorDelistas(String nombreDeLista, T[] listaAImprimir) {
        System.out.println(nombreDeLista);
        for (int i = 0; i < listaAImprimir.length; i++) {
            confi.separadorInicioMapa();
            if (listaAImprimir[i] instanceof MapaCiudad mapa) {
                System.out.println(confi.formatearMapa(i + 1 + ") " + mapa.getNombre()));
            }
            confi.separadorFinalMapa();
        }
    }

    public void impresorDeEstadoJugador(JugadorPokemonPartida jugador, MapaCiudad[] mapas) {
        confi.separadorInicioMapa();
        System.out.println(confi.formatearMapa("Nombre del jugador: " + jugador.getNombre()));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("Cantidad de pokemonedas ( ₽ ): " + jugador.getPokemonedas()));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("Medallas obtenidas"));
        int[] medallas = jugador.getMedallasObtenidas();
        for (int i = 0; i < mapas.length; i++) {
            if (medallas[i] == 0) {
                System.out.println(ROJO);
                System.out.println(confi.formatearMapa(
                        mapas[i].getNombre() + " Sin derrotar " + medallas[i] + " medallas"));
                System.out.println(RESET);
            } else {
                System.out.println(VERDE);
                System.out.println(confi.formatearMapa(
                        mapas[i].getNombre() + " Derrotado " + medallas[i] + " medallas"));
                System.out.println(RESET);

            }
        }
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("Precione enter para salir del perfil"));
        confi.separadorFinalMapa();

    }

    public void impresorMochila(Mochila mochila) {
        confi.separadorInicioMapa();
        System.out.println(confi.formatearMapa("Mochila"));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("1) Pokebola" + mochila.getPokebola()));
        System.out.println(confi.formatearMapa("2) Pocion" + mochila.getPocion()));
        System.out.println(confi.formatearMapa("3) Superpocion" + mochila.getSuperPocion()));
        System.out.println(confi.formatearMapa("4) Antidoto" + mochila.getAntidoto()));
        System.out.println(confi.formatearMapa("5) Antiparaliz" + mochila.getAntiParalisis()));
        System.out.println(confi.formatearMapa("6) Restaura todo" + mochila.getRestauraTodo()));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("Selecione uno a utilizar"));
        confi.separadorFinalMapa();
    }

    private void impresorDePokedex() {

    }

    public void impresorDeNombre(String nombre) {
        confi.separadorInicioMapa();
        System.out.println(confi.formatearMapa("Cambio a la ciudad " + nombre));
        confi.separadorFinalMapa();
    }
}
