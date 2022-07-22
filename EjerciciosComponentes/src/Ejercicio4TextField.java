import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/*Crear un formulario de acceso con usuario, contraseña y botón de Acceder.
 Al puslar el botón, si el usuario es jairo y la contraseña es 12345678 debe devolver
 CORRECTO en verde, en caso contrario, debe devolver INCORRECTO en rojo.
 */

public class Ejercicio4TextField extends JFrame implements ActionListener {

    /* Definimos variables. */
    private JTextField textfieldUsuario;
    private JPasswordField passfieldContrasena;
    private JLabel labelUsuario, labelContrasena, labelResultado;
    private JButton botonAceptar;
    char [] contrasena;

    public Ejercicio4TextField() {

        setLayout(null);

        //Propiedades del layout
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Etiqueta de usuario
        labelUsuario = new JLabel("Usuario");
        labelUsuario.setBounds(10, 10, 100, 30);
        add(labelUsuario);

        //Etiqueta de contraseña
        labelContrasena = new JLabel("Contraseña");
        labelContrasena.setBounds(10, 40, 100, 30);
        add(labelContrasena);

        //Etiqueta de resultado
        labelResultado = new JLabel("");
        labelResultado.setBounds(180, 70, 100, 30);
        add(labelResultado);

        //Campo de usuario
        textfieldUsuario = new JTextField();
        textfieldUsuario.setBounds(120, 10, 150, 20);
        add(textfieldUsuario);

        //Campo de contrasena
        passfieldContrasena = new JPasswordField();
        passfieldContrasena.setBounds(120, 40, 150, 20);
        add(passfieldContrasena);

        //Boton de aceptar
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(10, 70, 100, 30);
        add(botonAceptar);

        //Inicializo action listener
        botonAceptar.addActionListener(this);


    }

     public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonAceptar) {

            //Recojo la contraseña como char (hace que salgan como ***)
            contrasena = passfieldContrasena.getPassword();

            //Compruebo si lo introducido es lo que deberia aparecer
            if(new String(contrasena).equals("12345678") && textfieldUsuario.getText().equals("jairo")){
                labelResultado.setText("Correcto");
                labelResultado.setForeground(Color.green);
            }
            else{
                labelResultado.setText("Incorrecto");
                labelResultado.setForeground(Color.red);
            }
        }
    }

    public static void main(String[] args) {

        Ejercicio4TextField formulario1 = new Ejercicio4TextField();
        formulario1.setBounds(0, 0, 300, 150);
        formulario1.setVisible(true);

    }
}

