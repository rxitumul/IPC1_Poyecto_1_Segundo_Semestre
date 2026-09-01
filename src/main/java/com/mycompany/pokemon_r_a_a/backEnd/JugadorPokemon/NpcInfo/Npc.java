package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

public abstract class Npc<T> {

    protected String nombre;
    protected boolean boleanoActivo;
    protected int ciudad;

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

    public void accion() {
    }

    public abstract void setBoleanoActivo(boolean boleanoActivo);

    public abstract boolean getbBleanoActivo();

    public abstract T[] getLista();

    public abstract void setLista(T[] pokemosEquipo);
}
