package Clases;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pila pila= new Pila();
        pila.insertar(2);
        pila.insertar(5);
        pila.insertar(3);
        pila.insertar(4);
        pila.insertar(5);
        pila.insertar(5);
        pila.mostrar();
        pila=pila.eliminarUnElemento(5);
        System.out.println();
        pila.mostrar();
        pila= pila.eliminarElemento(5);
        System.out.println();
        pila.mostrar();
        System.out.println("\ntamaño:" +pila.tamaño());
        System.out.println();
        
	}

}
