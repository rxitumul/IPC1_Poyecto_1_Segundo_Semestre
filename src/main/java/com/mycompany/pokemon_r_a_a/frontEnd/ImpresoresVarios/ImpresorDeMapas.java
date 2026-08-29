package com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresVarios;




import com.mycompany.pokemon_r_a_a.backEnd.TiposDeCasillas.Casillas;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class ImpresorDeMapas extends ImpresoresGlobal  {


    public void imprimirMapaObjetos(Casillas[][] mapa, String nombre) {
        separadorInicioMapa();
        System.out.println(formatearMapa("Ciudad " + nombre));
        separadorMediosMapa();
        for (Casillas[] casillas : mapa) {
            System.out.print(getMarcoVertical());
            for (Casillas casillas2 : casillas) {
                casillas2.imprimir();
            }
            System.out.println(getMarcoVertical());
        }
        separadorMediosMapa();
        System.out.println(formatearMapa("CONTROLES"));
        separadorMediosMapa();
        System.out.println(formatearMapa("    ┌───┐      "));
        System.out.println(formatearMapa("    │ W │      M → Mochila       N → Mapa          X → Salir"));
        System.out.println(formatearMapa("┌───┼───┼───┐"));
        System.out.println(formatearMapa("│ A │ S │ D │  P → Pokémon       T → Pokédex       F → Perfil"));
        System.out.println(formatearMapa("└───┴───┴───┘"));
        separadorMediosMapa();
        System.out.println(formatearMapa("OBJETOS DEL MAPA"));
        separadorMediosMapa();
        System.out.println(formatearMapa("■ Murro   ✚ Centro Pokémon   G Gimnasio   $ Tienda   ⌂ Casa"));
        System.out.println(formatearMapa("♣ Hierba  ☻ NPC              ♠ Árbol      ≈ Agua"));
        separadorMediosMapa();
        System.out.println(formatearMapa("Porfavor selecione una opcion"));
        separadorFinalMapa();
    }
}
