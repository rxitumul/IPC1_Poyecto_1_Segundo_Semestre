package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Hidrocanon extends Fisico{
public Hidrocanon() {
    nombre="Hidrocanon";
    potencia= 120;
}

@Override
protected void estadosAlterados() {
 System.out.println(confi.formatearMapa("El pokemon a utlizado un cañonazo de agua el pokemon debe descansar"));
        confi.separadorFinalMapa();
}

}
