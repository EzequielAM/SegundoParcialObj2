class Producto {

    private String id;
    private String nombre;
    private double precioUnitario;
    private int cantidad;
    private boolean esDeLujo;  //determinamos que es un producto de lujo o no desde un principio

    public Producto(String id, String nombre, double precioUnitario, int cantidad, boolean esDeLujo) {
        this.id = id;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.esDeLujo = esDeLujo;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public boolean esDeLujo() {
        return esDeLujo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}