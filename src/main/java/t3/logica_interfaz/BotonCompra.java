package t3.logica_interfaz;

import t3.logica_expendedor.Excepciones.ProductoNoRetirado;
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
        this.setToolTipText("Comprar");
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        try {
            //Si no hay ningun producto en la salida
            if(pExp.getComprado() != null) {throw new ProductoNoRetirado();}

            String productoCompradoTXT;
            Precios_Productos productoSeleccionado = pExp.getProducto();

            String producto = null;
            switch (productoSeleccionado) {
                case Precios_Productos.COCACOLA -> producto = "Cocacola  comprada!";
                case Precios_Productos.SPRITE -> producto = "Sprite  comprada!";
                case Precios_Productos.FANTA -> producto = "Fanta  comprada!";
                case Precios_Productos.SNICKERS -> producto = "Snickers  comprado!";
                case Precios_Productos.SUPER8 -> producto = "Super8  comprado!";
            }

            pExp.getComprador().comprar(productoSeleccionado);
            pExp.setComprado(productoSeleccionado);

            pExp.getLetrero().cambiarTextoLetrero(producto);
            pExp.getLetrero().ImprimirCompra();
            pExp.getBotonProducto().impresionProducto();
        }
        catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());}
        finally {pExp.setProducto(null);}
    }

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {;}

    public void mouseExited(MouseEvent me) {;}
}
