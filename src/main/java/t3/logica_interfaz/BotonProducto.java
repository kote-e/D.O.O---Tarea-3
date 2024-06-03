package t3.logica_interfaz;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonProducto extends JLabel implements MouseListener {
    private final PanelExpendedor pExp;
    private PanelComprador panelComprador;

    public BotonProducto(PanelExpendedor pExp,PanelComprador panelComprador ,int x, int y, int width, int height) {
        this.pExp = pExp;
        this.panelComprador = panelComprador;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        pExp.getComprador().addProducto(pExp.getExpendedor().getProducto());
        panelComprador.getProductosUsuarioLabel(pExp.getComprado()).setCantidad(pExp.getComprador().cantidadProducto(pExp.getComprado()));
    }

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {;}

    public void mouseExited(MouseEvent me) {;}

    public void setPanelComprador(PanelComprador panelComprador) {this.panelComprador = panelComprador;}
}
