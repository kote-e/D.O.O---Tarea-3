package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Expendedor;

import javax.swing.*;

public class Ventana extends JFrame {
    public Ventana(Expendedor expendedor,Comprador comprador){
        try{
            PanelExpendedor panelExpendedor = new PanelExpendedor(expendedor, comprador);
            PanelComprador panelComprador = new PanelComprador(panelExpendedor);

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
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
