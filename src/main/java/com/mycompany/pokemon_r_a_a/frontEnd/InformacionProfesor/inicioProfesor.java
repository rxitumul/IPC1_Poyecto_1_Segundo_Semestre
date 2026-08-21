package com.mycompany.pokemon_r_a_a.frontEnd.InformacionProfesor;

import com.mycompany.pokemon_r_a_a.frontEnd.ConfiguracionesDeEstetica;
import com.mycompany.pokemon_r_a_a.frontEnd.MensajesDeInformacion;
import com.mycompany.pokemon_r_a_a.frontEnd.MensajesDeInformacion;

public class InicioProfesor {
    private ConfiguracionesDeEstetica confi = new ConfiguracionesDeEstetica();
    private MensajesDeInformacion info = new MensajesDeInformacion();
    private String nombreLocal = "";
    private static final String[] MENSAJES_PROFESOR_INICIO = {
            "¡Hola! ¡Bienvenido al maravilloso mundo de los Pokémon!",
            "Mi nombre es Profesor Oak, y desde hace muchos años estudio a estas increíbles criaturas llamadas Pokémon.",
            "Los Pokémon viven junto a nosotros en bosques, montañas, ciudades y muchos otros lugares.",
            "Pero antes de comenzar nuestra aventura...",
            "Dime, ¿cuál es tu nombre?"};
    private String mensajeProfesor2[] = {
            "¡Mucho gusto, " + nombreLocal + "!",
            "Hoy estás a punto de comenzar tu propia aventura, " + nombreLocal + ".",
            "Pero antes de partir, necesitas elegir a tu primer compañero Pokémon.",
            "Tengo tres Pokémon aquí conmigo, y cada uno posee habilidades y características diferentes.",
            "El primero es Bulbasaur, un Pokémon de tipo Planta y Veneno. Es tranquilo, resistente y lleva una misteriosa semilla en su espalda.",
            "El segundo es Charmander, un Pokémon de tipo Fuego. Su cola arde constantemente y es conocido por su espíritu combativo.",
            "El tercero es Squirtle, un Pokémon de tipo Agua. Su resistente caparazón le proporciona una gran defensa.",
            "Los tres pueden convertirse en grandes compañeros durante tu viaje.",
            "Así que, " + nombreLocal + "...",
            "¿Cuál de estos tres Pokémon elegirás?"
    };

    public void cadenaDeMensajesInicial(int mensaje) {
        confi.separadorInicio();
        System.out.println(confi.formatear(MENSAJES_PROFESOR_INICIO[mensaje]));
        confi.separadorMedios() ;
        if (mensaje ==4){
            info.mensajeDeIngresoDeNombre();
        }else{
            info.mensajeInformativoDecontinuar();
        }
        confi.separadorFinal();
    }

    public void setNombre(String nombre) {
        nombreLocal = nombre;
    }

    public void mensajeDespuesDenombre(int mensaje) {
        confi.separadorInicio();
        System.out.println(confi.formatear(mensajeProfesor2[mensaje]));
        confi.separadorMedios() ;
        confi.separadorFinal();
    }

}
