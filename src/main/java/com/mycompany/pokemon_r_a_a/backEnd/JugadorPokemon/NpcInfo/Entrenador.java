package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class Entrenador extends Npc<Pokemons> {

    private Pokemons[] pokemosEquipo;
    private String ciudadNombre="";
    private boolean derrotado = false;

    public Entrenador(String nombreCiudad){
        ciudadNombre=nombreCiudad;
    }
    public boolean isDerrotado() {
        return derrotado;
    }

    public void setDerrotado(boolean derrotado) {
        this.derrotado = derrotado;
    }

    @Override
    public Pokemons[] getLista() {
        return pokemosEquipo;
    }

    @Override
    public void setLista(Pokemons[] pokemosEquipo) {
        this.pokemosEquipo = pokemosEquipo;
    }

    @Override
    public void setBoleanoActivo(boolean esLider) {
        this.boleanoActivo = esLider;
    }

    @Override
    public boolean getbBleanoActivo() {
        return boleanoActivo;
    }

    @Override
    public void accion() {

    }

    @Override
    public String[] getDialojo(int tipo) {
        // TODO Auto-generated method stub
        switch (tipo) {
            case 0:
                return new String[] {
                        "¡Alto ahí, entrenador!",
                        "Este es el gimnasio de "+ciudadNombre+".",
                        "Veamos que tienes para demostrar de qué estás hecho." };
            case 1:
                return new String[] {
                        "¡Entonces prepárate!",
                        "¡Comienza el combate!" };
            case 2:
                return new String[] {
                        "¡Has perdido!",
                        "No te rindas. Puedes volver a intentarlo." };

            default:
                return new String[] {
                        "¡Increíble! Has conseguido derrotarme.",
                        "¡Buena suerte contra el líder del gimnasio!" };
        }
    }

}
