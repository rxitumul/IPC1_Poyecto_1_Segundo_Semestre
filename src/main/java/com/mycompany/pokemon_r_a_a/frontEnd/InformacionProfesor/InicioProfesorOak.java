package com.mycompany.pokemon_r_a_a.frontEnd.InformacionProfesor;

import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;
import com.mycompany.pokemon_r_a_a.frontEnd.MensajesDeInformacion;

public class InicioProfesorOak extends ImpresoresGlobal {
    private MensajesDeInformacion info = new MensajesDeInformacion();
    private String nombreLocal;
    private String nombrePokemonLocal;

    private static final String[] MENSAJES_PROFESOR_INICIO = {
            "¡Hola! ¡Bienvenido al maravilloso mundo de los Pokémon!",
            "Mi nombre es Profesor Oak, y desde hace muchos años estudio a estas increíbles criaturas llamadas Pokémon.",
            "Los Pokémon viven junto a nosotros en bosques, montañas, ciudades y muchos otros lugares.",
            "Pero antes de comenzar nuestra aventura...",
            "Dime, ¿cuál es tu nombre?" };

    private String[] mensajeProfesor2;

    private String[] mensajeProfesor3;
    private String[] mensajeProfesor4;

    public String getNombreLocal() {
        return nombreLocal;
    }
    public void cadenaDeMensajesInicial(int mensaje) {
        limpiadorDeLineas();
        separadorInicio();
        if (mensaje != 0) {
            System.out.println(formatear("Profesor Oak"));
            separadorMedios();
        }
        System.out.println(formatear(MENSAJES_PROFESOR_INICIO[mensaje]));
        separadorMedios();
        if (mensaje == 4) {
            info.mensajeDeIngresoDeNombre();
        } else {
            info.mensajeInformativoDecontinuar();
        }
        separadorFinal();
    }

    public void mensajeDespuesDenombre(int mensaje) {
        limpiadorDeLineas();
        separadorInicio();
        System.out.println(formatear("Profesor Oak"));
        separadorMedios();
        System.out.println(formatear(mensajeProfesor2[mensaje]));
        System.out.println(formatear(mensajeProfesor2[mensaje + 1]));
        separadorMedios();
        info.mensajeInformativoDecontinuar();
        separadorFinal();
    }

    public void mensajeProfesorCambioDeNombre(int mensaje) {
        limpiadorDeLineas();
        separadorInicio();
        System.out.println(formatear("Profesor Oak"));
        separadorMedios();
        System.out.println(formatear(mensajeProfesor3[mensaje]));
        separadorMedios();
        info.mensajeInformativoDecontinuar();
        separadorFinal();
    }

    public void mensajeProfesorFinal(int mensaje) {
        limpiadorDeLineas();
        separadorInicio();
        System.out.println(formatear("Profesor Oak"));
        separadorMedios();
        System.out.println(formatear(mensajeProfesor4[mensaje]));
        separadorMedios();
        info.mensajeInformativoDecontinuar();
        separadorFinal();
    }

    public void mensajeDeElecionDePokemon() {
        separadorInicio();
        System.out.println(formatear("(1) Bulbasaur"));
        System.out.println(formatear("(2) Squirtle"));
        System.out.println(formatear("(3) Charmander"));
        separadorMedios();
        System.out.println(formatear("Porfavor escoje un pokemon"));
        separadorFinal();
    }

    public void mensajeDeRenombre() {
        separadorInicio();
        System.out.println(formatear(formatear("Escribe S si desea cambiar el nombre de lo contrario precione enter")));
        separadorFinal();
    }

    public void nombreAEleguir() {
        separadorInicio();
        System.out.println(formatear("Porfavor ingrese el nuevo nombre del pokemon"));
        separadorFinal();

    }

    public void nombreDelPokemon(String apodo) {
        separadorInicio();
        System.out.println(formatear("El apodo del pokemon es" + apodo));
        separadorFinal();
    }

    public void setNombre(String nombre) {
        nombreLocal = nombre;
        mensajeProfesor2 = new String[] {
                "¡Mucho gusto, " + nombreLocal + "!",
                "Hoy estás a punto de comenzar tu propia aventura, " + nombreLocal + ".",
                "Pero antes de partir, necesitas elegir a tu primer compañero Pokémon.",
                "Tengo tres Pokémon aquí conmigo, y cada uno posee habilidades y características diferentes.",
                "El primero es Bulbasaur, un Pokémon de tipo Planta y Veneno. Es tranquilo, resistente y lleva una misteriosa semilla en su espalda.",
                "El segundo es Charmander, un Pokémon de tipo Fuego. Su cola arde constantemente y es conocido por su espíritu combativo.",
                "El tercero es Squirtle, un Pokémon de tipo Agua. Su resistente caparazón le proporciona una gran defensa.",
                "Los tres pueden convertirse en grandes compañeros durante tu viaje.",
                "Así que, " + nombreLocal + "...",
                "¿Cuál de estos tres Pokémon elegirás?" };

    }

    public void setPokemonSelecionado(String nombrePokemon) {
        nombrePokemonLocal = nombrePokemon;
        mensajeProfesor3 = new String[] {
                "¡Excelente elección, " + nombreLocal + "!",
                "Estoy seguro de que " + nombrePokemonLocal + " será un gran compañero para ti.",
                "Pero antes de comenzar tu aventura, hay algo que debemos hacer.",
                "Puedes darle el nombre que tú quieras.",
                "Si prefieres conservar su nombre original, también puedes hacerlo.",
                "¿Quieres ponerle un apodo a tu nuevo compañero?" };
        mensajeProfesor4 = new String[] {
                "Muy bien, " + nombrePokemonLocal + ". ¡Ese será su nombre a partir de ahora!",
                "Ahora que ya tienes a tu primer Pokémon, permíteme darte algunos consejos antes de que partas.",
                "Durante tu aventura encontrarás muchos Pokémon. Algunos serán fáciles de encontrar, mientras que otros serán mucho más difíciles.",
                "Podrás enfrentarte a ellos, capturarlos y formar tu propio equipo.",
                "Recuerda cuidar bien de tus Pokémon y conocer sus fortalezas y debilidades.",
                "También encontrarás diferentes objetos que podrán ayudarte durante tu viaje.",
                "Antes de que partas, quiero entregarte algunos objetos que te serán de gran utilidad durante tu aventura.",
                "Para ayudarte en el inicio de tu viaje, voy a entregarte una Pokédex liberada.",
                "Con ella podrás registrar y consultar información sobre los Pokémon que encuentres durante tu aventura.",
                "También quiero darte 5 Poké Balls. Te serán necesarias si quieres capturar nuevos Pokémon y ampliar tu equipo.",
                "Además, aquí tienes una Poción. Puede ayudarte cuando alguno de tus Pokémon necesite recuperar energía.",
                "Y, por último, te entregaré ₽1000 Pokémonedas para que puedas comprar algunos objetos cuando los necesites.",
                "Pokédex liberada: ✓",
                "Poké Balls: 5",
                "Poción: 1",
                "Pokémonedas: ₽1000",
                "No es mucho para comenzar, pero será suficiente para dar tus primeros pasos.",
                "Y algo muy importante, " + nombreLocal + "...",
                "No tengas miedo de explorar.",
                "El mundo Pokémon está lleno de lugares por descubrir y personas por conocer.",
                "Cada decisión que tomes formará parte de tu propia historia.",
                "Creo que ya estás preparado.",
                "Tienes a tu primer Pokémon, tienes tus herramientas y tienes todo un mundo esperando por ti.",
                "Ahora sí, " + nombreLocal + "...",
                "¡Tu aventura comienza ahora!",
                "¡Buena suerte, entrenador!"
        };
    }
}
