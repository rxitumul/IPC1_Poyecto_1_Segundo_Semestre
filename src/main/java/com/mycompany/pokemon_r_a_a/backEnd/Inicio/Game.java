package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.EstadoPokemonEquipo;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mapas;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeMapas;

public class Game {

    private Scanner scanner;
    private MovimientoJugador movimiento = new MovimientoJugador();
    private Pokedex pokedexLocal;
    private JugadorPokemonPartida jugadorLocal;
    private Mochila mochilaLocal;
    private ImpresorDeMapas impresor = new ImpresorDeMapas();
    private EstadoPokemonEquipo equipoEstado;

    private int[] jugadorPosicion;
    private MapaCiudad[] mapaCiudadesLocal;

    public Game(Scanner scanner, MapaCiudad[] mapaCiudades,
            JugadorPokemonPartida jugador) {
        this.scanner = scanner;
        pokedexLocal = jugador.getPokedexJugador();
        jugadorLocal = jugador;
        mochilaLocal = jugador.getMochilaJugador();
        mapaCiudadesLocal = mapaCiudades;
        equipoEstado = new EstadoPokemonEquipo(scanner, jugadorLocal);
        

    }

    public void gameInicio(int ciudadInicio) {
        MapaCiudad mapa = mapaCiudadesLocal[ciudadInicio];
        Casillas[][] mapaLocal = mapa.getMapa();
        String nombreCiudad = mapa.getNombre();
        jugadorPosicion = mapa.getJugador();
        Mapas mapas = new Mapas(scanner, mapaCiudadesLocal);
        String movi;
        jugadorLocal.setMapaCiudadesLocal(mapaCiudadesLocal);
        jugadorLocal.setEquipoEstado(equipoEstado);
        do {
            impresor.imprimirMapaObjetos(mapaLocal, nombreCiudad);
            movi = scanner.nextLine();
            if (movi.equalsIgnoreCase("W") || movi.equalsIgnoreCase("S") || movi.equalsIgnoreCase("A")
                    || movi.equalsIgnoreCase("D")) {
                mapaLocal = movimiento.movimiento(jugadorPosicion, mapaLocal, movi, jugadorLocal);
                jugadorPosicion = movimiento.getSpawn();

            } else if (movi.equalsIgnoreCase("M")) {
                mochilaLocal.menuInicialMochila();
            } else if (movi.equalsIgnoreCase("N")) {

                mapa.setJugador(jugadorPosicion);
                mapa = mapaCiudadesLocal[mapas.selecionDeMapa()];
                mapaLocal = mapa.getMapa();
                jugadorPosicion = mapa.getJugador();

            } else if (movi.equalsIgnoreCase("P")) {
                equipoEstado.menuInicial();

            } else if (movi.equalsIgnoreCase("T")) {
                pokedexLocal.pokedexMenu();
            } else if (movi.equalsIgnoreCase("X")) {
                System.out.println("Salir Y guardar");
                break;
            } else if (movi.equalsIgnoreCase("F")) {
                jugadorLocal.perfil(mapaCiudadesLocal);
            } else {
                System.out.println("hola");
            }
        } while (true);
    }

}
