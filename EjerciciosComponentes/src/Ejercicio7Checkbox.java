import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Crear un control JLabel que muestre el siguiente mensaje:
 "¿Acepta las condiciones del servicio?", luego un JCheckBox y
  finalmente un objeto de tipo JButton deshabilitado usando el método setEnabled(false).
  Cuando se marque el JCheckBox debemos habilitar el botón y al hacer clic en él,
  un JLabel debe mostrar debajo "Has aceptado las condiciones del servicio".
 */
public class Ejercicio7Checkbox extends JFrame implements ChangeListener {

    private JLabel label1,label2;
    private JCheckBox checkBox1, checkBox2;
    private JButton boton1;

    Ejercicio7Checkbox(){
        initVentana();
        initCheck();
        initBoton();
    }

    private void initVentana() {
        setLayout(null);
        setBounds(0, 0, 600, 150);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initCheck() {

        label1 = new JLabel("¿Acepta las condiciones del servicio?");
        label1.setBounds(25,27,300,30);
        add(label1);


        label2 = new JLabel("");
        label2.setBounds(350,50,200,30);
        add(label2);

        checkBox1 = new JCheckBox("SI");
        checkBox1.setBounds(280,25,50,10);
        checkBox1.addChangeListener(this);
        add(checkBox1);

        checkBox2 = new JCheckBox("NO");
        checkBox2.setBounds(280,50,50,10);
        checkBox2.addChangeListener(this);
        add(checkBox2);
    }

    private void initBoton() {

        boton1 = new JButton("Aceptar");
        boton1.setBounds(350,27,80,30);
        //boton1.addActionListener((ActionListener) this);
        add(boton1);
        boton1.setEnabled(false);
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton1){
                    label2.setText("has aceptado als condiciones");
                }
            }
        });

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (checkBox1.isSelected() == true){
            boton1.setEnabled(true);
        }
        if (checkBox2.isSelected() == true){
            System.exit(0);
        }


    }

    public static void main (String[] args){
        Ejercicio7Checkbox princiapl = new Ejercicio7Checkbox();
    }
}
