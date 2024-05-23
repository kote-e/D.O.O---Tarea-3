package t3.logica_interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


public class Ventana extends JFrame {
    public Ventana(){

        JPanel panelComprador = new PanelComprador();
        JPanel panelExpendedor = new PanelExpendedor();

        this.setTitle("Expendedor de Bebidas");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
        this.setSize(1100, 670); // tamaño de la ventana
        this.setResizable(false); // no se puede cambiar el tamaño

        // añadir paneles a ventana
        this.add(panelComprador);
        this.add(panelExpendedor);

        this.setVisible(true);
    }
}
