package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {

    public PanelComprador() {
        JButton btnMoneda1500 = new MonedaButton(1500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                40, 50);

        JButton btnMoneda1000 = new MonedaButton(1000,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                140, 50);

        JButton btnMoneda500 = new MonedaButton(500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                40, 110);

        JButton btnMoneda100 = new MonedaButton(100,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                140, 110);

        JLabel selecMonedaTitulo = new JLabel("Elegir Moneda");
        selecMonedaTitulo.setFont(new Font("Monospaced", Font.BOLD, 20));
        selecMonedaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        selecMonedaTitulo.setBounds(0, 0 , 350, 50);

        JPanel panelSelecMoneda = new JPanel();
        panelSelecMoneda.setBackground(new Color(0xF4F8FF));
        panelSelecMoneda.setBounds(20, 400, 350, 200);
        panelSelecMoneda.setLayout(null);

        ImageIcon imgUsuario = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/usuario.jpeg");

        JLabel imgUsuarioLabel = new JLabel(imgUsuario);
        imgUsuarioLabel.setBounds(5, 20, 50, 50 );




        JLabel titulo = new JLabel("Comprador");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setBounds(0, 8, 400, 100);
        titulo.setFont(new Font("Monospaced", Font.BOLD, 25));

        this.setBackground(new Color(0xceddf2));
        this.setBounds(0, 0, 400, 670);
        this.setLayout(null);
        this.add(panelSelecMoneda);
        this.add(titulo);
        this.add(imgUsuarioLabel);

        panelSelecMoneda.add(btnMoneda1000);
        panelSelecMoneda.add(btnMoneda1500);
        panelSelecMoneda.add(btnMoneda500);
        panelSelecMoneda.add(btnMoneda100);
        panelSelecMoneda.add(selecMonedaTitulo);

    }
}
