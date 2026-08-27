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
    private static final int ESPACIO = 6;

    private int[][] mapa = new int[25][25];
    private int[] jugador = new int[2];
    private Random rand = new Random();

    public Casillas[][] mapaCreador() {

        CreadorDeMapaDeObjetos objetosMapa = new CreadorDeMapaDeObjetos();
        for (int i = 0; i < TAMANO_MAPA_POKEMON_FIN; i++) {
            for (int j = 0; j < TAMANO_MAPA_POKEMON_FIN; j++) {
                mapa[i][j] = ESPACIO;
            }
        }
        mapa = posicionAlAzara(mapa, HIERVA_ALTA, true);

        mapa = posicionAlAzara(mapa, SPAWN, false);
        mapa = posicionAlAzara(mapa, TIENDA_POKEMON, false);
        mapa = posicionAlAzara(mapa, GIMNACIO_POKEMON, false);
        mapa = posicionAlAzara(mapa, CENTRO_POKEMON, false);
        for (int i = 0; i < 20; i++) {
            mapa = posicionAlAzara(mapa, MURRO, false);
            
        }

        return objetosMapa.creadorCasillasObjetos(mapa);

    }

    private int[][] posicionAlAzara(int[][] mapaPokemonM, int tipoAsignacion, boolean hiervaAlta) {
        int posicionX;
        int posicionY;
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
        return mapaPokemonM;
    }

    private int[][] grupoDehiervaAlta(int[][] mapaPokemonM, int startX, int startY) {
        int originX = Math.min(startX, TAMANO_MAPA_POKEMON_FIN - 5);
        int originY = Math.min(startY, TAMANO_MAPA_POKEMON_FIN - 5);
        if (originX < 0) originX = 0;
        if (originY < 0) originY = 0;

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

