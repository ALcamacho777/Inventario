package main;

import javax.swing.SwingUtilities;
import controller.ControladorInventario;
import model.Inventario;
import view.VistaInventario;

public class AppInventariomvc {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Inventario modelo = new Inventario();
            VistaInventario vista = new VistaInventario();
            ControladorInventario controlador = new ControladorInventario(modelo, vista);
            controlador.iniciar();
        });
    }
}
