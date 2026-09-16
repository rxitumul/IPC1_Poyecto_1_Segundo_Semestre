package com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.MetodosDeAyudaStatic.MetodosStatic;
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

public class DatosPokemon implements Serializable {

    private transient Random random;
    private static final double M_SALVAJE = 0.4;
    private static final double M_ENTRENADOR = 0.6;
    private static final double M_LIDER = 0.75;

    public DatosPokemon() {
        random = new Random();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        random = new Random();
    }

    private final String[] nombrePokemon = { "Bulbasaur", "Ivysaur", "Venusaur", "Charmander", "Charmeleon",
            "Charizard",
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

    private final int[] tiposPokemon = {
            1, 1, 1,
            2, 2, 2,
            3, 3, 3,
            6, 6, 6,
            6, 6, 6,
            5, 5, 5,
            5, 5,
            5, 5,
            7, 7,
            4
    };

    public String obtenerNombreTipo(int tipo) {
        switch (tipo) {
            case 1:
                return "Planta";
            case 2:
                return "Fuego";
            case 3:
                return "Agua";
            case 4:
                return "Eléctrico";
            case 5:
                return "Normal";
            case 6:
                return "Bicho";
            case 7:
                return "Veneno";
            default:
                return "Normal";
        }
    }

    public int calcularNivelGenerado(Pokemons[] equipoJugador, String tipoEncuentro) {
        if (equipoJugador == null || equipoJugador.length == 0) {
            return 1;
        }

        int sumaNiveles = 0;
        int cantidad = 0;
        for (Pokemons p : equipoJugador) {
            if (p != null) {
                sumaNiveles += p.getNivel();
                cantidad++;
            }
        }
        if (cantidad == 0) {
            return 1;
        }

        double m = M_SALVAJE;
        if ("ENTRENADOR".equals(tipoEncuentro)) {
            m = M_ENTRENADOR;
        } else if ("LIDER".equals(tipoEncuentro)) {
            m = M_LIDER;
        }

        int nivelGenerado = (int) ((sumaNiveles * m) / cantidad);
        if (nivelGenerado < 1) {
            return 1;
        } else {
            return nivelGenerado;
        }
    }

    public Pokemons pokemonRandom(Pokemons[] equipoJugador, String tipoEncuentro, int npcId, int correlativo) {
        Pokemons pokemon = new Pokemons();
        int numeroSeleccionado = random.nextInt(nombrePokemon.length);
        int tipo = tiposPokemon[numeroSeleccionado];
        int nivel = calcularNivelGenerado(equipoJugador, tipoEncuentro);
        int especieId = numeroSeleccionado + 1;

        String idDinamico = MetodosStatic.generarIdDinamico(tipo, nivel, especieId, npcId, correlativo);

        pokemon.setNombre(nombrePokemon[numeroSeleccionado]);
        pokemon.setMovimientos(movimientosPokemon[numeroSeleccionado]);
        pokemon.setVidaInicial(saludPokemon[numeroSeleccionado]);
        pokemon.setAtaqueInicial(ataquePokemon[numeroSeleccionado]);
        pokemon.setDefensaInicial(defensaPokemon[numeroSeleccionado]);
        pokemon.setVelocidadInicial(velocidadPokemon[numeroSeleccionado]);
        pokemon.setTipo(tipo);
        pokemon.setTipoNombre(obtenerNombreTipo(tipo));
        pokemon.setNivel(nivel);
        pokemon.setIdDinamico(idDinamico);
        pokemon.restauradorArtibutos();
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
        int tipo = tiposPokemon[indice];
        int nivel = 0;
        int especieId = indice + 1;
        String idDinamico = MetodosStatic.generarIdDinamico(tipo, nivel, especieId, 0, 1);

        pokemon.setNombre(nombrePokemon[indice]);
        pokemon.setMovimientos(movimientosPokemon[indice]);
        pokemon.setVidaInicial(saludPokemon[indice]);
        pokemon.setAtaqueInicial(ataquePokemon[indice]);
        pokemon.setDefensaInicial(defensaPokemon[indice]);
        pokemon.setVelocidadInicial(velocidadPokemon[indice]);
        pokemon.setTipo(tipo);
        pokemon.setTipoNombre(obtenerNombreTipo(tipo));
        pokemon.setNivel(nivel);
        pokemon.setIdDinamico(idDinamico);
        pokemon.restauradorArtibutos();
        return pokemon;
    }

    public Pokemons crearPokemonPorIdDinamico(String idDinamico) {
        int[] datos = MetodosStatic.descomponerIdDinamico(idDinamico);
        int tipo;
        if (datos.length > 0) {
            tipo = datos[0];
        } else {
            tipo = 5;
        }

        int nivel;
        if (datos.length > 1) {
            nivel = datos[1];
        } else {
            nivel = 1;
        }

        int especieId;
        if (datos.length > 2) {
            especieId = datos[2];
        } else {
            especieId = 1;
        }

        int indice = Math.max(0, Math.min(especieId - 1, nombrePokemon.length - 1));

        Pokemons pokemon = new Pokemons();
        pokemon.setNombre(nombrePokemon[indice]);
        pokemon.setMovimientos(movimientosPokemon[indice]);
        pokemon.setVidaInicial(saludPokemon[indice]);
        pokemon.setAtaqueInicial(ataquePokemon[indice]);
        pokemon.setDefensaInicial(defensaPokemon[indice]);
        pokemon.setVelocidadInicial(velocidadPokemon[indice]);
        int tipoFinal;
        if (tipo != 0) {
            tipoFinal = tipo;
        } else {
            tipoFinal = tiposPokemon[indice];
        }
        pokemon.setTipo(tipoFinal);
        pokemon.setTipoNombre(obtenerNombreTipo(pokemon.getTipo()));
        pokemon.setNivel(nivel);
        pokemon.setIdDinamico(idDinamico);
        pokemon.restauradorArtibutos();
        return pokemon;
    }

    public Pokemons[] creadorPokedesData() {
        Pokemons[] pokedex = new Pokemons[nombrePokemon.length];
        for (int i = 0; i < nombrePokemon.length; i++) {
            pokedex[i] = new Pokemons();
            int tipo = tiposPokemon[i];
            pokedex[i].setNombre(nombrePokemon[i]);
            pokedex[i].setVidaInicial(saludPokemon[i]);
            pokedex[i].setAtaqueInicial(ataquePokemon[i]);
            pokedex[i].setDefensaInicial(defensaPokemon[i]);
            pokedex[i].setVelocidadInicial(velocidadPokemon[i]);
            pokedex[i].setMovimientos(movimientosPokemon[i]);
            pokedex[i].setTipo(tipo);
            pokedex[i].setTipoNombre(obtenerNombreTipo(tipo));
            pokedex[i].setIdDinamico(MetodosStatic.generarIdDinamico(tipo, 1, i + 1, 0, 0));
            pokedex[i].restauradorArtibutos();
        }
        return pokedex;
    }

    public Pokemons pokemonRandom(Pokemons[] equipoJugador, String tipoEncuentro) {
        return pokemonRandom(equipoJugador, tipoEncuentro, 0, 1);
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
