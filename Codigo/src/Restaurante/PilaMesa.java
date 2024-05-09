package Restaurante;

import Clases.Nodo;
import Clases.Pila;

public class PilaMesa {
    NodoMesa ultimo;
    public PilaMesa() {
        ultimo=null;
    }

    public boolean estaVacia() {
        return ultimo==null;
    }
    public void insertar(Mesa m) {
        NodoMesa nuevo= new NodoMesa(m);
        nuevo.siguiente=ultimo;
        ultimo=nuevo;
    }
    public Mesa extraer() {
        Mesa m;
        if(ultimo==null) {
            return null;
        }
        m=ultimo.valor;
        ultimo=ultimo.siguiente;
        return m;
    }

    public void mostrar() {
        NodoMesa aux=ultimo;
        while(aux!=null) {
            System.out.print("-->" + aux.valor.toString());
            aux=aux.siguiente;
        }
    }
    public int tamaño() {
        NodoMesa aux=ultimo;
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

    public void volcarPila(PilaMesa p) {
        Mesa m;
        while(!estaVacia()) {
            m=extraer();
            p.insertar(m);
        }
    }
    public PilaMesa invertir() {
        PilaMesa aux= new PilaMesa();
        volcarPila(aux);
        return aux;
    }
    public boolean buscarElemento(Mesa m) {
        NodoMesa aux=ultimo;
        Mesa valor;
        boolean encontrado=false;
        while(aux!=null && !encontrado ) {
            valor=aux.valor;
            if(valor.equals(m)) {
                encontrado=true;
            }
            else {
                aux=aux.siguiente;
            }
        }
        return encontrado;
    }
    public PilaMesa eliminarElemento(Mesa m) {
        PilaMesa aux= new PilaMesa();
        Mesa valor;
        while(!estaVacia()) {
            valor= extraer();
            if(valor.equals(m)) {

            }
            else {
                aux.insertar(valor);
            }
        }
        aux=aux.invertir();
        return aux;
    }
    public PilaMesa eliminarUnElemento(Mesa m) {
        PilaMesa aux= new PilaMesa();
        Mesa valor;
        boolean eliminado=false;
        while(!estaVacia()) {
            valor= extraer();
            if(valor.equals(m) && !eliminado) {
                eliminado=true;
            }
            else {
                aux.insertar(valor);
            }
        }
        aux=aux.invertir();
        return aux;
    }

}
