package com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas;

import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.CasillaGenerica;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionEntrenador;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionFarmacia;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.InteracionTienda;
import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion.IntracionTele;

public class CreadorDeMapaDeObjetos {

    private HallDeLaFama hall;

    public CreadorDeMapaDeObjetos(HallDeLaFama hall) {
        this.hall = hall;
    }

    public Casillas[][] creadorCasillasObjetos(int[][] mapa) {
        int rows = mapa.length;
        int cols = mapa[0].length;
        Casillas[][] mapaO = new Casillas[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mapaO[i][j] = crearCasilla(mapa[i][j]);
            }
        }
        return mapaO;
    }

    private Casillas crearCasilla(int tipo) {
        switch (tipo) {
            // ── Edificios del mapa principal ──────────────────────────────
            case 0:  // Centro Pokémon (acceso desde el mapa)
                return new CasillaGenerica(Casillas.VERDE_CLARO + " ⚕ " + Casillas.RESET, true, 6, true, hall);
            case 1:  // Gimnasio
                return new CasillaGenerica(Casillas.AZUL + " ⊞ " + Casillas.RESET, true, 1, true, hall);
            case 2:  // Tienda
                return new CasillaGenerica(Casillas.AMARILLO + " ⊡ " + Casillas.RESET, true, 2, true, hall);
            case 3:  // Hierva Alta
                return new CasillaGenerica(Casillas.VERDE + " ≋ " + Casillas.RESET, true, 3, true, hall);
            case 4:  // Jugador (spawn)
                return new CasillaGenerica(Casillas.AMARILLO + " ☻ " + Casillas.RESET, true, 4, false, hall);
            case 5:  // Muro
                return new CasillaGenerica(Casillas.ROJO + " █ " + Casillas.RESET, false, 5, false, hall);
            case 7:  // Árbol
                return new CasillaGenerica(Casillas.VERDE + " ♠ " + Casillas.RESET, false, 7, false, hall);
            case 8:  // Agua
                return new CasillaGenerica(Casillas.AZUL + " ≈ " + Casillas.RESET, false, 8, false, hall);
            case 9:  // Casa
                return new CasillaGenerica(Casillas.AMARILLO + " ⌂ " + Casillas.RESET, false, 9, false, hall);

            // ── Casillas de NPC (interiores) ─────────────────────────────
            case 10: // Entrenador (casilla NPC walkable)
                return new CasillaGenerica(Casillas.AZUL + " ♜ " + Casillas.RESET, true, 10, true, hall);
            case 11: // Líder de Gimnasio
                return new CasillaGenerica(Casillas.AZUL + " ♛ " + Casillas.RESET, true, 11, true, hall);
            case 12: // Empleado Tienda
                return new CasillaGenerica(Casillas.AZUL + " ♙ " + Casillas.RESET, true, 12, true, hall);
            case 13: // Enfermera
                return new CasillaGenerica(Casillas.AZUL + " ♥ " + Casillas.RESET, true, 13, true, hall);
            case 14: // Televisión (NPC base visual)
                return new CasillaGenerica(Casillas.AZUL + " ▣ " + Casillas.RESET, true, 14, true, hall);

            // ── Casillas de interacción (con lógica real) ─────────────────
            case 15: // Zona de interacción - Entrenador
                return new InteracionEntrenador(hall);
            case 16: // Zona de interacción - Farmacia
                return new InteracionFarmacia(hall);
            case 17: // Zona de interacción - Tienda
                return new InteracionTienda(hall);
            case 18: // Zona de interacción - Televisión
                return new IntracionTele(hall);

            // ── Decorado interior ─────────────────────────────────────────
            case 19: // Mostrador
                return new CasillaGenerica("   ", false, 19, false, hall);
            case 20: // Salida
                return new CasillaGenerica(Casillas.ROJO + " ⇩ " + Casillas.RESET, true, 20, true, hall);

            default:
                return new CasillaGenerica("   ", true, 6, false, hall);
        }
    }
}
