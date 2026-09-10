package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.CargadorDePartidas.DistribuidorDeGuardado;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorMapas;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;
import com.mycompany.pokemon_r_a_a.frontEnd.Menus.InterfasDePartidaGuardada;

public class InicioGame {
    private final String RUTA_DE_ARCHIVOS_GUARDADOS = "Archivos/PartidasGuardadas/";
    private final int CANTIDAD_DE_POKEMONES_EN_POKEDEX = 25;
    private final int CANTIDAD_DE_POKEMONES_JUGADOR = 5;
    private ImpresoresGlobal impresor;
    private Scanner scanner;
    private HallDeLaFama hall;
    private CreadorMapas creador;
    private ProfesorCharla profe;
    private Pokemons[] equipos;
    private JugadorPokemonPartida jugador;
    private Mochila mochila;
    private Pokemons[] pokedexLista;
    private MenuPrincipal menuPrincipal;
    private DatosPokemon datos;
    private InterfasDePartidaGuardada guardadas;

    public InicioGame() {
        impresor = new ImpresoresGlobal();
        scanner = new Scanner(System.in);
        hall = new HallDeLaFama();
        creador = new CreadorMapas(hall);
        profe = new ProfesorCharla(scanner);
        equipos = new Pokemons[CANTIDAD_DE_POKEMONES_JUGADOR];
        jugador = new JugadorPokemonPartida(scanner);
        mochila = new Mochila(scanner);
        pokedexLista = new Pokemons[CANTIDAD_DE_POKEMONES_EN_POKEDEX];
        menuPrincipal = new MenuPrincipal(scanner);
        datos = new DatosPokemon();
        guardadas = new InterfasDePartidaGuardada();
    }

    public void inicio() {
        boolean salir = false;
        Game game;

        while (!salir) {
            int opcion = menuPrincipal.menuInicial();
            switch (opcion) {
                case 1:
                    // profe.charlaInicial();
                    jugador.setPokemosEquipo(equipos);
                    jugador.setMochilaJugador(mochila);
                    profe.regaloProfesor(jugador);

                    pokedexLista = datos.creadorPokedesData();
                    Pokedex pokedexNueva = new Pokedex(pokedexLista, scanner);
                    jugador.setPokedexJugador(pokedexNueva);

                    MapaCiudad[] mapas = new MapaCiudad[3];
                    for (int i = 0; i < mapas.length; i++) {
                        mapas[i] = creador.mapaCreador(mapas);
                    }

                    game = new Game(scanner, mapas, jugador);
                    game.gameInicio(0);
                    break;

                case 2:
                    DistribuidorDeGuardado guaradadoCarga = new DistribuidorDeGuardado(null, null, "");
                    guardadas.interfasDeCargadoPartida(RUTA_DE_ARCHIVOS_GUARDADOS);

                    try {
                        int numeroDePartida = Integer.parseInt(scanner.nextLine());
                        String[] nombres = guaradadoCarga.lectorDeDatosNombres(RUTA_DE_ARCHIVOS_GUARDADOS);

                        if (nombres != null && numeroDePartida >= 0 && numeroDePartida < nombres.length) {
                            String nombrePartidaElegida = nombres[numeroDePartida];

                            if (nombrePartidaElegida != null && !nombrePartidaElegida.trim().isEmpty()) {
                                impresor.mensajeInformativo(
                                        "Cargando partida guardada: " + nombrePartidaElegida + "...");

                                String rutaCompletaPartida = RUTA_DE_ARCHIVOS_GUARDADOS + nombrePartidaElegida;
                                game = guaradadoCarga.juegoGuardado(rutaCompletaPartida);

                                if (game != null) {
                                    game.gameInicio(0);
                                }
                            }
                        } else {
                            impresor.mensajeInformativo("Número de partida inválido o no existen registros.");
                        }
                    } catch (NumberFormatException e) {
                        impresor.mensajeInformativo("Por favor, ingresa un número válido.");
                    }
                    break;
                case 3:
                    System.out.println("¡Gracias por jugar Pokémon R_A_A!");
                    salir = true;
                    break;
            }
        }
    }
}
