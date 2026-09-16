package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Npc;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

@SuppressWarnings("rawtypes")
public class ImpresorDeMapas extends ImpresoresGlobal {

    public void imprimirMapaObjetos(Casillas[][] mapa, String nombre) {
        separadorInicioMapa();
        System.out.println(formatearMapa("Ciudad " + nombre));
        separadorMediosMapa();
        for (Casillas[] casillas : mapa) {
            System.out.print(getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println(getMarcoVertical());
        }
        separadorMediosMapa();
        System.out.println(formatearMapa("CONTROLES"));
        separadorMediosMapa();
        System.out.println(formatearMapa("    ┌───┐      "));
        System.out.println(formatearMapa("    │ W │      M → Mochila       N → Mapa          X → Salir"));
        System.out.println(formatearMapa("┌───┼───┼───┐"));
        System.out.println(formatearMapa("│ A │ S │ D │  P → Pokémon       T → Pokédex       F → Perfil"));
        System.out.println(formatearMapa("└───┴───┴───┘"));
        separadorMediosMapa();
        System.out.println(formatearMapa("OBJETOS DEL MAPA"));
        separadorMediosMapa();
        System.out.println(formatearMapa("■ Murro   ⚕ Centro Pokémon   G Gimnasio   $ Tienda   ⌂ Casa"));
        System.out.println(formatearMapa("♣ Hierba  ☻ NPC              ♠ Árbol      ≈ Agua     ♠ Arbol"));
        separadorMediosMapa();
        System.out.println(formatearMapa("Porfavor selecione una opcion"));
        separadorFinalMapa();
    }

    public void imprimidorDeMapaConInteracionGimnacio(Casillas[][] mapa, String nombre, Entrenador[] entrenadors,
            Npc LiderDeGimnacio, boolean activoDialogo) {
        Entrenador activo = null;
        if (entrenadors != null && entrenadors.length > 0) {
            activo = entrenadors[0];
        }
        imprimidorDeMapaConInteracionGimnacio(mapa, nombre, activo, activoDialogo);
    }

    public void imprimidorDeMapaConInteracionGimnacio(Casillas[][] mapa, String nombre, Entrenador entrenadorActivo,
            boolean activoDialogo) {
        separadorInicioMapa();
        System.out.println(formatearMapa(nombre));
        separadorFinalMapa();
        separadorInicialMapaSubMapa();
        for (Casillas[] casillas : mapa) {
            System.out.print(getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println(getMarcoVertical());
        }
        separadorFinalMapaSubMapa();
        separadorInicioMapa();
        System.out.println(formatearMapa("OBJETOS DEL MAPA"));
        separadorMediosMapa();
        System.out.println(formatearMapa("♜ Entrenador   ♛ Líder de Gimnasio   ⇩ Salida   "));
        separadorMediosMapa();
        System.out.println(formatearMapa("CONTROLES"));
        separadorMediosMapa();
        System.out.println(formatearMapa("    ┌───┐      "));
        System.out.println(formatearMapa("    │ W │      M → Mochila       F → Perfil          "));
        System.out.println(formatearMapa("┌───┼───┼───┐"));
        System.out.println(formatearMapa("│ A │ S │ D │  P → Pokémon       T → Pokédex       "));
        System.out.println(formatearMapa("└───┴───┴───┘"));
        separadorMediosMapa();
        if (activoDialogo && entrenadorActivo != null) {
            System.out.println(formatearMapa("DIALOGO"));
            separadorMediosMapa();
            String[] dialogo;

            if (entrenadorActivo.isDerrotado()) {
                dialogo = entrenadorActivo.getDialojo(3);
            } else {
                dialogo = entrenadorActivo.getDialojo(0);
            }

            if (dialogo != null) {
                for (String linea : dialogo) {
                    System.out.println(formatearMapa(linea));
                }
            }
            separadorMediosMapa();
            System.out.println(
                    formatearMapaCentrado("si quiere continuar hablando con el entrenador ingrese → C"));
            separadorMediosMapa();
        }
        System.out.println(formatearMapa("Porfavor selecione una opcion"));
        separadorFinalMapa();
    }

    public void imprimidorDeMapaConInteracionTienda(Casillas[][] mapa, String nombre, Npc vendedor,
            boolean activoDialogo) {
        separadorInicioMapa();
        System.out.println(formatearMapa(nombre));
        separadorFinalMapa();
        separadorInicialMapaSubMapa();
        for (Casillas[] casillas : mapa) {
            System.out.print(getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println(getMarcoVertical());
        }
        separadorFinalMapaSubMapa();
        separadorInicioMapa();
        System.out.println(formatearMapa("OBJETOS DEL MAPA"));
        separadorMediosMapa();
        System.out.println(formatearMapa("♙ Tienda   ⇩ Salida   "));
        separadorMediosMapa();
        System.out.println(formatearMapa("CONTROLES"));
        separadorMediosMapa();
        System.out.println(formatearMapa("    ┌───┐      "));
        System.out.println(formatearMapa("    │ W │      M → Mochila       F → Perfil          "));
        System.out.println(formatearMapa("┌───┼───┼───┐"));
        System.out.println(formatearMapa("│ A │ S │ D │  P → Pokémon       T → Pokédex       "));
        System.out.println(formatearMapa("└───┴───┴───┘"));
        separadorMediosMapa();
        if (activoDialogo) {
            System.out.println(formatearMapa("DIALOGO"));
            separadorMediosMapa();
            String[] dialogo = vendedor.getDialojo(0);
            for (String linea : dialogo) {
                System.out.println(formatearMapa(linea));
            }
            System.out.println(
                    formatearMapaCentrado("si quiere continuar hablando con el de la tienda  ingrese → C"));
            separadorMediosMapa();
        }
        System.out.println(formatearMapa("Porfavor selecione una opcion"));
        separadorFinalMapa();
    }

    public void imprimidorDeMapaConInteracioFarmacia(Casillas[][] mapa, String nombre, Npc enfermera,
            boolean activoDialogo, boolean enfermeraOTelevison) {
        separadorInicioMapa();
        System.out.println(formatearMapa(nombre));
        separadorFinalMapa();
        separadorInicialMapaSubMapa();
        for (Casillas[] casillas : mapa) {
            System.out.print(getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println(getMarcoVertical());
        }
        separadorFinalMapaSubMapa();
        separadorInicioMapa();

        System.out.println(formatearMapa("OBJETOS DEL MAPA"));
        separadorMediosMapa();
        System.out.println(formatearMapa("♥ Farmacia   ▣ Television⇩ Salida   "));
        separadorMediosMapa();
        System.out.println(formatearMapa("CONTROLES"));
        separadorMediosMapa();
        System.out.println(formatearMapa("    ┌───┐      "));
        System.out.println(formatearMapa("    │ W │      M → Mochila       F → Perfil          "));
        System.out.println(formatearMapa("┌───┼───┼───┐"));
        System.out.println(formatearMapa("│ A │ S │ D │  P → Pokémon       T → Pokédex       "));
        System.out.println(formatearMapa("└───┴───┴───┘"));
        separadorMediosMapa();
        if (activoDialogo && enfermeraOTelevison) {
            System.out.println(formatearMapa("DIALOGO"));
            separadorMediosMapa();
            String[] dialogo = enfermera.getDialojo(0);
            for (String linea : dialogo) {
                System.out.println(formatearMapa(linea));
            }
            separadorMediosMapa();
            System.out.println(formatearMapaCentrado("si quiere continuar hablando con la enfermera ingrese → C"));
            separadorMediosMapa();
        }
        if (activoDialogo && !enfermeraOTelevison) {
            System.out.println(formatearMapa("DIALOGO"));
            separadorMediosMapa();

            System.out.println(formatearMapaCentrado("Si quieres ver la television ingrese → C"));
            separadorMediosMapa();
        }
        System.out.println(formatearMapa("Porfavor selecione una opcion"));
        separadorFinalMapa();
    }

}
