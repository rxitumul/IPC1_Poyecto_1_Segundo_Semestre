package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

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

    @Override
    public Pokemons accionCasilla() {
        double prob = random.nextDouble();
        if (prob > 0.15) {
            return datos.pokemonRandom(0,1);
        }
        return null;
    }

}
