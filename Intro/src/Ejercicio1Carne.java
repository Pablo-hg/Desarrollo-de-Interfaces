import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Ejercicio1Carne extends JDialog implements ActionListener {

    private JButton boton;
    private JLabel label;

    public Ejercicio1Carne(Ejercicio1 parent, boolean modal) {

        super(parent, modal);

        setLayout(null);
        setBounds(440, 10, 410, 210);

        label = new JLabel("Esta es la ventana  de carne");
        label.setBounds(115, 60, 500, 50);
        add(label);

        boton = new JButton("Volver");
        boton.setBounds(105, 110, 200, 30);
        add(boton);

        boton.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            //Cierro la ventana
            setVisible(false);
        }
    }
}
