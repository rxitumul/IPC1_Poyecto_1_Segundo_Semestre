package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class RayoSolar extends Fisico{
public RayoSolar() {
nombre="RayoSolar";
potencia=120;
}

@Override
protected void estadosAlterados() {
 System.out.println(confi.formatearMapa("El pokemon a utilizado toda la carga de energia solar y ataco al pokemon con un rayo"));
        confi.separadorFinalMapa();
}
}
