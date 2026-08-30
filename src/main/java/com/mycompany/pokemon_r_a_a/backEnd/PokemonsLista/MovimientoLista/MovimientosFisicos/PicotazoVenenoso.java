package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.MovimientosFisicos;

import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Envenenado;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Fisico;

public class PicotazoVenenoso extends Fisico {
    public PicotazoVenenoso() {
        nombre = "PicotazoVenenoso";
    }

    @Override
    protected void estadosAlterados() {
        System.out.println(confi.formatearMapa("Ataqu toxico"));
        if(rand.nextDouble()>0.15){
            System.out.println(confi.formatearMapa("Se enveneno al pokemon "+pokemonAtacado.getApodo()));
            pokemonAtacado.agragarEstado(new Envenenado(pokemonAtacado));
        }else{
            System.out.println(confi.formatearMapa("No se enveneno al pokemon "+pokemonAtacado.getApodo()));
        }
        confi.separadorFinalMapa();
    }
}
