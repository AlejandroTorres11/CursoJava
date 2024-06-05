package TiendaOnline;

import java.util.ArrayList;

public class Pedido {
    private String id;
    private int idCliente;
    private ArrayList<Integer> productos;
    private float costeTotal;
    private String estado;

    public Pedido(String id, int idCliente, ArrayList<Integer> productos, float costeTotal, String estado) {
        this.id = id;
        this.idCliente = idCliente;
        this.productos = productos;
        this.costeTotal = costeTotal;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<Integer> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Integer> productos) {
        this.productos = productos;
    }

    public float getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(float costeTotal) {
        this.costeTotal = costeTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", productos=" + productos.toString() +
                ", costeTotal=" + costeTotal +
                ", estado='" + estado + '\'' +
                '}';
    }
}
