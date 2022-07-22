


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*1ºCrear una ventana de 1024 píxeles por 800 píxeles. Luego no permitir que el operador modifique
el tamaño de la ventana. Sabiendo que hacemos visible al JFrame llamando la método setVisible pasando el valor true,
 existe otro método llamado setResizable que también requiere como parámetro un valor true o false.

2ºCrear tres objetos de la clase JLabel, ubicarlos uno debajo de otro y mostrar nombres de personas.

3ºDisponer dos objetos de la clase JButton con las etiquetas: "carne" y "pescado", al presionarse cada
 botón abrir una nueva ventana que muestre la opción elegida, no permitiendo elegir otra opción mientras
 no se cierre la anterior.
 */


public class Ejercicio1 extends JFrame implements ActionListener {

    private JButton botonCarne, botonPescado;
    private JLabel label1, label2, label3;



    public Ejercicio1(){

        setLayout(null);
        setResizable(false);
        setBounds(10,10,1024,800);

        label1 = new JLabel("Pablo");
        label1.setBounds(100,100,50,30);
        add(label1);

        label2 = new JLabel("Pepe");
        label2.setBounds(150,100,50,30);
        add(label2);

        label3 = new JLabel("Juan");
        label3.setBounds(200,100,50,30);
        add(label3);

        botonCarne = new JButton("Carne");
        botonCarne.setBounds(100,400,100,60);
        add(botonCarne);
        botonCarne.addActionListener(this);

        botonPescado = new JButton("Pescado");
        botonPescado.setBounds(250,400,100,60);
        add( botonPescado);
        botonPescado.addActionListener(this);

        setVisible(true);
    }


    public static void main(String[] args) {

        new Ejercicio1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCarne){
            Ejercicio1Carne carne = new Ejercicio1Carne(this,true);
            carne.setVisible(true);
        }
        else if (e.getSource() == botonPescado){
            Ejercicio1Pescado pescado = new Ejercicio1Pescado(this,true);
            pescado.setVisible(true);
        }
    }
}
