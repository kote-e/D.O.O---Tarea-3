package t3.logica_expendedor.Monedas;
import java.lang.Comparable;    //Importacion de la interfaz Comparable

/**
 * Clase abstracta que representa a una moneda
 * @author
 */

public abstract class Moneda implements Comparable<Moneda>{
    /**
     * Constructor de la clase vasio
     */
    public Moneda(){}

    /**
     *Funsion que retorna la referencia a si mismo
     * @return referencia
     */
    public int getSerie(){return this.hashCode();}

    /**
     * Función que retorna el valor de la moneda
     * @return valor de la moneda
     */
    public abstract int getValor();

    /**
     * Función que compara dos monedas
     * @param m Moneda
     * @return Diferencia entre el valor de las 2 monedas
     */
    public int compareTo(Moneda m){     //Funcion que compara dos monedas
        return this.getValor()-m.getValor();    //Retorna la diferencia entre los valores de las monedas, si es positivo la moneda actual es mayor, si es negativo la moneda actual es menor, si es 0 son iguales
    }
}
