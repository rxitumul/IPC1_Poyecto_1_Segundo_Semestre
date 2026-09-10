package com.mycompany.pokemon_r_a_a.backEnd.Reportes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
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
        imprimir.mensaje("¡" + jugador.getNombre() + " ha sido registrado en el Hall de la Fama!");

    }

    public void mostrarHallDeLaFama() {

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
