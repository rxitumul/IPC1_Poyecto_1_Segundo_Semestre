package com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.NpcInfo;

import com.mycompany.pokemon_r_a_a.backEnd.JugadorPokemon.Mochila;

public class TiendaNpc extends Npc<Mochila> {

    private Mochila productosDisponibles;
    @Override
    public String[] getDialojo(int tipo) {
       switch (tipo) {
        case 0:
            return new String[]{
                "¡Bienvenido a la Tienda Pokémon!",
                "Tenemos todo lo que un entrenador necesita.",
                "¿Quieres ver nuestros productos?"};
        case 1:
            return new String[]{
                "Estos son los productos disponibles.",
                "Recuerda que necesitas suficientes Pokémonedas para realizar una compra."};
        case 2:
            return new String[]{
                "¡Gracias por tu compra!",
                "El objeto ha sido enviado directamente a tu mochila."};
        case 3:
            return new String[]{
                "Lo siento, no tienes suficientes Pokémonedas para comprar este objeto."};
        default:
            return new String[]{
                "¡Gracias por visitar la Tienda Pokémon!",
                "¡Vuelve cuando necesites algo!"};
       }
    }

    @Override
    public void setBoleanoActivo(boolean boleanoActivo) {
        this.boleanoActivo = boleanoActivo;
    }

    @Override
    public boolean getbBleanoActivo() {
        return boleanoActivo;
    }

    @Override
    public Mochila[] getLista() {
        return new Mochila[]{productosDisponibles};
    }

    @Override
    public void setLista(Mochila[] mochila) {
        this.productosDisponibles = mochila[0]; // Assuming you want to set the first item in the array
    }

    @Override
    public void accion() {
    }

}
