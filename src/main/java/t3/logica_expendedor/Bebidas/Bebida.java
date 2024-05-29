package t3.logica_expendedor.Bebidas;
import t3.logica_expendedor.Producto;

/**
 * Producto de tipo bebida
 * @author Valeria Quiroga
 */
public abstract class Bebida extends Producto{
    //DECLARACIONES DE METODOS
    /**
     * Constructor asigna el núemro de serie a la bebida
     * @param x este parametro es el numero de serie de cada bebida
     */
    public Bebida(int x){super(x);}

    /**
     * Función que retorna el sonido de beber una bebida
     * @return sonido
     */
    public String consumir(){return "Se bebe la ";};
}
