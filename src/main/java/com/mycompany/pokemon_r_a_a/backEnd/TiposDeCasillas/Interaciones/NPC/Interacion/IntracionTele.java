package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class IntracionTele extends InteracionCasillas<HallDeLaFama> {

    public IntracionTele(HallDeLaFama hall) {
        super(hall);
        this.dialogo = hall;
    }

    @Override
    public int tipoCasilla() {
        return 18;
    }

    @Override
    public void setNpc(HallDeLaFama hallDeLaFama) {
        this.dialogo = hallDeLaFama;
    }

    @Override
    public Boolean subMenu() {
        dialogo.mostrarHallDeLaFama();
        return true;
    }
}
