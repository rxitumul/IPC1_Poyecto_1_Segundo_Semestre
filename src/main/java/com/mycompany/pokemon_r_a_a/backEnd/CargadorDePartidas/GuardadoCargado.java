package com.mycompany.pokemon_r_a_a.backEnd.CargadorDePartidas;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.frontEnd.Menus.InterfasDePartidaGuardada;

public class GuardadoCargado {
    protected static final String RUTA_PARA_GUIA_TAMANO_NOMBRES = "archivos/juego/valores";
    protected final String RUTA_DE_ARCHIVOS_GUARDADOS = "Archivos/PartidasGuardadas/";

    protected InterfasDePartidaGuardada impresor;
    protected Scanner scanner;
    protected MapaCiudad[] mapas;
    protected JugadorPokemonPartida jugador;
    protected InterfasDePartidaGuardada guardadaImpresor;

    public GuardadoCargado() {
        this.scanner = new Scanner(System.in);
        this.guardadaImpresor = new InterfasDePartidaGuardada();
        this.impresor = new InterfasDePartidaGuardada();
    }

    public GuardadoCargado(MapaCiudad[] mapas, JugadorPokemonPartida jugador) {
        this.scanner = new Scanner(System.in);
        this.mapas = mapas;
        this.jugador = jugador;
        this.guardadaImpresor = new InterfasDePartidaGuardada();
        this.impresor = new InterfasDePartidaGuardada();
    }
}
