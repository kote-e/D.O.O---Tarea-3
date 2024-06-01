package t3.logica_expendedor.Excepciones;

/**
 * NoHayProductoDepositoSalida es una subclase de Exception que ocurre
 * cuando esta vacio el deposito de salida del producto del Expendedor
 * @author
 */
public class NoHayProductoDepositoSalida extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public NoHayProductoDepositoSalida(){super("No hay ningun producto para sacar");}
}
