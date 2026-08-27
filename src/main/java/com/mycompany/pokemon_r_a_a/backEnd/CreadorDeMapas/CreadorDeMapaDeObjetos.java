package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CentroPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Espacio;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.GimnasioPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.HiervaAlta;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Jugador;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Murro;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.TiendaPokemon;

public class CreadorDeMapaDeObjetos {

    public Casillas[][] creadorCasillasObjetos(int[][] mapa) {
        Casillas[][] mapaO = new Casillas[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                switch (mapa[i][j]) {
                    case 0:
                        mapaO[i][j] = new CentroPokemon();
                        break;
                    case 1:
                        mapaO[i][j] = new GimnasioPokemon();

                        break;
                    case 2:
                        mapaO[i][j] = new TiendaPokemon();
                        break;
                    case 3:
                        mapaO[i][j] = new HiervaAlta();
                        break;
                    case 4:
                        mapaO[i][j] = new Jugador();
                        break;
                        case 5:
                        mapaO[i][j] = new Murro();
                        break;
                    default:
                        mapaO[i][j] = new Espacio();
                        break;
                }
            }
        }
        return mapaO;
    }

}
