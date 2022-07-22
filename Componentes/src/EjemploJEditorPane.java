import javax.swing.*;
import java.net.URL;

public class EjemploJEditorPane  extends JFrame {

    public EjemploJEditorPane(){

        URL url = getClass().getResource("/img/smile.png");

        setLayout(null); //Layout absoluto

        JEditorPane editor = new JEditorPane(); //Incilaizamos el editorPane
        editor.setContentType("text/html"); // Marcamos el editor para que use HTML

        // Insertamos un trozo de HTML
        editor.setText(
                "<b>hola</b><br>" +
                        "<i>adios</i>" +
                        "<font face='arial'>fuente arial</font><br>" +
                        "<font face='courier'>fuente courier</font><br>" +
                        "<font size='24'>fuente grande</font><br>" +
                        "<font color='red'>color rojo</font><br>" +
                        "<img src=" + url + " width=250 height=250></img>"
        );

        //Si sólo queremos mostrar texto HTML, debemos deshabilitar la edición del editor
        editor.setEditable(false);

        //Incializamos el scrollPane y le añadimos el editor
        JScrollPane scrollPane = new JScrollPane(editor);
        scrollPane.setBounds(50,50,300,300);
        add(scrollPane);

    }

    public static void main(String[] args) {

        EjemploJEditorPane formulario =new EjemploJEditorPane();
        formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formulario.setBounds(0,0,400,400);
        formulario.setTitle("Ejemplo JEditorPane");
        formulario.setVisible(true);

    }

}

