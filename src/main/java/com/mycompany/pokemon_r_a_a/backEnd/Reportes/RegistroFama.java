package com.mycompany.pokemon_r_a_a.backEnd.Reportes;

import java.io.Serializable;

import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Listas;

public class RegistroFama implements Serializable {

    private String nombreJugador;
    private int balanceFinal;
    private int[] medallas;
    private String[] ciudadesMedallas;
    private int totalBatallasSalvajes;
    private int totalBatallasEntrenador;
    private int pokebolasLanzadas;
    private int pokemonCapturados;
    private String pokemonMVP;
    private Listas<InfoPokemon> equipoVictorioso;

    public RegistroFama() {
        equipoVictorioso = new Listas<>();
    }

    public Listas<InfoPokemon> getEquipoVictorioso() {
        return equipoVictorioso;
    }

    public void setEquipoVictorioso(InfoPokemon info) {
        equipoVictorioso.agregarAlFinal(info);
    }

    public int getBalanceFinal() {
        return balanceFinal;
    }

    public int[] getMedallas() {
        return medallas;
    }

    public String[] getCiudadesMedallas() {
        return ciudadesMedallas;
    }

    public void setCiudadesMedallas(String[] ciudadesMedallas) {
        this.ciudadesMedallas = ciudadesMedallas;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public int getPokebolasLanzadas() {
        return pokebolasLanzadas;
    }

    public int getPokemonCapturados() {
        return pokemonCapturados;
    }

    public String getPokemonMVP() {
        return pokemonMVP;
    }

    public int getTotalBatallasEntrenador() {
        return totalBatallasEntrenador;
    }

    public int getTotalBatallasSalvajes() {
        return totalBatallasSalvajes;
    }

    public void setBalanceFinal(int balanceFinal) {
        this.balanceFinal = balanceFinal;
    }

    public void setMedallas(int[] medallas) {
        this.medallas = medallas;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public void setPokebolasLanzadas(int pokebolasLanzadas) {
        this.pokebolasLanzadas = pokebolasLanzadas;
    }

    public void setPokemonCapturados(int pokemonCapturados) {
        this.pokemonCapturados = pokemonCapturados;
    }

    public void setPokemonMVP(String pokemonMVP) {
        this.pokemonMVP = pokemonMVP;
    }

    public void setTotalBatallasEntrenador(int totalBatallasEntrenador) {
        this.totalBatallasEntrenador = totalBatallasEntrenador;
    }

    public void setTotalBatallasSalvajes(int totalBatallasSalvajes) {
        this.totalBatallasSalvajes = totalBatallasSalvajes;
    }
}
