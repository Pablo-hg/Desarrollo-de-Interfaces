import javax.swing.*;
import java.awt.*;

public class Ejercicio1Graphics extends JFrame {
    
    JPanel panel;

    public Ejercicio1Graphics(){

        initPanel();
        initPantalla();

    }

    private void initPantalla() {

        panel = new JPanel();
        add(panel);
        panel.setPreferredSize(new Dimension(400,300));

    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        Graphics2D psoe = (Graphics2D) g;//
        psoe.setStroke(new BasicStroke(5));

        Graphics2D pp =  (Graphics2D) g;
        pp.setStroke(new BasicStroke(5));

        Graphics2D podemos =  (Graphics2D) g;
        podemos.setStroke(new BasicStroke(5));

        Graphics2D vox =  (Graphics2D) g;
        vox.setStroke(new BasicStroke(5));

        Graphics2D Cs =  (Graphics2D) g;
        Cs.setStroke(new BasicStroke(5));

        Graphics2D otros =  (Graphics2D) g;
        otros.setStroke(new BasicStroke(5));


        psoe.setColor(Color.red);
        psoe.drawArc(250, 150, 300, 300, 0, 110);
        psoe.fillArc(250, 150, 300, 300, 0, 110);



        pp.setColor(Color.BLUE);  
        pp.drawArc(250, 150, 300, 300, 110, 84);
        pp.fillArc(250, 150, 300, 300, 110, 84);


        
        podemos.setColor(Color.magenta);
        podemos.drawArc(250, 150, 300, 300, 184, 50);
        podemos.fillArc(250, 150, 300, 300, 184, 50);



        vox.setColor(Color.green);
        vox.drawArc(250, 150, 300, 300, 234, 64);
        vox.fillArc(250, 150, 300, 300, 234, 64);



        Cs.setColor(Color.orange);
        Cs.drawArc(250, 150, 300, 300, 298, 20);
        Cs.fillArc(250, 150, 300, 300, 298, 20);


        otros.setColor(Color.gray);
        otros.drawArc(250, 150, 300, 300, 318, 41);
        otros.fillArc(250, 150, 300, 300, 318, 42);


    }



    private void initPanel() {

        setTitle("Ejercicio 1 Graphcis");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main( String args[] ) {

        new Ejercicio1Graphics();

    }
}
