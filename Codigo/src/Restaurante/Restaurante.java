package Restaurante;

import Clases.Pila;

import java.util.ArrayList;
import java.util.List;
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
        int numeroPersonas = r.getNumeroPersonas();

        if(numeroPersonas>4){
            numeroPersonas=8;

        }
        else if(numeroPersonas<=4){
            numeroPersonas=4;

        }
        for(int i=0; i< pMesas.tamaño(); i++){
            m=pMesas.extraer();
            if(m.getSituacion().equals(r.getSituacionMesa()) && m.getCapacidad()== numeroPersonas){
                r.setNumeroMesa(m.getNumeroMesa());
                m.setDisponible(false);
                pMesasOcupadas.insertar(m);
                listaAtendiendose.add(r);
                listaReservas.remove(r);
                aux.volcarPila(pMesas);
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
        for(Reserva r : listaReservas){//busqueda comensal
            if(!r.isAtendida()){
                int numeroPersonas = r.getNumeroPersonas();
                System.out.println(numeroPersonas);
                if(numeroPersonas>4){
                    numeroPersonas=8;

                }
                else if(numeroPersonas<=4){
                    numeroPersonas=4;

                }
                for(int i=0; i< pMesas.tamaño(); i++){ //busqueda mesa
                    m=pMesas.extraer();
                    if(m.getSituacion().equals(r.getSituacionMesa()) && numeroPersonas==m.getCapacidad() && !r.isAtendida()){
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

    public void servirMesas(){
        List<Reserva> eliminar= new ArrayList<>();
        for(Reserva r : listaAtendiendose){
            Mesa m=pMesasOcupadas.extraerMesaNumero(r.getNumeroMesa());
            m.setDisponible(true);
            pMesas.insertar(m);
            eliminar.add(r);
        }
        listaAtendiendose.removeAll(eliminar);
    }
    public void atenderPendientes(){

        Mesa m;
        PilaMesa aux= new PilaMesa();
        ArrayList<Reserva> eliminar= new ArrayList<>();
        for(Reserva r : listaPendientes){
            if(!r.isAtendida()){
                int numeroPersonas = r.getNumeroPersonas();
                if(numeroPersonas>4){
                    numeroPersonas=8;

                }
                else if(numeroPersonas<=4){
                    numeroPersonas=4;

                }
                for(int i=0; i<pMesas.tamaño();i++){
                    m=pMesas.extraer();
                    if(m.getCapacidad()==numeroPersonas && m.getSituacion().equals(r.getSituacionMesa()) && m.isDisponible()){
                        r.setNumeroMesa(m.getNumeroMesa());
                        m.setDisponible(false);
                        pMesasOcupadas.insertar(m);
                        listaAtendiendose.add(r);
                        r.setAtendida(true);
                        eliminar.add(r);
                        break;
                    }else{
                        aux.insertar(m);
                    }
                }
            }
            aux.volcarPila(pMesas);
        }
        listaPendientes.removeAll(eliminar);
    }
    public int finalizarPendientes(){
        int i=0;
        while(listaPendientes.size()>0){
            System.out.println("Atender pendientes");
            atenderPendientes();
            System.out.println("Pendientes");
            mostrarPendientes();
            System.out.println("Atendiendose");
            mostrarAtendiendose();
            System.out.println("Mesas");
            mostrarMesas();
            System.out.println("Mesas ocupadas");
            mostrarMesasOcupadas();
            servirMesas();
            i++;
        }
        return i;
    }

}
