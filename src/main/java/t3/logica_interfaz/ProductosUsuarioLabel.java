package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Excepciones.NoHayProductoComprador;
import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *  La clase ProductosUsuarioLabel es una extensión de JLabel que representa un producto
 *  del usuario en la interfaz gráfica. Implementa la interfaz GeneradorImagen para generar
 *  imágenes de productos
 * @author
 */
public class ProductosUsuarioLabel extends JLabel implements GeneradorImagen{

    private final ProductosUsuarioLabel thisLabel;
    private final Comprador comprador;
    private final Precios_Productos producto;
    private String strProducto;
    private int cantidad = 0;

    /**
     * Constructor para inicializar un label de producto del usuario
     * @param prod el producto que representa el label
     * @param posX esta es la coordenada x donde se encuentra el label en el panel
     * @param posY esta es la coordenada y donde se encuentra el label en el panel
     * @param comp este es el comprador
     */
    public ProductosUsuarioLabel(Precios_Productos prod, int posX, int posY, Comprador comp) {
        comprador = comp;
        producto = prod;
        thisLabel = this;

        ImageIcon icon = null;
        switch(prod) {
            case Precios_Productos.COCACOLA:
                icon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/cocacola.png",20,20);
                strProducto = "Cocacola";
                break;
            case Precios_Productos.FANTA:
                icon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/fanta.png",20,20);
                strProducto = "Fanta   ";
                break;
            case Precios_Productos.SPRITE:
                icon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/sprite.png",20,20);
                strProducto = "Sprite  ";
                break;
            case Precios_Productos.SUPER8:
                icon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/super8.png",20,20);
                strProducto = "Super8  ";
                break;
            case Precios_Productos.SNICKERS:
                icon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/snickers.png",20,20);
                strProducto = "Snickers";
                break;
        }

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

    /**
     * Esta clase funciona para manejar eventos de mouse sobre el label de producto
     */
    private class EscucharMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e){
            try{
                comprador.consumirProducto(producto);
                thisLabel.setCantidad(comprador.cantidadProducto(producto));
            }
            catch (NoHayProductoComprador exp){
                JOptionPane.showMessageDialog(null, exp.getMessage());
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
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

    /**
     * este método para establecer la cantidad de productos en el label
     * @param cant La nueva cantidad de productos
     */
    public void setCantidad(int cant){
        cantidad = cant;
        this.setText(strProducto + "       cantidad: " + String.valueOf(cantidad));
    }
}
