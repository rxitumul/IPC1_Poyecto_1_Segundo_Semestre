package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorMapas;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class InicioGame {
    private Scanner scanner = new Scanner(System.in);
    private CreadorMapas creador = new CreadorMapas();
    private ProfesorCharla profe = new ProfesorCharla(scanner);
    private Pokemons[] equipos = new Pokemons[5];
    private JugadorPokemonPartida jugador = new JugadorPokemonPartida(scanner);
    private Mochila mochila = new Mochila(scanner);
    private Pokemons[] pokedexLista = new Pokemons[25];
    private MenuPrincipal menuPrincipal = new MenuPrincipal(scanner);
    private DatosPokemon datos = new DatosPokemon();
    /*
     * "Pokédex liberada: ✓",
     * 
     * 
     */

    public void inicio() {
        boolean salir = false;
        while (!salir) {
            int opcion = menuPrincipal.menuInicial();
            switch (opcion) {
                case 1:
                    // profe.charlaInicial();
                    profe.regaloProfesor(jugador);
                    pokedexLista = datos.creadorPokedesData();
                    Pokedex pokedex = new Pokedex(pokedexLista, scanner);
                    MapaCiudad[] mapas = new MapaCiudad[3];
                    for (int i = 0; i < mapas.length; i++) {
                        mapas[i] = creador.mapaCreador(mapas);
                    }
                    Game game = new Game(scanner, mapas, pokedex, equipos, jugador, mochila);
                    game.gameInicio(0);
                    break;
                case 2:
                    System.out.println("Cargando partida guardada...");
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar Pokémon R_A_A!");
                    salir = true;
                    break;
            }
        }
    }
}
