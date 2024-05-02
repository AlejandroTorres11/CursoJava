package Clases;

public class Pila {
	Nodo ultimo; 
	public Pila() {
		ultimo=null;
	}
	
	public boolean estaVacia() {
		return ultimo==null;
	}
	public void insertar(int v) {
		Nodo nuevo= new Nodo(v);
		nuevo.siguiente=ultimo;
		ultimo=nuevo;
	}
	public int extraer() {
		int v;
		if(ultimo==null) {
			return 0;
		}
		v=ultimo.valor;
		ultimo=ultimo.siguiente;
		return v;
	}
	
	public void mostrar() {
		Nodo aux=ultimo;
		while(aux!=null) {
			System.out.print("-->" + aux.valor);
			aux=aux.siguiente;
		}
	}
	public int tamaño() {
		Nodo aux=ultimo;
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
	
	public void volcarPila(Pila p) {
		int valor;
		while(!estaVacia()) {
			valor=extraer();
			p.insertar(valor);
		}
	}
	public Pila invertir() {
		Pila aux= new Pila();
		volcarPila(aux);
		return aux;
	}
	public boolean buscarElemento(int v) {
		Nodo aux=ultimo;
		int valor;
		boolean encontrado=false;
		while(aux!=null && !encontrado ) {
			valor=aux.valor;
			if(valor==v) {
				encontrado=true;
			}
			else {
				aux=aux.siguiente;
			}
		}
		return encontrado;
	}
	public Pila eliminarElemento(int v) {
		Pila aux= new Pila();
		int valor;
		while(!estaVacia()) {
			valor= extraer();
			if(valor==v) {
				
			}
			else {
				aux.insertar(valor);
			}
		}
		aux=aux.invertir();
		return aux;
	}
	public Pila eliminarUnElemento(int v) {
		Pila aux= new Pila();
		int valor;
		boolean eliminado=false;
		while(!estaVacia()) {
			valor= extraer();
			if(valor==v && !eliminado) {
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
