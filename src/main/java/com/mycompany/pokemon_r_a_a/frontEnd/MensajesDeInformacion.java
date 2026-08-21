package com.mycompany.pokemon_r_a_a.frontEnd;

public class MensajesDeInformacion {
    private ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();

    public void pantallaDeError() {
        confi.delayThread();
        System.out.print("\033[38;5;208m");
        confi.limpiadorDeLineas();
        confi.separadorInicio();
        System.out.println(confi.formatear("Error: Opción inválida"));
        System.out.println(confi.formatear("Por favor, seleccione una opción válida"));
        confi.separadorFinal();
        System.out.print("\033[0m");
    }

    public void mensajeInformativoDecontinuar(){
        System.out.println(confi.formatear("Presione enter para continuar....."));
    }
    public void mensajeDeIngresoDeNombre(){
        System.out.println(confi.formatear("Ingrese el nombre a utilizar"));
    }
}
