import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Resultado extends JDialog implements ActionListener {

    //Creamos los componenentes y la variable
    private JButton volver;
    public int puntuacion;
    private JLabel texto;


    //indicamos que es un objeto heredado de DianaHOrizontal
    public Resultado(DianaHorizontal parent, boolean modal){

        super(parent,modal);

        //Indicamos al variable que se hereda del apdre
        puntuacion = parent.puntuacion;


        //Configuramos la ventana
        setLayout(null);
        setResizable(false);
        setBounds(620,10,300,200);

        //configuro el boton para volver a jugar
        volver = new JButton("Volver a jugar");
        volver.setBounds(65,80,150,50);
        add(volver);
        volver.addActionListener(this);

        //Configuro el texto
        texto = new JLabel(String.valueOf(puntuacion));
        texto.setForeground(Color.green);
        if (puntuacion == 50){
            texto.setForeground(Color.red);
            texto.setText(puntuacion + " ¡Enhorabuena, acertaste!");
        } else if (puntuacion >= 40 && puntuacion <=60){
            texto.setForeground(Color.orange);
            texto.setText(puntuacion + " Ha estado cerca, prueba otra vez");
        }
        texto.setBounds(50,25,300,50);
        add(texto);

    }



    @Override
    //Creamos la accion para volver a jugar
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == volver){
            setVisible(false);
        }

    }
}
