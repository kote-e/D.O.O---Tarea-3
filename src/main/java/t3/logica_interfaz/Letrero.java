package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public class Letrero extends JLabel {
    private final PanelExpendedor expendedor;
    String imprimir = "-----";

    public Letrero(PanelExpendedor pExp, int x, int y, int width, int height) {
        super();
        this.expendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0x000000));
        this.setOpaque(true);

        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        this.setFont(new Font("monospace", Font.PLAIN, 30));
        this.setForeground(new Color(0xFFFF));

        this.setText(imprimir);
    }

    public void Imprimir(){
        if(expendedor.getProducto() != null){
            imprimir = "$" + String.valueOf(expendedor.getProducto().getPrecio());
        }

        this.setText(imprimir);
    }
}
