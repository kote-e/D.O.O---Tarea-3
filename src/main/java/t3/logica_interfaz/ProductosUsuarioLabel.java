package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ProductosUsuarioLabel extends JLabel {

    Precios_Productos producto;
    private int cantidad = 0;

    public ProductosUsuarioLabel(Precios_Productos prod, int posX, int posY ) {
        ImageIcon icon = null;
        producto = prod;

        String strProducto = "";

        switch(prod) {
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
                strProducto = "Sprite  ";
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
        Image imgIcon = icon.getImage();
        Image scaledImgIcon = imgIcon.getScaledInstance(20,20, Image.SCALE_DEFAULT);
        icon = new ImageIcon(scaledImgIcon);



        this.setText(strProducto + "       cantidad: " + cantidad);
        this.setFont(new Font("monospaced", Font.PLAIN, 16));
        this.setHorizontalTextPosition(JLabel.RIGHT);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setIcon(icon);
        this.setBounds(posX, posY, 310, 25);
        this.setBackground(new Color(0xF4EAFF));
        this.setOpaque(true);

        this.addMouseListener(new EscucharMouse());

    }

    private class EscucharMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            String strProducto = null;

            switch (producto) {
                case Precios_Productos.COCACOLA:
                    strProducto = "Cocacola";
                    break;
                case Precios_Productos.FANTA:
                    strProducto = "Fanta   ";
                    break;
                case Precios_Productos.SPRITE:
                    strProducto = "Sprite   ";
                    break;
                case Precios_Productos.SUPER8:
                    strProducto = "Super8   ";
                    break;
                case Precios_Productos.SNICKERS:
                    strProducto = "Snickers";
                    break;
            }

            System.out.println("clicked on producto: " + strProducto);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            ProductosUsuarioLabel lbl = (ProductosUsuarioLabel) e.getComponent();
            lbl.setBackground(new Color(0xCC9DFF));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ProductosUsuarioLabel lbl = (ProductosUsuarioLabel) e.getComponent();
            lbl.setBackground(new Color(0xF4EAFF));
        }
    }

    public void setCantidad(int cant){
        cantidad = cant;
    }

}
