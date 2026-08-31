package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class ImpresorDeSelecion extends ImpresoresGlobal {



    public void impresorDeEstadoJugador(JugadorPokemonPartida jugador, MapaCiudad[] mapas) {
        separadorInicioMapa();
        System.out.println(formatearMapa("Nombre del jugador: " + jugador.getNombre()));
        separadorMediosMapa();
        System.out.println(formatearMapa("Cantidad de pokemonedas ( ₽ ): " + jugador.getPokemonedas()));
        separadorMediosMapa();
        System.out.println(formatearMapa("Medallas obtenidas"));
        int[] medallas = jugador.getMedallasObtenidas();
        for (int i = 0; i < mapas.length; i++) {
            if (medallas[i] == 0) {
                System.out.println(formatearMapaCentrado(ROJO +
                        mapas[i].getNombre() + " Sin derrotar " + medallas[i] + " medallas" + RESET));
            } else {
                System.out.println(formatearMapaCentrado(VERDE +
                        mapas[i].getNombre() + " Derrotado " + medallas[i] + " medallas" + RESET));
            }
        }
        separadorMediosMapa();
        System.out.println(formatearMapa("Precione enter para salir del perfil"));
        separadorFinalMapa();

    }

    public void impresorMochila(Mochila mochila) {
        separadorInicioMapa();
        System.out.println(formatearMapa("Mochila"));
        separadorMediosMapa();
        System.out.println(formatearMapa("1) Pokebola" + mochila.getPokebola()));
        System.out.println(formatearMapa("2) Pocion" + mochila.getPocion()));
        System.out.println(formatearMapa("3) Superpocion" + mochila.getSuperPocion()));
        System.out.println(formatearMapa("4) Antidoto" + mochila.getAntidoto()));
        System.out.println(formatearMapa("5) Antiparaliz" + mochila.getAntiParalisis()));
        System.out.println(formatearMapa("6) Restaura todo" + mochila.getRestauraTodo()));
        separadorMediosMapa();
        System.out.println(formatearMapa("Selecione uno a utilizar o escriba cualquier otra letra"));
        separadorFinalMapa();
    }

    public void impresorDePokedex(Pokemons[] pokemon) {

        inicioDeTabla();
        System.out.println(formatoTabla("Nombre", "ID"));
        mediosDeTabla();
        for (int i = 0; i < pokemon.length; i++) {
            System.out.println(formatoTabla(pokemon[i].getNombre(), String.valueOf(i + 1)));
        }
        finDeTabla();
        separadorInicioMapa();
        System.out.println(formatearMapa("Porfavor Ingrese el numero del pokemon para ver informacion,"));
        System.out.println(formatearMapa("Ingrese cualquier letra para salir "));
        separadorFinalMapa();
    }


    public void impresorDeNombre(String nombre) {
        separadorInicioMapa();
        System.out.println(formatearMapa("Cambio a la ciudad " + nombre));
        separadorFinalMapa();
    }
}
