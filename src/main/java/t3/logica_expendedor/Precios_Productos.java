package t3.logica_expendedor;

/**
 * Enumeración que representa los productos que se pueden comprar y sus precios respectivamente
 */
public enum Precios_Productos{
    /** Constante que contiene el precio de la CocaCola */
    COCACOLA(100),
    /** Constante que contiene el precio de la Sprite */
    SPRITE(200),
    /** Constante que contiene el precio de la Fanta */
    FANTA(300),
    /** Constante que contiene el precio del Snickers */
    SNICKERS(400),
    /** Constante que contiene el precio del Super8 */
    SUPER8(500);
/** Variable que guarda el valor numerico de la constante */
    private final int precio;

    /**
     * Constructor de la enumeración que asigna el valor numérico a la constante
     * @param valor el precio del producto
     */

    Precios_Productos(int valor) {this.precio = valor;}

    /**
     * Devuelve el precio del producto
     * @return valor del producto
     */

    public int getPrecio() {return precio;}
};