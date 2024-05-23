package TiendaOnline;

public class MainTienda {
    public static void main(String[] args) {
        Tienda t = new Tienda();
        t.generarClientes();
        t.generarProductos();
        t.añadirAlCarrito(1,1);
        t.añadirAlCarrito(1,2);
        t.mostrarCliente(1);
        t.realizarPedido(1);
        t.mostrarPedidos();
        t.mostrarProductos();

    }
}
