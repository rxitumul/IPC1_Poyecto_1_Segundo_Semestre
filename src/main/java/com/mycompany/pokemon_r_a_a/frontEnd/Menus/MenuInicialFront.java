package com.mycompany.pokemon_r_a_a.frontEnd.Menus;

import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class MenuInicialFront extends ImpresoresGlobal {

    public void menu() {
        delayThread();
        limpiadorDeLineas();
        separadorInicio();
        System.out.println(formatearCentrado(""));
        System.out.println(formatearCentrado("¡BIENVENIDO AL MUNDO POKÉMON!"));
        System.out.println(formatearCentrado("POKÉMON R_A_A - EDICIÓN CONSOLA"));
        System.out.println(formatearCentrado(""));
        separadorMedios();
        System.out.println(formatearCentrado("[01] Iniciar Nueva Aventura"));
        System.out.println(formatearCentrado("[02] Cargar Partida Guardada"));
        System.out.println(formatearCentrado("[03] Salir del Juego"));
        separadorMedios();
        System.out.println(formatearCentrado("Seleccione una opción: "));
        separadorFinal();
    }

}
