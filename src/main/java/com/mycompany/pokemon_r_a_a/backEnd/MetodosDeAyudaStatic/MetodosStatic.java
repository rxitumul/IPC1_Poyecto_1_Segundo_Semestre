package com.mycompany.pokemon_r_a_a.backEnd.MetodosDeAyudaStatic;

public class MetodosStatic {

    public static String generarIdDinamico(int tipo, int nivel, int especieId, int npcId, int correlativo) {
        return tipo + "-" + nivel + "-" + especieId + "-" + npcId + "-" + correlativo;
    }

    public static int[] descomponerIdDinamico(String id) {
        if (id == null || id.isEmpty()) {
            return new int[] { 0, 0, 0, 0, 0 };
        }
        if (id.contains("-")) {
            String[] partes = id.split("-");
            int[] resultado = new int[partes.length];
            for (int i = 0; i < partes.length; i++) {
                try {
                    resultado[i] = Integer.parseInt(partes[i].trim());
                } catch (NumberFormatException e) {
                    resultado[i] = 0;
                }
            }
            return resultado;
        } else {
            try {
                int valor = Integer.parseInt(id.trim());
                return new int[] { valor };
            } catch (Exception e) {
                return new int[] { 0 };
            }
        }
    }

}
