package Clinica;

import excepciones.historiaClinicaException;
import java.time.LocalDate;
import java.util.Objects;
import excepciones.*;
public class Paciente {
    private String historiaClinica;
    private String nombre;
    private String servicio;
    private String seguroMedico;
    private int importe;
    private LocalDate fechaCita;
    private boolean atendido;

    public Paciente(String historiaClinica, String nombre, String servicio, String seguroMedico, int importe, LocalDate fechaCita, boolean atendido) throws historiaClinicaException,fechaException,CamposVaciosException, Exception {
        this.historiaClinica = historiaClinica;
        this.nombre = nombre;
        this.servicio = servicio;
        this.seguroMedico = seguroMedico;
        this.importe = importe;
        this.fechaCita = fechaCita;
        this.atendido = atendido;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente paciente)) return false;
        return importe == paciente.importe && atendido == paciente.atendido && Objects.equals(historiaClinica, paciente.historiaClinica) && Objects.equals(nombre, paciente.nombre) && Objects.equals(servicio, paciente.servicio) && Objects.equals(seguroMedico, paciente.seguroMedico) && Objects.equals(fechaCita, paciente.fechaCita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(historiaClinica, nombre, servicio, seguroMedico, importe, fechaCita, atendido);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "historiaClinica='" + historiaClinica + '\'' +
                ", nombre='" + nombre + '\'' +
                ", servicio='" + servicio + '\'' +
                ", seguroMedico='" + seguroMedico + '\'' +
                ", importe=" + importe +
                ", fechaCita=" + fechaCita +
                ", atendido=" + atendido +
                '}';
    }
}

