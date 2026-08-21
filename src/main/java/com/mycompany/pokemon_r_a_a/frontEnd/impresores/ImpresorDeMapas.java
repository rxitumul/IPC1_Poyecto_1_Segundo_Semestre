
package com.mycompany.eljuegodeender.impresores;

import com.mycompany.eljuegodeender.casilla.Casilla;
import com.mycompany.eljuegodeender.componentes.Componentes;
import com.mycompany.eljuegodeender.configuracion.Configuraciones;
import com.mycompany.eljuegodeender.exepcion.ReturnNullExepcion;
import com.mycompany.eljuegodeender.naves.Naves;
import com.mycompany.eljuegodeender.objetos.Objetos;
import com.mycompany.eljuegodeender.pilotos.Piloto;
import com.mycompany.eljuegodeender.statusDeJuego.VentaCompraPrecios;

/**
 *
 * @author estebancastillo
 */
public class ImpresorDeMapas {

    private int cr;
    private int pt;
    private int estrellasNoLiberadas;
    private int estrellasLiberadas;
    private int bases;
    private String nombreNave;
    private String nombrePiloto;
    private Configuraciones confi;

    public void setValores(int estrellas, int crE, int ptE, Configuraciones confiE) {
        cr = crE;
        pt = ptE;
        estrellasNoLiberadas = estrellas;
        confi = confiE;
    }

    public void getLimpiadorDeley() {
        confi.delayThread();
    }

    public void limpiadorPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void imprimirFlota(Naves[] naveE) {
        Componentes[] componentes;
        double[] stadsNave;
        Piloto pilotoA;
        for (int i = 0; i < 3; i++) {
            try {

                if (naveE[i] != null) {
                    nombreNave = naveE[i].getNombre();
                } else {
                    nombreNave = "Disponible";
                }
            } catch (Exception e) {
                nombreNave = "Disponible";
            }
            try {
                pilotoA = naveE[i].getPiloto();
                nombrePiloto = pilotoA.getNombre();
            } catch (ReturnNullExepcion | NullPointerException e) {
                nombrePiloto = "Disponible";
            }
            confi.separadoresIniciales();
            System.out.printf("| %-50s%-49s|%n", "Nombre nave: " + nombreNave, "Nombre piloto: " + nombrePiloto);
            confi.separadoresMedios();
            try {
                componentes = naveE[i].getComponentes();
                System.out.printf("|%-100s|%n", "Componetes Nave");
                confi.separadoresMedios();
                for (Componentes componentes2 : componentes) {
                    if (componentes2 instanceof VentaCompraPrecios componete) {
                        System.out.printf("| %-99s|%n", componete.getNombre());
                    }
                }
                confi.separadoresMedios();
                System.out.printf("|%-100s|%n", "Estado nave");
                stadsNave = naveE[i].getStads();
                System.out.printf("|%-33s%-33s%-34s|%n", "Vida nave: " + stadsNave[0], " Escudo nave: " + stadsNave[2],
                        " Energia nave: " + stadsNave[1]);
            } catch (ReturnNullExepcion | NullPointerException e) {
                System.out.printf("|%-100s|%n", " ");
            }
            confi.separadoresFinales();

        }

    }

    public void imprimirMapaObjetos(Casilla[][] mapa, Naves[] naveE, Objetos[] objetos) {

        String objetoNombreUno = "";
        String objetoNombreDos = "";
        int objetoCantidadUno = 0;
        int objetoCantidadDos = 0;
        Piloto piloto;
        confi.separadoresIniciales();

        System.out.printf("|%-20s%-20s%-20s%36s|%n", "CR " + cr, "PT " + pt,
                "Estrellas Libreradas " + estrellasLiberadas + "/" + estrellasNoLiberadas,
                "Bases derotadas " + bases);
        confi.separadoresMedios();
        for (Casilla[] casillas : mapa) {
            System.out.print("|");
            for (Casilla casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println("|");
        }
        confi.separadoresMedios();
        System.out.printf("|%-21s%-26s|%-52s|%n", "Flota", "Pilotos", "Objetos");
        for (int i = 0; i < 3; i++) {
            try {
                if (objetos[i] instanceof VentaCompraPrecios objeto1) {
                    objetoNombreUno = objeto1.getNombre();
                }
                objetoCantidadUno = objetos[i].getCantidadUsos();
                if (objetos[i + 3] instanceof VentaCompraPrecios objeto2) {
                    objetoNombreDos = objeto2.getNombre();
                }
                objetoCantidadDos = objetos[i + 3].getCantidadUsos();
                nombreNave = naveE[i].getNombre();
                try {
                    piloto = naveE[i].getPiloto();
                    nombrePiloto = piloto.getNombre();
                } catch (ReturnNullExepcion e) {
                    nombrePiloto = "";
                }
            } catch (NullPointerException|ReturnNullExepcion e) {
                nombreNave = " ";
                nombrePiloto = " ";
            }
            System.out.printf("| %-21s%-25s| %-28s%23s|%n", nombreNave, nombrePiloto,
                    objetoNombreUno + ": " + objetoCantidadUno,
                    objetoNombreDos + ": " + objetoCantidadDos);
        }
        confi.separadoresFinales();
    }

    public void setEstrellasLiberadas(int estrellas) {
        estrellasLiberadas = estrellas;
    }

    public void setBasesEnemigasDerrotadas(int basesEnemigas) {
        bases = basesEnemigas;
    }

}
