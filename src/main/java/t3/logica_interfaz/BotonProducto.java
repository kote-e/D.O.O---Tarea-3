package t3.logica_interfaz;

import t3.logica_expendedor.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.sound.sampled.Clip;

/**
 * La subclase BotonProducto es una extensión de JLabel e implementa MouseListener,
 *GeneradorImagen y Sonidos.
 * Representa un botón en la interfaz para sacar un producto al ser presionado
 * @see PanelExpendedor
 * @see PanelComprador
 */
public class BotonProducto extends JLabel implements MouseListener, GeneradorImagen, Sonidos {
    private final PanelExpendedor pExp;
    private PanelComprador panelComprador;
    private JLabel labelProducto = null;
    private final Clip abrirSonido;

    /**
     * Crea una instancia de BotonProducto
     * @param pExp El panel el expendedor asociado con el botón
     * @param panelComprador el panel del comprador asociado con este botón
     * @param x esta es la coordenada x donde se encuentra el botón en la pantall
     * @param y esta es la coordenada y donde se encuentra el botón en la pantalla
     * @param width este es el ancho del botón
     * @param height este es el alto del botón
     */
    public BotonProducto(PanelExpendedor pExp,PanelComprador panelComprador ,int x, int y, int width, int height) {
        this.pExp = pExp;
        this.panelComprador = panelComprador;
        this.setBounds(x,y,width,height);
        this.setBackground(new Color(0x000000));
        this.setOpaque(true);
        this.addMouseListener(this);
        this.setToolTipText("Sacar producto");

        abrirSonido = Sonidos.cargarSonido("src/main/java/t3/logica_interfaz/Sonidos/Abrir_Compuerta.wav");
    }

    /**
     * Este emtodo se utiliza al hacer el clic en el botón (press y release
     *ocurren en el mismo pixel)
     * @param me este es el evento del mouse
     */
    public void mouseClicked(MouseEvent me) {;}

    /**
     * Este metodo se utiliza al presionar el botón del mouse, intenta sacar un producto
     * y si algo sale mal, muestra un mensaje de error
     * @param me este es el evento del mouse
     */
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

    /**
     * Este metodo se utiliza cuando se deja de hacer clic al mouse
     * @param me este es el evento del mouse
     */
    public void mouseReleased(MouseEvent me) {;}

    /**
     * esto se utiliza cuando el mouse esta dento de del area del botón
     * @param me este es el evento del mouse
     */
    public void mouseEntered(MouseEvent me) {
        BotonProducto lbl = (BotonProducto) me.getComponent();
        lbl.setBackground(new Color(0x672222));
        if(labelProducto!=null){labelProducto.setVisible(true);}
        Sonidos.reproducirSonido(abrirSonido,() -> {});
    }

    /**
     * Esto se utiliza cuando el mouse sale del área del botón.
     * @param me Este es el evento del mouse.
     */
    public void mouseExited(MouseEvent me) {
        BotonProducto lbl = (BotonProducto) me.getComponent();
        lbl.setBackground(new Color(0x000000));
        if(labelProducto!=null){labelProducto.setVisible(false);}
    }

    /**
     * establece el panel del comprador
     * @param panelComprador este es el panel del comprador acociado al boton
     */
    public void setPanelComprador(PanelComprador panelComprador) {this.panelComprador = panelComprador;}

    /**
     * Crea y muestra una imagen que representa el producto seleccionado en el expendedor,
     * la imagen se carga y se posiciona de acuerdo al producto comprado
     *
     */
    public void impresionProducto(){
        labelProducto = switch (pExp.getComprado()){
            case COCACOLA -> GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/cocacola_90.png",40,-35,150,150);
            case SPRITE -> GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/sprite_90.png",45,-40,155,155);
            case FANTA -> GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/fanta_90.png",60,-35,150,150);
            case SNICKERS -> GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/snickers_90.png",100,-40,150,150);
            case SUPER8 -> GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/super8_90.png",80,-35,130,130);
        };
        this.add(labelProducto);
    }
}
