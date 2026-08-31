package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista;

public abstract class Fisico extends Movimiento {

    private int variacion;
    private int nivelPokemon;
    private int puntosDeAtaque;
    private final static int VARIACION_INICIO = 85;
    private final static int VARIACION_FIN = 101;
    protected int daño;
    protected int potencia;

    @Override
    protected int resultadoAcion(Boolean recursivo) {
        if (pokemonUsuario == null || pokemonAtacado == null) {
            return 0;
        }

        puntosDeAtaque = pokemonUsuario.getAtaquePokemon();
        nivelPokemon = pokemonUsuario.getNivel();
        variacion = rand.ints(VARIACION_INICIO, VARIACION_FIN).findFirst().getAsInt();

        int def = pokemonAtacado.getDefensaPokemon();
        if (def <= 0) {
            def = 1;
        }

        daño = (int) (0.01 * variacion
                * ((((0.2 * nivelPokemon + 1) * puntosDeAtaque * potencia) / (25 * def))
                        + 2));

        // Verificar si el objetivo bloquea el ataque con Protección
        if (pokemonAtacado.bolqueador()) {
            System.out.println(confi.formatearMapa("¡" + pokemonAtacado.getNombre() + " se protegió del ataque!"));
            return 0;
        }

        int vidaActual = pokemonAtacado.getVidaPokemon();
        int nuevaVida = vidaActual - daño;
        if (nuevaVida < 0) {
            nuevaVida = 0;
        }
        pokemonAtacado.setVidaPokemon(nuevaVida);

        System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " usó " + getNombre()
                + " causando " + daño + " de daño a " + pokemonAtacado.getNombre() + "! (HP restante: " + nuevaVida
                + "/" + pokemonAtacado.getVidaInicial() + ")"));

        if (!recursivo) {
            estadosAlterados();
        }
        return daño;
    }

}
