package t3.logica_interfaz;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonVuelto extends JLabel implements MouseListener {
    private final PanelExpendedor pExpendedor;

    public BotonVuelto(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExpendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        //pExpendedor.getExpendedor().sacarMonedasEntradaASalida();
    }

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {;}

    public void mouseExited(MouseEvent me) {;}

}
