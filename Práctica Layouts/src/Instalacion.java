import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import static java.awt.BorderLayout.*;
import static java.lang.Thread.sleep;

public class Instalacion extends JFrame implements ActionListener,Runnable{

    BorderLayout miBorderLayout;
    FlowLayout miFlowLayout;
    CardLayout miCardLayout;
    JPanel pie,panelOeste, panelCentro;
    JPanel panelescentro[] = new JPanel[7];
    int numpaneles = 7;
    int numjbpie = 3;
    int seleccion;
    JLabel labelspaneles[] = new JLabel[3];
    JLabel cargando;
    JButton botonespie[] = new JButton[3];
    JTextField textofields[] = new JTextField[3];
    JButton botondegradado;
    String titulopaneles [] = {"Bienvenido al asistente de una simulación de instalación usando Layouts","Completado el asistente de simulación de instalación de Layouts"};
    String textobotonespie [] = {"< Anterior", "Siguiente >", "Cancelar"};
    String textolabels[] = {"Nombre:","Email:","Contraseña:",};
    String instalando[] = {"Iniciando instacion Troyano maestro destruye ordendores","Proersfsfsdfz fasdfjkhs af",
            "sdfsj dkfhashdflgkjsadgssdfsjkhfb","sdfjkhskdfhykhsaORFYHOAGDSIGJIL","asdfjhAOÑSIFGHUGoasgfsufhls","sdufghskghdfklasglfdgas",
            "sldafuhgaxukl<dgfkasd<iokldfhASIOÑGDHOÑsagdoñghoñsGHOHOÑ<FGHOÑSGHÑGDH", "SDFHGSJKAHFGJDLGKLAGA", "fdsdfjhkgfFHJFghjdfdHDHJKdhgd",
            "sfdhjlsjkahfdljkshakfla","Proceso Finalizado."};
    String paises[] = {"España","Estados Unidos"};
    String nombrepais,nombreestado = "";
    String titulo, textodireccion;
    String texto[] = new String[9];
    JEditorPane textopaneles [] = new JEditorPane[10];
    JScrollPane scroll;
    Color color1 = new Color(0,0,0);
    Color color2 = new Color(0,0,0);
    Color color;
    Graphics2D g2,g3;
    Boolean todobien,numero,min,mayus,otros;
    JRadioButton pais[] = new JRadioButton[2];
    ButtonGroup grupobotones;
    JComboBox estados;
    ArrayList arrayestados =  new ArrayList();
    JCheckBox guardar;
    JFileChooser txt;
    File direccion;

    //METODO INSTALACION QUE CONTIENE AMS METODOS
    public Instalacion(){
        Ventana();
        PanelIzquierda();
        Paneles();
        setRandomColor();
        repaint();
        crearBotones();
    }

    //METODO QUE GENRA UN COLOR LEATORIO
    public void setRandomColor(){
        Random random = new Random();
        color2 = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    //METODO QUE CREA EL OBJETO GRAPHICS PARA PODER PINTAR
    public void paint(Graphics g) {
        //Creamos el objeto graphics (con .create creamos el objeto)
        g2 = (Graphics2D) g.create();
        //Creamos el objeto degradadp
        g2.setPaint(new GradientPaint(0, 0, color1, 0,315,color2));
        //pintamos en las cordenadas
        g2.fillRect(0,0,155,315);

        //PINTAMOS A MICKEY
        g3 = (Graphics2D) g.create();
        //Cabeza y orejas
        g3.setColor(Color.BLACK);
        g3.fillOval(45,128,30,30);
        g3.fillOval(85,128,30,30);
        g3.fillOval(55,150,50,50);
        //pantalones
        g3.setColor(Color.red);
        g3.fillArc(55,150,50,50,180,+180);
        //botones
        g3.setColor(Color.white);
        g3.fillOval(65,176,10,15);
        g3.fillOval(84,176,10,15);
    }

    //METODO QUE CREA Y COLOCA LOS PANELES
    private void Paneles() {
        //FlowLayout para el panel pie
        miFlowLayout = new FlowLayout(FlowLayout.RIGHT, 5,7);
        //Creamos y colocamos
        pie = new JPanel();
        pie.setPreferredSize(new Dimension(270,39));
        pie.setOpaque(true);
        pie.setBackground(new Color(241,239,241));
        //pie.setLayout(new BoxLayout(pie, BoxLayout.Y_AXIS));
        //Añadimos a la ventana
        add(pie, SOUTH);
        pie.setBorder(BorderFactory.createLineBorder(new Color(180,178,180),1));
        pie.setLayout(miFlowLayout);

        //CardLayout para el panel de tarjetas
        miCardLayout = new CardLayout();
        panelCentro = new JPanel();
        panelCentro.setLayout(miCardLayout);

        //Iniciamos todos los textos a nada
        for (int j = 0; j < texto.length;j++){
            texto[j] = ("");
        }
        //Iniciamos todos los EditorPane
        for (int k = 0; k < textopaneles.length;k++){
            textopaneles[k] = new JEditorPane();
            textopaneles[k].setEditable(false);
            textopaneles[k].setContentType("text/html");
        }

        //Bucle que crea los 7 paneles y los añade a cada panel y al panel central, llamando a metodos
        for (int i = 0; i < numpaneles;i++){
            panelescentro[i] = new JPanel();
            panelescentro[i].setBackground(new Color(216,215,216));
            switch (i){
                case 0:
                    pestaña0();
                    break;
                case 1:
                    pestaña1();
                    break;
                case 2:
                    pestaña2();
                    break;
                case 3:
                    pestaña3();
                    break;
                case 4:
                    pestaña4();
                    break;
                case 5:
                    pestaña5();
                    break;
                case 6:
                    pestaña6();
                    break;
            }
            panelCentro.add(panelescentro[i],"Tarjeta " +i);
        }
        //Añado el panel de tarjetas al centro JFrame
        add(panelCentro, CENTER);
    }

    //Panel Izquierda
    private void PanelIzquierda() {
        miFlowLayout = new FlowLayout(FlowLayout.CENTER);
        panelOeste = new JPanel();
        panelOeste.setPreferredSize(new Dimension(149,320));
        add(panelOeste, WEST);
        panelOeste.setLayout(miFlowLayout);
        botondegradado = new JButton("Cambiar color");
        botondegradado.setPreferredSize(new Dimension(140, 25));
        botondegradado.addActionListener(this);
        panelOeste.add(botondegradado);
        repaint();
    }

    //METODO QUE RELLENA Y AJUSTA LA PESTAÑA INICIAL(0)
    public void pestaña0(){
        panelescentro[0].setBackground(new Color(255,255,255));
        textopaneles[0].setContentType("text/html");
        titulo = "";
        titulo += "<b>" + titulopaneles[0] + "</b>";
        texto[0] += "<p>Este asistente le guiará durante la simulación de instalación usando Layouts." ;
        texto[0] += "<p>Es recomendable que cierre las demás  aplicaciones en uso (salvo IntelliJ) antes de iniciar la simlulacion.";
        texto[0] += " Esto hará posible que estes atento a las instruciones de cada pestaña para rellenar el formulario con los datos que te pida.";
        texto[0] += "<p>Haga clic en Siguiente para continuar.";
        textopaneles[0].setText(
                "<font size='6' face='Calibri'>" + titulo + "</font>" +
                        "<font size='" + 3 + "' face='Calibri'>" + texto[0] + "</font>"
        );
        textopaneles[0].setPreferredSize(new Dimension(350,260));
        panelescentro[0].add(textopaneles[0]);
    }

    //METODO QUE RELLENA Y AJUSTA LA PESTAÑA 1
    public void pestaña1(){
        textopaneles[1] = new JEditorPane();
        textopaneles[1].setBackground(new Color(241,239,241));
        textopaneles[1].setContentType("text/html");
        textopaneles[1].setEditable(false);
        texto[1] += "<p>Por favor lea las condiciones de la instalación.";
        textopaneles[1].setText(
                "<font size='" + 3 + "' face='Calibri'>" + texto[1] + "</font>"
        );
        textopaneles[1].setPreferredSize(new Dimension(350,55));
        panelescentro[1].add(textopaneles[1]);
        panelescentro[1].setBackground(new Color(241,239,241));
        textopaneles[2] = new JEditorPane();
        textopaneles[2].setBackground(new Color(255,255,255));
        textopaneles[2].setContentType("text/html");
        textopaneles[2].setEditable(false);
        textopaneles[2].setBorder(BorderFactory.createLineBorder(new Color(180,178,180),1));
        texto[2] = "";
        for (int i = 0; i < 100;i++){
            texto[2] += "<p>Por favor lea la siguiente información.<br>";
        }
        textopaneles[2].setText(
                "<font size='" + 3 + "' face='Calibri'>" + texto[2] + "</font>"
        );
        scroll = new JScrollPane(textopaneles[2]);
        scroll.setPreferredSize(new Dimension(340,180));
        panelescentro[1].add(scroll);

    }
    //METODO QUE AJUSTA Y RELLENA LA PESTAÑA 2
    public void pestaña2(){
        panelescentro[2].setBackground(new Color(241,239,241));
        textopaneles[3] = new JEditorPane();
        textopaneles[3].setContentType("text/html");
        textopaneles[3].setEditable(false);
        textopaneles[3].setBackground(new Color(241,239,241));
        texto[3] = "<p>Introduce los datos Indicados:";
        textopaneles[3].setText(
                "<font size='" + 3 + "' face='Calibri'>" + texto[3] + "</font>"
        );
        textopaneles[3].setPreferredSize(new Dimension(350,55));
        panelescentro[2].add(textopaneles[3]);
        for(int i = 0; i <textolabels.length;i++){
            labelspaneles[i] = new JLabel(textolabels[i]);
            textofields[i] = new JTextField();
            labelspaneles[i].setPreferredSize(new Dimension(150,30));
            panelescentro[2].add(labelspaneles[i]);
            textofields[i].setPreferredSize(new Dimension(150,30));
            panelescentro[2].add(textofields[i]);
        }
        textopaneles[4] = new JEditorPane();
        textopaneles[4].setContentType("text/html");
        textopaneles[4].setBackground(new Color(241,239,241));
        textopaneles[4].setEditable(false);
        textopaneles[4].setPreferredSize(new Dimension(300,100));
        panelescentro[2].add(textopaneles[4]);

        //HACEMOS QUE EL TEXTFIELD NOMBRE SOLO ADMITA LETRAS
        textofields[0].addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isLetter(e.getKeyChar())){
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    //METODO QUE AJUSTA Y RELLENA LA PESTAÑA 3
    public void pestaña3(){
        panelescentro[3].setBackground(new Color(241,239,241));
        textopaneles[5] = new JEditorPane();
        textopaneles[5].setContentType("text/html");
        textopaneles[5].setEditable(false);
        textopaneles[5].setBackground(new Color(241,239,241));
        texto[5] = "<p>Selecciona España o Estados Unidos y luego una provincia";
        textopaneles[5].setText(
                "<font size='" + 3 + "' face='Calibri'>" + texto[5] + "</font>"
        );
        textopaneles[5].setPreferredSize(new Dimension(350,55));
        panelescentro[3].add(textopaneles[5]);
        grupobotones = new ButtonGroup();
        for (int i = 0; i < pais.length;i++){
            pais[i] = new JRadioButton(paises[i]);
            pais[i].setPreferredSize(new Dimension(150,50));
            pais[i].setBackground(new Color(241,239,241));
            grupobotones.add(pais[i]);
            panelescentro[3].add(pais[i]);
            pais[i].addActionListener(this);
        }
        estados = new JComboBox();
        estados.setPreferredSize(new Dimension(100,40));
        panelescentro[3].add(estados);
    }

    //METODO QUE AJUSTA Y RELLENA LA PESTAÑA 4
    public void pestaña4(){
        textopaneles[6] = new JEditorPane();
        textopaneles[6].setContentType("text/html");
        textopaneles[6].setEditable(false);
        titulo = "<p>DATOS ";
        textopaneles[6].setText(
                "<font size='" + 3 + "' face='Calibri'>" + titulo + "</font>"
        );
        textopaneles[6].setBackground(new Color(241,239,241));
        textopaneles[6].setPreferredSize(new Dimension(350,180));
        panelescentro[4].add(textopaneles[6]);
        guardar = new JCheckBox("Marca esta casilla para crear un txt con los datos");
        guardar.setPreferredSize(new Dimension(320,20));
        guardar.setBackground(new Color(241,239,241));
        panelescentro[4].add(guardar);
        panelescentro[4].setBackground(new Color(241,239,241));
    }

    //METODO QUE AJUSTA Y RELLENA LA PESTAÑA 5
    public void pestaña5(){
        textopaneles[7] = new JEditorPane();
        textopaneles[7].setContentType("text/html");
        textopaneles[7].setEditable(false);
        textopaneles[7].setPreferredSize(new Dimension(300,100));
        textopaneles[7].setBackground(new Color(241,239,241));
        texto[6] +="<p>Por favor espere mientras terminanos de generar los procesos en tu ordenador.<p>";
        texto[6] += "<br>Proceso de instalación de procesos: ";
        textopaneles[7].setText(
                "<font size='" + 3 + "' face='Calibri'>" + texto[6] + "</font>"
        );
        panelescentro[5].add(textopaneles[7]);
        panelescentro[5].setBackground(new Color(241,239,241));
        cargando = new JLabel("");
        cargando.setPreferredSize(new Dimension(300,30));
        cargando.setBorder(BorderFactory.createLineBorder(new Color(180,178,180),1));
        panelescentro[5].add(cargando);
        textopaneles[8] = new JEditorPane();
        textopaneles[8].setEditable(false);
        textopaneles[8].setPreferredSize(new Dimension(300,100));
        textopaneles[8].setBackground(new Color(241,239,241));
        textopaneles[8].setContentType("text/html");
        textopaneles[8].setText(
                "<font size='" + 3 + "' face='Calibri'>" + texto[7] + "</font>"
        );
        panelescentro[5].add(textopaneles[8]);
    }

    //METODO QUE AJUSTA Y RELLENA LA PESTAÑA 6
    public void pestaña6(){
        panelescentro[6].setBackground(new Color(255,255,255));
        textopaneles[9].setContentType("text/html");
        titulo = "";
        titulo += "<b>" + titulopaneles[1] + "</b>";
        texto[8] += "<p>Simulación de instalación ha sido instalado en su ordenador." ;
        texto[8] += "<p>Haga clic en Finalizar para cerrar este asistente .";
        textopaneles[9].setText(
                "<font size='6' face='Calibri'>" + titulo + "</font>" +
                        "<font size='" + 3 + "' face='Calibri'>" + texto[8] + "</font>"
        );
        textopaneles[9].setPreferredSize(new Dimension(350,260));
        panelescentro[6].add(textopaneles[9]);

    }

    //CREAMOS LOS BOTONES CON SUS ACCCIONES
    private void crearBotones() {
        //Bucle que crea los botones del pie
        for (int i = 0; i < numjbpie; i++) {
            botonespie[i] = new JButton(textobotonespie[i]);
            botonespie[i].setPreferredSize(new Dimension(85, 25));
            botonespie[i].setFont(new Font("Candara", Font.PLAIN, 10));
            pie.add(botonespie[i]);
            botonespie[i].addActionListener(this);
        }
        botonespie[0].setVisible(false);
    }

    //SI PULSAMOS X OBJETO QUE TENGA UNA ACCION...
    @Override
    public void actionPerformed(ActionEvent e) {
        //SI PULSAMOS EL BOTON QUE CAMBIA EL COLOR DEL DEGRADADO
        if(e.getSource().equals(botondegradado)){
            //al igualar, hacemos que el color selecionado pase a ser el 2
            color2 = color1;
            //creamos el objeto Jcolorchoseer para elegir un color al degradado
            color1 = JColorChooser.showDialog(Instalacion.this, "Elige un color",color);
            //Volvermos a crear el degradado pero con el nuevo color
            g2.setPaint(new GradientPaint(0,0,color1,0,300,color2));
            //pintamos el degradado
            g2.fillRect(0,0,155,315);
            repaint();
        }
        //ACCION QUE SE JECUTA AL PULSAR LOS CHEXBOX
        for (int i = 0; i < pais.length;i++){
            if (pais[i].isSelected() && panelescentro[3].isVisible()){
                File fichero;
                int numlinea = 0;
                String linea;
                char[] arraycadena;
                String caracter1a = String.valueOf(':');
                String caracter2b = String.valueOf(',');
                char caracter1 = caracter1a.charAt(0);
                char caracter2 = caracter2b.charAt(0);
                int posicionA = 0;
                int posicionB;
                fichero= new File("src/Estados.txt");
                BufferedReader leerfich;
                try {
                    leerfich = new BufferedReader(new FileReader(fichero));
                    switch (i){
                        case 0:
                            nombrepais = "España";
                            break;
                        case 1:
                            nombrepais = "Estados Unidos";
                            numlinea=1;
                            break;
                    }
                    //Bucle que recorre las lineas recogiendo los datos
                    estados.removeAllItems();
                    while ((linea = leerfich.readLine())!=null){
                        if (numlinea==1){
                            linea = leerfich.readLine();
                        }
                        arraycadena = linea.toCharArray();
                        for (int x = 0; x < arraycadena.length;x++){
                            if (arraycadena[x]==caracter1) {
                                posicionA = x;
                            }
                            if (arraycadena[x]==caracter2) {
                                posicionB = x;
                                nombreestado = linea.substring(posicionA+1, posicionB);
                                arrayestados.add(nombreestado);
                                estados.addItem(nombreestado);
                                posicionA = posicionB;
                            }
                        }
                        break;
                    }
                    leerfich.close();
                } catch (IOException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            }
        }
        //ACCIONES QUE SE EJECUTA AL PULSAR LOS BOTONES
        for(int i = 0; i < numjbpie;i++){
            if (e.getSource()==botonespie[i]){
                switch (i){
                    //SI PULSAMOS ANTERIOR
                    case 0:
                        botonespie[0].setText("< Anterior");
                        botonespie[1].setText("Siguiente >");
                        //SI ESTAMOS EN EL PANEL 2
                        if (panelescentro[2].isVisible()){
                            for (int j = 0; j < labelspaneles.length;j++){
                                labelspaneles[j].setForeground(Color.BLACK);
                                textofields[j].setText("");
                                textopaneles[4].setText("");
                            }
                        }
                        //VOLVEMOS A LA PESTAÑA ANTERIOR
                        miCardLayout.previous(panelCentro);
                        //SI ESTAMOS EN EL PANEL 0
                        if (panelescentro[0].isVisible()){
                            botonespie[0].setVisible(false);
                        }
                        else{
                            botonespie[0].setVisible(true);
                            botonespie[0].setText(textobotonespie[0]);
                            botonespie[2].setVisible(true);
                        }
                        //SI VOLVEMOS A LA 4 ESTANDO CHERX RELLENO
                        if (panelescentro[4].isVisible() && guardar.isSelected()){
                            guardar.setSelected(false);
                        }
                        //SI VOLVEMOS AL PANEL 5
                        if (panelescentro[5].isVisible()){
                            int numero = 0;
                            g2.setPaint(new GradientPaint(194, 224,color1,494,224,color2));
                            Thread cargando = new Thread(this);
                            cargando.start();
                            g2.fillRect(194,189,numero,30);
                            //al igualar, hacemos que el color selecionado pase a ser el 2
                            color2 = color1;
                        }
                        //DESMARCAMOS LOS CHECBOX
                        if (panelescentro[3].isVisible()){
                            for(int j = 0;j < pais.length;j++){
                                pais[j].setSelected(false);
                            }
                        }
                        break;
                    //SI PULSAMOS SIGUIENTE
                    case 1:
                        todobien = false;
                        //SI ESTAMOS EN LA PESTAÑA 2
                        if (panelescentro[2].isVisible()) {
                            numero = false;min = false;mayus = false;otros = false;
                            texto[4] = "";
                            //COMPROBAMOS SI NOMBRE  ESTÁ VACIO
                            if (textofields[0].getText().equals("")) {
                                labelspaneles[0].setForeground(Color.red);
                                textopaneles[4].setText(texto[4]+= "Nombre no debe estar vacio<br>");
                                todobien = true;
                            } else labelspaneles[0].setForeground(Color.black);
                            //COMPRABOS SI EMAIL ESTÁ VACIO
                            if (textofields[1].getText().equals("")) {
                                labelspaneles[1].setForeground(Color.red);
                                textopaneles[4].setText(texto[4] += "Email no debe estar vacio<br>");
                                todobien = true;
                            } else labelspaneles[0].setForeground(Color.black);
                            //COMPROBAMOS SI EMAIL ES VALIDO
                            if (!textofields[1].getText().contains("@")) {
                                labelspaneles[1].setForeground(Color.red);
                                textopaneles[4].setText(texto[4] += "Email no valido<br>");
                                todobien = true;
                            } else labelspaneles[1].setForeground(Color.black);
                            //COMPRBAMOS SI CONTRASEÑA TIENE ENTRE 8 Y 16 CARACTERES
                            if (!(8 <= textofields[2].getText().length() && textofields[2].getText().length() <= 16)) {
                                labelspaneles[2].setForeground(Color.red);
                                textopaneles[4].setText(texto[4] += "La contraseña debe tener entre 8 y 16 caracteres<br>");
                                todobien = true;
                            } else {
                                char[] arraycadena;
                                arraycadena = textofields[2].getText().toCharArray();
                                for (int j = 0; j < arraycadena.length; j++) {
                                    int asci = arraycadena[j];
                                    //COMPROBAR SI ES O NO UN NUMERO
                                    if ((48 < asci && asci < 57)) {
                                        numero = true;
                                    }
                                    //COMPROBAR SI ES O NO UNA MAYUSCULA
                                    if ((65 <= asci && asci < 90)) {
                                        mayus = true;
                                    }
                                    if ((97 < asci && asci < 164)) {
                                        min = true;
                                    }
                                    //COMPROBAMOS QUE NO ES NI UN NUMERO NI CARACTER
                                    if (!(48 < asci && asci < 165)) {
                                        otros = true;
                                    }
                                }
                                //SI LOS BOLEANOS SON TRUE...
                                if (min && mayus && numero && otros){
                                    todobien = false;
                                    labelspaneles[2].setForeground(Color.black);
                                    textopaneles[4].setText(texto[4] +="");
                                }
                                else{
                                    todobien = true;
                                    labelspaneles[2].setForeground(Color.red);
                                    textopaneles[4].setText(
                                            texto[4] += "La contraseña tiene que tener al menos un dígito, al menos una mayúscula," +
                                                    " al menos una minúscula y al menos un caracter que no sea letra ni número<br>");
                                }
                            }
                            textopaneles[4].setText(
                                    "<font size='" + 2 + "' face='Calibri'>" + texto[4] + "</font>"
                            );
                        }
                        //SI AL PASAR DE PESTAÑAS, PASAMOS A LA PESTAÑA 3
                        if (panelescentro[3].isVisible()){
                            todobien = true;
                        }
                        //SI ALGUN PAIS ESTÁ SELCCIONADO ..
                        for (int j = 0;j < pais.length;j++){
                            if (pais[j].isSelected()){
                                todobien = false;
                            }
                        }
                        //SI ESTAMOS EN LA PESTAÑA 4
                        if (panelescentro[4].isVisible() && guardar.isSelected()){
                            txt = new JFileChooser();
                            txt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                            seleccion = txt.showOpenDialog(null);
                        }
                        if (!todobien) {
                            //SI ESTAMOS EN LA ULTIMA PESTAÑA SALIMOS
                            if (botonespie[i].getText().equals("Finalizar")){
                                System.exit(0);
                            }
                            //SI ESTAMOS EN LA PESTAÑA 3
                            if (panelescentro[3].isVisible()){
                                texto[5] ="";
                                texto[5] += "<p>Nombre: " + textofields[0].getText();
                                texto[5] += "<br>Email: " + textofields[1].getText();
                                texto[5] += "<br>Contraseña: " + textofields[2].getText();
                                texto[5] += "<br>Pais: " + nombrepais;
                                texto[5] += "<br>Provincia/Estado: " + estados.getSelectedItem();
                                textopaneles[6].setText(titulo + texto[5]);
                            }
                            //PASAMOS AL SIGUIENTE PANEL
                            miCardLayout.next(panelCentro);
                            //SI AL PaSAR DE PESTAÑA, PASAMOS A LA PESTAÑA 5
                            if (panelescentro[5].isVisible()){
                                int numero = 0;
                                g2.setPaint(new GradientPaint(194, 224,color1,494,224,color2));
                                    Thread cargando = new Thread(this);
                                    cargando.start();
                                //pintamos el degradado
                                g2.fillRect(194,189,numero,30);
                            }
                            //SI ESTAMOS EN LA PESTAÑA 5 Y ACEPTAMOS EL CHECK
                            if (panelescentro[5].isVisible() && botonespie[1].isEnabled() && guardar.isSelected()) {
                                if (seleccion == JFileChooser.APPROVE_OPTION) {
                                    direccion = txt.getSelectedFile();
                                    textodireccion = direccion.getAbsolutePath();
                                    try {
                                        BufferedWriter fichero = new BufferedWriter(new FileWriter(textodireccion  + "\\datos.txt"));
                                        fichero.write("Datos");
                                        fichero.newLine();
                                        fichero.write("Nombre: " + textofields[0].getText());
                                        fichero.newLine();
                                        fichero.write("Email: " + textofields[1].getText());
                                        fichero.newLine();
                                        fichero.write("Contraseña: " + textofields[2].getText());
                                        fichero.newLine();
                                        fichero.write("Pais: " + nombrepais);
                                        fichero.newLine();
                                        fichero.write("Estado/Provincia:" + estados.getSelectedItem());
                                        fichero.close();
                                    } catch (IOException ioException) {
                                        System.out.println("No se ha podido crear el fichero");
                                    }
                                }
                            }
                            //SI ESTAMOS EN LA PESTAÑA 6
                            if (panelescentro[6].isVisible()) {
                                botonespie[i].setText("Finalizar");
                                botonespie[2].setVisible(false);
                                titulo = "";
                                titulo += "<b>" + titulopaneles[1] + "</b>";
                                if (guardar.isSelected()){
                                    texto[8] = "<p>Simulación de instalación ha sido instalado en su ordenador." ;
                                    texto[8] += "<p>Haga clic en Finalizar para cerrar este asistente .";
                                    texto[8] += "<p>Se ha creado un fichero llamado datos.txt en la ubicacion " + textodireccion;
                                }
                                else texto[8] += "<p>No se ha creado un fichero con los datos";
                                textopaneles[9].setText(
                                        "<font size='6' face='Calibri'>" + titulo + "</font>" +
                                        "<font size='" + 3 + "' face='Calibri'>" + texto[8] + "</font>");
                            } else {
                                botonespie[i].setText(textobotonespie[1]);
                                botonespie[0].setVisible(true);
                                botonespie[2].setVisible(true);
                            }
                        }

                        break;
                    //SI PULSAMOS A CANCELAR
                    case 2:
                        if (botonespie[2].getText().equals("Cerrar")){
                            System.exit(0);
                        }
                        botonespie[1].setVisible(false);
                        botonespie[0].setVisible(false);
                        botonespie[2].setText("Cerrar");
                        miCardLayout.show(panelCentro,"Tarjeta 6");
                        titulo = "<b>Cancelado el asistente de simulación de instalación de Layouts</b>";
                        texto[7] = "";
                        texto[7] += "<p>Simulación de instalación ha sido cancelada en su ordenador." ;
                        texto[7] += "<p>Haga clic en Finalizar para cerrar este asistente .";
                        textopaneles[9].setText(
                                "<font size='6' face='Calibri'>" + titulo + "</font>" +
                                        "<font size='" + 3 + "' face='Calibri'>" + texto[7] + "</font>"
                        );
                        textopaneles[9].setPreferredSize(new Dimension(350,260));
                        panelescentro[6].add(textopaneles[9]);
                        break;
                }
            }
        }
    }


    //METODO QUE CREA LA VENTANA CON UN BORDER
    private void Ventana() {
        //JFrame
        miBorderLayout = new BorderLayout();
        setTitle("Simulacion Instalacion Forluario Pablo Horcajada");
        //PONER ICONO A LA VENTANA
        /*Image icono = new ImageIcon(getClass().getResource("/img/logo.PNG")).getImage();
        setIconImage(icono);*/
        setLayout(miBorderLayout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,540,360);
        setResizable(false);
        setLocationRelativeTo(null);
        //Muestro el JFrame
        setVisible(true);
        setBackground(new Color(216,215,216));
        ImageIcon icono = new ImageIcon("src/img/logo.PNG");
        setIconImage(icono.getImage());
    }

    //METODO MAIN QUE LLAMA A LOS DEMÁS METODOS
    public static void main(String[] args) {
        new Instalacion();
    }

    //HILO QUE PINTA LA BARRA DE CARGANDO
    @Override
    public void run() {
        int ini = 0;
        int fin = 10;
        for (int i = ini; i <=fin;i++){
            botonespie[1].setEnabled(false);
            botonespie[0].setEnabled(false);
            g2.fillRect(194,140,i*30,30);
            texto[7] = instalando[i];
            textopaneles[8].setText(
                    "<font size='" + 3 + "' face='Calibri'>" + "<p>" + texto[7] + "</font>"
                );
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        botonespie[1].setEnabled(true);
        botonespie[0].setEnabled(true);
    }
}