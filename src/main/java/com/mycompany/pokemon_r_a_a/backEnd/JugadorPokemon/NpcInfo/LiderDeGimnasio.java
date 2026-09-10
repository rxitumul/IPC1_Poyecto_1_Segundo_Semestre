package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

public class LiderDeGimnasio extends Entrenador {
    private Entrenador[] entrenadores;
    private String medalla;

    public LiderDeGimnasio(String nombreCiudad) {
        super(nombreCiudad);
    }


    @Override
    public String[] getDialojo(int tipo) {
        // TODO Auto-generated method stub
        if (nombre == null) {
            nombre = "Lider";
        }
        switch (tipo) {
            case 0:
                return new String[] {

                        "¡Bienvenido al Gimnasio Pokémon!",
                        "Mi nombre es " + nombre + " y soy el líder de este gimnasio.",
                        "Si consigues derrotarme, recibirás la medalla " + medalla + ".",
                        "¿Estás preparado para demostrar que mereces esa medalla?" };
            case 1:
                return new String[] {
                        "¡Has demostrado ser un gran entrenador!",
                        "Reconozco tu habilidad y acepto mi derrota.",
                        "Como prometí, esta es la medalla " + medalla + ".",
                        "¡Felicidades por tu victoria!" };
            case 2:
                return new String[] {
                        "Has perdido este combate.",
                        "Pero una derrota no significa el final de tu camino.",
                        "Entrena a tus Pokémon y vuelve cuando estés preparado." };
            default:
                return new String[] {
                        "Felicidades nuevamente por haber obtenido la medalla " + medalla + "!",
                        "¡Eres un entrenador excepcional! Sigue adelante y enfrenta nuevos desafíos." };
        }
    }

    public void SetMedalla(String medalla) {
        this.medalla = medalla;
    }

    public String getMedalla() {
        return medalla;
    }

    public Entrenador[] getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(Entrenador[] entrenadores) {
        this.entrenadores = entrenadores;
    }

    @Override
    public void setBoleanoActivo(boolean boleanoActivo) {
        this.boleanoActivo = boleanoActivo;
    }

    @Override
    public boolean getbBleanoActivo() {
        return boleanoActivo;
    }

    @Override
    public void accion() {
    }

}
