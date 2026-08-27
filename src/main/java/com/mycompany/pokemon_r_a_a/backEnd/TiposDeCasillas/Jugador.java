package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;



public class Jugador extends Casillas {

    @Override
    public void imprimir() {
        System.out.print(AZUL+" ► "+RESET);
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
        return 5;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEstadoDeGruppo'");
    }

}
