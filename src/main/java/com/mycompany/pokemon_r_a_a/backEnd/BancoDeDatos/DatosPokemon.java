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
    // ── Tipos de Pokémon (1: Planta, 2: Fuego, 3: Agua, 4: Eléctrico, 5: Normal,
    // 6: Bicho, 7: Veneno)
    private final int[] tiposPokemon = {
            1, 1, 1, // 0-2: Bulbasaur, Ivysaur, Venusaur (Planta)
            2, 2, 2, // 3-5: Charmander, Charmeleon, Charizard (Fuego)
            3, 3, 3, // 6-8: Squirtle, Wartortle, Blastoise (Agua)
            6, 6, 6, // 9-11: Caterpie, Metapod, Butterfree (Bicho)
            6, 6, 6, // 12-14: Weedle, Kakuna, Beedrill (Bicho)
            5, 5, 5, // 15-17: Pidgey, Pidgeotto, Pidgeot (Normal)
            5, 5, // 18-19: Rattata, Raticate (Normal - 2 Pokémon)
            5, 5, // 20-21: Spearow, Fearow (Normal - 2 Pokémon)
            7, 7, // 22-23: Ekans, Arbok (Veneno)
            4 // 24: Pikachu (Eléctrico)
    };

    public static String obtenerNombreTipo(int tipo) {
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

    /**
     * Genera un ID dinámico para el Pokémon:
     * El primer número identifica al tipo, el siguiente al nivel, y así
     * sucesivamente
     * (tipo-nivel-especieId-npcId-correlativo).
     */
    public static String generarIdDinamico(int tipo, int nivel, int especieId, int npcId, int correlativo) {
        return tipo + "-" + nivel + "-" + especieId + "-" + npcId + "-" + correlativo;
    }

    /**
     * Descompone un ID dinámico en sus componentes numéricos:
     * [0] = tipo, [1] = nivel, [2] = especieId, [3] = npcId, [4] = correlativo
     */
    public static int[] descomponerIdDinamico(String id) {
        if (id == null || id.isEmpty()) {
            return new int[] { 0, 0, 0, 0, 0 };
        }
        if (id.contains("-")) {
            String[] partes = id.split("-");
            int[] resultado = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                try {
                    resultado[i] = Integer.parseInt(partes[i].trim());
                } catch (NumberFormatException e) {
                    resultado[i] = 0;
                }
            }
            return resultado;
        } else {
            try {
                int valor = Integer.parseInt(id.trim());
                return new int[] { valor };
            } catch (Exception e) {
                return new int[] { 0 };
            }
        }
    }

    // ── Multiplicadores de encuentro ──────────────────────────────────────────
    private static final double M_SALVAJE = 0.4;
    private static final double M_ENTRENADOR = 0.6;
    private static final double M_LIDER = 0.75;

    /**
     * Calcula el nivel que debe tener un Pokémon rival basándose en el equipo
     * del jugador y el tipo de encuentro ("SALVAJE", "ENTRENADOR" o "LIDER").
     *
     * nivelGenerado = (Σ niveles del jugador × M) / cantidad de Pokémon
     */
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
        return nivelGenerado < 1 ? 1 : nivelGenerado;
    }

    public Pokemons pokemonRandom(Pokemons[] equipoJugador, String tipoEncuentro) {
        return pokemonRandom(equipoJugador, tipoEncuentro, 0, 1);
    }

    public Pokemons pokemonRandom(Pokemons[] equipoJugador, String tipoEncuentro, int npcId, int correlativo) {
        Pokemons pokemon = new Pokemons();
        int numeroSeleccionado = random.nextInt(nombrePokemon.length);
        int tipo = tiposPokemon[numeroSeleccionado];
        int nivel = calcularNivelGenerado(equipoJugador, tipoEncuentro);
        int especieId = numeroSeleccionado + 1;

        String idDinamico = generarIdDinamico(tipo, nivel, especieId, npcId, correlativo);

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
        int nivel = 5;
        int especieId = indice + 1;
        String idDinamico = generarIdDinamico(tipo, nivel, especieId, 0, 1);

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

    /**
     * Reconstruye un Pokémon a partir de un ID dinámico (útil para lectores de
     * archivos).
     * ID formato: tipo-nivel-especieId-npcId-correlativo
     */
    public Pokemons crearPokemonPorIdDinamico(String idDinamico) {
        int[] datos = descomponerIdDinamico(idDinamico);
        int tipo = datos.length > 0 ? datos[0] : 5;
        int nivel = datos.length > 1 ? datos[1] : 1;
        int especieId = datos.length > 2 ? datos[2] : 1;

        int indice = Math.max(0, Math.min(especieId - 1, nombrePokemon.length - 1));

        Pokemons pokemon = new Pokemons();
        pokemon.setNombre(nombrePokemon[indice]);
        pokemon.setMovimientos(movimientosPokemon[indice]);
        pokemon.setVidaInicial(saludPokemon[indice]);
        pokemon.setAtaqueInicial(ataquePokemon[indice]);
        pokemon.setDefensaInicial(defensaPokemon[indice]);
        pokemon.setVelocidadInicial(velocidadPokemon[indice]);
        pokemon.setTipo(tipo != 0 ? tipo : tiposPokemon[indice]);
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
            pokedex[i].setIdDinamico(generarIdDinamico(tipo, 1, i + 1, 0, 0));
            pokedex[i].restauradorArtibutos();
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
