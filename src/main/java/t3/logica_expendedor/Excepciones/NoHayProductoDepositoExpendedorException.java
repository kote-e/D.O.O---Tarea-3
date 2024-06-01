package t3.logica_expendedor.Excepciones;

/**
 * NoHayProductoDepositoExpendedorException es una subclase de Exception que ocurre
 * cuando esta vacio el deposito del producto que se quiere comprar
 * @author
 */
public class NoHayProductoDepositoExpendedorException extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public NoHayProductoDepositoExpendedorException(){
        super("No hay producto");
    }
}
