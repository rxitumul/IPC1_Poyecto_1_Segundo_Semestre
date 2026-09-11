package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;
import com.mycompany.pokemon_r_a_a.frontEnd.Menus.MenuInicialFront;

public class MenuPrincipal {

    private Scanner scanner;
    private MenuInicialFront menu;
    private ImpresoresGlobal info;

    public MenuPrincipal(Scanner scanner) {
        this.scanner = scanner;
        menu = new MenuInicialFront();
        info = new ImpresoresGlobal();
    }

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        info = new ImpresoresGlobal();
        menu = new MenuInicialFront();
    }

    public int menuInicial() {
        String opcionJugador;

        do {
            menu.menu();
            opcionJugador = scanner.nextLine();
            switch (opcionJugador) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default:
                    info.pantallaDeError();
                    break;
            }
        } while (true);
    }
}
