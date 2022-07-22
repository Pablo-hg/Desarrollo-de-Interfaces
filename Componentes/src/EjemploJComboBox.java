import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class EjemploJComboBox extends JFrame implements ItemListener {

    private JComboBox combo1;
    private JLabel label1;

    public EjemploJComboBox() {

        setLayout(null);

        //Añado el ComboBox con sus items y su ItemListener, así como la etiqueta
        combo1=new JComboBox();
        combo1.setBounds(10,10,80,20);
        add(combo1);

        combo1.addItem("rojo");
        combo1.addItem("verde");
        combo1.addItem("azul");
        combo1.addItemListener(this);

        label1 = new JLabel("Color seleccionado: ninguno");
        label1.setBounds(10,80,200,30);
        add(label1);

    }



    public static void main(String[] args) {

        EjemploJComboBox formularioCombobox = new EjemploJComboBox();
        formularioCombobox.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formularioCombobox.setBounds(0,0,300,200);
        formularioCombobox.setVisible(true);

    }

    //Implemento el método itemStateChanged
    @Override
    public void itemStateChanged(ItemEvent e) {

        //String texto = "Color seleccionado:  ";
        if (e.getSource() == combo1) {
            String nepe = (String) combo1.getSelectedItem();
            label1.setText("Color seleccionado " + combo1.getSelectedItem());
        }
    }
}
