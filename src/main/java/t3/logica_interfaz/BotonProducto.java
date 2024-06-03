package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class BotonProducto extends JLabel implements MouseListener {
    private final PanelExpendedor pExp;
    private PanelComprador panelComprador;
    private JLabel labelProducto = null;

    public BotonProducto(PanelExpendedor pExp,PanelComprador panelComprador ,int x, int y, int width, int height) {
        this.pExp = pExp;
        this.panelComprador = panelComprador;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0x000000));
        this.setOpaque(true);
        this.addMouseListener(this);
        this.setToolTipText("Sacar producto");
    }

    public void mouseClicked(MouseEvent me) {;}

    public void mousePressed(MouseEvent me) {
        try{
            pExp.getComprador().addProducto(pExp.getExpendedor().getProducto());
            panelComprador.getProductosUsuarioLabel(pExp.getComprado()).setCantidad(pExp.getComprador().cantidadProducto(pExp.getComprado()));
            pExp.getLetrero().cambiarTextoLetrero("Sacar Producto");
            pExp.setComprado(null);

            labelProducto.setVisible(false);
            this.remove(labelProducto);
            labelProducto = null;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"No hay ningún producto");
        }
}

    public void mouseReleased(MouseEvent me) {;}

    public void mouseEntered(MouseEvent me) {
        BotonProducto lbl = (BotonProducto) me.getComponent();
        lbl.setBackground(new Color(0x672222));
        if(labelProducto!=null){
            labelProducto.setVisible(true);
        }

    }

    public void mouseExited(MouseEvent me) {
        BotonProducto lbl = (BotonProducto) me.getComponent();
        lbl.setBackground(new Color(0x000000));
        if(labelProducto!=null){
            labelProducto.setVisible(false);
        }
    }

    public void setPanelComprador(PanelComprador panelComprador) {this.panelComprador = panelComprador;}

    public void impresionProducto(){
        String producto = switch (pExp.getComprado()){
            case COCACOLA -> "src/main/java/t3/logica_interfaz/Imagenes/CocaCola.png";
            case SPRITE -> "src/main/java/t3/logica_interfaz/Imagenes/sprite.png";
            case FANTA -> "src/main/java/t3/logica_interfaz/Imagenes/fanta.png";
            case SNICKERS -> "src/main/java/t3/logica_interfaz/Imagenes/snickers.png";
            case SUPER8 -> "src/main/java/t3/logica_interfaz/Imagenes/super8.png";
        };

        labelProducto = scaledProducto(producto,10,2,100,80);
        this.add(labelProducto);
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
