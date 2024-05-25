package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {

    public PanelComprador() {

        JLabel productoUsuarioTitulo = new JLabel("Productos del Usuario");
        productoUsuarioTitulo.setFont(new Font("Monospaced", Font.PLAIN, 18));
        productoUsuarioTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        productoUsuarioTitulo.setBounds(0, 0, 350, 40);

        JPanel panelProductoUsuario = new JPanel();
        panelProductoUsuario.setBackground(new Color(0xF4F8FF));
        panelProductoUsuario.setLayout(null);
        panelProductoUsuario.setBounds(20, 95, 350, 175);



        // Seccion donde se muestra las cantidades de monedas del comprador
        int posX = 20;
        int posY = 40;
        int offset = 35;

        JLabel moneda1500CantLabel = new CantidadMonedasLabel(1500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                posX, posY
        );

        JLabel moneda1000CantLabel = new CantidadMonedasLabel(1000,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                posX, posY + offset
        );

        JLabel moneda500CantLabel = new CantidadMonedasLabel(500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                posX, posY + offset*2
        );

        JLabel moneda100CantLabel = new CantidadMonedasLabel(100,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                posX , posY + offset*3
        );

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
        JButton btnMoneda1500 = new MonedaButton(1500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                20, 35);

        JButton btnMoneda1000 = new MonedaButton(1000,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                110, 35);

        JButton btnMoneda500 = new MonedaButton(500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                20, 85);

        JButton btnMoneda100 = new MonedaButton(100,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                110, 85);

        ImageIcon imgMonedaSeleccionada = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png");
        JLabel lblMonedaSeleccionada = new JLabel(imgMonedaSeleccionada);
        lblMonedaSeleccionada.setBounds(250, 60, imgMonedaSeleccionada.getIconWidth(), imgMonedaSeleccionada.getIconHeight() );

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
}
