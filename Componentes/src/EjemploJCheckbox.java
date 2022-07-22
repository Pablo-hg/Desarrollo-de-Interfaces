import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class EjemploJCheckbox extends JFrame implements ChangeListener {

    private JCheckBox checkBox1, checkBox2, checkBox3;
    private JLabel label1;

    public EjemploJCheckbox() {

        setLayout(null);

        //Añado los 3 checkbox con su ChangeListener y la etiqueta
        checkBox1 = new JCheckBox("Español");
        checkBox1.setBounds(10,10,150,30);
        checkBox1.addChangeListener(this);
        add(checkBox1);

        checkBox2 = new JCheckBox("Inglés");
        checkBox2.setBounds(10,50,150,30);
        checkBox2.addChangeListener(this);
        add(checkBox2);

        checkBox3 = new JCheckBox("Alemán");
        checkBox3.setBounds(10,90,150,30);
        checkBox3.addChangeListener(this);
        add(checkBox3);

        label1 = new JLabel("Idiomas: ninguno");
        label1.setBounds(10,130,250,30);
        add(label1);


    }

    //Implemento el método stateChanged
    public void stateChanged(ChangeEvent e){

        String texto = "Idiomas:  ";
        //Poner un Checkbox == true significa que está seleccionado
        if (checkBox1.isSelected() == true) {
            texto += "Español, ";
        }
        if (checkBox2.isSelected() == true) {
            texto += "Ingles, ";
        }
        if (checkBox3.isSelected() == true) {
            texto += "Alemán, ";
        }

        //Quito la última ',' y escribo el texto
        texto = texto.substring(0, texto.length() - 2);
        label1.setText(texto);
    }

    public static void main(String[] ar) {

        EjemploJCheckbox formularioCheckbox = new EjemploJCheckbox();
        formularioCheckbox.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formularioCheckbox.setBounds(0,0,300,200);
        formularioCheckbox.setVisible(true);

    }


}