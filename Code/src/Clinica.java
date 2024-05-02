
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.io.*;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Iterator;

public class Clinica {
    private List<Paciente> listaPacientes= new ArrayList<Paciente>();

    public Clinica() throws IOException,Exception {
        System.out.println("baliza");
        File f = new File("Clinica.txt");
        if (!f.exists()) {
            System.out.println("No existe");
            f.createNewFile();
        }
        //String isbn, titulo, autor, editorial, fechaRegistro, fechaPrestamo, precio, prestado;
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea = "";
        Paciente paciente = null;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
            String[] datos = linea.split(",");
            String historiaClinica=datos[0], nombre=datos[1], servicio=datos[2], seguroMedico=datos[3];
            int importe= Integer.parseInt(datos[4]);
            LocalDate fechaCita= LocalDate.parse(datos[5]);
            boolean atendido= Boolean.parseBoolean(datos[6]);
            paciente=new Paciente(historiaClinica,nombre,servicio,seguroMedico, importe, fechaCita,atendido );
            listaPacientes.add(paciente);
             System.out.println(paciente.toString());
            paciente = null;
        }
        fr.close();
        br.close();

        fr = null;
        br = null;
    }

    public List<Paciente> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public List<Paciente> mostrarPacientes(){  //ordenadas por seguro medico
        System.out.println(listaPacientes.toString());
        return listaPacientes;
    }


    public boolean darCita(){
        return true;
    }
    public Paciente atenderPaciente(){ //el primer paciente no atendido del dia,se cobra segun tenga o no seguro, null si no hay paciente
        return null;
    }
    public Paciente modificaCita(){
        return null;
    }
    public void mostrarHistorialPaciente(){

    }
    public List<Paciente> mostrarPacientesSinAtender() {

        return null;
    }
    public void cobrarServicio(){

    }
    public int eliminarPacienteSeguro(){
        return 0;
    }
    public boolean guardarDatos(){
        return true;
    }
}
