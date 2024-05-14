package Cafeteria;

import java.util.Objects;

public class Comensal {
    private int numero;
    private int numeroBandeja;
    private String nombre;
    private int curso;
    private boolean servido;
    private boolean vegano;

    // Constructor
    public Comensal(int numero, String nombre, int curso, boolean servido, boolean vegano) {
        this.numero = numero;
        this.numeroBandeja=0;
        this.nombre = nombre;
        this.curso = curso;
        this.servido = servido;
        this.vegano = vegano;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumeroBandeja() {
        return numeroBandeja;
    }

    public void setNumeroBandeja(int numeroBandeja) {
        this.numeroBandeja = numeroBandeja;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public boolean isServido() {
        return servido;
    }

    public void setServido(boolean servido) {
        this.servido = servido;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comensal comensal)) return false;
        return numero == comensal.numero && curso == comensal.curso && servido == comensal.servido && vegano == comensal.vegano && Objects.equals(nombre, comensal.nombre);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                ", curso=" + curso +
                ", servido=" + servido +
                ", vegano=" + vegano ;
    }
}