package com.mycompany.pokemon_r_a_a;

import java.util.Random;

public class CreadorMapas {
    private static final int TAMAnO_MAPA_GALACTICO_FIN = 25;
    private static final int TAMAnO_MAPA_GALACTICO_INICIO = 0;
    private static final int WARP = 0;
    private static final int ESTACION = 1;
    private static final int BASE_ENEMIGA = 2;
    private static final int SECTOR_DE_COMBATE = 3;
    private static final int ESTRELLA = 4;
    private static final int SPAWN = 5;
    private static final int ESPACIO = 6;

    private static final int BASE_ENEMIGA_CANTIDAD = 2;
    private static final int ESTACIONES_CANTIDAD = 6;
    private static final int SECTORES_DE_COMBATE_CANTIDAD = 6;
    private static final int UNO = 1;
    private static final int CERO = 0;

    private int[][] mapa = new int[25][25];
    private int[] jugador = new int[2];
    private Random rand = new Random();
    private int cantidadEstrellas;
    private int cantidadBasesEnemigas;

    public Casilla[][] mapaCreador(int opcionMapa, boolean baseEnemigaCreacion, int estrellas) {

        int cantiadMaxima;
        for (int i = 0; i < TAMAnO_MAPA_GALACTICO_FIN; i++) {
            for (int j = 0; j < TAMAnO_MAPA_GALACTICO_FIN; j++) {
                mapa[i][j] = ESPACIO;
            }
        }

        if (opcionMapa == CERO) {
            mapa = posicionAlAzara(mapa, SPAWN, false, CERO);
            if (estrellas == 0) {
                cantidadEstrellas = randomizador(2, 5);
                mapa = posicionAlAzara(mapa, ESTRELLA, true, cantidadEstrellas);
            } else {
                mapa = posicionAlAzara(mapa, ESTRELLA, true, estrellas);
            }

            cantiadMaxima = randomizador(UNO, ESTACIONES_CANTIDAD);
            mapa = posicionAlAzara(mapa, ESTACION, true, cantiadMaxima);

            cantiadMaxima = randomizador(UNO, SECTORES_DE_COMBATE_CANTIDAD);
            mapa = posicionAlAzara(mapa, SECTOR_DE_COMBATE, true, cantiadMaxima);

        } else if (opcionMapa == UNO) {

            mapa = posicionAlAzara(mapa, WARP, false, CERO);
            mapa = posicionAlAzara(mapa, SPAWN, false, CERO);

            cantiadMaxima = randomizador(UNO, ESTACIONES_CANTIDAD);
            mapa = posicionAlAzara(mapa, ESTACION, false, cantiadMaxima);

            cantiadMaxima = randomizador(UNO, SECTORES_DE_COMBATE_CANTIDAD);
            mapa = posicionAlAzara(mapa, SECTOR_DE_COMBATE, false, cantiadMaxima);
            if (baseEnemigaCreacion) {
                cantidadBasesEnemigas = randomizador(UNO, BASE_ENEMIGA_CANTIDAD);
                mapa = posicionAlAzara(mapa, BASE_ENEMIGA, false, cantidadBasesEnemigas);
            }
        }
        return creadorCasillasObjetos(mapa);

    }

    private int[][] posicionAlAzara(int[][] mapaGalaticoM, int tipoAsignacion, boolean repeticion, int contador) {
        int posicionX;
        int posicionY;
        do {
            posicionY = rand.ints(TAMAnO_MAPA_GALACTICO_INICIO, TAMAnO_MAPA_GALACTICO_FIN).findFirst().getAsInt();
            posicionX = rand.ints(TAMAnO_MAPA_GALACTICO_INICIO, TAMAnO_MAPA_GALACTICO_FIN).findFirst().getAsInt();
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

    private Casilla[][] creadorCasillasObjetos(int[][] mapa) {
        Casilla[][] mapaO = new Casilla[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                switch (mapa[i][j]) {
                    case 0:
                        mapaO[i][j] = new RetornarGalacia();
                        break;
                    case 1:
                        mapaO[i][j] = new EstacionEspacial();

                        break;
                    case 2:
                        mapaO[i][j] = new BaseEnemiga();
                        break;
                    case 3:
                        mapaO[i][j] = new SectorCombate();
                        break;
                    case 4:
                        mapaO[i][j] = new Estrellas();
                        break;
                    case 5:
                        mapaO[i][j] = new Jugador();
                        break;
                    default:
                        mapaO[i][j] = new Espacio();
                        break;
                }
            }
        }
        return mapaO;
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
