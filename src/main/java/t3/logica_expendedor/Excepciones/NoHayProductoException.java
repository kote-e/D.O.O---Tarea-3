package t3.logica_expendedor.Excepciones;
/**
 * NoHayProductoException es una subclase de Exception que ocurre
 * cuando esta vacio el deposito del producto que se quiere comprar
 * @author
 */
public class NoHayProductoException extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara en la terminal
     * por el canal de error
     * @param message mensaje que se mostrara
     */
    public NoHayProductoException (String message){
        super(message);
    }
}
