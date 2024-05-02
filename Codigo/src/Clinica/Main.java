package Clinica;

import java.io.IOException;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws Exception {
        Clinica clinica= new Clinica();
        clinica.mostrarPacientes();
        clinica.darCita("165393","Dermatologia",LocalDate.of(2027,3,21));
        clinica.modificaCita("165389","Dermatologia",LocalDate.of(2030, 5, 1));
        clinica.mostrarPacientes();
        clinica.mostrarPacientesSinAtender();
        clinica.mostrarHistorialPaciente("165389");
        System.out.println();
        //int numero=clinica.eliminarPacienteSeguro("PRIVADO");
        //System.out.println(numero);
        System.out.println();
        clinica.mostrarPacientes();
        clinica.guardarDatos();
    }
}