package t3.logica_interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import t3.logica_expendedor.Precios_Productos;

public class PanelExpendedor extends JPanel {
    public PanelExpendedor() {
        super();
        setBackground(new Color(0xf0f6ff));
        setBounds(400, 0, 850, 670);
        setLayout(null);

        //Se agregan los productos
        add(scaledProducto("cocacola.png",300,136,60,60));
        add(scaledProducto("sprite.png",224,138,90,90));
        add(scaledProducto("fanta.jpg",224,195,60,70));
        add(scaledProducto("snickers.png",184,305,40,70));
        add(scaledProducto("super8.png",225,305,60,60));

        //Se agregan los precios
        add(mostrarPrecios(Precios_Productos.COCACOLA,420,244,30,20));
        add(mostrarPrecios(Precios_Productos.SPRITE,420,260,30,20));
        add(mostrarPrecios(Precios_Productos.FANTA,420,273,30,20));
        add(mostrarPrecios(Precios_Productos.SNICKERS,420,289,30,20));
        add(mostrarPrecios(Precios_Productos.SUPER8,420,304,30,20));

        //Se agregan los botones para comprar los productos
        add(crearBotones("1",455,250,10,10));
        add(crearBotones("2",455,265,10,10));
        add(crearBotones("3",455,280,10,10));
        add(crearBotones("4",455,295,10,10));
        add(crearBotones("5",455,310,10,10));


        //Se carga, redimenciona y agrega la imagen de fondo del Expendedor
        ImageIcon originalExpendedorIcon = new ImageIcon("src/main/java/t3/resources/expendedor.jpg");
        Image originalExpendedorIconImage = originalExpendedorIcon.getImage();
        Image scaledExpendedorIconImage = originalExpendedorIconImage.getScaledInstance(600, 600, Image.SCALE_SMOOTH);
        ImageIcon expendedorIcon = new ImageIcon(scaledExpendedorIconImage);

        JLabel expendedorLabel = new JLabel(expendedorIcon);
        expendedorLabel.setBounds(0,0 , 670,670);

        add(expendedorLabel);
    }

    // Cargar y redimensionar la imagen del Producto
    private JLabel scaledProducto(String nombre, int x, int y, int width, int height){
        ImageIcon originalIcon = new ImageIcon("src/main/java/t3/resources/" + nombre);
        Image originalIconImage = originalIcon.getImage();
        Image scaledIconImage = originalIconImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon Icon = new ImageIcon(scaledIconImage);

        JLabel label = new JLabel(Icon);
        label.setBounds(x,y , 60,60);

        return label;
    }

    private JLabel mostrarPrecios(Precios_Productos nombre, int x, int y, int width, int height){
        JLabel precio = new JLabel("$" + nombre.getPrecio());
        precio.setForeground(new Color(0x000000));
        precio.setBounds(x,y,width,height);

        return precio;
    }

    private JButton crearBotones(String nombre, int x, int y, int width, int height){
        JButton button = new JButton(nombre);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Presionado " + nombre);     //Cambiar por la funcionalidad de comprar el producto
            }
        });
        button.setBounds(x,y,width,height);
        return button;
    }
}
