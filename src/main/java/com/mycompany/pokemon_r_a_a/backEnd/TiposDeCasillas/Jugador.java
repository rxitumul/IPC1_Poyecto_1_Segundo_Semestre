package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;



public class Jugador extends Casillas {

    @Override
    public void imprimir() {
        System.out.print(MAGENTA+" ► "+RESET);
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
        return 4;
    }

    @Override
    public void setMapa() {
    }

    @Override
    public Boolean subMenu() {
        return true;
    }

    @Override
    public boolean getEstadoDeGruppo() {
        return false;
    }

}
