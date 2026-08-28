
package com.mycompany.pokemon_r_a_a.frontEnd.impresores;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Pokedex;
import com.mycompany.pokemon_r_a_a.backEnd.ListaDeBuff.Objetos;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

public class ImpresorDeMapas {

    private Pokemons[] equiposLocaal;
    private Pokedex pokedexLocal;
    private JugadorPokemonPartida jugadorLocal;
    private Mochila mochilaLocal;

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

    public void imprimirMapaObjetos(Casillas[][] mapa, String nombre) {
        confi.separadorInicioMapa();
        System.out.println(confi.formatearMapa("Ciudad " + nombre));
        confi.separadorMediosMapa();
        for (Casillas[] casillas : mapa) {
            System.out.print(confi.getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println(confi.getMarcoVertical());
        }
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("CONTROLES"));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("    ┌───┐      "));
        System.out.println(confi.formatearMapa("    │ W │      M → Mochila       N → Mapa          X → Salir"));
        System.out.println(confi.formatearMapa("┌───┼───┼───┐"));
        System.out.println(confi.formatearMapa("│ A │ S │ D │  P → Pokémon       T → Pokédex       F → Perfil"));
        System.out.println(confi.formatearMapa("└───┴───┴───┘"));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("OBJETOS DEL MAPA"));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("■ Murro   ✚ Centro Pokémon   G Gimnasio   $ Tienda   ⌂ Casa"));
        System.out.println(confi.formatearMapa("♣ Hierba  ☻ NPC              ♠ Árbol      ≈ Agua"));
        confi.separadorMediosMapa();
        System.out.println(confi.formatearMapa("Porfavor selecione una opcion"));
        confi.separadorFinalMapa();
    }
}
