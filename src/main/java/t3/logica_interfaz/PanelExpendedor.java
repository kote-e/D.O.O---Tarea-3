package t3.logica_interfaz;

import t3.logica_expendedor.Bebidas.CocaCola;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    public PanelExpendedor() {
        super();
        setBackground(new Color(0xf0f6ff));
        setBounds(400, 0, 850, 670);
        setLayout(null);

        add(scaledProducto("cocacola.png",300,136,60,60));
        add(scaledProducto("sprite.png",224,138,90,90));
        add(scaledProducto("fanta.jpg",224,195,60,70));
        add(scaledProducto("snickers.png",184,305,40,70));
        add(scaledProducto("super8.png",225,305,60,60));

        ImageIcon originalExpendedorIcon = new ImageIcon("src/main/java/t3/resources/expendedor.jpg");
        Image originalExpendedorIconImage = originalExpendedorIcon.getImage();
        Image scaledExpendedorIconImage = originalExpendedorIconImage.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        ImageIcon expendedorIcon = new ImageIcon(scaledExpendedorIconImage);

        JLabel expendedorLabel = new JLabel(expendedorIcon);
        expendedorLabel.setBounds(0,0 , 670,670);

        add(expendedorLabel);
    }

    // Cargar y redimensionar la imagen del Producto
    static JLabel scaledProducto(String nombre, int x, int y, int width, int height){
        ImageIcon originalIcon = new ImageIcon("src/main/java/t3/resources/" + nombre);
        Image originalIconImage = originalIcon.getImage();
        Image scaledIconImage = originalIconImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledIconImage);

        JLabel label = new JLabel(Icon);
        label.setBounds(x,y , 60,60);

        return label;
    }
}
