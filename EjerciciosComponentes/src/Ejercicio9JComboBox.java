

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*Crear un formulario con 3 JComboBox con valores entre 0 y 255 y etiquetas R, G y B.
 Al pulsar en un botón, el fondo del JFrame debe ser del color seleccionado en los 3
  JComboBox en formato RGB. Para añadir ítems a los JComboBox, necesitarás la expresión
  String.valueOf(num), y para luego convertir el valor seleccionado a entero,
   Integer.parseInt(string). Un nuevo color en formato RGB se añade con la expresión
   new Color(r,g,b), donde r,g y b son de tipo int. Modifica ahora el ejercicio para
   que permita introducir también los colores en un jTextField en formato hexadecimal
   (6 dígitos), de modo que además de cambiar el color, si se introduce en RGB aparezca
   el resultado en Hex y viceversa.
 */
public class Ejercicio9JComboBox extends JFrame implements ItemListener {


    private JComboBox combo1,combo2,combo3;
    private JButton boton1,boton2;
    String red,green,blue;
    private JLabel hex;
    private JTextField hextextfield;
    String numero;

    public Ejercicio9JComboBox() {

        setLayout(null);

        //Añado el ComboBox con sus items y su ItemListener, así como la etiqueta
        combo1=new JComboBox();
        combo1.setBounds(10,10,80,20);
        add(combo1);

        combo2=new JComboBox();
        combo2.setBounds(10,40,80,20);
        add(combo2);

        combo3=new JComboBox();
        combo3.setBounds(10,70,80,20);
        add(combo3);

        hex=new JLabel("Hex :    #");
        hex.setBounds(10,100,80,30);
        add(hex);

        for (int i = 0; i <= 255;i++){
            numero = String.valueOf(i);
            combo1.addItem(numero);
            combo2.addItem(numero);
            combo3.addItem(numero);
        }
        combo1.addItemListener(this);
        combo2.addItemListener(this);
        combo3.addItemListener(this);

        hextextfield = new JTextField();
        hextextfield.setBounds(60,105,80,20);
        add(hextextfield);

        boton1 = new JButton("Pintar RGB");
        boton1.setBounds(150,20,100,50);
        add(boton1);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hextextfield.getText().equals("")) {
                    int red1 = Integer.parseInt(red);
                    int green1 = Integer.parseInt(green);
                    int blue1 = Integer.parseInt(blue);
                    getContentPane().setBackground(new Color(red1, green1, blue1));
                }
                else {//Vamos a suponer que escribe el numero bien
                    String colorHex = hextextfield.getText();
                    String rHex = colorHex.substring(0,2);
                    String gHex = colorHex.substring(2,4);
                    String bHex = colorHex.substring(4,6);
                    red = String.valueOf(Integer.parseInt(rHex,16));
                    green = String.valueOf(Integer.parseInt(gHex,16));
                    blue = String.valueOf(Integer.parseInt(bHex,16));
                    int red1 = Integer.parseInt(red);
                    int green1 = Integer.parseInt(green);
                    int blue1 = Integer.parseInt(blue);
                    getContentPane().setBackground(new Color(red1,green1,blue1));

                }
            }
        });
        boton2 = new JButton("Pintar Hexadecimal");
        boton2.setBounds(100,80,150,20);
        add(boton2);
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hextextfield.getText().equals("")) {
                    int red1 = Integer.parseInt(red);
                    int green1 = Integer.parseInt(green);
                    int blue1 = Integer.parseInt(blue);
                    getContentPane().setBackground(new Color(red1, green1, blue1));

                }
            }
        });
    }

    public static void main(String[] args) {

        Ejercicio9JComboBox formularioCombobox = new Ejercicio9JComboBox();
        formularioCombobox.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formularioCombobox.setBounds(0,0,300,200);
        formularioCombobox.setVisible(true);

    }

    //Implemento el método itemStateChanged
    @Override
    public void itemStateChanged(ItemEvent e) {

        //String texto = "Color seleccionado:  ";
        if (e.getSource() == combo1) {
             red = (String) combo1.getSelectedItem();

        }
        if (e.getSource() == combo2) {
            green = (String) combo2.getSelectedItem();
        }
        if (e.getSource() == combo3) {
            blue = (String) combo3.getSelectedItem();
        }

    }
}
