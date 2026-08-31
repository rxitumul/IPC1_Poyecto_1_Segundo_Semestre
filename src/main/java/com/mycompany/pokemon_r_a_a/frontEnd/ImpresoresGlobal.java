package com.mycompany.pokemon_r_a_a.frontEnd;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;

public class ImpresoresGlobal extends ConfiguracionesDeEstetica {
    protected final static String VERDE = "\u001B[32m";
    protected final static String ROJO = "\u001B[31m";
    protected final static String RESET = "\u001B[0m";
    protected final static String NARANJA = "\033[38;5;208m";

    protected final static String BARRAS_DE_VIDA_25 = "█████░░░░░░░░░░░░░░░";
    protected final static String BARRAS_DE_VIDA_50 = "██████████░░░░░░░░░░";
    protected final static String BARRAS_DE_VIDA_75 = "███████████████░░░░░";
    protected final static String BARRAS_DE_VIDA_100 = "████████████████████";



    public void pantallaDeError() {
        delayThread();
        System.out.print(NARANJA);
        limpiadorDeLineas();
        separadorInicio();
        System.out.println(formatearCentrado("Error: Opción inválida"));
        System.out.println(formatearCentrado("Por favor, seleccione una opción válida"));
        separadorFinal();
        System.out.print(RESET);
    }

    public void mensajeInformativo(String mensaje) {
        delayThread();
        limpiadorDeLineas();
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado(mensaje));
        separadorFinalMapa();
    }

    public void mensajeInformativoDecontinuar() {
        System.out.println(formatearCentrado("Presione enter para continuar....."));
    }
     public void mensajeInformativoSelecion() {
        System.out.println(formatearMapaCentrado("Selecione una opcion"));
    }

    public void mensajeDeIngresoDeNombre() {
        System.out.println(formatearCentrado("Ingrese el nombre a utilizar"));
    }

    public <T> void impresorDelistas(String nombreDeLista, T[] listaAImprimir) {
        System.out.println(nombreDeLista);
        for (int i = 0; i < listaAImprimir.length; i++) {
            separadorInicioMapa();
            if (listaAImprimir[i] instanceof MapaCiudad mapa) {
                System.out.println(formatearMapa(i + 1 + ") " + mapa.getNombre()));
            } else if (listaAImprimir[i] instanceof Pokemons pokemons) {
                System.out.println(formatearMapa(i + 1 + ") " + pokemons.getNombre()));

            }
            separadorFinalMapa();
        }
    }

    public void impresorDePokemon(Pokemons[] pokemon, int numero) {
        Movimiento[] movimientoPokemon = pokemon[numero].getMovimientos();

        separadorInicioMapa();
        System.out.println(formatearMapaCentrado(pokemon[numero].getNombre()));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado("Estadisticas "));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado(
                "Vida inicial: " + pokemon[numero].getVidaInicial() + "  Defensa Inicial: "
                        + pokemon[numero].getDefensaInicial()));
        System.out.println(formatearMapaCentrado("Ataque inicial: " + pokemon[numero].getAtaqueInicial()
                + "  Velocidad Inicial: " + pokemon[numero].getVelocidadInicial()));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado("Movimientos "));
        separadorMediosMapa();
        if (movimientoPokemon.length == 2) {
            System.out.println(
                    formatearMapaCentrado(movimientoPokemon[0].getNombre() + "  " + movimientoPokemon[1].getNombre()));
        } else if (movimientoPokemon.length == 1) {
            System.out.println(
                    formatearMapaCentrado(movimientoPokemon[0].getNombre()));
        } else {
            System.out.println(
                    formatearMapaCentrado(movimientoPokemon[0].getNombre() + "  " + movimientoPokemon[1].getNombre()
                            + "  " + movimientoPokemon[2].getNombre()));
        }
        separadorFinalMapa();
        separadorInicioMapa();
        System.out.println(formatearMapa("Presione enter para regresar al menu de pokemons"));
        separadorFinalMapa();
    }

}
