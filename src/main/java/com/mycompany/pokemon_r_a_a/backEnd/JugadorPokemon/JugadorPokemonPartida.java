package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.CapturaPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorDeSelecion;

public class JugadorPokemonPartida implements Serializable {
    private transient Scanner scanner;
    private transient ImpresorDeSelecion impresorDeSelecion;
    private transient CapturaPokemon captura;

    // atributos serializables
    private String nombre;
    private int pokemonedas;
    private int[] medallasObtenidas = { 0, 0, 0 };
    private boolean capturaExitosa;
    private int batallasJugadasSalvajes = 0;
    private int batallasJugadasEntrenador = 0;
    private int pokebolasLanzadas = 0;
    private int pokemonCapturados = 0;
    private boolean vencido;

    // Atributos serialisables de clases
    private Mochila mochilaJugador;
    private Pokemons[] pokemosEquipo;
    private Pokedex pokedexJugador;
    private MapaCiudad[] mapaCiudadesLocal;
    private EstadoPokemonEquipo equipoEstado;

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        this.scanner = new Scanner(System.in);
        this.impresorDeSelecion = new ImpresorDeSelecion();
        this.captura = new CapturaPokemon();

        if (this.equipoEstado != null) {
            this.equipoEstado.setJugador(this);
        }
    }

    public JugadorPokemonPartida(Scanner scanner) {
        pokemonedas = 1000;
        vencido = false;
        this.scanner = scanner;
        this.impresorDeSelecion = new ImpresorDeSelecion();
        this.captura = new CapturaPokemon();
    }

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
                        pokebolasLanzadas++;
                        capturaExitosa = captura.captura(enemigo, this);
                        if (capturaExitosa) {
                            pokemonCapturados++;
                        }
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

    public int getBatallasJugadasSalvajes() {
        return batallasJugadasSalvajes;
    }

    public void incrementarBatallasSalvajes() {
        this.batallasJugadasSalvajes++;
    }

    public int getBatallasJugadasEntrenador() {
        return batallasJugadasEntrenador;
    }

    public void incrementarBatallasEntrenador() {
        this.batallasJugadasEntrenador++;
    }

    public int getPokebolasLanzadas() {
        return pokebolasLanzadas;
    }

    public void incrementarPokebolasLanzadas() {
        this.pokebolasLanzadas++;
    }

    public int getPokemonCapturados() {
        return pokemonCapturados;
    }

    public void incrementarPokemonCapturados() {
        this.pokemonCapturados++;
    }

    public int getCantidadPokemonEquipo() {
        if (pokemosEquipo == null) {
            return 0;
        }
        int count = 0;
        for (Pokemons p : pokemosEquipo) {
            if (p != null) {
                count++;
            }
        }
        return count;
    }

    public MapaCiudad[] getMapaCiudadesLocal() {
        return mapaCiudadesLocal;
    }

    public void setMapaCiudadesLocal(MapaCiudad[] mapaCiudadesLocal) {
        this.mapaCiudadesLocal = mapaCiudadesLocal;
    }

    public EstadoPokemonEquipo getEquipoEstado() {
        return equipoEstado;
    }

    public void setEquipoEstado(EstadoPokemonEquipo equipoEstado) {
        this.equipoEstado = equipoEstado;
    }

    public void setVencido(boolean vencido) {
        this.vencido = vencido;
    }

    public boolean getVencido() {
        return vencido;
    }

}
