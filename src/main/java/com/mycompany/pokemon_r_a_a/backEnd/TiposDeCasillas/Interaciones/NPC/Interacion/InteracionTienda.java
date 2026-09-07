package com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Interaciones.NPC.Interacion;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;
import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo.TiendaNpc;
import com.mycompany.pokemon_r_a_a.backEnd.Reportes.HallDeLaFama;

public class InteracionTienda extends InteracionCasillas<TiendaNpc> {

    public InteracionTienda(HallDeLaFama hall) {
        super(hall);
    }

    @Override
    public int tipoCasilla() {
        return 17;
    }

    @Override
    public void setNpc(TiendaNpc npcT) {
        this.npcT = npcT;
    }

    @Override
    public Boolean subMenu() {
        front.tiendaBienvenida(npcT);
        boolean seguirComprando = true;
        while (seguirComprando) {
            int dineroActual;
            if (jugador != null) {
                dineroActual = jugador.getPokemonedas();
            } else {
                dineroActual = 0;
            }
            front.tablaDeProductos(dineroActual);
            String opcion = scanner.nextLine().trim();

            if (opcion.equals("0")) {
                break;
            }

            boolean selecionCorrecta = front.preciosTienda(opcion);
            int cantidad = 0;
            if (!selecionCorrecta) {
                continue;
            }
            int precioUnitario = front.getPrecioUnitario();
            try {
                cantidad = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                front.mensajeInformativo("Cantidad inválida.");
                continue;
            }

            if (cantidad <= 0) {
                front.mensajeInformativo("Cantidad debe ser mayor a 0.");
                continue;
            }

            int costoTotal = precioUnitario * cantidad;
            if (jugador == null) {
                front.mensajeInformativo("No se encontró al jugador.");
                break;
            }

            if (jugador.getPokemonedas() < costoTotal) {
                String[] sinFondos = npcT.getDialojo(3);
                front.mensajeEncadenado(sinFondos);
            } else {
                jugador.setPokemonedas(jugador.getPokemonedas() - costoTotal);
                Mochila mochila = jugador.getMochilaJugador();
                if (mochila != null) {
                    switch (opcion) {
                        case "1":
                            mochila.setPokebola(mochila.getPokebola() + cantidad);
                            break;
                        case "2":
                            mochila.setPocion(mochila.getPocion() + cantidad);
                            break;
                        case "3":
                            mochila.setSuperPocion(mochila.getSuperPocion() + cantidad);
                            break;
                        case "4":
                            mochila.setAntidoto(mochila.getAntidoto() + cantidad);
                            break;
                        case "5":
                            mochila.setAntiParalisis(mochila.getAntiParalisis() + cantidad);
                            break;
                        case "6":
                            mochila.setRestauraTodo(mochila.getRestauraTodo() + cantidad);
                            break;
                    }
                }
                String nombreObjeto = front.getNombreObjeto();
                String[] compraExitosa = npcT.getDialojo(2);
                front.mensajeEncadenado(compraExitosa);
                front.mensajeInformativo(
                        "Has comprado " + cantidad + "x " + nombreObjeto + " por ₽" + costoTotal + ".");
            }
        }

        String[] despedida = npcT.getDialojo(4);
        front.mensajeEncadenado(despedida);
        front.mensajeInformativo("Presiona Enter para continuar...");
        scanner.nextLine();
        return true;
    }
}
