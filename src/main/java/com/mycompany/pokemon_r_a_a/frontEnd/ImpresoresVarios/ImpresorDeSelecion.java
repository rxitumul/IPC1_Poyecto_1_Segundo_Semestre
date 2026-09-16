package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorNpc;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.Gimnasio;
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
        System.out.println(formatearMapa("Medallas de Gimnasio"));
        int[] medallas = jugador.getMedallasObtenidas();
        String[] nombresMedallas = jugador.getNombresMedallas();
        CreadorNpc creadorNpc = new CreadorNpc();

        for (int i = 0; i < mapas.length; i++) {
            String nombreCiudad = (mapas[i] != null) ? mapas[i].getNombre() : ("Ciudad #" + (i + 1));
            String medallaInfo = (nombresMedallas != null && i < nombresMedallas.length && nombresMedallas[i] != null && !nombresMedallas[i].trim().isEmpty())
                    ? nombresMedallas[i]
                    : null;

            if (medallaInfo == null && mapas[i] != null && mapas[i].getMapa() != null) {
                for (Casillas[] fila : mapas[i].getMapa()) {
                    if (fila != null) {
                        for (Casillas c : fila) {
                            if (c instanceof Gimnasio) {
                                String med = ((Gimnasio) c).getMedallaNombre();
                                if (med != null && !med.trim().isEmpty()) {
                                    medallaInfo = med;
                                    break;
                                }
                            }
                        }
                    }
                    if (medallaInfo != null) break;
                }
            }

            if (medallaInfo == null) {
                medallaInfo = creadorNpc.obtenerNombreMedallaCompleto(i);
            }

            if (medallas != null && i < medallas.length && medallas[i] > 0) {
                System.out.println(formatearMapaCentrado(VERDE +
                        nombreCiudad + " | Medalla: " + medallaInfo + " [Obtenida]" + RESET));
            } else {
                System.out.println(formatearMapaCentrado(ROJO +
                        nombreCiudad + " | Medalla: " + medallaInfo + " [Sin derrotar]" + RESET));
            }
        }
        separadorMediosMapa();
        System.out.println(formatearMapa("Precione enter para salir del perfil"));
        separadorFinalMapa();

    }

    public void impresorMochila(Mochila mochila) {
        limpiadorPantalla();
        separadorInicioMapa();
        System.out.println(formatearMapa("Mochila"));
        separadorMediosMapa();
        System.out.println(formatearMapa("1) Pokebola = " + mochila.getPokebola()));
        System.out.println(formatearMapa("2) Pocion = " + mochila.getPocion()));
        System.out.println(formatearMapa("3) Superpocion = " + mochila.getSuperPocion()));
        System.out.println(formatearMapa("4) Antidoto = " + mochila.getAntidoto()));
        System.out.println(formatearMapa("5) Antiparaliz = " + mochila.getAntiParalisis()));
        System.out.println(formatearMapa("6) Restaura todo = " + mochila.getRestauraTodo()));
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
        System.out.println(formatearMapa("Ingrese el número o nombre del Pokémon para ver información,"));
        System.out.println(formatearMapa("o ingrese 'X' / presione enter para salir "));
        separadorFinalMapa();
    }

    public void impresorDeNombre(String nombre) {
        separadorInicioMapa();
        System.out.println(formatearMapa("Cambio a la ciudad " + nombre));
        separadorFinalMapa();
    }
}
