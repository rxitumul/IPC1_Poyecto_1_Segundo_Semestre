package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Obstaculos;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class Casa extends Casillas{

    @Override
    public void imprimir() {
               System.out.print(AZUL+" ⌂ "+RESET);
    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
        return false;
    }

    @Override
    public int tipoCasilla() {
        return 9;
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
