import model.Inventario;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventarioTest {

    @Test
    void testRegistrarEntradaProductoNuevo() {
        Inventario inv = new Inventario();
        String msg = inv.registrarEntrada("Manzana", 10);

        assertTrue(msg.contains("Producto nuevo agregado"));
        assertTrue(inv.generarReporteInventario().contains("Manzana"));
    }

    @Test
    void testRegistrarEntradaProductoExistente() {
        Inventario inv = new Inventario();
        inv.registrarEntrada("Pan", 5);
        String msg = inv.registrarEntrada("Pan", 3);

        assertTrue(msg.contains("Entrada registrada"));
        assertTrue(inv.generarReporteInventario().contains("8"));
    }

    @Test
    void testRegistrarVentaCorrecta() {
        Inventario inv = new Inventario();
        inv.registrarEntrada("Leche", 10);

        String msg = inv.registrarVenta("Leche", 4);

        assertTrue(msg.contains("Venta registrada"));
    }

    @Test
    void testRegistrarVentaStockInsuficiente() {
        Inventario inv = new Inventario();
        inv.registrarEntrada("Queso", 2);

        String msg = inv.registrarVenta("Queso", 5);

        assertTrue(msg.contains("No hay stock suficiente"));
    }

    @Test
    void testStockCritico() {
        Inventario inv = new Inventario();
        inv.registrarEntrada("Arroz", 3);

        String reporte = inv.generarReporteStockCritico();

        assertTrue(reporte.contains("Arroz"));
    }
}
