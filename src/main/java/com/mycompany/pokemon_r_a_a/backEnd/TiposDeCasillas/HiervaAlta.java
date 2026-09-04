package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class HiervaAlta extends Casillas<Pokemons> {

    private DatosPokemon datos = new DatosPokemon();

    public HiervaAlta(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall) {
        super(hall);
        this.simbolo = simbolo;
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
    }
    
    public Pokemons accionCasilla(JugadorPokemonPartida jugador) {
        Pokemons[] jugadorGrupo = jugador.getPokemosEquipo();
        int nivelEquipo = 0;
        if (random.nextDouble() > 0.15) {
            for (Pokemons pokemons : jugadorGrupo) {
                if (pokemons != null) {
                    int nivelPokemon = pokemons.getNivel();
                    if (nivelEquipo < nivelPokemon) {
                        nivelEquipo = nivelPokemon;
                    }

                }
            }
            Pokemons pokemonSalvaje = datos.pokemonRandom(nivelEquipo, 1);
            batalla.pokemonPeleaHierva(jugador, pokemonSalvaje);

        }
        return null;

    }


    @Override
    public void imprimir() {
        System.out.print(simbolo);
    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
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
