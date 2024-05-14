package Restaurante;

import java.util.Objects;

public class Reserva {
    private int numeroReserva;
    private int numeroMesa;
    private String nombre;
    private int numeroPersonas;
    private String menu;
    private String situacionMesa;
    private boolean atendida;

    public Reserva(int numeroReserva,int numeroMesa, String nombre, int numeroPersonas, String menu, String situacionMesa) {
        this.numeroReserva = numeroReserva;
        this.numeroMesa = numeroMesa;
        this.nombre = nombre;
        this.numeroPersonas = numeroPersonas;
        this.menu = menu;
        this.situacionMesa = situacionMesa;
        this.atendida = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return numeroMesa == reserva.numeroMesa && numeroPersonas == reserva.numeroPersonas && Objects.equals(nombre, reserva.nombre) && Objects.equals(menu, reserva.menu) && Objects.equals(situacionMesa, reserva.situacionMesa);
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getSituacionMesa() {
        return situacionMesa;
    }

    public void setSituacionMesa(String situacionMesa) {
        this.situacionMesa = situacionMesa;
    }

    public boolean isAtendida() {
        return atendida;
    }

    public void setAtendida(boolean atendida) {
        this.atendida = atendida;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numeroReserva=" + numeroReserva +
                ", numeroMesa=" + numeroMesa +
                ", nombre='" + nombre + '\'' +
                ", numeroPersonas=" + numeroPersonas +
                ", menu='" + menu + '\'' +
                ", situacionMesa='" + situacionMesa + '\'' + "atendia= " + atendida +
                '}';
    }
}
