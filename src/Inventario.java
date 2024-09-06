import java.util.HashMap;
import java.util.Map;

class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    public void anadirProducto(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    public void eliminarProducto(String id) throws ProductoNoEncontradoException {
        if (!productos.containsKey(id)) {
            throw new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado.");
        }
        productos.remove(id);
    }

    public Producto obtenerProducto(String id) throws ProductoNoEncontradoException {
        if (!productos.containsKey(id)) {
            throw new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado.");
        }
        return productos.get(id);
    }

    public void actualizarCantidadProducto(String id, int cantidad) throws ProductoNoEncontradoException {
        Producto producto = obtenerProducto(id);
        producto.setCantidad(cantidad);
    }
}