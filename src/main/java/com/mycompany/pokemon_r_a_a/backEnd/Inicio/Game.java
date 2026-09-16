package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CargadorDePartidas.DistribuidorDeGuardado;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.EstadoPokemonEquipo;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mapas;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeMapas;

@SuppressWarnings("rawtypes")

public class Game {

    private Scanner scanner;
    private MovimientoJugador movimiento;
    private Pokedex pokedexLocal;
    private JugadorPokemonPartida jugadorLocal;
    private Mochila mochilaLocal;
    private ImpresorDeMapas impresor;
    private EstadoPokemonEquipo equipoEstado;
    private HallDeLaFama hallGlobal;

    private int[] jugadorPosicion;
    private AsignadorDeVariableGobalHall asignar;
    private MapaCiudad[] mapaCiudadesLocal;

    public Game(Scanner scanner, MapaCiudad[] mapaCiudades,
            JugadorPokemonPartida jugador, HallDeLaFama hallGlobal) {
        asignar = new AsignadorDeVariableGobalHall(hallGlobal, mapaCiudades);
        this.scanner = scanner;
        this.hallGlobal = hallGlobal;
        mapaCiudadesLocal = mapaCiudades;
        pokedexLocal = jugador.getPokedexJugador();
        jugadorLocal = jugador;
        mochilaLocal = jugador.getMochilaJugador();
        impresor = new ImpresorDeMapas();
        movimiento = new MovimientoJugador();
        equipoEstado = new EstadoPokemonEquipo(scanner, jugadorLocal);
        asignar.asignacion();

    }

    public void gameInicio(int ciudadInicio, String nomprePartida) {
        MapaCiudad mapa = mapaCiudadesLocal[ciudadInicio];
        Casillas[][] mapaLocal = mapa.getMapa();
        String nombreCiudad = mapa.getNombre();
        Mapas mapas = new Mapas(scanner, mapaCiudadesLocal);
        String movi;
        boolean vencido = false;
        jugadorPosicion = mapa.getJugador();

        jugadorLocal.setMapaCiudadesLocal(mapaCiudadesLocal);
        jugadorLocal.setEquipoEstado(equipoEstado);
        do {
            impresor.imprimirMapaObjetos(mapaLocal, nombreCiudad);
            movi = scanner.nextLine();
            if (movi.equalsIgnoreCase("W") || movi.equalsIgnoreCase("S") || movi.equalsIgnoreCase("A")
                    || movi.equalsIgnoreCase("D")) {
                mapaLocal = movimiento.movimiento(jugadorPosicion, mapaLocal, movi, jugadorLocal, false);
                jugadorPosicion = movimiento.getSpawn();
                vencido = jugadorLocal.getVencido();

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
                DistribuidorDeGuardado guardado = new DistribuidorDeGuardado(mapaCiudadesLocal, jugadorLocal,
                        nomprePartida);
                guardado.guardarJuego(mapaCiudadesLocal, jugadorLocal, hallGlobal);

                impresor.mensajeInformativo("Salir Y guardar");
                break;
            } else if (movi.equalsIgnoreCase("F")) {
                jugadorLocal.perfil(mapaCiudadesLocal);
            } else {
                impresor.pantallaDeError();
            }
            if (vencido) {
                // 1. Restaurar la casilla en la posición previa del jugador en el mapa principal
                if (jugadorPosicion != null && jugadorPosicion[0] >= 0 && jugadorPosicion[0] < mapaLocal.length
                        && jugadorPosicion[1] >= 0 && jugadorPosicion[1] < mapaLocal[0].length) {
                    Casillas prev = movimiento.getCasillaAnterior();
                    if (prev != null && prev.tipoCasilla() != 4) {
                        mapaLocal[jugadorPosicion[0]][jugadorPosicion[1]] = prev;
                    } else {
                        mapaLocal[jugadorPosicion[0]][jugadorPosicion[1]] = new CasillaGenerica("   ", true, 0, false, null);
                    }
                }

                // 2. Limpiar cualquier posición residual de jugador (tipo 4) en el mapa principal
                for (int i = 0; i < mapaLocal.length; i++) {
                    for (int j = 0; j < mapaLocal[i].length; j++) {
                        if (mapaLocal[i][j] != null && mapaLocal[i][j].tipoCasilla() == 4) {
                            mapaLocal[i][j] = new CasillaGenerica("   ", true, 0, false, null);
                        }
                    }
                }

                // 3. Buscar casilla caminable adyacente o cercana al Centro Pokémon (enfermería)
                int[] enfermeriaActual = mapa.getEnfermeria();
                int targetY = enfermeriaActual[0];
                int targetX = enfermeriaActual[1];
                boolean encontrado = false;

                int[][] deltas = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
                for (int[] d : deltas) {
                    int ny = enfermeriaActual[0] + d[0];
                    int nx = enfermeriaActual[1] + d[1];
                    if (ny >= 0 && ny < mapaLocal.length && nx >= 0 && nx < mapaLocal[0].length) {
                        if (mapaLocal[ny][nx] != null && mapaLocal[ny][nx].caminable() && mapaLocal[ny][nx].tipoCasilla() != 4) {
                            targetY = ny;
                            targetX = nx;
                            encontrado = true;
                            break;
                        }
                    }
                }

                if (!encontrado) {
                    int maxDist = Math.max(mapaLocal.length, mapaLocal[0].length);
                    for (int dist = 2; dist < maxDist && !encontrado; dist++) {
                        for (int dy = -dist; dy <= dist && !encontrado; dy++) {
                            for (int dx = -dist; dx <= dist && !encontrado; dx++) {
                                int ny = enfermeriaActual[0] + dy;
                                int nx = enfermeriaActual[1] + dx;
                                if (ny >= 0 && ny < mapaLocal.length && nx >= 0 && nx < mapaLocal[0].length) {
                                    if (mapaLocal[ny][nx] != null && mapaLocal[ny][nx].caminable() && mapaLocal[ny][nx].tipoCasilla() != 4) {
                                        targetY = ny;
                                        targetX = nx;
                                        encontrado = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                // 4. Posicionar al jugador en la casilla caminable cerca de la enfermería
                Casillas casillaDestino = mapaLocal[targetY][targetX];
                movimiento.setCasillaAnterior(casillaDestino);
                mapaLocal[targetY][targetX] = new CasillaGenerica("\u001B[35m > \u001B[0m", true, 4, false, null);
                jugadorPosicion = new int[] { targetY, targetX };
                movimiento.setSpawn(jugadorPosicion);
                mapa.setJugador(jugadorPosicion);
                jugadorLocal.setVencido(false);
                vencido = false;
            }

        } while (true);
    }

}
