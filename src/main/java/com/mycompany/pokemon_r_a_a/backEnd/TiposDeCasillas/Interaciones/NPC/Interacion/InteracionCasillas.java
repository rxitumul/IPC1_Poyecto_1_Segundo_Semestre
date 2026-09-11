package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import java.io.IOException;
import java.io.ObjectInputStream;

import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios.InteracionConLosNpc;

public abstract class InteracionCasillas<T> extends Casillas<T> {
    protected  transient InteracionConLosNpc front;

    public InteracionCasillas(HallDeLaFama hall) {
        super(hall);
         front = new InteracionConLosNpc();
         // TODO Auto-generated constructor stub
        }
        
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            front = new InteracionConLosNpc();
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
