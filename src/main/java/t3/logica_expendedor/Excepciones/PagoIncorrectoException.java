package t3.logica_expendedor.Excepciones;
/**
 * PagoIncorrectoException es una subclase de Exception que ocurre
 * cuando no se ha ingresado ninguna moneda para realizar el pago
 * @author
 */
public class PagoIncorrectoException extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public PagoIncorrectoException (){
        super("No se ingreso moneda");
    }
}
