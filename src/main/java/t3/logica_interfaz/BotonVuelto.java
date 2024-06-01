package t3.logica_interfaz;

import t3.logica_expendedor.Monedas.Moneda;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonVuelto extends JLabel implements MouseListener {
    private final PanelExpendedor pExpendedor;
    private PanelComprador pComprador;

    public BotonVuelto(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExpendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        try {
            Moneda moneda = pExpendedor.getExpendedor().getVuelto();
            pExpendedor.getComprador().addMonedas(moneda);
            pComprador.getCantMonedasLabel(moneda.getValor()).setCantidad(pExpendedor.getComprador().cantidadMonedas(moneda.getValor()));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No quedan mas monedas");
        }
    }

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {;}

    public void mouseExited(MouseEvent me) {;}

    public void setpComprador(PanelComprador pComprador) {this.pComprador = pComprador;}
}
