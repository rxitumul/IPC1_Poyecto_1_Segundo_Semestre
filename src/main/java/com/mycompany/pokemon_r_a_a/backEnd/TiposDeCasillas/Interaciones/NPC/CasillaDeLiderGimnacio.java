package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;

public class CasillaDeLiderGimnacio extends Casillas {

    @Override
    public void imprimir() {
               System.out.print(AZUL+" ♛ "+RESET);

    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
        return true;
    }

    @Override
    public int tipoCasilla() {
        return 11;
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
