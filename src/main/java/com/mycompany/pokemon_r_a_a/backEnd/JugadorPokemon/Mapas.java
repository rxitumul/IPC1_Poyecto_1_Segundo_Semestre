package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon;

import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.frontEnd.MensajesDeInformacion;
import com.mycompany.pokemon_r_a_a.frontEnd.impresores.ImpresorDeSelecion;

public class Mapas {
    private MensajesDeInformacion mensaje = new MensajesDeInformacion();
    private MapaCiudad[] mapaCiudadesLocal;
    private ImpresorDeSelecion impresor = new ImpresorDeSelecion();
    private Scanner scanner;

    public Mapas(Scanner scanner, MapaCiudad[] mapaCiudades) {
        this.scanner = scanner;
        mapaCiudadesLocal = mapaCiudades;
    }

    public int selecionDeMapa() {

        do {
            impresor.impresorDelistas("Mapas", mapaCiudadesLocal);
            String selecion = scanner.nextLine();
            switch (selecion) {
                case "1":
                    impresor.impresorDeNombre(mapaCiudadesLocal[0].getNombre());
                    return 0;
                case "2":
                    impresor.impresorDeNombre(mapaCiudadesLocal[1].getNombre());

                    return 1;
                case "3":
                    impresor.impresorDeNombre(mapaCiudadesLocal[2].getNombre());
                    return 2;
                default:
                    mensaje.pantallaDeError();
                    break;
            }
        } while (true);

    }
}
