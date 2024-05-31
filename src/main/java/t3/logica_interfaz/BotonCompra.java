package t3.logica_interfaz;

import t3.logica_expendedor.Expendedor;
import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BotonCompra extends JLabel implements MouseListener{
    private final PanelExpendedor pExp;

    public BotonCompra(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExp = pExp;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        try{
            pExp.getComprador().comprar(pExp.getProducto());
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally {
            pExp.setProducto(null);
        }
    }

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {;}

    public void mouseExited(MouseEvent me) {;}
}
