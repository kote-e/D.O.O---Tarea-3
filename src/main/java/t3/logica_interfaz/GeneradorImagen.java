package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public interface GeneradorImagen {
    // Cargar y redimensionar la imagen del Producto
    static ImageIcon scaledProducto(String nombre, int width, int height){
        ImageIcon originalIcon = new ImageIcon(nombre);
        Image originalIconImage = originalIcon.getImage();
        Image scaledIconImage = originalIconImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledIconImage);
    }

    //Generar una JLabel Custom para cada imagen
    static JLabel ImageLabel(String nombre, int x, int y, int width, int height){
        ImageIcon icon = scaledProducto(nombre, width, height);

        JLabel label = new JLabel(icon);
        label.setBounds(x, y, width, height);

        return label;
    }
}
