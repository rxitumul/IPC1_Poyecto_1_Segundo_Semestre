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
 System.out.println(confi.formatearMapa("El pokemon a realizado un ataque electrico"));
 if (rand.nextDouble()>0.15){
    System.out.println(confi.formatearMapa("El pokemon a paralizado al oponete"));
    pokemonAtacado.agragarEstado(new Paralizado());
 }
        confi.separadorFinalMapa();
}

}
