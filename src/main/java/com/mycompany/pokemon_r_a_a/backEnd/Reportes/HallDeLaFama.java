package com.mycompany.pokemon_r_a_a.backEnd.Reportes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.ListaEnlazadaException;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Listas;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImprimirReportes;

public class HallDeLaFama implements Serializable {

    private Listas<RegistroFama> registros;
    private transient ImprimirReportes imprimir;

    public HallDeLaFama() {
        registros = new Listas<>();
        imprimir = new ImprimirReportes();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        imprimir = new ImprimirReportes();
    }

    public void registrarVictoria(JugadorPokemonPartida jugador) {
        RegistroFama registro = new RegistroFama();

        registro.setNombreJugador(jugador.getNombre());
        registro.setBalanceFinal(jugador.getPokemonedas());
        if (jugador.getMedallasObtenidas() != null) {
            registro.setMedallas(jugador.getMedallasObtenidas().clone());
        } else {
            registro.setMedallas(new int[] { 0, 0, 0 });
        }
        if (jugador.getCiudadesMedallas() != null) {
            registro.setCiudadesMedallas(jugador.getCiudadesMedallas().clone());
        }

        Pokemons[] equipo = jugador.getPokemosEquipo();
        Pokemons mvpPokemon = null;
        int maxDebilitados = -1;

        if (equipo != null) {
            for (Pokemons p : equipo) {
                if (p != null) {
                    InfoPokemon info = new InfoPokemon();
                    info.setEspecie(p.getNombre());
                    info.setApodo(p.getApodo());
                    info.setNivel(p.getNivel());
                    info.setVidaMaxima(p.getVidaInicial());
                    registro.setEquipoVictorioso(info);

                    if (p.getEnemigosDebilitados() > maxDebilitados) {
                        maxDebilitados = p.getEnemigosDebilitados();
                        mvpPokemon = p;
                    }
                }
            }
        }

        registro.setTotalBatallasSalvajes(jugador.getBatallasJugadasSalvajes());
        registro.setTotalBatallasEntrenador(jugador.getBatallasJugadasEntrenador());
        registro.setPokebolasLanzadas(jugador.getPokebolasLanzadas());
        registro.setPokemonCapturados(jugador.getPokemonCapturados());

        if (mvpPokemon != null) {
            if (mvpPokemon.getApodo() != null && !mvpPokemon.getApodo().isEmpty()) {
                registro.setPokemonMVP(mvpPokemon.getApodo() + " (" + mvpPokemon.getNombre() + ")");
            } else {
                registro.setPokemonMVP(mvpPokemon.getNombre());
            }

        } else {
            registro.setPokemonMVP("Ninguno");
        }

        registros.agregarAlFinal(registro);
        guardarEnTexto("Archivos/Datos/hall/hallDeLaFama.txt");
        imprimir.mensaje("¡" + jugador.getNombre() + " ha sido registrado en el Hall de la Fama!");

    }

    public void guardarEnTexto(String ruta) {
        File archivo = new File(ruta);
        File carpeta = archivo.getParentFile();
        if (carpeta != null && !carpeta.exists()) {
            carpeta.mkdirs();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
            bw.write("=================================================");
            bw.newLine();
            bw.write("               HALL DE LA FAMA                   ");
            bw.newLine();
            bw.write("=================================================");
            bw.newLine();
            if (registros.estaVacia()) {
                bw.write("Aún no hay entrenadores registrados.");
                bw.newLine();
            } else {
                for (int i = 0; i < registros.getCapacidad(); i++) {
                    RegistroFama r = registros.obtenerContenido(i);
                    bw.newLine();
                    bw.write("--- REGISTRO #" + (i + 1) + " ---");
                    bw.newLine();
                    bw.write("1. FICHA DEL ENTRENADOR");
                    bw.newLine();
                    bw.write("   Nombre: " + r.getNombreJugador());
                    bw.newLine();
                    bw.write("   Balance final: " + r.getBalanceFinal() + " pokémonedas");
                    bw.newLine();
                    int cantMedallas = 0;
                    if (r.getMedallas() != null) {
                        for (int m : r.getMedallas()) {
                            if (m > 0) {
                                cantMedallas++;
                            }
                        }
                    }
                    bw.write("   Medallas: " + cantMedallas + " / 3 obtenidas");
                    bw.newLine();
                    if (r.getCiudadesMedallas() != null && r.getMedallas() != null) {
                        for (int m = 0; m < r.getMedallas().length; m++) {
                            if (r.getMedallas()[m] > 0) {
                                String cd;
                                if (m < r.getCiudadesMedallas().length && r.getCiudadesMedallas()[m] != null) {
                                    cd = r.getCiudadesMedallas()[m];
                                } else {
                                    cd = "Ciudad #" + (m + 1);
                                }
                                bw.write("     - Medalla de: " + cd);
                                bw.newLine();
                            }
                        }
                    }
                    bw.newLine();
                    bw.write("2. EQUIPO POKÉMON VICTORIOSO");
                    bw.newLine();
                    Listas<InfoPokemon> eq = r.getEquipoVictorioso();
                    for (int j = 0; j < eq.getCapacidad(); j++) {
                        InfoPokemon ip = eq.obtenerContenido(j);
                        String ap;
                        if (ip.getApodo() != null && !ip.getApodo().isEmpty()) {
                            ap = " '" + ip.getApodo() + "'";
                        } else {
                            ap = "";
                        }
                        bw.write("   - " + ip.getEspecie() + ap + " (Nivel " + ip.getNivel() + ") | Vida Máxima: "
                                + ip.getVidaMaxima());
                        bw.newLine();
                    }
                    bw.newLine();
                    bw.write("3. ESTADÍSTICAS DE LA PARTIDA");
                    bw.newLine();
                    bw.write("   Batallas salvajes: " + r.getTotalBatallasSalvajes());
                    bw.newLine();
                    bw.write("   Batallas vs entrenadores: " + r.getTotalBatallasEntrenador());
                    bw.newLine();
                    bw.write("   Pokébolas lanzadas: " + r.getPokebolasLanzadas());
                    bw.newLine();
                    bw.write("   Pokémon capturados: " + r.getPokemonCapturados());
                    bw.newLine();
                    bw.write("   MVP: " + r.getPokemonMVP());
                    bw.newLine();
                    bw.write("-------------------------------------------------");
                    bw.newLine();
                }
            }
        } catch (IOException | ListaEnlazadaException e) {
            System.err.println("Error al guardar Hall de la Fama en texto: " + e.getMessage());
        }
    }

    public void mostrarHallDeLaFama() {

        imprimir.limpiadorPantalla();
        imprimir.mensaje("HALL DE LA FAMA");
        if (registros.estaVacia()) {
            imprimir.mensaje("Aún no hay entrenadores registrados.");
            return;
        }

        for (int i = 0; i < registros.getCapacidad(); i++) {
            imprimir.mensajeregistro(i + 1, registros);
        }
    }

    public Listas<RegistroFama> getRegistros() {
        return registros;
    }
}
