package com.mycompany.pokemon_r_a_a.backEnd.ListaîlaYColas;

import java.io.Serializable;

public class Listas<T> implements Serializable {

    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int capacidad;

    public Listas() {
        capacidad = 0;
    }

    public void agregarAlFinal(T contenido) {
        Nodo<T> nuevo = new Nodo<T>(contenido);
        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo; // Corrección base: asegurar que fin no quede null al inicio
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
        }
        capacidad++;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public T obtenerContenido(int index) throws ListaEnlazadaException {
        Nodo<T> nodoBuscado = obtenerNodo(index);
        return (T) nodoBuscado.getContenido();
    }

    private Nodo<T> obtenerNodo(int index) throws ListaEnlazadaException {
        if (index < 0 || index >= capacidad) {
            throw new ListaEnlazadaException("El indice esta fuera de rango, por favor intente de nuevo");
        }
        Nodo<T> actual = inicio;
        for (int i = 0; i < index; i++) {
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public void eliminar(int index) throws ListaEnlazadaException {
        if (index < 0 || index >= capacidad) {
            throw new ListaEnlazadaException("El indice esta fuera de rango, por favor intente de nuevo");
        }

        if (index == 0) {
            inicio = inicio.getSiguiente();
            if (inicio == null) {
                fin = null;
            } else {
                inicio.setAnterior(null); // ✔️ CORRECCIÓN: Desvincular el nodo viejo hacia atrás
            }
        } else {
            Nodo<T> nodoAEliminar = obtenerNodo(index);
            Nodo<T> anterior = nodoAEliminar.getAnterior();
            Nodo<T> siguiente = nodoAEliminar.getSiguiente();

            anterior.setSiguiente(siguiente);
            if (siguiente != null) {
                siguiente.setAnterior(anterior);
            } else {
                fin = anterior;
            }
        }
        capacidad--;
    }

    public void eliminarUltimo() throws ListaEnlazadaException {
        if (esVacia()) {
            throw new ListaEnlazadaException("La lista esta vacia");
        }

        if (capacidad == 1) {
            inicio = null;
            fin = null;
        } else {
            // Optimización: Usar el puntero 'fin' directo en vez de recorrer toda la lista con obtenerNodo
            fin = fin.getAnterior();
            fin.setSiguiente(null);
        }
        capacidad--;
    }

    public int obtenerIndex(T contenido) {
        Nodo<T> actual = inicio;
        int contador = 0;
        if (contenido == null) {
            return -1;
        }
        while (actual != null) {
            // ✔️ CORRECCIÓN: Usar .equals() para comparar el objeto real, no solo su tipo de clase
            if (actual.getContenido() != null && actual.getContenido().equals(contenido)) {
                return contador;
            }
            contador++;
            actual = actual.getSiguiente();
        }
        return -1;
    }

    public void limpiar() {
        inicio = null;
        fin = null;
        capacidad = 0;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean estaVacia(){
        return inicio == null;
    }

    public Nodo<T> getInicio() {
        return inicio;
    }
}
