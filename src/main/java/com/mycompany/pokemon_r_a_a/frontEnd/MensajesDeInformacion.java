package com.mycompany.pokemon_r_a_a.frontEnd;

public class MensajesDeInformacion extends ImpresoresGlobal {


    public void pantallaDeError() {
        delayThread();
        System.out.print(NARANJA);
        limpiadorDeLineas();
        separadorInicio();
        System.out.println(formatearCentrado("Error: Opción inválida"));
        System.out.println(formatearCentrado("Por favor, seleccione una opción válida"));
        separadorFinal();
        System.out.print(RESET);
    }

    public void mensajeInformativo(String mensaje) {
        delayThread();
        limpiadorDeLineas();
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado(mensaje));
        separadorFinalMapa();
    }

    public void mensajeInformativoDecontinuar() {
        System.out.println(formatearCentrado("Presione enter para continuar....."));
    }

    public void mensajeDeIngresoDeNombre() {
        System.out.println(formatearCentrado("Ingrese el nombre a utilizar"));
    }
}
