package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;

import javax.swing.*;
import java.awt.*;

public class CantidadMonedasLabel extends JLabel {

    private int cantidad = 0;
    private Comprador comprador = null;

    public CantidadMonedasLabel(int val, int posX, int posY , Comprador comp) {
        ImageIcon icon = null;
        comprador = comp;
        cantidad = comprador.cantidadMonedas(val);

        switch(val) {
            case 100:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_100.png");
                break;
            case 500:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_500.png");
                break;
            case 1000:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_1000.png");
                break;
            case 1500:
                icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png");
                break;

        }


        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(20,20, Image.SCALE_DEFAULT);
        icon = new ImageIcon(scaledImg);

        String strVal = "";
        if(val >= 1000){strVal = String.valueOf(val);}
        else{strVal = String.valueOf(val) + " ";}

        this.setText(strVal + "           cantidad: " + cantidad);
        this.setFont(new Font("monospaced", Font.PLAIN, 16));
        this.setHorizontalTextPosition(JLabel.RIGHT);
        this.setVerticalTextPosition(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setIcon(icon);
        this.setBounds(posX, posY, 310, 30);
        this.setBackground(new Color(0xF4EAFF));
        this.setOpaque(true);



    }

    public void setCantidad(int cant){
        cantidad = cant;

    }
}
