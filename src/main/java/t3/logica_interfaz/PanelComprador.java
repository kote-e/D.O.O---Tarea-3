package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel {
    public PanelComprador() {
        super();
        setBackground(new Color(0xceddf2));
        setBounds(0, 0, 400, 670);

        JLabel titulo = new JLabel("Comprador");
        add(titulo);
    }
}
