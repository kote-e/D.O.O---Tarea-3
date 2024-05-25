package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;

public class ProductosUsuarioLabel extends JLabel {


    private int cantidad = 0;

    public ProductosUsuarioLabel(Precios_Productos producto, int posX, int posY ) {
            ImageIcon icon = null;

            String strProducto = "";

            switch(producto) {
                case Precios_Productos.COCACOLA:
                    icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/Cocacola.png");
                    strProducto = "Cocacola";
                    break;
                case Precios_Productos.FANTA:
                    icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/Fanta.png");
                    strProducto = "Fanta   ";
                    break;
                case Precios_Productos.SPRITE:
                    icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/Sprite.png");
                    strProducto = "Sprite   ";
                    break;
                case Precios_Productos.SUPER8:
                    icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/Super8.png");
                    strProducto = "Super8   ";
                    break;
                case Precios_Productos.SNICKERS:
                    icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/Snickers.png");
                    strProducto = "Snickers";
                    break;
            }

            this.setText(strProducto + "         cantidad: " + cantidad);
            this.setFont(new Font("monospaced", Font.PLAIN, 16));
            this.setHorizontalTextPosition(JLabel.RIGHT);
            this.setVerticalTextPosition(JLabel.CENTER);
            this.setHorizontalAlignment(JLabel.LEFT);
            this.setIcon(icon);
            this.setBounds(posX, posY, 310, 25);
            this.setBackground(new Color(0xF4EAFF));
            this.setOpaque(true);

    }

    public void setCantidad(int cant){
        cantidad = cant;
    }

}
