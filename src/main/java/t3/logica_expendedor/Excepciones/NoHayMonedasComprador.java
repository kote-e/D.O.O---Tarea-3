package t3.logica_expendedor.Excepciones;

/**
 * NoHayMonedasComprador es una subclase de Exception que ocurre
 * cuando esta vacio el deposito de monedas del Comprador
 * @author Antonio Benavides
 */
public class NoHayMonedasComprador extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public NoHayMonedasComprador (String message){
        super("No tienes moneda de " + message);
    }
}
