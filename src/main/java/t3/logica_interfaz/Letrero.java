package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;

/**
 * La subclase Letrero es una extensión de JLabel que muestra información sobre
 * los precios de los productos y la cantidad de monedas ingresadas
 * @author
 */
public class Letrero extends JLabel {
    private final PanelExpendedor panelExpendedor;

    /**
     * Constructor que inicializa el letrero en su posición y sus dimensiones
     * @param pExp es el panel al que pertenece el letrero
     * @param x esta es la cooredenada x donde se encuentra el letrero
     * @param y esta es la cooredenada y donde se encuentra el letrero
     * @param width este es el ancho del letrero
     * @param height esta es la altura del letrero
     */

    public Letrero(PanelExpendedor pExp, int x, int y, int width, int height) {
        super();
        this.panelExpendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0x000000)); // Color negro del letrero
        this.setOpaque(true);

        // Configuración de posición y estilo del texto
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setFont(new Font("Monospaced", Font.PLAIN, 15));
        this.setForeground(new Color(0xFFFF)); // Color del texto
        // Texto inicial del letrero
        this.setText("<html> <p  style=\"text-align: center;\">Seleccione Producto</p> </html>");
    }

    /**
     * Método para imprimir el precio del producto seleccionado en el letrero
     */
    public void ImprimirPrecio(){
        String producto = null;
        switch (panelExpendedor.getProducto()){
            case Precios_Productos.COCACOLA -> producto = "Cocacola";
            case Precios_Productos.SPRITE -> producto = "Sprite";
            case Precios_Productos.FANTA -> producto = "Fanta";
            case Precios_Productos.SNICKERS -> producto = "Snickers";
            case Precios_Productos.SUPER8 -> producto = "Super8";
        }
        this.setText("<html><p  style=\"text-align: center;\">Precio de "+ producto +":<br>$" + panelExpendedor.getProducto().getPrecio() + "</p></html>");
    }

    /**
     * Método para imprimir la cantidad total de monedas ingresadas en el expendedor
     */
    public void ImprimirMonedas(){
        this.setText("<html> <p style=\"text-align: center;\">Ingresado: " +
                "$" + panelExpendedor.getExpendedor().valorTotalIngresado() + "</p></html>");
    }

    /**
     * Método para cambiar el texto del letrero del expendedor
     */
    public void cambiarTextoLetrero(String str){
        this.setText("<html> <p  style=\"text-align: center;\">" + str + "</p></html>");
    }

    public void ImprimirCompra(){
        String producto = null;
        switch (panelExpendedor.getComprado()){
            case Precios_Productos.COCACOLA -> producto = "Cocacola comprada con exito!";
            case Precios_Productos.SPRITE -> producto = "Sprite comprada con exito!";
            case Precios_Productos.FANTA -> producto = "Fanta comprada con exito!";
            case Precios_Productos.SNICKERS -> producto = "Snickers comprado con exito!";
            case Precios_Productos.SUPER8 -> producto = "Super8 comprado con exito!";
        }
        this.setText("<html> <p  style=\"text-align: center;\">"  + producto + " </p></html>");
    }
}
