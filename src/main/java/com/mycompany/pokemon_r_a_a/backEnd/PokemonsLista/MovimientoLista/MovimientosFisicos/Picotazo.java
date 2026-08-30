package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Picotazo extends Fisico{
public Picotazo() {
nombre="Picotazo";
potencia=40;
}

@Override
protected void estadosAlterados() {
   System.out.println(confi.formatearMapa("El pokemon a ensartado al pokemon "+pokemonAtacado.getApodo()+" con su pico punzante"));
        confi.separadorFinalMapa();
}

}
