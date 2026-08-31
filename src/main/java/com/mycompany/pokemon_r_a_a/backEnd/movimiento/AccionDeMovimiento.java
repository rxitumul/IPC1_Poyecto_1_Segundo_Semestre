package com.mycompany.pokemon_r_a_a.backEnd.movimiento;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Jugador;
import com.mycompany.pokemon_r_a_a.frontEnd.MensajesDeInformacion;

public class AccionDeMovimiento {
    private MensajesDeInformacion mensaje = new MensajesDeInformacion();
    private int[] spawnLocal;
    private Casillas casillaAnteriorLocal;

    public AccionDeMovimiento(int[] spawn, Casillas casillaAnterior) {
        spawnLocal = spawn;
        casillaAnteriorLocal = casillaAnterior;
    }

    public Casillas getCasillaAnterior() {
        return casillaAnteriorLocal;
    }

    public Casillas[][] movEstado(Casillas[][] mapa, int y, int x, boolean posicionXOY, JugadorPokemonPartida jugador) {
        Casillas casilla = mapa[y][x];
        switch (casilla.tipoCasilla()) {
            case 0:
                // Centro Pokemon
                mensaje.mensajeInformativo("Ingresando al Centro Pokémon...");
                casilla.subMenu();
                break;
            case 1:
                // Gimnasio Pokemon
                mensaje.mensajeInformativo("Ingresando al Gimnasio Pokémon...");
                casilla.subMenu();
                break;
            case 2:
                // Tienda Pokemon
                mensaje.mensajeInformativo("Ingresando a la Tienda Pokémon...");
                casilla.subMenu();
                break;
            case 3:
                // Hierba Alta
                mensaje.mensajeInformativo("Caminando por la Hierba Alta...");
                casilla.subMenu();
                mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                casillaAnteriorLocal = casilla;
                mapa[y][x].accionCasilla(jugador);
                mapa[y][x] = new Jugador();
                if (posicionXOY) {
                    spawnLocal[1] = x;
                } else {
                    spawnLocal[0] = y;
                }
                break;
            case 5:
                // Muro
                mensaje.mensajeInformativo("No puedes pasar, hay un muro.");
                break;
            case 7:
                // Arbol
                mensaje.mensajeInformativo("No puedes pasar, hay un árbol.");
                break;
            case 8:
                // Agua
                mensaje.mensajeInformativo("No puedes pasar, hay agua.");
                break;
            case 9:
                // Casa
                mensaje.mensajeInformativo("No puedes pasar, hay una casa.");
                break;
            default:
                mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                casillaAnteriorLocal = casilla;
                mapa[y][x] = new Jugador();
                if (posicionXOY) {
                    spawnLocal[1] = x;
                } else {
                    spawnLocal[0] = y;
                }
                break;
        }
        return mapa;
    }
}
