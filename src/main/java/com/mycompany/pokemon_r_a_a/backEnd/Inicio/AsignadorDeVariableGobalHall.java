package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.Farmacia;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.Gimnasio;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.Tienda;

@SuppressWarnings("rawtypes")
public class AsignadorDeVariableGobalHall {

    private MapaCiudad[] mapaCiudad;
    private HallDeLaFama hall;

    public AsignadorDeVariableGobalHall(HallDeLaFama hall, MapaCiudad[] mapaCiudad) {
        this.mapaCiudad = mapaCiudad;
        this.hall = hall;
    }

    public void asignacion() {
        for (MapaCiudad mapaCiudad2 : mapaCiudad) {
            if (mapaCiudad2 == null)
                continue;
            Casillas[][] casillas = mapaCiudad2.getMapa();
            if (casillas == null)
                continue;
            for (int i = 0; i < casillas.length; i++) {
                for (int j = 0; j < casillas[i].length; j++) {

                    if (casillas[i][j] != null) {
                        casillas[i][j].setHall(hall);

                        if (casillas[i][j] instanceof Farmacia || casillas[i][j] instanceof Gimnasio
                                || casillas[i][j] instanceof Tienda) {

                            Casillas[][] mapaInterno = casillas[i][j].getMapa();

                            recoridoDeMapaDos(mapaInterno);
                        }
                    }
                }
            }
        }
    }

    private void recoridoDeMapaDos(Casillas[][] mapaInterno) {

        if (mapaInterno == null) {
            return;
        }

        for (int i = 0; i < mapaInterno.length; i++) {
            if (mapaInterno[i] == null)
                continue;

            for (int j = 0; j < mapaInterno[i].length; j++) {
                if (mapaInterno[i][j] != null) {
                    mapaInterno[i][j].setHall(hall);
                }
            }
        }
    }

}
