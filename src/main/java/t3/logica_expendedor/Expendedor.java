package t3.logica_expendedor;

import t3.logica_expendedor.Bebidas.*;
import t3.logica_expendedor.Dulces.*;
import t3.logica_expendedor.Monedas.*;
import t3.logica_expendedor.Excepciones.*;
import t3.logica_interfaz.Sonidos;

import javax.sound.sampled.Clip;

/**
 * Clase que representa a un expendedor de Bebidas y Dulces
 */
public class Expendedor implements Sonidos {
    private Deposito<Moneda> monEn;     //Deposito que guarda las monedas que entran
    private int valorIngresado = 0;         //Guarda el valor total ingresado de las monedas
    private Deposito<Moneda> monVu;     //Deposito que guarda las monedas del vuelto
    private Deposito<Producto> coca;      //Deposito que guarda las bebidas CocaCola
    private Deposito<Producto> sprite;    //Deposito que guarda las bebidas Sprite
    private Deposito<Producto> fanta;     //Deposito que guarda las bebidas Fanta
    private Deposito<Producto> snickers;   //Deposito que guarda los dulces Snickers
    private Deposito<Producto> super8;     //Deposito que guarda los dulces Super8
    private Producto depositoSalida;
    private final Clip caerLata;
    private final Clip caerDulce;
    private final Clip caerMonedas;

    /**
     * Constructor: Recibe la cantidad de bebidas con la que se llenaran los depósitos
     *
     * @param numBebidas Cantidad de bebidas con las que se llamaran los depósitos
     */
    public Expendedor(int numBebidas) {
        monEn = new Deposito<>();     //Instanciacion del Deposito de Monedas
        monVu = new Deposito<>();     //Instanciacion del Deposito de Monedas
        coca = new Deposito<>();      //Instanciacion del Deposito de CocaColas
        sprite = new Deposito<>();    //Instanciacion del Deposito de Sprite
        fanta = new Deposito<>();     //Instanciacion del Deposito de Fanta
        snickers = new Deposito<>();   //Instanciacion del Deposito de Snickers
        super8 = new Deposito<>();     //Instanciacion del Deposito de Super8

        for (int i = 0; i < numBebidas; i++) {      //For en que se rellenan los depositos con sus respectivasd monedas
            Bebida bc = new CocaCola(i);            //Se crea una CocaCola con su numero de serie
            coca.add(bc);                     //Se ingresa la bebida recien creada al deposito de CocaCola
            Bebida bs = new Sprite(numBebidas + i);   //Se crea una Sprite con su numero de serie
            sprite.add(bs);                   //Se ingresa la bebida recien creada al deposito de Sprite
            Bebida bf = new Fanta(2 * numBebidas + i);   //Se crea una Fanta con su numero de serie
            fanta.add(bf);                   //Se ingresa la bebida recien creada al deposito de Fanta
            Dulce ds = new Snickers(3 * numBebidas + i);            //Se crea un Snickers con su numero de serie
            snickers.add(ds);                 //Se ingresa el dulce recien creado al deposito de Snickers
            Dulce d8 = new Super8(4 * numBebidas + i);   //Se crea un Super8 con su numero de serie
            super8.add(d8);                   //Se ingresa el dulce recien creado al deposito de Super8
        }

        caerLata = Sonidos.cargarSonido("src/main/java/t3/logica_interfaz/Sonidos/Caer_Lata.wav");
        caerDulce = Sonidos.cargarSonido("src/main/java/t3/logica_interfaz/Sonidos/Caer_Envoltorio.wav");
        caerMonedas = Sonidos.cargarSonido("src/main/java/t3/logica_interfaz/Sonidos/Caer_Monedas.wav");
    }

    /**
     * Permite comprar productos del expendedor ingresando una moneda y el tipo de producto a comprar.
     *
     * @param cualProducto tipo del producto
     * @throws PagoIncorrectoException   si no se ingres monedas
     * @throws PagoInsuficienteException si el dinero ingresado es menor al precio del producto
     * @throws NoHayProductoDepositoExpendedorException    si no hay producto disponible
     * @throws ProductoNoSeleccionado    si no se ha seleccionado ningun producto para comprar
     */
    public void comprarProducto(Precios_Productos cualProducto) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoDepositoExpendedorException, ProductoNoSeleccionado {   //Funcion que permite comprar productos del expendedor ingresando una moneda y el numero que indica el producto a comprar
        Producto producto = null; //Se crea un puntero auxiliar de tipo Bebida nulo

        // Si no se escogio producto
        if(cualProducto == null){throw new ProductoNoSeleccionado();}

        //Si no se ingreso una moneda se sale de la funcion
        if (monEn.size() == 0) {throw new PagoIncorrectoException();}

        if (valorIngresado < cualProducto.getPrecio()) {                         //Si se logro sacar una bebida pero el valor de la moneda no alcansa para comprar:
            sacarMonedasEntradaASalida();
            //Se elimina al producto que se saco del deposito del puntero que la referenciaba
            throw new PagoInsuficienteException();
        }

        producto = switch (cualProducto) {   //Switch que permite retirar un producto del deposito correspondiente
            case COCACOLA -> coca.get();
            case SPRITE -> sprite.get();
            case FANTA -> fanta.get();
            case SNICKERS -> snickers.get();
            case SUPER8 -> super8.get();
        };

        if (producto == null) {
            sacarMonedasEntradaASalida();
            throw new NoHayProductoDepositoExpendedorException();
        }

        if (valorIngresado > cualProducto.getPrecio()) {                //Si el valor de la moneda ingresada es mayor al precio del producto comprado
            int mon100 = (valorIngresado - cualProducto.getPrecio()) / 100;    //Se calcula la diferencia entre el presio y el valor del producto, dividiendolo por 100 para el siguiente for
            for (int i = 0; i < mon100; i++) {                  //For en que se agregan monedas al deposito del vuelto con el valor del vuelto calculado anteriormente
                Moneda100 vueltomon100 = new Moneda100();          //Se instancia una moneda de 100
                monVu.add(vueltomon100);                        //Se agrega la moneda al deposito del vuelto
            }
            for (int i = 0; i < monEn.size(); i++) {
                monEn.get();
            } //Elimino todas las monedas del deposito de entrada
            valorIngresado = 0;
        }

        depositoSalida = producto;   //Se retorna el producto que se compro o null en otros casos

        if(cualProducto == Precios_Productos.COCACOLA || cualProducto == Precios_Productos.SPRITE || cualProducto == Precios_Productos.FANTA){
            Sonidos.reproducirSonido(caerLata, () -> {;});
        }
        else{Sonidos.reproducirSonido(caerDulce,() -> {});}
    }

    /**
     *Devuelve una moneda del depósito
     * @return Moneda del depósito
     */
    public Moneda getVuelto() throws NoHayMonedasDepositoVuelto{
        if(monVu.size() == 0){
            throw new NoHayMonedasDepositoVuelto();
        }
        return monVu.get();
    }

    /**
     * Funcion que retorna el precio de los productos
     * @param producto tipo de producto
     * @return precio del producto
     */

    public int getPrecio(Precios_Productos producto){
        switch (producto) {
            case COCACOLA:
                return Precios_Productos.COCACOLA.getPrecio();
            case SPRITE:
                return Precios_Productos.SPRITE.getPrecio();
            case FANTA:
                return Precios_Productos.FANTA.getPrecio();
            case SNICKERS:
                return Precios_Productos.SNICKERS.getPrecio();
            case SUPER8:
                return Precios_Productos.SUPER8.getPrecio();
            default:
                return 0;
        }
    }

    /**
     * Agrega la moneda al deposito
     * @param moneda la moneda que se agrega
     */
    public void addMonedaEntrada(Moneda moneda){
        monEn.add(moneda);
        this.valorIngresado += moneda.getValor();
    }

    /**
     * Devuelve todo el valor ingresado
     * @return valor ingresado
     */
    public int valorTotalIngresado(){return valorIngresado;}

    /**
     * Saca todas las monedas del depósito de entrada al depósito de vuelto
     */

    public void sacarMonedasEntradaASalida(){
        if(monEn.size() != 0){Sonidos.reproducirSonido(caerMonedas,() -> {;});}
        for(int i = 0; i < monEn.size(); i++){monVu.add(monEn.get());}   //Se agrega la moneda al deposito del vuelto
        valorIngresado = 0;
    }

    /**
     * Devuelve el producto obtenido del expendedor
     * @return producto obtenido
     */

    public Producto getProducto() throws NoHayProductoDepositoSalida{
        Producto producto = null;
        if (depositoSalida == null) {
            throw new NoHayProductoDepositoSalida();
        }

        producto = depositoSalida;
        depositoSalida = null;



        return producto;
    }

    public int CantidadMonedasVuelto(int valor){
        int contador = 0;
        for(int i = 0; i < monVu.size(); i++){
            if(((Moneda)monVu.getInstance(i)).getValor() == valor){contador++;}
        }
        return contador;
    }

    public int CantidadProductoDentro(Precios_Productos tipoProducto){
        return switch (tipoProducto){
            case COCACOLA -> coca.size();
            case SPRITE -> sprite.size();
            case FANTA -> fanta.size();
            case SNICKERS -> snickers.size();
            case SUPER8 -> super8.size();
        };
    }
}