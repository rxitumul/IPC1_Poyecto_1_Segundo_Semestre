package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista;

public abstract class Fisico extends Movimiento {

    private int variacion;
    private int nivelPokemon;
    private int puntosDeAtaque;
    protected int daño;
    protected int potencia;
    private final static int VARIACION_INICIO = 85;
    private final static int VARIACION_FIN = 101;



    @Override
    protected int resultadoAcion(Boolean recursivo) {
        if (pokemonUsuario == null || pokemonAtacado == null) {
            return 0;
        }

        puntosDeAtaque = pokemonUsuario.getAtaquePokemon();
        nivelPokemon = pokemonUsuario.getNivel();
        variacion = rand.ints(VARIACION_INICIO, VARIACION_FIN).findFirst().getAsInt();

        // Verificar si el objetivo está en el aire (por Vuelo)
        if (pokemonAtacado.isEnElAire()) {
            confi.mensajeInformativo("¡El ataque falló porque " + pokemonAtacado.getNombre() + " está en el aire!");
            return 0;
        }

        // Verificar si el objetivo bloquea el ataque con Protección
        if (pokemonAtacado.bolqueador()) {
            confi.mensajeInformativo("¡" + pokemonAtacado.getNombre() + " se protegió del ataque!");
            return 0;
        }

        int def = pokemonAtacado.getDefensaPokemon();
        if (def <= 0) {
            def = 1;
        }
        if (nivelPokemon <= 0) {
            nivelPokemon = 1;
        }

        int daño = (int) (0.01 * variacion *
                ((((0.2 * nivelPokemon + 1) * puntosDeAtaque * potencia) / (25.0 * def)) + 2));
        if (daño < 1) {
            daño = 1;
        }

        int vidaActual = pokemonAtacado.getVidaPokemon();
        int nuevaVida = vidaActual - daño;
        if (nuevaVida < 0) {
            nuevaVida = 0;
        }
        pokemonAtacado.setVidaPokemon(nuevaVida);

        confi.mensajeInformativo("¡" + pokemonUsuario.getNombre() + " usó " + getNombre() + " causando " + daño
                + " de daño a " + pokemonAtacado.getNombre() + "! (HP restante: " + nuevaVida + "/"
                + pokemonAtacado.getVidaInicial() + ")");

        if (!recursivo) {
            estadosAlterados();
        }
        return daño;
    }

}
