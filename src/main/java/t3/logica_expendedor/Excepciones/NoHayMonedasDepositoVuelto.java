package t3.logica_expendedor.Excepciones;

/**
 * NoHayMonedasDepositoVuelto es una subclase de Exception que ocurre
 * cuando esta vacio el deposito de monedas de Vuelto del Expendedor
 * @author Antonio Benavides
 */
public class NoHayMonedasDepositoVuelto extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public NoHayMonedasDepositoVuelto (){
        super("No quedan monedas en el Deposito del Vuelto");
    }
}
