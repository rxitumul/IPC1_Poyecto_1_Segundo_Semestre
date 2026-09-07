package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class HojaAfilada extends Fisico{
public HojaAfilada() {
    nombre= "HojaAfilada";
    potencia= 80;;
}

@Override
protected void estadosAlterados() {
 System.out.println(confi.formatearMapa("El pokemon a utilizado hojas afiladas para cortar al oponete"));

}
}
