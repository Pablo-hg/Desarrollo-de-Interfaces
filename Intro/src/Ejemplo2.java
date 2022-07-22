import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*Confeccionar una ventana que contenga tres objetos de la clase JButton
 con las etiquetas "1", "2" y "3". Al presionarse cambiar el título del JFrame
  indicando qué botón se presionó.*/

public class Ejemplo2 extends JFrame implements ActionListener  {

    private JButton boton1, boton2, boton3;

    public Ejemplo2(){

        setLayout(null);

        //inicializo
        boton1= new JButton("1");
        boton2= new JButton("2");
        boton3= new JButton("3");

        //Posciono
        boton1.setBounds(10,100,90,30);
        boton2.setBounds(110,100,90,30);
        boton3.setBounds(210,100,90,30);

        //Añado al JFrame
        add(boton1);
        add(boton2);
        add(boton3);

        //Añdo al Action  Listener
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boton1){
            setTitle("boton 1");
        }
        else if (e.getSource() == boton2){
            setTitle("boton 2");
        }
        else if (e.getSource() == boton3){
            setTitle("boton 3");
        }

    }

    public static void main(String[] args){
        Ejemplo2 ejemplo2 = new Ejemplo2();
        ejemplo2.setBounds(0,0,350,200);
        ejemplo2.setVisible(true);
    }
}
