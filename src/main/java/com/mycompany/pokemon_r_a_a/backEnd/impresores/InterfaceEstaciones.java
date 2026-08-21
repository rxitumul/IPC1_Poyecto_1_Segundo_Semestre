package com.mycompany.eljuegodeender.impresores;

import com.mycompany.eljuegodeender.componentes.Componentes;
import com.mycompany.eljuegodeender.configuracion.Configuraciones;
import com.mycompany.eljuegodeender.exepcion.ReturnNullExepcion;
import com.mycompany.eljuegodeender.naves.Naves;
import com.mycompany.eljuegodeender.statusDeJuego.EstatusJuego;
import com.mycompany.eljuegodeender.statusDeJuego.VentaCompraPrecios;

public class InterfaceEstaciones {
    private Configuraciones confi = new Configuraciones();

    public void getLimpiadorDeley() {
        confi.delayThread();
    }

    public void limpiadorPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void impresionDeEstacionMenu() {
        confi.separadoresIniciales();
        System.out.printf("%-42s%s%42s%n", "|", "ESTACIÓN  ESPACIAL", "|");
        confi.separadoresMedios();
        System.out.printf("%-43s%s%43s%n", "|", "ESTACION  ACTIVA", "|");
        confi.separadoresMedios();
        System.out.printf("|%-25s%-29s%-23s%-23s|%n", "MODULO DE COMERCIO [01]", "MODULO DE MANTENIMIENTO [02]",
                "Barracas [03]", "Salir [04]");
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "SELECCIONE UNA OPCIÓN");
        confi.separadoresFinales();
    }

    public void impresorDeModuloDeComercio(int creditoDisponible) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "MODULO DE COMERCIO | Venta");
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "CREDITOS: " + creditoDisponible);
        confi.separadoresMedios();
        System.out.printf("|%-25s%-25s%-25s%-25s|%n", "Naves [01]", "Componentes [02]", "Consumibles [03]",
                "Regresar[04]");
        opcionDecicion(false);
    }

    public void impresorDecicionDelModuloDeComercio(int creditoDisponible) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "MODULO DE COMERCIO");
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "CREDITOS: " + creditoDisponible);
        confi.separadoresMedios();
        System.out.printf("|%-33s%-33s%-34s|%n", "Vender [01]", "Comprar [02]", "Regresar [03]");
        opcionDecicion(false);
    }

    public void imprecionDeModuloMantenimientoInicio(int puntosDeTecnologiaDisponibles, int creditoDisponible) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "MODULO DE MANTENIMIENTO");
        confi.separadoresMedios();
        System.out.printf("|%-50s%-50s|%n", "PUNTOS DE TECNOLOGIA: " + puntosDeTecnologiaDisponibles,
                "CREDITOS: " + creditoDisponible);
        confi.separadoresMedios();
        System.out.printf("|%-33s%-34s%-33s|%n", "Flota [01]", "Agregar a flota [02]", "Regresar [03]");
        opcionDecicion(false);
    }

    public void imprimirAgregarNaveFlota(Naves[] almacenNaves) {
        int contador = 1;
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "NAVES EN ALMACEN");
        for (Naves navesA : almacenNaves) {
            if (navesA != null) {
                try {
                    System.out.printf("|%-100s|%n", "[0" + contador + "]" + navesA.getNombre());
                } catch (ReturnNullExepcion e) {
                }
            } else {
                System.out.printf("|%-100s|%n", "[0" + contador + "] " + "Sin Nave");
            }

            contador++;
        }
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "SELECCIONE UNA NAVE PARA AGREGAR A FLOTA");
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "O PRECIONE R PARA REGRESAR ");
        confi.separadoresFinales();
    }

    public void impresorDeModuloDeMantenimientoElecionNave(int puntosDeTecnologiaDisponibles, int creditoDisponible,
            Naves[] fota) {
        int contador = 1;
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "MODULO DE MANTENIMIENTO");
        confi.separadoresMedios();
        System.out.printf("|%-50s%-50s|%n", "PUNTOS DE TECNOLOGIA: " + puntosDeTecnologiaDisponibles,
                "CREDITOS: " + creditoDisponible);
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "NAVES EN FLOTA");
        confi.separadoresMedios();
        for (Naves navesF : fota) {
            try {
                if (navesF != null) {
                    System.out.printf("|%-100s|%n", "[0" + contador + "]" + navesF.getNombre());
                } else {
                    System.out.printf("|%-100s|%n", "[0" + contador + "] " + "Sin Nave");
                }
            } catch (NullPointerException | ReturnNullExepcion e) {
                System.out.printf("|%-100s|%n", "[0" + contador + "] " + "Sin Nave");
            }
            contador++;
        }
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "SELECCIONE UNA NAVE PARA ENTRARA A MANTENIMIENTO");
        System.out.printf("|%-100s|%n", "O ESCRIBA R PARA REGRESAR");
        confi.separadoresFinales();
    }

    public void impresorDeModuloDeMantenimientoNaves(Naves nave, int puntosDeTecnologiaDisponibles,
            int creditoDisponible) {

        double[] standsNave = nave.getStads();
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "MODULO DE MANTENIMIENTO");
        confi.separadoresMedios();
        System.out.printf("|%-50s%-50s|%n", "PUNTOS DE TECNOLOGIA: " + puntosDeTecnologiaDisponibles,
                "CREDITOS: " + creditoDisponible);
        confi.separadoresMedios();
        try {
            System.out.printf("|%-100s|%n", "Nave en mantenimiento: " + nave.getNombre());
            System.out.printf("|%-100s|%n", "Estado de nave");
            confi.separadoresMedios();

            if (nave != null) {
                System.out.printf("|%-25s%-25s%-25s%-25s|%n", "HP = " + standsNave[0], "SHP = " + standsNave[2],
                        "SP = " + standsNave[3], "EP = " + standsNave[1]);
                confi.separadoresMedios();
            }
        } catch (ReturnNullExepcion e) {
            System.out.println("No seleciono una nave ");
        }
        System.out.printf("|%-25s%-25s%-25s%-25s|%n", "Piloto [01]", "Componetes [02]", "Reparacion [03]",
                "A almacen [04]");
        System.out.printf("|%-100s|%n", "Regresar [05]");
        opcionDecicion(false);
    }

    public void impresionReparacionPrecio(int costo) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "Costo de reparacion " + costo);
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "DESEA REPARAR S/N");
        confi.separadoresFinales();

    }

    public void impresorDePilotosNaves(Naves[] naves) {

        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "Pilotos en Naves");
        for (Naves naves2 : naves) {
            try {
                System.out.printf("|%-50s%-50s|%n", naves2.getNombre(), naves2.getPiloto().getNombre());
            } catch (ReturnNullExepcion | NullPointerException e) {
                System.out.printf("|%-100s|%n", "Sin datos de nave o piloto asignado");
            }
        }
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "Precione enter para regresar");
        confi.separadoresFinales();
    }

    public void impresorDeBarracas(int creditoDisponible) {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "BARRACAS DE PILOTOS");
        confi.separadoresMedios();
        System.out.printf("|%-100s|%n", "CREDITOS: " + creditoDisponible);
        confi.separadoresMedios();
        System.out.printf("|%-33s%-33s%-34s|%n", "Contratar [01]", "Desalogar  [02]", "Ver Pilotos [03]");
        System.out.printf("|%-100s|%n", "Salir [04]");
        opcionDecicion(false);
    }

    public <T> void impresorDeT(T[] disponibles, boolean compra, EstatusJuego valoresJugo) {
        int contador = 1;
        confi.separadoresIniciales();
        if (compra) {
            System.out.printf("|%-100s|%n", "Credito estelara disponible; " + valoresJugo.getCreditosEstelares());
            confi.separadoresMedios();
            System.out.printf("|%-50s%-50s|%n", "Nombre", "Compra");
            confi.separadoresMedios();
            for (T disponibleT : disponibles) {
                if (disponibleT instanceof VentaCompraPrecios venta) {
                    try {
                        System.out.printf("|%-50s%-50s|%n", "[0" + contador + "] " + venta.getNombre(),
                                venta.getPrecioCompra());
                        contador++;
                    } catch (NullPointerException | ReturnNullExepcion e) {
                        System.out.printf("|%-100s|%n", "[0" + contador + "] " + "Sin producto");
                        contador++;
                    }
                }
            }
        } else {
            System.out.printf("|%-50s%-50s|%n", "Nombre", "Venta");
            confi.separadoresMedios();
            for (T disponibleT : disponibles) {
                if (disponibleT instanceof VentaCompraPrecios compraT) {
                    try {
                        System.out.printf("|%-50s%-50s|%n", "[0" + contador + "] " + compraT.getNombre(),
                                compraT.getPrecioVenta());
                        contador++;
                    } catch (NullPointerException | ReturnNullExepcion e) {
                        System.out.printf("|%-100s|%n", "[0" + contador + "] " + "Sin producto");
                        contador++;
                    }
                }
            }
        }
        opcionDecicion(true);
    }

    public <T> void impresorDeLista(T[] objetosImprimir, String nombreDeObjetos) {
        confi.separadoresIniciales();
        int contador = 1;
        String nombreObjetoT;
        System.out.printf("|%-100s|%n", nombreDeObjetos);
        confi.separadoresMedios();
        for (T objetoT : objetosImprimir) {
            try {

                if (objetoT != null) {
                    if (objetoT instanceof VentaCompraPrecios objetoTV) {

                        nombreObjetoT = objetoTV.getNombre();
                        System.out.printf("|%-100s|%n", "[0" + contador + "]" + nombreObjetoT);
                    }
                }
            } catch (NullPointerException | ReturnNullExepcion e) {
                System.out.printf("|%-100s|%n", "[0" + contador + "] sin " + nombreDeObjetos);

            }
            contador++;
        }
        confi.separadoresFinales();
    }

    public void imprimirPiloto(String nombrePiloto) {

        confi.separadoresIniciales();
        if (nombrePiloto == null) {
            System.out.printf("|%-100s|%n", "La nave no tiene piloto");
            confi.separadoresMedios();
            System.out.printf("|%-100s|%n", "Desea agregar un piloto S/N");
        } else {
            System.out.printf("|%-100s|%n", "El piloto actual de la nave es " + nombrePiloto);
            confi.separadoresMedios();
            System.out.printf("|%-100s|%n", "Desea cambiar de piloto S/N");
        }

    }

    public void impresorDecicionesComponetesInternas(Componentes componente) {
        try {

            String nombeComponete = componente.getNombre();
            confi.separadoresIniciales();
            System.out.printf("|%-100s|%n", "Componete selecionado " + nombeComponete);
            confi.separadoresMedios();
            System.out.printf("|%-33s%-33s%-34s|%n", "MEJORAR COMPONETE [01] ", "DESEQUIPAR COMPONETE [02]",
                    "REGRESAR [03]");
            opcionDecicion(false);
        } catch (ReturnNullExepcion | NullPointerException e) {
            System.out.println("Sin componetes ");
        }
    }

    public void decicionComponetesInicial() {
        confi.separadoresIniciales();
        System.out.printf("|%-100s|%n", "QUE HACER A CONTINUACION");
        confi.separadoresMedios();
        System.out.printf("|%-33s%-33s%-34s|%n", "Modificar componete nave [01]", "Agregar componete nave [02]",
                "Regresar [03]");
        opcionDecicion(false);
    }

    public void opcionDecicion(boolean activacionR) {
        if (activacionR) {
            confi.separadoresMedios();
            System.out.printf("|%-100s|%n", "PRECIONE R PARA REGRESAR O");
        } else {
            confi.separadoresMedios();
        }
        System.out.printf("|%-100s|%n", "SELECCIONE UNA OPCION");
        confi.separadoresFinales();

    }

}
