package t3.logica_expendedor.Bebidas;
/**
 * Es una subclase de Bebida que representa una Sprite
 * @author
 */
public class Sprite extends Bebida{
    /**
     *Constructor de la bebida Sprite
     * @param numSerie es el valor del numero de serie de este producto
     */
    public Sprite(int numSerie){super(numSerie);}

    /**
     * Funcion que retorna el gesto/sonido de deber
     * @return sonido
     */
    public String consumir(){return super.consumir() + "sprite";};
}