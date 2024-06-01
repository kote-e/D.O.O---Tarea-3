package t3.logica_expendedor;

import t3.logica_expendedor.Bebidas.CocaCola;
import t3.logica_expendedor.Bebidas.Fanta;
import t3.logica_expendedor.Bebidas.Sprite;
import t3.logica_expendedor.Dulces.Snickers;
import t3.logica_expendedor.Dulces.Super8;
import t3.logica_expendedor.Monedas.*;
import t3.logica_expendedor.Excepciones.*;
import javax.swing.*;

/**
 * clase que representa al comprador
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public class Comprador{
    //DECLARACIONES DE ATRIBUTOS
    private final Expendedor expendedor;

    private Deposito<Moneda100> moneda100; //Deposito en donde se guardaran las monedas en posecion del Comprador
    private Deposito<Moneda500> moneda500; //Deposito en donde se guardaran las monedas en posecion del Comprador
    private Deposito<Moneda1000> moneda1000; //Deposito en donde se guardaran las monedas en posecion del Comprador
    private Deposito<Moneda1500> moneda1500; //Deposito en donde se guardaran las monedas en posecion del Comprador

    private Deposito<CocaCola> cocaColaDeposito;
    private Deposito<Sprite> spriteDeposito;
    private Deposito<Fanta> fantaDeposito;
    private Deposito<Snickers> snickersDeposito;
    private Deposito<Super8> super8Deposito;

    //DECLARACIONES DE METODOS
    /**
     *Constructor que recibe la referencia
     * la moneda con la que comprara, un numero que identifica el tipo de producto y
     * la referencia al Expendedor en el que comprara
     * @param expendedor referencia a Expendedor
     */

    public Comprador(Expendedor expendedor) {
        this.expendedor = expendedor;

        moneda100 = new Deposito<Moneda100>();
        moneda500 = new Deposito<Moneda500>();
        moneda1000 = new Deposito<Moneda1000>();
        moneda1500 = new Deposito<Moneda1500>();

        cocaColaDeposito = new Deposito<CocaCola>();
        spriteDeposito = new Deposito<Sprite>();
        fantaDeposito = new Deposito<Fanta>();
        snickersDeposito = new Deposito<Snickers>();
        super8Deposito = new Deposito<Super8>();

    }

    /**
     * Metodo para comprar un producto (Se compra el producto en el expendedor
     * entregandole la moneda y el numero que identifica el tipo de producto)
     * @param cualProducto El producto que se desea comprar
     * @throws PagoInsuficienteException si el pago es insuficiente
     * @throws PagoIncorrectoException si el pago es incorrecto
     * @throws NoHayProductoDepositoExpendedorException si no hay el producto que se eligio
     */

    public void comprar(Precios_Productos cualProducto)throws PagoInsuficienteException, PagoIncorrectoException, NoHayProductoDepositoExpendedorException, ProductoNoSeleccionado{
        try{expendedor.comprarProducto(cualProducto);}
        catch (PagoInsuficienteException | PagoIncorrectoException | NoHayProductoDepositoExpendedorException | ProductoNoSeleccionado e){
            throw e; // Lanzar la expresion nuevamente para que sea manejada en main.
        }
    }

    /**
     * Metodo para añadrir monedas al depósito
     * @param moneda la moneda ingresada
     */
    public void addMonedas(Moneda moneda){
        if(moneda instanceof Moneda100){
            moneda100.add((Moneda100) moneda);
        }
        if(moneda instanceof Moneda500){
            moneda500.add((Moneda500) moneda);
        }
        if(moneda instanceof Moneda1000){
            moneda1000.add((Moneda1000) moneda);
        }
        if(moneda instanceof Moneda1500){
            moneda1500.add((Moneda1500) moneda);
        }
    }

    public Moneda getMoneda(int valor){
        return switch (valor) {
            case 100 -> moneda100.get();
            case 500 -> moneda500.get();
            case 1000 -> moneda1000.get();
            case 1500 -> moneda1500.get();
            default -> null;
        };
    }

    public int cantidadMonedas(int valor){
        return switch (valor){
            case 100 -> moneda100.size();
            case 500 -> moneda500.size();
            case 1000 -> moneda1000.size();
            case 1500 -> moneda1500.size();
            default -> -1;  //Valor de ERROR
        };
    }

    public Expendedor getExpendedor() {return expendedor;}

    /**
     * Añade del producto  qie puede ser una bebida o dulce al depósito del comprador
     * @param producto producto que se añade
     */

    public void addProducto(Producto producto){
        if(producto instanceof CocaCola){
            cocaColaDeposito.add((CocaCola) producto);
        }
        if(producto instanceof Sprite){
            spriteDeposito.add((Sprite) producto);
        }
        if(producto instanceof Fanta){
            fantaDeposito.add((Fanta) producto);
        }
        if(producto instanceof Snickers){
            snickersDeposito.add((Snickers) producto);
        }
        if(producto instanceof Super8){
            super8Deposito.add((Super8) producto);
        }
    }

    /**
     * Obtiene la cantidad de un producto en específico en el depósito
     * @param producto el tipo de producto
     * @return la cantidad de producto en el depósito
     */
    public int cantidadProducto(Precios_Productos producto){        //REVISAR//
        return switch (producto) {
            case COCACOLA -> cocaColaDeposito.size();
            case SPRITE -> spriteDeposito.size();
            case FANTA -> fantaDeposito.size();
            case SNICKERS -> snickersDeposito.size();
            case SUPER8 -> super8Deposito.size();
        };
    }

    public void consumirProducto(Precios_Productos tipo_producto){
        Producto producto = null;
        switch (tipo_producto) {
            case COCACOLA -> producto  = cocaColaDeposito.get();
            case SPRITE -> producto = spriteDeposito.get();
            case FANTA -> producto = fantaDeposito.get();
            case SNICKERS -> producto = snickersDeposito.get();
            case SUPER8 -> producto = super8Deposito.get();
        }
        if(producto != null){
            JOptionPane.showMessageDialog(null,producto.consumir());
        }
        else{System.out.println("No existe producto para consumir");}
    }
}
