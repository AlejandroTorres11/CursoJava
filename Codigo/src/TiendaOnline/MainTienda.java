package TiendaOnline;

import java.io.IOException;

public class MainTienda {
    public static void main(String[] args) throws IOException {
        Tienda t = new Tienda();
        t.cargarDatosProductos();
        t.guardarDatosProductos();
        t.cargarDatosPedidos();
        t.mostrarPedidos();
    }
}
