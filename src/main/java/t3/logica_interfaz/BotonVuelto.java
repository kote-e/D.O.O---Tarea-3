package t3.logica_interfaz;

import t3.logica_expendedor.Monedas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BotonVuelto extends JLabel implements MouseListener {
    private final PanelExpendedor pExpendedor;
    private PanelComprador pComprador;

    private ArrayList<JLabel> monedas100;
    private ArrayList<JLabel> monedas500;
    private ArrayList<JLabel> monedas1000;
    private ArrayList<JLabel> monedas1500;

    public BotonVuelto(PanelExpendedor pExp, int x, int y, int width, int height) {
        this.pExpendedor = pExp;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0x000000));
        this.setOpaque(true);
        this.addMouseListener(this);
        this.setToolTipText("Sacar vuelto");

        monedas100 = new ArrayList<>();
        monedas500 = new ArrayList<>();
        monedas1000 = new ArrayList<>();
        monedas1500 = new ArrayList<>();

        creacionMonedas();
    }

    public void mouseClicked(MouseEvent me) {;} // es llamado cuando el press y el release ocurren en el mismo pixel

    public void mousePressed(MouseEvent me) {
        try {
            Moneda moneda = pExpendedor.getExpendedor().getVuelto();
            pExpendedor.getComprador().addMonedas(moneda);
            pComprador.getCantMonedasLabel(moneda.getValor()).setCantidad(pExpendedor.getComprador().cantidadMonedas(moneda.getValor()));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {
        BotonVuelto lbl = (BotonVuelto) me.getComponent();
        lbl.setBackground(new Color(0x672222));

        //Imprime las monedas que estan dentro
        for(int i = 0; i<7; i++){this.add(monedas100.get(i));}
        for(int i = 0; i<7; i++){this.add(monedas500.get(i));}
        for(int i = 0; i<7; i++){this.add(monedas1000.get(i));}
        for(int i = 0; i<7; i++){this.add(monedas1500.get(i));}
    }

    public void mouseExited(MouseEvent me) {
        BotonVuelto lbl = (BotonVuelto) me.getComponent();
        lbl.setBackground(new Color(0x000000));

        //Elimina las monedas que estan dentro
        for(int i = 0; i<7; i++){this.remove(monedas100.get(i));}
        for(int i = 0; i<7; i++){this.remove(monedas500.get(i));}
        for(int i = 0; i<7; i++){this.remove(monedas1000.get(i));}
        for(int i = 0; i<7; i++){this.remove(monedas1500.get(i));}
    }

    public void setpComprador(PanelComprador pComprador) {this.pComprador = pComprador;}

    public void creacionMonedas(){     // 166 x 82
        JLabel monedaImg = null;
        for(int i=0;i<7;i++){   //Cantidad de monedas que se pueden mostrar en la salida del vuelto
            monedas100.add(scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_100.png",10,60 - i*10,20,20));
            monedas500.add(scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_500.png",50,60 - i*10,20,20));
            monedas1000.add(scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_1000.png",90,60 - i*10,20,20));
            monedas1500.add(scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",130,60 - i*10,20,20));
        }
    }

    private JLabel scaledProducto(String nombre, int x, int y, int width, int height){
        ImageIcon originalIcon = new ImageIcon(nombre);
        Image originalIconImage = originalIcon.getImage();
        Image scaledIconImage = originalIconImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledIconImage);

        JLabel label = new JLabel(Icon);
        label.setBounds(x,y , width,height);

        return label;
    }
}
