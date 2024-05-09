package Restaurante;

import java.util.Objects;

public class Mesa {
    private int numeroMesa;
    private int capacidad; // Terraza o Interior
    private String situacion; // Terraza o Interior
    private boolean disponible;

    public Mesa(int numeroMesa, int capacidad, String situacion,boolean disponible) {
        this.numeroMesa = numeroMesa;
        this.capacidad = capacidad;
        this.situacion = situacion;
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mesa mesa = (Mesa) o;
        return numeroMesa == mesa.numeroMesa && capacidad == mesa.capacidad && Objects.equals(situacion, mesa.situacion);
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "numeroMesa=" + numeroMesa +
                ", capacidad=" + capacidad +
                ", situacion='" + situacion +"disponible="+disponible+"-->\n" ;
    }
}
