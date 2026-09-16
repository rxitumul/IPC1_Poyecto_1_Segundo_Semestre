package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeSelecion;

public class Mochila  implements Serializable {
    private transient ImpresorDeSelecion impresorDeSelecion;
    private transient Scanner scanner;

    private int pokebola;
    private int pocion;
    private int superPocion;
    private int antidoto;
    private int antiParalisis;
    private int restauraTodo;

    public Mochila(Scanner scanner) {
        this.scanner = scanner;
        restauraTodo = 0;
        antiParalisis = 0;
        antidoto = 0;
        superPocion = 0;
        pocion = 1;
        pokebola = 5;
        impresorDeSelecion = new ImpresorDeSelecion();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
         // Esto carga todo lo normal (vida, medallas, pokemons...)
        this.scanner = new Scanner(System.in);
        this.impresorDeSelecion = new ImpresorDeSelecion();
    }
    public void aplicacionObjetos(Pokemons aplicacion, int tipo) {

        switch (tipo) {
            case 1:
                if (antiParalisis > 0) {
                    aplicacion.eliminarEstado("Paralizado");
                    antiParalisis--;
                    impresorDeSelecion.mensajeInformativo("¡Parálisis curada!");
                }
                break;
            case 2:
                if (antidoto > 0) {
                    aplicacion.eliminarEstado("Envenenado");
                    antidoto--;
                    impresorDeSelecion.mensajeInformativo("¡Veneno curado!");
                }
                break;
            case 3:
                if (pocion > 0) {
                    restaurarVidaPociones(aplicacion, 20);
                    pocion--;
                }
                break;
            case 5:
                if (restauraTodo > 0) {
                    aplicacion.lipiarEstadosTodos();
                    aplicacion.restauradorArtibutos();
                    restauraTodo--;
                    impresorDeSelecion.mensajeInformativo("¡Pokémon completamente restaurado!");
                }
                break;
            case 6:
                if (superPocion > 0) {
                    restaurarVidaPociones(aplicacion, 50);
                    superPocion--;
                }
                break;
        }
    }

    public boolean tieneObjeto(int tipo) {
        switch (tipo) {
            case 1:
                return antiParalisis > 0;
            case 2:
                return antidoto > 0;
            case 3:
                return pocion > 0;
            case 4:
                return pokebola > 0;
            case 5:
                return restauraTodo > 0;
            case 6:
                return superPocion > 0;
            default:
                return false;
        }
    }



    private void restaurarVidaPociones(Pokemons aplicacion, int curacion) {
        int vida = aplicacion.getVidaPokemon();
        int vidaMaxima = aplicacion.getVidaInicial();
        vida += curacion;
        if (vida > vidaMaxima) {
            aplicacion.setVidaPokemon(vidaMaxima);
        } else {
            aplicacion.setVidaPokemon(vida);
        }
        impresorDeSelecion.mensajeInformativo("¡Salud restaurada! HP: " + aplicacion.getVidaPokemon() + "/" + vidaMaxima);
    }

    public int getAntiParalisis() {
        return antiParalisis;
    }

    public int getAntidoto() {
        return antidoto;
    }

    public int getPocion() {
        return pocion;
    }

    public int getPokebola() {
        return pokebola;
    }

    public int getRestauraTodo() {
        return restauraTodo;
    }

    public int getSuperPocion() {
        return superPocion;
    }

    public void setAntiParalisis(int antiParalisis) {
        this.antiParalisis = antiParalisis;
    }

    public void setAntidoto(int antidoto) {
        this.antidoto = antidoto;
    }

    public void setPocion(int pocion) {
        this.pocion = pocion;
    }

    public void setPokebola(int pokebola) {
        this.pokebola = pokebola;
    }

    public void setRestauraTodo(int restauraTodo) {
        this.restauraTodo = restauraTodo;
    }

    public void setSuperPocion(int superPocion) {
        this.superPocion = superPocion;
    }

    public void menuInicialMochila() {
        do {
            try {
                impresorDeSelecion.impresorMochila(this);
                int selecion = Integer.parseInt(scanner.nextLine());
                if (selecion == 0) {
                    break;
                }
                if (selecion == 1) {
                    impresorDeSelecion.mensajeInformativo("¡Las Pokébolas solo pueden usarse durante una batalla con un Pokémon salvaje!");
                }
            } catch (NumberFormatException e) {
                break;
            }
        } while (true);
    }

}
