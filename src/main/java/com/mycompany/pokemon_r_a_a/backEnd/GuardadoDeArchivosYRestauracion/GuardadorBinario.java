package com.mycompany.pokemon_r_a_a.backEnd.GuardadoDeArchivosYRestauracion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class GuardadorBinario {

    private ImpresoresGlobal impresor;

    public GuardadorBinario() {
        impresor = new ImpresoresGlobal();
    }

    public <T> void escritorDeObjetosMenoria(T datosAGuardar, String rutaDeArchivo) {
        File memoriaArchivoGuardado = new File(rutaDeArchivo);
        try (FileOutputStream out = new FileOutputStream(memoriaArchivoGuardado);
                ObjectOutputStream objectStream = new ObjectOutputStream(out)) {
            objectStream.writeObject(datosAGuardar);
            impresor.mensajeInformativo("Se guardo la partida");
        } catch (IOException e) {
            impresor.mensajeInformativo("No se pudo guardar la partida");
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T lectorDeObjetosMemoria(String rutaDeArchivo) {
        File memoriaArchivoGuardado = new File(rutaDeArchivo);

        if (!memoriaArchivoGuardado.exists()) {
            impresor.mensajeInformativo("No se encontro ninguna partida guardada.");
            return null;
        }

        try (FileInputStream in = new FileInputStream(memoriaArchivoGuardado);
                ObjectInputStream objectStream = new ObjectInputStream(in)) {

            T datosCargados = (T) objectStream.readObject();
            impresor.mensajeInformativo("Partida cargada con éxito.");
            return datosCargados;

        } catch (IOException | ClassNotFoundException e) {
            impresor.mensajeInformativo("Error al cargar la partida.");
            return null;
        }
    }

}
