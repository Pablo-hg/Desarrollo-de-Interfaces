
import javax.annotation.processing.RoundEnvironment;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Calculadora extends JFrame {

    //Creamos la ventana
    JLabel display;
    JLabel display2;
    //Creamos 22 botones
    JButton botones[] = new JButton[22];
    //Creamos un array con el texto que irá dentro de cada boton según su posicion
    //Para que me capte el 1/x y el +/- meto un espacio justo para que no me llame a los dos botones que empiezan igual que ellos
    String textoBotones[] = {"√x","7","8","9","/","x^(2)"," 1/x","4","5","6","*","-","x^(y)","1","2","3","+","="," +/-","C","0","."};
    //Margen horizontal de los botones
    int xBotones[] = {25,95,165,235,305,375,25,95,165,235,305,375,25,95,165,235,305,375,25,95,165,235,305,375};
    //Margen vertical de los botones
    int yBotones[] = {115,115,115,115,115,115,175,175,175,175,175,175,235,235,235,235,235,235,295,295,295,295};
    //Posicion de los botones que son "numeros" en el array "TextoBotones"
    int numerosBotones [] = {1,2,3,7,8,9,13,14,15,20};
    //Posicion de los botones que son "operaciones" en el array "TextoBotones
    int[] operacionesBotones = {0,4,5,6,10,11,12,16,17,18};

    //Ancho y alto de los botones
    int anchoBoton = 62;
    int altoBoton = 50;
    //Numero total de botones
    int numBotones = 22;
    //Creamos unas variables que afectáran al "." y si hay un 0 al principio
    boolean nuevoNumero = true;
    boolean puntoDecimal = false;
    //Inicializamos los operandosy  el resultado en 0
    double operando1 = 0;
    double operando2 = 0;
    double resultado = 0;
    //Inicializamos el texto de la operacion en vacio
    String operacion = "";

    //Creamos todos los eventos que vamos a usar
    public Calculadora(){

        initDisplay();
        initDisplayop();
        initBotones();
        initPantalla();
        initHovers();
        initColores();
        eventosTeclas();
        eventosNumeros();
        eventoDecimal();
        eventosOperaciones();
        eventoResultado();
        eventoLimpiar();
        resultado();
    }

    //Evento que ajusta las caracteristicas de la ventana
    private void initPantalla() {

        setLayout(null); //Mostramos el contenido
        setTitle("Calculadora"); //Le ponemos un tirulo a la ventana
        setSize(475,400); //Ajustamos el ancho y el alto
        setResizable(false); //Hacemos la ventana fija
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Finalizamos operacion al cerrar la ventana
        getContentPane().setBackground(new Color(232,245,255)); //le ponemos un color de fondo
        setVisible(true); //Hacemos la ventana visible

    }

    //Método que ajusta las caracterisicas del JLabel(donde se muesta los numeros y el resultado)
    private void initDisplay() {

        display = new JLabel("0"); //Inicialiamoss el texto en 0
        display.setBounds(25,10,410,50); //Ajustamos donde lo ubicamos y su alto y ancho
        display.setOpaque(true); //Nos permite ponerle un color de fondo
        display.setBackground(new Color(255,255,255));
        display.setForeground(Color.black); //Le cambiamos el color de la fuente
        display.setFont(new Font("Lucida Console",Font.PLAIN,30)); //Le cambiamos la fuente
        display.setHorizontalAlignment(SwingConstants.RIGHT); //Lo alinieamos en el lado derecho
        display.setFocusable(true); //Permito que el JLabel pueda tener el foco
        add(display); //Lo añadimos a la ventana
        Border borde = BorderFactory.createLineBorder(Color.gray, 3); //Modificamos el borde de color gris y 5 pixeles de ancho
        this.display.setBorder(borde); //le añadimos el "borde"

    }

    //Método que ajusta las caracterisicas del JLabel2 (el resultado con los operandos y la operacion usada)
    private void initDisplayop() {

        display2 = new JLabel("0");
        display2.setBounds(25,63,410,40);
        display2.setOpaque(true);
        display2.setBackground(new Color(255,255,255));
        display2.setForeground(Color.black);
        display2.setFont(new Font("Lucida Console",Font.PLAIN,20));
        display2.setHorizontalAlignment(SwingConstants.LEFT);
        display2.setFocusable(true);
        add(display2);
        Border borde = BorderFactory.createLineBorder(Color.gray, 3);
        this.display2.setBorder(borde);
    }

    //Método que ajusta las dimensiones de los botones
    private void initBotones() {

        for(int i = 0; i < numBotones; i++){
            botones[i] = new JButton(textoBotones[i]); //Indicamos que el boton "i" tiene el texto del textobotones "i"
            //Cambiamos el alto de dos botones
            int alto = (i == 16 || i == 17) ? 110 : altoBoton; // Operador ternario (El boton 16 y 17 tiene un alto diferente a los demás)
            botones[i].setBounds(xBotones[i], yBotones[i], anchoBoton, alto); //Ubicamos el boton "i"
            botones[i].setOpaque(true);
            add(botones[i]);
        }
    }

    //Método que ajusta los coloes de los botones
    private void initColores() {
        for(int i = 0; i < numBotones; i++){
            botones[i].setFont(new Font("Lucida Console",Font.PLAIN,19));
            botones[i].setBackground(new Color(238,238,238));
            botones[i].setForeground(new Color(0,77,156));
            botones[i].setBorder(new LineBorder(Color.DARK_GRAY));
            //configuramos el borde
            Border line = BorderFactory.createLineBorder(Color.black, 2);
            botones[i].setBorder(line);
            //Cambiamos el color de algunos botones
            if (i == 19){//Pintamos el boton que limpia
                botones[i].setBackground(Color.red);
                botones[i].setForeground(Color.white);
            } for (int j = 0; j < operacionesBotones.length; j++){
                if (i == operacionesBotones[j]){
                    botones[i].setBackground(new Color(127,127,127));
                    botones[i].setForeground(Color.white);
                } else if (i == operacionesBotones[8]){
                    botones[i].setBackground(new Color(0,77,156));
                    botones[i].setForeground(Color.white);
                }
            }
        }
    }

    //Método que cambia las caracterisitcas cuándo pulso/paso por encima del un boton
    private void initHovers() {

        for (int i = 0; i < botones.length; i++) {
            int numero = i;
            botones[numero].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //Cuando pulsamos el boton x, cambiamos su fondo,fuente y color de fuente(los botones que corresponden a las operaciones)
                    for (int j = 0; j < operacionesBotones.length; j++) {
                        if (e.getSource() == botones[operacionesBotones[j]]) {
                            botones[numero].setBackground(Color.orange);
                            botones[numero].setForeground(Color.black);
                            botones[numero].setFont(new Font("Lucida Console", Font.BOLD, 18));
                        }
                    } for (int j = 0; j < numerosBotones.length; j++){
                        if (e.getSource() == botones[numerosBotones[j]]){
                            botones[numero].setBackground(Color.darkGray);
                            botones[numero].setForeground(Color.red);
                            botones[numero].setFont(new Font("Lucida Console",Font.BOLD,18));
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {


                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }


                @Override
                //Cuando el raton está dentro de un boton, cambiamos sus caracterisicas
                public void mouseEntered(MouseEvent e) {
                    botones[numero].setBackground(Color.darkGray);
                    botones[numero].setForeground(Color.red);
                    botones[numero].setFont(new Font("Lucida Console",Font.BOLD,18));
                }

                //Cuando nos salimos de un boton, hacemos que vuelva a las caractericas que tenia inicialmente
                @Override
                public void mouseExited(MouseEvent e) {
                    initColores();
                }
            });
        }
    }

    //Método que escriba la tecla que pulso en el JLabel y "ilumina" su respectivo boton
    private void eventosTeclas() {

            display.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                }

                //Cuando suelto una tecla , me escribe en el JLabel dicha tecla
                @Override
                public void keyReleased(KeyEvent e) {
                    int key = e.getKeyCode();//Guardamos el codigo(numero) de la tecla
                    char letra = e.getKeyChar(); //Guardamos el caracter de la tecla
                    for (int i = 0; i < botones.length; i++) {
                        //si la "letra" forma parte del Array prinicpal "botones" ....
                        if (botones[i].getText().charAt(0) == letra) {
                            initColores();
                            botones[i].setBackground(Color.darkGray);
                            botones[i].setForeground(Color.red);
                            botones[i].setFont(new Font("Lucida Console",Font.BOLD,18));
                            botones[i].doClick();//simulamos que pulsamos dicho boton gráficamente
                            //si pulsamos los botones que corresponde al "/","*","-","+"
                            if (i == 4 | i == 10 | i == 11 | i ==16){
                                botones[i].setBackground(Color.orange);
                                botones[i].setForeground(Color.black);
                                botones[i].setFont(new Font("Lucida Console", Font.BOLD, 18));
                            }
                        }
                    } if (key == KeyEvent.VK_ENTER) { //Si el codigo coresponde al enter del teclado viertual...
                        resultado();
                        initColores();
                        botones[17].setBackground(Color.orange);
                        botones[17].setForeground(Color.black);
                        botones[17].setFont(new Font("Lucida Console", Font.BOLD, 18));
                    } else if (key == KeyEvent.VK_C) { //Si el codigo coresponde a la letra "C" del teclado viertual...
                        limpiar();
                        initColores();
                        botones[19].setBackground(Color.orange);
                        botones[19].setForeground(Color.black);
                        botones[19].setFont(new Font("Lucida Console", Font.BOLD, 18));
                    }
                }
            });
    }


    //Método que escribe en los JLabel el numero que corresponde a su boton
    private void eventosNumeros() {

        for (int i = 0; i < numerosBotones.length; i++){
            int numBoton = numerosBotones[i];
            //Al pulsar el boton x.....
            botones[numBoton].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Si es un nuevo numero y no es 0, sustituyo el valor del display por dicho numero
                    if (nuevoNumero){
                        if (!textoBotones[numBoton].equals("0")) {
                            display.setText(textoBotones[numBoton]);
                            display2.setText(textoBotones[numBoton]);
                            nuevoNumero = false;
                        }
                    }
                    //Si no, lo añado a los digitos que ya hubiera
                    else {
                        display.setText(display.getText() + textoBotones[numBoton]);
                        display2.setText(display2.getText() + textoBotones[numBoton]);
                    }
                }
            });
        }
    }

    //Método que me permite hacer operaciones decimales
    private void eventoDecimal() {

        //Al pulsar el boton "."
        botones[21].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si es un nuevo numero, sustituyo el valor del display
                if (!puntoDecimal){
                    display.setText(display.getText() + textoBotones[21]);
                    display2.setText(display2.getText() + textoBotones[21]);
                    nuevoNumero = false;
                    puntoDecimal = true;
                    display.requestFocus();
                }
            }
        });
    }

    //Método que ejecuta las operaciones en la consola
    private void eventosOperaciones() {

        for (int i = 0; i < operacionesBotones.length; i++) {
            int numBoton = operacionesBotones[i];
            botones[numBoton].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    display.requestFocus();
                    if (operacion.equals("")) {
                        operacion = textoBotones[numBoton];
                        operando2 = Double.parseDouble(display.getText());
                        System.out.println(operando2);
                        nuevoNumero = true;
                        puntoDecimal = false;
                        System.out.println(operando2 + " " + operacion);
                    } else {
                        operando2 = resultado();
                        operacion = textoBotones[numBoton];
                    }
                    System.out.println(operando2 + " " + operacion + " " + operando1);
                }
            });
        }
    }


    //Método que al pulsar el boton "=" escribe en el JLabel el resultado de una operaciones llamando al metodo "resultado()"
    private void eventoResultado() {

        botones[17].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado();
                display.requestFocus();
                display2.requestFocus();
            }
        });
    }

    //Método que ejecuta las operaciones
    private double resultado(){

        operando1 = Double.parseDouble(display.getText());//texto que habia en el display
        switch (operacion){
            case "+": resultado = operando1 + operando2;
                break;
            case "-": resultado = operando2 - operando1;
                break;
            case "*": resultado = operando2 * operando1;
                break;
            case "/": resultado = operando2 / operando1;
                break;
            case "x^(y)": resultado = Math.pow(operando2,operando1);
                break;
            case " 1/x": resultado = 1 / operando1;
                break;
            case "√x": resultado = Math.sqrt(operando1);
                break;
            case "x^(2)": resultado = operando1 * operando1;
                break;
            case " +/-": resultado = operando1 - operando1*2;
                break;
        }

        //Formatear el resultado(que no salga x.0 en el resultado)
        Locale  localActual = Locale.GERMAN;//Libreria de signos alemana
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(localActual);
        simbolos.setDecimalSeparator('.');
        //Dar formato
        DecimalFormat formatoResultado = new DecimalFormat("#.######", simbolos);
        display.setText(String.valueOf(formatoResultado.format(resultado)));
        String operando2s = String.valueOf(formatoResultado.format(operando2));
        String operando1s = String.valueOf(formatoResultado.format(operando1));
        String resultados = String.valueOf(formatoResultado.format(resultado));

        //Imprimos en el display 2 la operacion completa
        display2.setText(operando2s+ " " + operacion + " " + operando1s + " = " + resultados);

        //Reiniciamos todas las variables
        operando1 = 0;
        operando2 = 0;
        operacion = "";
        nuevoNumero = true;
        puntoDecimal = false;
        return resultado;

    }

    //Método que "limpia" el texto del resultado y llama al método "limpiar()" pulsando la "C"
    private void eventoLimpiar() {

        botones[19].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.requestFocus();
                limpiar();
                initColores();
            }
        });
    }

    //Método que limpia todos las variables igulandolas por defecto
    private void limpiar(){

        operando1 = operando2 = 0;
        resultado = 0;
        operacion = "";
        nuevoNumero = true;
        puntoDecimal = false;
        display.setText("0");
        display2.setText("0");
    }

    //Método princiapl que nos permite ejecutar el proyecto, creando el objeto "Calculadora" que contiene todos los métodos
    public static void main(String[] args) {
        new Calculadora();
    }
}