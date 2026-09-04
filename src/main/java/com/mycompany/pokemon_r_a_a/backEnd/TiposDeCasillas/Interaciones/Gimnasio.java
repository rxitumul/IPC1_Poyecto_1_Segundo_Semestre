package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.LiderDeGimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class Gimnasio extends CasillasConMapas {

    private Entrenador[] entrenador;

    public Gimnasio(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaGimnasio) {
        super(hall, mapaGimnasio);
        this.simbolo = simbolo;
        entrenador = new Entrenador[2];
        entrenador[0] = new Entrenador();
        entrenador[1] = new Entrenador();
        npc = new LiderDeGimnasio();
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
        this.jugadorPosicion = new int[] { 10, 5 };
    }

    @Override
    public void imprimir() {
        System.out.print(" G ");
    }



    @Override
    public Boolean subMenu() {
        boolean salida = false;
        String movimientoJugador;
        impresor.limpiadorPantalla();

        do {
            impresor.imprimidorDeMapaConInteracionGimnacio(mapa, nombre, entrenador, npc, false);
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
            mapa = mapaCreador.getMapaGimnasio();
        }
        jugadorPosicion = new int[] { 10, 5 };
    }

}
