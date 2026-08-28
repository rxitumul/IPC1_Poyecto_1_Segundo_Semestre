package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

public class Pokedex {
    private String[] nombrePokemon;
    private ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();

    public String[] getNombrePokemon() {
        return nombrePokemon;
    }

    public void impresorDeNombres() {
        confi.inicioDeTabla();
        System.out.println(confi.formatoTabla("Nombre", "ID"));
        confi.mediosDeTabla();
        for (int i = 0; i < nombrePokemon.length; i++) {
            System.out.println(confi.formatoTabla(nombrePokemon[i], String.valueOf(i + 1)));
        }
        confi.finDeTabla();
    }

    public void impresorPokemon(int numero) {
        confi.separadorInicioMapa();

        confi.separadorMediosMapa();

        confi.separadorFinalMapa();
    }

}
