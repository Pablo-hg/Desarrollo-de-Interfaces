/* Importamos las componentes Swing, así como el paquete con los interfaces para los eventos */
import javax.swing.*;
import java.awt.event.*;

/* La clase JFrame encapsula el concepto de una ventana, para implementar una aplicación que muestre una ventana debemos plantear una clase que herede de la clase JFrame e implemente a a ActionListener para el evento del botón*/
public class Formulario extends JFrame implements ActionListener{

    /* Definimos variables. */
    private JTextField textfield1;
    private JLabel label1;
    private JButton boton1;

    /* En el constructor de la clase llamamos al método heredado de la clase JFrame llamado setLayout y le pasamos como parámetro un valor null, con esto estamos informándole a la clase JFrame que utilizaremos posicionamiento absoluto para los controles visuales dentro del JFrame*/
    public Formulario() {

        setLayout(null);

        /* Etiqueta de usuario */
        label1=new JLabel("Usuario:");
        label1.setBounds(10,10,100,30);
        add(label1);

        /* Campo de texto */
        textfield1=new JTextField();
        textfield1.setBounds(120,10,150,20);
        add(textfield1);

        /* Botón de Aceptar */
        boton1=new JButton("Aceptar");
        boton1.setBounds(10,80,100,30);
        add(boton1);

        /* Inicializo escuchador del botón */
        boton1.addActionListener(this);

    }

    /* Método que implementa la acción del botón */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            String titulo=textfield1.getText();
            setTitle(titulo);
        }
    }

    /* En el método main creamos un objeto de la clase Formulario, llamamos al método setBounds para ubicar y dar tamaño al control y mediante el método setVisible hacemos visible el JFrame */
    public static void main(String[] args) {

        Formulario formulario1=new Formulario();
        formulario1.setBounds(0,0,300,150);
        formulario1.setVisible(true);

    }

}