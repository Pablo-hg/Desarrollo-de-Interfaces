import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Crear una ventana con un botón que lleve a otra ventana
e impida que se abran nuevas ventanas hasta que se cierre la anterior.*/

public class Ejemplo5Principal extends JFrame implements ActionListener {

    private JButton boton;
    private JLabel label;

    public Ejemplo5Principal(){

        //JFrame
        setLayout(null);
        setBounds(10,10,410,210);

        //Etiqueta
        label = new JLabel("Esta es la ventana principal");
        label.setBounds(115,60,200,30);
        add(label);

        //Botón
        boton = new JButton("Haz clic aquí");
        boton.setBounds(105,110,200,40);
        add(boton);

        //Añado el botón al action listener
        boton.addActionListener(this);

        //Muestro el JFrame
        setVisible(true);

    }

    public static void main(String[] args) {
        new Ejemplo5Principal();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton){
            //abrir la venatan secundaria
            //poner true en el modal hace que solo deja abrir una ventana secundaria
            Ejemplo5Secundaria secundaria = new Ejemplo5Secundaria(this,true);
            secundaria.setVisible(true);

        }
    }
}
