class LineaFactura {
    private Producto producto;
    private int cantidad;
    private double totalProducto;

    public LineaFactura(Producto producto, int cantidad, double totalProducto) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.totalProducto = totalProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getTotalProducto() {
        return totalProducto;
    }
}