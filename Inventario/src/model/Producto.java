package model;

public class Producto {
    private String nombre;
    private int stock;

    public Producto(String nombre, int stockInicial) {
        this.nombre = nombre;
        this.stock = stockInicial;
    }

    public String getNombre() { return nombre; }
    public int getStock() { return stock; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setStock(int stock) { this.stock = stock; }

    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            this.stock += cantidad;
        }
    }

    public boolean vender(int cantidad) {
        if (cantidad > 0 && cantidad <= stock) {
            this.stock -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + " | Stock: " + stock;
    }
}
