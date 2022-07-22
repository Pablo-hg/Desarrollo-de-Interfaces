import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ParesyNones  extends JFrame implements ActionListener{

    //Creo los elementos que voy a usar
     private JLabel label1 , label2;
     private JButton boton1,boton2, boton3,boton4,boton5, pares, nones;
     public int minumero;



     public  ParesyNones(){

         //Configuro la ventana principal
         setLayout(null);
         setResizable(false);
         setBounds(10,10,500,300);
         setTitle("Pares y Nones Pablo Horcajada");

         //Configuro el Titulo
         label1 = new JLabel("Juego de Pares y Nones");
         label1.setBounds(40,40,350,30);
         add(label1);
         label1.setFont(new Font("MONOSPACED",Font.PLAIN,24));
         label1.setHorizontalAlignment(SwingConstants.RIGHT);

        //Configuro el texto
         label2 = new JLabel("Elige un número para jugar vs la máquina");
         label2.setBounds(25,100,400,30);
         add(label2);
         label2.setFont(new Font("MONOSPACED",Font.PLAIN,15));
         label2.setHorizontalAlignment(SwingConstants.RIGHT);

        //Configuro el boton 1
         boton1 = new JButton("1");
         boton1.setOpaque(true);
         boton1.setBounds(25,150,75,60);
         add(boton1);
         boton1.addActionListener(this);

         //Configuro el boton 2
         boton2 = new JButton("2");
         boton2.setOpaque(true);
         boton2.setBounds(115,150,75,60);
         add(boton2);
         boton2.addActionListener(this);

         //Configuro el boton 3
         boton3 = new JButton("3");
         boton3.setOpaque(true);
         boton3.setBounds(205,150,75,60);
         add(boton3);
         boton3.addActionListener(this);

         //Configuro el boton 4
         boton1.setOpaque(true);
         boton4 = new JButton("4");
         boton4.setBounds(295,150,75,60);
         add(boton4);
         boton4.addActionListener(this);

         //Configuro el boton 5
         boton5 = new JButton("5");
         boton1.setOpaque(true);
         boton5.setBounds(385,150,75,60);
         add(boton5);
         boton5.addActionListener(this);

         //Hago visible todo
         setVisible(true);



     }

     //Creamos el main para ejecutar el programa
    public static void main(String[] args){

         new ParesyNones();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
         //si pulsamos el boton x
        if (e.getSource() == boton1){
            minumero = 1;
            Resultado resultado = new Resultado(this,true);
            resultado.setVisible(true);
        } else if (e.getSource() == boton2){//si pulsamos el boton 2
            minumero = 2;
            Resultado resultado = new Resultado(this, true);
            resultado.setVisible(true);
        } else if (e.getSource() == boton3){//si pulsamos el boton 3
            minumero = 3;
            Resultado resultado = new Resultado(this, true);
            resultado.setVisible(true);
        } else if (e.getSource() == boton4){//si pulsamos el boton 4
            minumero = 4;
            Resultado resultado = new Resultado(this, true);
            resultado.setVisible(true);
        } else if (e.getSource() == boton5){//si pulsamos el boton 5
            minumero = 5;
            Resultado resultado = new Resultado(this, true);
            resultado.setVisible(true);
        }
    }
}
