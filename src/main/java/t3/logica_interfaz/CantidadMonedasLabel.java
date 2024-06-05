package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;

import javax.swing.*;
import java.awt.*;

/**
 * La subclase CantidadMonedasLabel es una extensión de JLabel que muestra una
 * etiqueta la cantidad de monedas de un valor que tiene el comprador e implementa
 * la interfaz GeneradorImagen
 */
public class CantidadMonedasLabel extends JLabel implements GeneradorImagen{
    private int cantidad;
    private final String strVal;

    /**
     * Constructor para inicializar la etiqueta con la cantidad de monedas y su ícono correspondiente
     * @param val esta es el valor de la moneda
     * @param posX esta es la coordenada x donde se encuentra la etiqueta en la pantalla
     * @param posY esta es la coordenada y donde se encuentra la etiqueta en la pantalla
     * @param comprador este es el comprador
     */
    public CantidadMonedasLabel(int val, int posX, int posY , Comprador comprador) {
        cantidad = comprador.cantidadMonedas(val);

        //Carga y escala  de imagenes
        ImageIcon icon = switch(val) {
            case 100 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_100.png",20,20);
            case 500 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_500.png",20,20);
            case 1000 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_1000.png",20,20);
            case 1500 -> GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",20,20);
            default -> null;
        };

        // Establece el texto y el ícono de la etiqueta
        if(val >= 1000){strVal = String.valueOf(val);}
        else{strVal = val + " ";}

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


    /**
     * Metodo para cambiar el texto del indicador de cantidad de monedas en la label pasada como argumento en el constructor.
    * @param cant la nueva cantidad de monedas
    */
    public void setCantidad(int cant){
        cantidad = cant;
        this.setText(strVal + "           cantidad: " + cantidad);
    }
}
