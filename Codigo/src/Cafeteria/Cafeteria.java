package Cafeteria;

import Restaurante.Mesa;
import Restaurante.PilaMesa;
import Restaurante.Reserva;

import java.util.ArrayList;
import java.util.Random;

public class Cafeteria {
    ArrayList<Comensal> listaComensales = new ArrayList<>();
    ArrayList<Comensal> listaPendientes= new ArrayList<>();
    PilaBandeja pBandejas = new PilaBandeja();
    PilaBandeja pBandejasTotales = new PilaBandeja();

    public Cafeteria() {
    }

    public void mostrarListaComensales() {
        for (Comensal c : listaComensales) {
            System.out.println(c);
        }
    }
    public void mostrarPendientes(){
        for (Comensal c : listaPendientes) {
            System.out.println(c);
        }
    }
    public void mostrarPilaBandejas() {
        pBandejas.mostrar();
    }
    public void mostrarPilaBandejasTotales() {pBandejasTotales.mostrar();}
    public void mostrarCurso(int curso) {
        for (Comensal c : listaComensales) {
            if (c.getCurso() == curso) {
                System.out.println(c);
            }
        }
    }

    public void mostrarVeganos() {
        for (Comensal c : listaComensales) {
            if (c.isVegano()) {
                System.out.println(c);
            }
        }
    }

    public void mostrarServidos() {
        for (Comensal c : listaComensales) {
            if (c.isServido()) {
                System.out.println(c);
            }
        }
    }

    public void generarBandejas() {
        String[] platos = {"Ensalada", "Sopa", "Filete", "Tacos", "Paella", "Pizza", "Pasta"};
        String[] postres = {"Pastel", "Helado", "Flan", "Tarta", "Gelatina", "Mousse", "Churros"};
        Random rand = new Random();
        for (int i = 0; i < 20; i++) { //se generan 20
            int numero = i + 1;
            String platoPrincipal = platos[rand.nextInt(platos.length)];
            String postre = postres[rand.nextInt(postres.length)];
            Boolean vegano = (rand.nextInt(2) == 0) ? true : false;
            Boolean disponible = true;
            Bandeja bandeja= new Bandeja(numero,platoPrincipal,postre,vegano,disponible);
            pBandejas.insertar(bandeja);
            pBandejasTotales.insertar(bandeja);
            bandeja = null;
        }
    }

    public void generarComensales() {
        String listaNombres[] = {"David", "Alejandro", "Juan", "Pedro", "Sandra", "Maria", "Alejandra", "Silvia", "Jose", "Vanesa", "Ana", "Patricia", "Fernando", "Manuel", "Luis", "Elena", "Carlos", "Carmen", "Lorena", "Roberto", "Rosa", "Laura", "Javier", "Isabel", "Antonio", "Eduardo", "Marta", "Raul", "Lucia", "Diego", "Veronica", "Sergio", "Monica", "Andres", "Beatriz", "Miguel", "Maria Jose", "Pablo", "Victoria", "Ricardo", "Natalia", "Hector", "Valentina", "Gonzalo", "Camila", "Rene", "Paola", "Hugo", "Diana"};
        Random rand = new Random();
        String[] platos = {"Ensalada", "Sopa", "Filete", "Tacos", "Paella", "Pizza", "Pasta"};
        for (int i = 0; i < 20; i++) {

            String platoPrincipal = platos[rand.nextInt(platos.length)];
            Comensal c= new Comensal(i+1,listaNombres[rand.nextInt(45)],(rand.nextInt(3) == 0) ? 1 : (rand.nextInt(2) == 0) ? 2 : 3,false, platoPrincipal,(rand.nextInt(2) == 0) ? true : false);
            listaComensales.add(c);
        }
    }
    public void atenderCurso(int curso) {
        PilaBandeja aux= new PilaBandeja();
        ArrayList<Comensal> listaEliminar = new ArrayList<>();
        for (Comensal c : listaComensales) {
            String platoP=c.getPlatoPrincipal();
            if (c.getCurso() == curso && !c.isServido() ) {
                for(int i=0; i<pBandejas.tamaño();i++){
                    Bandeja b= pBandejas.extraer();
                    if(c.isVegano()==b.isVegano() && platoP.equals(c.getPlatoPrincipal())){
                        c.setNumeroBandeja(b.getNumero());
                        c.setServido(true);
                        b.setDisponible(false);

                        listaEliminar.add(c);
                        break;
                    }
                    else{
                        aux.insertar(b);
                    }
                }
                if(c.getNumeroBandeja()==0){
                    System.out.println("Bandeja no encontrado");
                    listaPendientes.add(c);
                }
            }
            aux.volcarPila(pBandejas);
        }
        listaComensales.removeAll(listaEliminar);
    }
    public void atenderTodosCursos(){
        Bandeja b;
        PilaBandeja aux= new PilaBandeja();
        ArrayList<Comensal> eliminar= new ArrayList<>();
        for(Comensal c: listaComensales){ //busqueda comensal
            String platoP=c.getPlatoPrincipal();
            if(!c.isServido()){
                for(int i=0; i< pBandejas.tamaño(); i++){ //busqueda mesa
                    b=pBandejas.extraer();
                    if(c.isVegano()==b.isVegano() && b.isDisponible() && !c.isServido() && platoP.equals(c.getPlatoPrincipal())){
                        c.setNumeroBandeja(b.getNumero());
                        c.setServido(true);
                        b.setDisponible(false);
                        eliminar.add(c);
                        break;
                    }
                    else{
                        aux.insertar(b);
                    }
                }
                if(c.getNumeroBandeja()==0){
                    listaPendientes.add(c);
                }
            }
            aux.volcarPila(pBandejas);
        }
        listaComensales.removeAll(eliminar);
    }
    public void atenderPendientes(){
        Bandeja b;
        PilaBandeja aux= new PilaBandeja();
        ArrayList<Comensal> eliminar= new ArrayList<>();
        for(Comensal c: listaComensales){
            String platoP=c.getPlatoPrincipal();
            if(!c.isServido()){
                for(int i=0; i< pBandejas.tamaño(); i++){ //busqueda mesa
                    b=pBandejas.extraer();
                    if(c.isVegano()==b.isVegano() && b.isDisponible() && !c.isServido()){
                        c.setNumeroBandeja(b.getNumero());
                        c.setServido(true);
                        b.setDisponible(false);
                        eliminar.add(c);
                        break;
                    }
                    else{
                        aux.insertar(b);
                    }
                }
                if(c.getNumeroBandeja()==0){
                    int numero= pBandejasTotales.mayorNumero() +1;
                    Random rand= new Random();
                    String[] postres = {"Pastel", "Helado", "Flan", "Tarta", "Gelatina", "Mousse", "Churros"};
                    String postre = postres[rand.nextInt(postres.length)];
                    Boolean vegano = c.isVegano();
                    Boolean disponible = false;
                    Bandeja b2= new Bandeja(numero,platoP,postre,vegano,disponible);
                    c.setNumeroBandeja(b2.getNumero());
                    pBandejasTotales.insertar(b2);
                    eliminar.add(c);
                }
            }
            aux.volcarPila(pBandejas);
        }
        listaPendientes.removeAll(eliminar);
    }

}
