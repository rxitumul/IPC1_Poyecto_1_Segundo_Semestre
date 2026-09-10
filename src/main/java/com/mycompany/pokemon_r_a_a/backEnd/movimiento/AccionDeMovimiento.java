package com.mycompany.pokemon_r_a_a.backEnd.movimiento;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;
@SuppressWarnings("rawtypes")

public class AccionDeMovimiento {
    private ImpresoresGlobal mensaje = new ImpresoresGlobal();
    private int[] spawnLocal;
    
    private Casillas casillaAnteriorLocal;
    private boolean salida = false;
    private final static String AMARILLO_BRILLANTE = "\u001B[93m";

    private final static String MAGENTA = "\u001B[35m";
    protected final static String RESET = "\u001B[0m";

    public void setSpawn(int[] spawn) {
        spawnLocal = spawn;
    }

    public void setCasillaAnterior( Casillas casillaAnterior) {
        casillaAnteriorLocal = casillaAnterior;
    }

    
    public Casillas getCasillaAnterior() {
        return casillaAnteriorLocal;
    }

    
    public Casillas[][] movEstado( Casillas[][] mapa, int y, int x, boolean posicionXOY, JugadorPokemonPartida jugador) {
        Casillas casilla = mapa[y][x];
        if (casilla.caminable()) {

            switch (casilla.tipoCasilla()) {
                case 3:
                    // Hierba Alta
                    mensaje.mensajeInformativo("Caminando por la Hierba Alta...");
                    casilla.subMenu();
                    mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                    casillaAnteriorLocal = casilla;
                    mapa[y][x].accionCasilla(jugador);
                    mapa[y][x] = new CasillaGenerica(AMARILLO_BRILLANTE + " > " + RESET, true, 4, false, null);
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
                case 15:
                    // Zona de interacción - Entrenador / Líder
                    casilla.setjugador(jugador);
                    mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                    casillaAnteriorLocal = casilla;
                    mapa[y][x] = new CasillaGenerica(MAGENTA + " > " + RESET, true, 4, false, null);
                    if (posicionXOY) {
                        spawnLocal[1] = x;
                    } else {
                        spawnLocal[0] = y;
                    }
                    break;
                case 16:
                    // Zona de interacción - Farmacia
                    casilla.setjugador(jugador);
                    mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                    casillaAnteriorLocal = casilla;
                    mapa[y][x] = new CasillaGenerica(MAGENTA + " > " + RESET, true, 4, false, null);
                    if (posicionXOY) {
                        spawnLocal[1] = x;
                    } else {
                        spawnLocal[0] = y;
                    }
                    break;
                case 17:
                    // Zona de interacción - Tienda
                    casilla.setjugador(jugador);
                    mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                    casillaAnteriorLocal = casilla;
                    mapa[y][x] = new CasillaGenerica(MAGENTA + " > " + RESET, true, 4, false, null);
                    if (posicionXOY) {
                        spawnLocal[1] = x;
                    } else {
                        spawnLocal[0] = y;
                    }
                    break;
                case 18:

                casilla.setjugador(jugador);
                    mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                    casillaAnteriorLocal = casilla;
                    mapa[y][x] = new CasillaGenerica(MAGENTA + " > " + RESET, true, 4, false, null);
                    if (posicionXOY) {
                        spawnLocal[1] = x;
                    } else {
                        spawnLocal[0] = y;
                    }
                    //1
                    
                    break;
                case 20:
                    mensaje.mensajeInformativo("Regresando al exterior...");
                    salida = true;
                    break;

                default:
                    mapa[spawnLocal[0]][spawnLocal[1]] = casillaAnteriorLocal;
                    casillaAnteriorLocal = casilla;
                    mapa[y][x] = new CasillaGenerica(MAGENTA + " > " + RESET, true, 4, false, null);
                    if (posicionXOY) {
                        spawnLocal[1] = x;
                    } else {
                        spawnLocal[0] = y;
                    }
                    break;
            }
        } else {
            switch (casilla.tipoCasilla()) {
                case 6:
                    // Centro Pokemon
                    mensaje.mensajeInformativo("Ingresando al Centro Pokémon...");
                    casilla.setMapa();
                    casilla.setjugador(jugador);
                    casilla.subMenu();
                    break;
                case 1:
                    // Gimnasio Pokemon
                    mensaje.mensajeInformativo("Ingresando al Gimnasio Pokémon...");
                    casilla.setjugador(jugador);
                    casilla.setMapa();
                    casilla.subMenu();
                    break;
                case 2:
                    // Tienda Pokemon
                    mensaje.mensajeInformativo("Ingresando a la Tienda Pokémon...");
                    casilla.setMapa();
                    casilla.setjugador(jugador);
                    casilla.subMenu();
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
                case 19:
                    mensaje.mensajeInformativo("No puedes pasar, hay una mostrador.");
                    break;
            }

        }
        return mapa;
    }

    public boolean getCondicionSalida() {
        return salida;
    }


}
