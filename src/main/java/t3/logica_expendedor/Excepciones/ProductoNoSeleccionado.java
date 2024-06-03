package t3.logica_expendedor.Excepciones;

/**
 *  ProductoNoSeleccionado es una subclase de Exception que ocurre
 *  cuando no se ha seleccionado ningun producto para comprar
 * @author Antonio Benavides
 */
public class ProductoNoSeleccionado  extends Exception{
    /**
     * Se le asigna un mensaje a la excepción que luego se mostrara
     */
    public ProductoNoSeleccionado(){super("No ha seleccionado ningún producto para comprar");}
}
