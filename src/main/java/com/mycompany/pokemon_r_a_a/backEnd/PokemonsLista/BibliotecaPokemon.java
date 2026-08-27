package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista;

import java.util.Random;

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

public class BibliotecaPokemon {
    private Random random = new Random();
    private final String[] NOMBRE = { " Bulbasaur", " Ivysaur", "Venusaur", "Charmander", "Charmeleon", "Charizard",
            "Squirtle", "Wartortle", "Blastoise", "Caterpie", "Metapod", "Butterfree", "Weedle", "Kakuna", "Beedrill",
            "Pidgey", "Pidgeotto", "Pidgeot", "Rattata", "Raticate", "Spearow", "Fearow", "Ekans", "Arbok", "Pikachu" };
    private final Movimiento[][] MOVIMIENTOS = { { new Placaje(), new Grunido(), new HojaAfilada() },
            { new Descanso(), new Drenadoras(), new HojaAfilada() },
            { new Drenadoras(), new HojaAfilada(), new RayoSolar() }, { new Placaje(), new Grunido(), new GiroFuego() },
            { new DobleFilo(), new GiroFuego(), new Lanzallamas() },
            { new GorroFuego(), new Lanzallamas(), new AnilloIgneo() },
            { new Placaje(), new Latigo(), new RayoBurbuja() }, { new Mordisco(), new Proteccion(), new RayoBurbuja() },
            { new Mordisco(), new RayoBurbuja(), new Hidrocanon() }, { new Placaje(), new DisparoDemora() },
            { new Fortaleza() }, { new DisparoDemora(), new Fortaleza(), new Supersonico() },
            { new PicotazoVenenoso(), new DisparoDemora() }, { new Fortaleza() },
            { new AtaqueFuria(), new Fortaleza(), new Picotazo() }, { new Placaje(), new Grunido() },
            { new Placaje(), new Grunido(), new AtaqueAla() }, { new Vuelo(), new AtaqueAla(), new DobleFilo() },
            { new Placaje(), new AtaqueRápido(), new Latigo() }, { new Mordisco(), new Descanso() },
            { new Placaje(), new Grunido(), new AtaqueFuria() }, { new AtaqueAla(), new Picotazo(), new DobleFilo() },
            { new Placaje(), new PicotazoVenenoso(), new Mordisco() }, { new PicotazoVenenoso(), new Mordisco() },
            { new Impactrueno(), new Atactrueno(), new Rayo() } };
    private final int[][] STATUS = { { 30, 30, 30, 30 }, { 40, 40, 40, 40 }, { 50, 50, 50, 50 }, { 30, 40, 30, 40 },
            { 40, 40, 40, 50 }, { 50, 50, 50, 60 }, { 30, 30, 40, 30 }, { 40, 40, 50, 40 }, { 50, 50, 60, 50 },
            { 30, 20, 30, 30 }, { 30, 20, 40, 20 }, { 40, 30, 30, 50 }, { 30, 30, 20, 30 }, { 30, 20, 30, 30 },
            { 40, 60, 30, 50 }, { 30, 30, 30, 40 }, { 40, 40, 40, 50 }, { 50, 50, 50, 60 }, { 20, 40, 30, 50 },
            { 40, 50, 40, 60 }, { 30, 40, 20, 50 }, { 40, 60, 40, 60 }, { 30, 40, 30, 40 }, { 40, 60, 50, 50 },
            { 30, 40, 30, 60 } };
    // private Double[]
    // probDeAparicion={0.2,0.5,0.1,0.2,0.5,0.1,0.2,0.5,0.1,0.8,0.5,0.2,0.8,0.5,0.2,0.12,0.5,0.1,0.15,0.5,0.8,0.2,0.7,0.2,0.22};

    public Pokemons pokemon() {
        Pokemons pokemon = new Pokemons();
        int numeroSeleccionado = random.nextInt(NOMBRE.length);
        String nombre = NOMBRE[numeroSeleccionado];
        Movimiento[] movimientosSeleccionado = MOVIMIENTOS[numeroSeleccionado];
        int[] statusSeleccionado = STATUS[numeroSeleccionado];
        pokemon.setMovimientos(movimientosSeleccionado);
        pokemon.setNombre(nombre);
        pokemon.setStatus(statusSeleccionado);
        return pokemon;
    }

    public Pokemons pokemonIniciales(int inicial) {

        Pokemons pokemon = new Pokemons();
        String nombre;
        Movimiento[] movimientosSeleccionado;
        int[] statusSeleccionado;
        switch (inicial) {
            case 1:
                nombre = NOMBRE[0];
                movimientosSeleccionado = MOVIMIENTOS[0];
                statusSeleccionado = STATUS[0];
                break;
            case 2:
                nombre = NOMBRE[6];
                movimientosSeleccionado = MOVIMIENTOS[6];
                statusSeleccionado = STATUS[6];
                break;
            default:
                nombre = NOMBRE[3];
                movimientosSeleccionado = MOVIMIENTOS[3];
                statusSeleccionado = STATUS[3];
                break;
        }
        pokemon.setMovimientos(movimientosSeleccionado);
        pokemon.setNombre(nombre);
        pokemon.setStatus(statusSeleccionado);
        return pokemon;

    }
}
