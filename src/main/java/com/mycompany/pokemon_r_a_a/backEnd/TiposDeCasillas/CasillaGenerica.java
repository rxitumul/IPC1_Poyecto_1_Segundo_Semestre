package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas;

import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class CasillaGenerica extends Casillas {


    public CasillaGenerica(String simbolo, boolean caminable, int tipo, boolean tieneSubMenu, HallDeLaFama hall) {
        super(hall);
        this.simbolo = simbolo;
        this.caminable = caminable;
        this.tipo = tipo;
        this.tieneSubMenu = tieneSubMenu;
    }

    @Override
    public void imprimir() {
        System.out.print(simbolo);
    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
        return caminable;
    }

    @Override
    public int tipoCasilla() {
        return tipo;
    }

    @Override
    public Boolean subMenu() {
        return tieneSubMenu;
    }

    @Override
    public void setMapa() {
    }

    @Override
    public boolean getEstadoDeGruppo() {
        return false;
    }
}
