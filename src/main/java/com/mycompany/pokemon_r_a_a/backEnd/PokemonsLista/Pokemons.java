package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista;

import java.util.Random;

import com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas.Listas;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados.Estados;
import com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.MovimientoLista.Movimiento;

public class Pokemons {

    private static final int IV_INICIO = 0;
    private static final int IV_FIN = 16;
    private Movimiento[] movimientosPokemonLocal;
    private String nombreLocal;
    private String apodo;

    private int vidaPokemon;
    private int defensaPokemon;
    private int ataquePokemon;
    private int velocidadPokemon;

    private int vidaInicial;
    private int defensaInicial;
    private int ataqueInicial;
    private int velocidadInicial;

    private int vidaIv;
    private int defensaIv;
    private int ataqueIv;
    private int velocidadIv;

    private int xpVida;
    private int xpAtaque;
    private int xpDefensa;
    private int xpVelocidad;

    private int id;
    private int nivel;
    private int xp;
    private boolean prioritario;

    private Listas<Estados> estadosAlterados;
    private Listas<Estados> estadosAlteradosPermanete;
    private Random rand = new Random();

    private boolean activoBloqueo = false;

    public Pokemons() {
        vidaIv = rand.ints(IV_INICIO, IV_FIN).findFirst().getAsInt();
        defensaIv = rand.ints(IV_INICIO, IV_FIN).findFirst().getAsInt();
        ataqueIv = rand.ints(IV_INICIO, IV_FIN).findFirst().getAsInt();
        velocidadIv = rand.ints(IV_INICIO, IV_FIN).findFirst().getAsInt();

    }

    public boolean bolqueador() {
        if (activoBloqueo) {
            activoBloqueo = false;
            return rand.nextDouble() > 0.7;
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

    public void lipiarEstadosTodos() {
        estadosAlterados.limpiar();
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public void setAtaqueInicial(int ataqueInicial) {
        this.ataqueInicial = ataqueInicial;
    }

    public void setAtaquePokemon(int ataquePokemon) {
        this.ataquePokemon = ataquePokemon;
    }

    public void setDefensaInicial(int defensaInicial) {
        this.defensaInicial = defensaInicial;
    }

    public void setDefensaPokemon(int defensaPokemon) {
        this.defensaPokemon = defensaPokemon;
    }

    public void setNivel(int nivel) {

        vidaInicial = (int) ((((vidaInicial * vidaIv) * 2 + ((raizCuadrada(xpVida) / 4) * nivel)) / 100) + nivel + 10);
        defensaInicial = (int) ((((defensaInicial * defensaIv) * 2 + ((raizCuadrada(xpDefensa) / 4) * nivel)) / 100)
                + 5);
        ataqueInicial = (int) ((((ataqueInicial * ataqueIv) * 2 + ((raizCuadrada(xpAtaque) / 4) * nivel)) / 100) + 5);
        velocidadInicial = (int) ((((velocidadInicial * velocidadIv) * 2 + ((raizCuadrada(xpVelocidad) / 4) * nivel))
                / 100) + 5);

        this.nivel = nivel;
    }

    public void setVelocidadInicial(int velocidadInicial) {
        this.velocidadInicial = velocidadInicial;
    }

    public void setVelocidadPokemon(int velocidadPokemon) {
        this.velocidadPokemon = velocidadPokemon;
    }

    public void setVidaInicial(int vidaInicial) {
        this.vidaInicial = vidaInicial;
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
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    private double raizCuadrada(double numero) {
        if (numero < 0) {
            return 0;
        }
        if (numero == 0 || numero == 1) {
            return numero;
        }

        double estimacion = numero;
        double precision = 0.00001;
        double diferencia = 1;

        while (diferencia > precision) {
            double siguienteEstimacion = 0.5 * (estimacion + (numero / estimacion));

            diferencia = estimacion - siguienteEstimacion;
            if (diferencia < 0) {
                diferencia = -diferencia;
            }

            estimacion = siguienteEstimacion;
        }

        return estimacion;
    }
}
