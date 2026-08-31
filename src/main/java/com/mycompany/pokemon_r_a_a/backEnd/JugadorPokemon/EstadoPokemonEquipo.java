package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.ImpresorEstado;

public class EstadoPokemonEquipo {
    private Scanner scanner;
    private JugadorPokemonPartida jugador;
    private Pokemons[] equipo;
    private ImpresorEstado impresorEstado = new ImpresorEstado();

    public EstadoPokemonEquipo(Scanner scanner, JugadorPokemonPartida jugador) {
        this.scanner = scanner;
        this.jugador = jugador;
    }

    public void menuInicial() {
        equipo = jugador.getPokemosEquipo();
        while (true) {
            try {
                impresorEstado.impresorEquipo(equipo);
                int selecionado = Integer.parseInt(scanner.nextLine());
                switch (selecionado) {
                    case 1:
                        cambioDeOrden();
                        break;
                    case 2:
                        int contador=0;
                        for (Pokemons pokemons : equipo) {
                            if(pokemons!=null){
                                contador++;
                            }
                        }
                        if (contador>1){
                            liberadorPokemon();
                        }else{
                            impresorEstado.fallo("no te puedes quedar sin pokemons");
                        }
                        break;
                    case 3:
                        informacionPokemon();
                        break;
                    case 0:
                        return;
                    default:
                        impresorEstado.pantallaDeError();
                        break;
                }
            } catch (NumberFormatException e) {
                impresorEstado.pantallaDeError();
            }
        }

    }

    private void cambioDeOrden() throws NumberFormatException {
        try {
            impresorEstado.cambioDeOrden(equipo, false);
            int pokemonCambio = Integer.parseInt(scanner.nextLine());
            if (pokemonCambio==0){
                return;
            }
            impresorEstado.cambioDeOrden(equipo, true);
            int lugarCambio = Integer.parseInt(scanner.nextLine());
             if (lugarCambio==0){
                return;
            }
            Pokemons temporal = equipo[lugarCambio-1];
            equipo[lugarCambio-1] = equipo[pokemonCambio-1];
            equipo[pokemonCambio-1] = temporal;
            impresorEstado.exito("cambio de lugar");
        } catch (NullPointerException e) {
            throw new NumberFormatException();
        }

    }

    private void liberadorPokemon() throws NumberFormatException {
        try {

            impresorEstado.impresorDeLiberacion(equipo);
            int pokemonLiberar = Integer.parseInt(scanner.nextLine());
            if (pokemonLiberar==0){
                return;
            }
            if (equipo[pokemonLiberar-1] != null) {
                impresorEstado.confirmacionLiberacion();
                if (scanner.nextLine().equalsIgnoreCase("s")) {
                    equipo[pokemonLiberar-1] = null;
                    impresorEstado.exito("liberacion");
                } else {
                    impresorEstado.exito("cancelada");
                }
            } else {
                impresorEstado.fallo("Pokemon inexistente");
            }
        } catch (NullPointerException e) {
            throw new NumberFormatException();
        }

    }

    private void informacionPokemon() throws NumberFormatException {
        try {
            impresorEstado.impresorDelistas("Pokemons", equipo);
            impresorEstado.mensajeInformativoSelecion();
            int pokemonSelecionado = Integer.parseInt(scanner.nextLine());
            impresorEstado.impresorDePokemon(equipo, pokemonSelecionado - 1);
            scanner.nextLine();
        } catch (NullPointerException e) {
            throw new NumberFormatException();
        }

    }

}
