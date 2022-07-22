import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acercade extends JDialog implements  ActionListener{

    //creamos los componenentes
    private JButton boton1;
    private JLabel nombre,texto1, texto2, texto3,texto4, texto5, texto6;

    //indicamos que es un objeto heredado de DianaHOrizontal
    public Acercade (DianaHorizontal parent, boolean modal){

        super(parent,modal);

        //Configuramos la ventana
        setLayout(null);
        setResizable(false);
        setBounds(620,10,700,350);

        //boton para volver al juego
        boton1 = new JButton("Volver al juego");
        boton1.setBounds(245,250,150,50);
        add(boton1);
        boton1.addActionListener(this);

        //titulo
        nombre = new JLabel("Pablo Horcajada González");
        nombre.setBounds(80,30,450,30);
        nombre.setFont(new Font("MONOSPACED",Font.PLAIN,24));
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        add(nombre);

        //texto1
        texto1 = new JLabel("JLider -> Control con selector de número entre el 1 y el 100");
        texto1.setBounds(18,70,575,20);
        texto1.setFont(new Font("MONOSPACED",Font.PLAIN,15));
        add(texto1);

        //texto2
        texto2 = new JLabel("JButton -> Boton que abre ventanas y regula el ancho del slider");
        texto2.setBounds(12,100,595,20);
        texto2.setFont(new Font("MONOSPACED",Font.PLAIN,15));
        add(texto2);

        //texto3
        texto3 = new JLabel("JLabel -> Espacio donde se pone cualquier tipo de texto");
        texto3.setBounds(15,130,595,20);
        texto3.setFont(new Font("MONOSPACED",Font.PLAIN,15));
        add(texto3);

        //texto4
        texto4 = new JLabel("ActionListener -> Se produce al hacer click(enter) en un componente");
        texto4.setBounds(15,160,630,20);
        texto4.setFont(new Font("MONOSPACED",Font.PLAIN,15));
        add(texto4);

        //texto5
        texto5 = new JLabel("MouseListener -> Se produce cuando realizamos una acción con el ratón");
        texto5.setBounds(15,190,650,20);
        texto5.setFont(new Font("MONOSPACED",Font.PLAIN,15));
        add(texto5);

        //texto6
        texto6 = new JLabel("MouseClicked -> Pinchar y soltar un componente");
        texto6.setBounds(15,220,650,20);
        texto6.setFont(new Font("MONOSPACED",Font.PLAIN,15));
        add(texto6);

    }

    @Override
    //Creamos la accion para volver al juego
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            setVisible(false);
        }
    }
}
