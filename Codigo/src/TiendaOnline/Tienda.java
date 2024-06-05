package TiendaOnline;

import Banco.CuentaBancaria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

public class Tienda {
    public ArrayList<Cliente> listaClientes= new ArrayList<>();
    public ArrayList<Producto> listaProductos=new ArrayList<>(); //según cantidad de apariciones se mide el stock
    public ArrayList<Pedido> listaPedidos=new ArrayList<>();
    public ArrayList<Pedido> listaPedidosRealizados=new ArrayList<>();
    public ArrayList<Pedido> listaPedidosPendientes=new ArrayList<>();
    public Tienda() {
        //generarProductos();
        generarClientes();
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
        Producto p=new Producto("Cuchillo",1, 15.0F,9);
        listaProductos.add(p);
        Producto p2=new Producto("Secadora",2, 20.0F,11);
        listaProductos.add(p2);
        Producto p3=new Producto("Ordenador",3, 600.0F,14);
        listaProductos.add(p3);
        Producto p4=new Producto("Mesa",4, 150.0F,5);
        listaProductos.add(p4);
        Producto p5=new Producto("Cuchillo",5, 15.0F,40);
        listaProductos.add(p5);
        Producto p6=new Producto("Secadora",6, 20.0F,22);
        listaProductos.add(p6);
        Producto p7=new Producto("Ordenador",7, 600.0F,33);
        listaProductos.add(p7);
        Producto p8=new Producto("Mesa",8, 150.0F,6);
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
        //Pedido pedido= new Pedido(idPedido,idCliente,productos,costeTotal,estado);
        //listaPedidos.add(pedido);
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
    public boolean guardarDatosProductos() throws IOException {
        File f = new File("Productos.txt");
        if (!f.exists()) {
            System.out.println("Fichero no existente, creando uno nuevo");
            f.createNewFile();
        }
        boolean guardado = false;
        try {
            FileWriter fw = new FileWriter(f); // Abre el archivo en modo de sobreescritura
            BufferedWriter bw = new BufferedWriter(fw);
            for (Producto p : listaProductos) {
                System.out.println("Guardando producto: " + p);
                bw.write(p.toString());
                bw.newLine();
            }
            bw.flush();
            System.out.println("Datos guardados exitosamente");
            guardado = true;
            fw.close();
            bw.close();
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
        return guardado;
    }
    public void cargarDatosProductos() throws IOException{
        File f= new File("Productos.txt");
        if(!f.exists())
        {
            System.out.println("Fichero no existente, creando uno nuevo");
            f.createNewFile();
        }
        FileReader fr= new FileReader(f);
        BufferedReader br= new BufferedReader(fr);
        String linea= "";
        Producto producto=null;
        try {
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int id = Integer.parseInt(datos[1]);
                float precio = Float.parseFloat(datos[2]);
                int stock = Integer.parseInt(datos[3]);
                producto = new Producto(nombre, id, precio, stock);
                listaProductos.add(producto);
                producto = null;
            }
        } catch (Exception e) { System.out.println("Error "+ e); }
        fr.close();
        br.close();

        fr= null;
        br= null;
    }

    public void cargarDatosPedidos() throws  IOException{
        File f= new File("Pedidos.txt");
        if(!f.exists())
        {
            System.out.println("Fichero no existente, creando uno nuevo");
            f.createNewFile();
        }
        FileReader fr= new FileReader(f);
        BufferedReader br= new BufferedReader(fr);
        String linea= "";
        Producto producto=null;
        while((linea= br.readLine())!= null) {
            String[] datos= linea.split(",");
            String idPedido= datos[0];
            int idCliente= Integer.parseInt(datos[1]);
            String[] idProductos= datos[2].split(";");
            ArrayList<Integer> lProductos= new ArrayList<>();
            for(String idP: idProductos){
                int id=Integer.parseInt(idP);
                lProductos.add(id);
            }
            float costeTotal= Float.parseFloat(datos[3]);
            String estado= datos[4];
            Pedido p= new Pedido(idPedido,idCliente,lProductos,costeTotal,estado);
            listaPedidos.add(p);
        }
    }

}
