package t3.logica_expendedor;

/**
 * Clase abstracta que representa al producto
 */

public abstract class Producto {
    //DECLARACIONES DE ATRIBUTOS
    /** Variable que almacena el numero de serie del producto */
    protected int numSerie;
    //DECLARACIONES DE METODOS

    /**
     * Constructor qye asigna el número de serie al producto
     * @param x numero de serie del producto
     */
    public Producto(int x){numSerie = x;}

    /**
     *Funcion que retorna el número de serie del producto
     * @return número de serie del producto
     */
    public int getSerie(){return numSerie;}

    /**
     *Metodo abstracto de la función consumir que retornara el sonido/gesto de consumirse el producto
     * @return gesto/sonido de consumir
     */
    public abstract String consumir();
}
