import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class Ejercicio11CardLayout extends JFrame {

    BorderLayout miBorderLayout;
    FlowLayout miFlowLayout;
    CardLayout miCardLayout;
    JPanel panelOeste, panelCentro, panelTarjeta1, panelTarjeta2, panelTarjeta3;
    JButton botonAnterior, botonTarjeta1, botonTarjeta2, botonTarjeta3, botonSiguiente;
    JLabel titulo, pie, texto1, texto2, texto3;

    public Ejercicio11CardLayout(){

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

        //FlowLayout para el panel Oeste
        miFlowLayout = new FlowLayout(FlowLayout.CENTER, 5,5);

        //Panel Oeste
        panelOeste = new JPanel();
        panelOeste.setPreferredSize(new Dimension(100,400));
        panelOeste.setLayout(miFlowLayout);
        add(panelOeste, WEST);

        //CardLayout para el panel de tarjetas
        miCardLayout = new CardLayout();
        panelCentro = new JPanel();
        panelCentro.setLayout(miCardLayout);

        //Tarjetas del panel
        panelTarjeta1 = new JPanel();
        panelTarjeta2 = new JPanel();
        panelTarjeta3 = new JPanel();
        panelTarjeta1.setBackground(Color.GREEN);
        panelTarjeta2.setBackground(Color.BLUE);
        panelTarjeta3.setBackground(Color.ORANGE);

        //Labels de cada tarjeta
        texto1 = new JLabel("Esta es la tarjeta 1");
        texto1.setHorizontalAlignment(SwingConstants.CENTER);
        panelTarjeta1.add(texto1);
        texto2 = new JLabel("Esta es la tarjeta 2");
        texto2.setHorizontalAlignment(SwingConstants.CENTER);
        panelTarjeta2.add(texto2);
        texto3 = new JLabel("Esta es la tarjeta 3");
        texto3.setHorizontalAlignment(SwingConstants.CENTER);
        panelTarjeta3.add(texto3);

        //Añado esas tarjetas al panel de tarjetas
        panelCentro.add(panelTarjeta1,"Tarjeta 1");
        panelCentro.add(panelTarjeta2,"Tarjeta 2");
        panelCentro.add(panelTarjeta3,"Tarjeta 3");

        //Añado el panel de tarjetas al centro JFrame
        add(panelCentro, CENTER);

        //Botones
        crearBotones();

        //Muestro el JFrame
        setVisible(true);

    }

    private void crearBotones(){

        //Boton anterior
        botonAnterior = new JButton("Anterior");
        botonAnterior.setPreferredSize(new Dimension(90,66));
        panelOeste.add(botonAnterior);
        botonAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Voy a la tarjeta anterior
                miCardLayout.previous(panelCentro);
            }
        });

        //Boton tarjeta 1
        botonTarjeta1 = new JButton("Tarjeta 1");
        botonTarjeta1.setPreferredSize(new Dimension(90,66));
        panelOeste.add(botonTarjeta1);
        botonTarjeta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Voy a la tarjeta 1
                miCardLayout.show(panelCentro,"Tarjeta 1");
            }
        });

        //Boton tarjeta 2
        botonTarjeta2 = new JButton("Tarjeta 2");
        botonTarjeta2.setPreferredSize(new Dimension(90,66));
        panelOeste.add(botonTarjeta2);
        botonTarjeta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Voy a la tarjeta 2
                miCardLayout.show(panelCentro,"Tarjeta 2");
            }
        });

        //Boton tarjeta 3
        botonTarjeta3 = new JButton("Tarjeta 3");
        botonTarjeta3.setPreferredSize(new Dimension(90,66));
        panelOeste.add(botonTarjeta3);
        botonTarjeta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Voy a la tarjeta 3
                miCardLayout.show(panelCentro,"Tarjeta 3");
            }
        });

        //Boton siguiente
        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setPreferredSize(new Dimension(90,66));
        panelOeste.add(botonSiguiente);
        botonSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Voy a la tarjeta siguiente
                miCardLayout.next(panelCentro);
            }
        });

    }

    public static void main(String[] args) {
        new Ejercicio11CardLayout();
    }

}
