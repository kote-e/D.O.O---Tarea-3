package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonProducto extends JLabel implements MouseListener {
    private final PanelExpendedor pExp;
    private PanelComprador panelComprador;

    public BotonProducto(PanelExpendedor pExp,PanelComprador panelComprador ,int x, int y, int width, int height) {
        this.pExp = pExp;
        this.panelComprador = panelComprador;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0x000000));
        this.setOpaque(true);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        try{
            pExp.getComprador().addProducto(pExp.getExpendedor().getProducto());
            panelComprador.getProductosUsuarioLabel(pExp.getComprado()).setCantidad(pExp.getComprador().cantidadProducto(pExp.getComprado()));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"No hay ningun producto");
        }
}

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {
        BotonProducto lbl = (BotonProducto) me.getComponent();
        lbl.setBackground(new Color(0x672222));
    }

    public void mouseExited(MouseEvent me) {
        BotonProducto lbl = (BotonProducto) me.getComponent();
        lbl.setBackground(new Color(0x000000));
    }

    public void setPanelComprador(PanelComprador panelComprador) {this.panelComprador = panelComprador;}
}
