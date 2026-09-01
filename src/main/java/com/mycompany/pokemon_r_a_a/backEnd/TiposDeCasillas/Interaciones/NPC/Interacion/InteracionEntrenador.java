package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class InteracionEntrenador extends InteracionCasillas<Entrenador> {

    public InteracionEntrenador(HallDeLaFama hall) {
        super(hall);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int tipoCasilla() {
        // TODO Auto-generated method stub
        return 15;
    }

    @Override
    public void setNpc(Entrenador dialogo) {
        this.dialogo = dialogo;
    }

}
