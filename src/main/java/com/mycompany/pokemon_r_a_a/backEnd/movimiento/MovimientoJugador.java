package com.mycompany.pokemon_r_a_a.backEnd.movimiento;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;
@SuppressWarnings("rawtypes")

public class MovimientoJugador {
    private int[] spawn;
    private Casillas casillaAnterior;
    private AccionDeMovimiento acion;
    private ImpresoresGlobal impresor;

    public MovimientoJugador() {
        impresor = new ImpresoresGlobal();
        acion = new AccionDeMovimiento();
        casillaAnterior = new CasillaGenerica("   ", true, 0, false, null);
    }

    public Casillas[][] movimiento(int[] spawnE, Casillas[][] mapa, String movimiento, JugadorPokemonPartida jugador,
            boolean derrota) {
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
                if (derrota) {
                    mapa = cambioJugador(mapa, "x", 0, jugador);
                } else {
                    impresor.mensajeInformativo("ingresa una tecla de movimiento valida (W, A, S, D)");
                }
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
                impresor.mensajeInformativo("llego al fin del mapa");
            }
        } else {
            if (movimientoY < mapa.length && movimientoY > -1) {
                mapa = acion.movEstado(mapa, movimientoY, spawn[1], false, jugador);
                casillaAnterior = acion.getCasillaAnterior();
            } else {
                impresor.mensajeInformativo("llego al fin del mapa");
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

    public void setSpawn(int[] spawn) {
        this.spawn = spawn;
    }

    public Casillas getCasillaAnterior() {
        return casillaAnterior;
    }

    public void setCasillaAnterior(Casillas casillaAnterior) {
        this.casillaAnterior = casillaAnterior;
    }
}
