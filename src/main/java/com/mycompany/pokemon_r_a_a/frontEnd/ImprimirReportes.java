package com.mycompany.pokemon_r_a_a.frontEnd;

import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.ListaEnlazadaException;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Listas;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.InfoPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.RegistroFama;

public class ImprimirReportes extends ImpresoresGlobal {
    public void mensaje(String mensaje) {
        limpiadorPantalla();
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado(mensaje));
        separadorFinalMapa();
        delayThread();
    }

    public void mensajeregistro(int contador, Listas<RegistroFama> registros) {
        try {
            RegistroFama registroFama = registros.obtenerContenido(contador - 1);
            separadorInicioMapa();
            System.out.println(formatearMapaCentrado("--- Registro #" + contador + " ---"));
            System.out.println(formatearMapaCentrado("1. FICHA DEL ENTRENADOR"));
            System.out.println(formatearMapa("   Nombre: " + registroFama.getNombreJugador()));
            System.out.println(formatearMapa("   Balance final: " + registroFama.getBalanceFinal() + " pokémonedas"));
            int contadorMedallas = 0;
            if (registroFama.getMedallas() != null) {
                for (int m : registroFama.getMedallas())
                    if (m > 0)
                        contadorMedallas++;
            }
            System.out.println(formatearMapa("   Medallas: " + contadorMedallas + " / 3 obtenidas"));

            System.out.println(formatearMapaCentrado("2. EQUIPO POKÉMON VICTORIOSO"));
            Listas<InfoPokemon> equipo = registroFama.getEquipoVictorioso();
            for (int j = 0; j < equipo.getCapacidad(); j++) {
                try {
                    InfoPokemon ip = equipo.obtenerContenido(j);
                    String ap;
                    if (ip.getApodo() != null && !ip.getApodo().isEmpty()) {
                        ap = " '" + ip.getApodo() + "'";
                    } else {
                        ap = "";
                    }
                    System.out.println(formatearMapa(
                            "   - " + ip.getEspecie() + ap + " (Nivel " + ip.getNivel() + ") | Vida Máxima: "
                                    + ip.getVidaMaxima()));
                } catch (ListaEnlazadaException e) {
                    mensaje("Error al obtener el pokemon");
                }
            }

            System.out.println(formatearMapaCentrado("3. ESTADÍSTICAS DE LA PARTIDA"));
            System.out.println(formatearMapa("   Batallas salvajes: " + registroFama.getTotalBatallasSalvajes()));
            System.out.println(
                    formatearMapa("   Batallas vs entrenadores: " + registroFama.getTotalBatallasEntrenador()));
            System.out.println(formatearMapa("   Pokébolas lanzadas: " + registroFama.getPokebolasLanzadas()));
            System.out.println(formatearMapa("   Pokémon capturados: " + registroFama.getPokemonCapturados()));
            System.out.println(formatearMapa("   MVP: " + registroFama.getPokemonMVP()));
            separadorFinalMapa();
        } catch (ListaEnlazadaException e) {
            mensaje("Error al obtener el registro");
        }
        delayThread();
    }
}
