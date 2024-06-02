package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ProductosUsuarioLabel extends JLabel {

    private final ProductosUsuarioLabel thisLabel;
    private Comprador comprador;
    private Precios_Productos producto;
    private String strProducto;
    private int cantidad = 0;

    public ProductosUsuarioLabel(Precios_Productos prod, int posX, int posY, Comprador comp) {
        comprador = comp;
        producto = prod;
        thisLabel = this;


        ImageIcon icon = null;
        switch(prod) {
            case Precios_Productos.COCACOLA:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/cocacola.png");
                strProducto = "Cocacola";
                break;
            case Precios_Productos.FANTA:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/fanta.png");
                strProducto = "Fanta   ";
                break;
            case Precios_Productos.SPRITE:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/sprite.png");
                strProducto = "Sprite  ";
                break;
            case Precios_Productos.SUPER8:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/super8.png");
                strProducto = "Super8  ";
                break;
            case Precios_Productos.SNICKERS:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/snickers.png");
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
            if(comprador.cantidadProducto(producto) != 0){
                comprador.consumirProducto(producto);
                thisLabel.setCantidad(comprador.cantidadProducto(producto));

            } else {
                System.out.println("No hay producto");
                JOptionPane.showMessageDialog(null, "No tienes " + strProducto);
                // implementar excepcion customizada
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            ProductosUsuarioLabel lbl = (ProductosUsuarioLabel) e.getComponent();
            lbl.setBackground(new Color(0xDFC3FF));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            ProductosUsuarioLabel lbl = (ProductosUsuarioLabel) e.getComponent();
            lbl.setBackground(new Color(0xF4EAFF));
        }
    }

    public void setCantidad(int cant){
        cantidad = cant;
        this.setText(strProducto + "       cantidad: " + String.valueOf(cantidad));
    }
}
