//instanciamos una exception para lanzar un mensaje sobre el producto

class ProductoNoEncontradoException extends Exception {
    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}