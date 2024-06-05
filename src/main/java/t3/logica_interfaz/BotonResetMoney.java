package t3.logica_interfaz;

import javax.swing.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La subclase BotonResetMoney es una extensión de JLabel e implementa MouseListener
 *  que representa un botón en la interfaz que reinicia el dinero al ser presionado
 * @see PanelExpendedor
 */
public class BotonResetMoney extends JLabel implements MouseListener {
    private final PanelExpendedor pExpendedor;

    /**
     * crea una instancia de BotonResetMoney
     * @param pExp es el panel en expendedor asociado al botón
     * @param x esta es la coordenada x donde se encuentra el botón en la pantalla
     * @param y esta es la coordenada y donde se encuentra el botón en la pantalla
     * @param width este es el ancho del botón
     * @param height este es el alto del botón
     */
    public BotonResetMoney(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExpendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
        this.setToolTipText("Cancelar compra");
    }

    /**
     *este método se utiliza al hacer clic en el botón (press y el release
     *ocurren en el mismo pixel)
     * @param me este es el evento del mouse
     */
    public void mouseClicked(MouseEvent me) {}
    /**
     * este metodo se utiliza al precionar el botón del mouse se
     * reinicia el dinero en el expendedor
     * @param me este es el evento del mouse
     */
    public void mousePressed(MouseEvent me) {
        pExpendedor.getExpendedor().sacarMonedasEntradaASalida();
        pExpendedor.getLetrero().cambiarTextoLetrero("Seleccione Producto");
    }

    /**
     * este metodo es cuando se deja de hacer clic en el mouse
     * @param me este es el evento del mouse
     */
    public void mouseReleased(MouseEvent me) {}
    /**
     *esto se utiluza cuando el mouse está dentro del area del botón
     * @param me este es el evento del mouse
     */
    public void mouseEntered(MouseEvent me) {}
    /**
     * esto se utiliza cuando el mouse sale del area del botón
     * @param me es el evento del mouse
     */
    public void mouseExited(MouseEvent me) {}
}
