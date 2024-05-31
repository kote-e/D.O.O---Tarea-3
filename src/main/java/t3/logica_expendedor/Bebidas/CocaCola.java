package t3.logica_expendedor.Bebidas;

/**
 * Es una subclase de Bebida que representa una CocaCola
 * @author
 */

public class CocaCola extends Bebida{
    /**
     *Constructor de la bebida cocacola
     * @param numSerie es el valor del numero de serie de este producto
     */
    public CocaCola(int numSerie){super(numSerie);}

    /**
     * Funcion que retorna el gesto/sonido de deber
     * @return sonido
     */
    public String consumir(){return super.consumir() + "cocacola";};
}
