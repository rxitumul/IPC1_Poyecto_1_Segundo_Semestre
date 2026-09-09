package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.LiderDeGimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class Gimnasio extends CasillasConMapas {

    private Entrenador[] entrenador;
    private String nombreCiudad;
    private int[] posicionInicial = new int[2];
    private boolean vencido;

    public Gimnasio(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall,
            Casillas[][] mapaGimnasio, String nombreCiudad) {
        super(hall, mapaGimnasio);
        this.simbolo = simbolo;
        entrenador = new Entrenador[2];
        this.nombreCiudad = nombreCiudad;
        nombre = "Gimnasio de " + nombreCiudad;
        entrenador[0] = new Entrenador(nombreCiudad);
        entrenador[1] = new Entrenador(nombreCiudad);
        npc = new LiderDeGimnasio(nombreCiudad);
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
        this.jugadorPosicion = new int[] { 7, 4 };

        posicionInicial = jugadorPosicion;
    }

    @Override
    public void imprimir() {
        System.out.print(" G ");
    }

    @Override
    public Boolean subMenu() {
        boolean salida = false;
        String movimientoJugador;
        vencido = false;
        impresor.limpiadorPantalla();

        do {

            Casillas casillaAnterior = mov.getCasillaAnterior();
            if (casillaAnterior.tipoCasilla() == 15 || casillaAnterior.tipoCasilla() == 15) {
                impresor.imprimidorDeMapaConInteracionGimnacio(mapa, nombre, entrenador, npc, true);

            } else {
                impresor.imprimidorDeMapaConInteracionGimnacio(mapa, nombre, entrenador, npc, false);
            }
            movimientoJugador = scan.nextLine();
            if (casillaAnterior.tipoCasilla() == 15 && movimientoJugador.trim().equalsIgnoreCase("C")) {
                casillaAnterior.subMenu();
            } else {

                if (movimientoJugador.equalsIgnoreCase("W") || movimientoJugador.equalsIgnoreCase("S")
                        || movimientoJugador.equalsIgnoreCase("A")
                        || movimientoJugador.equalsIgnoreCase("D")) {
                    mapa = mov.movimiento(jugadorPosicion, mapa, movimientoJugador, jugador, false);
                    jugadorPosicion = mov.getSpawn();
                    salida = mov.getCondicionSalida();
                    vencido = jugador.getVencido();
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
            }
            if (vencido) {
                jugadorPosicion = posicionInicial;
                break;
            }
            impresor.limpiadorPantalla();

        } while (!salida);

        return true;
    }

    @Override
    public void setMapa() {
        if (mapa == null) {
            Entrenador[] lista = mapaCreador.getNpcCreador()
                    .creadorDeEntrenadoresYLider(jugador.getPokemosEquipo(), nombreCiudad);
            this.entrenador = new Entrenador[3];
            for (int i = 0; i < 3; i++) {
                this.entrenador[i] = lista[i];
                // this.entrenador[i].setBoleanoActivo(true);
            }
            this.npc = lista[3];
            mapa = mapaCreador.getMapaGimnasio(lista, nombreCiudad);
        }
        jugadorPosicion = new int[] { 10, 5 };
    }

    public boolean estadoCasilla(Boolean jugador) {
        return vencido;
    }

}
