package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.TiendaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

@SuppressWarnings("rawtypes")

public class CreadorMapas {
    private final static int TAMANO_MAPA_POKEMON_FIN = 25;
    private final static int TAMANO_MAPA_POKEMON_INICIO = 0;
    private final static int CENTRO_POKEMON = 6;
    private final static int GIMNACIO_POKEMON = 1;
    private final static int TIENDA_POKEMON = 2;
    private final static int HIERVA_ALTA = 3;
    private final static int SPAWN = 4;
    private final static int MURRO = 5;
    private final static int ARBOL = 7;
    private final static int AGUA = 8;
    private final static int CASA = 9;
    private final static int ESPACIO = 0;
    private final static int INTERACION_CON_NPC_DE_ENEMIGO = 15;
    private final static int INTERACION_CON_NPC_DE_ENFERMERA = 16;
    private final static int INTERACION_CON_NPC_DE_TELEVICION = 18;
    private final static int INTERACION_CON_NPC_DE_TIENDA = 17;
    private final static int SALIDA = 20;
    private final static int MOSTRADOR = 19;

    private int[][] mapaCentroPokemon = {
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENFERMERA, INTERACION_CON_NPC_DE_ENFERMERA,
                    INTERACION_CON_NPC_DE_ENFERMERA, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENFERMERA, MOSTRADOR, MOSTRADOR, MOSTRADOR,
                    INTERACION_CON_NPC_DE_ENFERMERA, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENFERMERA, MOSTRADOR, 13, MOSTRADOR,
                    INTERACION_CON_NPC_DE_ENFERMERA, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENFERMERA, MOSTRADOR, MOSTRADOR, MOSTRADOR,
                    INTERACION_CON_NPC_DE_ENFERMERA, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENFERMERA, INTERACION_CON_NPC_DE_ENFERMERA,
                    INTERACION_CON_NPC_DE_ENFERMERA, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO,
                    INTERACION_CON_NPC_DE_TELEVICION },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, SPAWN, ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_TELEVICION,
                    14 },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, SALIDA, ESPACIO, ESPACIO, ESPACIO, ESPACIO,
                    INTERACION_CON_NPC_DE_TELEVICION }
    };

    private int[][] mapaTiendaPokemon = {
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_TIENDA, INTERACION_CON_NPC_DE_TIENDA,
                    INTERACION_CON_NPC_DE_TIENDA, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_TIENDA, MOSTRADOR, MOSTRADOR, MOSTRADOR,
                    INTERACION_CON_NPC_DE_TIENDA, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_TIENDA, MOSTRADOR, 12, MOSTRADOR, INTERACION_CON_NPC_DE_TIENDA,
                    ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_TIENDA, MOSTRADOR, MOSTRADOR, MOSTRADOR,
                    INTERACION_CON_NPC_DE_TIENDA, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_TIENDA, INTERACION_CON_NPC_DE_TIENDA,
                    INTERACION_CON_NPC_DE_TIENDA, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, SPAWN, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, 20, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO }
    };
    private int[][] mapaGimnasio = {
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO, ESPACIO,
                    ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, 10,
                    INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO,
                    INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO, ESPACIO },
            { ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, 10, INTERACION_CON_NPC_DE_ENEMIGO, INTERACION_CON_NPC_DE_ENEMIGO,
                    ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, 10, INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO },
            { ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, INTERACION_CON_NPC_DE_ENEMIGO, 11,
                    INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, INTERACION_CON_NPC_DE_ENEMIGO, ESPACIO, ESPACIO, ESPACIO, ESPACIO,
                    ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, SPAWN, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO },
            { ESPACIO, ESPACIO, ESPACIO, ESPACIO, SALIDA, ESPACIO, ESPACIO, ESPACIO, ESPACIO, ESPACIO }

    };

    private String[] nombres = { "Pallet Town",
            "Viridian City", "Pewter City", "Cerulean City", "Vermilion City", "Saffron City", "Celadon City",
            "Lavender Town", "Fuchsia City", "Cinnabar Island" };

    private int[] jugador;
    private int[] enfermeria;
    private int[][] mapa;
    private CreadorNpc npcCreador;
    private Random rand;
    private CreadorDeMapaDeObjetos objetosMapa;

    public CreadorMapas(HallDeLaFama hall) {
        mapa = new int[25][25];
        npcCreador = new CreadorNpc();
        rand = new Random();
        objetosMapa = new CreadorDeMapaDeObjetos(hall);
    }

    public CreadorNpc getNpcCreador() {
        return npcCreador;
    }

    public Casillas[][] getMapaCentroPokemon(EnfermeriaNpc npc) {
        if (npc == null) {
            npc = npcCreador.creadorDeEnfermeria();
        }
        return objetosMapa.creadorCasillasCentroPokemon(mapaCentroPokemon, npc);
    }

    public Casillas[][] getMapaCentroPokemon() {
        return getMapaCentroPokemon(npcCreador.creadorDeEnfermeria());
    }

    public Casillas[][] getMapaGimnasio(Entrenador[] entrenadores, String ciudadNombre) {
        if (entrenadores == null) {
            entrenadores = npcCreador.creadorDeEntrenadoresYLider(ciudadNombre);
        }
        return objetosMapa.creadorCasillasGimnasio(mapaGimnasio, entrenadores, ciudadNombre);
    }

    public int[][] getMapaGimnasioMatriz() {
        return mapaGimnasio;
    }

    public Casillas[][] getMapaTiendaPokemon(TiendaNpc tienda) {
        if (tienda == null) {
            tienda = npcCreador.creadorDeTienda();
        }
        return objetosMapa.creadorCasillasTienda(mapaTiendaPokemon, tienda);
    }

    public Casillas[][] getMapaTiendaPokemon() {
        return getMapaTiendaPokemon(npcCreador.creadorDeTienda());
    }

    public MapaCiudad mapaCreador(MapaCiudad[] mapasCreados) {
        jugador = new int[2];
        enfermeria = new int[2];
        String nombre = "";

        for (int i = 0; i < TAMANO_MAPA_POKEMON_FIN; i++) {
            for (int j = 0; j < TAMANO_MAPA_POKEMON_FIN; j++) {
                mapa[i][j] = ESPACIO;
            }
        }
        int repetir = rand.nextInt(5) + 1;
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

        int ciudadIndice = 0;
        if (mapasCreados != null) {
            for (MapaCiudad mc : mapasCreados) {
                if (mc != null) {
                    ciudadIndice++;
                }
            }
        }
        return new MapaCiudad(nombre, objetosMapa.creadorCasillasObjetos(mapa, nombre, ciudadIndice), jugador, enfermeria);

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
                    } else if (tipoAsignacion == CENTRO_POKEMON) {
                        enfermeria[0] = posicionY;
                        enfermeria[1] = posicionX;
                    }
                    break;
                }
            }

            if (hiervaAlta) {
                grupoDehiervaAlta(mapaPokemonM, posicionX, posicionY);
            }
            if (contador >= repetirDatos) {
                break;
            }
        } while (repetir);

        return mapaPokemonM;
    }

    private int[][] grupoDehiervaAlta(int[][] mapaPokemonM, int startX, int startY) {
        int maxLim = TAMANO_MAPA_POKEMON_FIN - 5;
        int originX;
        if (startX < maxLim) {
            originX = startX;
        } else {
            originX = maxLim;
        }

        int originY;
        if (startY < maxLim) {
            originY = startY;
        } else {
            originY = maxLim;
        }
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
}
