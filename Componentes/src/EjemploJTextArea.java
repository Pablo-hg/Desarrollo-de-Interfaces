import javax.swing.*;

public class EjemploJTextArea extends JFrame{

    /* Definimos variables. */
    private JTextField textfield1;
    private JTextArea textarea1;

    public EjemploJTextArea() {

        setLayout(null);

        /* Campo de email */
        textfield1=new JTextField();
        textfield1.setBounds(10,10,200,30);
        add(textfield1);

        /* Cuerpo de mensaje */
        textarea1=new JTextArea();
        textarea1.setBounds(10,50,400,300);
        add(textarea1);

    }

    public static void main(String[] args) {

        EjemploJTextArea formulario1=new EjemploJTextArea();
        formulario1.setBounds(0,0,540,400);
        formulario1.setVisible(true);

    }

}