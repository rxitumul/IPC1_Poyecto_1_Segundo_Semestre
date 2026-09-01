package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class InteracionTienda extends InteracionCasillas<Object> {

    public InteracionTienda(HallDeLaFama hall) {
        super(hall);
    }

    @Override
    public int tipoCasilla() {
        return 17;
    }

    @Override
    public void setNpc(Object dialogo) {
        this.dialogo = dialogo;
    }
}
