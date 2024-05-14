package Cafeteria;

public class Bandeja {
    private int numero;
    private String platoPrincipal;
    private String postre;
    private boolean vegano;
    private boolean disponible;
    public Bandeja(int numero, String platoPrincipal, String postre, boolean vegano, boolean disponible) {
        this.numero = numero;
        this.platoPrincipal = platoPrincipal;
        this.postre = postre;
        this.vegano = vegano;
        this.disponible = disponible;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getPlatoPrincipal() {
        return platoPrincipal;
    }

    public void setPlatoPrincipal(String platoPrincipal) {
        this.platoPrincipal = platoPrincipal;
    }

    public String getPostre() {
        return postre;
    }

    public void setPostre(String postre) {
        this.postre = postre;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return  "numero=" + numero +
                ", platoPrincipal='" + platoPrincipal + '\'' +
                ", postre='" + postre + '\'' +
                ", vegano=" + vegano +
                ", disponible=" + disponible +'\n' ;
    }
}

