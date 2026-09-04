package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

public class LiderDeGimnasio extends Npc<Entrenador> {

    private Entrenador[] entrenadores;
    private String medalla;

    @Override
    public String[] getDialojo(int tipo) {
        // TODO Auto-generated method stub
        switch (tipo) {
            case 0:
                return new String[] {
                        "¡Bienvenido al Gimnasio " + nombre + "!",
                        "Mi nombre es [Nombre del líder] y soy el líder de este gimnasio.",
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

    @Override
    public void setBoleanoActivo(boolean boleanoActivo) {
        this.boleanoActivo = boleanoActivo;
    }

    @Override
    public boolean getbBleanoActivo() {
        return boleanoActivo;
    }

    @Override
    public Entrenador[] getLista() {
        return entrenadores;
    }

    @Override
    public void setLista(Entrenador[] entrenadores) {
        this.entrenadores = entrenadores;
    }

    @Override
    public void accion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accion'");
    }

}
