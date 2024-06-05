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
 * un botón en la interfaz para realizar una compra al ser presionado
 * @see PanelExpendedor
 * @see Expendedor
 */
public class BotonCompra extends JLabel implements MouseListener{
    private final PanelExpendedor pExp;

    /**
     *  crea una instancia de BotonCompra
     * @param pExp El panel del expendedor asociado con este botón
     * @param x esta es la coordenada x donde se encuentra el botón en la pantalla
     * @param y esta es la coordenada y donde se encuentra el botón en la pantalla
     * @param width este es el ancho del botón
     * @param height este es el alto del botón
     */
    public BotonCompra(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExp = pExp;
        this.setBounds(x,y,width,height);
        this.setOpaque(false);
        this.addMouseListener(this);
        this.setToolTipText("Comprar");
    }

    /**
     * Este método se utiliza al hacer clic en el boton (press y el release
     * ocurren en el mismo pixel)
     * @param me este es el evento del mouse
     */
    public void mouseClicked(MouseEvent me) {;}

    /**
     * Este metodo se utiliza al presionar el botón del mouse, se intenta realizar una
     * compra y si algo sale mal, muestra un mensaje de error
     * @param me este es el evento del mouse
     */
    public void mousePressed(MouseEvent me) {
        try {
            //Si no hay un producto en la salida
            if(pExp.getComprado() != null) {throw new ProductoNoRetirado();}

            Precios_Productos productoSeleccionado = pExp.getProducto();

            String producto = switch (productoSeleccionado) {
                case Precios_Productos.COCACOLA -> "Cocacola  comprada!";
                case Precios_Productos.SPRITE -> "Sprite  comprada!";
                case Precios_Productos.FANTA -> "Fanta  comprada!";
                case Precios_Productos.SNICKERS -> "Snickers  comprado!";
                case Precios_Productos.SUPER8 -> "Super8  comprado!";
            };

            pExp.getComprador().comprar(productoSeleccionado);
            pExp.setComprado(productoSeleccionado);

            pExp.getLetrero().cambiarTextoLetrero(producto);
            pExp.getLetrero().ImprimirCompra();
            pExp.getBotonProducto().impresionProducto();
            pExp.getPanelProductos().ocultarProductos();
        }
        catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage());}
        finally {pExp.setProducto(null);}
    }

    /**
     * este método se utiliza cuando se deja de hacer clic en el mouse
     * @param me este es el evento del mouse
     */
    public void mouseReleased(MouseEvent me) {;}

    /**
     *Este se utiliza cuando el mouse está dentro del área del botón
     * @param me este es el evento del mouse
     */
    public void mouseEntered(MouseEvent me) {;}

    /**
     * Esto se utiliza cuando el mouse sale del area del boton
     * @param me es el evento del mouse
     */
    public void mouseExited(MouseEvent me) {;}
}
