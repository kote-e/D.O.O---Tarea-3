package t3.logica_expendedor;

import t3.logica_expendedor.Bebidas.*;
import t3.logica_expendedor.Dulces.*;
import t3.logica_expendedor.Monedas.*;
import t3.logica_expendedor.Producto;
import t3.logica_expendedor.Excepciones.*;
import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;

public class Comprador{
    //DECLARACIONES DE ATRIBUTOS
    private String sonido;  //Guarda el sonido/gesto de consumir el producto comprado
    private int vuelto = 0; //Guarda el valor numeroco (int) del vuelto resibido al comprar el producto
    private Expendedor expendedor;
    Producto producto = null;

    // depositos para monedas del comprador
    private Deposito<Moneda> depositoMoneda100;
    private Deposito<Moneda> depositoMoneda500;
    private Deposito<Moneda> depositoMoneda1000;
    private Deposito<Moneda> depositoMoneda1500;

    // depositos para productos del comprador
    private Deposito<Producto> depositoCocacola;
    private Deposito<Producto> depositoSprite;
    private Deposito<Producto> depositoFanta;
    private Deposito<Producto> depositoSnickers;
    private Deposito<Producto> depositoSuper8;

    //DECLARACIONES DE METODOS

    //Constructor: recibe la moneda con la que comprara, un numero que identifica el tipo de producto y la referencia al Expendedor en el que comprara
    public Comprador(Expendedor exp) throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoException{

        expendedor = exp;

        // incializar depositos

        depositoMoneda100 = new Deposito<Moneda>();
        depositoMoneda500 = new Deposito<Moneda>();
        depositoMoneda1000 = new Deposito<Moneda>();
        depositoMoneda1500 = new Deposito<Moneda>();

        depositoCocacola = new Deposito<Producto>();
        depositoSprite = new Deposito<Producto>();
        depositoFanta = new Deposito<Producto>();
        depositoSuper8 = new Deposito<Producto>();
        depositoSnickers = new Deposito<Producto>();
    }

    public void getVuelto(){
        while (true) {
            Moneda vueltoexp = expendedor.getVuelto();                 //Se extrae una moneda del deposito de vuelto del expendedor

            if (vueltoexp == null) {
                break;
            }                      //Si no se extrajo ninguna moneda se sale del bucle, debido a esto vuelto queda en 0 debido a que no se modifico
            vuelto = vuelto + vueltoexp.getValor();             //Si se logro sacar una moneda, el valor de esa moneda se suma con el vuelto guardado en las iteraciones anteriores

            switch (vueltoexp.getValor()) {
                case 100:
                    depositoMoneda100.add(vueltoexp);
                    break;

                case 500:
                    depositoMoneda500.add(vueltoexp);
                    break;

                case 1000:
                    depositoMoneda1000.add(vueltoexp);
                    break;

                case 1500:
                    depositoMoneda1500.add(vueltoexp);
                    break;
            }
        }
    }

    public int cuantoVuelto() {return vuelto;}      //Funcion que retorna el vuelto como un valor "int"


    public void comprarProducto(Moneda moneda, Precios_Productos cualProducto){
        try{
            producto = expendedor.comprarProducto(moneda, cualProducto);    //Se compra el producto en el expendedor entregandole la moneda y el numero que identifica el tipo de producto

        } catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoException e){
            e.printStackTrace();
            //throw e; // Lanzar la expresion nuevamente para que sea manejada en main.
        }

        switch (cualProducto) {   //Switch que permite retirar un producto del deposito correspondiente
            case COCACOLA:
                depositoCocacola.add(producto);    //Se añade una CocaCola al deposito
                break;
            case SPRITE:
                depositoSprite.add(producto);    //Se añade una Sprite al deposito
                break;
            case FANTA:
                depositoFanta.add(producto);    //Se añade una Fanta al deposito
                break;
            case SNICKERS:
                depositoSnickers.add(producto);    //Se añade un Snickers al deposito
                break;
            case SUPER8:
                depositoSuper8.add(producto);    //Se añade un Super8 al deposito
                break;
            default:
                break;
        }
    }

    public void consumirProducto(Producto producto){
        if (producto == null) {     //Si no se logro conprar un producto:
            sonido = null;          //El sonido de consumir el producto queda como null

        } else {sonido = producto.consumir();}  //Si se logro consumir el producto se asigna el gesto/sonido de consumir el producto
    }

    public String queConsumiste() {return sonido;}  //Funcion que retorna el sonido de consumir el producto comprado en formato "String"


    public Moneda getMoneda(int val){

        Moneda m = null;
        switch(val) {
            case 100:
                m = depositoMoneda100.get();
                break;
            case 500:
                m = depositoMoneda500.get();
                break;
            case 1000:
                m = depositoMoneda1000.get();
                break;
            case 1500:
                m = depositoMoneda1500.get();
                break;
        }

        if(m == null){
            return null; // luego crear excepcion para manejar caso
        }

        return m;
    }

    public void setMoneda(Moneda moneda){

        if(moneda == null){
            return; // luego escribir codigo para manejar caso
        }

        switch(moneda.getValor()) {
            case 100:
                depositoMoneda100.add(moneda);
                break;
            case 500:
                depositoMoneda500.add(moneda);
                break;
            case 1000:
                depositoMoneda1000.add(moneda);
                break;
            case 1500:
                depositoMoneda1500.add(moneda);
                break;
        }
    }
}
