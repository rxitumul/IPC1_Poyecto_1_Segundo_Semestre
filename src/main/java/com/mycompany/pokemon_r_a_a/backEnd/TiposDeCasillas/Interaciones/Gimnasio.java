package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.LiderDeGimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionEntrenador;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;
@SuppressWarnings("rawtypes")

public class Gimnasio extends CasillasConMapas {

    private Entrenador[] entrenador;
    private String nombreCiudad;
    private int[] posicionInicial = new int[2];
    private boolean vencido;

    public Gimnasio(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaGimnasio, String nombreCiudad) {
        super(hall, mapaGimnasio);
        this.simbolo = simbolo;
        entrenador = new Entrenador[3];
        this.nombreCiudad = nombreCiudad;
        nombre = "Gimnasio de " + nombreCiudad;
        entrenador[0] = new Entrenador(nombreCiudad);
        entrenador[1] = new Entrenador(nombreCiudad);
        entrenador[2] = new Entrenador(nombreCiudad);
        npc = new LiderDeGimnasio(nombreCiudad);
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
        this.jugadorPosicion = new int[] { 7, 4 };
        this.posicionInicial = new int[] { 7, 4 };
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

            if (casillaAnterior != null && casillaAnterior.tipoCasilla() == 15 && movimientoJugador.trim().equalsIgnoreCase("C")) {
                casillaAnterior.subMenu();
                vencido = jugador != null && jugador.getVencido();
            } else {
                movimiento(mov, movimientoJugador);
                vencido = jugador != null && jugador.getVencido();
            }
            if (vencido) {
                jugadorPosicion = new int[] { posicionInicial[0], posicionInicial[1] };
                break;
            }

        } while (!salida);

        return true;
    }

    @Override
    public void setMapa() {
        if (mapa == null) {
            Entrenador[] lista = mapaCreador.getNpcCreador()
                    .creadorDeEntrenadoresYLider(jugador != null ? jugador.getPokemosEquipo() : null, nombreCiudad);
            this.entrenador = new Entrenador[3];
            for (int i = 0; i < 3; i++) {
                this.entrenador[i] = lista[i];
            }
            this.npc = lista[3];
            mapa = mapaCreador.getMapaGimnasio(lista, nombreCiudad);
        } else {
            // Limpiar cualquier posición previa del jugador y resetear en el spawn
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (mapa[i][j] != null && mapa[i][j].tipoCasilla() == 4) {
                        mapa[i][j] = new CasillaGenerica("   ", true, 0, false, null);
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

}

