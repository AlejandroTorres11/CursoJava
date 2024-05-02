
import java.util.*;
import java.time.LocalDate;
import java.io.*;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class Clinica {
    private List<Paciente> listaPacientes= new ArrayList<Paciente>();

    public Clinica() throws IOException,Exception {
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
            //System.out.println(linea);
            String[] datos = linea.split(",");
            String historiaClinica=datos[0], nombre=datos[1], servicio=datos[2], seguroMedico=datos[3];
            int importe= Integer.parseInt(datos[4]);
            LocalDate fechaCita= LocalDate.parse(datos[5]);
            boolean atendido= Boolean.parseBoolean(datos[6]);
            paciente=new Paciente(historiaClinica,nombre,servicio,seguroMedico, importe, fechaCita,atendido );
            listaPacientes.add(paciente);
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
        ordenarSeguro();
        // Mostrar la lista de pacientes ordenada
        System.out.println("Lista de pacientes ordenada por seguroMedico:");
        for (Paciente paciente : listaPacientes) {
            System.out.println(paciente);
        }
        return listaPacientes;
    }
    public List<Paciente> ordenarSeguro(){
        Collections.sort(listaPacientes, Comparator.comparing(Paciente::getSeguroMedico)); //Paciente :: para no tener que invocar un paciente, entonces se tendria que usar un for
        return listaPacientes;
    }

    public boolean darCita(){
        boolean resultado=false;
        for (Paciente paciente : listaPacientes) {
            if(!paciente.isAtendido()){
                paciente.setAtendido(true);
                resultado=true;
                if(paciente.getSeguroMedico()=="PRIVADO"){
                    paciente.setImporte(50);
                }
                else{
                    paciente.setImporte(30);
                }
                break;
            }
        }
        return resultado;
    }
    public Paciente atenderPaciente(){ //el primer paciente no atendido del dia,se cobra segun tenga o no seguro, null si no hay paciente
        return null;
    }
    public void modificaCita(String historiaClinica,LocalDate nuevaFecha){
        for (Paciente paciente : listaPacientes) {
            if (paciente.getHistoriaClinica().equals(historiaClinica)) {
                paciente.setFechaCita(nuevaFecha);
                break;
            }
        }
    }
    public void mostrarHistorialPaciente(){
        //problema ya que el numero de historia clinica es solo un numero, no entiendo lo que pide el enunciado,.
    }
    public List<Paciente> mostrarPacientesSinAtender() {
        List<Paciente> sinAtender= new ArrayList<Paciente>();
        System.out.println("Lista pacientes sin atender");
        for(Paciente paciente : listaPacientes) {
            if(!paciente.isAtendido()){
                sinAtender.add(paciente);
                System.out.println(paciente);
            }
        }
        return sinAtender;
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
