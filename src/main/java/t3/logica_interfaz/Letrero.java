package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public class Letrero extends JLabel {
    private final PanelExpendedor expendedor;

    public Letrero(PanelExpendedor pExp, int x, int y, int width, int height) {
        super();
        this.expendedor = pExp;
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
        this.setText("Precio: $" + String.valueOf(expendedor.getProducto().getPrecio()));
    }

    public void ImprimirMonedas(){      //Falta implementar
        this.setText("Monedas: $" + String.valueOf(expendedor.getExpendedor().valorTotalIngresado()));
    }
}
