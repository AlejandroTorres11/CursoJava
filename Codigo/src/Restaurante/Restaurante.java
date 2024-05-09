package Restaurante;

import Clases.Pila;

import java.util.ArrayList;
import java.util.Random;

public class Restaurante {
    public ArrayList<Reserva> listaReservas= new ArrayList<>();
    public PilaMesa pMesas= new PilaMesa();
    public Restaurante() {

    }
    public void generarReservas(){
        String listaNombres[] = {"David", "Alejandro", "Juan", "Pedro", "Sandra", "Maria", "Alejandra", "Silvia", "Jose", "Vanesa", "Ana", "Patricia", "Fernando", "Manuel", "Luis", "Elena", "Carlos", "Carmen", "Lorena", "Roberto", "Rosa", "Laura", "Javier", "Isabel", "Antonio", "Eduardo", "Marta", "Raul", "Lucia", "Diego", "Veronica", "Sergio", "Monica", "Andres", "Beatriz", "Miguel", "Maria Jose", "Pablo", "Victoria", "Ricardo", "Natalia", "Hector", "Valentina", "Gonzalo", "Camila", "Rene", "Paola", "Hugo", "Diana"};
        Random rand = new Random();
        for( int i=0; i<20; i++){
            int numPersonas = rand.nextInt(8) + 1;
            String nombre = listaNombres[rand.nextInt(45)];
            String situacionMesa = (rand.nextInt(2) == 0) ? "Terraza" : "Interior";
            String menu = (rand.nextInt(3) == 0) ? "vegano" : ((rand.nextInt(2) == 0) ? "sin Gluten" : "completo");
            Reserva reserva = new Reserva(i + 1,0, nombre, numPersonas, menu,situacionMesa);
            listaReservas.add(reserva);
        }
    }
    public void generarMesas(){
        Random rand= new Random();
        for(int i=0; i<10; i++){
            int numeroMesa= i+1;
            int capacidad = (rand.nextInt() % 2 == 0) ? 4 : 8;
            boolean disponible = true;
            String situacion;
            if (i <= 5) {
                situacion = "Terraza";
            } else {
                situacion = "Interior";
            }
            Mesa mesa= new Mesa(numeroMesa,capacidad,situacion,disponible);
            pMesas.insertar(mesa);
        }
    }
    public void mostrarReservas(){
        for(Reserva reserva : listaReservas){
            System.out.println(reserva.toString());
        }
    }

    public void mostrarMesas(){
        pMesas.mostrar();
    }
}
