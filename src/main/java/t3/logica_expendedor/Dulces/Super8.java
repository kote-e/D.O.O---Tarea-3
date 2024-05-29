package t3.logica_expendedor.Dulces;

/**
 *  Es una subclase de Dulce que representa un Super8
 * @author
 */
public class Super8 extends Dulce{
    //DECLARACIONES DE METODOS
    /**
     * Constructor que asigna el numero de serie al producto
     * @param x Número de serie del producto
     */
    public Super8(int x){super(x);}
    /**
     * Funcion que retorna el sonido de consumir el producto en formato "String"
     * @return String gesto de consumir el producto
     */
    public String consumir(){return super.consumir() + "super8";}
}
