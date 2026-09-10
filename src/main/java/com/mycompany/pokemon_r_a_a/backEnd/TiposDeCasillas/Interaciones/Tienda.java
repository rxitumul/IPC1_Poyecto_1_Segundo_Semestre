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
        nombre = "Tienda";
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
        this.salida = false;
        this.mov = new MovimientoJugador();
        String movimientoJugador;
        impresor.limpiadorPantalla();

        do {

            Casillas casillaAnterior = mov.getCasillaAnterior();
            if (casillaAnterior.tipoCasilla() == 17) {
                impresor.imprimidorDeMapaConInteracionTienda(mapa, nombre, npc, true);

            } else {
                impresor.imprimidorDeMapaConInteracionTienda(mapa, nombre, npc, false);
            }
            movimientoJugador = scan.nextLine();

            if (casillaAnterior.tipoCasilla() == 17 && movimientoJugador.trim().equalsIgnoreCase("C")) {
                casillaAnterior.subMenu();
            } else {
                movimiento(mov, movimientoJugador);

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
