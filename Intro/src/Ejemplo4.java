/* Las componentes Swing hay que importarlas del paquete javax.swing.
 Cuando debemos importar varias componentes de un paquete es más conveniente utilizar
 el asterisco que indicar cada clase a importar.*/
import javax.swing.*;

/* La clase JFrame encapsula el concepto de una ventana,
 para implementar una aplicación que muestre una ventana debemos plantear una clase que herede de la clase JFrame */
public class Ejemplo4 extends JFrame{

    /* Definimos un objeto JLabel para la etiqueta. */
    private JLabel label1;

    /* En el constructor de la clase llamamos al método heredado de la clase JFrame llamado setLayout
     y le pasamos como parámetro un valor null, con esto estamos informándole a la clase JFrame que
      utilizaremos posicionamiento absoluto para los controles visuales dentro del JFrame*/
    public Ejemplo4() {

        setLayout(null);

        /* Creamos el objeto de la clase JLabel y le pasamos como parámetro al constructor el texto a mostrar.*/
        label1=new JLabel("Hola Mundo.");

        /* Ubicamos al objeto de la clase JLabel llamando al método setBounds,
        este requiere como parámetros la columna, fila, ancho y alto del JLabel.
         Finalmente llamamos al método add (metodo heredado de la clase JFrame)
          que tiene como objetivo añadir el control JLabel al control JFrame */
        label1.setBounds(10,20,200,30);
        add(label1);
    }

    /* En el método main creamos un objeto de la clase Formulario, llamamos al
     método setBounds para ubicar y dar tamaño al control y mediante el método setVisible hacemos visible el JFrame */
    public static void main(String[] args) {

        Ejemplo4 formulario1=new Ejemplo4();
        formulario1.setBounds(10,10,400,300);
        formulario1.setVisible(true);
    }

}