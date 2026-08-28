package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mapas;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;
import com.mycompany.pokemon_r_a_a.frontEnd.impresores.ImpresorDeMapas;
import com.mycompany.pokemon_r_a_a.frontEnd.impresores.ImpresorDeSelecion;

public class Game {

    private Scanner scanner;
    private MovimientoJugador movimiento = new MovimientoJugador();
    private Pokedex pokedexLocal;
    private Pokemons[] equiposLocal;
    private JugadorPokemonPartida jugadorLocal;
    private Mochila mochilaLocal;
    private ImpresorDeMapas impresor = new ImpresorDeMapas();
    private ImpresorDeSelecion impresorSelecion = new ImpresorDeSelecion();

    private int[] jugadorPosicion;
    private MapaCiudad[] mapaCiudadesLocal;

    public Game(Scanner scanner, MapaCiudad[] mapaCiudades, Pokedex pokedex, Pokemons[] equipos,
            JugadorPokemonPartida jugador, Mochila mochila) {
        this.scanner = scanner;
        pokedexLocal = pokedex;
        equiposLocal = equipos;
        jugadorLocal = jugador;
        mochilaLocal = mochila;
        mapaCiudadesLocal = mapaCiudades;

    }

    public void gameInicio(int ciudadInicio) {
        MapaCiudad mapa = mapaCiudadesLocal[ciudadInicio];
        Casillas[][] mapaLocal = mapa.getMapa();
        String nombreCiudad = mapa.getNombre();
        jugadorPosicion = mapa.getJugador();
        Mapas mapas = new Mapas(scanner, mapaCiudadesLocal);
        String movi;
        do {
            impresor.imprimirMapaObjetos(mapaLocal, nombreCiudad);
            movi = scanner.nextLine();
            if (movi.equalsIgnoreCase("W") || movi.equalsIgnoreCase("S") || movi.equalsIgnoreCase("A")
                    || movi.equalsIgnoreCase("D")) {
                mapaLocal = movimiento.movimiento(jugadorPosicion, mapaLocal, movi);
                jugadorPosicion = movimiento.getSpawn();

            } else if (movi.equalsIgnoreCase("M")) {
                impresorSelecion.impresorMochila(mochilaLocal);
            } else if (movi.equalsIgnoreCase("N")) {

                mapa.setJugador(jugadorPosicion);
                mapa = mapaCiudadesLocal[mapas.selecionDeMapa()];
                mapaLocal = mapa.getMapa();
                jugadorPosicion = mapa.getJugador();

            } else if (movi.equalsIgnoreCase("P")) {
                System.out.println("Pokemons");
            } else if (movi.equalsIgnoreCase("T")) {
                System.out.println("Pokedex");
            } else if (movi.equalsIgnoreCase("X")) {
                System.out.println("Salir Y guardar");
                break;
            } else if (movi.equalsIgnoreCase("F")) {
                impresorSelecion.impresorDeEstadoJugador(jugadorLocal, mapaCiudadesLocal);
                scanner.nextLine();
            } else {
                System.out.println("hola");
            }
        } while (true);
    }

}
