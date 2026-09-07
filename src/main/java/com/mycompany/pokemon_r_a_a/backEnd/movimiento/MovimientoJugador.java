package com.mycompany.pokemon_r_a_a.backEnd.movimiento;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class MovimientoJugador {
    private int[] spawn;
    private Casillas casillaAnterior = new CasillaGenerica("   ", true, 6, false, null);
    private AccionDeMovimiento acion = new AccionDeMovimiento();

    public Casillas[][] movimiento(int[] spawnE, Casillas[][] mapa, String movimiento, JugadorPokemonPartida jugador) {
        spawn = spawnE;
        switch (movimiento.toLowerCase()) {
            case "w":
                mapa = cambioJugador(mapa, "y", -1, jugador);
                break;
            case "a":
                mapa = cambioJugador(mapa, "x", -1, jugador);
                break;
            case "s":
                mapa = cambioJugador(mapa, "y", 1, jugador);
                break;
            case "d":
                mapa = cambioJugador(mapa, "x", 1, jugador);
                break;
            default:
                System.out.println("ingresa una tecla de movimiento valida (W, A, S, D)");
                break;
        }
        return mapa;
    }

    private Casillas[][] cambioJugador(Casillas[][] mapa, String mov, int movI, JugadorPokemonPartida jugador) {
        int movimientoX = spawn[1] + movI;
        int movimientoY = spawn[0] + movI;
        acion.setCasillaAnterior(casillaAnterior);
        acion.setSpawn(spawn);
        if (mov.equals("x")) {
            if (movimientoX < mapa[0].length && movimientoX > -1) {
                mapa = acion.movEstado(mapa, spawn[0], movimientoX, true, jugador);
                casillaAnterior = acion.getCasillaAnterior();
            } else {
                System.out.println("llego al fin del mapa");
            }
        } else {
            if (movimientoY < mapa.length && movimientoY > -1) {
                mapa = acion.movEstado(mapa, movimientoY, spawn[1], false, jugador);
                casillaAnterior = acion.getCasillaAnterior();
            } else {
                System.out.println("llego al fin del mapa");
            }
        }
        return mapa;
    }

    public boolean getCondicionSalida() {
        return acion.getCondicionSalida();
    }

    public int[] getSpawn() {
        return spawn;
    }
    public Casillas getCasillaAnterior() {
        return casillaAnterior;
    }
}
