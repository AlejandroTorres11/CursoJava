

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.time.LocalDate;
import java.io.*;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Clinica {
    private List<Paciente> listaPacientes = new ArrayList<Paciente>();
    Conexion conexion = new Conexion();
    DatosClinica datosClinica= null;
    public Clinica() throws IOException, Exception {
        try {
            Conexion conexion= new Conexion();
            conexion.ConexionBaseDeDatos();
            Connection con= conexion.getConnection()
;           datosClinica = new DatosClinica(con);
            listaPacientes = datosClinica.getConsultaPacientes("Select * from pacientes");
            System.out.println("baliza");
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        }
    }
    
    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public List<Paciente> mostrarPacientes() {  //ordenadas por seguro medico
        ordenarSeguro();
        // Mostrar la lista de pacientes ordenada
        System.out.println("Lista de pacientes ordenada por seguroMedico:");
        for (Paciente paciente : listaPacientes) {
            System.out.println(paciente);
        }
        return listaPacientes;
    }

    public List<Paciente> ordenarSeguro() {
        Collections.sort(listaPacientes, Comparator.comparing(Paciente::getSeguroMedico)); //Paciente :: para no tener que invocar un paciente, entonces se tendria que usar un for
        return listaPacientes;
    }

    public boolean darCita(int historiaClinica, String servicio, Date fechaCita) throws Exception {
        boolean resultado = false;
        for (Paciente paciente : listaPacientes) {
            if(paciente.getHistoriaClinica() ==historiaClinica) {
                    Paciente nuevoPaciente= new Paciente(paciente.getHistoriaClinica(),paciente.getNombre(),servicio, paciente.getSeguroMedico(),0,fechaCita,false);
                    listaPacientes.add(nuevoPaciente);
                    datosClinica.agregarPaciente(nuevoPaciente);
                    break;
            }
        }
        return resultado;
    }

    public Paciente atenderPaciente(String servicio) { //el primer paciente no atendido del dia,se cobra segun tenga o no seguro, null si no hay paciente
        Paciente p = null;
        for (Paciente paciente : listaPacientes) {
            if (!paciente.isAtendido() && paciente.getServicio().equals(servicio)) {
                paciente.setAtendido(true);
                if (paciente.getSeguroMedico() == "PRIVADO") {
                    paciente.setImporte(50);
                } else {
                    paciente.setImporte(30);
                }
                paciente.setAtendido(true);
                p=paciente;
                break;
            }
        }
        return p;
    }

    public void modificaCita(int historiaClinica,String servicio,Date nuevaFecha) {
        for (Paciente paciente : listaPacientes) {
            if ((paciente.getHistoriaClinica()==historiaClinica) && paciente.getServicio().equals(servicio)) {
                paciente.setFechaCita(nuevaFecha);

                break;
            }
        }
    }

    public void mostrarHistorialPaciente(int historiaClinica) {
        //problema ya que el numero de historia clinica es solo un numero, no entiendo lo que pide el enunciado,.
        System.out.println("Historial del paciente "+historiaClinica);
        for (Paciente paciente : listaPacientes) {
            if (paciente.getHistoriaClinica()==historiaClinica) {
                System.out.println(paciente);
            }
        }
    }

    public List<Paciente> mostrarPacientesSinAtender() {
        List<Paciente> sinAtender = new ArrayList<Paciente>();
        System.out.println("Lista pacientes sin atender");
        for (Paciente paciente : listaPacientes) {
            if (!paciente.isAtendido()) {
                sinAtender.add(paciente);
                System.out.println(paciente);
            }
        }
        return sinAtender;
    }

    public void cobrarServicio() {

    }

public int eliminarPacienteSeguro(String seguro) throws SQLException {
        int eliminados = 0;
        Iterator<Paciente> iterator = listaPacientes.iterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (seguro.equals(paciente.getSeguroMedico())) {
                datosClinica.borrarPaciente("DELETE * FROM paciente WHERE seguro=" +seguro);
                iterator.remove();
                eliminados++;
            }
        }
        return eliminados;
    }
}

