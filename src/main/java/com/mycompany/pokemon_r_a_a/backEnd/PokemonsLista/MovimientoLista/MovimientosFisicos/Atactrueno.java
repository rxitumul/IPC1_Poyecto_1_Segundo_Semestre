package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class Atactrueno extends Fisico {
    public Atactrueno() {
        nombre = "Atactrueno";
        potencia=90;
    }

    @Override
    protected void estadosAlterados() {
 System.out.println(confi.formatearMapa("El pokemon hiso un ataque electrico"));

    }
    
}
