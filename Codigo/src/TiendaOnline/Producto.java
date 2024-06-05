package TiendaOnline;

import java.util.ArrayList;

public class Producto {
    private String nombre;
    private int id;
    private float precio;
    private int stock;

    public Producto(String nombre, int id, float precio,int stock) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return   nombre + ","+ id + "," + precio + "," + stock;
    }

}
