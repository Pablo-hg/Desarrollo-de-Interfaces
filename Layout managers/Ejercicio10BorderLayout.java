import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.WEST;

public class Ejercicio10BorderLayout extends JFrame {

    BorderLayout miBorderLayout;
    FlowLayout miFlowLayout;
    JPanel panelEste, panelOeste;
    JButton boton[];
    JLabel titulo, pie;
    JTextArea textArea;

    public Ejercicio10BorderLayout(){

        //JFrame
        miBorderLayout = new BorderLayout();
        setLayout(miBorderLayout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,800,600);

        //Título
        titulo = new JLabel("Este es el título");
        titulo.setPreferredSize(new Dimension(800,100));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        add(titulo, NORTH);

        //Pie
        pie = new JLabel("Este es el pie");
        pie.setPreferredSize(new Dimension(800,100));
        pie.setHorizontalAlignment(SwingConstants.CENTER);
        pie.setOpaque(true);
        pie.setBackground(Color.YELLOW);
        add(pie, SOUTH);

        //Textarea
        textArea = new JTextArea("Este es el Text Area");
        add(textArea, CENTER);

        //FlowLayout para los paneles Este y Oeste
        miFlowLayout = new FlowLayout(FlowLayout.CENTER, 5,5);

        //Panel Este
        panelEste = new JPanel();
        panelEste.setPreferredSize(new Dimension(100,400));
        panelEste.setLayout(miFlowLayout);
        add(panelEste, EAST);

        //Panel Oeste
        panelOeste = new JPanel();
        panelOeste.setPreferredSize(new Dimension(100,400));
        panelOeste.setLayout(miFlowLayout);
        add(panelOeste, WEST);

        //Botones
        boton = new JButton[10];
        for (int i=0; i<10; i++){
            boton[i] = new JButton("Botón " + (i+1));
            boton[i].setPreferredSize(new Dimension(90,66));
            if (i <= 4){
                panelOeste.add(boton[i]);
            }
            else{
                panelEste.add(boton[i]);
            }
        }


        //Muestro el JFrame
        setVisible(true);

    }

    public static void main(String[] args) {
        new Ejercicio10BorderLayout();
    }

}
