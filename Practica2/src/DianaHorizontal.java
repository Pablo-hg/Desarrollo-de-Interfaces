import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DianaHorizontal extends JFrame implements  ActionListener, MouseListener {

    //creamos los componenentes y variables
    private JSlider slider;
    public JLabel label1,label2;
    public int puntuacion;
    public JButton boton1, boton2, boton3, boton4;



    public DianaHorizontal() {

        //Configuro la ventana principal
        setLayout(null);
        setResizable(false);
        setBounds(10,10,600,350);
        setTitle("Diana Horizontal Pablo Horcajada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Configuro el Titulo
        label1 = new JLabel("Juego de la Diana Horizontal");
        label1.setBounds(40,40,450,30);
        add(label1);
        label1.setFont(new Font("MONOSPACED",Font.PLAIN,24));
        label1.setHorizontalAlignment(SwingConstants.RIGHT);

        //Configuro el texto
        label2 = new JLabel("Coloca el control donde tu quieras y elige el nivel");
        label2.setBounds(35,90,500,30);
        add(label2);
        label2.setFont(new Font("MONOSPACED",Font.PLAIN,15));
        label2.setHorizontalAlignment(SwingConstants.RIGHT);

        //Configuro el boton1
        boton1 = new JButton("1");
        boton1.setBounds(100, 150, 50,50);
        add(boton1);
        boton1.addActionListener( this);

        //Configuro el boton2
        boton2 = new JButton("2");
        boton2.setBounds(250, 150, 50,50);
        add(boton2);
        boton2.addActionListener( this);

        //Configuro el boton3
        boton3 = new JButton("3");
        boton3.setBounds(400, 150, 50,50);
        add(boton3);
        boton3.addActionListener(this);

        //Configuro el boton4
        boton4 = new JButton("Acerca de");
        boton4.setBounds(495,0,95,45);
        add(boton4);
        boton4.addActionListener( this);


        //Configuro el JSlider
        slider = new JSlider(0,100,0);
        slider.setBounds(135, 225, 300, 50);
        add(slider);
        slider.addMouseListener(this);
        //Pintamos los numeros
        slider.setPaintLabels(true);
        //slider.setSnapToTicks(true);
        //Ponemos que sean de 100 de 100  2 veces (el 0 y el 100)
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(2);

        //Hacemos visible todo
        setVisible(true);

    }

    public static void main (String[] args) {
        new DianaHorizontal();
    }

    @Override
    //creamos las acciones de los botones
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            slider.setBounds(250, 225, 60, 50);
        } else if (e.getSource() == boton2){
            slider.setBounds(125, 225, 300, 50);
        }else if (e.getSource() == boton3){
            slider.setBounds(-5, 225, 600, 50);
        } else if (e.getSource() == boton4) {
            Acercade acercade = new Acercade(this, true);
            acercade.setVisible(true);
        }
    }


    @Override
    //creamos las acciones de pulsar dentro del slider
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == slider){
            puntuacion = (int) (e.getX() * 100) / slider.getWidth();
            slider.setValue(puntuacion);
            Resultado resultado= new Resultado(this, true);
            resultado.setVisible(true);
        }
    }

    //Aunque no utlizemos el resto de acciones, se tiene que quedar vacias
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

