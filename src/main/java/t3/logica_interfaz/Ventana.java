package t3.logica_interfaz;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;


public class Ventana extends JFrame {
    public Ventana(){

        JPanel panelComprador = new JPanel();
        panelComprador.setBackground(new Color(0xceddf2));
        panelComprador.setBounds(0, 0, 400, 670);

        JLabel titulo = new JLabel("Comprador");
        panelComprador.add(titulo);


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
