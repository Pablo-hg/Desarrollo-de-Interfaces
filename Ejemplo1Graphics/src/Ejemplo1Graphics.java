import javax.swing.*;
import java.awt.*;

import static java.awt.Font.PLAIN;

public class Ejemplo1Graphics extends JFrame {

        JPanel panel;

    public Ejemplo1Graphics(){

        initPanel();
        initPantalla();

    }

    private void initPantalla() {

        panel = new JPanel(); //Inicializo panel
        add(panel); //Lo añado al JFrame
        panel.setPreferredSize(new Dimension(800,600)); //Establezco dimensiones del panel
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Para poder modificar más propiedades
        Graphics2D g2d = (Graphics2D) g;

        //Línea
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(5));
        g2d.drawLine(30, 70, 770, 70);

        //Rectángulo (relleno y borde)
        g2d.setColor(Color.BLUE);
        g2d.fillRect(30, 100, 350, 60);//relleno
        g2d.setColor(Color.BLACK);
        g2d.drawRect(30, 100, 350, 60);//borde

        //Rectángulo redondeado
        g2d.setColor(Color.CYAN);
        g2d.drawRoundRect (420, 100, 350, 60, 10, 10);//x,y,ancho,alto,a´ngulo donde empieza y donde acaba

        //Arco
        g2d.setColor(Color.yellow);
        g2d.drawArc(30, 200, 100, 100, 180, -90);

        //Círculo
        g2d.setColor(Color.RED);
        g2d.drawOval(100, 200, 100, 100);

        //Óvalo (con relleno y borde)
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(240, 200, 150, 100);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(240, 200, 150, 100);

        //Polígono (3 lados)
        int [] triangulo_x = {450, 510, 570};
        int [] triangulo_y = {300, 200, 300};
        g2d.setColor(Color.ORANGE);
        g.drawPolygon (triangulo_x, triangulo_y, 3);//puntos alto, punto ancho y nºpuntos

        //Polígono (5 lados con relleno y borde)
        int [] pentagono_x = {670, 650, 700, 750, 730};
        int [] pentagono_y = {300, 245, 200, 245, 300};
        g2d.setColor(Color.MAGENTA);
        g2d.fillPolygon (pentagono_x, pentagono_y, 5);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon (pentagono_x, pentagono_y, 5);

        //Texto
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("ARIAL",PLAIN,32));
        g2d.drawString("Esto es un texto", 30, 400);

        //Imagen
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage ("src/img/mosca.png");
        g2d.drawImage(imagen, 30, 450, this);

        //Degradado
        GradientPaint gp = new GradientPaint(400, 350, Color.RED, 770, 350, Color.GREEN);//irá cambiando de rojo a verde dessde el 400 al 770
        g2d.setPaint(gp);//pintar
        g2d.fillRect(400, 350, 370, 200);

    }

    private void initPanel() {

        setTitle("Ejemplo Gráficos 1");
        setSize(800,600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main( String args[] ) {

        new Ejemplo1Graphics();

    }

}

