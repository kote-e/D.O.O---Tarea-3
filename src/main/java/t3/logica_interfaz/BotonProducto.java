package t3.logica_interfaz;

import t3.logica_expendedor.Excepciones.ProductoNoSeleccionado;
import t3.logica_expendedor.Precios_Productos;
import t3.logica_expendedor.Producto;

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

            Producto prod = pExp.getExpendedor().getProducto();

            pExp.getComprador().addProducto(prod);
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
        labelProducto = switch (pExp.getComprado()){
            case COCACOLA -> scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/cocacola_90.png",40,-35,150,150);
            case SPRITE -> scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/sprite_90.png",45,-40,155,155);
            case FANTA -> scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/fanta_90.png",60,-35,150,150);
            case SNICKERS -> scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/snickers_90.png",100,-40,150,150);
            case SUPER8 -> scaledProducto("src/main/java/t3/logica_interfaz/Imagenes/super8_90.png",80,-35,130,130);
        };


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
