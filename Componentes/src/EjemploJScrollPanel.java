import javax.swing.*;

public class EjemploJScrollPanel extends JFrame{

    /* Definimos variables. */
    private JTextField textfield1;
    private JTextArea textarea1;
    private JScrollPane scrollpane1;

    public EjemploJScrollPanel() {


        setLayout(null);

        /* Campo de email */
        textfield1=new JTextField();
        textfield1.setBounds(10,10,200,30);
        add(textfield1);

        /* Cuerpo de mensaje en scrollPane*/
        textarea1=new JTextArea();
        textarea1.setLineWrap(true); //Para que salte de línea al llegar al final del ancho del jTextArea
        scrollpane1=new JScrollPane(textarea1);
        scrollpane1.setBounds(10,50,200,200);
        add(scrollpane1);

    }

    private void inittablas(){

        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= 10;i++){
                textarea1.setText(i + " x " + j + " = " + i*j);
            }
        }
    }

    public static void main(String[] args) {

        EjemploJScrollPanel formulario1=new EjemploJScrollPanel();
        formulario1.setBounds(0,0,540,400);
        formulario1.setVisible(true);

    }

}