package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.frontEnd.InformacionProfesor.InicioProfesor;

public class ProfesorCharla {
    private InicioProfesor profesor = new InicioProfesor();
    Scanner scanner = new Scanner(System.in);
    int pokemnSelecionado;

    public void charlaInicial() {
        int contadorMensajes = 0;
        while (contadorMensajes == 4) {
            profesor.cadenaDeMensajesInicial(contadorMensajes);
            contadorMensajes++;
            if (contadorMensajes == 4) {
                profesor.setNombre(scanner.nextLine());
            } else {
                scanner.nextLine();
            }
        }
        contadorMensajes = 0;
        while (contadorMensajes == 5) {
            profesor.mensajeDespuesDenombre(contadorMensajes);
            contadorMensajes++;
            if (contadorMensajes != 5) {
                scanner.nextLine();
            }
        }
        profesor.mensajeDeElecionDePokemon();
        pokemnSelecionado = Integer.parseInt(scanner.nextLine());

        
    }
}
