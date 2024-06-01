package t3.logica_interfaz;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Monedas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LlenarMonedas extends JFrame {
    private Comprador comprador;
    private int cant100 = 1;
    private int cant500 = 1;
    private int cant1000 = 1;
    private int cant1500 = 1;

    public LlenarMonedas(Comprador comprador) {
        super("Monedas");

        this.comprador = comprador;

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        // Agregar los deslizadores y las etiquetas a la ventana
        this.add(createSlider(1500,50,20,400,50));
        this.add(createSlider(1000,50,120,400,50));
        this.add(createSlider(500,50,220,400,50));
        this.add(createSlider(100,50,320,400,50));

        this.add(createButton("Confirmador"));

        this.setVisible(true);
    }

    private JPanel createSlider(int valor,int x, int y, int width, int height) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        JLabel label = new JLabel("Valor: 1");
        label.setBounds(x, y + height, width, 30);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("Valor: " + slider.getValue());
                switch (valor) {
                    case 100:
                        cant100 = slider.getValue();
                        break;
                    case 500:
                        cant500 = slider.getValue();
                        break;
                    case 1000:
                        cant1000 = slider.getValue();
                        break;
                    case 1500:
                        cant1500 = slider.getValue();
                        break;
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(x, y, width, height + 30);
        panel.add(slider, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);

        return panel;
    }

    private JButton createButton(String text) {
        JButton boton = new JButton(text);
        boton.setBounds(150, 400, 200, 50);
        boton.setText("Confirmar Monedas");
        boton.setFont(new Font("monospaced", Font.PLAIN, 12));
        boton.setForeground(Color.black);
        boton.setFocusable(true);
        boton.setToolTipText(text);
        boton.setBackground(new Color(0xE0FAFA));
        boton.setBorder(BorderFactory.createEtchedBorder());

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarMonedasComprador();
                dispose(); // Cerrar la ventana actual
                new Ventana(comprador.getExpendedor(),comprador); // Abrir la nueva ventana
            }
        });

        return boton;
    }

    private void agregarMonedasComprador(){
        for(int i=0;i<cant100;i++){
            comprador.addMonedas(new Moneda100());
        }
        for(int i=0;i<cant500;i++){
            comprador.addMonedas(new Moneda500());
        }
        for(int i=0;i<cant1000;i++){
            comprador.addMonedas(new Moneda1000());
        }
        for(int i=0;i<cant1500;i++){
            comprador.addMonedas(new Moneda1500());
        }
    }
}
