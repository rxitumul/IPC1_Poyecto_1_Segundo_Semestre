package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

import java.io.Serializable;

public abstract class Npc<T> implements Serializable {

    protected int id;
    protected String nombre;
    protected boolean boleanoActivo;
    protected int ciudad;
    protected String[] dialojo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public int getCiudad() {
        return ciudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void accion();

    public abstract String[] getDialojo(int tipo);

    public abstract void setBoleanoActivo(boolean boleanoActivo);

    public abstract boolean getbBleanoActivo();

    public abstract T[] getLista();

    public abstract void setLista(T[] pokemosEquipo);
}
