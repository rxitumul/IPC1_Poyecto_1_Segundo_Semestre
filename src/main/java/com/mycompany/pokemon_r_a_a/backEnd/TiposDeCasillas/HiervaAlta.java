package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;

import java.io.IOException;
import java.io.ObjectInputStream;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class HiervaAlta extends Casillas<Pokemons> {

    private DatosPokemon datos;

    public HiervaAlta(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall) {
        super(hall);
        this.simbolo = simbolo;
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
        datos = new DatosPokemon();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        datos = new DatosPokemon();
    }

    public Pokemons accionCasilla(JugadorPokemonPartida jugador) {
        Pokemons[] jugadorGrupo = jugador.getPokemosEquipo();
        if (random.nextDouble() < 0.15) {
            Pokemons pokemonSalvaje = datos.pokemonRandom(jugadorGrupo, "SALVAJE");
            batalla.pokemonPeleaHierva(jugador, pokemonSalvaje);

        }
        return null;

    }

    @Override
    public void imprimir() {
        System.out.print(simbolo);
    }

    @Override
    public boolean caminable() {
        return caminable;
    }

    @Override
    public int tipoCasilla() {
        return tipo;
    }

    @Override
    public Boolean subMenu() {
        return tieneSubMenu;
    }

    @Override
    public void setMapa() {
    }

    @Override
    public boolean getEstadoDeGruppo() {
        return false;
    }

}
