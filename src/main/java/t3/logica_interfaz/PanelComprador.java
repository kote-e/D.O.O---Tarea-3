package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {

    public PanelComprador() {
        JButton btnMoneda1500 = new MonedaButton(1500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                20, 40);

        JButton btnMoneda1000 = new MonedaButton(1000,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                120, 40);

        JButton btnMoneda500 = new MonedaButton(500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                20, 100);

        JButton btnMoneda100 = new MonedaButton(100,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                120, 100);

        JLabel selecMonedaTitulo = new JLabel("Elegir Moneda");
        selecMonedaTitulo.setFont(new Font("Monospaced", Font.BOLD, 20));
        selecMonedaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        selecMonedaTitulo.setBounds(0, 0 , 350, 35);

        JPanel panelSelecMoneda = new JPanel();
        panelSelecMoneda.setBackground(new Color(0xF4F8FF));
        panelSelecMoneda.setBounds(20, 450, 350, 150);
        panelSelecMoneda.setLayout(null);

        ImageIcon imgUsuario = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/usuario.jpeg");

        JLabel imgUsuarioLabel = new JLabel(imgUsuario);
        imgUsuarioLabel.setBounds(5, 20, 50, 50 );



        // luego optimizar con array
        int posX = 38;
        int posY = 295;
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






        JLabel titulo = new JLabel("Comprador");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 8, 400, 100);
        titulo.setFont(new Font("Monospaced", Font.BOLD, 25));

        // titulo de la seccion donde se muestra la cantidad de monedas
        JLabel seccCantMonedasTitulo = new JLabel("Cantidad Monedas");
        seccCantMonedasTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        seccCantMonedasTitulo.setBounds(10, 240, 400, 50);
        seccCantMonedasTitulo.setFont(new Font("Monospaced", Font.PLAIN, 18));

        // luego optimizar con arrays
        this.setBackground(new Color(0xceddf2));
        this.setBounds(0, 0, 400, 670);
        this.setLayout(null);
        this.add(panelSelecMoneda);
        this.add(imgUsuarioLabel);
        this.add(titulo);
        this.add(seccCantMonedasTitulo);

        this.add(moneda1500CantLabel);
        this.add(moneda1000CantLabel);
        this.add(moneda500CantLabel);
        this.add(moneda100CantLabel);

        panelSelecMoneda.add(btnMoneda1000);
        panelSelecMoneda.add(btnMoneda1500);
        panelSelecMoneda.add(btnMoneda500);
        panelSelecMoneda.add(btnMoneda100);
        panelSelecMoneda.add(selecMonedaTitulo);

    }
}
