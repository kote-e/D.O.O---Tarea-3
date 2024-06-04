package t3.logica_interfaz;

import t3.logica_expendedor.Excepciones.ProductoNoRetirado;
import t3.logica_expendedor.Expendedor;
import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La subclase BotonCompra es una extensión de JLabel e implementa MouseListener y representa
 * un boton en la interfaz para realizar una compra al ser precionado
 * @see PanelExpendedor
 * @see Expendedor
 */
public class BotonCompra extends JLabel implements MouseListener{
    private final PanelExpendedor pExp;

    /**
     *  crea una instancia de BoonbCompra
     * @param pExp El panel del expendedor asociado con este botón
     * @param x esta es la cooredenada x donde se encuentra el bóton en la pantalla
     * @param y esta es la cooredenada y donde se encuentra el bóton en la pantalla
     * @param width este es el ancho del boton
     * @param height este es el alto del boton
     */
    public BotonCompra(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExp = pExp;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
        this.setToolTipText("Comprar");
    }

    /**
     * este metodo se utiliza al hacer clic en el boton (press y el release
     * ocurren en el mismo pixel)
     * @param me este es el evento del mouse
     */
    public void mouseClicked(MouseEvent me) {;}

    /**
     * este metodo se utiliza al precionar el botón del mouse se intenta realizar una compra
     * y si algo sale mal ale un mensaje de error.
     * @param me este es el evento del mouse
     */
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
            pExp.getPanelProductos().ocultarProductos();
            pExp.getPanelProductos().imprimirProductos();
        }
        catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());}
        finally {pExp.setProducto(null);}
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
