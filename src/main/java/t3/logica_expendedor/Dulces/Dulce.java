package t3.logica_expendedor.Dulces;
import t3.logica_expendedor.Producto;

/**
 * Clase abstracta que representa a cualquier dulce
 * @author
 */
public abstract class Dulce extends Producto{
    //DECLARACIONES DE METODOS
    /**
     * Constructor que asigna el numero de serie al producto
     * @param x número de serie del producto
     */
    public Dulce(int x){super(x);}

    /**
     * Funcion que retorna el sonido de consumir el producto en formato "String"
     * @return String gesto de consumir el producto
     */
    public String consumir(){return "Se come el ";}
}
