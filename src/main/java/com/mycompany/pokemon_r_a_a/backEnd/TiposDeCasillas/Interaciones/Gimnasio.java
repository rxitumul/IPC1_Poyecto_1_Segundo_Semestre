package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.LiderDeGimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionEntrenador;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorNpc;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;

@SuppressWarnings("rawtypes")

public class Gimnasio extends CasillasConMapas {

    private Entrenador[] entrenador;
    private String nombreCiudad;
    private int ciudad;
    private int[] posicionInicial;
    private boolean vencido;

    public Gimnasio(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaGimnasio, String nombreCiudad, int ciudad) {
        super(hall, mapaGimnasio);
        posicionInicial = new int[2];
        this.simbolo = simbolo;
        this.ciudad = ciudad;
        entrenador = new Entrenador[3];
        this.nombreCiudad = nombreCiudad;
        nombre = "Gimnasio de " + nombreCiudad;
        entrenador[0] = new Entrenador(nombreCiudad);
        entrenador[1] = new Entrenador(nombreCiudad);
        entrenador[2] = new Entrenador(nombreCiudad);
        
        LiderDeGimnasio lider = new LiderDeGimnasio(nombreCiudad);
        lider.setCiudad(ciudad);
        lider.setBoleanoActivo(true);
        CreadorNpc npcCreador = new CreadorNpc();
        lider.SetMedalla(npcCreador.obtenerNombreMedallaCompleto(ciudad));
        this.npc = lider;

        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
        this.jugadorPosicion = new int[] { 7, 4 };
        this.posicionInicial = new int[] { 7, 4 };
    }

    public Gimnasio(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaGimnasio, String nombreCiudad) {
        this(simbolo, caminable, tipo, tieneSubMenu, hall, mapaGimnasio, nombreCiudad, 0);
    }

    @Override
    public void imprimir() {
        System.out.print(" G ");
    }

    @Override
    public Boolean subMenu() {
        this.salida = false;
        this.mov = new MovimientoJugador();
        String movimientoJugador;
        vencido = false;

        do {
            impresor.limpiadorPantalla();

            Casillas casillaAnterior = mov.getCasillaAnterior();
            if (casillaAnterior != null && casillaAnterior.tipoCasilla() == 15) {
                Entrenador entrenadorActual = null;
                if (casillaAnterior instanceof InteracionEntrenador) {
                    entrenadorActual = ((InteracionEntrenador) casillaAnterior).getNpc();
                }
                if (entrenadorActual == null && entrenador != null && entrenador.length > 0) {
                    entrenadorActual = entrenador[0];
                }
                impresor.imprimidorDeMapaConInteracionGimnacio(mapa, nombre, entrenadorActual, true);
            } else {
                impresor.imprimidorDeMapaConInteracionGimnacio(mapa, nombre, (Entrenador) null, false);
            }

            movimientoJugador = scan.nextLine();

            if (casillaAnterior != null && casillaAnterior.tipoCasilla() == 15
                    && movimientoJugador.trim().equalsIgnoreCase("C")) {
                casillaAnterior.subMenu();
                vencido = jugador != null && jugador.getVencido();
            } else {
                movimiento(mov, movimientoJugador);
                vencido = jugador != null && jugador.getVencido();
            }
            if (vencido) {
                int[] spawnActual = mov.getSpawn();
                Casillas casillaAnteriorActual = mov.getCasillaAnterior();
                if (spawnActual != null && casillaAnteriorActual != null
                        && spawnActual[0] >= 0 && spawnActual[0] < mapa.length
                        && spawnActual[1] >= 0 && spawnActual[1] < mapa[0].length) {
                    mapa[spawnActual[0]][spawnActual[1]] = casillaAnteriorActual;
                }
                jugadorPosicion = new int[] { posicionInicial[0], posicionInicial[1] };
                break;
            }

        } while (!salida);

        int[] spawnFinal = mov.getSpawn();
        Casillas casillaAnteriorFinal = mov.getCasillaAnterior();
        if (spawnFinal != null && casillaAnteriorFinal != null
                && spawnFinal[0] >= 0 && spawnFinal[0] < mapa.length
                && spawnFinal[1] >= 0 && spawnFinal[1] < mapa[0].length) {
            mapa[spawnFinal[0]][spawnFinal[1]] = casillaAnteriorFinal;
        }

        return true;
    }

    @Override
    public void setMapa() {
        if (mapa == null) {
            Pokemons[] equipoJugadorTemp; 
            if (jugador != null) {
                equipoJugadorTemp = jugador.getPokemosEquipo();
            } else {
                equipoJugadorTemp = null;
            }

            if ((this.ciudad < 0 || this.ciudad > 2) && mapaCiudadesLocal != null) {
                for (int i = 0; i < mapaCiudadesLocal.length; i++) {
                    if (mapaCiudadesLocal[i] != null && mapaCiudadesLocal[i].getNombre() != null
                            && mapaCiudadesLocal[i].getNombre().equals(nombreCiudad)) {
                        this.ciudad = i;
                        break;
                    }
                }
            }

            Entrenador[] lista = mapaCreador.getNpcCreador().creadorDeEntrenadoresYLider(this.ciudad, nombreCiudad, equipoJugadorTemp);

            this.entrenador = new Entrenador[3];
            for (int i = 0; i < 3; i++) {
                this.entrenador[i] = lista[i];
            }
            this.npc = lista[3];
            mapa = mapaCreador.getMapaGimnasio(lista, nombreCiudad);
        } else {
            // Limpiar cualquier posición previa del jugador y resetear en el spawn sin eliminar casillas de interacción
            int[][] layoutOriginal = mapaCreador.getMapaGimnasioMatriz();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (mapa[i][j] != null && mapa[i][j].tipoCasilla() == 4) {
                        if (i == 7 && j == 4) {
                            // Spawn inicial, se reasigna abajo
                        } else if (layoutOriginal != null && layoutOriginal[i][j] == 15) {
                            InteracionEntrenador ie = new InteracionEntrenador(hall);
                            Entrenador asignado = null;
                            if (i <= 2 && j >= 5) {
                                if (entrenador != null && entrenador.length > 0) {
                                    asignado = entrenador[0];
                                }
                            } else if (j < 5 && i <= 3) {
                                if (entrenador != null && entrenador.length > 1) {
                                    asignado = entrenador[1];
                                }
                            } else if (j >= 5 && i <= 3) {
                                if (entrenador != null && entrenador.length > 2) {
                                    asignado = entrenador[2];
                                }
                            } else {
                                if (npc instanceof Entrenador) {
                                    asignado = (Entrenador) npc;
                                }
                            }
                            if (asignado == null && entrenador != null && entrenador.length > 0) {
                                asignado = entrenador[0];
                            }
                            ie.setNpc(asignado);
                            mapa[i][j] = ie;
                        } else {
                            mapa[i][j] = new CasillaGenerica("   ", true, 0, false, null);
                        }
                    }
                }
            }
            mapa[7][4] = new CasillaGenerica("\u001B[35m > \u001B[0m", true, 4, false, null);
            mapa[8][4] = new CasillaGenerica("\u001B[31m ⇩ \u001B[0m", true, 20, true, null);
        }
        jugadorPosicion = new int[] { 7, 4 };
    }

    public boolean estadoCasilla(Boolean jugador) {
        return vencido;
    }

    public String getMedallaNombre() {
        if (npc instanceof LiderDeGimnasio) {
            return ((LiderDeGimnasio) npc).getMedalla();
        }
        return null;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

}
