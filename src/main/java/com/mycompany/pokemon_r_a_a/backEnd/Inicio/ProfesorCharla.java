package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.frontEnd.InformacionProfesor.InicioProfesor;

public class ProfesorCharla {
    private InicioProfesor profesor = new InicioProfesor();
    Scanner scanner = new Scanner(System.in);
    public void charlaInicial (){
        int contadorMensajes= 0; 
        while (true) {
            profesor.cadenaDeMensajesInicial(contadorMensajes);
            scanner.nextLine();
        }
    }
}
