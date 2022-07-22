import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Confeccionar una ventana que muestre un botón. Cuando se presione finalizar la ejecución del programa Java.


public class Ejempl1  extends JFrame implements ActionListener {

    JButton boton1;

    public Ejempl1(){

        //utilizo layout absoluto
        setLayout(null);//
        //Inicializo el bton
        boton1 = new JButton("Finalizar");
        //posiciono el boton
        boton1.setBounds(300,250,100,30);
        //añado el boton al JFrame
        add(boton1);
        //Añado el botón al Action Listener de esta clase
        boton1.addActionListener(this);
    }

    public static void main (String[] args){
        Ejempl1 ejemplo1 = new Ejempl1();
        //Posiciono el JFrame en la pantalla
        ejemplo1.setBounds(100,0,450,350);
        //Muestro el JFrame
        ejemplo1.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            //salimos de la aplicacion
            System.exit(0);
        }
    }
}
