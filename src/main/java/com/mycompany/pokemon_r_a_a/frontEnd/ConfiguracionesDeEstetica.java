package com.mycompany.pokemon_r_a_a.frontEnd;

public class ConfiguracionesDeEstetica {

    private static final int SEPARACION_DE_BORDES = 140;
    private final int TIEMPO = 1100;
    private final static String LIMPIADOR_DE_PANTALLA = "\033[H\033[2J";

    private final static String MARCO_HORIZONTAL = "═";
    private final static String MARCO_VERTICAL = "║";
    private final static String MARCO_ESQUINA_DERECHA_SUPERIOR = "╗";
    private final static String MARCO_ESQUINA_IZQUIERDA_SUPERIOR = "╔";
    private final static String MARCO_ESQUINA_DERECHA_INFERIOR = "╗";
    private final static String MARCO_ESQUINA_IZQUIERDA_INFERIOR = "╔";
    private final static String MARCO_VERTICAL_INTERCECION_DERECHA = "╣";
    private final static String MARCO_VERTICAL_INTERCECION_IZQUIERDA = "╠";
    private final static String MARCO_HORIZONTAL_INTERCECION_HACIA_ARRIBA = "╩";
    private final static String MARCO_HORIZONTAL_INTERCECION_HACIA_ABAJO = "╦";
    private final static String MARCO_INTERCECION_CUATRUPLE = "╬";

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

    public void delayThread() {
        try {
            Thread.sleep(TIEMPO);
        } catch (InterruptedException ex) {
        }

        System.out.flush();
    }

    public void pantallaDeError() {
        delayThread();
        System.out.print("\033[38;5;208m");
        limpiadorDeLineas();
        separadorInicio();
        System.out.println(formatear("Error: Opción inválida"));
        System.out.println(formatear("Por favor, seleccione una opción válida"));
        separadorFinal();
        System.out.print("\033[0m");
    }

}
