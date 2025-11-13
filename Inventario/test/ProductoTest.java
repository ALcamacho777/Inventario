import model.Producto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    void testCrearProducto() {
        Producto p = new Producto("Coca Cola", 10);
        assertEquals("Coca Cola", p.getNombre());
        assertEquals(10, p.getStock());
    }

    @Test
    void testAgregarStock() {
        Producto p = new Producto("Pan", 5);
        p.agregarStock(3);
        assertEquals(8, p.getStock());
    }

    @Test
    void testVenderStockSuficiente() {
        Producto p = new Producto("Leche", 10);
        boolean resultado = p.vender(4);

        assertTrue(resultado);
        assertEquals(6, p.getStock());
    }

    @Test
    void testVenderStockInsuficiente() {
        Producto p = new Producto("Leche", 2);
        boolean resultado = p.vender(5);

        assertFalse(resultado);
        assertEquals(2, p.getStock()); // Stock no baja porque no alcanza
    }
}
