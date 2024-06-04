package t3.logica_interfaz;

import t3.logica_expendedor.Monedas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.sound.sampled.Clip;

/**
 * La subclase BotonVuelto es una extensión de JLabel e implementa MouseListener,
 * representa un botón que permite sacar el vuelto de la máquina expendedora y también
 * implementa GeneradorImagen y Sonidos
 * @author
 */
public class BotonVuelto extends JLabel implements MouseListener, GeneradorImagen, Sonidos {
    private final PanelExpendedor pExpendedor;
    private PanelComprador pComprador;

    private ArrayList<JLabel> monedas100;
    private ArrayList<JLabel> monedas500;
    private ArrayList<JLabel> monedas1000;
    private ArrayList<JLabel> monedas1500;

    private final Clip abrirSonido;

    /**
     * Crea una instancia de BotonVuelto
     * @param pExp este es panel del expendedor asociado con este botón
     * @param x esta es la coordenada x donde se encuentra el botón en la pantalla
     * @param y esta es la coordenada y donde se encuentra el botón en la pantalla
     * @param width este es el ancho del botón
     * @param height este es el alto del botón
     */
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

        abrirSonido = Sonidos.cargarSonido("src/main/java/t3/logica_interfaz/Sonidos/Abrir_Compuerta.wav");
    }

    /**
     * Método llamado cuando se hace clic en el botón (press y release
     * ocurren en el mismo píxel)
     * @param me este es el evento del mouse
     */
    public void mouseClicked(MouseEvent me) {;}

    /**
     * este es el método llamado cuando se presiona el botón del mouse y se intenta
     * sacar el vuelto de la máquina expendedora y actualizar el panel del comprador
     * @param me Este es el evento del mouse
     */
    public void mousePressed(MouseEvent me) {
        try {
            Moneda moneda = pExpendedor.getExpendedor().getVuelto();
            pExpendedor.getComprador().addMonedas(moneda);
            pComprador.getCantMonedasLabel(moneda.getValor()).setCantidad(pExpendedor.getComprador().cantidadMonedas(moneda.getValor()));
            ocultarMonedas();
            imprimirMonedas();
            this.repaint();     //Forzar que se refresque la imagen
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Método llamado cuando se deja de hacer clic en el mouse
     * @param me Este es el evento del mouse
     */
    public void mouseReleased(MouseEvent me) {;}

    /**
     * Este método es se utiliza cuando el mouse entra en el área del botón y cambia
     * el color del botón y muestra las monedas
     * @param me Este es el evento del mouse
     */
    public void mouseEntered(MouseEvent me) {
        BotonVuelto lbl = (BotonVuelto) me.getComponent();
        lbl.setBackground(new Color(0x672222));
        imprimirMonedas();
        Sonidos.reproducirSonido(abrirSonido, () -> {});
    }

    /**
     * este método se ocupa cuando el mouse sale del área del botón, cambia el color
     * del botón y oculta las monedas
     * @param me Este es el evento del mouse
     */
    public void mouseExited(MouseEvent me) {
        BotonVuelto lbl = (BotonVuelto) me.getComponent();
        lbl.setBackground(new Color(0x000000));
        ocultarMonedas();
    }

    /**
     * Establece el panel del comprador
     * @param pComprador el panel
     */
    public void setpComprador(PanelComprador pComprador) {this.pComprador = pComprador;}

    /**
     * crea las imagenes para mostrarlas en el panel
     */
    private void creacionMonedas(){     // 166 x 82
        for(int i=0;i<7;i++){   //Cantidad de monedas que se pueden mostrar en la salida del vuelto
            monedas100.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/moneda_100.png",10,60 - i*10,20,20));
            monedas500.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/moneda_500.png",50,60 - i*10,20,20));
            monedas1000.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/moneda_1000.png",90,60 - i*10,20,20));
            monedas1500.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/moneda_1500.png",130,60 - i*10,20,20));
        }
    }

    /**
     * Imprime las monedas en el panel según la cantidad de cada tipo de moneda
     */
    public void imprimirMonedas(){
        int cantidad = pExpendedor.getExpendedor().CantidadMonedasVuelto(100);
        if(cantidad >7){cantidad = 7;}
        for(int i = 0; i<cantidad; i++){this.add(monedas100.get(i));}

        cantidad = pExpendedor.getExpendedor().CantidadMonedasVuelto(500);
        if(cantidad >7){cantidad = 7;}
        for(int i = 0; i<cantidad; i++){this.add(monedas500.get(i));}

        cantidad = pExpendedor.getExpendedor().CantidadMonedasVuelto(1000);
        if(cantidad >7){cantidad = 7;}
        for(int i = 0; i<cantidad; i++){this.add(monedas1000.get(i));}

        cantidad = pExpendedor.getExpendedor().CantidadMonedasVuelto(1500);
        if(cantidad >7){cantidad = 7;}
        for(int i = 0; i<cantidad; i++){this.add(monedas1500.get(i));}
    }

    /**
     * occulta las monedad
     */
    public void ocultarMonedas(){
        for(int i = 0; i<7; i++){this.remove(monedas100.get(i));}
        for(int i = 0; i<7; i++){this.remove(monedas500.get(i));}
        for(int i = 0; i<7; i++){this.remove(monedas1000.get(i));}
        for(int i = 0; i<7; i++){this.remove(monedas1500.get(i));}
    }
}
