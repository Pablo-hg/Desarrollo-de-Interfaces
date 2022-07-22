
/*Crear un formulario con dos JTextField y 4 JRadioButton (sumar, restar, multiplicar y dividir),
 de modo que podamos introducir dos números y al seleccionar un JRadioButton un JLabel
 nos muestre la operación. Además, si el resultado es positivo o 0 el fondo del
 JFrame debe ser verde, en caso contrario, será rojo. Por último, un botón debe
 permitir "reinicializar" el JFrame, de modo que los JTextField estén vacíos,
 los JRadioButton sin seleccionar y el fondo del color original.
 */


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio8JRadioButton extends JFrame implements ChangeListener {

    private JTextField jfield1, jfield2, jfield3;
    private JButton boton;
    private JRadioButton radio1, radio2, radio3, radio4;
    private ButtonGroup grupo;
    int op1;
    int op2;
    int result;

    Ejercicio8JRadioButton(){

        initRadios();
        initCosas();
        initVentana();
    }

    private void initVentana() {

        setLayout(null);
        setBounds(0, 0, 300, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private void initRadios() {
        grupo = new ButtonGroup();

        radio1=new JRadioButton("Sumar");
        radio1.setBounds(10,20,100,20);
        radio1.addChangeListener(this);
        add(radio1);
        grupo.add(radio1);

        radio2=new JRadioButton("Restar");
        radio2.setBounds(10,60,100,20);
        radio2.addChangeListener(this);
        add(radio2);
        grupo.add(radio2);

        radio3=new JRadioButton("Dividir");
        radio3.setBounds(10,100,100,20);
        radio3.addChangeListener(this);
        add(radio3);
        grupo.add(radio3);

        radio4=new JRadioButton("Multiplicar");
        radio4.setBounds(10,140,100,20);
        radio4.addChangeListener(this);
        add(radio4);
        grupo.add(radio4);
    }

    private void initCosas() {
        jfield1 = new JTextField("Operando1");
        jfield1.setBounds(130,40,100,30);
        add(jfield1);

        jfield2 = new JTextField("Operando2");
        jfield2.setBounds(130,80,100,30);
        add(jfield2);

        jfield3 = new JTextField("Resultado");
        jfield3.setBounds(130,120,100,30);
        add(jfield3);

        boton = new JButton("Reiniciar");
        boton.setBounds(100,180,100,50);
        add(boton);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton){
                    op1 = 0;
                    op2 = 0;
                    jfield1.setText("Operando1");
                    jfield2.setText("Operando2");
                    jfield3.setText("Operando3");
                }
            }
        });
    }


    @Override
    public void stateChanged(ChangeEvent e) {

        //Pasar por encima cuenta como stateChanged(ya que es una accion propia)

        if (radio1.isSelected()){
            op1 = Integer.parseInt(jfield1.getText());
            op2 = Integer.parseInt(jfield2.getText());
            result = op1 + op2;
            jfield3.setText(String.valueOf(result));
        }
        if (radio2.isSelected()){
            op1 = Integer.parseInt(jfield1.getText());
            op2 = Integer.parseInt(jfield2.getText());
            result = op1 - op2;
            jfield3.setText(String.valueOf(result));
        }
        if (radio3.isSelected()){
            op1 = Integer.parseInt(jfield1.getText());
            op2 = Integer.parseInt(jfield2.getText());
            result = op1 / op2;
            jfield3.setText(String.valueOf(result));
        }
        if (radio4.isSelected()){
            op1 = Integer.parseInt(jfield1.getText());
            op2 = Integer.parseInt(jfield2.getText());
            result = op1 * op2;
            jfield3.setText(String.valueOf(result));
        }

        if (result >= 0){
                getContentPane().setBackground(Color.green);
        } else {
            getContentPane().setBackground(Color.red);
        }

    }

    public static void main (String[] args) {

        Ejercicio8JRadioButton formulario = new Ejercicio8JRadioButton();

    }
}
