package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.TiendaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;

public class Tienda extends CasillasConMapas {

    public Tienda(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaTienda) {
        super(hall, mapaTienda);
        npc = new TiendaNpc();
        mov = new MovimientoJugador();
        this.simbolo = simbolo;
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
        this.jugadorPosicion = new int[] { 7, 4 };
    }

    @Override
    public void imprimir() {
        System.out.print(" $ ");
    }



    @Override
    public Boolean subMenu() {
        boolean salida = false;
        String movimientoJugador;
        impresor.limpiadorPantalla();

        do {
            impresor.imprimidorDeMapaConInteracionTienda(mapa, nombre, npc, false);
            movimientoJugador = scan.nextLine();
            mapa = mov.movimiento(jugadorPosicion, mapa, movimientoJugador, jugador);
            jugadorPosicion = mov.getSpawn();
            salida = mov.getCondicionSalida();
            impresor.limpiadorPantalla();

        } while (!salida);

        return true;
    }

    @Override
    public void setMapa() {
        if (mapa == null) {
            mapa = mapaCreador.getMapaTiendaPokemon();
        }
        jugadorPosicion = new int[] { 7, 4 };
    }

    public void setJugadorPosicion(int[] jugadorPosicion) {
        this.jugadorPosicion = jugadorPosicion;
    }



}
