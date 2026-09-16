package com.mycompany.pokemon_r_a_a.backEnd.Reportes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;

import com.mycompany.pokemon_r_a_a.backEnd.GuardadoDeArchivosYRestauracion.GuardadorYCargadorTxt;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.ListaEnlazadaException;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Listas;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImprimirReportes;

public class HallDeLaFama implements Serializable {

    private Listas<RegistroFama> registros;
    private transient ImprimirReportes imprimir;
    private transient GuardadorYCargadorTxt txt;

    public HallDeLaFama() {
        txt = new GuardadorYCargadorTxt();
        registros = new Listas<>();
        imprimir = new ImprimirReportes();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        txt = new GuardadorYCargadorTxt();
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
        if (jugador.getNombresMedallas() != null) {
            registro.setNombresMedallas(jugador.getNombresMedallas().clone());
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
        txt.registroDeGanador(registro, "Archivos/Datos/hall/hallDeLaFama.txt");
        imprimir.mensaje("¡" + jugador.getNombre() + " ha sido registrado en el Hall de la Fama!");

    }

    public void guardarEnTexto(String ruta) {
        if (registros == null || registros.estaVacia()) {
            return;
        }
        for (int i = 0; i < registros.getCapacidad(); i++) {
            try {
                txt.registroDeGanador(registros.obtenerContenido(i), ruta);
            } catch (ListaEnlazadaException ignored) {
            }
        }
    }

    public void mostrarHallDeLaFama() {
        String phat = "Archivos/Datos/hall/hallDeLaFama.txt";
        imprimir.limpiadorPantalla();
        txt.cargadorDeRegistros(phat);
    }

    public Listas<RegistroFama> getRegistros() {
        return registros;
    }
}
