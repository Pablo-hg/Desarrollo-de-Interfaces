import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resultado extends JDialog implements ActionListener {

    //creamos las variables y los objetos
    private JLabel titulo1, titulo2, display1, display2, ganador;
    private JButton botonvolver;
    int suma1, suma2;
    public int minumero;

    public Resultado(ParesyNones parent, boolean modal){

        //indicamos quien es su padre
        super(parent, modal);

        //Creamos la ventana para que no se pueda mover
        setLayout(null);
        setResizable(false);
        setBounds(500,10,500,350);

        //Creamops el boton de volver a jugar
        botonvolver = new JButton("Volver a jugar");
        botonvolver.setBounds(175,250,125,30);
        add(botonvolver);
        botonvolver.addActionListener(this);

        //Ponemos los textos
        titulo1 = new JLabel("YO");
        titulo1.setBounds(125,40,350,30);
        add(titulo1);
        titulo1.setFont(new Font("MONOSPACED",Font.PLAIN,24));
        titulo2 = new JLabel("MÁQUINA");
        titulo2.setBounds(275,40,350,30);
        add(titulo2);
        titulo2.setFont(new Font("MONOSPACED",Font.PLAIN,24));

        //llamamos a la variable de la venatana anerior
        minumero = parent.minumero;

        //creamos los voids
        maquinaresultado();
        miresultado();
        resultado();
    }

    //Hacemos un numero aleatorio que tendrá la maquina
    void maquinaresultado(){
        suma2 = (int) ((Math.random()*5)+1);
        display2 = new JLabel(String.valueOf(suma2));
        display2.setBounds(300,125,50,30);
        display2.setFocusable(true);
        display2.setBorder(new LineBorder(Color.DARK_GRAY));
        display2.setHorizontalAlignment(SwingConstants.CENTER);
        add(display2);
    }

    //Ponemos el numero que hemos elegido en la ventana anterior
    void miresultado(){
        display1 = new JLabel(String.valueOf(minumero));
        display1.setBounds(115,125,50,30);
        display1.setFocusable(true);
        display1.setBorder(new LineBorder(Color.DARK_GRAY));
        display1.setHorizontalAlignment(SwingConstants.CENTER);
        add(display1);
        suma1 = minumero;
    }

    //Hacemos la operacion para ver si es divisible(par)
    void resultado(){
        int sumresultado = suma1 + suma2;
        if (sumresultado % 2 == 0){
            ganador = new JLabel("El ganador eres tu");
        } else {
            ganador = new JLabel("Ha ganado la maquina");
        }
        ganador.setBounds(160,200,150,30);
        ganador.setFocusable(true);
        ganador.setBorder(new LineBorder(Color.DARK_GRAY));
        ganador.setHorizontalAlignment(SwingConstants.CENTER);
        add(ganador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Al pulsar al boton "volver a jugar" volvemos a la ventana original
        if (e.getSource() == botonvolver) {
            //cierro y vuelvo a la ventana principal
            setVisible(false);

        }
    }


}
