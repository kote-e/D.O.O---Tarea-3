package t3.logica_interfaz;

import t3.logica_expendedor.Excepciones.NoHayMonedasComprador;
import t3.logica_expendedor.Monedas.Moneda100;
import t3.logica_interfaz.Ventana;
import t3.logica_expendedor.*;
import t3.logica_expendedor.Monedas.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MonedaButton extends JButton{
    private int value = 0;
    private JLabel selecMonedaLabel;
    private CantidadMonedasLabel cantMonedasLabel;
    private Comprador comprador;
    private final PanelExpendedor pExpendedor;

    public MonedaButton(PanelExpendedor panelExpendeor,int val, int posX, int posY, JLabel selecMonlbl, JLabel cantMonedasLbl){
        pExpendedor=panelExpendeor;
        value = val;
        selecMonedaLabel = selecMonlbl;
        cantMonedasLabel = (CantidadMonedasLabel) cantMonedasLbl;
        comprador = pExpendedor.getComprador();

        ImageIcon icon = null;

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
        Image scaledImg = img.getScaledInstance(30,30, Image.SCALE_DEFAULT);
        icon = new ImageIcon(scaledImg);

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


    private class EscuchadorBoton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            ImageIcon iconoMonedaSelec = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_"+ value +".png");
            Image imgMonedaSelec = iconoMonedaSelec.getImage();
            Image scaledImgMonedaSelec = imgMonedaSelec.getScaledInstance(80,80, Image.SCALE_DEFAULT);
            iconoMonedaSelec = new ImageIcon(scaledImgMonedaSelec);

            selecMonedaLabel.setIcon(iconoMonedaSelec);

            // si el comprador no tiene una moneda no hacer nada

            Moneda moneda = comprador.getMoneda(value);
            if(moneda != null){
                comprador.getExpendedor().addMonedaEntrada(moneda);
                cantMonedasLabel.setCantidad(comprador.cantidadMonedas(value));
                selecMonedaLabel.setText(String.valueOf(moneda.getSerie()));
                pExpendedor.getLetrero().ImprimirMonedas();
            } else {
                selecMonedaLabel.setText("XXXXX");
                NoHayMonedasComprador exc = new NoHayMonedasComprador(String.valueOf(value));
                JOptionPane.showMessageDialog(null, exc.getMessage());
            }
        }
    }

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
