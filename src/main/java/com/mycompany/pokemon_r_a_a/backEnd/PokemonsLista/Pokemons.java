package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;

public class Pokemons {
    private Movimiento[] movimientosPokemonLocal;
    private String nombreLocal;
    private String apodo;
    private int vida;
    private int defensa;
    private int ataque;
    private int velocidad;
    private int id;

    public void setNombre(String nombre) {
        nombreLocal = nombre;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public String getApodo() {
        return apodo;
    }

}
