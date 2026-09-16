package com.mycompany.pokemon_r_a_a.backEnd.CargadorDePartidas;

import java.io.File;
import java.util.Scanner;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.GuardadoDeArchivosYRestauracion.GuardadorBinario;
import com.mycompany.pokemon_r_a_a.backEnd.Inicio.Game;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class DistribuidorDeGuardado extends GuardadoCargado {

    private String nombreJuego;

    private final static String RUTA_DE_GUARDADO_JUGADOR_CARPETA = "/jugador";
    private final static String RUTA_DE_GUARDADO_MAPAS_CARPETA = "/mapas";
    private final static String RUTA_DE_GUARDADO_HALL_DE_FAMA = "hall/hallDeLaFama.txt";
    private final static String RUTA_DE_GUARDADO_HALL_DE_FAMA_BIN = "hall/hallDeLaFama.bin";
    private GuardadorBinario guardador;



    public DistribuidorDeGuardado(MapaCiudad[] mapas, JugadorPokemonPartida jugador, String nombreJuego) {
        super(mapas, jugador);
        guardador = new GuardadorBinario();
        this.nombreJuego = nombreJuego;
    }

    public void guardarJuego(MapaCiudad[] mapas, JugadorPokemonPartida jugador, HallDeLaFama hallAGuardar) {
        try {
            String rutaBase = RUTA_DE_ARCHIVOS_GUARDADOS + nombreJuego;

            crearCarpetaGuardado(rutaBase + RUTA_DE_GUARDADO_JUGADOR_CARPETA);
            crearCarpetaGuardado(rutaBase + RUTA_DE_GUARDADO_MAPAS_CARPETA);
            crearCarpetaGuardado(RUTA_DE_ARCHIVOS_GUARDADOS_DATOS +"hall");

            for (MapaCiudad mapaCiudad : mapas) {
                if (mapaCiudad != null) {
                    guardador.escritorDeObjetosMenoria(mapaCiudad,
                            rutaBase + RUTA_DE_GUARDADO_MAPAS_CARPETA + "/" + mapaCiudad.getNombre() + ".bin");
                }
            }

            guardador.escritorDeObjetosMenoria(jugador,
                    rutaBase + RUTA_DE_GUARDADO_JUGADOR_CARPETA + "/" + jugador.getNombre() + ".bin");
            if (hallAGuardar != null) {
                hallAGuardar.guardarEnTexto(RUTA_DE_ARCHIVOS_GUARDADOS_DATOS + RUTA_DE_GUARDADO_HALL_DE_FAMA);
                guardador.escritorDeObjetosMenoria(hallAGuardar,
                        RUTA_DE_ARCHIVOS_GUARDADOS_DATOS + RUTA_DE_GUARDADO_HALL_DE_FAMA_BIN);
            }
            impresor.mensajeInformativo("Guardado Exitoso de la partida " + nombreJuego);

        } catch (Exception e) {
            impresor.mensajeInformativo("Ocurrió un error al guardar la partida: " + nombreJuego);
        }
    }

    public Game juegoGuardado(String path, HallDeLaFama hall,Scanner sacanerActivado) {
        String[] nombresMapas = lectorDeDatosNombres(path + RUTA_DE_GUARDADO_MAPAS_CARPETA);
        String[] nombreJugador = lectorDeDatosNombres(path + RUTA_DE_GUARDADO_JUGADOR_CARPETA);
        if (nombresMapas == null || nombreJugador == null || nombreJugador.length == 0) {
            impresor.mensajeInformativo("Error: No se encontraron archivos de guardado válidos.");
            return null;
        }

        MapaCiudad[] mapas = new MapaCiudad[nombresMapas.length];

        for (int i = 0; i < nombresMapas.length; i++) {
            mapas[i] = guardador.lectorDeObjetosMemoria(path + RUTA_DE_GUARDADO_MAPAS_CARPETA + "/" + nombresMapas[i]);
        }

        JugadorPokemonPartida jugador = guardador
                .lectorDeObjetosMemoria(path + RUTA_DE_GUARDADO_JUGADOR_CARPETA + "/" + nombreJugador[0]);
        return new Game(sacanerActivado, mapas, jugador, hall);
    }

    public HallDeLaFama creadDeLaFama() {
        String pathHall = RUTA_DE_ARCHIVOS_GUARDADOS_DATOS + RUTA_DE_GUARDADO_HALL_DE_FAMA_BIN;
        HallDeLaFama hallGuardado = guardador.lectorDeObjetosMemoria(pathHall);
        if (hallGuardado == null) {
            hallGuardado = guardador.lectorDeObjetosMemoria(RUTA_DE_ARCHIVOS_GUARDADOS + RUTA_DE_GUARDADO_HALL_DE_FAMA_BIN);
        }
        return hallGuardado;
    }

    private void crearCarpetaGuardado(String ruta) {
        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }

    public String[] lectorDeDatosNombres(String rutaArchivo) {
        File tamanoArchivo = new File(rutaArchivo);
        String[] nombrePartida = tamanoArchivo.list();
        return nombrePartida;
    }

}
