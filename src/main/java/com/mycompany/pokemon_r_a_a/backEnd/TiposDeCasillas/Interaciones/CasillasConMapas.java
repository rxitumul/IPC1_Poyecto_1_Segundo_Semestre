package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorMapas;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Npc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeMapas;

public abstract class CasillasConMapas extends Casillas<JugadorPokemonPartida> {

    @SuppressWarnings("rawtypes")
    protected Casillas[][] mapa;
    protected String nombre;
    protected ImpresorDeMapas impresor = new ImpresorDeMapas();
    protected Scanner scan = new Scanner(System.in);
    protected MovimientoJugador mov = new MovimientoJugador();
    protected int[] jugadorPosicion;
    protected Npc npc;
    protected CreadorMapas mapaCreador;

    @SuppressWarnings("rawtypes")
    public CasillasConMapas(HallDeLaFama hall, Casillas[][] mapa) {
        super(hall);
        mapaCreador = new CreadorMapas(hall);
        this.jugadorPosicion = new int[] { 10, 5 };
        this.mapa = mapa;
    }

    @Override
    public boolean caminable() {
        return caminable;
    }

    @Override
    public boolean getEstadoDeGruppo() {
        return true;
    }

    @Override
    public int tipoCasilla() {
        return tipo;
    }

}
