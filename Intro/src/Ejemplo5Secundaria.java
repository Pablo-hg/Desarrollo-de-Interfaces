import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo5Secundaria extends JDialog implements ActionListener {


    private JButton boton2;
    private JLabel label1;

    public Ejemplo5Secundaria(Ejemplo5Principal parent, boolean modal){//parent nos llama al padre

        //Invocar al constructor de la clase superior
        super(parent, modal);

        setLayout(null);
        setBounds(440,10,410,210);

        label1 = new JLabel("Esta es la ventana secundaria");
        label1.setBounds(115,60,500,50);
        add(label1);

        boton2 = new JButton("Volver");
        boton2.setBounds(105,110,200,30);
        add(boton2);

        boton2.addActionListener(this);



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton2){
            //Cierro la ventana
            setVisible(false);
        }
    }
}
