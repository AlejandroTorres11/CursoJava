import java.util.Date;

public class MainClinica {
	public static void main(String[] args) throws Exception {
        Clinica clinica= new Clinica();
        clinica.mostrarPacientes();
        Date fechaCita= new Date(2027,5,8);
        clinica.darCita(21,"Dermatologia",fechaCita);
        //clinica.modificaCita(22,"Dermatologia",LocalDate.of(2030, 5, 1));
        clinica.mostrarPacientes();
        clinica.mostrarPacientesSinAtender();
        clinica.mostrarHistorialPaciente(165389);
        System.out.println();
        //int numero=clinica.eliminarPacienteSeguro("PRIVADO");
        //System.out.println(numero);
        System.out.println();
        clinica.mostrarPacientes();
    }
}
