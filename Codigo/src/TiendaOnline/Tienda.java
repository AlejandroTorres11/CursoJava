package TiendaOnline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Tienda {
    public ArrayList<Cliente> listaClientes= new ArrayList<>();
    public ArrayList<Producto> listaProductos=new ArrayList<>(); //según cantidad de apariciones se mide el stock
    public ArrayList<Pedido> listaPedidos=new ArrayList<>();
    public ArrayList<Pedido> listaPedidosRealizados=new ArrayList<>();
    public ArrayList<Pedido> listaPedidosPendientes=new ArrayList<>();
    public Tienda() {

    }

    public void generarClientes(){
        for(int i = 0; i < 5; i++){
            Random rand= new Random();
            String[] listaNombres = {"David", "Alejandro", "Juan", "Pedro", "Sandra", "Maria", "Alejandra", "Silvia", "Jose", "Vanesa", "Ana", "Patricia", "Fernando", "Manuel", "Luis", "Elena", "Carlos", "Carmen", "Lorena", "Roberto", "Rosa", "Laura", "Javier", "Isabel", "Antonio", "Eduardo", "Marta", "Raul", "Lucia", "Diego", "Veronica", "Sergio", "Monica", "Andres", "Beatriz", "Miguel", "Maria Jose", "Pablo", "Victoria", "Ricardo", "Natalia", "Hector", "Valentina", "Gonzalo", "Camila", "Rene", "Paola", "Hugo", "Diana"};
            String[] provincias={"Madrid","Cádiz","Sevilla"};
            int id=i+1;
            String nombre=listaNombres[rand.nextInt(listaNombres.length)];
            String provincia=provincias[rand.nextInt(provincias.length)];
            Cliente cliente=new Cliente(id,nombre,provincia);
            listaClientes.add(cliente);
        }
    }

    public void generarProductos(){
        Producto p=new Producto("Cuchillo",1, 15.0F);
        listaProductos.add(p);
        Producto p2=new Producto("Secadora",2, 20.0F);
        listaProductos.add(p2);
        Producto p3=new Producto("Ordenador",3, 600.0F);
        listaProductos.add(p3);
        Producto p4=new Producto("Mesa",4, 150.0F);
        listaProductos.add(p4);
        Producto p5=new Producto("Cuchillo",5, 15.0F);
        listaProductos.add(p5);
        Producto p6=new Producto("Secadora",6, 20.0F);
        listaProductos.add(p6);
        Producto p7=new Producto("Ordenador",7, 600.0F);
        listaProductos.add(p7);
        Producto p8=new Producto("Mesa",8, 150.0F);
        listaProductos.add(p8);
    }
    public void añadirAlCarrito(int id,int idProducto){
        Cliente cliente = null;
        for(Cliente c:listaClientes){
            if(c.getId()==id){
                cliente=c;
                break;
            }
        }
        Producto producto=null;
        for(Producto p:listaProductos){
            if(p.getId()==idProducto){
                producto=p;
                break;
            }
        }
        if(listaProductos.contains(producto)){
            int indice=listaProductos.indexOf(producto);
            Producto p=listaProductos.get(indice);
            listaProductos.remove(indice);
            cliente.getCarrito().add(p);
        }
    }
    public void realizarPedido(int id){
        Cliente cliente = null;
        for(Cliente c:listaClientes){
            if(c.getId()==id){
                cliente=c;
                break;
            }
        }
        LocalDate fechaActual= LocalDate.now();
        int idCliente= cliente.getId();
        String idPedido= fechaActual.toString() + idCliente;
        ArrayList<Producto> productos= cliente.getCarrito();
        float costeTotal= cliente.PrecioCarrito();
        String estado= "recibido";
        Pedido pedido= new Pedido(idPedido,idCliente,productos,costeTotal,estado);
        listaPedidos.add(pedido);
        cliente.vaciarCarrito();
    }
    public void mostrarPedidos(){
        for(Pedido pedido: listaPedidos){
            System.out.println(pedido);
        }
    }
    public void mostrarPedidosRealizados(){
        for(Pedido pedido: listaPedidosRealizados){
            System.out.println(pedido);
        }
    }
    public void mostrarPedidosPendientes(){
        for(Pedido pedido: listaPedidosPendientes){
            System.out.println(pedido);
        }
    }
    public void mostrarCliente(int id){
        for(Cliente cliente: listaClientes){
            if(cliente.getId()==id){
                System.out.println(cliente);
            }
        }
    }
    public void mostrarProductos(){
        for(Producto producto: listaProductos){
            System.out.println(producto);
        }
    }

}
