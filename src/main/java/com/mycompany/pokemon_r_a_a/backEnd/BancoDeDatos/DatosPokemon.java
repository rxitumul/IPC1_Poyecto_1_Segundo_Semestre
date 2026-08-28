package com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.Descanso;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.DisparoDemora;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.Drenadoras;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.Fortaleza;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.Grunido;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.Latigo;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.Proteccion;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientoDeEstado.Supersonico;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.AnilloIgneo;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Atactrueno;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.AtaqueAla;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.AtaqueFuria;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.AtaqueRápido;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.DobleFilo;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.GiroFuego;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.GorroFuego;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Hidrocanon;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.HojaAfilada;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Impactrueno;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Lanzallamas;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Mordisco;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Picotazo;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.PicotazoVenenoso;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Placaje;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Rayo;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.RayoBurbuja;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.RayoSolar;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos.Vuelo;

public class DatosPokemon {

    private Random random = new Random();

    private final String[] nombrePokemon = { "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
            "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
            "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu" };

    private final Movimiento[][] movimientosPokemon = { 
            { new Placaje(), new Grunido(), new HojaAfilada() },
            { new Descanso(), new Drenadoras(), new HojaAfilada() },
            { new Drenadoras(), new HojaAfilada(), new RayoSolar() }, 
            { new Placaje(), new Grunido(), new GiroFuego() },
            { new DobleFilo(), new GiroFuego(), new Lanzallamas() },
            { new GorroFuego(), new Lanzallamas(), new AnilloIgneo() },
            { new Placaje(), new Latigo(), new RayoBurbuja() }, 
            { new Mordisco(), new Proteccion(), new RayoBurbuja() },
            { new Mordisco(), new RayoBurbuja(), new Hidrocanon() }, 
            { new Placaje(), new DisparoDemora() },
            { new Fortaleza() }, 
            { new DisparoDemora(), new Fortaleza(), new Supersonico() },
            { new PicotazoVenenoso(), new DisparoDemora() }, 
            { new Fortaleza() },
            { new AtaqueFuria(), new Fortaleza(), new Picotazo() }, 
            { new Placaje(), new Grunido() },
            { new Placaje(), new Grunido(), new AtaqueAla() }, 
            { new Vuelo(), new AtaqueAla(), new DobleFilo() },
            { new Placaje(), new AtaqueRápido(), new Latigo() }, 
            { new Mordisco(), new Descanso() },
            { new Placaje(), new Grunido(), new AtaqueFuria() }, 
            { new AtaqueAla(), new Picotazo(), new DobleFilo() },
            { new Placaje(), new PicotazoVenenoso(), new Mordisco() }, 
            { new PicotazoVenenoso(), new Mordisco() },
            { new Impactrueno(), new Atactrueno(), new Rayo() } 
    };

    private final int[] saludPokemon = {
            30, 40, 50,
            30, 40, 50,
            30, 40, 50,
            30, 30, 40,
            30, 30, 40,
            30, 40, 50,
            20, 40, 30,
            40, 30, 40,
            30
    };

    private final int[] ataquePokemon = {
            30, 40, 50,
            40, 40, 50,
            30, 40, 50,
            20, 20, 30,
            30, 20, 60,
            30, 40, 50,
            40, 50, 40,
            50, 40, 60,
            40
    };

    private final int[] defensaPokemon = {
            30, 40, 50,
            30, 40, 50,
            40, 50, 60,
            30, 40, 30,
            20, 50, 30,
            30, 40, 50,
            20, 40, 30,
            40, 30, 50,
            30
    };

    private final int[] velocidadPokemon = {
            30, 40, 50,
            40, 50, 60,
            30, 40, 50,
            40, 30, 50,
            50, 40, 60,
            40, 50, 60,
            60, 50, 50,
            60, 50, 50,
            60
    };

    public Pokemons pokemon() {
        Pokemons pokemon = new Pokemons();
        int numeroSeleccionado = random.nextInt(nombrePokemon.length);
        pokemon.setNombre(nombrePokemon[numeroSeleccionado]);
        pokemon.setMovimientos(movimientosPokemon[numeroSeleccionado]);
        pokemon.setVida(saludPokemon[numeroSeleccionado]);
        pokemon.setAtaque(ataquePokemon[numeroSeleccionado]);
        pokemon.setDefensa(defensaPokemon[numeroSeleccionado]);
        pokemon.setVelocidad(velocidadPokemon[numeroSeleccionado]);
        return pokemon;
    }

    public Pokemons pokemonIniciales(int inicial) {
        Pokemons pokemon = new Pokemons();
        int indice;
        switch (inicial) {
            case 1:
                indice = 0;
                break;
            case 2:
                indice = 6;
                break;
            default:
                indice = 3;
                break;
        }
        pokemon.setNombre(nombrePokemon[indice]);
        pokemon.setMovimientos(movimientosPokemon[indice]);
        pokemon.setVida(saludPokemon[indice]);
        pokemon.setAtaque(ataquePokemon[indice]);
        pokemon.setDefensa(defensaPokemon[indice]);
        pokemon.setVelocidad(velocidadPokemon[indice]);
        return pokemon;
    }

    public Pokemons[] creadorPokedesData() {
        Pokemons[] pokedex = new Pokemons[nombrePokemon.length];
        for (int i = 0; i < nombrePokemon.length; i++) {
            pokedex[i] = new Pokemons();
            pokedex[i].setNombre(nombrePokemon[i]);
            pokedex[i].setVida(saludPokemon[i]);
            pokedex[i].setAtaque(ataquePokemon[i]);
            pokedex[i].setDefensa(defensaPokemon[i]);
            pokedex[i].setVelocidad(velocidadPokemon[i]);
            pokedex[i].setMovimientos(movimientosPokemon[i]);
        }
        return pokedex;
    }

    public String[] getNombrePokemon() {
        return nombrePokemon;
    }

    public Movimiento[][] getMovimientosPokemon() {
        return movimientosPokemon;
    }

    public int[] getSaludPokemon() {
        return saludPokemon;
    }

    public int[] getAtaquePokemon() {
        return ataquePokemon;
    }

    public int[] getDefensaPokemon() {
        return defensaPokemon;
    }

    public int[] getVelocidadPokemon() {
        return velocidadPokemon;
    }
}
