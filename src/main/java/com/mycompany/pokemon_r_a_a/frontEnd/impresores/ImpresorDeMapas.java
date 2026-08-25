
package com.mycompany.pokemon_r_a_a.frontEnd.impresores;

import com.mycompany.pokemon_r_a_a.backEnd.ListaDeBuff.Objetos;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.Pokemons;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;

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
    private ConfiguracionesDeEstetica confi;

    public void setValores(int estrellas, int crE, int ptE, ConfiguracionesDeEstetica confiE) {
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

    public void imprimirMapaObjetos(Casillas[][] mapa, Pokemons[] pokemonE, Objetos[] objetos) {

        confi.separadorInicio();

        System.out.printf("|%-20s%-20s%-20s%36s|%n", "CR " + cr, "PT " + pt,
                "Estrellas Libreradas " + estrellasLiberadas + "/" + estrellasNoLiberadas,
                "Bases derotadas " + bases);
        confi.separadorMedios();
        for (Casillas[] casillas : mapa) {
            System.out.print(confi.getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println();
        }
        confi.separadorMedios();
        System.out.printf("|%-21s%-26s|%-52s|%n", "Flota", "Pilotos", "Objetos");
        /* 
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
        */
        confi.separadorFinal();
    }

    public void setEstrellasLiberadas(int estrellas) {
        estrellasLiberadas = estrellas;
    }

    public void setBasesEnemigasDerrotadas(int basesEnemigas) {
        bases = basesEnemigas;
    }

}
