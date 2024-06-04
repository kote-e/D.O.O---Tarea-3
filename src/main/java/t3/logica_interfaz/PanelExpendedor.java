package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

import t3.logica_expendedor.*;
import t3.logica_expendedor.Excepciones.ProductoNoSeleccionado;

/**
 * La subclase PanelExpendedor es una extensión de JPanel que representa la interfaz gráfica
 * de la máquina expendedora
 * @author Antonio Benavides
 */

public class PanelExpendedor extends JPanel implements GeneradorImagen{
    private Precios_Productos producto = null;
    private Precios_Productos pComprado = null;
    private final Expendedor expendedor;
    private final Comprador comprador;
    private final Letrero letrero;
    private PanelComprador panelComprador;
    private final BotonProducto botonProducto;
    private final BotonVuelto botonVuelto;
    private final PanelProductos panelProductos;

    /**
     * Estye es el constructor para inicializar el panel de la maquina expendedora
     * @param expendedor este es el panel de la maquina expendedora
     * @param comprador este es el usuario
     */

    public PanelExpendedor(Expendedor expendedor, Comprador comprador) {
        super();
        this.expendedor = expendedor;
        this.comprador = comprador;

        setBackground(new Color(0xf0f6ff));
        setBounds(400, 0, 850, 670);
        setLayout(null);

        panelProductos = new PanelProductos(this);
        this.add(panelProductos);

        //Agregar el Letrero
        this.letrero = new Letrero(this,432,105,165,100);
        this.add(letrero);

        //Se agregan los botones para seleccionar los productos
        this.add(new BotonSelectorP(this,Precios_Productos.COCACOLA,"1",438,328,47,42));
        this.add(new BotonSelectorP(this,Precios_Productos.SPRITE,"2",490,328,47,42));
        this.add(new BotonSelectorP(this,Precios_Productos.FANTA,"3",544,328,47,42));
        this.add(new BotonSelectorP(this,Precios_Productos.SNICKERS,"4",438,377,47,42));
        this.add(new BotonSelectorP(this,Precios_Productos.SUPER8,"5",490,377,47,42));

        //Se agrega el Boton para concretar la compra
        this.add(new BotonCompra(this,557,235,40,40));

        //Se agrega el Boton para Sacar las Monedas ingresadas sin comprar
        this.add(new BotonResetMoney(this,500,235,40,40));

        //Se agrega el boton para sacar el vuelto
        botonVuelto = new BotonVuelto(this,431,477,166,82);
        this.add(botonVuelto);

        //Se agrega el boton para sacar al producto
        botonProducto = new BotonProducto(this,panelComprador,93,477,306,82);
        this.add(botonProducto);

        //Se carga, redimenciona y agrega la imagen de fondo del Expendedor
        ImageIcon expendedorIcon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/expendedor.png",600,600);
        JLabel expendedorLabel = new JLabel(expendedorIcon);
        expendedorLabel.setBounds(0,0 , 670,670);

        this.add(expendedorLabel);
    }

    public void setProducto(Precios_Productos producto){this.producto = producto;}

    public Precios_Productos getProducto() throws ProductoNoSeleccionado{
        if(producto == null){throw new ProductoNoSeleccionado();}
        return this.producto;
    }

    /**
     * Obtiene el expendedor asociado
     * @return Retorna el Expendedor asociado
     */
    public Expendedor getExpendedor(){return this.expendedor;}

    /**
     * obtine al comprador
     * @return retorna al comprador
     */
    public Comprador getComprador(){return this.comprador;}

    /**
     * obtiene el letrero
     * @return el letrero asociado
     */
    public Letrero getLetrero(){return this.letrero;}

    /**
     * este establece el panel del Comprador
     * @param panelComprador este es el panel del comprador
     */
    public void setPanelComprador(PanelComprador panelComprador) {
        this.panelComprador = panelComprador;
        botonProducto.setPanelComprador(panelComprador);
        botonVuelto.setpComprador(panelComprador);
    }

    /**
     * Establese el producto comprado
     * @param producto Representa al ultimo tipo de producto que se compro
     */
    public void setComprado(Precios_Productos producto){this.pComprado = producto;}

    /**
     * Obtiene el producto comprado
     * @return el producto
     */
    public Precios_Productos getComprado(){return this.pComprado;}

    public BotonProducto getBotonProducto(){return botonProducto;}

    public PanelProductos getPanelProductos(){return panelProductos;}
}
