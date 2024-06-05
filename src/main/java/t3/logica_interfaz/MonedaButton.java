package t3.logica_interfaz;

import t3.logica_expendedor.Excepciones.NoHayMonedasComprador;
import t3.logica_expendedor.*;
import t3.logica_expendedor.Monedas.Moneda;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * La clase MonedaButton es una extensión de JButton que representa un botón personalizado
 * que permite seleccionar una moneda de un valor específico, al hacer clic en el botón,
 * se actualiza la interfaz del expendedor para reflejar la selección de la moneda
 * @author
 */

public class MonedaButton extends JButton implements GeneradorImagen,Sonidos{
    private final int value;    //Valor de la moneda que representara el Boton
    private final JLabel selecMonedaLabel;
    private final CantidadMonedasLabel cantMonedasLabel;
    private final Comprador comprador;
    private final PanelExpendedor pExpendedor;
    private final Clip meterMoneda;

    /**
     *Constructor para inicializar el botón de moneda
     * @param panelExpendeor este es el panel expendedor al que pertenece el botón
     * @param val este es el valor de la moneda
     * @param posX esta es la coordenada x donde se encuentra el botón en la pantalla
     * @param posY esta es la coordenada y donde se encuentra el botón en la pantalla
     * @param selecMonlbl es la etiqueta que muestra la moneda seleccionada
     * @param cantMonedasLbl esta es la etiqueta que muestra la cantidad de monedas
     */
    public MonedaButton(PanelExpendedor panelExpendeor,int val, int posX, int posY, JLabel selecMonlbl, JLabel cantMonedasLbl){
        pExpendedor=panelExpendeor;
        value = val;
        selecMonedaLabel = selecMonlbl;
        cantMonedasLabel = (CantidadMonedasLabel) cantMonedasLbl;
        comprador = pExpendedor.getComprador();
        meterMoneda = Sonidos.cargarSonido("src/main/java/t3/logica_interfaz/Sonidos/Meter_Moneda.wav");

        ImageIcon icon = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_"+ value +".png",30,30);

        this.setBounds(posX, posY, 85, 45);
        this.setIcon(icon);
        this.setText(String.valueOf(val));
        this.setFont(new Font("monospaced", Font.PLAIN, 12));
        this.setForeground(Color.black);
        this.setFocusable(true);

        this.setBackground(new Color(0xE0FAFA));
        this.setBorder(BorderFactory.createEtchedBorder());

        this.addActionListener(new EscuchadorBoton());
        this.addMouseListener(new EscucharMouse());
    }

    /**
     * Clase interna que implementa ActionListener para manejar eventos de acción del botón
     */

    private class EscuchadorBoton implements ActionListener, GeneradorImagen {
        public void actionPerformed(ActionEvent ae) {
            ImageIcon iconoMonedaSelec = GeneradorImagen.scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_"+ value +".png",80,80);
            selecMonedaLabel.setIcon(iconoMonedaSelec);

            // si el comprador no tiene una moneda no hacer nada
            Moneda moneda = comprador.getMoneda(value);
            if(moneda != null){
                comprador.getExpendedor().addMonedaEntrada(moneda);
                cantMonedasLabel.setCantidad(comprador.cantidadMonedas(value));
                selecMonedaLabel.setText(String.valueOf(moneda.getSerie()));
                pExpendedor.getLetrero().ImprimirMonedas();
                Sonidos.reproducirSonido(meterMoneda,() -> {;});
            } else {
                selecMonedaLabel.setText("XXXXX");
                NoHayMonedasComprador exc = new NoHayMonedasComprador(String.valueOf(value));
                JOptionPane.showMessageDialog(null, exc.getMessage());
            }
        }
    }

    /**
     * Esta es una clase interna que implementa MouseListener para
     * manejar eventos del mause sobre el botón
     */
    private class EscucharMouse implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {
            MonedaButton btn = (MonedaButton) e.getComponent();
            btn.setBackground(new Color(0xABF5FF));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            MonedaButton btn = (MonedaButton) e.getComponent();
            btn.setBackground(new Color(0xE0FAFA));
        }
    }
}
