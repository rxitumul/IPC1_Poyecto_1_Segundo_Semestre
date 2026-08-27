
package com.mycompany.pokemon_r_a_a.frontEnd.impresores;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.ListaDeBuff.Objetos;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Jugador;
import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

public class ImpresorDeMapas {

    private Pokemons[] equiposLocaal = new Pokemons[5];
    private Pokedex pokedexLocal = new Pokedex();
    private JugadorPokemonPartida jugadorLocal = new JugadorPokemonPartida();
    private Mochila mochilaLocal = new Mochila();

    private ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();

    public void setValores(Pokedex pokedex, JugadorPokemonPartida jugador, Mochila mochila) {
        pokedexLocal = pokedex;
        jugadorLocal = jugador;
        mochilaLocal = mochila;
    }

    public void limpiadorPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void imprimirMapaObjetos(Casillas[][] mapa, Pokemons[] pokemonE, Objetos[] objetos) {
        confi.separadorInicioMapa();

        for (Casillas[] casillas : mapa) {
            System.out.print(confi.getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println(confi.getMarcoVertical());
        }

        confi.separadorFinalMapa();
    }
}
