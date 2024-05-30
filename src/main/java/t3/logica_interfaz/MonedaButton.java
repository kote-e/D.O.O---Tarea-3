package t3.logica_interfaz;

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
    private JLabel cantMonedasLabel;
    private Comprador comprador;

    public MonedaButton(int val, int posX, int posY, Comprador comp, JLabel selecMonlbl, JLabel cantMonedasLbl){
        value = val;
        selecMonedaLabel = selecMonlbl;
        cantMonedasLabel = cantMonedasLbl;
        comprador = comp;

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
        this.setToolTipText("text");
        this.setBackground(new Color(0xE0FAFA));
        this.setBorder(BorderFactory.createEtchedBorder());

        this.addActionListener(new EscuchadorBoton());
        this.addMouseListener(new EscucharMouse());
    }


    private class EscuchadorBoton implements ActionListener {
        public void actionPerformed(ActionEvent ae) {

            System.out.println(value);

            ImageIcon iconoMonedaSelec = new ImageIcon("src/main/java/t3/logica_interfaz/Imagenes/moneda_"+ value +".png");
            Image imgMonedaSelec = iconoMonedaSelec.getImage();
            Image scaledImgMonedaSelec = imgMonedaSelec.getScaledInstance(80,80, Image.SCALE_DEFAULT);
            iconoMonedaSelec = new ImageIcon(scaledImgMonedaSelec);

            selecMonedaLabel.setIcon(iconoMonedaSelec);


            // si el comprador no tiene una moneda

            Moneda moneda = comprador.getMoneda(value);
            if(moneda != null){
                comprador.getExpendedor().addMonedaEntrada(moneda);
            } else {
                System.out.println("No hay moneda");
                JOptionPane.showMessageDialog(null, "No tienes moneda de " + String.valueOf(value));
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
