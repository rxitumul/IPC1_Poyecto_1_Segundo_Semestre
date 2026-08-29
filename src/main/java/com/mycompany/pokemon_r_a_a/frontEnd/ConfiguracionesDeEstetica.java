package com.mycompany.pokemon_r_a_a.frontEnd;

public class ConfiguracionesDeEstetica {

    private static final int SEPARACION_DE_BORDES = 124;
    private static final int SEPARACION_DE_BORDES_MAPA = 75;
    private static final int CUATRO = 4;
    private static final int CATORCE = 14;

    private final static int TIEMPO_DE_ESPERA = 200;
    private final static String LIMPIADOR_DE_PANTALLA = "\033[H\033[2J";
    private final static String LIMPIADOR_DECOLORES = "\u001B\\[[;\\d]*m";

    private final static String MARCO_HORIZONTAL = "═";
    private final static String MARCO_VERTICAL = "║";
    private final static String MARCO_ESQUINA_DERECHA_SUPERIOR = "╗";
    private final static String MARCO_ESQUINA_IZQUIERDA_SUPERIOR = "╔";
    private final static String MARCO_ESQUINA_DERECHA_INFERIOR = "╝";
    private final static String MARCO_ESQUINA_IZQUIERDA_INFERIOR = "╚";
    private final static String MARCO_VERTICAL_INTERCECION_DERECHA = "╣";
    private final static String MARCO_VERTICAL_INTERCECION_IZQUIERDA = "╠";
    private final static String MARCO_HORIZONTAL_INTERCECION_HACIA_ARRIBA = "╩";
    private final static String MARCO_HORIZONTAL_INTERCECION_HACIA_ABAJO = "╦";
    private final static String MARCO_INTERCECION_CUATRUPLE = "╬";

    public void limpiadorPantalla() {
        System.out.print(LIMPIADOR_DE_PANTALLA);
        System.out.flush();
    }

    public void separadorInicio() {
        System.out.println(MARCO_ESQUINA_IZQUIERDA_SUPERIOR + MARCO_HORIZONTAL.repeat(SEPARACION_DE_BORDES)
                + MARCO_ESQUINA_DERECHA_SUPERIOR);
    }

    public void separadorMedios() {
        System.out.println(MARCO_VERTICAL_INTERCECION_IZQUIERDA + MARCO_HORIZONTAL.repeat(SEPARACION_DE_BORDES)
                + MARCO_VERTICAL_INTERCECION_DERECHA);
    }

    public void separadorFinal() {
        System.out.println(MARCO_ESQUINA_IZQUIERDA_INFERIOR + MARCO_HORIZONTAL.repeat(SEPARACION_DE_BORDES)
                + MARCO_ESQUINA_DERECHA_INFERIOR);
    }

    public void separadorInicioMapa() {
        System.out.println(MARCO_ESQUINA_IZQUIERDA_SUPERIOR + MARCO_HORIZONTAL.repeat(SEPARACION_DE_BORDES_MAPA)
                + MARCO_ESQUINA_DERECHA_SUPERIOR);
    }

    public void separadorMediosMapa() {
        System.out.println(MARCO_VERTICAL_INTERCECION_IZQUIERDA + MARCO_HORIZONTAL.repeat(SEPARACION_DE_BORDES_MAPA)
                + MARCO_VERTICAL_INTERCECION_DERECHA);
    }

    public void separadorFinalMapa() {
        System.out.println(MARCO_ESQUINA_IZQUIERDA_INFERIOR + MARCO_HORIZONTAL.repeat(SEPARACION_DE_BORDES_MAPA)
                + MARCO_ESQUINA_DERECHA_INFERIOR);
    }

    public void limpiadorDeLineas() {
        System.out.print(LIMPIADOR_DE_PANTALLA);
    }

    public String formatear(String texto) {
        int interior = SEPARACION_DE_BORDES;

        if (texto.length() > interior) {
            texto = texto.substring(0, interior);
        }

        return MARCO_VERTICAL + String.format("%-" + interior + "s", texto) + MARCO_VERTICAL;
    }

    public String formatearCentrado(String texto) {
        int interior = SEPARACION_DE_BORDES;
        String textoLimpio = texto.replaceAll(LIMPIADOR_DECOLORES, "");
        int visibleLength = textoLimpio.length();

        if (visibleLength > interior) {
            texto = texto.substring(0, interior);
            visibleLength = interior;
        }

        int espacioTotal = interior - visibleLength;
        int paddingIzquierda = espacioTotal / 2;
        int paddingDerecha = espacioTotal - paddingIzquierda;

        return MARCO_VERTICAL + " ".repeat(paddingIzquierda) + texto + " ".repeat(paddingDerecha) + MARCO_VERTICAL;
    }

    public String formatearMapa(String texto) {
        int interior = SEPARACION_DE_BORDES_MAPA;
        

        if (texto.length() > interior) {
            texto = texto.substring(0, interior);
        }

        return MARCO_VERTICAL + String.format("%-" + interior + "s", texto) + MARCO_VERTICAL;
    }

    public String formatearMapaCentrado(String texto) {
        int interior = SEPARACION_DE_BORDES_MAPA;
        String textoLimpio = texto.replaceAll(LIMPIADOR_DECOLORES, "");
        int visibleLength = textoLimpio.length();

        if (visibleLength > interior) {
            texto = texto.substring(0, interior);
            visibleLength = interior;
        }

        int espacioTotal = interior - visibleLength;
        int paddingIzquierda = espacioTotal / 2;
        int paddingDerecha = espacioTotal - paddingIzquierda;

        return MARCO_VERTICAL + " ".repeat(paddingIzquierda) + texto + " ".repeat(paddingDerecha) + MARCO_VERTICAL;
    }

    public void inicioDeTabla() {
        System.out.println(
                MARCO_ESQUINA_IZQUIERDA_SUPERIOR + MARCO_HORIZONTAL.repeat(CUATRO)
                        + MARCO_HORIZONTAL_INTERCECION_HACIA_ABAJO
                        + MARCO_HORIZONTAL.repeat(CATORCE) + MARCO_ESQUINA_DERECHA_SUPERIOR);
    }

    public void finDeTabla() {
        System.out.println(
                MARCO_ESQUINA_IZQUIERDA_INFERIOR + MARCO_HORIZONTAL.repeat(CUATRO)
                        + MARCO_HORIZONTAL_INTERCECION_HACIA_ARRIBA
                        + MARCO_HORIZONTAL.repeat(CATORCE) + MARCO_ESQUINA_DERECHA_INFERIOR);
    }

    public void mediosDeTabla() {
        System.out.println(
                MARCO_VERTICAL_INTERCECION_IZQUIERDA + MARCO_HORIZONTAL.repeat(CUATRO) + MARCO_INTERCECION_CUATRUPLE
                        + MARCO_HORIZONTAL.repeat(CATORCE) + MARCO_VERTICAL_INTERCECION_DERECHA);
    }

    public String formatoTabla(String nombre, String id) {
        return MARCO_VERTICAL + formatearCentradoTablaDinamico(id, CUATRO) + MARCO_VERTICAL
                + formatearCentradoTablaDinamico(nombre, CATORCE) + MARCO_VERTICAL;

    }

    public String getMarcoVertical() {
        return MARCO_VERTICAL;
    }

    public void delayThread() {
        try {
            Thread.sleep(TIEMPO_DE_ESPERA);
        } catch (InterruptedException ex) {
        }

        System.out.flush();
    }

    private String formatearCentradoTablaDinamico(String texto, int ancho) {
        int interior = ancho;
        String textoLimpio = texto.replaceAll(LIMPIADOR_DECOLORES, "");
        int visibleLength = textoLimpio.length();

        if (visibleLength > interior) {
            texto = texto.substring(0, interior);
            visibleLength = interior;
        }

        int espacioTotal = interior - visibleLength;
        int paddingIzquierda = espacioTotal / 2;
        int paddingDerecha = espacioTotal - paddingIzquierda;

        return " ".repeat(paddingIzquierda) + texto + " ".repeat(paddingDerecha);
    }
}
