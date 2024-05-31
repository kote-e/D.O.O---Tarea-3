package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

import t3.logica_expendedor.*;

public class PanelExpendedor extends JPanel {
    private Precios_Productos producto = null;
    private final Expendedor expendedor;
    private final Comprador comprador;
    private final Letrero letrero;

    public PanelExpendedor(Expendedor expendedor, Comprador comprador) {
        super();
        this.expendedor = expendedor;
        this.comprador = comprador;

        setBackground(new Color(0xf0f6ff));
        setBounds(400, 0, 850, 670);
        setLayout(null);

        //Se agregan los productos
        add(scaledProducto("cocacola.png",65,100,150,150));
        add(scaledProducto("sprite.png",170,100,150,150));
        add(scaledProducto("fanta.png",270,100,150,150));
        add(scaledProducto("snickers.png",55,270,160,160));
        add(scaledProducto("super8.png",153,275,160,160));

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
        add(new BotonSelectorP(this,Precios_Productos.COCACOLA,438,328,47,42));
        add(new BotonSelectorP(this,Precios_Productos.SPRITE,490,328,47,42));
        add(new BotonSelectorP(this,Precios_Productos.FANTA,544,328,47,42));
        add(new BotonSelectorP(this,Precios_Productos.SNICKERS,438,377,47,42));
        add(new BotonSelectorP(this,Precios_Productos.SUPER8,490,377,47,42));

        //Se agrega el Boton para concretar la compra
        add(new BotonCompra(this,557,235,40,40));

        //Se agrega el Boton para Sacar las Monedas ingresadas sin comprar
        add(new BotonResetMoney(this,500,235,40,40));

        //Se agrega el boton para sacar el vuelto
        add(new BotonVuelto(this,431,477,166,81));

        //Se agrega el boton para sacar al producto
        add(new BotonProducto(this,93,477,304,81));

        //Se carga, redimenciona y agrega la imagen de fondo del Expendedor
        ImageIcon originalExpendedorIcon = new ImageIcon("src/main/java/t3/resources/expendedor.png");
        Image originalExpendedorIconImage = originalExpendedorIcon.getImage();
        Image scaledExpendedorIconImage = originalExpendedorIconImage.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        ImageIcon expendedorIcon = new ImageIcon(scaledExpendedorIconImage);

        JLabel expendedorLabel = new JLabel(expendedorIcon);
        expendedorLabel.setBounds(0,0 , 670,670);

        add(expendedorLabel);
    }

    // Cargar y redimensionar la imagen del Producto
    private JLabel scaledProducto(String nombre, int x, int y, int width, int height){
        ImageIcon originalIcon = new ImageIcon("src/main/java/t3/resources/" + nombre);
        Image originalIconImage = originalIcon.getImage();
        Image scaledIconImage = originalIconImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledIconImage);

        JLabel label = new JLabel(Icon);
        label.setBounds(x,y , width,height);

        return label;
    }

    private JLabel mostrarPrecios(Precios_Productos nombre, int x, int y, int width, int height){
        JLabel precio = new JLabel("$" + nombre.getPrecio());
        precio.setForeground(new Color(0x000000));
        precio.setBounds(x,y,width,height);

        return precio;
    }

    public void setProducto(Precios_Productos producto){this.producto = producto;}

    public Precios_Productos getProducto(){return this.producto;}

    public Expendedor getExpendedor(){return this.expendedor;}

    public Comprador getComprador(){return this.comprador;}

    public Letrero getLetrero(){return this.letrero;}
}
