package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.InteracionConLosNpc;

public abstract class InteracionCasillas<T> extends Casillas<T> {
    protected  InteracionConLosNpc front = new InteracionConLosNpc();

    public InteracionCasillas(HallDeLaFama hall) {
        super(hall);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void imprimir() {
        System.out.print("   ");
    }

    @Override
    public boolean caminable() {
        return true;
    }

    @Override
    public boolean estadoCasilla(Boolean jugador) {
        if (jugador) {
            return false;
        }
        return true;
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
