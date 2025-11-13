package controller;

import java.util.Optional;
import model.Inventario;
import view.VistaInventario;

public class ControladorInventario {

    private final Inventario inventario;
    private final VistaInventario vista;

    public ControladorInventario(Inventario inventario, VistaInventario vista) {
        this.inventario = inventario;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = vista.mostrarMenuPrincipal();

            switch (opcion) {
                case 1 -> registrarEntrada();
                case 2 -> registrarVenta();
                case 3 -> verInventarioCompleto();
                case 4 -> verStockCritico();
                case 5 -> {
                    vista.mostrarMensajeVentana("Saliendo del sistema...");
                    salir = true;
                }
                default -> vista.mostrarMensajeVentana("Opcion invalida. Intenta nuevamente.");
            }
        }
    }

    private void registrarEntrada() {
        Optional<String> nombreEntrada = vista.pedirNombreProducto("Registrar entrada");

        if (nombreEntrada.isEmpty()) {
            vista.mostrarMensajeVentana("Operacion cancelada o nombre invalido.");
            return;
        }

        Optional<Integer> cantidadEntrada = vista.pedirCantidad("Registrar entrada");

        if (cantidadEntrada.isEmpty()) {
            vista.mostrarMensajeVentana("Operacion cancelada o cantidad invalida.");
            return;
        }

        int cantidad = cantidadEntrada.get();

        String resultado = inventario.registrarEntrada(nombreEntrada.get(), cantidad);
        vista.mostrarEnConsola("Resultado de registrar entrada", resultado);
        vista.mostrarMensajeVentana("Operacion realizada. Revisa la consola para mas detalles.");
    }

    private void registrarVenta() {
        Optional<String> nombreVenta = vista.pedirNombreProducto("Registrar venta");

        if (nombreVenta.isEmpty()) {
            vista.mostrarMensajeVentana("Operacion cancelada o nombre invalido.");
            return;
        }

        Optional<Integer> cantidadVenta = vista.pedirCantidad("Registrar venta");

        if (cantidadVenta.isEmpty()) {
            vista.mostrarMensajeVentana("Operacion cancelada o cantidad invalida.");
            return;
        }

        int cantidad = cantidadVenta.get();

        String resultado = inventario.registrarVenta(nombreVenta.get(), cantidad);
        vista.mostrarEnConsola("Resultado de registrar venta", resultado);
        vista.mostrarMensajeVentana("Operacion realizada. Revisa la consola para mas detalles.");
    }

    private void verInventarioCompleto() {
        String reporte = inventario.generarReporteInventario();
        vista.mostrarEnConsola("Inventario completo", reporte);
        vista.mostrarMensajeVentana("Inventario mostrado en la consola.");
    }

    private void verStockCritico() {
        String reporte = inventario.generarReporteStockCritico();
        vista.mostrarEnConsola("Stock critico", reporte);
        vista.mostrarMensajeVentana("Stock critico mostrado en la consola.");
    }
}
