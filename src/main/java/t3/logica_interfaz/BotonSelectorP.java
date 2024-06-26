package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *  La subclase BotonSelectorP es una extensión de JLabel e implementa MouseListener
 *  que representa un botón que muestra un producto
 */
public class BotonSelectorP extends JLabel implements MouseListener {
    private final Precios_Productos producto;
    private final PanelExpendedor pExpendedor;

    /**
     * Constructor para inicializar el botón con un producto
     * @param pExp es el panel en expendedor asociado al botón
     * @param producto El producto asociado a cada botón
     * @param x  esta es la coordenada x donde se encuentra el botón en la pantalla
     * @param y esta es la coordenada y donde se encuentra el botón en la pantalla
     * @param width este es el ancho del botón
     * @param height este es el alto del botón
     */
    public BotonSelectorP(PanelExpendedor pExp, Precios_Productos producto,String ver, int x, int y, int width, int height) {
        this.pExpendedor = pExp;
        this.producto = producto;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0xF4EAFF));
        this.setOpaque(true);
        this.setText("   " + ver);
        this.setFont(new Font("monospace", Font.PLAIN, 20));
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        this.addMouseListener(this);
    }

    /**
     *este método se utiliza al hacer clic en el botón (press y el release
     *ocurren en el mismo pixel)
     * @param me este es el evento del mouse
     */
    public void mouseClicked(MouseEvent me) {}

    /**
     * este método se utiliza al presionar el botón del mouse, seleccionando el producto en
     * el panel expendedor e imprime el precio del producto seleccionado en la pantalla
     * @param me este es el evento del mouse
     */
    public void mousePressed(MouseEvent me) {
        pExpendedor.setProducto(producto);
        pExpendedor.getLetrero().ImprimirPrecio(producto);
    }
    /**
     * este metodo es cuando se deja de hacer clic en el mouse
     * @param me este es el evento del mouse
     */
    public void mouseReleased(MouseEvent me) {}

    /**
     * Cambia el color del botón cuando el mouse interactua con este
     * @param me este es el evento del mouse
     */
    public void mouseEntered(MouseEvent me) {
        BotonSelectorP lbl = (BotonSelectorP) me.getComponent();
        lbl.setBackground(new Color(0xDFC3FF));
    }

    /**
     * Restablece el color del botón cuando el mouse interactua con este
     * @param me este es el evento del mouse
     */
    public void mouseExited(MouseEvent me) {
        BotonSelectorP lbl = (BotonSelectorP) me.getComponent();
        lbl.setBackground(new Color(0xF4EAFF));
    }
}
