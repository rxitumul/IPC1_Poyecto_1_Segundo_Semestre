package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.LiderDeGimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.TiendaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.HiervaAlta;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.Farmacia;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.Gimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.Tienda;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionEntrenador;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionFarmacia;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionTienda;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.IntracionTele;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class CreadorDeMapaDeObjetos {

    private HallDeLaFama hall;
    private final static String ROJO = "\u001B[31m";
    private final static String VERDE = "\u001B[32m";
    private final static String AMARILLO = "\u001B[33m";

    private final static String VERDE_CLARO = "\u001B[38;5;118m";
    private final static String AZUL = "\u001B[34m";
    private final static String AZUL_BRILLANTE = "\u001B[94m";
    private final static String MAGENTA = "\u001B[35m";
    private final static String RESET = "\u001B[0m";

    public CreadorDeMapaDeObjetos(HallDeLaFama hall) {
        this.hall = hall;
    }

    public Casillas[][] creadorCasillasObjetos(int[][] mapa, String nombreCiudad) {
        return creadorCasillasObjetos(mapa, nombreCiudad, 0);
    }

    public Casillas[][] creadorCasillasObjetos(int[][] mapa, String nombreCiudad, int ciudadIndice) {
        int rows = mapa.length;
        int cols = mapa[0].length;
        Casillas[][] mapaO = new Casillas[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mapaO[i][j] = crearCasilla(mapa[i][j], nombreCiudad, ciudadIndice);
            }
        }
        return mapaO;
    }

    public Casillas[][] creadorCasillasCentroPokemon(int[][] mapa, EnfermeriaNpc enfermera) {
        Casillas[][] mapeoDeCentroPokemon = creadorCasillasObjetos(mapa, "");
        for (int i = 0; i < mapeoDeCentroPokemon.length; i++) {
            for (int j = 0; j < mapeoDeCentroPokemon[0].length; j++) {
                if (mapeoDeCentroPokemon[i][j] instanceof InteracionFarmacia) {
                    mapeoDeCentroPokemon[i][j].setNpc(enfermera);
                }
            }
        }
        return mapeoDeCentroPokemon;
    }

    public Casillas[][] creadorCasillasTienda(int[][] mapa, TiendaNpc tienda) {
        Casillas[][] mapeoDeTiendas = creadorCasillasObjetos(mapa, "");
        for (int i = 0; i < mapeoDeTiendas.length; i++) {
            for (int j = 0; j < mapeoDeTiendas[0].length; j++) {
                if (mapeoDeTiendas[i][j] instanceof InteracionTienda) {
                    mapeoDeTiendas[i][j].setNpc(tienda);
                }
            }
        }
        return mapeoDeTiendas;
    }

    public Casillas[][] creadorCasillasGimnasio(int[][] mapa, Entrenador[] entrenadores, String nombreCiudad) {
        int filas = mapa.length;
        int columnas = mapa[0].length;
        Casillas[][] mapaGymCasillas = new Casillas[filas][columnas];
        Entrenador[][] mapeoDeNpcsGym = new Entrenador[filas][columnas];

        int contadorEntrenadores = 0;
        Entrenador lider = null;

        if (entrenadores != null) {
            for (Entrenador liderOEntrenador : entrenadores) {
                if (liderOEntrenador instanceof LiderDeGimnasio
                        || (liderOEntrenador != null && liderOEntrenador.getbBleanoActivo())) {
                    lider = liderOEntrenador;
                }
            }
            if (lider == null && entrenadores.length > 0) {
                lider = entrenadores[entrenadores.length - 1];
            }
        }

        // Primer pase: crear casillas y mapear posición de cada Entrenador (10) y Líder
        // (11)
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mapaGymCasillas[i][j] = crearCasilla(mapa[i][j], nombreCiudad);
                if (mapa[i][j] == 10 && entrenadores != null && contadorEntrenadores < entrenadores.length - 1) {
                    mapeoDeNpcsGym[i][j] = entrenadores[contadorEntrenadores++];
                    mapaGymCasillas[i][j].setNpc(mapeoDeNpcsGym[i][j]);
                } else if (mapa[i][j] == 11) {
                    mapeoDeNpcsGym[i][j] = lider;
                    mapaGymCasillas[i][j].setNpc(lider);
                }
            }
        }

        // Segundo pase: conectar casillas de interacción (15) con su Entrenador o Líder
        // adyacente
        int[][] casillasAdyasentes = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (mapaGymCasillas[i][j] instanceof InteracionEntrenador) {
                    Entrenador asignado = null;
                    for (int[] casilla : casillasAdyasentes) {
                        int fila = i + casilla[0];
                        int columna = j + casilla[1];
                        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas
                                && mapeoDeNpcsGym[fila][columna] != null) {
                            asignado = mapeoDeNpcsGym[fila][columna];
                            break;
                        }
                    }
                    if (asignado == null) {
                        if (lider != null) {
                            asignado = lider;
                        } else if (entrenadores != null && entrenadores.length > 0) {
                            asignado = entrenadores[0];
                        }
                    }
                    mapaGymCasillas[i][j].setNpc(asignado);
                }
            }
        }

        return mapaGymCasillas;
    }

    private Casillas crearCasilla(int tipo, String nombreCiudad) {
        return crearCasilla(tipo, nombreCiudad, 0);
    }

    private Casillas crearCasilla(int tipo, String nombreCiudad, int ciudadIndice) {
        switch (tipo) {
            // ── Edificios del mapa principal ──────────────────────────────
            case 6: // Centro Pokémon (acceso desde el mapa)
                return new Farmacia(VERDE_CLARO + " ⚕ " + RESET, false, 6, false, hall, null);
            case 1: // Gimnasio
                return new Gimnasio(AZUL_BRILLANTE + " G " + RESET, false, 1, false, hall, null, nombreCiudad, ciudadIndice);
            case 2: // Tienda
                return new Tienda(AMARILLO + " $ " + RESET, false, 2, false, hall, null);
            case 3: // Hierva Alta
                return new HiervaAlta(VERDE + " ♣ " + RESET, true, 3, true, hall);

            case 4: // Jugador (spawn)
                return new CasillaGenerica(MAGENTA + " > " + RESET, true, 4, false, hall);
            case 5: // Muro
                return new CasillaGenerica(ROJO + " ■ " + RESET, false, 5, false, hall);
            case 7: // Árbol
                return new CasillaGenerica(VERDE + " ♠ " + RESET, false, 7, false, hall);
            case 8: // Agua
                return new CasillaGenerica(AZUL + " ≈ " + RESET, false, 8, false, hall);
            case 9: // Casa
                return new CasillaGenerica(AMARILLO + " ⌂ " + RESET, false, 9, false, hall);

            // ── Casillas de NPC (interiores) ─────────────────────────────
            case 10: // Entrenador
                return new CasillaGenerica(AZUL + " ♜ " + RESET, false, 10, true, hall);
            case 11: // Líder de Gimnasio
                return new CasillaGenerica(AZUL + " ♛ " + RESET, false, 11, true, hall);
            case 12: // Empleado Tienda
                return new CasillaGenerica(AZUL + " ♙ " + RESET, false, 12, true, hall);
            case 13: // Enfermera
                return new CasillaGenerica(AZUL + " ♥ " + RESET, false, 13, true, hall);
            case 14: // Televisión
                return new CasillaGenerica(AZUL + " ▣ " + RESET, false, 14, true, hall);

            // ── Casillas de interacción (con lógica real) ─────────────────

            
            case 15: // Zona de interacción - Entrenador
                return new InteracionEntrenador(hall);
            case 16: // Zona de interacción - Farmacia
                return new InteracionFarmacia(hall);
            case 17: // Zona de interacción - Tienda
                return new InteracionTienda(hall);
            case 18: // Zona de interacción - Televisión
                return new IntracionTele(hall);

            // ── Decorado interior ─────────────────────────────────────────
            case 19: // Mostrador
                return new CasillaGenerica("---", false, 19, false, hall);
            case 20: // Salida
                return new CasillaGenerica(ROJO + " ⇩ " + RESET, true, 20, true, hall);

            default:
                return new CasillaGenerica("   ", true, 0, false, hall);
        }
    }
}
