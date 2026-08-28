package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

public class Mochila {
    private int pokebola;
    private int pocion;
    private int superPocion;
    private int antidoto;
    private int antiParalisis;
    private int restauraTodo;

    public Mochila() {
        restauraTodo = 0;
        antiParalisis = 0;
        antidoto = 0;
        superPocion = 0;
        pocion = 1;
        pokebola = 5;
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

}
