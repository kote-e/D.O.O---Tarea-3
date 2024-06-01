package t3.logica_expendedor.Excepciones;

/**
 * NoHayProductoComprador es una subclase de Exception que ocurre
 * cuando el Comprador no posee del producto que desea Consumir
 * @author Antonio Benavides
 */
public class NoHayProductoComprador extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public NoHayProductoComprador (String str){
        super("No tienes " + str);
    }
}
