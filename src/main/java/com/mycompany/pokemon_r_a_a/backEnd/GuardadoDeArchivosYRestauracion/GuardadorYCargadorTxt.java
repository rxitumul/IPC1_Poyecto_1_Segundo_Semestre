package com.mycompany.pokemon_r_a_a.backEnd.GuardadoDeArchivosYRestauracion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.ListaEnlazadaException;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Listas;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.InfoPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.RegistroFama;
import com.mycompany.pokemon_r_a_a.frontEnd.ImprimirReportes;

public class GuardadorYCargadorTxt {

    private ImprimirReportes impresor = new ImprimirReportes();

    public void registroDeGanador(RegistroFama r, String ruta) {
        File archivo = new File(ruta);
        File carpeta = archivo.getParentFile();
        try (PrintWriter writer = new PrintWriter(new FileWriter(archivo, false))) {
            if (carpeta != null && !carpeta.exists()) {
                carpeta.mkdirs();
                writer.println();
                writer.println("               HALL DE LA FAMA                   ");
                writer.println();
            }

            int numeroRegistro = 1;
            StringBuilder contenidoPrevio = new StringBuilder();

            writer.print(contenidoPrevio.toString().trim());
            writer.println();
            writer.println();

            writer.println("--- REGISTRO #" + numeroRegistro + " ---");
            writer.println("1. FICHA DEL ENTRENADOR");
            writer.println("   Nombre: " + r.getNombreJugador());
            writer.println("   Balance final: " + r.getBalanceFinal() + " pokémonedas");
            int cantMedallas = 0;
            if (r.getMedallas() != null) {
                for (int m : r.getMedallas()) {
                    if (m > 0) {
                        cantMedallas++;
                    }
                }
            }
            writer.println("   Medallas: " + cantMedallas + " / 3 obtenidas");
            if (r.getCiudadesMedallas() != null && r.getMedallas() != null) {
                for (int m = 0; m < r.getMedallas().length; m++) {
                    if (r.getMedallas()[m] > 0) {
                        String cd;
                        if (m < r.getCiudadesMedallas().length && r.getCiudadesMedallas()[m] != null) {
                            cd = r.getCiudadesMedallas()[m];
                        } else {
                            cd = "Ciudad #" + (m + 1);
                        }
                        String med = "";
                        if (r.getNombresMedallas() != null && m < r.getNombresMedallas().length
                                && r.getNombresMedallas()[m] != null && !r.getNombresMedallas()[m].isEmpty()) {
                            med = " Medalla " + r.getNombresMedallas()[m];
                        }
                        writer.println("     - Medalla de: " + cd + med);
                    }
                }
            }
            writer.println("");
            writer.println("2. EQUIPO POKÉMON VICTORIOSO");
            Listas<InfoPokemon> eq = r.getEquipoVictorioso();
            if (eq != null) {
                for (int j = 0; j < eq.getCapacidad(); j++) {
                    try {
                        InfoPokemon ip = eq.obtenerContenido(j);
                        String ap = (ip.getApodo() != null && !ip.getApodo().isEmpty()) ? " '" + ip.getApodo() + "'"
                                : "";
                        writer.println("   - " + ip.getEspecie() + ap + " (Nivel " + ip.getNivel() + ") | Vida Máxima: "
                                + ip.getVidaMaxima());
                    } catch (ListaEnlazadaException ignored) {
                    }
                }
            }
            writer.println("");
            writer.println("3. ESTADÍSTICAS DE LA PARTIDA");
            writer.println("   Batallas salvajes: " + r.getTotalBatallasSalvajes());
            writer.println("   Batallas vs entrenadores: " + r.getTotalBatallasEntrenador());
            writer.println("   Pokébolas lanzadas: " + r.getPokebolasLanzadas());
            writer.println("   Pokémon capturados: " + r.getPokemonCapturados());
            writer.println("   MVP: " + r.getPokemonMVP());
            writer.println("-------------------------------------------------");
            writer.println("");
        } catch (IOException e) {
            impresor.pantallaDeError();
        }
    }

    public void cargadorDeRegistros(String phat) {
        File archivo = new File(phat);
        if (!archivo.exists()) {
            impresor.separadorInicioMapa();
            impresor.mensajeSinSeparadores("Aún no hay entrenadores registrados en el Hall de la Fama.");
            impresor.separadorFinalMapa();
            return;
        }
        try (FileReader reader = new FileReader(archivo);
                BufferedReader buffer = new BufferedReader(reader)) {

            impresor.separadorInicioMapa();
            String linea;
            while ((linea = buffer.readLine()) != null) {
                impresor.mensajeSinSeparadores(linea);
            }
            impresor.separadorFinalMapa();
        } catch (IOException e) {
            impresor.pantallaDeError();
        }
    }
}
