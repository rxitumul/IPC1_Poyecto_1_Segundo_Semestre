package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class CreadorMapas {
    private static final int TAMANO_MAPA_GALACTICO_FIN = 25;
    private static final int TAMANO_MAPA_GALACTICO_INICIO = 25;

    private static final int TIENDA_POKEMON = 2;
    private static final int GIMNACIO_POKEMON = 1;
    private static final int CENTRO_POKEMON = 3;
    private static final int HIERVA_ALTA = 4;
    private static final int SPAWN = 4;
    private static final int ESPACIO = 6;

    private static final int ESTACIONES_CANTIDAD = 6;
    private static final int SECTORES_DE_COMBATE_CANTIDAD = 6;
    private static final int UNO = 1;
    private static final int CERO = 0;

    private int[][] mapa = new int[25][25];
    private int[] jugador = new int[2];
    private Random rand = new Random();
    private int cantidadEstrellas;

    public Casillas[][] mapaCreador(boolean baseEnemigaCreacion, int estrellas) {

        CreadorDeMapaDeObjetos objetosMapa = new CreadorDeMapaDeObjetos();
        int cantiadMaximaHiervaAlta;
        for (int i = 0; i < TAMANO_MAPA_GALACTICO_FIN; i++) {
            for (int j = 0; j < TAMANO_MAPA_GALACTICO_FIN; j++) {
                mapa[i][j] = ESPACIO;
            }
        }

        mapa = posicionAlAzara(mapa, SPAWN, false, CERO);
        mapa = posicionAlAzara(mapa, TIENDA_POKEMON, false, CERO);
        mapa = posicionAlAzara(mapa, GIMNACIO_POKEMON, false, CERO);
        mapa = posicionAlAzara(mapa, CENTRO_POKEMON, true, CERO);

        cantiadMaximaHiervaAlta = randomizador(1, 6);
        mapa = posicionAlAzara(mapa, CENTRO_POKEMON, true, cantiadMaximaHiervaAlta);

        return objetosMapa.creadorCasillasObjetos(mapa);

    }

    private int[][] posicionAlAzara(int[][] mapaGalaticoM, int tipoAsignacion, boolean repeticion, int contador) {
        int posicionX;
        int posicionY;
        do {
            posicionY = rand.ints(TAMANO_MAPA_GALACTICO_INICIO, TAMANO_MAPA_GALACTICO_FIN).findFirst().getAsInt();
            posicionX = rand.ints(TAMANO_MAPA_GALACTICO_INICIO, TAMANO_MAPA_GALACTICO_FIN).findFirst().getAsInt();
            if (mapaGalaticoM[posicionY][posicionX] == ESPACIO) {
                mapaGalaticoM[posicionY][posicionX] = tipoAsignacion;
                contador--;
            }
            if (contador == 0) {
                repeticion = false;
            }
            if (tipoAsignacion == 5) {
                jugador[0] = posicionY;
                jugador[1] = posicionX;
            }

        } while (repeticion);
        return mapaGalaticoM;
    }

    private int randomizador(int inicial, int fin) {
        return rand.ints(inicial, fin).findFirst().getAsInt();
    }

    public int getCantidadEstrellas() {
        return cantidadEstrellas;
    }

    public int[] getJugador() {
        return jugador;
    }
}
