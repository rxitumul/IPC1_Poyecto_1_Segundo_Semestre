package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Jugador;

public class HiervaAlta extends Casillas {
    private DatosPokemon datos = new DatosPokemon();

    @Override
    public void imprimir() {
        System.out.print(VERDE + " ♧ " + RESET);

    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
        return true;
    }

    @Override
    public int tipoCasilla() {
        return 3;
    }

    @Override
    public Boolean subMenu() {
        return true;
    }

    @Override
    public void setMapa() {
    }

    @Override
    public boolean getEstadoDeGruppo() {
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Boolean accionCasilla(JugadorPokemonPartida jugador) {
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
        return false;
    }

}
