import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MercadoMayoristaTests {

    private Inventario inventario;

    @BeforeEach
    void setUp() {
        inventario = new Inventario();
        inventario.anadirProducto(new Producto("001", "Yerba", 0.5, 100, false));
        inventario.anadirProducto(new Producto("002", "Fernet", 10, 50, true));
        inventario.anadirProducto(new Producto("003", "Paco(perfume)", 50, 20, true));
    }

    @Test
    void queSePuedePedirImpuestoSobreProducto() throws ProductoNoEncontradoException {
        Producto producto = inventario.obtenerProducto("001");
        double precioConImpuesto = producto.getPrecioUnitario() * 1.21;
        assertEquals(0.5 * 1.21, precioConImpuesto);
    }

    @Test
    void queSePuedePedirImpuestoSobreProductoDeLujo() throws ProductoNoEncontradoException {
        Producto producto = inventario.obtenerProducto("002");
        double precioConImpuesto = producto.getPrecioUnitario() * 1.21 * 1.15;
        assertEquals(10 * 1.21 * 1.15, precioConImpuesto);
    }

    @Test
    void queSePuedeCalcularElTotalPorDetalle() {
        Producto producto = new Producto("004", "Avon", 2, 10, false);
        Factura factura = new Factura();
        factura.añadirLinea(producto, 5);
        double totalEsperado = 2 * 5 * 1.21;
        assertEquals(totalEsperado, factura.getLineas().get(0).getTotalProducto());
    }

    @Test
    void queSePuedaCalcularElTotalDeFactura() {
        Factura factura = new Factura();
        factura.añadirLinea(new Producto("001", "Pochoclos", 0.5, 100, false), 10);
        factura.añadirLinea(new Producto("002", "Malbec", 10, 50, true), 5);
        assertEquals(74.05, factura.getTotal());
    }

    @Test
    void quePuedaEliminarUnProductoDelInventario() throws ProductoNoEncontradoException {
        inventario.eliminarProducto("001");
        assertThrows(ProductoNoEncontradoException.class, () -> inventario.obtenerProducto("001"));
    }

    @Test
    void queSePuedaActualizarLaCantidadDeUnProductoEnElInventario() throws ProductoNoEncontradoException {
        inventario.actualizarCantidadProducto("001", 150);
        Producto producto = inventario.obtenerProducto("001");
        assertEquals(150, producto.getCantidad());
    }

    @Test
    void queSeLanceUnaExcepcionCuandoSeIntenteAccederAUnProductoInexistenteEnElInventario() {
        assertThrows(ProductoNoEncontradoException.class, () -> inventario.obtenerProducto("999"));
    }
}
