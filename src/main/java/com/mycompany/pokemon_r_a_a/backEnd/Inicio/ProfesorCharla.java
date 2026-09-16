package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.BancoDeDatos.DatosPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;
import com.mycompany.pokemon_r_a_a.frontEnd.InformacionProfesor.InicioProfesorOak;

public class ProfesorCharla {
    private Pokemons pokemonInicial;
    private int pokemnSelecionado;
    private Scanner scanner;
    private DatosPokemon pokemonCreador;
    private ImpresoresGlobal info;
    private InicioProfesorOak profesor;

    public ProfesorCharla(Scanner scanner) {
        this.scanner = scanner;
        pokemonCreador = new DatosPokemon();
        info = new ImpresoresGlobal();
        profesor = new InicioProfesorOak();
    }

    public void regaloProfesor(JugadorPokemonPartida jugador) {
        jugador.setNombre(profesor.getNombreLocal());
        Pokemons[] pokemonEquipo = jugador.getPokemosEquipo();
        pokemonEquipo[0] = pokemonInicial;
    }

    public void charlaInicial() {
        int contadorMensajes = 0;
        while (contadorMensajes != 5) {
            if (contadorMensajes == 4) {
                do {
                    profesor.cadenaDeMensajesInicial(contadorMensajes);

                    String nombre = scanner.nextLine();
                    if (nombre != null && !nombre.trim().isEmpty()) {
                        profesor.setNombre(nombre);
                        break;
                    } else {
                        profesor.pantallaDeError();
                    }
                } while (true);
            } else {
                profesor.cadenaDeMensajesInicial(contadorMensajes);
                scanner.nextLine();
            }
            contadorMensajes++;
        }
        contadorMensajes = 0;
        while (contadorMensajes != 10) {
            profesor.mensajeDespuesDenombre(contadorMensajes);
            contadorMensajes++;
            contadorMensajes++;
            if (contadorMensajes != 10) {
                scanner.nextLine();
            }
        }
        while (true) {
            try {
                profesor.mensajeDeElecionDePokemon();
                pokemnSelecionado = Integer.parseInt(scanner.nextLine());
                if (1 <= pokemnSelecionado && pokemnSelecionado <= 3) {
                    pokemonInicial = pokemonCreador.pokemonIniciales(pokemnSelecionado);
                    break;
                } else {
                    info.pantallaDeError();
                }
            } catch (Exception e) {
                info.pantallaDeError();
            }
        }

        profesor.setPokemonSelecionado(pokemonInicial.getNombre());
        contadorMensajes = 0;
        while (contadorMensajes != 6) {
            profesor.mensajeProfesorCambioDeNombre(contadorMensajes);
            contadorMensajes++;
            scanner.nextLine();
        }
        profesor.mensajeDeRenombre();
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            profesor.nombreAEleguir();
            String nombrePokemon = scanner.nextLine();
            pokemonInicial.setApodo(nombrePokemon);
            profesor.setPokemonSelecionado(nombrePokemon);
        } else {
            pokemonInicial.setApodo(pokemonInicial.getNombre());
        }
        profesor.nombreDelPokemon(pokemonInicial.getApodo());
        contadorMensajes = 0;
        while (contadorMensajes != 13) {
            profesor.mensajeProfesorFinal(contadorMensajes);
            contadorMensajes++;
            scanner.nextLine();
        }
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        scanner.nextLine();
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        scanner.nextLine();
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        scanner.nextLine();
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        scanner.nextLine();
        while (contadorMensajes != 26) {

            profesor.mensajeProfesorFinal(contadorMensajes);
            contadorMensajes++;
            scanner.nextLine();
        }
    }
}
