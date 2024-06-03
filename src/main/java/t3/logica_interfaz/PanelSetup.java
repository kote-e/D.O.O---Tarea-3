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

    private int cantMonedas100 = 5;
    private int cantMonedas500 = 5;
    private int cantMonedas1000 = 5;
    private int cantMonedas1500 = 5;

    public PanelSetup(Comprador cmp, Ventana frame) {
        comprador = cmp;

        JPanel setupPanel = new JPanel();


        setupPanel.setLayout(new GridLayout(0, 2, 2, 2));
        setupPanel.setBounds(0, 0, 500, 500);

        SpinnerNumberModel model100 = new SpinnerNumberModel(5, 0, 100, 1);
        SpinnerNumberModel model500 = new SpinnerNumberModel(5, 0, 100, 1);
        SpinnerNumberModel model1000 = new SpinnerNumberModel(5, 0, 100, 1);
        SpinnerNumberModel model1500 = new SpinnerNumberModel(5, 0, 100, 1);

        compradorMonedas100 = new JSpinner(model100);
        compradorMonedas500 = new JSpinner(model500);
        compradorMonedas1000 = new JSpinner(model1000);
        compradorMonedas1500 = new JSpinner(model1500);

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


        int option = JOptionPane.showConfirmDialog(frame, setupPanel, "Ingresar cantidad de monedas del comprador", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            // agregar monedas al comprador
            for (int i = 0; i < cantMonedas100; i++) {comprador.addMonedas(new Moneda100());}

            for (int j = 0; j < cantMonedas500; j++) {comprador.addMonedas(new Moneda500());}

            for (int k = 0; k < cantMonedas1000; k++) {comprador.addMonedas(new Moneda1000());}

            for (int l = 0; l < cantMonedas1500; l++) {comprador.addMonedas(new Moneda1500());}

        } else if(option == JOptionPane.CLOSED_OPTION){

            System.exit( 0 );

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
