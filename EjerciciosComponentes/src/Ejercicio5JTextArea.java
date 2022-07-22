
/* Crear un formulario que incluya un jTextArea en el que se escriban las tablas
 de multiplicar del 1 al 10 con una operación en cada línea (total 100 operaciones en formato 1 x 1 = 1).
 Añadir el jTextArea a un JScrollPane para poder recorrer el texto del jTextArea mediante scroll.
 */

import javax.swing.*;

/*Crear un formulario que incluya un jTextArea en el que se escriban las
tablas de multiplicar del 1 al 10 con una operación en cada línea (total 100 operaciones en formato 1 x 1 = 1).
 Añadir el jTextArea a un JScrollPane para poder recorrer el texto del jTextArea mediante scroll.
 */
public class Ejercicio5JTextArea extends JFrame {


    JTextArea textArea;
    JScrollPane scrollPane;
    String contenido = "";

    Ejercicio5JTextArea() {

        //Opciones del layout
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(200, 300, 300, 410);
        setVisible(true);

        //Textarea y Scrollpane
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(0, 0, getWidth(), 400);
        add(scrollPane);

        //Recorro del 1 al 10
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                //Añado la línea
                contenido += i + "x" + j + " = " + (i * j) + "\n";
            }
            //Separador de tabla
            contenido += "\n";
        }

        //Aplico texto al textArea
        textArea.setText(contenido);

    }

    public static void main(String[] args) {
        new Ejercicio5JTextArea();
    }
}
