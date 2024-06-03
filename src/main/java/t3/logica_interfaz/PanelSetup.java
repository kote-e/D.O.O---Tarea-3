package t3.logica_interfaz;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

import t3.logica_expendedor.Comprador;
import t3.logica_expendedor.Monedas.*;

public class PanelSetup extends JPanel implements ChangeListener {

    // inicializar variables
    private Comprador comprador;

    private JSpinner compradorMonedas100;
    private JSpinner compradorMonedas500;
    private JSpinner compradorMonedas1000;
    private JSpinner compradorMonedas1500;

    private int cantMonedas100;
    private int cantMonedas500;
    private int cantMonedas1000;
    private int cantMonedas1500;

    public PanelSetup(Comprador cmp, Ventana frame) {
        comprador = cmp;


        JPanel setupPanel = new JPanel();

        setupPanel.setLayout(new GridLayout(0, 2, 2, 2));
        setupPanel.setBounds(0, 0, 500, 500);

        compradorMonedas100 = new JSpinner();
        compradorMonedas500 = new JSpinner();
        compradorMonedas1000 = new JSpinner();
        compradorMonedas1500 = new JSpinner();

        compradorMonedas100.setBounds(70, 20, 50, 40);
        compradorMonedas500.setBounds(70, 50, 50, 40);
        compradorMonedas1000.setBounds(70, 80, 50, 40);
        compradorMonedas1500.setBounds(70, 110, 50, 40);

        compradorMonedas100.addChangeListener(this);
        compradorMonedas500.addChangeListener(this);
        compradorMonedas1000.addChangeListener(this);
        compradorMonedas1500.addChangeListener(this);

        // agregar los spinners al panel
        setupPanel.add(new JLabel("Monedas de 1500"));
        setupPanel.add(compradorMonedas1500);
        setupPanel.add(new JLabel("Monedas de 1000"));
        setupPanel.add(compradorMonedas1000);
        setupPanel.add(new JLabel("Monedas de 500"));
        setupPanel.add(compradorMonedas500);
        setupPanel.add(new JLabel("Monedas de 100"));
        setupPanel.add(compradorMonedas100);



        int option = JOptionPane.showConfirmDialog(frame, setupPanel, "Ingresar cantidad de monedas del comprador", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {

            // establecer limites de cantidad entre [0,100]

            if (cantMonedas100 < 0) {
                cantMonedas100 = 0;
            } else if (cantMonedas100 > 100) {
                cantMonedas100 = 100;
            }

            if (cantMonedas500 < 0) {
                cantMonedas500 = 0;
            } else if (cantMonedas500 > 100) {
                cantMonedas500 = 100;
            }

            if (cantMonedas1000 < 0) {
                cantMonedas1000 = 0;
            } else if (cantMonedas1000 > 100) {
                cantMonedas1000 = 100;
            }

            if (cantMonedas1500 < 0) {
                cantMonedas1500 = 0;
            } else if (cantMonedas1500 > 100) {
                cantMonedas1500 = 100;
            }


            // agregar monedas al comprador
            for (int i = 0; i < cantMonedas100; i++) {
                Moneda m100 = new Moneda100();
                comprador.addMonedas(m100);
            }

            for (int j = 0; j < cantMonedas500; j++) {
                Moneda m = new Moneda500();
                comprador.addMonedas(m);
            }

            for (int k = 0; k < cantMonedas1000; k++) {
                Moneda m = new Moneda1000();
                comprador.addMonedas(m);
            }

            for (int l = 0; l < cantMonedas1500; l++) {
                Moneda m = new Moneda1500();
                comprador.addMonedas(m);
            }
        } else {
            // en el caso de apretar cancel poner 5 monedas de cada una al comprador
            for (int i = 0; i < 5; i++) {
                Moneda m100 = new Moneda100();
                comprador.addMonedas(m100);

                Moneda m500 = new Moneda500();
                comprador.addMonedas(m500);

                Moneda m1000 = new Moneda1000();
                comprador.addMonedas(m1000);

                Moneda m1500 = new Moneda1500();
                comprador.addMonedas(m1500);
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        // guardar cantidad de monedas
        if(e.getSource() == compradorMonedas100){
            String value100 = compradorMonedas100.getValue() + "";
            cantMonedas100 = Integer.parseInt(value100);

        } else if(e.getSource() == compradorMonedas500){
            String value500 = compradorMonedas500.getValue() + "";
            cantMonedas500 = Integer.parseInt(value500);

        } else if(e.getSource() == compradorMonedas1000){
            String value1000 = compradorMonedas1000.getValue() + "";
            cantMonedas1000 = Integer.parseInt(value1000);

        } else if(e.getSource() == compradorMonedas1500){
            String value1500 = compradorMonedas1500.getValue() + "";
            cantMonedas1500 = Integer.parseInt(value1500);
        }
    }
}
