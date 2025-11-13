package view;

import java.util.Optional;
import javax.swing.JOptionPane;

public class VistaInventario {

    public int mostrarMenuPrincipal() {
        String menu = """
                SISTEMA DE INVENTARIO - MVC

                1. Registrar entrada de productos
                2. Registrar venta de productos
                3. Ver inventario completo
                4. Ver stock critico (<= 5)
                5. Salir

                Ingresa una opcion:
                """;

        String input = JOptionPane.showInputDialog(null, menu, "Menu Inventario", JOptionPane.QUESTION_MESSAGE);

        if (input == null) {
            // Usuario cerró la ventana → tratamos como "Salir"
            return 5;
        }

        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            return -1; // opción inválida
        }
    }

    public Optional<String> pedirNombreProducto(String titulo) {
        String nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del producto:", titulo,
                JOptionPane.QUESTION_MESSAGE);

        if (nombre == null) {
            return Optional.empty(); // canceló
        }

        nombre = nombre.trim();
        if (nombre.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(nombre);
    }

    public Optional<Integer> pedirCantidad(String titulo) {
        String input = JOptionPane.showInputDialog(null, "Ingresa la cantidad:", titulo,
                JOptionPane.QUESTION_MESSAGE);

        if (input == null) {
            return Optional.empty();
        }

        try {
            int cantidad = Integer.parseInt(input.trim());
            return Optional.of(cantidad);
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public void mostrarMensajeVentana(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void mostrarEnConsola(String titulo, String contenido) {
        System.out.println("\n========== " + titulo + " ==========");
        System.out.println(contenido);
        System.out.println("=====================================\n");
    }
}
