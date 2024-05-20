package Cafeteria;

import Cafeteria.Bandeja;
import Cafeteria.NodoBandeja;

public class PilaBandeja {
    NodoBandeja ultimo;
    public PilaBandeja() {
        ultimo=null;
    }

    public boolean estaVacia() {
        return ultimo==null;
    }
    public void insertar(Bandeja b) {
        NodoBandeja nuevo= new NodoBandeja(b);
        nuevo.siguiente=ultimo;
        ultimo=nuevo;
    }
    public Bandeja extraer() {
        Bandeja b;
        if(ultimo==null) {
            return null;
        }
        b=ultimo.valor;
        ultimo=ultimo.siguiente;
        return b;
    }

    public void mostrar() {
        NodoBandeja aux=ultimo;
        while(aux!=null) {
            System.out.print("-->" + aux.valor.toString());
            aux=aux.siguiente;
        }
    }
    public int tamaño() {
        NodoBandeja aux=ultimo;
        int tamaño=0;
        while(aux!=null) {
            tamaño++;
            aux=aux.siguiente;
        }
        return tamaño;
    }
    public void vaciarPila() {
        while(!estaVacia()) {
            extraer();
        }
    }

    public void volcarPila(PilaBandeja pb) {
       Bandeja b;
        while(!estaVacia()) {
            b=extraer();
            pb.insertar(b);
        }
    }
    public PilaBandeja invertir() {
        PilaBandeja aux= new PilaBandeja();
        volcarPila(aux);
        return aux;
    }
    public boolean buscarElemento(Bandeja b) {
        NodoBandeja aux=ultimo;
        Bandeja valor;
        boolean encontrado=false;
        while(aux!=null && !encontrado ) {
            valor=aux.valor;
            if(valor.equals(b)) {
                encontrado=true;
            }
            else {
                aux=aux.siguiente;
            }
        }
        return encontrado;
    }
    public PilaBandeja eliminarElemento(Bandeja b) {
        PilaBandeja aux= new PilaBandeja();
        Bandeja valor;
        while(!estaVacia()) {
            valor= extraer();
            if(valor.equals(b)) {

            }
            else {
                aux.insertar(valor);
            }
        }
        aux=aux.invertir();
        return aux;
    }
    public PilaBandeja eliminarUnElemento(Bandeja b) {
        PilaBandeja aux= new PilaBandeja();
        Bandeja valor;
        boolean eliminado=false;
        while(!estaVacia()) {
            valor= extraer();
            if(valor.equals(b) && !eliminado) {
                eliminado=true;
            }
            else {
                aux.insertar(valor);
            }
        }
        aux=aux.invertir();
        return aux;
    }
    public int mayorNumero(){
        int numeroMaximo=0;
        NodoBandeja aux=ultimo;
        Bandeja valor;
        while (aux!=null){
            valor=aux.valor;
            if(valor.getNumero()>numeroMaximo){
                numeroMaximo=valor.getNumero();
            }
            aux=aux.siguiente;
        }
        return numeroMaximo;
    }
}
