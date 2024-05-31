package t3.logica_expendedor.Excepciones;
/**
 * PagoInsuficienteException es una subclase de Exception que ocurre cuando el pago ingresado
 * no es suficiente para comprar el producto que se quiere adquirir
 * @author
 */

public class PagoInsuficienteException extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara en la terminal
     * por el canal de error
     * @param message mensaje que se mostrara
     */
    public PagoInsuficienteException (String message){
        super(message);
    }
}
