package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Expendedor;

import javax.swing.*;

/**
 * La clase Ventana es una extencion de JFrame que representa la interfaz gráfica
 * de la máquina expendedora y configura los componentes principales de la interfaz de usuario
 * @author
 */
public class Ventana extends JFrame {
    /**
     * Inicializa la interfaz gráfica, creando los componentes necesarios como el comprador,
     * el expendedor, y los paneles correspondientes
     */
    public Ventana(){
        Comprador comprador;
        Expendedor expendedor;

        try {
            int cantidadProductosExpendedor = 3;
            expendedor = new Expendedor(cantidadProductosExpendedor);
            comprador = new Comprador(expendedor);

            // popUp para poner monedas en el comprador
            new PanelSetup(comprador, this);

            // Comprador y Expendedor
            PanelExpendedor panelExpendedor = new PanelExpendedor(expendedor, comprador);
            PanelComprador panelComprador = new PanelComprador(panelExpendedor);
            panelExpendedor.setPanelComprador(panelComprador);

            ImageIcon icono = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/Icono-aplicacion.jpg");

            this.setTitle("Expendedor de Bebidas");
            this.setIconImage(icono.getImage());
            this.setLayout(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // cerrar la aplicacion al apretar x
            this.setSize(1100, 670); // tamaño de la ventana
            this.setResizable(false); // no se puede cambiar el tamaño

            // añadir paneles a ventana
            this.add(panelComprador);
            this.add(panelExpendedor);

            this.setVisible(true);
        }
        catch (Exception e){JOptionPane.showMessageDialog(this, e.getMessage());}
    }
}
