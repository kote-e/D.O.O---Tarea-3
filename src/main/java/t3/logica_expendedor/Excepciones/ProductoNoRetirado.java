package t3.logica_expendedor.Excepciones;

/**
 * ProductoNoRetirado es una subclase de Exception que ocurre cuando el pago ingresado
 * no es suficiente para comprar el producto que se quiere adquirir
 * @author Antonio Benavides
 */

public class ProductoNoRetirado extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public ProductoNoRetirado (){
        super("Antes de comprar, retire el producto de la salida");
    }
}
