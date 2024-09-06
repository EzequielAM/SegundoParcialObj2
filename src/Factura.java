import java.util.ArrayList;
import java.util.List;

class Factura {
    private List<LineaFactura> lineas;
    private double total;

    public Factura() {
        lineas = new ArrayList<>();
        total = 0;
    }
// al agregar el producto y cantidad podemos calcular su impuesto en un mismo metodo

    public void añadirLinea(Producto producto, int cantidad) {
        double totalProducto = producto.getPrecioUnitario() * cantidad;
        double impuesto = 0.21 * totalProducto;
        if (producto.esDeLujo()) {
            impuesto += 0.15 * totalProducto;
        }
        totalProducto += impuesto;
        total += totalProducto;
        lineas.add(new LineaFactura(producto, cantidad, totalProducto));
    }

    public List<LineaFactura> getLineas() {
        return lineas;
    }

    public double getTotal() {
        return total;
    }
}