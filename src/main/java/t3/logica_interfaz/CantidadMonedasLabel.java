package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;

import javax.swing.*;
import java.awt.*;

/**
 * La clase CantidadMonedasLabel que muestra una etiqueta la cantidad de monedas de
 * un valor que tiene el comprador
 * @author
 */
public class CantidadMonedasLabel extends JLabel {
public class CantidadMonedasLabel extends JLabel implements GeneradorImagen{
    private CantidadMonedasLabel thisLabel;
    private int cantidad = 0;
    private Comprador comprador = null;
    private String strVal = "";

    /**
     * Constructor para inicializar la etiqueta con la cantidad de monedas y su ícono correspondiente
     * @param val esta es el valor de la moneda
     * @param posX esta es la cooredenada x donde se encuentra la etiqueta en la pantalla
     * @param posY esta es la cooredenada y donde se encuentra la etiqueta en la pantalla
     * @param comp este es el comprador
     */
    public CantidadMonedasLabel(int val, int posX, int posY , Comprador comp) {
        thisLabel = this;
        comprador = comp;
        cantidad = comprador.cantidadMonedas(val);


        /** Selecciona el ícono correspondiente al valor de la moneda */

        ImageIcon icon = null;
        switch(val) {
            case 100 -> icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_100.png");

            case 500 -> icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_500.png");

            case 1000 -> icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_1000.png");

            case 1500 -> icon = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png");
        }


        /** Escala la imagen del ícono */

        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(20,20, Image.SCALE_DEFAULT);
        icon = new ImageIcon(scaledImg);
        ImageIcon icon = switch(val) {
            case 100 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_100.png",20,20);
            case 500 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_500.png",20,20);
            case 1000 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_1000.png",20,20);
            case 1500 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",20,20);
            default -> null;
        };


        /** Establece el texto y el ícono de la etiqueta */

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


    /*
    * Metodo para cambiar el texto del indicador de cantidad de monedas en la label pasada como argumento en el constructor.
    * @param int cantidad cantidad de monedas
    */
    public void setCantidad(int cant){
        cantidad = cant;
        thisLabel.setText(strVal + "           cantidad: " + cantidad);
    }
}
