package com.mycompany.pokemon_r_a_a.backEnd.CargadorDePartidas;

import java.io.File;

import com.mycompany.pokemon_r_a_a.backEnd.CreadorDeMapas.MapaCiudad;
import com.mycompany.pokemon_r_a_a.backEnd.GuardadoDeArchivosYRestauracion.GuardadorBinario;
import com.mycompany.pokemon_r_a_a.backEnd.Inicio.Game;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.JugadorPokemonPartida;

public class DistribuidorDeGuardado extends GuardadoCargado {

    private String nombreJuego;

    private final String RUTA_DE_GUARDADO_JUGADOR_CARPETA = "/jugador";
    private final String RUTA_DE_GUARDADO_MAPAS_CARPETA = "/mapas";
    private GuardadorBinario guardador;

    public DistribuidorDeGuardado() {
        guardador = new GuardadorBinario();
    }

    public DistribuidorDeGuardado(MapaCiudad[] mapas, JugadorPokemonPartida jugador, String nombreJuego) {
        super(mapas, jugador);
        guardador = new GuardadorBinario();
        this.nombreJuego = nombreJuego;
    }

    public void guardarActionPerformed(MapaCiudad[] mapas, JugadorPokemonPartida jugador) {
        try {
            String rutaBase = RUTA_DE_ARCHIVOS_GUARDADOS + nombreJuego;

            crearCarpetaGuardado(rutaBase + RUTA_DE_GUARDADO_JUGADOR_CARPETA);
            crearCarpetaGuardado(rutaBase + RUTA_DE_GUARDADO_MAPAS_CARPETA);

            for (MapaCiudad mapaCiudad : mapas) {
                if (mapaCiudad != null) {
                    guardador.escritorDeObjetosMenoria(mapaCiudad,
                            rutaBase + RUTA_DE_GUARDADO_MAPAS_CARPETA + "/" + mapaCiudad.getNombre() + ".bin");
                }
            }

            guardador.escritorDeObjetosMenoria(jugador,
                    rutaBase + RUTA_DE_GUARDADO_JUGADOR_CARPETA + "/" + jugador.getNombre() + ".bin");
            impresor.mensajeInformativo("Guardado Exitoso de la partida " + nombreJuego);

        } catch (Exception e) {
            impresor.mensajeInformativo("Ocurrió un error al guardar la partida: " + nombreJuego);
        }
    }

    public Game juegoGuardado(String path) {
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
        return new Game(scanner, mapas, jugador);
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
