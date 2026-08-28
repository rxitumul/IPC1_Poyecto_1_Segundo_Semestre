package com.mycompany.pokemon_r_a_a.frontEnd;

public class MensajesDeInformacion {
    private ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();

    public void pantallaDeError() {
        confi.delayThread();
        System.out.print("\033[38;5;208m");
        confi.limpiadorDeLineas();
        confi.separadorInicio();
        System.out.println(confi.formatearCentrado("Error: Opción inválida"));
        System.out.println(confi.formatearCentrado("Por favor, seleccione una opción válida"));
        confi.separadorFinal();
        System.out.print("\033[0m");
    }

    public void mensajeInformativo(String mensaje) {
        confi.delayThread();
        confi.limpiadorDeLineas();
        confi.separadorInicioMapa();
        System.out.println(confi.formatearMapaCentrado(mensaje));
        confi.separadorFinalMapa();
    }

    public void mensajeInformativoDecontinuar() {
        System.out.println(confi.formatearCentrado("Presione enter para continuar....."));
    }

    public void mensajeDeIngresoDeNombre() {
        System.out.println(confi.formatearCentrado("Ingrese el nombre a utilizar"));
    }
}
