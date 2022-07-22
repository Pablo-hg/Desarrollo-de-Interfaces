import java.awt.*;
import static java.awt.BorderLayout.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

class EjemploBorderLayout extends JFrame implements ActionListener{
    
	JButton boton1, boton2, boton3, boton4, boton5;
	BorderLayout miBorderLayout;
    
	public EjemploBorderLayout(){
        
		//Instancia un objeto BorderLayout con una separacion de 3px en horizonal y vertical
		miBorderLayout = new BorderLayout(3,3);
        
		//Uso este BorderLayout para que sea el controlador de posicionamiento de mi objeto JFrame
		setLayout(miBorderLayout);
        
		//Creo 5 botones y los añado a mi objeto JFrame
		boton1 = new JButton("Sur");
		boton2 = new JButton("Oeste");
		boton3 = new JButton("Norte");
		boton4 = new JButton("Este");
		boton5 = new JButton("Centro");
		add(boton1, SOUTH);
		add(boton2, WEST);
		add(boton3,  NORTH);
		add(boton4, EAST);
		add(boton5, CENTER);
        
		//Añado los botones al ActionListener
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		boton4.addActionListener(this);
		boton5.addActionListener(this);

	}
    
	public static void main( String args[] ) {
        
		EjemploBorderLayout formulario = new EjemploBorderLayout();
		formulario.setSize(250,150);
		formulario.setTitle("Ejemplo de BorderLayout");
		formulario.setDefaultCloseOperation(EXIT_ON_CLOSE);
		formulario.setVisible(true);
        
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Al hacer clic en un botón, añado 5px de espacio horizontal y vertical entre botones
		miBorderLayout.setHgap(miBorderLayout.getHgap() + 5);
		miBorderLayout.setVgap(miBorderLayout.getVgap() + 5);
		//Fijo el nuevo layout al formulario
		setLayout(miBorderLayout);
		//Valido el formulario para asegurarme de que se actualiza en pantalla
		validate();
        
	}

}