package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class Farmacia extends CasillasConMapas {

    public Farmacia(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaFarmacia) {
        super(hall, mapaFarmacia);
        npc = new EnfermeriaNpc();
        this.simbolo = simbolo;
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
        this.jugadorPosicion = new int[] { 8, 4 };
    }

    @Override
    public void imprimir() {
        System.out.print(" ⚕ ");
    }

    @Override
    public Boolean subMenu() {
        boolean salida = false;
        String movimientoJugador;
        impresor.limpiadorPantalla();

        do {
            impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, false);
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
            mapa= mapaCreador.getMapaCentroPokemon();
        }
        jugadorPosicion = new int[] { 8, 4 };
    }

}
