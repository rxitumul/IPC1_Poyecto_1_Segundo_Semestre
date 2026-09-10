package com.mycompany.pokemon_r_a_a.frontEnd.Menus;

import com.mycompany.pokemon_r_a_a.backEnd.CargadorDePartidas.DistribuidorDeGuardado;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class InterfasDePartidaGuardada extends ImpresoresGlobal {

    public void interfasDeCargadoPartida(String rutaDeGuardado) {
        limpiadorPantalla();
        String[] nombresPartidasGuardadas;
        DistribuidorDeGuardado lector = new DistribuidorDeGuardado(null, null, rutaDeGuardado);
        separadorInicio();
        System.out.println(formatearCentrado("AVENTURA PARA CONTINUAR "));
        separadorMedios();
        try {
            nombresPartidasGuardadas = lector.lectorDeDatosNombres(rutaDeGuardado);
            String[] nombrePartidasGuardadasModificado = new String[nombresPartidasGuardadas.length];

            for (int i = 0; i < nombresPartidasGuardadas.length; i++) {

                String nombreCompleto = nombresPartidasGuardadas[i];

                if (nombreCompleto.startsWith(".")) {
                    nombrePartidasGuardadasModificado[i] = "";
                    continue;
                }
                int ultimoDato = nombreCompleto.lastIndexOf('.');
                if (ultimoDato != -1) {
                    nombrePartidasGuardadasModificado[i] = nombreCompleto.substring(0, ultimoDato);
                } else {
                    nombrePartidasGuardadasModificado[i] = nombreCompleto;
                }
            }

            for (int i = 0; i < nombrePartidasGuardadasModificado.length; i++) {
                if (!nombrePartidasGuardadasModificado[i].isEmpty()) {
                    System.out.println(formatear("  (" + (i + 1) + ") " + nombrePartidasGuardadasModificado[i]));
                }
            }
            delayThread();
            separadorMedios();
            System.out.println(formatearCentrado("SELECIONE UNA PARTIDA GUARDAD O ESCRIBA R PARA REGRESAR "));
            separadorFinal();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
