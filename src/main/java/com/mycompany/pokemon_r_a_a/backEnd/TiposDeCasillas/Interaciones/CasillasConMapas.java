package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorMapas;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.EstadoPokemonEquipo;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Npc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.movimiento.MovimientoJugador;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeMapas;

@SuppressWarnings("rawtypes")

public abstract class CasillasConMapas extends Casillas<JugadorPokemonPartida> {

    protected boolean salida = false;
    protected String nombre;
    protected EstadoPokemonEquipo equipoEstado;
    protected Mochila mochilaLocal;
    protected Pokedex pokedexLocal;
    protected MapaCiudad[] mapaCiudadesLocal;
    protected int[] jugadorPosicion;
    protected Npc npc;

    protected transient ImpresorDeMapas impresor;
    protected transient Scanner scan;
    protected transient MovimientoJugador mov;
    protected transient CreadorMapas mapaCreador;

    public CasillasConMapas(HallDeLaFama hall, Casillas[][] mapa) {
        super(hall);
        this.jugadorPosicion = new int[] { 10, 5 };
        this.mapa = mapa;
        if (jugador != null) {
            mochilaLocal = jugador.getMochilaJugador();
            equipoEstado = jugador.getEquipoEstado();
            pokedexLocal = jugador.getPokedexJugador();
            mapaCiudadesLocal = jugador.getMapaCiudadesLocal();
        }
        impresor = new ImpresorDeMapas();
        mapaCreador = new CreadorMapas(hall);
        scan = new Scanner(System.in);
        mov = new MovimientoJugador();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        impresor = new ImpresorDeMapas();
        mapaCreador = new CreadorMapas(hall);
        scan = new Scanner(System.in);
        mov = new MovimientoJugador();
    }

    @Override
    public void setjugador(JugadorPokemonPartida jugador) {
        super.setjugador(jugador);
        if (jugador != null) {
            this.mochilaLocal = jugador.getMochilaJugador();
            this.equipoEstado = jugador.getEquipoEstado();
            this.pokedexLocal = jugador.getPokedexJugador();
            this.mapaCiudadesLocal = jugador.getMapaCiudadesLocal();
        }
    }

    protected MovimientoJugador movimiento(MovimientoJugador mov, String movimientoJugador) {
        if (movimientoJugador.equalsIgnoreCase("W") || movimientoJugador.equalsIgnoreCase("S")
                || movimientoJugador.equalsIgnoreCase("A")
                || movimientoJugador.equalsIgnoreCase("D")) {
            mapa = mov.movimiento(jugadorPosicion, mapa, movimientoJugador, jugador, false);
            jugadorPosicion = mov.getSpawn();
            salida = mov.getCondicionSalida();
        } else if (movimientoJugador.equalsIgnoreCase("M")) {
            mochilaLocal.menuInicialMochila();
        } else if (movimientoJugador.equalsIgnoreCase("P")) {
            equipoEstado.menuInicial();
        } else if (movimientoJugador.equalsIgnoreCase("T")) {
            pokedexLocal.pokedexMenu();
        } else if (movimientoJugador.equalsIgnoreCase("F")) {
            jugador.perfil(mapaCiudadesLocal);
        } else {
            impresor.pantallaDeError();
        }
        return mov;
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
