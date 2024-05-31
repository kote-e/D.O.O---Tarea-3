package t3.logica_interfaz;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La subclase BotonVuelto es una extensión de JLabel e implementa MouseListener
 * que actúa como un botón para recoger el vuelto del expendedor
 */
public class BotonVuelto extends JLabel implements MouseListener {
    private final PanelExpendedor pExpendedor;

    /**
     * Este es el constructor para iniciar el boton del vuelto
     * @param pExp es el panel en expendedor asociado al boton
     * @param x  esta es la cooredenada x donde se encuentra el bóton en la pantalla
     * @param y esta es la cooredenada y donde se encuentra el bóton en la pantalla
     * @param width este es el ancho del boton
     * @param height este es el alto del boton
     */

    public BotonVuelto(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExpendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
    }

    /**
     *este metodo se utiliza al hacer clic en el boton (press y el release
     *ocurren en el mismo pixel)
     * @param me este es el evento del mouse
     */
    public void mouseClicked(MouseEvent me) {;}

    /**
     * este metodo se utiliza al precionar el botón del mouse el producto seleccionado en
     * el panel expendedor e imprime el precio del producto seleccionado en la pantalla
     * @param me este es el evento del mouse
     */
    public void mousePressed(MouseEvent me) {
        pExpendedor.getComprador().addMonedas(pExpendedor.getExpendedor().getVuelto());
    }

    /**
     * este metodo es cuando se deja de hacer clic en el mouse
     * @param me este es el evento del mouse
     */
    public void mouseReleased(MouseEvent me) {;}
    /**
     * Cambia el color del botón cuando el mouse interactua con este
     * @param me este es el evento del mouse
     */
    public void mouseEntered(MouseEvent me) {;}
    /**
     * Restablece el color del botón cuando el mouse interactua con este
     * @param me este es el evento del mouse
     */
    public void mouseExited(MouseEvent me) {;}

}
