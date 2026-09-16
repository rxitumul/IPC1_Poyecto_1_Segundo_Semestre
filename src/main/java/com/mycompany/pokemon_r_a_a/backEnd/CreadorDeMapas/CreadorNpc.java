package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.LiderDeGimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.TiendaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;

public class CreadorNpc {

    private String[] nombresNpcEnfermeria = { "Amelia", "Clara", "Elena", "Julia", "Laura", "Marta", "Sofía", "Valeria",
            "Diana", "Camila " };
    private String[] nombresNpcTienda = { "Roberto", "Samuel", "Mateo", "Fernando", "Raúl", "Tomás", "Víctor", "Javier",
            "Sergio", "Esteban" };
    private String[] nombresNpcGimnasioEntrenadores = { "Alex", "Alan", "Axel", "Benjamín", "Cristian", "Damián",
            "Erick",
            "Fabián", "Felipe", "Franco", "Isaac", "Iván", "Kevin", "Leonardo", "Lucas", "Manuel", "Martín", "Miguel",
            "Óscar", "Pablo", "Pedro", "Rafael", "Ricardo", "Rodrigo", "Sebastián", "Santiago", "Thiago", "Valentín",
            "Xavier", "Yahir" };

    private String[] nombresNpcGimnasioLideres = { "Brock", "Misty", "Lt. Surge", "Erika", "Koga", "Sabrina", "Blaine",
            "Giovanni" };

    private String[][] nombreMedallasYIconos = {
            { "Fuego", "Agua", "Bosque", "Trueno", "Roca", "Viento", "Nieve", "Sombra", "Sol", "Luna", "Estrella",
                    "Cristal", "Acero", "Veneno", "Psíquica", "Dragón", "Fantasma", "Corazón", "Corona", "Cometa",
                    "Volcán", "Océano", "Montaña" },
            { "♦", "≈", "♧", "ϟ", "●", "◇", "❄", "☾", "☼", "☽", "★", "✧", "⚙", "☠", "◉", "♢", "◌", "♥", "♛", "☄", "△",
                    "≋", "▲" } };

    private Random random;
    private DatosPokemon datosPokemon;

    public CreadorNpc() {
        random = new Random();
        datosPokemon = new DatosPokemon();
    }

    private static String[][] medallasGeneradas;

    public String[][] generadorDeMedallas() {
        if (medallasGeneradas != null) {
            return medallasGeneradas;
        }
        medallasGeneradas = new String[2][3];
        int contador = 0;
        int totalMedallas = nombreMedallasYIconos[0].length;
        while (contador < 3) {
            int medalla = random.nextInt(totalMedallas);
            String nombre = nombreMedallasYIconos[0][medalla];
            String icono = nombreMedallasYIconos[1][medalla];
            boolean repetida = false;
            for (int i = 0; i < contador; i++) {
                if (medallasGeneradas[0][i] != null && medallasGeneradas[0][i].equals(nombre)) {
                    repetida = true;
                    break;
                }
            }
            if (!repetida) {
                medallasGeneradas[0][contador] = nombre;
                medallasGeneradas[1][contador] = icono;
                contador++;
            }
        }
        return medallasGeneradas;
    }

    public String obtenerNombreMedallaCompleto(int ciudad) {
        String[][] medallas = generadorDeMedallas();
        int indice = Math.max(0, Math.min(ciudad, medallas[0].length - 1));
        return medallas[0][indice] + " " + medallas[1][indice];
    }

    private int contarPokemonsEnEquipo(Pokemons[] equipo) {
        if (equipo == null) {
            return 0;
        }
        int count = 0;
        for (Pokemons p : equipo) {
            if (p != null) {
                count++;
            }
        }
        return count;
    }

    public Entrenador[] creadorDeEntrenadoresYLider(int ciudad, String ciudadNombre, Pokemons[] equipoJugador) {
        Entrenador[] lista = new Entrenador[4];
        int cantJugador = contarPokemonsEnEquipo(equipoJugador);

        // 3 entrenadores de gimnasio
        for (int i = 0; i < 3; i++) {
            Entrenador entrenador = new Entrenador(ciudadNombre);
            String nombre = nombresNpcGimnasioEntrenadores[random.nextInt(nombresNpcGimnasioEntrenadores.length)];
            entrenador.setNombre(nombre);
            entrenador.setId(i + 1);
            entrenador.setCiudad(ciudad);
            entrenador.setBoleanoActivo(false);

            int cantPokemon;
            if (cantJugador > 0) {
                cantPokemon = random.nextInt(cantJugador) + 1;
            } else {
                cantPokemon = 1;
            }
            Pokemons[] equipo = new Pokemons[cantPokemon];
            for (int p = 0; p < cantPokemon; p++) {
                equipo[p] = datosPokemon.pokemonRandom(equipoJugador, "ENTRENADOR", entrenador.getId(), p + 1);
            }
            entrenador.setLista(equipo);
            lista[i] = entrenador;
        }

        // 1 Líder de gimnasio
        LiderDeGimnasio lider = new LiderDeGimnasio(ciudadNombre);
        String nombreLider = nombresNpcGimnasioLideres[random.nextInt(nombresNpcGimnasioLideres.length)];
        lider.setNombre(nombreLider);
        lider.setId(99);
        lider.setCiudad(ciudad);
        lider.setBoleanoActivo(true);

        String[][] medallas = generadorDeMedallas();
        int indiceMedalla = Math.min(ciudad, medallas[0].length - 1);
        String medallaNombre = medallas[0][indiceMedalla] + " " + medallas[1][indiceMedalla];
        lider.SetMedalla(medallaNombre);

        int cantPokemonLider;
        if (cantJugador > 0) {
            cantPokemonLider = random.nextInt(cantJugador) + 1;
        } else {
            cantPokemonLider = 1;
        }
        Pokemons[] equipoLider = new Pokemons[cantPokemonLider];
        for (int p = 0; p < cantPokemonLider; p++) {
            equipoLider[p] = datosPokemon.pokemonRandom(equipoJugador, "LIDER", lider.getId(), p + 1);
        }
        lider.setLista(equipoLider);

        Entrenador[] entrenadoresGym = new Entrenador[3];
        System.arraycopy(lista, 0, entrenadoresGym, 0, 3);
        lider.setEntrenadores(entrenadoresGym);

        lista[3] = lider;
        return lista;
    }

    public TiendaNpc creadorDeTienda(int ciudad) {
        TiendaNpc tienda = new TiendaNpc();
        int indiceNombre = random.nextInt(nombresNpcTienda.length);
        tienda.setNombre(nombresNpcTienda[indiceNombre].trim());
        tienda.setId(indiceNombre + 1);
        tienda.setCiudad(ciudad);
        tienda.setBoleanoActivo(true);

        Mochila stock = new Mochila(null);
        stock.setPokebola(99999);
        stock.setPocion(99999);
        stock.setSuperPocion(99999);
        stock.setAntidoto(99999);
        stock.setAntiParalisis(9999);
        stock.setRestauraTodo(99);
        tienda.setLista(new Mochila[] { stock });

        return tienda;
    }

    public EnfermeriaNpc creadorDeEnfermeria(int ciudad) {
        EnfermeriaNpc enfermera = new EnfermeriaNpc();
        int indiceNombre = random.nextInt(nombresNpcEnfermeria.length);
        enfermera.setNombre(nombresNpcEnfermeria[indiceNombre].trim());
        enfermera.setId(indiceNombre + 1);
        enfermera.setCiudad(ciudad);
        enfermera.setBoleanoActivo(true);

        return enfermera;
    }

    public EnfermeriaNpc creadorDeEnfermeria() {
        return creadorDeEnfermeria(0);
    }

    public TiendaNpc creadorDeTienda() {
        return creadorDeTienda(0);
    }

    public Entrenador[] creadorDeEntrenadoresYLider(Pokemons[] equipoJugador, String ciudadNombre) {
        return creadorDeEntrenadoresYLider(0, ciudadNombre, equipoJugador);
    }

    public Entrenador[] creadorDeEntrenadoresYLider(String ciudadNombre) {
        return creadorDeEntrenadoresYLider(0, ciudadNombre, null);
    }

}
