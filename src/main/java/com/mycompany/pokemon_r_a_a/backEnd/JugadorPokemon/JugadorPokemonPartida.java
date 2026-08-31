package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.CapturaPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeSelecion;

public class JugadorPokemonPartida {
    private String nombre;
    private int pokemonedas;
    private int[] medallasObtenidas = { 0, 0, 0 };
    private Scanner scanner;
    private Mochila mochilaJugador;
    private Pokemons[] pokemosEquipo;
    private Pokedex pokedexJugador;
    private ImpresorDeSelecion impresorDeSelecion = new ImpresorDeSelecion();
    private CapturaPokemon captura = new CapturaPokemon();
    private boolean capturaExitosa;

    public void acionJugador(int opcion, int pokemonJugando, int selecion, Pokemons enemigo) {
        switch (opcion) {
            case 1:
                if (pokemosEquipo != null && pokemonJugando >= 0 && pokemonJugando < pokemosEquipo.length
                        && pokemosEquipo[pokemonJugando] != null) {
                    Movimiento[] movimientos = pokemosEquipo[pokemonJugando].getMovimientos();
                    if (movimientos != null && selecion >= 0 && selecion < movimientos.length
                            && movimientos[selecion] != null) {
                        movimientos[selecion].setpokemonAtacado(enemigo);
                        movimientos[selecion].ataque();
                    }
                }
                break;
            case 2:
                if (selecion == 4) {
                    int pokembola = mochilaJugador.getPokebola();
                    if (pokembola > 0) {
                        capturaExitosa = captura.captura(enemigo, this);
                        mochilaJugador.setPokebola(pokembola - 1);
                    }
                } else {
                    if (pokemosEquipo != null && pokemonJugando >= 0 && pokemonJugando < pokemosEquipo.length
                            && pokemosEquipo[pokemonJugando] != null) {
                        mochilaJugador.aplicacionObjetos(pokemosEquipo[pokemonJugando], selecion);
                    }
                }
                break;
        }

    }

    public JugadorPokemonPartida(Scanner scanner) {
        pokemonedas = 1000;
        this.scanner = scanner;
    }

    public boolean tienePokemonVivos() {
        if (pokemosEquipo == null) {
            return false;
        }
        for (Pokemons p : pokemosEquipo) {
            if (p != null && p.getVidaPokemon() > 0) {
                return true;
            }
        }
        return false;
    }

    public int getPrimerPokemonVivoIndice() {
        if (pokemosEquipo == null) {
            return -1;
        }
        for (int i = 0; i < pokemosEquipo.length; i++) {
            if (pokemosEquipo[i] != null && pokemosEquipo[i].getVidaPokemon() > 0) {
                return i;
            }
        }
        return -1;
    }

    public Pokedex getPokedexJugador() {
        return pokedexJugador;
    }

    public Mochila getMochilaJugador() {
        return mochilaJugador;
    }

    public int[] getMedallasObtenidas() {
        return medallasObtenidas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPokemonedas() {
        return pokemonedas;
    }

    public boolean getCaptura() {
        return capturaExitosa;
    }

    public Pokemons[] getPokemosEquipo() {
        return pokemosEquipo;
    }

    public void setPokemosEquipo(Pokemons[] pokemosEquipo) {
        this.pokemosEquipo = pokemosEquipo;
    }

    public void setMedallasObtenidas(int[] medallasObtenidas) {
        this.medallasObtenidas = medallasObtenidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPokemonedas(int pokemonedas) {
        this.pokemonedas = pokemonedas;
    }

    public void setMochilaJugador(Mochila mochilaJugador) {
        this.mochilaJugador = mochilaJugador;
    }

    public void setPokedexJugador(Pokedex pokedexJugador) {
        this.pokedexJugador = pokedexJugador;
    }

    public void perfil(MapaCiudad[] mapaCiudadesLocal) {
        impresorDeSelecion.impresorDeEstadoJugador(this, mapaCiudadesLocal);
        scanner.nextLine();
    }

}
