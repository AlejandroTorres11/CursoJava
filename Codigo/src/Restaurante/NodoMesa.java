package Restaurante;

import Clases.Nodo;

public class NodoMesa {
    Mesa valor;
    NodoMesa siguiente;
    public NodoMesa(Mesa m) {
        valor=m;
        siguiente=null;
    }
}
