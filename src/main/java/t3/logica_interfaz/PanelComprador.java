package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;

 GeneradorImagen{
/**
 * La clase PanelCompradores un JPanel personalizado que muestra los productos y
 * monedas del comprador
 * @author
 */
     public class PanelComprador extends JPanel implements {
    private ProductosUsuarioLabel productoUsuarioCoca;
    private ProductosUsuarioLabel productoUsuarioSprite;
    private ProductosUsuarioLabel productoUsuarioFanta;
    private ProductosUsuarioLabel productoUsuarioSuper8;
    private ProductosUsuarioLabel productoUsuarioSnickers;

    private CantidadMonedasLabel moneda1500CantLabel;
    private CantidadMonedasLabel moneda1000CantLabel;
    private CantidadMonedasLabel moneda500CantLabel;
    private CantidadMonedasLabel moneda100CantLabel;

    /**
     * es un constructor para inicializar el panel del comprador
     * @param panelExpendedor Es el panel del expendedor al que pertenece
     */
    public PanelComprador(PanelExpendedor panelExpendedor) {
        Comprador comprador = panelExpendedor.getComprador();

        // Configuración de título para los productos del usuario
        JLabel productoUsuarioTitulo = new JLabel("Productos del Usuario");
        productoUsuarioTitulo.setFont(new Font("Monospaced", Font.PLAIN, 18));
        productoUsuarioTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        productoUsuarioTitulo.setBounds(0, 0, 350, 40);

        productoUsuarioCoca = new ProductosUsuarioLabel(Precios_Productos.COCACOLA, 20, 40, comprador);
        productoUsuarioSprite = new ProductosUsuarioLabel(Precios_Productos.SPRITE, 20, 66, comprador);
        productoUsuarioFanta = new ProductosUsuarioLabel(Precios_Productos.FANTA, 20, 92, comprador);
        productoUsuarioSnickers = new ProductosUsuarioLabel(Precios_Productos.SNICKERS, 20, 118, comprador);
        productoUsuarioSuper8 = new ProductosUsuarioLabel(Precios_Productos.SUPER8, 20, 144, comprador);

        JPanel panelProductoUsuario = new JPanel();
        panelProductoUsuario.setBackground(new Color(0xF4F8FF));
        panelProductoUsuario.setLayout(null);
        panelProductoUsuario.setBounds(20, 95, 350, 175);

        // Configuración donde se muestra las cantidades de monedas del comprador
        int posX = 20;
        int posY = 40;
        int offset = 35;

        moneda1500CantLabel = new CantidadMonedasLabel(1500, posX, posY, comprador);
        moneda1000CantLabel = new CantidadMonedasLabel(1000, posX, posY + offset, comprador);
        moneda500CantLabel = new CantidadMonedasLabel(500, posX, posY + offset*2, comprador);
        moneda100CantLabel = new CantidadMonedasLabel(100, posX , posY + offset*3, comprador);

        // titulo de la seccion donde se muestra la cantidad de monedas
        JLabel cantMonedasTitulo = new JLabel("Cantidad de Monedas");
        cantMonedasTitulo.setFont(new Font("Monospaced", Font.PLAIN, 18));
        cantMonedasTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        cantMonedasTitulo.setBounds(0, 0, 350, 40);


        JPanel panelCantMonedas = new JPanel();
        panelCantMonedas.setBackground(new Color(0xF4F8FF));
        panelCantMonedas.setBounds(20, 285, 350, 180);
        panelCantMonedas.setLayout(null);




        // seccion de seleccion de moneda
        ImageIcon iconoMonedaSelec = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",80,80);

        JLabel lblMonedaSeleccionada = new JLabel(iconoMonedaSelec);
        lblMonedaSeleccionada.setBounds(230, 40, iconoMonedaSelec.getIconWidth(), iconoMonedaSelec.getIconHeight());
        lblMonedaSeleccionada.setText("XXXXX");
        lblMonedaSeleccionada.setHorizontalTextPosition(JLabel.CENTER);
        lblMonedaSeleccionada.setVerticalTextPosition(JLabel.CENTER);
        lblMonedaSeleccionada.setIconTextGap(-30);
        lblMonedaSeleccionada.setFont(new Font("Monospaced", Font.PLAIN, 10));
        lblMonedaSeleccionada.setForeground(new Color(0x555555));

        JButton btnMoneda1500 = new MonedaButton(panelExpendedor,1500,20, 35,lblMonedaSeleccionada, moneda1500CantLabel);
        JButton btnMoneda1000 = new MonedaButton(panelExpendedor,1000, 110, 35,lblMonedaSeleccionada, moneda1000CantLabel);
        JButton btnMoneda500 = new MonedaButton(panelExpendedor,500,20, 85,lblMonedaSeleccionada, moneda500CantLabel);
        JButton btnMoneda100 = new MonedaButton(panelExpendedor,100,110, 85,lblMonedaSeleccionada, moneda100CantLabel);


        JLabel selecMonedaTitulo = new JLabel("Elegir Moneda");
        selecMonedaTitulo.setFont(new Font("Monospaced", Font.PLAIN, 18));
        selecMonedaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        selecMonedaTitulo.setBounds(0, 0 , 350, 35);

        JPanel panelSelecMoneda = new JPanel();
        panelSelecMoneda.setBackground(new Color(0xF4F8FF));
        panelSelecMoneda.setBounds(20, 480, 350, 140);
        panelSelecMoneda.setLayout(null);



        ImageIcon imgUsuario = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/usuario.jpeg");
        JLabel imgUsuarioLabel = new JLabel(imgUsuario);
        imgUsuarioLabel.setBounds(20, 20, 50, 50 );

        JLabel titulo = new JLabel("COMPRADOR");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        titulo.setBounds(10, 0, 390, 85);
        titulo.setFont(new Font("Monospaced", Font.BOLD, 25));


        // luego optimizar con arrays
        this.setBackground(new Color(0xceddf2));
        this.setBounds(0, 0, 400, 670);
        this.setLayout(null);
        this.add(imgUsuarioLabel);
        this.add(titulo);
        this.add(cantMonedasTitulo);

        //añadir subpaneles

        this.add(panelProductoUsuario);
        this.add(panelSelecMoneda);
        this.add(panelCantMonedas);


        // añadir componentes a los subpaneles

        panelProductoUsuario.add(productoUsuarioTitulo);
        panelProductoUsuario.add(productoUsuarioCoca);
        panelProductoUsuario.add(productoUsuarioSprite);
        panelProductoUsuario.add(productoUsuarioFanta);
        panelProductoUsuario.add(productoUsuarioSuper8);
        panelProductoUsuario.add(productoUsuarioSnickers);

        panelCantMonedas.add(moneda1500CantLabel);
        panelCantMonedas.add(moneda1000CantLabel);
        panelCantMonedas.add(moneda500CantLabel);
        panelCantMonedas.add(moneda100CantLabel);
        panelCantMonedas.add(cantMonedasTitulo);

        panelSelecMoneda.add(btnMoneda1000);
        panelSelecMoneda.add(btnMoneda1500);
        panelSelecMoneda.add(btnMoneda500);
        panelSelecMoneda.add(btnMoneda100);
        panelSelecMoneda.add(selecMonedaTitulo);
        panelSelecMoneda.add(lblMonedaSeleccionada);

    }

    public ProductosUsuarioLabel getProductosUsuarioLabel(Precios_Productos tipoProducto) {
        return switch (tipoProducto) {
            case Precios_Productos.COCACOLA -> productoUsuarioCoca;
            case Precios_Productos.SPRITE -> productoUsuarioSprite;
            case Precios_Productos.FANTA -> productoUsuarioFanta;
            case Precios_Productos.SNICKERS -> productoUsuarioSnickers;
            case Precios_Productos.SUPER8 -> productoUsuarioSuper8;
        };
    }

    public CantidadMonedasLabel getCantMonedasLabel(int valor) {
        return switch (valor) {
            case 100 -> moneda100CantLabel;
            case 500 -> moneda500CantLabel;
            case 1000 -> moneda1000CantLabel;
            case 1500 -> moneda1500CantLabel;
            default -> null;
        };
    }
}
