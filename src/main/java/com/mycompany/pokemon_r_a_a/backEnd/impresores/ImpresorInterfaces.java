package com.mycompany.eljuegodeender.impresores;

import com.mycompany.eljuegodeender.componentes.Componentes;
import com.mycompany.eljuegodeender.configuracion.Configuraciones;
import com.mycompany.eljuegodeender.exepcion.ReturnNullExepcion;
import com.mycompany.eljuegodeender.naves.Naves;
import com.mycompany.eljuegodeender.objetos.Objetos;
import com.mycompany.eljuegodeender.statusDeJuego.VentaCompraPrecios;

public class ImpresorInterfaces {
    private Configuraciones confi = new Configuraciones();

    public void impresorBatalla(Naves[] naves, Naves[] naveBoss) {
        confi.separadoresIniciales();
        int tamanoEnemigo = naveBoss.length;
        if (tamanoEnemigo > 1) {

            for (int i = 0; i < tamanoEnemigo; i++) {
                try {
                    if (naves[i].getNaveViva()) {
                        System.out.printf("%s%-57s", "|  ", naves[i].imprimir(false));
                    } else {
                        System.out.printf("%-51s", "|");
                    }
                } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                    System.out.printf("%-51s", "|");
                }

                try {
                    if (naveBoss[i].getNaveViva()) {
                        System.out.printf("%58s |%n", naveBoss[i].imprimir(true));
                    } else {
                        System.out.printf("%51s%n", "|");
                    }
                } catch (NullPointerException e) {
                    System.out.printf("%51s%n", "|");
                }

            }

        } else {
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.printf("%s%-57s", "|  ", naves[i].imprimir(false));
                } catch (NullPointerException e) {
                    System.out.printf("%-51s", "|");
                }
                if (i == 1) {
                    System.out.printf("%58s |%n", naveBoss[0].imprimir(true));
                } else {
                    System.out.printf("%51s%n", "|");
                }
            }
        }
        confi.separadoresFinales();
    }

    public void impresorAcion(String naveEnTurno) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "Es el turno de la nave " + naveEnTurno);
        System.out.printf("|%-20s%-20s%-20s%-20s%-20s|%n", "Atacar [01]", "Componente [02]", "Objeto [03]",
                "Saltar [04]", "Hab. piloto [05]");
        confi.separadoresFinales();
    }

    public void impresorEstadoDeNave(Naves nave) {
        double[] standsNave = nave.getStads();
        try {
            if (!nave.getTurnoPerdido()) {
                if (nave != null) {
                    if ("amiga".equals(nave.getTipo())) {
                        System.out.println("\u001B[32m");
                    } else {
                        System.out.println("\u001B[31m");
                    }
                    confi.separadoresIniciales();
                    System.out.printf("|%-100s|%n", "Nave " + nave.getTipo() + " " + nave.getNombre());
                    System.out.printf("|%-25s%-25s%-25s%-25s|%n", "HP = " + standsNave[0], "SHP = " + standsNave[2],
                            "SP = " + standsNave[3], "EP = " + standsNave[1]);
                    confi.separadoresFinales();
                    System.out.println("\u001B[0m");
                }
            }
        } catch (ReturnNullExepcion e) {
        }
    }

    public void impresorDecicionAtaque(Componentes[] componentes, String accion) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "Eliga una de las siguientes " + accion);
        confi.separadoresMedios();
        for (int i = 0; i < componentes.length; i++) {
            if (componentes[i] instanceof VentaCompraPrecios componete) {
                try {

                    if (componete.getNombre() != null) {
                        System.out.printf("|%-100s|%n", i + 1 + ":" + componete.getNombre());
                    } else {
                        break;
                    }
                } catch (ReturnNullExepcion e) {
                }
            }
        }
        confi.separadoresFinales();
    }

    public void impresorDano(int dano, boolean minas) {
        confi.separadoresIniciales();
        if (minas) {
            System.out.printf("|%-100s|%n", "dano mina ");
        }
        System.out.printf("|%-100s|%n", "se a atacado y se hizo un dano de " + dano);
        confi.separadoresFinales();
    }

    public void impresorDeNavesAmigas(Naves[] amigas) {
        int contador = 1;
        confi.separadoresIniciales();

        for (Naves naves : amigas) {
            try {
                if (naves != null) {
                    System.out.printf("|%-100s|%n",
                            "[0" + contador + "] " + naves.getNombre() + " nave actual con vida: "
                                    + naves.getNaveViva());
                    contador++;
                }
            } catch (NullPointerException | ReturnNullExepcion e) {
                break;
            }
        }
        confi.separadoresFinales();

    }

    public void impresorDecicionAtaqueEnemigo(Naves[] enemigas, boolean enemigosAmigos) {
        int contador = 1;
        confi.separadoresIniciales();

        for (Naves naves : enemigas) {
            try {
                if (naves.getNaveViva()) {
                    System.out.printf("|%-100s|%n", "[0" + contador + "] " + naves.getNombre());
                    naves.imprimir(enemigosAmigos);
                    contador++;
                }
            } catch (NullPointerException | ReturnNullExepcion e) {
                break;
            }
        }
        confi.separadoresFinales();
    }

    public void impresorDecicionObjetos(Objetos[] objetos) {
        int cantidadObjeto;
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "Objetos disponibles ");
        confi.separadoresMedios();
        System.out.printf("|%-50s%50s|%n", "Nombre del objeto", "Cantidad del objeto");
        confi.separadoresMedios();
        for (int i = 0; i < objetos.length; i++) {
            try {

                cantidadObjeto = objetos[i].getCantidadUsos();
                String nombreObjeto = "Sin nombre";
                if (objetos[i] instanceof VentaCompraPrecios objeto) {

                    nombreObjeto = objeto.getNombre();
                }
                System.out.printf("|%-50s%50s|%n", "[0" + (i + 1) + "] " + nombreObjeto, "[0" + cantidadObjeto + "]");
            } catch (ReturnNullExepcion e) {
            }
        }
        confi.separadoresFinales();
    }

    public void mensajeIntermedio(String mensaje) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", mensaje);
        confi.separadoresFinales();
    }

    public void cargando() {
        int contador = 0;
        do {

            System.out.printf("|%-100s|%n", "cargando .");
            System.out.print("\033[H\033[2J");
            System.out.printf("|%-100s|%n", "cargando ..");
            System.out.print("\033[H\033[2J");
            System.out.printf("|%-100s|%n", "cargando ...");
            contador++;
        } while (contador == 3);
        confi.delayThread();
    }

    public void getLimpiadorDeley() {
        confi.delayThread();
    }

    public void limpiadorPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}