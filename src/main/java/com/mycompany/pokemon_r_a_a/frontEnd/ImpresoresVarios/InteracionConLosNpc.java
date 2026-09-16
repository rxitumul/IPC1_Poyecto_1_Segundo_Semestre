package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.EnfermeriaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.Entrenador;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.TiendaNpc;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class InteracionConLosNpc extends ImpresoresGlobal {

    private final int PRECIO_POKEBOLA = 200;
    private final int PRECIO_POCION = 300;
    private final int PRECIO_SUPER_POCION = 600;
    private final int PRECIO_ANTIDOTO = 100;
    private final int PRECIO_ANTI_PARALISIS = 200;
    private final int PRECIO_RESTAURA_TODO = 700;

    private String nombreNpc;
    private int precioUnitario = 0;
    private String nombreObjeto = "";

    public boolean entrenadoresInicio(Entrenador entrenador, boolean esLider) {
        String rol;
        if (entrenador == null) {
            separadorInicioMapa();
            System.out.println(formatearMapaCentrado("No hay ningún oponente aquí."));
            System.out.println(formatearMapaCentrado("Presiona Enter para continuar..."));

            separadorFinalMapa();
            return true;
        }

        if (esLider) {
            rol = "LÍDER DE GIMNASIO";
        } else {
            rol = "ENTRENADOR";
        }
        if (entrenador.getNombre() != null) {
            nombreNpc = entrenador.getNombre().toUpperCase();
        } else {
            nombreNpc = "Rival";
        }
        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("   " + rol + ": " + nombreNpc));
        separadorMediosMapa();

        if (entrenador.isDerrotado()) {
            String[] yaVencido = entrenador.getDialojo(3);
            for (String linea : yaVencido) {
                System.out.println(formatearMapa(linea));
            }
            System.out.println(formatearMapaCentrado("Presiona Enter para continuar..."));
            separadorFinalMapa();
            return true;
        }

        String[] reto = entrenador.getDialojo(0);
        for (String linea : reto) {
            System.out.println(formatearMapaCentrado(linea));
        }
        separadorMediosMapa();
        System.out.println(formatearMapa("1) ¡Acepto el desafío!"));
        System.out.println(formatearMapa("2) Ahora no, necesito prepararme"));
        System.out.println(formatearMapa("Elige una opción "));
        separadorFinalMapa();
        return false;

    }

    public void mensajeDeFinalizacionEntrenador(Entrenador entrenador, boolean esLider, boolean rivalDerrotado) {
        separadorInicioMapa();
        if (rivalDerrotado) {

            entrenador.setDerrotado(true);
            System.out.println(
                    formatearMapaCentrado("¡VICTORIA FRENTE A " + entrenador.getNombre().toUpperCase() + "! "));
            if (esLider) {
                String[] victoriaLider = entrenador.getDialojo(1);
                for (String linea : victoriaLider) {
                    System.out.println(formatearMapaCentrado(linea));
                }
            } else {
                String[] victoriaEntrenador = entrenador.getDialojo(3);
                for (String linea : victoriaEntrenador) {
                    System.out.println(formatearMapaCentrado(linea));
                }
            }
        } else {
            String[] derrota = entrenador.getDialojo(2);
            for (String linea : derrota) {
                System.out.println(formatearMapaCentrado(linea));
            }
        }
        separadorFinalMapa();
    }

    public boolean enfermeraInicio(EnfermeriaNpc enfermera) {

        if (enfermera == null) {
            System.out.println(formatearMapaCentrado("No hay enfermera disponible en este momento."));
            System.out.println(formatearMapaCentrado("Presiona Enter para continuar..."));
            return true;
        }
        if (enfermera.getNombre() != null) {
            nombreNpc = enfermera.getNombre().toUpperCase();
        } else {
            nombreNpc = "JOY";
        }

        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("   CENTRO POKÉMON - ENFERMERA " + nombreNpc));
        separadorMediosMapa();
        String[] saludo = enfermera.getDialojo(0);
        for (String linea : saludo) {
            System.out.println(formatearMapa(linea));
        }
        separadorMediosMapa();
        System.out.println(formatearMapa("1) Sí, por favor cura a mis Pokémon"));
        System.out.println(formatearMapa("2) No, gracias"));
        System.out.println(formatearMapa("Selecciona una opción: "));
        separadorFinalMapa();
        return false;
    }

    public boolean tiendaBienvenida(TiendaNpc tiendaNpc) {
        if (tiendaNpc == null) {
            System.out.println(formatearMapa("No hay dependiente disponible en este momento."));
            return true;
        }
        if (tiendaNpc.getNombre() != null) {
            nombreNpc = tiendaNpc.getNombre().toUpperCase();
        } else {
            nombreNpc = "VENDEDOR";
        }

        separadorInicioMapa();
        System.out.println(formatearMapaCentrado("   TIENDA POKÉMON - DEPENDIENTE " + nombreNpc));
        separadorFinalMapa();
        String[] bienvenida = tiendaNpc.getDialojo(0);
        mensajeEncadenado(bienvenida);
        return false;
    }

    public void tablaDeProductos(int dineroActual) {
        separadorInicioMapa();
        System.out.println(
                formatearMapaCentrado("--- CATÁLOGO DE PRODUCTOS (Tus Pokémonedas: ₽" + dineroActual + ") ---"));
        System.out.println(formatearMapaCentrado("1) Pokébola        - ₽" + PRECIO_POKEBOLA));
        System.out.println(formatearMapaCentrado("2) Poción          - ₽" + PRECIO_POCION));
        System.out.println(formatearMapaCentrado("3) Súper Poción    - ₽" + PRECIO_SUPER_POCION));
        System.out.println(formatearMapaCentrado("4) Antídoto        - ₽" + PRECIO_ANTIDOTO));
        System.out.println(formatearMapaCentrado("5) Anti-parálisis  - ₽" + PRECIO_ANTI_PARALISIS));
        System.out.println(formatearMapaCentrado("6) Restaura Todo   - ₽" + PRECIO_RESTAURA_TODO));
        separadorMediosMapa();
        System.out.println(formatearMapaCentrado("0) Salir"));
        separadorMediosMapa();
        System.out.println("Elige un producto a comprar: ");
        separadorFinalMapa();
    }

    public boolean preciosTienda(String opcion) {

        switch (opcion) {
            case "1":
                precioUnitario = PRECIO_POKEBOLA;
                nombreObjeto = "Pokébola";
                break;
            case "2":
                precioUnitario = PRECIO_POCION;
                nombreObjeto = "Poción";
                break;
            case "3":
                precioUnitario = PRECIO_SUPER_POCION;
                nombreObjeto = "Súper Poción";
                break;
            case "4":
                precioUnitario = PRECIO_ANTIDOTO;
                nombreObjeto = "Antídoto";
                break;
            case "5":
                precioUnitario = PRECIO_ANTI_PARALISIS;
                nombreObjeto = "Anti-parálisis";
                break;
            case "6":
                precioUnitario = PRECIO_RESTAURA_TODO;
                nombreObjeto = "Restaura Todo";
                break;
            default:
                return false;
        }
        mensajeInformativo("¿Cuántas unidades de " + nombreObjeto + " deseas comprar?: ");
        return true;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

}
