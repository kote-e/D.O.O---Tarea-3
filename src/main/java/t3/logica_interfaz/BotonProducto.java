package t3.logica_interfaz;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La subclase BotonProducto es una extensión de JLabel e implementa MouseListener que
 * representa un botón en la interfaz que permite agregar un producto al hacer clic
 * @see PanelExpendedor
 */
public class BotonProducto extends JLabel implements MouseListener {
    private final PanelExpendedor pExp;

    /**
     * crea una istancia del BotonProducto
     * @param pExp es el panel en expendedor asociado al boton
     * @param x esta es la cooredenada x donde se encuentrab el bóton en la pantalla
     * @param y esta es la cooredenada y donde se encuentrab el bóton en la pantalla
     * @param width este es el ancho del boton
     * @param height  este es el alto del boton
     */
    public BotonProducto(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExp = pExp;
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
     * este metodo se utiliza al precionar el botón del mouse agregar un producto
     * usando el expendedor
     * @param me este es el evento del mouse
     */
    public void mousePressed(MouseEvent me) {
        pExp.getComprador().addProducto(pExp.getExpendedor().getProducto());
    }

    /**
     * este metodo es cuando se deja de hacer clic en el mouse
     * @param me este es el evento del mouse
     */
    public void mouseReleased(MouseEvent me) {;}

    /**
     *esto se utiluza cuando el mouse esta dentro del area del botón
     * @param me este es el evento del mouse
     */
    public void mouseEntered(MouseEvent me) {;}

    /**
     * esto se utiliza cuando el mouse sale del del area del boton
     * @param me es el evento del mouse
     */
    public void mouseExited(MouseEvent me) {;}
}
