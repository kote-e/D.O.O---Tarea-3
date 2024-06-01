package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;

public class Letrero extends JLabel {
    private final PanelExpendedor panelExpendedor;

    public Letrero(PanelExpendedor pExp, int x, int y, int width, int height) {
        super();
        this.panelExpendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0x000000));
        this.setOpaque(true);

        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        this.setFont(new Font("monospace", Font.PLAIN, 25));
        this.setForeground(new Color(0xFFFF));

        this.setText("-----");
    }

    public void ImprimirPrecio(){
        String producto = null;
        switch (panelExpendedor.getProducto()){
            case Precios_Productos.COCACOLA -> producto = "Cocacola";
            case Precios_Productos.SPRITE -> producto = "Sprites";
            case Precios_Productos.FANTA -> producto = "Fanta";
            case Precios_Productos.SNICKERS -> producto = "Snickers";
            case Precios_Productos.SUPER8 -> producto = "Super8";
        }
        this.setText("<html>Precio de "+ producto +":<br>$" + panelExpendedor.getProducto().getPrecio() + "</html>");
    }

    public void ImprimirMonedas(){
        this.setText("<html>Monedas:<br>$" + panelExpendedor.getExpendedor().valorTotalIngresado() + "</html>");
    }

    public void ImprimirCompra(){
        String producto = null;
        switch (panelExpendedor.getComprado()){
            case Precios_Productos.COCACOLA -> producto = "Cocacola";
            case Precios_Productos.SPRITE -> producto = "Sprites";
            case Precios_Productos.FANTA -> producto = "Fanta";
            case Precios_Productos.SNICKERS -> producto = "Snickers";
            case Precios_Productos.SUPER8 -> producto = "Super8";
        }
        this.setText("<html>" + producto + "<br>Comprado con exito</html>");
    }
}
