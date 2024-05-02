import java.io.IOException;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Clinica clinica= new Clinica();
        clinica.mostrarPacientes();
        clinica.darCita();
        clinica.modificaCita("165389", LocalDate.of(2030, 5, 1));
        clinica.mostrarPacientes();
        clinica.mostrarPacientesSinAtender();
    }
}