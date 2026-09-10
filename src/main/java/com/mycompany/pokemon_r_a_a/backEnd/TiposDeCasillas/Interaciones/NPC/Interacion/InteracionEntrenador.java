package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.LiderDeGimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class InteracionEntrenador extends InteracionCasillas<Entrenador> {

    public InteracionEntrenador(HallDeLaFama hall) {
        super(hall);
    }

    @Override
    public int tipoCasilla() {
        return 15;
    }

    @Override
    public void setNpc(Entrenador npcT) {
        this.npcT = npcT;
    }

    public Entrenador getNpc() {
        return npcT;
    }

    @Override
    public Boolean subMenu() {
        boolean esLider = (npcT instanceof LiderDeGimnasio) || npcT.getbBleanoActivo();

        boolean tipoDeEstado = front.entrenadoresInicio(npcT, esLider);
        String opcion = scanner.nextLine();
        if (tipoDeEstado) {
            return true;
        }
        if (opcion.equals("1")) {
            if (jugador == null || !jugador.tienePokemonVivos()) {
                front.mensajeInformativo("¡No tienes Pokémon en condiciones para luchar!");
                front.mensajeInformativo("Presiona Enter para continuar...");
                scanner.nextLine();
                return true;
            }

            String[] inicioCombate = npcT.getDialojo(1);
            if (!esLider && inicioCombate != null) {
                front.mensajeEncadenado(inicioCombate);
            }

            batalla.pokemonsPelea(jugador, npcT);

            // Verificar si el rival fue vencido
            Pokemons[] equipoRival = npcT.getLista();
            boolean rivalDerrotado = true;
            if (equipoRival != null) {
                for (Pokemons p : equipoRival) {
                    if (p != null && p.getVidaPokemon() > 0) {
                        rivalDerrotado = false;
                        break;
                    }
                }
            }
            if (!rivalDerrotado) {
                if (equipoRival != null) {
                    for (Pokemons p : equipoRival) {
                        p.restauradorArtibutos();
                    }
                }
            }

            front.mensajeDeFinalizacionEntrenador(npcT, esLider, rivalDerrotado);

        } else {
            front.mensajeInformativo("Decides retirarte por ahora.");
        }

        front.mensajeInformativo("Presiona Enter para continuar...");
        scanner.nextLine();
        return true;
    }

}
