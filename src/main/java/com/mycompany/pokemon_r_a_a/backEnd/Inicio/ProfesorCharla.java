package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.BibliotecaPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.frontEnd.MensajesDeInformacion;
import com.mycompany.pokemon_r_a_a.frontEnd.InformacionProfesor.InicioProfesor;

public class ProfesorCharla {
    private BibliotecaPokemon pokemonCreador = new BibliotecaPokemon();
    private MensajesDeInformacion info = new MensajesDeInformacion();
    private Pokemons pokemonInicial;

    public ProfesorCharla() {

    }

    private InicioProfesor profesor = new InicioProfesor();
    Scanner scanner = new Scanner(System.in);
    int pokemnSelecionado;

    public void charlaInicial() {
        int contadorMensajes = 0;
        while (contadorMensajes == 4) {
            profesor.cadenaDeMensajesInicial(contadorMensajes);
            contadorMensajes++;
            if (contadorMensajes == 4) {
                profesor.setNombre(scanner.nextLine());
            } else {
                scanner.nextLine();
            }
        }
        contadorMensajes = 0;
        while (contadorMensajes == 5) {
            profesor.mensajeDespuesDenombre(contadorMensajes);
            contadorMensajes++;
            if (contadorMensajes != 5) {
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
        while (contadorMensajes == 5) {
            profesor.mensajeProfesorCambioDeNombre(contadorMensajes);
            contadorMensajes++;
        }
        profesor.mensajeDeRenombre();
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            profesor.nombreAEleguir();
            pokemonInicial.setNombre(scanner.nextLine());
        }
        profesor.nombreDelPokemon();
        contadorMensajes = 0;
        while (contadorMensajes == 12) {
            profesor.mensajeProfesorFinal(contadorMensajes);
            contadorMensajes++;
        }
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        profesor.mensajeProfesorFinal(contadorMensajes);
        contadorMensajes++;
        while (contadorMensajes == 26) {
            profesor.mensajeProfesorFinal(contadorMensajes);
            contadorMensajes++;
        }
    }
}
