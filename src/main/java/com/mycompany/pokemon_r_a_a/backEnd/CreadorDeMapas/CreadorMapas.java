package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class CreadorMapas {
    private static final int TAMANO_MAPA_POKEMON_FIN = 25;
    private static final int TAMANO_MAPA_POKEMON_INICIO = 0;

    private static final int CENTRO_POKEMON = 0;
    private static final int GIMNACIO_POKEMON = 1;
    private static final int TIENDA_POKEMON = 2;
    private static final int HIERVA_ALTA = 3;
    private static final int SPAWN = 4;
    private static final int MURRO = 5;
    private static final int ARBOL = 7;
    private static final int AGUA = 8;
    private static final int CASA = 9;
    private static final int ESPACIO = 6;

    private String[] nombres = { "Pallet Town",
            "Viridian City", "Pewter City", "Cerulean City", "Vermilion City", "Saffron City", "Celadon City",
            "Lavender Town", "Fuchsia City", "Cinnabar Island" };
    private int[][] mapa = new int[25][25];
    private int[] jugador;
    private Random rand = new Random();

    public MapaCiudad mapaCreador(MapaCiudad[] mapasCreados) {
        jugador = new int[2];
        String nombre = "";
        CreadorDeMapaDeObjetos objetosMapa = new CreadorDeMapaDeObjetos();
        for (int i = 0; i < TAMANO_MAPA_POKEMON_FIN; i++) {
            for (int j = 0; j < TAMANO_MAPA_POKEMON_FIN; j++) {
                mapa[i][j] = ESPACIO;
            }
        }
        int repetir = rand.ints(0, 5).findFirst().getAsInt();
        mapa = posicionAlAzara(mapa, HIERVA_ALTA, true, true, repetir);

        mapa = posicionAlAzara(mapa, SPAWN, false, false, 0);
        mapa = posicionAlAzara(mapa, TIENDA_POKEMON, false, false, 0);
        mapa = posicionAlAzara(mapa, GIMNACIO_POKEMON, false, false, 0);
        mapa = posicionAlAzara(mapa, CENTRO_POKEMON, false, false, 0);
        mapa = posicionAlAzara(mapa, MURRO, false, true, 20);
        mapa = posicionAlAzara(mapa, ARBOL, false, true, 15);
        mapa = posicionAlAzara(mapa, AGUA, false, true, 10);
        mapa = posicionAlAzara(mapa, CASA, false, true, 20);
        do {
            boolean repetido = false;
            int nombreRango = rand.ints(0, nombres.length).findFirst().getAsInt();
            nombre = nombres[nombreRango];
            for (MapaCiudad mapaCiudad2 : mapasCreados) {
                if (mapaCiudad2 != null && mapaCiudad2.getNombre().equals(nombre)) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                break;
            }
        } while (true);

        return new MapaCiudad(nombre, objetosMapa.creadorCasillasObjetos(mapa), jugador);

    }

    private int[][] posicionAlAzara(int[][] mapaPokemonM, int tipoAsignacion, boolean hiervaAlta, boolean repetir,
            int repetirDatos) {
        int posicionX;
        int posicionY;
        int contador = 0;
        do {
            contador++;
            while (true) {
                posicionY = rand.ints(TAMANO_MAPA_POKEMON_INICIO, TAMANO_MAPA_POKEMON_FIN).findFirst().getAsInt();
                posicionX = rand.ints(TAMANO_MAPA_POKEMON_INICIO, TAMANO_MAPA_POKEMON_FIN).findFirst().getAsInt();
                if (mapaPokemonM[posicionY][posicionX] == ESPACIO) {
                    mapaPokemonM[posicionY][posicionX] = tipoAsignacion;
                    if (tipoAsignacion == SPAWN) {
                        jugador[0] = posicionY;
                        jugador[1] = posicionX;
                    }
                    break;
                }
            }

            if (hiervaAlta) {
                grupoDehiervaAlta(mapaPokemonM, posicionX, posicionY);
            }
            if (repetirDatos == contador) {
                break;
            }
        } while (repetir);

        return mapaPokemonM;
    }

    private int[][] grupoDehiervaAlta(int[][] mapaPokemonM, int startX, int startY) {
        int originX = Math.min(startX, TAMANO_MAPA_POKEMON_FIN - 5);
        int originY = Math.min(startY, TAMANO_MAPA_POKEMON_FIN - 5);
        if (originX < 0)
            originX = 0;
        if (originY < 0)
            originY = 0;

        for (int y = originY; y < originY + 5 && y < TAMANO_MAPA_POKEMON_FIN; y++) {
            for (int x = originX; x < originX + 5 && x < TAMANO_MAPA_POKEMON_FIN; x++) {
                if (mapaPokemonM[y][x] == ESPACIO || mapaPokemonM[y][x] == HIERVA_ALTA) {
                    mapaPokemonM[y][x] = HIERVA_ALTA;
                }
            }
        }
        return mapaPokemonM;
    }

    public int[] getJugador() {
        return jugador;
    }
}
