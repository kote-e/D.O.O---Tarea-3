package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class BotonSelectorP extends JLabel implements MouseListener {
    private final Precios_Productos producto;
    private final PanelExpendedor pExpendedor;

    public BotonSelectorP(PanelExpendedor pExp, Precios_Productos producto, int x, int y, int width, int height) {
        this.pExpendedor = pExp;
        this.producto = producto;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0xF4EAFF));
        this.setOpaque(true);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        pExpendedor.setProducto(producto);
        pExpendedor.getLetrero().ImprimirPrecio();
    }

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {
        BotonSelectorP lbl = (BotonSelectorP) me.getComponent();
        lbl.setBackground(new Color(0xDFC3FF));
    }

    public void mouseExited(MouseEvent me) {
        BotonSelectorP lbl = (BotonSelectorP) me.getComponent();
        lbl.setBackground(new Color(0xF4EAFF));
    }
}
