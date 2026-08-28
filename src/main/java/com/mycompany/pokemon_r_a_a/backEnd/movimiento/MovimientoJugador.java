package com.mycompany.pokemon_r_a_a.backEnd.movimiento;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Espacio;

public class MovimientoJugador {
    private int[] spawn;
    private Casillas casillaAnterior = new Espacio();

    public Casillas[][] movimiento(int[] spawnE, Casillas[][] mapa, String movimiento) {
        spawn = spawnE;
        switch (movimiento.toLowerCase()) {
            case "w":
                mapa = cambioJugador(mapa, "y", -1);
                break;
            case "a":
                mapa = cambioJugador(mapa, "x", -1);
                break;
            case "s":
                mapa = cambioJugador(mapa, "y", 1);
                break;
            case "d":
                mapa = cambioJugador(mapa, "x", 1);
                break;
            default:
                System.out.println("ingresa una tecla de movimiento valida (W, A, S, D)");
                break;
        }
        return mapa;
    }

    private Casillas[][] cambioJugador(Casillas[][] mapa, String mov, int movI) {
        int movimientoX = spawn[1] + movI;
        int movimientoY = spawn[0] + movI;
        AccionDeMovimiento acion = new AccionDeMovimiento(spawn, casillaAnterior);

        if (mov.equals("x")) {
            if (movimientoX < 25 && movimientoX > -1) {
                mapa = acion.movEstado(mapa, spawn[0], movimientoX, true);
            } else {
                System.out.println("llego al fin del mapa");
            }
        } else {
            if (movimientoY < 25 && movimientoY > -1) {
                mapa = acion.movEstado(mapa, movimientoY, spawn[1], false);
            } else {
                System.out.println("llego al fin del mapa");
            }
        }
        return mapa;
    }

    public int[] getSpawn() {
        return spawn;
    }
}
