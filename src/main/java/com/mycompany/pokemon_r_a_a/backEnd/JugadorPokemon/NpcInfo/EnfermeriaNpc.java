package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class EnfermeriaNpc extends Npc<Pokemons> {

    private Pokemons[] pokemosEquipo;

     @Override
    public void accion() {
        if (boleanoActivo){
            for (Pokemons pokemons : pokemosEquipo) {
                pokemons.restauradorArtibutos();
                pokemons.lipiarEstadosTodos();
            }
        }
    }

     @Override
    public String[] getDialojo(int tipo) {
        // TODO Auto-generated method stub
        switch (tipo) {
            case 0:
                return new String[] {
                        "¡Hola! Bienvenido al Centro Pokémon.",
                        "¿Quieres que revise a tus Pokémon?" };
            case 1:
                return new String[] {
                        "¡Perfecto! Dame un momento...",
                        "¡Listo! Tus Pokémon están completamente recuperados.","¡Cuídalos mucho y buena suerte en tu aventura!" };
            default:
                return new String[] {
                        "Tus Pokémon están en perfecto estado.",
                        "¡Puedes continuar tu aventura!" };
        }
    }

    @Override
    public void setBoleanoActivo(boolean boleanoActivo) {
        this.boleanoActivo = boleanoActivo;
    }

    @Override
    public boolean getbBleanoActivo() {
        return boleanoActivo;
    }

    @Override
    public Pokemons[] getLista() {
        return pokemosEquipo;
    }

    @Override
    public void setLista(Pokemons[] pokemosEquipo) {
        this.pokemosEquipo = pokemosEquipo;
    }

}
