package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Espacio;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Jugador;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.CentroPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.GimnasioPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.HiervaAlta;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.TiendaPokemon;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Obstaculos.Agua;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Obstaculos.Arbol;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Obstaculos.Casa;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Obstaculos.Murro;

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
                    case 7:
                        mapaO[i][j] = new Arbol();
                        break;
                    case 8:
                        mapaO[i][j] = new Agua();
                        break;
                    case 9:
                        mapaO[i][j] = new Casa();
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
