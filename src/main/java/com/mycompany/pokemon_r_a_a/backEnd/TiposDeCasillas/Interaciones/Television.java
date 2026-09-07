package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.TiendaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class Television extends CasillasConMapas {

    public Television(HallDeLaFama hall, Casillas[][] mapa) {
        super(hall, mapa);

    }

    @Override
    public void imprimir() {
        System.out.print(" ▣ ");
    }

    @Override
    public Boolean subMenu() {
        boolean salida = false;
        String movimientoJugador;
        impresor.limpiadorPantalla();

        do {
            Casillas casillaAnterior = mov.getCasillaAnterior();
            if (casillaAnterior.tipoCasilla() == 14) {
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, true, false);

            } else {
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, false, false);
            }
            movimientoJugador = scan.nextLine();
            if (casillaAnterior.tipoCasilla() == 14 && movimientoJugador.trim().equalsIgnoreCase("C")) {
                casillaAnterior.subMenu();
            } else {
                mapa = mov.movimiento(jugadorPosicion, mapa, movimientoJugador, jugador);
                jugadorPosicion = mov.getSpawn();
                salida = mov.getCondicionSalida();
            }

            impresor.limpiadorPantalla();

        } while (!salida);

        return true;
    }

    @Override
    public void setMapa() {
        if (mapa == null) {
            TiendaNpc tiendaNpc = mapaCreador.getNpcCreador().creadorDeTienda();
            this.npc = tiendaNpc;
            mapa = mapaCreador.getMapaTiendaPokemon(tiendaNpc);
        }
        jugadorPosicion = new int[] { 7, 4 };
    }

    public void setJugadorPosicion(int[] jugadorPosicion) {
        this.jugadorPosicion = jugadorPosicion;
    }
}
