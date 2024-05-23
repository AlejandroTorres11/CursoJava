package TiendaOnline;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombre;
    private ArrayList<Producto> carrito;
    private String provincia;

    public Cliente(int id, String nombre, String provincia) {
        this.id = id;
        this.nombre = nombre;
        carrito= new ArrayList<Producto>();
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float PrecioCarrito(){
        float resultado=0;
        for(Producto p: carrito){
            resultado+=p.getPrecio();
        }
        return resultado;
    }
    public void vaciarCarrito(){
        carrito.clear();
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", carrito=" + carrito +
                ", provincia='" + provincia + '\'' +
                '}';
    }
}
