package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class InteracionFarmacia extends InteracionCasillas<EnfermeriaNpc> {

    public InteracionFarmacia(HallDeLaFama hall) {
        super(hall);
    }

    @Override
    public int tipoCasilla() {
        return 16;
    }

    @Override
    public void setNpc(EnfermeriaNpc npcT) {
        this.npcT = npcT;
    }

    @Override
    public Boolean subMenu() {

        boolean enfermeraExiste = front.enfermeraInicio(npcT);
        String seleccion = scanner.nextLine();
        if (enfermeraExiste) {
            return true;
        }
        if (seleccion.trim().equals("1")) {
            if (jugador != null && jugador.getPokemosEquipo() != null) {
                npcT.setLista(jugador.getPokemosEquipo());
                npcT.setBoleanoActivo(true);
                npcT.accion();
                String[] recuperados = npcT.getDialojo(1);
                front.mensajeEncadenado(recuperados);
            } else {
                front.mensajeInformativo("¡No tienes un equipo Pokémon disponible para curar!");
            }
        } else {
            String[] despedida = npcT.getDialojo(2);
            front.mensajeEncadenado(despedida);

        }
        front.mensajeInformativo("Presiona Enter para continuar...");
        scanner.nextLine();
        return true;
    }
}
