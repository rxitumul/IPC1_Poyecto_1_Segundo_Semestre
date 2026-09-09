package com.mycompany.pokemon_r_a_a.backEnd.PokemonsLista.EstadosAlterados;

public abstract class Estados {
    protected int contador;
    protected String nombre;
    protected String nombreCorto;

    public String getNombre() {
        if (nombre != null) {
            return nombre;
        }
        return getClass().getSimpleName();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCorto() {
        if (nombreCorto != null) {
            return nombreCorto;
        }
        return getNombre();
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public void decrementarContador() {
        if (contador > 0) {
            contador--;
        }
    }

    public boolean esExpirado() {
        return contador <= 0;
    }

    public boolean accion() {
        return contador == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return this.getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
