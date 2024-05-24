package t3.logica_interfaz;

import t3.logica_expendedor.Monedas.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MonedaButton extends JButton implements ActionListener {
    int value = 0;

    public MonedaButton(int val, String file, int posX, int posY){
        value = val;

        ImageIcon buttonImg = new ImageIcon(file);
        this.setBounds(posX, posY, 85, 45);
        this.addActionListener(this);
        this.setIcon(buttonImg);
        this.setText(String.valueOf(val));
        this.setFont(new Font("monospaced", Font.PLAIN, 12));
        this.setForeground(Color.black);
        this.setFocusable(true);
        this.setToolTipText("text");
        this.setBackground(new Color(0xE0FAFA));
        this.setBorder(BorderFactory.createEtchedBorder());
        //this.setVerticalAlignment(JButton.CENTER);
        //this.setHorizontalAlignment(JButton.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this){
            System.out.println(String.valueOf(value));
        }
    }
}
