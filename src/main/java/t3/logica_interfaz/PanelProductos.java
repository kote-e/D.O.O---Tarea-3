package t3.logica_interfaz;

import t3.logica_expendedor.Precios_Productos;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * La clase PanelProductos es una extensión de JPanel que representa los productos en
 * la interfaz gráfica de la máquina expendedora
 * @author Antonio Benavides
 */
public class PanelProductos extends JPanel implements GeneradorImagen{
    private final PanelExpendedor pExpendedor;
    private final ArrayList<JLabel> Cocacola;
    private final ArrayList<JLabel> Sprite;
    private final ArrayList<JLabel> Fanta;
    private final ArrayList<JLabel> Snickers;
    private final ArrayList<JLabel> Super8;

    /**
     * este es un constructor para iniciar el panel de productos
     * @param pExpendedor este es el panel expendedor
     */
    public PanelProductos(PanelExpendedor pExpendedor) {
        this.pExpendedor = pExpendedor;

        Cocacola = new ArrayList<>();
        Sprite = new ArrayList<>();
        Fanta = new ArrayList<>();
        Snickers = new ArrayList<>();
        Super8 = new ArrayList<>();

        setOpaque(false);
        setBounds(60, 90, 850, 670);
        setLayout(null);
        this.setLayout(null);

        creacionProductos();
        imprimirProductos();

        //Se agregan los precios
        add(mostrarPrecios(Precios_Productos.COCACOLA,60,160,30,20));
        add(mostrarPrecios(Precios_Productos.SPRITE,170,160,30,20));
        add(mostrarPrecios(Precios_Productos.FANTA,270,160,30,20));
        add(mostrarPrecios(Precios_Productos.SNICKERS,60,335,30,20));
        add(mostrarPrecios(Precios_Productos.SUPER8,165,335,30,20));
    }

    /**
     * se crea un JLabel para mostrar el precio del producto
     * @param nombre tipo de producto
     * @param x esta es la coordenada x donde se encuentra el JLabel
     * @param y esta es la coordenada y donde se encuentra el JLabel
     * @param width este es el ancho del JLabel
     * @param height este es el alto del JLabel
     * @return un JLabel con el precio del producto
     */
    private JLabel mostrarPrecios(Precios_Productos nombre, int x, int y, int width, int height){
        JLabel precio = new JLabel("$" + nombre.getPrecio());
        precio.setForeground(new Color(0x000000));
        precio.setBounds(x,y,width,height);

        return precio;
    }

    /**
     * crea y añade etiquetas de imagenes de los productos
     */
    private void creacionProductos(){     // 166 x 82
        for(int i=0;i<5;i++){   //Cantidad de productos que se pueden mostrar en la salida del vuelto
            Cocacola.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/CocaCola.png",5,25 - i*7,150,140));
            Sprite.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/sprite.png",110,25 - i*7,150,140));
            Fanta.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/fanta.png",210,20 - i*7,150,140));
            Snickers.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/snickers.png",-5,195 - i*10,160,160));
            Super8.add(GeneradorImagen.ImageLabel("src/main/java/t3/logica_interfaz/Imagenes/super8.png",93,205 - i*10,160,160));
        }
    }

    /**
     * imprime los productos disponibles
     */
    public void imprimirProductos(){
        int cantidad = pExpendedor.getExpendedor().CantidadProductoDentro(Precios_Productos.COCACOLA);
        if(cantidad >5){cantidad = 5;}
        for(int i = 0; i<cantidad; i++){this.add(Cocacola.get(i));}

        cantidad = pExpendedor.getExpendedor().CantidadProductoDentro(Precios_Productos.SPRITE);
        if(cantidad >5){cantidad = 5;}
        for(int i = 0; i<cantidad; i++){this.add(Sprite.get(i));}

        cantidad = pExpendedor.getExpendedor().CantidadProductoDentro(Precios_Productos.FANTA);
        if(cantidad >5){cantidad = 5;}
        for(int i = 0; i<cantidad; i++){this.add(Fanta.get(i));}

        cantidad = pExpendedor.getExpendedor().CantidadProductoDentro(Precios_Productos.SNICKERS);
        if(cantidad >5){cantidad = 5;}
        for(int i = 0; i<cantidad; i++){this.add(Snickers.get(i));}

        cantidad = pExpendedor.getExpendedor().CantidadProductoDentro(Precios_Productos.SUPER8);
        if(cantidad >5){cantidad = 5;}
        for(int i = 0; i<cantidad; i++){this.add(Super8.get(i));}

        this.repaint();
    }

    /**
     * oculta los productos
     */
    public void ocultarProductos(){
        for(int i = 0; i<5; i++){this.remove(Cocacola.get(i));}
        for(int i = 0; i<5; i++){this.remove(Sprite.get(i));}
        for(int i = 0; i<5; i++){this.remove(Fanta.get(i));}
        for(int i = 0; i<5; i++){this.remove(Snickers.get(i));}
        for(int i = 0; i<5; i++){this.remove(Super8.get(i));}
    }
}
