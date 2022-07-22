package Calculadora;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class EjemploCalculadora extends JFrame {

    JLabel display;
    JButton botones[] = new JButton[17];
    String textoBotones[] = {"Resultado","7","8","9","/","4","5","6","*","1","2","3","-","C","0",".","+"};
    int xBotones[] = {15,15,80,145,210,15,80,145,210,15,80,145,210,15,80,145,210};
    int yBotones[] = {90,155,155,155,155,220,220,220,220,285,285,285,285,350,350,350,350};
    int numerosBotones [] = {14, 9, 10, 11, 5, 6, 7, 1, 2, 3};
    int[]  operacionesBotones = {16,12,8,4};//Indice de los botnes de opeeraciones
    int anchoBoton = 50;
    int altoBoton = 50;
    int numBotones = 17;
    boolean nuevoNumero = true;
    boolean puntoDecimal = false;
    double operando1 = 0;
    double operando2 = 0;
    double resultado = 0;
    String operacion = "";


    public EjemploCalculadora(){

        initDisplay();
        initBotones();
        initPantalla();
        eventosNumeros();
        eventoDecimal();
        eventosOperaciones();
        eventoResultado();
        eventoLimpiar();
        resultado();
    }



    private void initDisplay() {

        display = new JLabel("0");
        display.setBounds(15,15,245,60);
        display.setOpaque(true);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.green);
        display.setBorder(new LineBorder(Color.DARK_GRAY));
        display.setFont(new Font("MONOSPACED",Font.PLAIN,24));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFocusable(true);
        add(display);
    }

    private void initBotones() {

        for(int i = 0; i < numBotones; i++){
            botones[i] = new JButton(textoBotones[i]);
            int ancho = (i == 0) ? 245 : anchoBoton;// Operador ternario (if else)
            botones[i].setBounds(xBotones[i], yBotones[i], ancho, altoBoton);
            botones[i].setFont(new Font("Monospaced",Font.PLAIN,16));
            botones[i].setOpaque(true);
            botones[i].setFocusPainted(false);
            botones[i].setBackground(Color.DARK_GRAY);
            botones[i].setBorder(new LineBorder(Color.DARK_GRAY));
            botones[i].setForeground(Color.WHITE);
            add(botones[i]);
        }
    }

    private void initPantalla() {

        setLayout(null);
        setTitle("Calculadora");
        setSize(290,450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }

    private void eventosNumeros() {

        for (int i = 0; i < 10; i++){
            int numBoton = numerosBotones[i];
            botones[numBoton].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Si es un nuevo numero y no es 0, sustituyo el valor del display
                    if (nuevoNumero){
                        if (!textoBotones[numBoton].equals("0")) {
                            display.setText(textoBotones[numBoton]);
                            nuevoNumero = false;
                        }
                    }
                    //Si no, lo añado a los digitos que ya hubiera
                    else {
                        display.setText(display.getText() + textoBotones[numBoton]);
                    }
                }
            });
        }
    }

    private void eventoDecimal() {

        botones[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Si es un nuevo numero, sustituyo el valor del display
                if (!puntoDecimal){
                    display.setText(display.getText() + textoBotones[15]);
                    nuevoNumero = false;
                    puntoDecimal = true;
                }
            }
        });
    }

    private void eventosOperaciones() {

        for (int i = 0;i < operacionesBotones.length;i++){
            int numBoton = operacionesBotones[i];
            botones[numBoton].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){


                    if (operacion.equals("")) {
                        operacion = textoBotones[numBoton];
                        operando2 = Double.parseDouble(display.getText());
                        System.out.println(operando2);
                        nuevoNumero = true;
                        puntoDecimal = false;
                        System.out.println(operando2 + " " + operacion);
                    }
                    else{
                        operando2 = resultado();
                        operacion = textoBotones[numBoton];
                    }
                    System.out.println(operando2 + " " + operacion + " " + operando1);
                }
            });
        }
    }

    private void eventoResultado() {

        botones[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                resultado();

            }
        });
    }

    private double resultado(){

        operando1 = Double.parseDouble(display.getText());
        switch (operacion){
            case "+": resultado = operando1 + operando2;
                break;
            case "-": resultado = operando2 - operando1;
                break;
            case "*": resultado = operando2 * operando1;
                break;
            case "/": resultado = operando2 / operando1;
                break;
        }

        //Formatear el resultado(que no salga x.0 en el resultado)
        Locale  localActual = Locale.GERMAN;//Libreria de signos alemana
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(localActual);
        simbolos.setDecimalSeparator('.');
        //Dar formato
        DecimalFormat formatoResultado = new DecimalFormat("#.######", simbolos);
        display.setText(String.valueOf(formatoResultado.format(resultado)));

        operando1 = 0;
        operando2 = 0;
        operacion = "";
        nuevoNumero = true;
        puntoDecimal = false;
        return  resultado;

    }

    private void eventoLimpiar() {
        botones[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("0");
               limpiar();
            }
        });
    }

    private void limpiar(){
        operando1 = operando2 = 0;
        resultado = 0;
        operacion = "";
        nuevoNumero = true;
        puntoDecimal = false;
    }


    public static void main(String[] args) {
        new EjemploCalculadora();
    }
}