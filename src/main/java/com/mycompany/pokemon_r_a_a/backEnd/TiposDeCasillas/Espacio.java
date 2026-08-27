package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;


public class Espacio extends Casillas {

    @Override
    public void imprimir() {
        System.out.print("   ");
    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
        if (jugador) {
            return false;
        }
        return true;
    }

    @Override
    public int tipoCasilla() {
        return 6;
    }

    @Override
    public Boolean subMenu() {
        return true;
    }

    @Override
    public void setMapa() {
    }

    @Override
    public boolean getEstadoDeGruppo() {
        return false;
    }

}
