package com.mycompany.pokemon_r_a_a.backEnd.Inicio;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorDeMapaDeObjetos;
import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.CreadorMapas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.impresores.ImpresorDeMapas;

public class InicioGame {
    private ProfesorCharla profe = new ProfesorCharla();
    private CreadorMapas creador = new CreadorMapas();
    private ImpresorDeMapas impresor = new ImpresorDeMapas();

    public void inicio() {
        profe.charlaInicial();
        Casillas [][] mapa=creador.mapaCreador();
        impresor.imprimirMapaObjetos(mapa, null, null);
        

    }
}
