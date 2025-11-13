package model;

import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    private Producto buscarProductoPorNombre(String nombreBuscado) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return p;
            }
        }
        return null;
    }

    public String registrarEntrada(String nombre, int cantidad) {
        if (cantidad <= 0) {
            return "La cantidad debe ser mayor que cero.";
        }

        Producto encontrado = buscarProductoPorNombre(nombre);

        if (encontrado == null) {
            encontrado = new Producto(nombre, cantidad);
            productos.add(encontrado);
            return "Producto nuevo agregado: " + encontrado;
        } else {
            encontrado.agregarStock(cantidad);
            return "Entrada registrada. Nuevo stock de " + nombre + ": " + encontrado.getStock();
        }
    }

    public String registrarVenta(String nombre, int cantidad) {
        if (cantidad <= 0) {
            return "La cantidad debe ser mayor que cero.";
        }

        Producto encontrado = buscarProductoPorNombre(nombre);

        if (encontrado == null) {
            return "El producto '" + nombre + "' no existe en el inventario.";
        }

        boolean ok = encontrado.vender(cantidad);

        if (ok) {
            return "Venta registrada. Stock restante de " + nombre + ": " + encontrado.getStock();
        } else {
            return "No hay stock suficiente para vender " + cantidad + " unidades de " + nombre + ". Stock actual: " + encontrado.getStock();
        }
    }

    public String generarReporteInventario() {
        if (productos.isEmpty()) {
            return "El inventario está vacío.";
        }

        StringBuilder sb = new StringBuilder();
        for (Producto p : productos) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }

    public String generarReporteStockCritico() {
        StringBuilder sb = new StringBuilder();
        boolean hayCriticos = false;

        for (Producto p : productos) {
            if (p.getStock() <= 5) {
                sb.append(p.toString()).append("\n");
                hayCriticos = true;
            }
        }

        if (!hayCriticos) {
            sb.append("No hay productos en stock crítico.\n");
        }

        return sb.toString();
    }
}
