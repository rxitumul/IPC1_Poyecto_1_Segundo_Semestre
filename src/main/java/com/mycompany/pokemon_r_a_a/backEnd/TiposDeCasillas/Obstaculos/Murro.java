package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Obstaculos;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class Murro extends Casillas{

    @Override
    public void imprimir() {
               System.out.print(" ■ ");
    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
        return false;
    }

    @Override
    public int tipoCasilla() {
        return 5;
    }

    @Override
    public Boolean subMenu() {
        return false;
    }

    @Override
    public void setMapa() {
    }

    @Override
    public boolean getEstadoDeGruppo() {
        return false;
    }

}
