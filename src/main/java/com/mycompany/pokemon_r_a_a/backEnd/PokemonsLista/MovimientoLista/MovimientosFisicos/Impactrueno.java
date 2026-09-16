package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Paralizado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Impactrueno extends Fisico{
public Impactrueno() {
    nombre = "Impactrueno";
    potencia=50;
}

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("¡" + pokemonUsuario.getNombre() + " lanzó una descarga eléctrica!"));
        if (rand.nextDouble() <= 0.15) {
            String nombreObjetivo;
            if (pokemonAtacado.getApodo() != null) {
                nombreObjetivo = pokemonAtacado.getApodo();
            } else {
                nombreObjetivo = pokemonAtacado.getNombre();
            }
            System.out.println(confi.formatearMapa("¡" + nombreObjetivo + " ha sido paralizado!"));
            if (!pokemonAtacado.tieneEstado("Paralizado")) {
                pokemonAtacado.agragarEstado(new Paralizado());
            }
        }
    }


}
