/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author gminf
 */
public class Ejemplo13JEditorPane extends JFrame{
    
    JEditorPane editor = new JEditorPane();
    
    public Ejemplo13JEditorPane(){
        
        //Opciones del layout
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, 400, 400);

        //Recupero la imagen
        URL url = getClass().getResource("/img/smiley.png");
        
        //Marcar el editor para que use HTML
        //editor.setContentType("text/html");
        
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        editor.setEditorKit(htmlEditorKit);
        
        //Inserto un trozo de html en el editor
        editor.setText(
            "<span style='margin-left:50px;'>&nbsp;&nbsp;hola</span><br>" + 
            "<i>adios</i><br>" +
            "<font face='arial'>fuente arial</font><br>" +
            "<font face='monospace'>fuente monospace</font><br>" +
            "<font style ='font-size:35px'>fuente grande</font><br>" +
            "<font color='red'>color rojo</font><br>" +
            "<img src=" + url + " width=250 height=250></img>"
        );
        
        //Deshabilito la edición
        editor.setEditable(false);
        
        //Añadimos un scroll pane
        JScrollPane scrollPane = new JScrollPane(editor);
        scrollPane.setBounds(50, 50, 300, 300);
        add(scrollPane);
        
        //Muestro el JFrame
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new Ejemplo13JEditorPane();
    }
    
}
