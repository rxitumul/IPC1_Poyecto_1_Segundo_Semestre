package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;

public class Pokemons {
    private String nombreLocal;
    private Movimiento[] movimientosPokemonLocal;
    private int vida;
    private int defensa;
    private int ataque;
    private int velocidad;

    public void setNombre(String nombre) {
        nombreLocal = nombre;
    }

    public void setMovimientos(Movimiento[] movimientosPokemon) {
        movimientosPokemonLocal = movimientosPokemon;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setStatus(int[] status) {
        if (status != null && status.length >= 4) {
            this.vida = status[0];
            this.ataque = status[1];
            this.defensa = status[2];
            this.velocidad = status[3];
        }
    }

    public int[] getStatus() {
        return new int[]{ vida, ataque, defensa, velocidad };
    }

    public String getNombre() {
        return nombreLocal;
    }

    public Movimiento[] getMovimientos() {
        return movimientosPokemonLocal;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getVida() {
        return vida;
    }

}
