package com.mycompany.pokemon_r_a_a.frontEnd.Menus;

import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

public class MenuInicialFront {
private ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();
    public void menu(){
        confi.delayThread();
            confi.limpiadorDeLineas();
            confi.separadorInicio();
            System.out.println(confi.formatearCentrado(""));
            System.out.println(confi.formatearCentrado("¡BIENVENIDO AL MUNDO POKÉMON!"));
            System.out.println(confi.formatearCentrado("POKÉMON R_A_A - EDICIÓN CONSOLA"));
            System.out.println(confi.formatearCentrado(""));
            confi.separadorMedios();
            System.out.println(confi.formatearCentrado("[01] Iniciar Nueva Aventura"));
            System.out.println(confi.formatearCentrado("[02] Cargar Partida Guardada"));
            System.out.println(confi.formatearCentrado("[04] Salir del Juego"));
            confi.separadorMedios();
            System.out.println(confi.formatearCentrado("Seleccione una opción: "));
            confi.separadorFinal();
    }

}
