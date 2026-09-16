package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.ListaEnlazadaException;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Listas;
import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Nodo;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Estados;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;
import com.mycompany.pokemon_r_a_a.frontEnd.ImpresoresGlobal;

public class Pokemons implements Serializable {

    private final static int VARIACION_INICIO = 0;
    private final static int VARIACION_FIN = 32;

    private String nombreLocal;
    private String apodo;

    private int vidaPokemon;
    private int defensaPokemon;
    private int ataquePokemon;
    private int velocidadPokemon;

    private int vidaBase;
    private int defensaBase;
    private int ataqueBase;
    private int velocidadBase;

    private int vidaInicial;
    private int defensaInicial;
    private int ataqueInicial;
    private int velocidadInicial;

    private int vidaVariacion;
    private int defensaVariacion;
    private int ataqueVariacion;
    private int velocidadVariacion;

    private int id;
    private int tipo;
    private int xp;
    private int nivel;
    private int enemigosDebilitados = 0;
    private String idDinamico;
    private String tipoNombre;
    private boolean prioritario;
    private boolean activoBloqueo = false;
    private boolean enElAire = false;
    private boolean cargandoRayoSolar = false;

    private transient Random rand;
    private transient ImpresoresGlobal impresor;
    private Listas<Estados> estadosAlterados;
    private Listas<Estados> estadosAlteradosPermanete;

    private Movimiento[] movimientosPokemonLocal;

    public Pokemons() {
        estadosAlterados = new Listas<Estados>();
        estadosAlteradosPermanete = new Listas<Estados>();
        rand = new Random();
        impresor = new ImpresoresGlobal();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject(); // Esto carga todo lo normal (vida, medallas, pokemons...)
        rand = new Random();
        impresor = new ImpresoresGlobal();

    }

    public void eliminarElefecto(Estados estado) throws ListaEnlazadaException {
        int index = estadosAlterados.obtenerIndex(estado);
        if (index != -1) {
            estadosAlterados.eliminar(index);
        }
    }

    public void setXp(int xp) {
        this.xp = xp;
        int xpSubirDeNivel = (nivel + 1) * (nivel + 1);
        while (this.xp >= xpSubirDeNivel) {
            this.xp -= xpSubirDeNivel;
            setNivel(this.nivel + 1);
            if (apodo != null && !apodo.isEmpty()) {
                impresor.mensajeInformativo("¡El Pokémon " + apodo + " subió al nivel " + nivel + "!");
            } else {
                impresor.mensajeInformativo("¡El Pokémon " + nombreLocal + " subió al nivel " + nivel + "!");
            }
            xpSubirDeNivel = (nivel + 1) * (nivel + 1);
        }
    }

    public String getEstadosActivosString() {
        String resultado = "";

        Nodo<Estados> actual = estadosAlterados.getInicio();
        while (actual != null) {
            Estados e = actual.getContenido();
            if (e != null) {
                if (!resultado.isEmpty()) {
                    resultado += " ";
                }
                resultado += "[" + e.getNombreCorto() + "]";
            }
            actual = actual.getSiguiente();
        }

        actual = estadosAlteradosPermanete.getInicio();
        while (actual != null) {
            Estados e = actual.getContenido();
            if (e != null) {
                if (!resultado.isEmpty()) {
                    resultado += " ";
                }
                resultado += "[" + e.getNombreCorto() + "]";
            }
            actual = actual.getSiguiente();
        }

        if (resultado.isEmpty()) {
            return "NINGUNO";
        } else {
            return resultado;
        }
    }

    public boolean tieneEstado(String nombreEstado) {
        Nodo<Estados> actual = estadosAlterados.getInicio();
        while (actual != null) {
            Estados e = actual.getContenido();
            if (e != null && e.getNombre().equals(nombreEstado)) {
                return true;
            }
            actual = actual.getSiguiente();
        }

        actual = estadosAlteradosPermanete.getInicio();
        while (actual != null) {
            Estados e = actual.getContenido();
            if (e != null && e.getNombre().equals(nombreEstado)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public Estados obtenerEstado(String nombreEstado) {
        Nodo<Estados> actual = estadosAlterados.getInicio();
        while (actual != null) {
            Estados e = actual.getContenido();
            if (e != null && e.getNombre().equals(nombreEstado)) {
                return e;
            }
            actual = actual.getSiguiente();
        }

        actual = estadosAlteradosPermanete.getInicio();
        while (actual != null) {
            Estados e = actual.getContenido();
            if (e != null && e.getNombre().equals(nombreEstado)) {
                return e;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void eliminarEstado(String nombreEstado) {
        int index = 0;
        Nodo<Estados> actual = estadosAlterados.getInicio();
        while (actual != null) {
            Nodo<Estados> siguiente = actual.getSiguiente();
            Estados e = actual.getContenido();
            if (e != null && e.getNombre().equals(nombreEstado)) {
                try {
                    estadosAlterados.eliminar(index);
                } catch (ListaEnlazadaException ex) {
                    break;
                }
            } else {
                index++;
            }
            actual = siguiente;
        }

        index = 0;
        actual = estadosAlteradosPermanete.getInicio();
        while (actual != null) {
            Nodo<Estados> siguiente = actual.getSiguiente();
            Estados e = actual.getContenido();
            if (e != null && e.getNombre().equals(nombreEstado)) {
                try {
                    estadosAlteradosPermanete.eliminar(index);
                } catch (ListaEnlazadaException ex) {
                    break;
                }
            } else {
                index++;
            }
            actual = siguiente;
        }
    }

    public void restauradorArtibutos() {
        vidaPokemon = vidaInicial;
        defensaPokemon = defensaInicial;
        velocidadPokemon = velocidadInicial;
        ataquePokemon = ataqueInicial;
    }

    public boolean bolqueador() {
        if (activoBloqueo) {
            activoBloqueo = false;
            return rand.nextDouble() <= 0.70;
        }
        return false;
    }

    public void setActivoBloqueo(boolean activoBloqueo) {
        this.activoBloqueo = activoBloqueo;
    }

    public void agragarEstado(Estados estado) {
        estadosAlterados.agregarAlFinal(estado);
    }

    public void agragarEstadoPermanete(Estados estado) {
        estadosAlteradosPermanete.agregarAlFinal(estado);
    }

    public Listas<Estados> getEstadosAlterados() {
        return estadosAlterados;
    }

    public Listas<Estados> getEstadosAlteradosPermanete() {
        return estadosAlteradosPermanete;
    }

    public boolean isEnElAire() {
        return enElAire;
    }

    public void setEnElAire(boolean enElAire) {
        this.enElAire = enElAire;
    }

    public boolean isCargandoRayoSolar() {
        return cargandoRayoSolar;
    }

    public void setCargandoRayoSolar(boolean cargandoRayoSolar) {
        this.cargandoRayoSolar = cargandoRayoSolar;
    }

    public void lipiarEstadosTodos() {
        estadosAlterados.limpiar();
        estadosAlteradosPermanete.limpiar();
        enElAire = false;
        cargandoRayoSolar = false;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public void setAtaqueInicial(int ataqueInicial) {
        this.ataqueInicial = ataqueInicial;
        ataqueBase = ataqueInicial;
    }

    public void setVelocidadInicial(int velocidadInicial) {
        this.velocidadInicial = velocidadInicial;
        velocidadBase = velocidadInicial;
    }

    public void setVidaInicial(int vidaInicial) {
        this.vidaInicial = vidaInicial;
        vidaBase = vidaInicial;
    }

    public void setDefensaInicial(int defensaInicial) {
        this.defensaInicial = defensaInicial;
        defensaBase = defensaInicial;
    }

    public void setAtaquePokemon(int ataquePokemon) {
        this.ataquePokemon = ataquePokemon;
    }

    public void setDefensaPokemon(int defensaPokemon) {
        this.defensaPokemon = defensaPokemon;
    }

    public void setNivel(int nivel) {
        if (nivel <= 1) {
            this.nivel = 1;
            restauradorArtibutos();
            return;
        }

        int nivelInicio = this.nivel;
        if (nivelInicio < 1) {
            nivelInicio = 1;
        }

        for (int n = nivelInicio + 1; n <= nivel; n++) {
            vidaVariacion = rand.ints(VARIACION_INICIO, VARIACION_FIN).findFirst().getAsInt();
            defensaVariacion = rand.ints(VARIACION_INICIO, VARIACION_FIN).findFirst().getAsInt();
            ataqueVariacion = rand.ints(VARIACION_INICIO, VARIACION_FIN).findFirst().getAsInt();
            velocidadVariacion = rand.ints(VARIACION_INICIO, VARIACION_FIN).findFirst().getAsInt();

            int aumentoVida = (int) ((((vidaBase + vidaVariacion) * 2 * n) / 100) + n + 10);
            int aumentoDefensa = (int) (((((defensaBase + defensaVariacion) * 2 * n)) / 100) + 5);
            int aumentoAtaque = (int) (((((ataqueBase + ataqueVariacion) * 2 * n)) / 100) + 5);
            int aumentoVelocidad = (int) (((((velocidadBase + velocidadVariacion) * 2 * n)) / 100) + 5);

            vidaInicial += aumentoVida;
            defensaInicial += aumentoDefensa;
            ataqueInicial += aumentoAtaque;
            velocidadInicial += aumentoVelocidad;

            if (vidaPokemon > 0) {
                vidaPokemon += aumentoVida;
            }
            defensaPokemon += aumentoDefensa;
            ataquePokemon += aumentoAtaque;
            velocidadPokemon += aumentoVelocidad;
        }
        this.nivel = nivel;
    }

    public void setVelocidadPokemon(int velocidadPokemon) {
        this.velocidadPokemon = velocidadPokemon;
    }

    public void setVidaPokemon(int vidaPokemon) {
        this.vidaPokemon = vidaPokemon;
    }

    public void setNombre(String nombre) {
        nombreLocal = nombre;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public void setMovimientos(Movimiento[] movimientosPokemon) {

        movimientosPokemonLocal = movimientosPokemon;
        for (Movimiento movimiento : movimientosPokemon) {
            movimiento.setPokemonUsuario(this);
        }
    }

    public void setId(int id) {
        this.id = id;
        if (this.idDinamico == null) {
            this.idDinamico = String.valueOf(id);
        }
    }

    public void setId(String id) {
        this.idDinamico = id;
        try {
            this.id = Integer.parseInt(id.replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            this.id = 0;
        }
    }

    public int getId() {
        return id;
    }

    public String getIdDinamico() {
        if (idDinamico != null) {
            return idDinamico;
        } else {
            return String.valueOf(id);
        }
    }

    public void setIdDinamico(String idDinamico) {
        setId(idDinamico);
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTipoNombre() {
        return tipoNombre;
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNombre() {
        return nombreLocal;
    }

    public Movimiento[] getMovimientos() {
        return movimientosPokemonLocal;
    }

    public String getApodo() {
        return apodo;
    }

    public int getAtaqueInicial() {
        return ataqueInicial;
    }

    public int getAtaquePokemon() {
        return ataquePokemon;
    }

    public int getDefensaInicial() {
        return defensaInicial;
    }

    public int getDefensaPokemon() {
        return defensaPokemon;
    }

    public int getVelocidadInicial() {
        return velocidadInicial;
    }

    public int getVelocidadPokemon() {
        return velocidadPokemon;
    }

    public int getVidaInicial() {
        return vidaInicial;
    }

    public int getVidaPokemon() {
        return vidaPokemon;
    }

    public boolean getPrioritario() {
        return prioritario;
    }

    public int getXp() {
        return xp;
    }

    public int getEnemigosDebilitados() {
        return enemigosDebilitados;
    }

    public void incrementarEnemigosDebilitados() {
        this.enemigosDebilitados++;
    }
}
