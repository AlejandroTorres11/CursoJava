package Restaurante;

import Clases.Pila;

import java.util.ArrayList;
import java.util.Random;

public class Restaurante {
    public ArrayList<Reserva> listaReservas= new ArrayList<Reserva>();
    public ArrayList<Reserva> listaPendientes= new ArrayList<Reserva>();
    public ArrayList<Reserva> listaAtendiendose= new ArrayList<Reserva>();
    public PilaMesa pMesas= new PilaMesa();
    public PilaMesa pMesasOcupadas= new PilaMesa();
    public Restaurante() {

    }
    public void generarReservas(){
        String[] listaNombres = {"David", "Alejandro", "Juan", "Pedro", "Sandra", "Maria", "Alejandra", "Silvia", "Jose", "Vanesa", "Ana", "Patricia", "Fernando", "Manuel", "Luis", "Elena", "Carlos", "Carmen", "Lorena", "Roberto", "Rosa", "Laura", "Javier", "Isabel", "Antonio", "Eduardo", "Marta", "Raul", "Lucia", "Diego", "Veronica", "Sergio", "Monica", "Andres", "Beatriz", "Miguel", "Maria Jose", "Pablo", "Victoria", "Ricardo", "Natalia", "Hector", "Valentina", "Gonzalo", "Camila", "Rene", "Paola", "Hugo", "Diana"};
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
    public void mostrarPendientes(){
        for(Reserva reserva : listaPendientes){
            System.out.println(reserva.toString());
        }
    }
    public void mostrarAtendiendose(){
        for(Reserva reserva : listaAtendiendose){
            System.out.println(reserva.toString());
        }
    }
    public void mostrarMesas(){
        pMesas.mostrar();
    }
    public void mostrarMesasOcupadas(){
        pMesasOcupadas.mostrar();
    }
    public void gestionarUnaReserva(){ //gestionamos la primera
        Reserva r= listaReservas.get(0);
        PilaMesa aux= new PilaMesa();
        Mesa m;
        for(int i=0; i< pMesas.tamaño(); i++){
            m=pMesas.extraer();
            if(m.getSituacion().equals(r.getSituacionMesa()) && m.getCapacidad()>= r.getNumeroPersonas()){
                r.setNumeroMesa(m.getNumeroMesa());
                m.setDisponible(false);
                pMesasOcupadas.insertar(m);
                listaAtendiendose.add(r);
                listaReservas.remove(r);
                return;
            }
            else{
                aux.insertar(m);
            }
        }
        System.out.println("No encontrada mesa para: " + r.getNumeroReserva());
        aux.volcarPila(pMesas);
        listaPendientes.add(r);
    }

    public void gestionarReservas(){
        Mesa m;
        PilaMesa aux= new PilaMesa();
        ArrayList<Reserva> eliminar= new ArrayList<>();
        for(Reserva r : listaReservas){
            if(!r.isAtendida()){
                for(int i=0; i< pMesas.tamaño(); i++){
                    m=pMesas.extraer();
                    if(m.getSituacion().equals(r.getSituacionMesa()) && m.getCapacidad()>= r.getNumeroPersonas()){
                        r.setNumeroMesa(m.getNumeroMesa());
                        m.setDisponible(false);
                        r.setAtendida(true);
                        pMesasOcupadas.insertar(m);
                        listaAtendiendose.add(r);
                        eliminar.add(r);
                        break;
                    }
                    else{
                        aux.insertar(m);
                    }
                }
                if(r.getNumeroMesa()==0){
                    listaPendientes.add(r);
                }
            }
            aux.volcarPila(pMesas);
        }
        listaReservas.removeAll(eliminar);
    }
}
