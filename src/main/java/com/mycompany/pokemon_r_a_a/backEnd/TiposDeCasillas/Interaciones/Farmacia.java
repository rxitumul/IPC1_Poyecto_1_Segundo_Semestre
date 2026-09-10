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
        this.salida = false;
        this.mov = new com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador();
        String movimientoJugador;
        impresor.limpiadorPantalla();

        do {
            Casillas casillaAnterior = mov.getCasillaAnterior();

            // Mostrar diálogo según la casilla en la que está parado el jugador
            if (casillaAnterior.tipoCasilla() == 16) {
                // Parado sobre casilla de enfermera → mostrar diálogo enfermera
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, true, true);
            } else if (casillaAnterior.tipoCasilla() == 18) {
                // Parado sobre casilla de televisión → mostrar prompt de TV
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, true, false);
            } else {
                impresor.imprimidorDeMapaConInteracioFarmacia(mapa, nombre, npc, false, true);
            }

            movimientoJugador = scan.nextLine();

            // Interacción con NPC (enfermera tipo 16) o TV (tipo 18) → requiere tecla C
            if (movimientoJugador.trim().equalsIgnoreCase("C")
                    && (casillaAnterior.tipoCasilla() == 16 || casillaAnterior.tipoCasilla() == 18)) {
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
            EnfermeriaNpc enfermera = mapaCreador.getNpcCreador().creadorDeEnfermeria();
            this.npc = enfermera;
            mapa = mapaCreador.getMapaCentroPokemon(enfermera);
        }
        jugadorPosicion = new int[] { 8, 4 };
    }

}
