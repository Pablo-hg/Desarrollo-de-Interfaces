import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;


/*Confeccionar una ventana que contenga tres objetos de la clase JButton
 con las etiquetas "Pulsa o teclea 1", "Pulsa o teclea 2" y "Pulsa o teclea 3"
  y un display de tipo JLabel. Al presionarse cualquiera de los botones
  o pulsar en el teclado 1, 2 o 3 debe cambiar el texto del JLabel con los números correspondientes.
  Además, al pasar por encima de cada botón debe cambiar el color de fondo del mismo. Por último,
  un cuarto botón con el texto "limpiar display" (o pulsar la letra "c") debe vaciar el texto del JLabel display.*/

public class Ejemplo3 extends JFrame {


    JLabel display;//el label es una subventana
    JButton boton1, boton2, boton3, botonlimpiar;

    public Ejemplo3(){

        //Iniciar display
        initDisplay();
        //Iniciar botones
        initBotones();
        //Iniciar acciones
        initAciones();
        //Iniciar los hover(ratoón pasa por encimade un elemento)
        initHovers();
        //Iniciar una pantalla (JFrame), se crea al final
        initPantalla();

    }

    void initDisplay(){

        //Propiedades y estilos del display
        display = new JLabel("");
        display.setBounds(15,15,195,60);
        display.setOpaque(true); //Hago el elemento opaco para poder darle un color de fondo
        display.setBackground(Color.BLACK); //Color de fondo
        display.setForeground(Color.GREEN); //Color de fuente
        display.setBorder(new LineBorder(Color.DARK_GRAY)); //Borde del display
        display.setFont(new Font("MONOSPACED",Font.PLAIN,24)); //Tipo de fuente
        display.setHorizontalAlignment(SwingConstants.RIGHT); //Alinear texto a la derecha
        display.setFocusable(true); //Permito que el JLabel pueda tener el foco
        add(display); //Añado el elemento al JFrame

        //Eventos de entrada del teclado
        display.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String ch = String.valueOf(e.getKeyChar()); //Me devuelve el valor de tecla
                if ("1".equals(ch) || "2".equals(ch) || "3".equals(ch)){
                    display.setText(display.getText() + ch); //Añado el texto al display
                }

            }
        });
    }

    void initBotones(){

        boton1 = new JButton("Pulsa o tecla el 1");
        boton2 = new JButton("Pulsa o tecla el 2");
        boton3 = new JButton("Pulsa o tecla el 3");
        botonlimpiar = new JButton("Limpiar display");

        boton1.setBounds(15,90,195,50);
        boton2.setBounds(15,155,195,50);
        boton3.setBounds(15,220,195,50);
        botonlimpiar .setBounds(15,285,195,50);

        boton1.setFont(new Font("MONOSPACE", Font.PLAIN,16));
        boton2.setFont(new Font("MONOSPACE", Font.PLAIN,16));
        boton3.setFont(new Font("MONOSPACE", Font.PLAIN,16));
        botonlimpiar.setFont(new Font("MONOSPACE", Font.PLAIN,16));

        boton1.setOpaque(true);
        boton2.setOpaque(true);
        boton3.setOpaque(true);
        botonlimpiar.setOpaque(true);

        boton1.setFocusPainted(false);//le quito el marco azul que sale al hacer foco en el boton
        boton1.setBackground(Color.darkGray);
        boton1.setBorder(new LineBorder(Color.darkGray));
        boton1.setForeground(Color.white);

        boton2.setFocusPainted(false);//le quito el marco azul que sale al hacer foco en el boton
        boton2.setBackground(Color.darkGray);
        boton2.setBorder(new LineBorder(Color.darkGray));
        boton2.setForeground(Color.white);

        boton3.setFocusPainted(false);//le quito el marco azul que sale al hacer foco en el boton
        boton3.setBackground(Color.darkGray);
        boton3.setBorder(new LineBorder(Color.darkGray));
        boton3.setForeground(Color.white);

        botonlimpiar.setFocusPainted(false);//le quito el marco azul que sale al hacer foco en el boton
        botonlimpiar.setBackground(Color.darkGray);
        botonlimpiar.setBorder(new LineBorder(Color.darkGray));
        botonlimpiar.setForeground(Color.white);

        add(boton1);
        add(boton2);
        add(boton3);
        add(botonlimpiar);

    }

    void initAciones(){
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Recupero el texto del display y le añado un 1
                display.setText(display.getText() + "1");
                display.requestFocus();//devuelvo el foco al display para poder utilizar las teclas
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Recupero el exto del display y le añado un 2
                display.setText(display.getText() + "2");
                display.requestFocus();
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Recupero el exto del display y le añado un 3
                display.setText(display.getText() + "3");
                display.requestFocus();
            }
        });

        botonlimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //dejo vacio el display
                display.setText("");
                display.requestFocus();
            }
        });



    }

    void initHovers(){

        //que se ponga verde cuando pase por encima del boton limpiar el raton

        botonlimpiar.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                botonlimpiar.setBackground(Color.green);
                botonlimpiar.setBorder(new LineBorder(Color.green));
                botonlimpiar.setForeground(Color.darkGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonlimpiar.setBackground(Color.darkGray);
                botonlimpiar.setBorder(new LineBorder(Color.darkGray));
                botonlimpiar.setForeground(Color.white);

            }
        });

        //que se ponga verde cuando pase por encima del boton1 el raton
        boton1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                boton1.setBackground(Color.green);
                boton1.setForeground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton1.setForeground(Color.white);
                boton1.setBackground(Color.darkGray);
            }
        });

        //que se ponga verde cuando pase por encima del boton2 el raton
        boton2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                boton2.setBackground(Color.green);
                boton2.setBorder(new LineBorder(Color.green));
                boton2.setForeground(Color.darkGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton2.setBackground(Color.darkGray);
                boton2.setBorder(new LineBorder(Color.darkGray));
                boton2.setForeground(Color.white);

            }
        });

        //que se ponga verde cuando pase por encima del boton3 el raton
        boton3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                boton3.setBackground(Color.green);
                boton3.setBorder(new LineBorder(Color.green));
                boton3.setForeground(Color.darkGray);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton3.setBackground(Color.darkGray);
                boton3.setBorder(new LineBorder(Color.darkGray));
                boton3.setForeground(Color.white);

            }
        });

    }

    void initPantalla(){

        setTitle("Ejemplo3");//Pongo el titulo a la ventana
        setBounds(0,0,240,390);//Tamaño a la ventana y posicion en la pantalla
        //setSize(240,275);//Tamaño de la ventana
        setResizable(false);//Impido que la ventana se pueda remiensionar
        setLayout(null);//Utilizo Layout absoluto
        getContentPane().setBackground(Color.BLACK);//Fondo de la ventana de color negrto
        setDefaultCloseOperation(EXIT_ON_CLOSE);//Al cerrar la ventana, cieero el proceso
        setVisible(true);//muestro la ventana

    }

    public static void main (String[] args){
        new Ejemplo3();
    }

}

