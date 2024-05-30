package t3.logica_expendedor;

import java.util.ArrayList;

/**
 * Clase que representa a un Deposito de Productos o Monedas
 * @param <T>   //Tipo de Productos o Monedas que almacena
 */
public class Deposito<T>{
    ArrayList<T> list; //Definicion de la lista que guardara a las productos

    /**
     * Instanciacion de la lista que guardara a las productos
     */
    public Deposito() {list = new ArrayList<T>();}

    /**
     * Agregar un Producto o Moneda
     * @param x Producto o Moneda a ingresar
     */
    public void add(T x) {list.add(x);}

    /**
     * Funcion para retirar Productos o monedas de la lista
     * @return Producto o Moneda a retirar
     */
    public T get(){
        if (list.size() != 0) {return list.remove(0);}  //Si la lista no esta vacia se retorna al primera producto de la lista eliminadolo a la ves de esta lista
        else return null;       //Si la lista esta vacia se retorna null
    }

    /**
     * Funcion que devuelve la cantidad de Productos o Monedas que contiene
     * @return Cantidas de productos o Monedas que posee
     */
    public int size(){return list.size();}
}
