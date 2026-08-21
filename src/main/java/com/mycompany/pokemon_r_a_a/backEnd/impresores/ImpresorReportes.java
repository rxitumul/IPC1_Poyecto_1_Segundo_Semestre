package com.mycompany.eljuegodeender.impresores;

import com.mycompany.eljuegodeender.configuracion.Configuraciones;

public class ImpresorReportes {
    private static final String IMPRESOR_TAMAnO_100 = "|%-100s|%n";
    private Configuraciones confi = new Configuraciones();
    // 0 1 2 3 4
    private static final String[] NAVES_NOMBRES = { "Acorazados", "Cazas", "Fragatas", "Naves de apoyo", "Jefes" };
    // 0 1 2 3 4 5
    private static final String[] ARMAS_NOMBRES = { "Campo de minas", "Canon de iones", "Laza torpedos",
            "Laser de pulsos", "Misil teledirigido", "Rayo de particulas" };

    public void getLimpiadorDeley() {
        confi.delayThread();
    }

    public void limpiadorPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void impresorMenuReportes(boolean reporteReportes,String nombrePartida,
            String partidaGanadoPerdida,
            int[] cantidadDeNavesEnemigasDerrotadasPorTipo,
            int[] cantidadDeNavesAmigasDestruidasPorTipo,
            int[] cantidadDeDanoRealizadoPorNavePorTipo,
            int[] cantidadDeVecesQueSeDisparoCadaArma,
            int cantidadDeNavesEnemigasDerotadas) {
        confi.separadoresIniciales();
        System.out.printf("%-39s%s%39s%n", "|", "REGISTRO DE ESTRATEGICO ", "|");
        confi.separadoresMedios();
        if(reporteReportes){
            System.out.printf(IMPRESOR_TAMAnO_100, "Nombre de la partida: " + nombrePartida);
            System.out.printf(IMPRESOR_TAMAnO_100, "Resultado: " + partidaGanadoPerdida);
        }else{
            System.out.printf(IMPRESOR_TAMAnO_100,"Partida actual");
        }

        confi.separadoresMedios();
        System.out.printf(IMPRESOR_TAMAnO_100, "Naves enemigas derrotadas por tipo:");
        if (cantidadDeNavesEnemigasDerrotadasPorTipo != null) {
            for (int i = 0; i < cantidadDeNavesEnemigasDerrotadasPorTipo.length; i++) {
                System.out.printf(IMPRESOR_TAMAnO_100,
                        "  Tipo " + NAVES_NOMBRES[i] + ": " + cantidadDeNavesEnemigasDerrotadasPorTipo[i]);
            }
        }
        System.out.printf(IMPRESOR_TAMAnO_100,
                "Total de naves enemigas derrotadas: " + cantidadDeNavesEnemigasDerotadas);
        confi.separadoresMedios();

        System.out.printf(IMPRESOR_TAMAnO_100, "Naves amigas destruidas por tipo:");
        if (cantidadDeNavesAmigasDestruidasPorTipo != null) {
            for (int i = 0; i < cantidadDeNavesAmigasDestruidasPorTipo.length; i++) {
                System.out.printf(IMPRESOR_TAMAnO_100,
                        "  Tipo " + NAVES_NOMBRES[i] + ": " + cantidadDeNavesAmigasDestruidasPorTipo[i]);
            }
        }
        confi.separadoresMedios();
        System.out.printf(IMPRESOR_TAMAnO_100, "Dano realizado por nave por tipo:");
        if (cantidadDeDanoRealizadoPorNavePorTipo != null) {
            for (int i = 0; i < cantidadDeDanoRealizadoPorNavePorTipo.length; i++) {
                System.out.printf(IMPRESOR_TAMAnO_100,
                        "  Tipo " + NAVES_NOMBRES[i] + ": " + cantidadDeDanoRealizadoPorNavePorTipo[i]);
            }
        }
        confi.separadoresMedios();

        System.out.printf(IMPRESOR_TAMAnO_100, "Cantidad de veces que se disparó cada arma: ");
        if (cantidadDeVecesQueSeDisparoCadaArma != null) {
            for (int i = 0; i < cantidadDeVecesQueSeDisparoCadaArma.length; i++) {
                System.out.printf(IMPRESOR_TAMAnO_100,
                        "  Arma " + ARMAS_NOMBRES[i] + ": " + cantidadDeVecesQueSeDisparoCadaArma[i]);
            }
        }
        confi.separadoresMedios();
        System.out.printf(IMPRESOR_TAMAnO_100, "Presiona ENTER para regresar...");
        confi.separadoresFinales();
    }
}
