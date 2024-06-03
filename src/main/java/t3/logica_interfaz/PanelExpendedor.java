package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

import t3.logica_expendedor.*;
import t3.logica_expendedor.Excepciones.ProductoNoSeleccionado;

public class PanelExpendedor extends JPanel implements GeneradorImagen{
    private Precios_Productos producto = null;
    private Precios_Productos pComprado = null;
    private final Expendedor expendedor;
    private final Comprador comprador;
    private final Letrero letrero;
    private PanelComprador panelComprador;
    private final BotonProducto botonProducto;
    private final BotonVuelto botonVuelto;

    public PanelExpendedor(Expendedor expendedor, Comprador comprador) {
        super();
        this.expendedor = expendedor;
        this.comprador = comprador;

        setBackground(new Color(0xf0f6ff));
        setBounds(400, 0, 850, 670);
        setLayout(null);

        //Se agregan los productos
        add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/CocaCola.png",65,100,150,150));
        add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/sprite.png",170,100,150,150));
        add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/fanta.png",270,100,150,150));
        add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/snickers.png",55,270,160,160));
        add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/super8.png",153,275,160,160));

        //Se agregan los precios
        add(mostrarPrecios(Precios_Productos.COCACOLA,120,250,30,20));
        add(mostrarPrecios(Precios_Productos.SPRITE,230,250,30,20));
        add(mostrarPrecios(Precios_Productos.FANTA,330,250,30,20));
        add(mostrarPrecios(Precios_Productos.SNICKERS,120,425,30,20));
        add(mostrarPrecios(Precios_Productos.SUPER8,225,425,30,20));

        //Agregar el Letrero
        this.letrero = new Letrero(this,432,105,165,100);
        add(letrero);

        //Se agregan los botones para seleccionar los productos
        add(new BotonSelectorP(this,Precios_Productos.COCACOLA,"1",438,328,47,42));
        add(new BotonSelectorP(this,Precios_Productos.SPRITE,"2",490,328,47,42));
        add(new BotonSelectorP(this,Precios_Productos.FANTA,"3",544,328,47,42));
        add(new BotonSelectorP(this,Precios_Productos.SNICKERS,"4",438,377,47,42));
        add(new BotonSelectorP(this,Precios_Productos.SUPER8,"5",490,377,47,42));

        //Se agrega el Boton para concretar la compra
        add(new BotonCompra(this,557,235,40,40));

        //Se agrega el Boton para Sacar las Monedas ingresadas sin comprar
        add(new BotonResetMoney(this,500,235,40,40));

        //Se agrega el boton para sacar el vuelto
        botonVuelto = new BotonVuelto(this,431,477,166,82);
        add(botonVuelto);

        //Se agrega el boton para sacar al producto
        botonProducto = new BotonProducto(this,panelComprador,93,477,306,82);
        add(botonProducto);

        //Se carga, redimenciona y agrega la imagen de fondo del Expendedor
        ImageIcon expendedorIcon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/expendedor.png",600,600);
        JLabel expendedorLabel = new JLabel(expendedorIcon);
        expendedorLabel.setBounds(0,0 , 670,670);

        add(expendedorLabel);
    }

    private JLabel mostrarPrecios(Precios_Productos nombre, int x, int y, int width, int height){
        JLabel precio = new JLabel("$" + nombre.getPrecio());
        precio.setForeground(new Color(0x000000));
        precio.setBounds(x,y,width,height);

        return precio;
    }

    public void setProducto(Precios_Productos producto){this.producto = producto;}

    public Precios_Productos getProducto() throws ProductoNoSeleccionado{
        if(producto == null){throw new ProductoNoSeleccionado();}
        return this.producto;
    }

    public Expendedor getExpendedor(){return this.expendedor;}

    public Comprador getComprador(){return this.comprador;}

    public Letrero getLetrero(){return this.letrero;}

    public void setPanelComprador(PanelComprador panelComprador) {
        this.panelComprador = panelComprador;
        botonProducto.setPanelComprador(panelComprador);
        botonVuelto.setpComprador(panelComprador);
    }

    public void setComprado(Precios_Productos producto){this.pComprado = producto;}

    public Precios_Productos getComprado(){return this.pComprado;}

    public BotonProducto getBotonProducto(){return botonProducto;}
}
