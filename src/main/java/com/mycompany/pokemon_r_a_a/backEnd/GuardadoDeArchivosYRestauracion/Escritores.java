package com.mycompany.pokemon_r_a_a.backEnd.GuardadoDeArchivosYRestauracion;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escritores {

    public void escritorDatos(String id, int cantidadPreferente, String rutaGuardado)
            throws ErrorEnLosArchivosException {
        File memoriaReporteFile = new File(rutaGuardado);

        File parentDir = memoriaReporteFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        if (!memoriaReporteFile.exists()) {
            try {
                memoriaReporteFile.createNewFile();
            } catch (IOException e) {
                throw new ErrorEnLosArchivosException("Archivo no encontrado");
            }
        }

        try (FileWriter fileWriter = new FileWriter(memoriaReporteFile, true);
                PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.print(id);
            writer.print(",");
            writer.println(cantidadPreferente);
        } catch (IOException e) {
            throw new ErrorEnLosArchivosException("Archivo no encontrado");
        }
    }

    public void escritorTiempos(int tiempo1, int tiempo2, int tiempo3, int tiempo4,int tiempo5, String rutaGuardado)
            throws ErrorEnLosArchivosException {
        File memoriaReporteFile = new File(rutaGuardado);

        File parentDir = memoriaReporteFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        if (!memoriaReporteFile.exists()) {
            try {
                memoriaReporteFile.createNewFile();
            } catch (IOException e) {

                throw new ErrorEnLosArchivosException("Archivo no encontrado");
            }
        }

        try (FileWriter fileWriter = new FileWriter(memoriaReporteFile, false);
                PrintWriter writer = new PrintWriter(fileWriter)) {
            writer.print(tiempo1);
            writer.print(",");
            writer.print(tiempo2);
            writer.print(",");
            writer.print(tiempo3);
            writer.print(",");
            writer.print(tiempo4);
            writer.print(",");
            writer.print(tiempo5);

        } catch (IOException e) {
            throw new ErrorEnLosArchivosException("Archivo no encontrado");
        }
    }

}
