package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class Farmacia extends CasillasConMapas {

    public Farmacia(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaFarmacia) {
        super(hall, mapaFarmacia);
        npc = new EnfermeriaNpc();
        nombre = "Farmacia";
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
            Casillas casillaAnterior = mov.getCasillaAnterior();
            if (casillaAnterior.tipoCasilla() == 16) {
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, true, true);

            } else if (casillaAnterior.tipoCasilla() == 18) {
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, true, false);

            } else {
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, false, true);
            }
            movimientoJugador = scan.nextLine();
            if (casillaAnterior.tipoCasilla() == 18
                    || casillaAnterior.tipoCasilla() == 16 && movimientoJugador.trim().equalsIgnoreCase("C")) {
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
            EnfermeriaNpc enfermera = mapaCreador.getNpcCreador().creadorDeEnfermeria();
            this.npc = enfermera;
            mapa = mapaCreador.getMapaCentroPokemon(enfermera);
        }
        jugadorPosicion = new int[] { 8, 4 };
    }

}
