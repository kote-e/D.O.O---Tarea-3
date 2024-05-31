package t3.logica_expendedor.Bebidas;
/**
 * Es una subclase de Bebida que representa una Fanta
 * @author
 */
public class Fanta extends Bebida{
    /**
     *Constructor de la bebida Fanta
     * @param numSerie es el valor del numero de serie de este producto
     */
    public Fanta(int numSerie){super(numSerie);}
    /**
     * Funcion que retorna el gesto/sonido de deber
     * @return sonido
     */
    public String consumir(){return super.consumir() +"fanta";};
}
