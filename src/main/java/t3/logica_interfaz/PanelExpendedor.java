package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    private PanelComprador panelComprador;
    private final Expendedor expendedor;
    private final Comprador comprador;
    private final Letrero letrero;
    private final BotonProducto botonProducto;
    private final BotonVuelto botonVuelto;
    private final PanelProductos panelProductos;

    /**
     * Constructor para inicializar el panel de la máquina expendedora
     * @param expendedor este es el panel de la máquina expendedora
     * @param comprador este es el usuario (comprador)
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


        // boton para agregar productos al expendedor

        JButton btnAgregarProductos = new JButton(new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/reload.png"));
        btnAgregarProductos.setBounds(544,377,47,42);
        btnAgregarProductos.setBackground(new Color(0xF6AD8D));
        btnAgregarProductos.setToolTipText("Agregar productos a expendedor");

        PanelExpendedor panelExpendedor = this;
        btnAgregarProductos.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                int cantidad = 0;

                while(cantidad <= 0 || cantidad > 100) {

                    String input = JOptionPane.showInputDialog("¿Cuantos productos agregar?");

                    if (input == null) { // El usuario ha cancelado la entrada
                        System.out.println("Entrada cancelada por el usuario.");
                        return;
                    }

                    while (!input.matches("\\d+")){
                        input = JOptionPane.showInputDialog("Ingresar un número entre 1 y 100");

                        if (input == null) { // El usuario ha cancelado la entrada
                            System.out.println("Entrada cancelada por el usuario.");
                            return;
                        }
                    }

                    cantidad = Integer.parseInt(input);
                }
                expendedor.agregarProductos(cantidad);
                panelExpendedor.getPanelProductos().imprimirProductos();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {btnAgregarProductos.setBackground(new Color(0xF6CC8D));}
            @Override
            public void mouseExited(MouseEvent e) {btnAgregarProductos.setBackground(new Color(0xF6AD8D));}
        });

        this.add(btnAgregarProductos);


        //Se agrega el botón para concretar la compra
        this.add(new BotonCompra(this,557,235,40,40));

        //Se agrega el botón para Sacar las monedas ingresadas sin comprar
        this.add(new BotonResetMoney(this,500,235,40,40));

        //Se agrega el botón para sacar el vuelto
        botonVuelto = new BotonVuelto(this,431,477,166,82);
        this.add(botonVuelto);

        //Se agrega el botón para sacar al producto
        botonProducto = new BotonProducto(this,panelComprador,93,477,306,82);
        this.add(botonProducto);

        //Se carga, redimenciona y agrega la imagen de fondo del Expendedor
        ImageIcon expendedorIcon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/expendedor.png",600,600);
        JLabel expendedorLabel = new JLabel(expendedorIcon);
        expendedorLabel.setBounds(0,0 , 670,670);

        this.add(expendedorLabel);
    }

    /**
     * Establece el producto selecionado
     * @param producto el producto
     */
    public void setProducto(Precios_Productos producto){this.producto = producto;}

    /**
     * Se obtiene el producto seleccionado
     * @return el producto
     * @throws ProductoNoSeleccionado si es que no se ha seleccionado ningún producto
     */
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
     * Establece el producto comprado
     * @param producto Representa al último tipo de producto que se compró
     */
    public void setComprado(Precios_Productos producto){this.pComprado = producto;}

    /**
     * Obtiene el producto comprado
     * @return el producto
     */
    public Precios_Productos getComprado(){return this.pComprado;}

    /**
     * Obtiene el botón del producto
     * @return el botón
     */
    public BotonProducto getBotonProducto(){return botonProducto;}

    /**
     *Se obtiene el panel de productos
     * @return el panel
     */
    public PanelProductos getPanelProductos(){return panelProductos;}
}
