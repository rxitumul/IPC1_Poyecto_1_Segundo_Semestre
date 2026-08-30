package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista;

public abstract class Fisico extends Movimiento {

    private int variacion;
    private int nivelPokemon = pokemonUsuario.getNivel();
    private int puntosDeAtaque = pokemonUsuario.getAtaquePokemon();
    private final static int VARIACION_INICIO = 85;
    private final static int VARIACION_FIN = 101;
    protected int daño;

    protected int potencia;

    @Override
    protected int resultadoAcion() {
        variacion = rand.ints(VARIACION_INICIO, VARIACION_FIN).findFirst().getAsInt();
        daño = (int) (0.01 * variacion
                * ((((0.2 * nivelPokemon + 1) * puntosDeAtaque * potencia) / (25 * pokemonAtacado.getDefensaPokemon()))
                        + 2));
        estadosAlterados();
        return daño;

    }

}
