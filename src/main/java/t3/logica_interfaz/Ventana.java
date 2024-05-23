package t3.logica_interfaz;


import javax.swing.*;

import java.awt.Color;


public class Ventana extends JFrame {
    public Ventana(){


        JButton btnMoneda1500 = new MonedaButton(1500,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                100, 100);

        JButton btnMoneda1000 = new MonedaButton(1000,
                "src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",
                100, 200);

        JLabel titulo = new JLabel("Comprador");
        titulo.setBounds(5, 2, 100, 100);

        JPanel panelSelecMoneda = new JPanel();
        panelSelecMoneda.setBackground(new Color(0xF4F8FF));
        panelSelecMoneda.setBounds(20, 200, 350, 400);
        panelSelecMoneda.setLayout(null);

        JPanel panelComprador = new JPanel();
        panelComprador.setBackground(new Color(0xceddf2));
        panelComprador.setBounds(0, 0, 400, 670);
        panelComprador.setLayout(null);

        panelComprador.add(panelSelecMoneda);

        panelComprador.add(titulo);

        panelSelecMoneda.add(btnMoneda1000);
        panelSelecMoneda.add(btnMoneda1500);






        JPanel panelExpendedor = new JPanel();
        panelExpendedor.setBackground(new Color(0xf0f6ff));
        panelExpendedor.setBounds(400, 0, 850, 670);



        this.setTitle("Expendedor de Bebidas");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setResizable(false); // no se puede cambiar el tamaño
        this.setVisible(true);


        // añadir paneles a ventana
        this.add(panelComprador);
        this.add(panelExpendedor);
    }
}
