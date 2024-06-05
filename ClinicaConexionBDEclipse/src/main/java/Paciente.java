
import java.util.Date;
import java.time.LocalDate;
import java.util.Objects;
public class Paciente {
    private int historiaClinica;
    private String nombre;
    private String servicio;
    private String seguroMedico;
    private int importe;
    private Date fechaCita;
    private boolean atendido;

    public Paciente(int historiaClinica, String nombre, String servicio, String seguroMedico, int importe, Date fechaCita2, boolean atendido) {
        this.historiaClinica = historiaClinica;
        this.nombre = nombre;
        this.servicio = servicio;
        this.seguroMedico = seguroMedico;
        this.importe = importe;
        this.fechaCita = fechaCita2;
        this.atendido = atendido;
    }

    public int getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(int historiaClinica) {
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

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
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
        return historiaClinica +","+nombre+","+servicio+","+seguroMedico+","+importe+","+fechaCita+","+atendido;

    }
}
