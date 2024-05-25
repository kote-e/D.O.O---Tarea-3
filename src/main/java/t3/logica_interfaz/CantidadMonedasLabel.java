package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public class CantidadMonedasLabel extends JLabel {

    private int cantidad = 0;

    public CantidadMonedasLabel(int val, String file, int posX, int posY ) {
        ImageIcon icon = new ImageIcon(file);

        String strVal = "";
        if(val >= 1000){strVal = String.valueOf(val);}
        else{strVal = String.valueOf(val) + " ";}

        this.setText(strVal + "           cantidad: " + cantidad);
        this.setFont(new Font("monospaced", Font.PLAIN, 16));
        this.setHorizontalTextPosition(JLabel.RIGHT);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setIcon(icon);
        this.setBounds(posX, posY, 310, icon.getIconHeight() - 10);
        this.setBackground(new Color(0xF4EAFF));
        this.setOpaque(true);

    }

    public void setCantidad(int cant){
        cantidad = cant;
    }
}
