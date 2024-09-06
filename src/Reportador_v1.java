class Reportador_v1 implements Reportador {
    @Override
    public String reportar(Factura factura) {
        StringBuilder sb = new StringBuilder();
        sb.append("Factura:\n");
        for (LineaFactura linea : factura.getLineas()) {
            sb.append("Producto: ").append(linea.getProducto().getNombre())
                    .append(", Precio Unitario: ").append(linea.getProducto().getPrecioUnitario())
                    .append(", Cantidad: ").append(linea.getCantidad())
                    .append(", Total: ").append(linea.getTotalProducto())
                    .append("\n");
        }
        sb.append("Total Factura: ").append(factura.getTotal());
        return sb.toString();
    }
}
